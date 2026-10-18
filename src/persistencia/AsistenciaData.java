package persistencia;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import modelo.Asistencia;
import modelo.Cursada;
//import org.mariadb.jdbc.Connection;
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

    public void guardarAsistencia(Asistencia asistencia) {
        // a traves del Insert agregamos un registro
        String sql = "INSERT INTO asistencia "
                + "(idCursada,fecha,presente) "
                + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, asistencia.getCursada().getIdCursada());  // obtiene el id de cursada

            ps.setDate(2, new java.sql.Date(asistencia.getFecha().getTime())); // obtiene la fecha del objeto y la convierte a java.sgl.Date
            
            ps.setBoolean(3, asistencia.isPresente());  // aca obtiene el valor booleano del objeto (si o no)

            ps.executeUpdate();   // ejecuta la inserción, usamos Update para insert, update o delete
            ps.close();
        } catch (SQLException e) {
            System.out.println(" No se pudo guardar la asistencia:  " + e.getMessage());
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
            System.out.println(" NO se han podido listar las asistencia: " + e.getMessage());
        }
        return lista;

    }

    public void actualizarAsistencia(Asistencia asistencia) {
        String sql = "UPDATE asistencia " + "SET fecha = ?, presente = ? " // con update modificamos un registro, el set establece los nuevos valores y el quere decide que modifica
                + "WHERE idAsistencia = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(asistencia.getFecha().getTime()));
            ps.setBoolean(2, asistencia.isPresente());
            ps.setInt(3, asistencia.getIdAsistencia());
            ps.executeUpdate();  // ejecuta la modificacion en la base de datos
            ps.close();

        } catch (SQLException e) {
            System.out.println(" No se pudo actualizar la asistencia: " + e.getMessage());
        }
    }

    public void eliminarAsistencia(int idAsistencia) {

        String sql = "DELETE FROM asistencia WHERE  idAsistencia = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idAsistencia);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" No se pudieron hacer cambios en Asistencia; "
                    + e.getMessage());

        }

    }

}
