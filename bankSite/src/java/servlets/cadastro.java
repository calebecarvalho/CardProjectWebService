/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author burn
 */
@WebServlet(name = "cadastro", urlPatterns = {"/cadastro"})
public class cadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cpf = Integer.parseInt(request.getParameter("cpf_insert"));
        String nome = request.getParameter("nome");
        int senha = Integer.parseInt(request.getParameter("senha"));
        int cep = Integer.parseInt(request.getParameter("cep"));
        String endereco = request.getParameter("end");
        String email = request.getParameter("email");
        int telefoneres = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        int index = Integer.parseInt(request.getParameter("index"));
        
        
    }

}
