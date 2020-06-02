package User;

import User.User;
import User.DataBase;
import User.ResourseUser;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/UserServletTest")
public class UserServlet extends HttpServlet {
    public UserServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String inputLogin = request.getParameter("Login");
        String inputPassword = request.getParameter("Password");


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

        boolean flagcorrectpassword = true;

        if (inputLogin.equals("") || inputLogin == null) {
            request.setAttribute("ErrorMessage", "Empty login");
            request.getRequestDispatcher("login.jsp").
                    forward(request, response);
        }
        if (inputPassword.equals("") || inputPassword == null) {
            request.setAttribute("ErrorMessage", "Empty password");
            request.getRequestDispatcher("login.jsp").
                    forward(request, response);
        }


        if (cUser.name.equals(inputLogin)) {
            if (cUser.password != inputPassword.hashCode()) {
                flagcorrectpassword = false;
            }
        }

        if (cUser != null && flagcorrectpassword==true) {

            request.setAttribute("UserInfo", cUser.toString());
            request.setAttribute("UserLogin", cUser.name);
            request.setAttribute("CurrentDate", LocalDateTime.now());
            ArrayList<ResourseUser> resourseUsers =null;
            try {
                 resourseUsers = db.GetUserResourse(inputLogin);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            double sum=0;
            for (ResourseUser res:resourseUsers) {
                sum += res.cost;
            }
            request.setAttribute("list_res",resourseUsers );
            request.setAttribute("sum",sum );

            request.getRequestDispatcher("welcome.jsp").           //Lab11-12
                    forward(request, response);

//            response.getWriter().println("<br><div align=\"center\"><h3>Hello :" +     //Lab10
//                    cUser.role + " " + cUser.name + "<br>" + LocalDateTime.now() +
//                    "</h3></div><br>");

//            Cookie ck=new Cookie("user","");//deleting value of cookie    //example
//            ck.setMaxAge(0);//changing the maximum age to 0 seconds
//            response.addCookie(ck);//adding cookie in the response

            //cookies
            {
                boolean isLastTime = false;
                boolean isRole = false;
                boolean isCounter = false;

                Cookie ck[] = request.getCookies();
                for (int i = 0; i < ck.length; i++) {
                    response.getWriter().print("<br>" + ck[i].getName() + " " + ck[i].getValue());//printing name and value of cookie
                    switch (ck[i].getName()) {
                        case "Last":
                            isLastTime = true;
                            ck[i].setValue(LocalDateTime.now().toString());
                            break;
                        case "Role":
                            isRole = true;
                            ck[i].setValue(cUser.role);
                            break;
                        case "Counter":
                            isCounter = true;
                            int rc = Integer.parseInt(ck[i].getValue()) + 1;
                            ck[i].setValue(String.valueOf(rc));
                            break;
                    }
                    response.addCookie(ck[i]);//adding cookie in the response
                }
                if (!isLastTime) {
                    Cookie cookie = new Cookie("Last", LocalDateTime.now().toString());//deleting value of cookie
                    response.addCookie(cookie);//adding cookie in the response
                    response.getWriter().print("<br>" + cookie.getName() + " " + cookie.getValue());//printing name and value of cookie
                }
                if (!isRole) {
                    Cookie cookie = new Cookie("Role", cUser.role);//deleting value of cookie
                    response.addCookie(cookie);//adding cookie in the response
                    response.getWriter().print("<br>" + cookie.getName() + " " + cookie.getValue());//printing name and value of cookie
                }
                if (!isCounter) {
                    Cookie cookie = new Cookie("Counter", "0");//deleting value of cookie
                    response.addCookie(cookie);//adding cookie in the response
                    response.getWriter().print("<br>" + cookie.getName() + " " + cookie.getValue());//printing name and value of cookie
                }
            }
        } else {
            if (flagcorrectpassword) {
                //todo redirect to registrate
                request.setAttribute("ErrorCode", 1);
                request.setAttribute("ErrorMessage", "Login is not exist");
                request.getRequestDispatcher("ErrorPage.jsp").
                        forward(request, response);
            } else {
                request.setAttribute("ErrorMessage", "Wrong password");
                request.getRequestDispatcher("login.jsp").
                        forward(request, response);
            }
//                response.getWriter().println("<br><h1>ERROR</h1><br>");
        }
    }
}
