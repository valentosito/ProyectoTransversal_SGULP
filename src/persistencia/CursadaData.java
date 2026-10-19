
package persistencia;

import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;
//import org.mariadb.jdbc.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursadaData {

    private Connection connection;
    private int ultimoError;

    // casteo de conection. Aca conectamos con MariaDB
    public CursadaData() {
        connection = (Connection) Conexion.getInstancia().getConnection();
    }

    // damos el alta a la cursada 
    // importo la clase cursada
    public boolean guardarCursada(Cursada cursada) {   //recibe un objeto cursada y lo transforma en un INSERT//

        String sql = "INSERT INTO cursada"
                + "(idAlumno, idMateria, anio, cuatrimestre, condicion, "
                + "recursante, notaFinal, asistencia) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        ultimoError = 0;

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cursada.getAlumno().getIdAlumno());
            ps.setInt(2, cursada.getMateria().getIdMateria());
            ps.setInt(3, cursada.getAnio());
            ps.setInt(4, cursada.getCuatrimestre());
            ps.setInt(5, cursada.getCondicion());
            ps.setBoolean(6, cursada.isRecursante());

            //ps.setDouble(7, cursada.getNotaFinal()); reemplazo
            // Una cursada nueva todavía puede no tener nota:
            if (cursada.getNotaFinal() != null) {
                ps.setDouble(7, cursada.getNotaFinal());
            } else {
                ps.setNull(7, java.sql.Types.DECIMAL);
            }

            ps.setInt(8, cursada.getPorcAsistencia());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            ultimoError = e.getErrorCode();

            System.out.println(
                    "Error al guardar cursada: " + e.getMessage()
            );

            return false;
        }

    }

    public int getUltimoError() {
        return ultimoError;
    }

    // borrar la cursada (recibe solo id q se genero antes y lo elimina a traves de delete)
    
    // Agrego modificación para que el método no permita eliminar una cursada si ya tiene una nota final registrada,
    // y para que deje inactivo al estado de Alumno en caso de que no exista otra cursada asociada.
    public boolean borrarCursada(int idCursada) {

        // Buscar Cursada asociada a Alumno
        Cursada cursada = buscarCursada(idCursada);

        if (cursada == null) {
            
            System.out.println("No existe la cursada indicada.");
            return false;
        }

        // Restricción: la base de datos solo elimina la cursada cuando no tiene una nota final registrada.
        if (cursada.getNotaFinal() != null) {
            
            System.out.println("No se puede eliminar una cursada con nota final.");
            return false;
        }

        // Caso en donde sí hay una Cursada sin nota final asociada a un Alumno:
        int idAlumno = cursada.getAlumno().getIdAlumno();

        String sql = "DELETE FROM cursada WHERE idCursada = ? AND notaFinal IS NULL";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCursada);

            int filasAfectadas = ps.executeUpdate();
            ps.close();

            if (filasAfectadas == 0) {
                return false;
            }

            // Comprobar si el alumno conserva otras cursadas
            ArrayList<Cursada> cursadasRestantes = listarCursadasPorAlumno(idAlumno);

            if (cursadasRestantes.isEmpty()) {
                
                AlumnoData alumnoData = new AlumnoData();
                alumnoData.bajaEstado(idAlumno);
            }
            
            return true;  

        } catch (SQLException e) {
            System.out.println("Error al borrar cursada: " + e.getMessage());
            return false;
        }
    }

    // modificar la cursada la actualiza (recibe todos los datos y si hay cambios los actualiza)
    public void actualizarCursada(Cursada cursada) {

        String sql = "UPDATE cursada SET "
                + "idAlumno = ?, "
                + "idMateria = ?, "
                + "anio = ?, "
                + "cuatrimestre = ?, "
                + "condicion = ?, "
                + "recursante = ?, "
                + "notaFinal = ?, "
                + "asistencia = ? "
                + "WHERE idCursada = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cursada.getAlumno().getIdAlumno());
            ps.setInt(2, cursada.getMateria().getIdMateria());
            ps.setInt(3, cursada.getAnio());
            ps.setInt(4, cursada.getCuatrimestre());
            ps.setInt(5, cursada.getCondicion());
            ps.setBoolean(6, cursada.isRecursante());

            if (cursada.getNotaFinal() != null) {
                ps.setDouble(7, cursada.getNotaFinal());
            } else {
                ps.setNull(7, java.sql.Types.DECIMAL);
            }

            ps.setInt(8, cursada.getPorcAsistencia());
            ps.setInt(9, cursada.getIdCursada());

            int filas = ps.executeUpdate();

            ps.close();

            if (filas > 0) {
                System.out.println("Cursada actualizada correctamente.");
            } else {
                System.out.println("No se encontró la cursada o no se realizaron cambios.");
            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar cursada: " + e.getMessage());
        }
    }
    
    
    // Método que actualiza únicamente el porcentaje de asistencia de una cursada.
    public void actualizarPorcentajeAsistencia(int idCursada, int porcentaje) {

        String sql = "UPDATE cursada SET asistencia = ? WHERE idCursada = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, porcentaje);
            ps.setInt(2, idCursada);

            int filas = ps.executeUpdate();
            ps.close();

            if (filas == 0) {
                System.out.println("No se encontró la cursada.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el porcentaje de asistencia: "
                    + e.getMessage());
        }
    }

    

    // buscar la cursada por id. (aca el objeto llama al id ) 
    public Cursada buscarCursada(int idCursada) {

        String sql = "SELECT * FROM cursada WHERE idCursada = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idCursada);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int idAlumno = rs.getInt("idAlumno");
                int idMateria = rs.getInt("idMateria");

                // Buscamos los objetos relacionados
                AlumnoData alumnoData = new AlumnoData();
                MateriaData materiaData = new MateriaData();

                Alumno alumno = alumnoData.buscarAlumno(idAlumno);
                Materia materia = materiaData.buscarMateria(idMateria);

                // Agrego:
                Double notaFinal = rs.getObject("notaFinal", Double.class);

                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        //rs.getDouble("notaFinal"),
                        notaFinal,
                        rs.getBoolean("recursante"),
                        rs.getInt("asistencia"),
                        alumno,
                        materia
                );

                rs.close();
                ps.close();

                return cursada;
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            System.out.println("Error al buscar cursada: " + e.getMessage());
        }

        return null;
    }

    
    // Método que busca una cursada por alumno, materia, año y cuatrimestre para recuperar los datos en el botón de Desinscribir.
    public Cursada buscarCursada(int idAlumno, int idMateria,
            int anio, int cuatrimestre) {

        String sql = "SELECT idCursada FROM cursada "
                + "WHERE idAlumno = ? AND idMateria = ? "
                + "AND anio = ? AND cuatrimestre = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ps.setInt(3, anio);
            ps.setInt(4, cuatrimestre);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return buscarCursada(rs.getInt("idCursada"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cursada: " + e.getMessage());
        }

        return null;
    }
    
    
    // hacer el listado de las cursadas 
    public ArrayList<Cursada> listarCursadas() {

        ArrayList<Cursada> lista = new ArrayList<>();

        String sql = "SELECT * FROM cursada";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int idAlumno = rs.getInt("idAlumno");
                int idMateria = rs.getInt("idMateria");

                AlumnoData alumnoData = new AlumnoData();
                MateriaData materiaData = new MateriaData();

                Alumno alumno = alumnoData.buscarAlumno(idAlumno);
                Materia materia = materiaData.buscarMateria(idMateria);

                Double notaFinal = rs.getObject("notaFinal", Double.class);

                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        notaFinal,
                        rs.getBoolean("recursante"),
                        rs.getInt("asistencia"),
                        alumno,
                        materia
                );
                lista.add(cursada);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            System.out.println("Error al listar cursadas: " + e.getMessage());
        }

        return lista;     // se puede cargar en una tabla
    }

    // listado de los cursos del alumno 
    public ArrayList<Cursada> listarCursadasPorAlumno(int idAlumno) {

        ArrayList<Cursada> lista = new ArrayList<>();

        String sql = "SELECT * FROM cursada WHERE idAlumno = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            AlumnoData alumnoData = new AlumnoData();
            MateriaData materiaData = new MateriaData();

            Alumno alumno = alumnoData.buscarAlumno(idAlumno);

            while (rs.next()) {

                int idMateria = rs.getInt("idMateria");

                Materia materia = materiaData.buscarMateria(idMateria);

                Double notaFinal = rs.getObject("notaFinal", Double.class);

                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        notaFinal,
                        rs.getBoolean("recursante"),
                        rs.getInt("asistencia"),
                        alumno,
                        materia
                );
                lista.add(cursada);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            System.out.println("Error al listar cursadas del alumno: "
                    + e.getMessage());
        }

        return lista;
    }

    // cursadas de una materia
    public ArrayList<Cursada> listarCursadasPorMateria(int idMateria) {

        ArrayList<Cursada> lista = new ArrayList<>();

        String sql = "SELECT * FROM cursada WHERE idMateria = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();

            AlumnoData alumnoData = new AlumnoData();
            MateriaData materiaData = new MateriaData();

            Materia materia = materiaData.buscarMateria(idMateria);

            while (rs.next()) {

                int idAlumno = rs.getInt("idAlumno");

                Alumno alumno = alumnoData.buscarAlumno(idAlumno);

                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        rs.getObject("notaFinal", Double.class), // Evitar que una nota nula se interprete como 0.0.
                        rs.getBoolean("recursante"),
                        rs.getInt("asistencia"),
                        alumno,
                        materia
                );
                lista.add(cursada);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            System.out.println("Error al listar cursadas de la materia: "
                    + e.getMessage());
        }

        return lista;
    }
    
    
    // Método que devuelve las cursadas de una materia que coincidan con los criterios: materia, año y cuatrimestre.
    // Determinar vigencia.
    public ArrayList<Cursada> listarCursadasPorMateriaYPeriodo(
            
            int idMateria, int anio, int cuatrimestre) {

        ArrayList<Cursada> lista = new ArrayList<>();

        String sql = "SELECT * FROM cursada "
                + "WHERE idMateria = ? AND anio = ? "
                + "AND cuatrimestre = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idMateria);
            ps.setInt(2, anio);
            ps.setInt(3, cuatrimestre);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Cursada cursada = buscarCursada(
                            rs.getInt("idCursada")
                    );

                    if (cursada != null) {
                        lista.add(cursada);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "No se pudieron listar las cursadas: " + e.getMessage()
            );
        }

        return lista;
    }

}
