package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author burn
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        
        if(uname.equals("shadow") && pass.equals("1")){
            
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("menu.jsp");
        
        }else{
            
            response.sendRedirect("login.jsp");
        
        }
        
    }

}
