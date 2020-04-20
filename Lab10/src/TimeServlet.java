import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import com.google.gson.Gson;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

@WebServlet("/TimeServletTest")
public class TimeServlet extends HttpServlet {

    public TimeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("Current time :"+LocalTime.now()+"<br>");
        response.getWriter().println("<br>Your text :"+request.getParameter("TextForUrl")+"<br>");
        response.getWriter().println("<br>Request session ID :"+request.getRequestedSessionId()+"<br>");
        response.getWriter().println("<br>Server name :"+request.getServerName()+"<br>");
        response.getWriter().println("<br>Server port :" + request.getServerPort() + "<br>");
        response.getWriter().println("<br>Client IP :"+request.getRemoteAddr()+"<br>");
        response.getWriter().println("<br>Server IP :"+request.getLocalAddr()+"<br>");

        DataBase db = new DataBase();
        db.PutUser(new User("Admin","Admin","Admin"));
        ArrayList<User> users = db.GetUsers();
        User user = users.get(0);
        response.getWriter().println("<br>User :"+user+"<br>");
    }
}