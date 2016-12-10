package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import MySQLTranslator.ClienteTranslator;
import ApacheComplements.Complement;

/**
 * Created by CalebeLustosa on 10/12/2016.
 */
@WebServlet(name = "verificaUsuarioWeb")
public class verificaUsuarioWeb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        PrintWriter saida = response.getWriter();
        response.setHeader("Content-Type", "application/json");
        Complement complement = new Complement();
        String CPF = complement.normaliza(request.getParameter("CPF"));
        String senha = request.getParameter("senha");

        if (CPF == null){
            request.setAttribute("ERRO","Campo de CPF não pode ser vazio");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }
        if (senha == null){
            request.setAttribute("ERRO","Campo de senha não pode ser vazio");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }
        ClienteTranslator clienteTranslator = new ClienteTranslator();
        boolean sucesso = clienteTranslator.verificaAcessoCliente(CPF,senha);

        if(sucesso){
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

        }else {
            request.setAttribute("ERRO","Informações de login inválidos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }

    }catch (Exception E){
        E.getStackTrace();
    }
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("temp/erro.jsp");
    }
}
