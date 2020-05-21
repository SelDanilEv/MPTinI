package ExampleServlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import com.google.gson.Gson;

@WebServlet("/Task6_2AServletTest")
public class Task6_2AServlet extends HttpServlet {

    public Task6_2AServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String str = "<br>";
        try {
            str += request.getAttribute("Attribute1").toString() + "<br>";
        } catch (NullPointerException e) {
            str += "Attribute fail<br>";
        }
        request.setAttribute("mystr1", str);
        request.getRequestDispatcher("index10Lab.jsp").
                forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");

    }
}