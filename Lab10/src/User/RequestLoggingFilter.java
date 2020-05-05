package User;

import User.DataBase;
import User.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter("/UserServletTest")
public class RequestLoggingFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        String inputLogin = request.getParameter("Login");
        User cUser = null;

        DataBase db = null;
        try {
            db = new DataBase();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        try {
            cUser = db.GetUser(inputLogin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (cUser == null) {
            request.setAttribute("ErrorCode", 1);
            request.setAttribute("ErrorMessage", "Login is not exist");
            request.getRequestDispatcher("ErrorPage.jsp").
                    forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}