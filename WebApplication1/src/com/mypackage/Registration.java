package com.mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (userName != null && userName != "" && password != null && password != "") {
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("userName", userName);
            servletContext.setAttribute("password", password);

            PrintWriter printWriter = resp.getWriter();
            printWriter.print("<html><body> login.html should be called</body></html>");

            System.out.println("For github check");


//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
//            requestDispatcher.include(req,resp);
        }else {
            resp.getWriter().print("<font color='red'><b> Enter valid username or password </b></font>");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Registration.html");
//            requestDispatcher.include(req, resp);


        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (userName != null && userName != "" && password != null && password != "") {
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("userName", userName);
            servletContext.setAttribute("password", password);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
            requestDispatcher.include(req,resp);
        }else {
            resp.getWriter().print("<font color='red'><b> Enter valid username or password </b></font>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Registration.html");
            requestDispatcher.include(req, resp);


        }








    }
}
