import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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

        if(inputLogin.equals("") ||inputLogin==null){
            request.setAttribute("ErrorMessage", "Empty login");
            request.getRequestDispatcher("register.jsp").
                    forward(request, response);
        }
        if(inputPassword.equals("") ||inputPassword==null) {
            request.setAttribute("ErrorMessage", "Empty password");
            request.getRequestDispatcher("register.jsp").
                    forward(request, response);
        }
        if(inputPassword.length()<6) {
            request.setAttribute("ErrorMessage", "Password is too short");
            request.getRequestDispatcher("register.jsp").
                    forward(request, response);
        }


        DataBase db = null;
        try {
            db = new DataBase();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        User cUser = null;
        try {
            cUser = db.GetUser(inputLogin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (cUser != null) {
            request.setAttribute("ErrorCode", 2);
            request.setAttribute("ErrorMessage", "Login already exist");
            request.getRequestDispatcher("ErrorPage.jsp").
                    forward(request, response);
        } else {
            try {
                db.PutUser(new User(inputLogin,inputPassword.hashCode(),"User"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.setAttribute("ErrorMessage", inputLogin+" registrated");
            request.getRequestDispatcher("login.jsp").
                    forward(request, response);
        }
    }
}
