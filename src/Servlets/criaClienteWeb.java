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
@WebServlet(name = "criaClienteWeb", urlPatterns = {"/criaClienteWeb"})
public class criaClienteWeb extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{

            PrintWriter saida = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            Complement complement = new Complement();
            ClienteTranslator clienteTranslator = new ClienteTranslator();
            ClientConnector cliente = new ClientConnector();

            String confSenha = request.getParameter("confirmacao");
            if(!(request.getParameter("senha").equals(confSenha))){
                request.setAttribute("ERRO", "Repita a mesma senha nos campos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

            cliente.setNome(request.getParameter("nome"));
            cliente.setCpf(complement.normaliza(request.getParameter("cpf_insert")));
            cliente.setSenha(request.getParameter("senha"));
            cliente.setCep(request.getParameter("cep"));
            cliente.setEnd(request.getParameter("end"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setCelular(request.getParameter("celular"));
            clienteTranslator.cadastrarCliente(cliente);
            RequestDispatcher dispatcher = request.getRequestDispatcher("iniciar.jsp");
            dispatcher.forward(request,response);

        }catch (Exception E){
            E.getStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("temp/erro.jsp");
    }
}
