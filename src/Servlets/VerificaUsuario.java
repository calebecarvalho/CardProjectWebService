package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MySQLConnector.ClientConnector;
import MySQLConnector.CardConnector;
import MySQLTranslator.ClienteTranslator;
import MySQLTranslator.CartaoTranslator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by CalebeLustosa on 03/12/2016.
 */

@WebServlet(name = "Verificar Usuario", urlPatterns = {"/Verificacao"})
public class VerificaUsuario extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            String CPF = request.getParameter("CPF");
            if(CPF == null){
                out.print(1001);
                return ;
            }
            String senha = request.getParameter("Senha");
            if(senha == null){
                out.print(1001);
                return ;
            }
            ClienteTranslator clienteTranslator = new ClienteTranslator();
            if(!clienteTranslator.verificaAcessoCliente(CPF, senha)){
                out.print(1001);
                return ;
            }
            ClientConnector clientConnector = clienteTranslator.verificaCliente(CPF, senha);

            if(clientConnector == null){
                out.print(1001);
                return ;
            }

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            out.print(gson.toJson(clientConnector));
        }catch (Exception E){
            E.getStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.sendRedirect("etc/error.jsp");
    }


}