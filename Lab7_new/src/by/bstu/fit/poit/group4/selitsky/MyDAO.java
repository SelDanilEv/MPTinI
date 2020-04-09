package by.bstu.fit.poit.group4.selitsky;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyDAO implements IDAO {

    ResourceBundle resource = ResourceBundle.getBundle ("DB");
    private String user = resource.getString("DB.user");
    private String password = resource.getString("DB.password");
    private String url = resource.getString("DB.url");

    public MyDAO(){
        try{
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    @Override
    public IGenDAO<Planet, Integer> getPlanetsDAO(Connection connection) {
        return new MyDAO_Planet(connection);
    }

    @Override
    public IGenDAO<Satellites, Integer> getSatellitesDAO(Connection connection) {
        return new MyDAO_Sattelites(connection);
    }
}
