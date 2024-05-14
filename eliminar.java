import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eliminar {
    
     private static final String url = "jdbc:mysql://localhost:3306/database_java";
      private static final String user = "username";
       private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
                
                
                String deleteQuery = "DELETE FROM datos_java WHERE id = ?";
                
                
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                
                
                preparedStatement.setString(1, "1"); 
                
               
                int rowsAffected = preparedStatement.executeUpdate();
                
                
                if (rowsAffected > 0) {
                    System.out.println("Record deleted successfully!");
                } else {
                    System.out.println("Failed to delete record!");
                }
                
               
                preparedStatement.close();
                connection.close();
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

