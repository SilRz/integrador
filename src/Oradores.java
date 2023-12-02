import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Oradores {

    
    public static void main(String[] args) throws SQLException {
      
       try{ 
       Connection conexion=null;
        
       String user= "root";
       String password="root";
       
           String url="jdbc://localhost:3306/mysql?user=" + user + "&password=" + password;
           conexion= DriverManager.getConnection(url);
           if (conexion!= null){
               System.out.println("Conexion: Conexión a mi base satisfactoria");
                       
           }
        }catch(SQLException ex){
           
        }
            
           
       }
                
    
    
   
           
           
         
            
}
