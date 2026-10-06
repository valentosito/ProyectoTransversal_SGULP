package persistencia;

import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;
import org.mariadb.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursadaData {

    private Connection connection;

    // casteo de conection. Aca conectamos con MariaDB
    public CursadaData() {
        connection = (Connection) Conexion.getInstancia().getConnection();
    }

    // damos el alta a la cursada 
    // importo la clase cursada
    public void guardarCursada(Cursada cursada) {   //recibe un objeto cursada y lo transforma en un INSERT//

        String sql = "INSERT INTO cursada"
                + "(idAlumno, idMateria, anio, cuatrimestre, condicion, "
                + "recursante, notaFinal, asistencia) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cursada.getAlumno().getIdAlumno());
            ps.setInt(2, cursada.getMateria().getIdMateria());
            ps.setInt(3, cursada.getAnio());
            ps.setInt(4, cursada.getCuatrimestre());
            ps.setInt(5, cursada.getCondicion());
            ps.setBoolean(6, cursada.isRecursante());
            ps.setDouble(7, cursada.getNotaFinal());
            ps.setInt(8, cursada.getPorcAsistencia());

            ps.executeUpdate();

            ps.close();

            System.out.println("Cursada guardada correctamente.");

        } catch (SQLException e) {

            System.out.println("Error al guardar cursada: " + e.getMessage());
        }
    }

    // borrar la cursada ( recibe solo id q se genero antes y lo elimina a traves de delete)
    public void borrarCursada(int idCursada) {

        String sql = "DELETE FROM cursada WHERE idCursada = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idCursada);

            ps.executeUpdate();

            ps.close();

            System.out.println("Cursada borrada correctamente.");

        } catch (SQLException e) {

            System.out.println("Error al borrar cursada: " + e.getMessage());
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
            ps.setDouble(7, cursada.getNotaFinal());
            ps.setInt(8, cursada.getPorcAsistencia());
            ps.setInt(9, cursada.getIdCursada());

            ps.executeUpdate();

            ps.close();

            System.out.println("Cursada actualizada correctamente.");

        } catch (SQLException e) {

            System.out.println("Error al actualizar cursada: " + e.getMessage());
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

                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        rs.getDouble("notaFinal"),
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

                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        rs.getDouble("notaFinal"),
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
                Cursada cursada = new Cursada(
                        rs.getInt("idCursada"),
                        rs.getInt("anio"),
                        rs.getInt("cuatrimestre"),
                        rs.getInt("condicion"),
                        rs.getDouble("notaFinal"),
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
                        rs.getDouble("notaFinal"),
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
}
