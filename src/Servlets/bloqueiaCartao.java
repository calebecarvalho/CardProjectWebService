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
import MySQLTranslator.CartaoTranslator;
import MySQLConnector.CardConnector;
import ApacheComplements.Complement;
import com.google.gson.Gson;

/**
 * Created by CalebeLustosa on 10/12/2016.
 */
@WebServlet(name = "bloqueiaCartao", urlPatterns = {"/bloqueiaCartao"})
public class bloqueiaCartao extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            PrintWriter saida = response.getWriter();
            response.setHeader("Content-Type", "application/json");

            String CPF = request.getParameter("CPF");
            if (CPF == null){
                saida.print(1001);
                return;
            }
            String senha = request.getParameter("senha");
            if(senha == null){
                saida.print(1001);
                return;
            }

            ClienteTranslator clienteTranslator = new ClienteTranslator();
            if(!clienteTranslator.verificaAcessoCliente(CPF,senha)){
                saida.print(1001);
                return;
            }

            CartaoTranslator cartaoTranslator = new CartaoTranslator();
            if(cartaoTranslator.bloquear(NumCartao)){
                saida.print(1000);
                return;
            }
            saida.print(1003);
     }catch (Exception E){
            E.getStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("temp/erro.jsp");
    }
}
