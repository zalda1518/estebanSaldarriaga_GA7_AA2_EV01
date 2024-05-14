import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    public static void main (String[] arg){
        String url = "jdbc:mysql://localhost:3306/basedatos_java";
        String user = "root";
        String password = "";
    
        try{
            Connection conexion = DriverManager.getConnection(url,user,password);
            if(conexion != null){
               Statement statement = connection.createStatement();
               String query = "SELECT * datos_java";
               ResultSet resulSet = statement.executeQuery(query);
               
               while(ResultSet.next()){
                   int id = resultSet.getInt("id");
                   String nombre = resultSet.getString("nombre");
                   String clave = resultSet.getString("clave");
                   System.out.println("id:" + id + ", nombre: " + nombre);
               }
             }
        } catch (SQLExecption e){
            System.out.println("error de conexion con la base de datos");
            e.printStackTrace();
        }
        
        
    }
    
    
}
