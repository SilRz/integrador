import java.beans.Statement;
import static java.lang.ProcessBuilder.Redirect.to;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Oradores {

    
    public static void main(String[] args) throws Exception {
        
      Class.forName("com.msql.cj.jdbc.Driver");
      String url="jdbc://localhost:3306/dbjoes?chararcterEncoding=utf8";
      String username= "root@localhost";
      String password="";
      Connection conexion = DriverManager.getConnection(url,username,password);
      
      Statement stmt=(Statement) conexion.createStatement();
      ResultSet rs;
      PreparedStatement st;
      
      String qry="";
      int id,edad,opcion;
      String nombre, apellido, ciudad;
       
      Scanner in = new Scanner(System.in);
      Scanner str= new Scanner(System.in);
      
      while(true){
          
          System.out.println("MSQL Java CRUD");
          System.out.println("1.Ingresar");
          System.out.println("2.Modificar");
          System.out.println("3.Borrar");
          System.out.println("4.Seleccionar");
          System.out.println("5.Salir");
          System.out.println("Ingrese una opción: ");
          opcion=in.nextInt();
          System.out.println("######################################");
          
          switch(opcion){
              case 1 -> {
                  System.out.println("1.Ingresar datos");
                  System.out.println("Ingrese el nombre :");
                  nombre=str.nextLine();
                  System.out.println("Ingrese el apellido :");
                  apellido=str.nextLine();
                  System.out.println("Ingrese la edad :");
                  edad=in.nextInt();
                  System.out.println("Ingrese la ciudad :");
                  ciudad=str.nextLine();
                  
                  qry="insert into users(nombre, apellido,edad,ciudad) values(?,?,?,?)";
                  st=(PreparedStatement) conexion.prepareStatement(qry);
                  st.setString(1, nombre);
                  st.setString(2, apellido);
                  st.setInt(3, edad);
                  st.setString(4, ciudad);
                  
                  st.executeUpdate();
                  System.out.println("Ingreso de datos exitoso");
              }
                  
              case 2 -> {
                  System.out.println("2.Modificar datos");
                  System.out.println("Ingrese ID : ");
                  id =in.nextInt();
                  System.out.println("Ingrese el nombre :");
                  nombre=str.nextLine();
                  System.out.println("Ingrese el apellido :");
                  apellido=str.nextLine();
                  System.out.println("Ingrese la edad: ");
                  edad=in.nextInt();
                  System.out.println("Ingrese la ciudad :");
                  ciudad=str.nextLine();
                  
                  qry="update users set nombre=?,apellido=?,edad=?,ciudad=? where ID=?";
                  st= (PreparedStatement) conexion.prepareStatement(qry);
                  st.setString(1,nombre);
                  st.setString(2,apellido);
                  st.setInt(3,edad);
                  st.setString(4,ciudad);
                  
                  st.executeUpdate();
                  System.out.println("Modificación exitosa");
              }
                  
              case 3 -> {
                  System.out.println("3.Borrar datos");
                  System.out.println("Ingrese ID : ");
                  id =in.nextInt();
                  
                  
                  qry="delete from users where ID=?";
                  st= (PreparedStatement) conexion.prepareStatement(qry);
                  
                  st.executeUpdate();
                  System.out.println("Borrado de datos exitoso");
              }
                  
              case 4 -> {
                  System.out.println("4. Mostrar todos los registros");
                  
                  qry="SELECT ID,nombre,apellido,edad,ciudad from users";
                  rs=stmt.executeQuery(qry);
                  while(rs.next()){
                      id=rs.getInt("ID");
                      nombre=rs.getString("nombre");
                      apellido=rs.getString("apellido");
                      edad=rs.getInt("edad");
                      ciudad=rs.getString("ciudad");
                      
                      System.out.println(id + " ");
                      System.out.println(nombre + " ");
                      System.out.println(apellido + " ");
                      System.out.println(edad + " ");
                      System.out.println(ciudad + " ");
                      
                  }
              }
                  
              case 5 -> {
                  System.out.println("GRACIAS");
                  System.exit(0);
              }
                  
              default -> System.out.println("Opción ingresada invalida");
         
         
              }
                  
               System.out.println("##################################### ");   
                  
              
              }
}
                  
                  
      }
           
       
                
    
    
   
           
           
         
            

