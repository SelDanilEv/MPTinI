import org.apache.log4j.PropertyConfigurator;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//
//@WebServlet(
//        urlPatterns = {"/FirstServletTest"},
//        initParams = {
//                @WebInitParam(name = "mail.smtps.host", value = "smtp.gmail.com"),
//                @WebInitParam(name = "mail.smtp.port", value = "465"),
//                @WebInitParam(name = "smtps.auth.user", value = "pnv"),
//                @WebInitParam(name = "smtps.auth.pass", value = "pnv"),
//                @WebInitParam(name = "mail.transport.protocol", value = "smtps")
//        })
//public class FirstServlet extends HttpServlet {
//    protected void performServletConfig(
//            HttpServletRequest request,
//            HttpServletResponse response) {
//        try {
//            ServletConfig sc = this.getServletConfig();
//// определение набора имен параметров инициализации
//            Enumeration e = sc.getInitParameterNames();
//            while (e.hasMoreElements()) {
//// определение имени параметра инициализации
//                String name = (String) e.nextElement();
//// определение значения параметра инициализации
//                String value = sc.getInitParameter(name);
//                response.getWriter().print(value + '\n');
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//-------------------------------------------------
//@WebServlet(name = "FirstServletTest",
//        urlPatterns = {"/FirstServletTest"})
//public class FirstServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//    }
//
//    public void init() {
//        String prefix = getServletContext().getRealPath("/");
//        String filename = getInitParameter("init_log4j");
//        if (filename != null) {
//            PropertyConfigurator.configure(prefix + filename);
//        }
//    }
//
//    protected void performTask (HttpServletRequest request,
//                                HttpServletResponse response){
//        try {
//            ServletContext sc = this.getServletContext();
//            response.getWriter().print(this.getServletContext().
//                    getInitParameter("administrator") + '\n');
//            response.getWriter().print( sc.getServerInfo()+'\n');
//            response.getWriter().print( sc.getContextPath()+'\n');
//            response.getWriter().print(sc.getServletContextName() + '\n');
//            sc.log("This is message from first servlet");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response)
//            throws ServletException, IOException {
//        if (request.getParameter("radios") != null) {
//            if (request.getParameter("radios").equals("radio1")) {
//                response.getWriter().print("ISiT was selected. <br/>");
//            }
//            if (request.getParameter("radios").equals("radio2")) {
//                request.setAttribute("res", 26);
//                request.getRequestDispatcher("rezult.jsp").
//                        forward(request, response);
//            }
//            if(request.getParameter("radios").equals("radio3")){
//                performTask(request, response);
//            }
//        }
//    }
//}
//----------------------------------------------------------------------------------
//@WebServlet("/DemoServletTest")
//public class DemoServlet1111 extends HttpServlet {
//    public DemoServlet1111() {
//        super();
//    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse
//            response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().print("This is " +
//                this.getClass().getName()
//                + ", using the GET method");
//    }
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().print("This is " +
//                this.getClass().getName()
//                + ", using the POST method");
//    }
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//        System.out.println("service");
//    }
//    public void destroy() {
//        super.destroy();
//        System.out.println("destroy");
//    }
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        System.out.println("init");
//    }
//}
//----------------------------------------------------------------------
//@WebServlet("/FirstServletTest")
//public class FirstServlet extends HttpServlet {
//    public FirstServlet() {
//        super();
//    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse
//            response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().print(request.getParameter("radios").toString());
//    }
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().print("This is " +
//                this.getClass().getName()
//                + ", using the POST method");
//    }
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//        System.out.println("service");
//    }
//    public void destroy() {
//        super.destroy();
//        System.out.println("destroy");
//    }
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        System.out.println("init");
//    }
//}