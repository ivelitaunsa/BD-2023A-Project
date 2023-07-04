import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conn;
    public Conexion() {
        // com.mysql.jdbc.Driver -> Deprecated
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/";
        final String dbName = "BaseDatos";
        final String userName = "root";
        final String password = "1234";
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url+dbName, userName, password);		
            System.out.println("Conexión OK");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error" + e);
        }
    }
}
