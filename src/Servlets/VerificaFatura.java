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
import MySQLConnector.FaturaConnector;
import MySQLTranslator.ClienteTranslator;
import MySQLTranslator.CartaoTranslator;
import MySQLTranslator.FaturaTranslator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by CalebeLustosa on 01/12/2016.
 */
@WebServlet(name =  "VerificaFatura", urlPatterns = {"/Fatura"})
public class VerificaFatura extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {

            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");

            String CPF = request.getParameter("CPF");
            if (CPF == null){
                out.print(1001);
                return ;
            }

            String senha = request.getParameter("Senha");
            if (senha == null){
                out.print(1001);
                return ;
            }

            ClienteTranslator clienteTranslator = new ClienteTranslator();
            if(!clienteTranslator.verificaAcessoCliente(CPF, senha)){
                out.print(1001);
                return ;
            }

            String NumCartao = request.getParameter("NumCartao");
            FaturaTranslator faturaTranslator = new FaturaTranslator();
            ArrayList<FaturaConnector> faturas = faturaTranslator.recebeFatura(NumCartao);

            if (faturas == null){
                out.print(404);
                return ;
            }

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            out.print(gson.toJson(faturas));

        }catch (Exception E){
            E.getStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("etc/error.jsp");
    }
}