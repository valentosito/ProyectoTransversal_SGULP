package persistencia;

import java.sql.Connection;
import modelo.Materia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MateriaData {

    private Connection connection;

    public MateriaData() {

        connection = Conexion.getInstancia().getConnection();
    }

    public void guardarMateria(Materia m) {
        String sql = "INSERT INTO materia(nombre, estado) VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, m.getNombre());
            ps.setBoolean(2, m.isEstado());
            ps.executeUpdate();
            ps.close();

            System.out.println("Materia guardada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar la materia: " + e.getMessage());
        }
    }

    public Materia buscarMateria(int idMateria) {
        Materia m = null;
        String query = "SELECT * FROM materia WHERE idMateria = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));

            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return m;
    }

    public ArrayList<Materia> listarMaterias() {
        Materia m = null;
        ArrayList<Materia> materias = new ArrayList<>();
        String query = "SELECT * FROM materia";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return materias;

    }

    public void borrarMateria(int id) {
        String sql = "DELETE FROM materia WHERE idMateria = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                System.out.println("Materia borrada correctamente.");
            } else {
                System.out.println("No se encontró una materia con id " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar la materia: " + e.getMessage());
        }
    }

    public void bajaEstado(int id) {
        String sql = "UPDATE materia SET estado = false WHERE idMateria = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                System.out.println("Materia dada de baja correctamente.");
            } else {
                System.out.println("No se encontró una materia con id " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al dar de baja a la materia: " + e.getMessage());
        }
    }

    public void altaEstado(int id) {
        String sql = "UPDATE materia SET estado = true WHERE idMateria = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                System.out.println("Materia dada de alta correctamente.");
            } else {
                System.out.println("No se encontró una materia con id " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al dar de alta a la materia: " + e.getMessage());
        }
    }

    public void actualizarMateria(Materia m) {
        String sql = "UPDATE materia SET nombre=?, estado=? WHERE idMateria = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setBoolean(2, m.isEstado());
            ps.setInt(3, m.getIdMateria());
            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                System.out.println("Materia actualizada correctamente.");
            } else {
                System.out.println("No se encontró una materia con id " + m.getIdMateria());
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la materia: " + e.getMessage());
        }
    }

}
