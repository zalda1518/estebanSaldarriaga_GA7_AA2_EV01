package javaapplication5;
import java.sql.*;

public class JavaApplication5 {

      public static void main(String[] args) {
          
       String usuario ="root";
       String password ="";
       String url = "jdbc:mysql://localhost:3306/database_java";
       Connection conexion;
       Statement statement;
       ResultSet rs;   
      
        try{
           Class.forName("com.mysql.cj.jdcb.Driver");
           
           conexion = DriverManager.getConnection(url,usuario,password);
           statement = conexion.createStatement();
           
           statement.executeUpdate("INSERT INTO java_datos (nombre, cedula, clave) VALUES ('andres', '1234', 'andres1234')");
          
           rs = statement.executeQuery("SELECT * FROM java_datos");
           rs.next();
           do {
               System.out.println(rs.getInt("id") + ":" + rs.getString("nombre") + ":" + rs.getInt("cedula") + ":" + rs.getString("clave") );
           } while (rs.next());
       }   catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
           
       }
          
     }
    
}
