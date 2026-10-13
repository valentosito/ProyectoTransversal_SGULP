
package persistencia;

import java.sql.SQLException;
import java.util.Date;
import modelo.Asistencia;
import org.mariadb.jdbc.Connection;


public class AsistenciaData {
    //creamos el atributo de conexion
    private Connection connection;
    // creamos el constructor de conexion
    public AsistenciaData () {
    connection =  (Connection) Conexion.getInstancia().getConnection(); 
    }
    
    public void guardarAsistencia(Asistencia asistencia) {
        // a traves del Insert agregamos un registro
        String sql= "INSERT INTO asistecnia" + "(idCursada,fecha,presente)"+ "VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, asistencia.getCursada(). getIdCursada());  // obtiene el id de cursada
            ps.setDate(2, new Date (asistencia.getFecha(). getTime())); // obtiene la fecha del objeto y la convierte a java.sgl.Date
            ps.setBoolean(3, asistencia.isPresente());  // aca obtiene el valor booleano del objeto (si o no)
            
            ps.executeUpdate();   // ejecuta la inserción
            ps.Close();
        } catch (SQLException e) {
            System.out.println(" No se pudo guardar la asistencia:  "+ e.getMessage());
        }
    
    }
    
    
}
