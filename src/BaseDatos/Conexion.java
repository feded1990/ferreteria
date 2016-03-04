package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection conexion;
    
    public static Connection crearConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/ferreteria";
            String usuarioDB="David";
            String passwordDB="123456";//Ferreteria2015/123456
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar a la base "
                    + "de datos. Revise su conexion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar a la base "
                    + "de datos. Revise su conexion");
        }
        return conexion;
    }
    
    public Connection obtenerConexion() {
        if (conexion == null) {
            conexion = crearConexion();
        }
        return conexion;
 
    }
}
