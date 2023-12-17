

package oradores;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


public class Conexion {
    Connection con;
    
    
    public Conexion(){
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practico","root","");
        
        JOptionPane.showMessageDialog(null,"La conexión se ha realizado con exito. " );
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo establecer la conexión, error: " + e.toString() );
            
        }
    }
    public Connection getConnection(){
        return con;
    }
    
   
}
