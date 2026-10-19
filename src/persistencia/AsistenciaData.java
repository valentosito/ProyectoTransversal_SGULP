package persistencia;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import modelo.Asistencia;
import modelo.Cursada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class AsistenciaData {

    //creamos el atributo de conexion
    private Connection connection;

    // creamos el constructor de conexion
    public AsistenciaData() {
        connection = (Connection) Conexion.getInstancia().getConnection();
    }

    // Método que cuenta las clases que ya tienen un registro de asistencia para una cursada determinada. (Límite: 30).
    public int contarAsistencias(Cursada cursada) {

        String sql = "SELECT COUNT(*) FROM asistencia WHERE idCursada = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cursada.getIdCursada());

            ResultSet rs = ps.executeQuery();

            int cantidad = 0;

            if (rs.next()) {
                cantidad = rs.getInt(1);
            }

            rs.close();
            ps.close();

            return cantidad;

        } catch (SQLException e) {
            System.out.println("No se pudieron contar las asistencias: "
                    + e.getMessage());
            return -1;
        }
    }

    // Método que solo guarda asistencia si hay menos de 30 registradas.
    public boolean guardarAsistencia(Asistencia asistencia) {

        // Verificación de que la cursada no haya alcanzado las 30 clases:
        int cantidad = contarAsistencias(asistencia.getCursada());

        if (cantidad == -1) {
            return false;
        }

        if (cantidad >= 30) {
            System.out.println("La cursada ya tiene registradas las 30 clases.");
            return false;
        }

        // a traves del Insert agregamos un registro
        String sql = "INSERT INTO asistencia "
                + "(idCursada,fecha,presente) "
                + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, asistencia.getCursada().getIdCursada());  // obtiene el id de cursada

            ps.setDate(2, new java.sql.Date(asistencia.getFecha().getTime())); // obtiene la fecha del objeto y la convierte a java.sgl.Date

            ps.setBoolean(3, asistencia.isPresente());  // aca obtiene el valor booleano (si o no)

            int filas = ps.executeUpdate();   // ejecuta la inserción, usamos Update para insert, update o delete
            ps.close();

            if (filas > 0) {
                recalcularPorcentaje(asistencia.getCursada());
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.out.println(" No se pudo guardar la asistencia:  " + e.getMessage());
            return false;
        }
    }

    // creamos el metodo listar cursada
    public List<Asistencia> listarPorCursada(Cursada cursada) {

        // creamos la lista vacia
        List<Asistencia> lista = new ArrayList<>();
        // la consulta a SQL q vamos a usar
        String sql = "SELECT * FROM asistencia WHERE idCursada = ?";  // para consultar usamos query

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cursada.getIdCursada());
            ResultSet rs = ps.executeQuery();    // query se usa para consultas como select 

            while (rs.next()) {   // recorremos las filas de las consultas 
                Asistencia asistencia = new Asistencia(
                        rs.getInt("idAsistencia"),
                        rs.getDate("fecha"),
                        rs.getBoolean("presente"),
                        cursada
                );

                lista.add(asistencia);  // lo guardamos en la lista
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" NO se pudieron listar las asistencias: " + e.getMessage());
        }
        return lista;
    }

    // Agrego control de filas afectadas para detectar si el ID no corresponde a ningún registro.
    public void actualizarAsistencia(Asistencia asistencia) {

        String sql = "UPDATE asistencia SET fecha = ?, presente = ? "
                + "WHERE idAsistencia = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(asistencia.getFecha().getTime()));
            ps.setBoolean(2, asistencia.isPresente());
            ps.setInt(3, asistencia.getIdAsistencia());

            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                recalcularPorcentaje(asistencia.getCursada());
            } else {
                System.out.println("No se modificó ninguna asistencia.");
            }

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar la asistencia: " + e.getMessage());
        }
    }
    

    /*
    Método que recalcula el porcentaje de asistencia de una cursada a partir de sus registros de asistencia 
    y actualiza ese valor en la base de datos.
    Objetivo: mantener los valores sincronizados cuando se registra o modifica una asistencia.
    */
    private void recalcularPorcentaje(Cursada cursada) {

        // Obtenemos todos los registros de asistencia de la cursada.
        List<Asistencia> asistencias = listarPorCursada(cursada);

        // Actualizamos la lista de asistencias del objeto Cursada.
        cursada.getListaDeAsistencias().clear();
        cursada.getListaDeAsistencias().addAll(asistencias);

        // Calculamos el porcentaje de asistencia.
        int porcentaje = cursada.calcularPorcentajeAsistencia();

        // Actualizamos el porcentaje en la base de datos.
        CursadaData cursadaData = new CursadaData();
        cursadaData.actualizarPorcentajeAsistencia(
                cursada.getIdCursada(),
                porcentaje
        );
    }

    
}
