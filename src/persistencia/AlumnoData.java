
package persistencia;

import modelo.Alumno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

// Mientras que Alumno representa el dato/objeto; 
// AlumnoData es el encargado de hacer las operaciones con el SGBD MariaDB.

public class AlumnoData {
    
    private Connection connection;  // Referencia que apunta a la conexión obtenida mediante patrón SINGLETON.

    public AlumnoData() {
        
        connection = Conexion.getInstancia().getConnection();
    }
    
         
    // MÉTODOS ABMC //   
        
    /*   
    Cuando el usuario toca Guardar, la Vista obtiene los datos de los campos y crea un objeto Alumno:
    Alumno alumno = new Alumno(dni, nombre, apellido, fecha, true);
    Después crea AlumnoData y le entrega el objeto:
    AlumnoData alumnoData = new AlumnoData();
    alumnoData.guardarAlumno(alumno);  
    */
    
    // Alta de Alumno. (INSERT) 
    // Crear un registro nuevo.
    
    public void guardarAlumno(Alumno alumno) {
        
        // Recibir un objeto Alumno y convertir sus datos en una operación SQL:
        String sql = "INSERT INTO alumno (dni, nombre, apellido, fecNac, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            
            // ps quedó preparado con un INSERT:
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(5, alumno.isEstado());
            
            // executeUpdate ordena a la BD que se ejecute el INSERT previamente cargado en la variable sql.
            ps.executeUpdate();  
            ps.close();
            
            System.out.println("Alumno guardado correctamente.");
            
        } catch (SQLException e) {
            
            System.out.println("Error al guardar alumno: " + e.getMessage());
        }
    }

    
    // Baja de Alumno. (UPDATE) 
    // Recibe un idAlumno y elimina el registro correspondiente de la tabla.  
    
    public void borrarAlumno(int idAlumno) {
        
        String sql = "DELETE FROM alumno WHERE idAlumno = ?";

        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idAlumno);

            ps.executeUpdate();
            ps.close();

            System.out.println("Alumno borrado correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al borrar alumno: " + e.getMessage());
        }
    }
    
      
    // Modificación de Alumno. (UPDATE)
    
    public void actualizarAlumno(Alumno alumno) {
        
        String sql = "UPDATE alumno SET dni = ?, nombre = ?, apellido = ?, fecNac = ?, estado = ? WHERE idAlumno = ?";

        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());

            ps.executeUpdate();
            ps.close();

            System.out.println("Alumno actualizado correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar alumno: " + e.getMessage());
        }
    }

        
    // ESTADO ACTIVO-INACTIVO //
    
    // Método que reactiva un registro existente con estado inactivo: pasar de estado false a true. (UPDATE)
    
    public void bajaEstado(int idAlumno) {
        
        String sql = "UPDATE alumno SET estado = true WHERE idAlumno = ?";

        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            ps.executeUpdate();
            ps.close();
            
            System.out.println("Alumno dado de alta correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al dar de alta al alumno: " + e.getMessage());
        }
    }
    
    // Método que desactiva un registro existente con estado activo: pasar de estado true a false. (UPDATE)
    
    public void altaEstado(int idAlumno) {
        
        String sql = "UPDATE alumno SET estado = false WHERE idAlumno = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            ps.executeUpdate();
            ps.close();
            
            System.out.println("Alumno dado de baja correctamente.");

        } catch (SQLException e) {
            
            System.out.println("Error al dar de baja al alumno: " + e.getMessage());
        }
    }
    
        
    // CONSULTAS //
    
    
    // Buscar UN alumno según el id. (SELECT)
    
    public Alumno buscarAlumno(int idAlumno) {
        
        // Creo y almaceno consulta.
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";

        try {
            
            // Preparo consulta SQL para poder ejecutarla.
            PreparedStatement ps = connection.prepareStatement(sql);
            
            // Le doy valor al primer y único '?'.
            ps.setInt(1, idAlumno);

            // Ejecución real de la consulta.
            ResultSet rs = ps.executeQuery();

            // ResultSet puede contener cero, una o varias filas. En este caso: o 0 o 1.
            if (rs.next()) {
  
                // Creo un objeto Alumno usando los datos recuperados de la BD.
                Alumno alumno = new Alumno(
                        rs.getInt("idAlumno"), rs.getString("dni"), rs.getString("nombre"), 
                        rs.getString("apellido"), rs.getDate("fecNac").toLocalDate(), rs.getBoolean("estado"));

                rs.close();
                ps.close();

                return alumno;
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }

        return null;
    }
    
    
    
    // Listar TODOS los alumnos. (SELECT)
    
    public ArrayList<Alumno> listarAlumnos() {
        
        ArrayList<Alumno> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM alumno";

        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // ResultSet con probabilidad de muchas filas en este caso.
            while (rs.next()) {
                
                Alumno alumno = new Alumno(
                        rs.getInt("idAlumno"), rs.getString("dni"), rs.getString("nombre"), 
                        rs.getString("apellido"), rs.getDate("fecNac").toLocalDate(), rs.getBoolean("estado"));

                lista.add(alumno);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }

        return lista;
    }

    //  Método para listar alumnos por materia no lo pongo acá porque es una consulta propia de la relación en sí (Cursada). 
    // Lo mismo para el método de listar materias de un alumno.
    
}
