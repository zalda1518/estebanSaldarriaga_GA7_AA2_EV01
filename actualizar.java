import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class actualizar {
    private static final String url = "jdbc:mysql://localhost:3306/basedatos_java";
    private static final String user = "root";
    private static final String password = "";
    
    public static void main(String[] arg){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection != null){
                System.out.println("conectado con exito");
                
                String updateQuery = "UPDDATE datos_java SET nombres  = ? WHERE id = ? ";
                
                PrepatedStatement preparedStatement = connection.prepareStatement(updateQuery);
                
                preparedStatement.setString(1, "pedro");
                preparedStatement.setString(2, "1");
                
                 int rowsAffected = preparedStatement.executeUpdate();
                 
                  if (rowsAffected > 0) {
                    System.out.println("Data updated successfully!");
                } else {
                    System.out.println("Failed to update data!");
                }
                preparedStatement.close();
                connection.close();
            }
            
            } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    
  } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
