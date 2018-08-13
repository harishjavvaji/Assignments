package com.mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");


        ServletContext servletContext = req.getServletContext();
        String Username = (String) servletContext.getAttribute("userName");
        String Password = (String) servletContext.getAttribute("password");


        if (Username.equals(userName) && Password.equals(password)) {

            PrintWriter printWriter = resp.getWriter();
            printWriter.print("<html><body> login.html should be called</body></html>");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Welcome.html");
//            requestDispatcher.include(req,resp);
        }else {

            resp.getWriter().print("<font color='red'><b> Incorrect username or password</b></font>");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
//            requestDispatcher.include(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");


        ServletContext servletContext = req.getServletContext();
        String Username = (String) servletContext.getAttribute("userName");
        String Password = (String) servletContext.getAttribute("password");


        if (Username.equals(userName) && Password.equals(password)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Welcome.html");
            requestDispatcher.include(req,resp);
        }else {

            resp.getWriter().print("<font color='red'><b> Incorrect username or password</b></font>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
            requestDispatcher.include(req, resp);
        }




    }
}
