import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {

    private String url;
    private String user;
    private String password;

    public ConnectionCreator() {
//        ResourceBundle resource = ResourceBundle.getBundle("DB");
//        url = resource.getString("db.url");
//        user = resource.getString("db.user");
        url = "jdbc:mysql://localhost:3306/java10?useUnicode=true&serverTimezone=UTC&useSSL=false";
        user = "root";
        password = "Фвьшт";

    }

    public Connection createConnection() throws SQLException {
        Properties prop = new Properties();
        prop.put("user", user);
        prop.put("password", password);
        return DriverManager.getConnection(url, prop);
    }
}