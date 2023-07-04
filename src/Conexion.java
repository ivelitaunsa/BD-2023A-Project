import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conn;
    public Conexion() {
        // com.mysql.jdbc.Driver -> Deprecated
        final String driver = "com.mysql.cj.jdbc.Driver";
        
        //Extrayendo keys de archivo .properties
        Properties props=new Properties();
        try(FileInputStream fis=new FileInputStream("./src/config.properties")){
            props.load(fis);
        }catch(IOException e){
            System.out.println("Error" + e);
        }
        final String url = props.getProperty("db.url");
        final String dbName = props.getProperty("db.name");
        final String userName = props.getProperty("db.user");
        final String password = props.getProperty("db.password");
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url+dbName, userName, password);		
            System.out.println("Conexión OK");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error" + e);
        }
    }
}
