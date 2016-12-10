package MySQLTranslator;
import MySQLConnector.ClientConnector;

import java.sql.*;
/**
 * Created by CalebeLustosa on 14/11/2016.
 */
public class ClienteTranslator {

    private static final String END_BD = "jdbc:mysql://localhost:3306/projeto_d";
    private static final String USUARIO = "user";
    private static final String SENHA = "123mudar";

    private Connection conexao = null;
    private PreparedStatement preparedStatement = null;

    private void preparaConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(END_BD, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException E) {
            E.printStackTrace();
        }
    }
    private void fechaConexao() {
        try {
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
                conexao = null;
            }
        }
        catch (SQLException E){
            conexao = null;
            E.printStackTrace();
        }
    }

    public boolean verificaAcessoCliente(String CPF, String senha){

        boolean existente = false;

        try{
            if(conexao == null)
                preparaConexao();

            String querry = "SELECT COUNT(*) FROM cliente WHERE CPF = ? AND senha = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(querry);

            preparedStatement.setString(1, CPF);
            preparedStatement.setString(2, senha);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                if (resultSet.getInt("COUNT(*)") == 1) {
                    fechaConexao();
                    return true;
                }
                else{
                    fechaConexao();
                    return false;
                }

                }
            else {
                fechaConexao();
                return false;
            }
        }catch (SQLException E){
            E.getMessage();
        }
       fechaConexao();
        return false;
    }
    public ClientConnector verificaCliente(String CPF){

        ClientConnector clientConnector = null;
        try{

            if(conexao == null)
                preparaConexao();

            String querry = "SELECT cliente.index, cliente.CPF, cliente.Nome, cliente.Senha, cliente.CEP, cliente.Endereço, cliente.Email, cliente.TelefoneRes., cliente.Celular\n"+
                            "FROM client cliente JOIN conta WHERE conta.NumConta = fk_NumConta_cl and cliente.CPF = ?"+
                            "AND cliente.Senha = ?";

            preparedStatement = conexao.prepareStatement(querry);
            preparedStatement.setString(1, CPF);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                clientConnector = new ClientConnector();

                do {
                    clientConnector.setIndex(resultSet.getInt("index"));
                    clientConnector.setNome(resultSet.getString("nome"));
                    clientConnector.setCpf(resultSet.getString("cpf"));
                    clientConnector.setSenha(resultSet.getString("senha"));
                    clientConnector.setCep(resultSet.getString("cep"));
                    clientConnector.setEnd(resultSet.getString("end"));
                    clientConnector.setEmail(resultSet.getString("email"));
                    clientConnector.setTelefone(resultSet.getString("telefone"));
                    clientConnector.setCelular(resultSet.getString("celular"));
                } while (resultSet.next());
            }else {
                fechaConexao();
                return null;
            }
        }catch (SQLException E){
            E.getMessage();
        }
        fechaConexao();
        return clientConnector;
    }

    public void cadastrarCliente(ClientConnector clientConnector){

        try{

            if (conexao == null)

                preparaConexao();

            String querry = "INSERT INTO projetod.cliente(Nome, CPF, Senha, CEP, Endereço, Email, TelefoneRes., Celular"+
                            "VALUES(?, ?, ?, ?, ?, ?, ?,?);";

            preparedStatement = conexao.prepareStatement(querry);

            preparedStatement.setString('1', clientConnector.getNome());
            preparedStatement.setString('2',clientConnector.getCpf());
            preparedStatement.setString('3', clientConnector.getSenha());
            preparedStatement.setString('4', clientConnector.getCep());
            preparedStatement.setString('6', clientConnector.getEnd());
            preparedStatement.setString('7',clientConnector.getEmail());
            preparedStatement.setString('8', clientConnector.getTelefone());
            preparedStatement.setString('9', clientConnector.getCelular());

            preparedStatement.execute();
            preparedStatement.close();



        }catch (SQLException E){
            E.getMessage();
        }
    }

    public void apagarCliente(String CPF, String senha){

        try {

            if (conexao == null)
                preparaConexao();

            String querry = "DELETE FROM cliente WHERE CPF = ? AND Senha = ?;";
            preparedStatement = conexao.prepareStatement(querry);
            preparedStatement.setString('1', CPF);
            preparedStatement.setString('2', senha);

            System.out.print(querry);

            preparedStatement.executeUpdate();
            fechaConexao();

        }catch (SQLException E){
            E.getMessage();
        }
    }

}
