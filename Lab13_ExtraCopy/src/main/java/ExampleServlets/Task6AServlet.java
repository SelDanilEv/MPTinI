package ExampleServlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import com.google.gson.Gson;

@WebServlet("/Task6AServletTest")
public class Task6AServlet extends HttpServlet {

    public Task6AServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setAttribute("Attribute1", "Task 6(attribute)");
        request.getRequestDispatcher("Task6_2AServletTest").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");

    }
}