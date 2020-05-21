import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDao {

    private final ConnectionCreator connectionCreator = new ConnectionCreator();

    public UserDao() {
    }


    public void addUser(User user) throws SQLException, ClassNotFoundException {
        String query = " INSERT INTO users"
                + " VALUES (?, ?,?)";
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,user.getName());
        statement.setInt(2,user.getPassword());
        statement.setString(3,user.getRole());
        statement.executeUpdate();
    }

    public User GetUser(String login) throws SQLException, ClassNotFoundException {
        User user = null;
        String query = " select *  from users where user_name = (?) ";
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,login);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            user = new User(
                    resultSet.getString("user_name"),
                    resultSet.getInt("user_password"),
                    resultSet.getString("user_role"));
        }
        return user;
    }

    public ArrayList<ResourseUser> GetResourse(String login) throws SQLException {
        ArrayList<ResourseUser> rc = new ArrayList<ResourseUser>();
        String query = " select *  from resources where user_login = (?) ";
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,login);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            rc.add(new ResourseUser(
                    resultSet.getString("resource_name"),
                    resultSet.getDouble("resource_cost")
                    ) );
        }
        return rc;
    }
}
