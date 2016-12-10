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
import com.google.gson.Gson;

/**
 * Created by CalebeLustosa on 10/12/2016.
 */
@WebServlet(name = "clienteInfoWeb", urlPatterns = {"/clienteInfoWeb"})
public class clienteInfoWeb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        PrintWriter saida = response.getWriter();
        response.setHeader("Content-Type", "application/json");

        String CPF = request.getParameter("CPF");
        ClienteTranslator clienteTranslator = new ClienteTranslator();
        ClientConnector cliente = new ClientConnector();
        cliente = clienteTranslator.verificaCliente("CPF");
        Gson gson = new Gson();

        request.setAttribute("nome", gson.toJson(cliente.getNome()));
        request.setAttribute("CPF", gson.toJson(cliente.getCpf()));
        request.setAttribute("cep", gson.toJson(cliente.getCep()));
        request.setAttribute("endereco", gson.toJson(cliente.getEnd()));
        request.setAttribute("telfone", gson.toJson(cliente.getTelefone()));
        request.setAttribute("celular", gson.toJson(cliente.getCelular()));

        RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
        dispatcher.forward(request, response);
    }catch (Exception E){
        E.getStackTrace();
    }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("temp/erro.jsp");
    }
}
