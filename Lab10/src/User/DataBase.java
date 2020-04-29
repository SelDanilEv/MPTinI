package User;

import DataBasePack.UserDao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.google.gson.Gson;

public class DataBase {

    private static UserDao dao ;

    public DataBase() throws SQLException, NamingException {
        if(dao == null)
            dao = new UserDao();
    }

    public User GetUser(String login) throws SQLException, ClassNotFoundException {
        User rc = null;
        rc = dao.GetUser(login);
        return rc;
    }

    public void PutUser(User user) throws SQLException, ClassNotFoundException {
        dao.addUser(user);
    }

    public ArrayList<ResourseUser> GetUserResourse(String login) throws SQLException {
        return dao.GetResourse(login);
    }
//-------------------------------------------------------------------------
//    private Gson gson;
//    String fileName = "E:/Danil/university/MPTinI/1s/Lab10/src/Users.json";
//    public ArrayList<User> GetUsers() throws FileNotFoundException {
//        gson = new GsonBuilder().create();
//
//        Path path = new File(fileName).toPath();
//
//        ArrayList<User> rc = null;
//        Type listType = new TypeToken<ArrayList<User>>() {
//        }.getType();
//
//        try (Reader reader = Files.newBufferedReader(path,
//                StandardCharsets.UTF_8)) {
//            rc = gson.fromJson(reader, listType);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (rc == null)
//            rc = new ArrayList<>();
//        return rc;
//    }
//
//    public void PutUser(User user) throws IOException {
//
//        gson = new Gson();
//        ArrayList<User> rc = GetUsers();
//        rc.add(user);
//
//        try (FileOutputStream fos = new FileOutputStream(fileName);
//             OutputStreamWriter isr = new OutputStreamWriter(fos,
//                     StandardCharsets.UTF_8)) {
//            gson.toJson(rc, isr);
//        }
//    }
}
