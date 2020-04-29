package DataBasePack;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionCreator {

    private String url;
    private String user;
    private String password;

    public ConnectionCreator() {

        ResourceBundle resource = ResourceBundle.getBundle("DB");
        url = resource.getString("db.url");
        user = resource.getString("db.user");
        password = "Фвьшт";

    }

    public Connection createConnection() throws SQLException {
        Properties prop = new Properties();
        prop.put("user", user);
        prop.put("password", password);
        return DriverManager.getConnection(url, prop);
    }
}