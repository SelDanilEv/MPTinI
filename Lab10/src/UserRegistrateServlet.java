import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/UserRegistrateServletTest")
public class UserRegistrateServlet extends HttpServlet {
    public UserRegistrateServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String inputLogin = request.getParameter("Login");
        String inputPassword = request.getParameter("Password");

        User cUser = null;

        DataBase db = new DataBase();

        ArrayList<User> users = db.GetUsers();

        for (User us : users) {
            if (us.name.equals(inputLogin))
                cUser = us;
        }

        if (cUser != null)
            response.getWriter().println("<br><h1>ERROR</h1><br>");
        else {
            db.PutUser(new User(inputLogin,inputPassword,"User"));
            response.getWriter().println("<br><div align=\"center\"><h3>Hello :" + inputLogin + " " + "User" +"<br>"+ LocalDateTime.now() +"</h3></div><br>");
        }
    }
}
