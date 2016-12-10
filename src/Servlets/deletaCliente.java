package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import MySQLConnector.ClientConnector;
import MySQLTranslator.ClienteTranslator;
import ApacheComplements.Complement;
import com.google.gson.Gson;

/**
 * Created by CalebeLustosa on 09/12/2016.
 */
@WebServlet(name = "deletaCliente", urlPatterns = {"/deletaCliente"})
public class deletaCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            PrintWriter saida = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            Complement complement = new Complement();
            String CPF = complement.normaliza(request.getParameter("DelCPF"));
            String senha = request.getParameter("DelSenha");

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

            if (clienteTranslator.verificaCliente(CPF).equals(0)) {
                request.setAttribute("ERRO","Usuário não existe");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            }else {
                clienteTranslator.apagarCliente(CPF, senha);

                request.setAttribute("Sucesso", "Usuaário excluído");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/temp/erro.jsp");
    }
}
