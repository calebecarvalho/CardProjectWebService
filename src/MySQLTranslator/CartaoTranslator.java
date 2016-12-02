package MySQLTranslator;
import MySQLConnector.CardConnector;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by CalebeLustosa on 14/11/2016.
 */
public class CartaoTranslator {

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
    public ArrayList<CardConnector> recebeCartoes(String CPF) throws Exception{
        if (CPF == null)
            throw new Exception("CPF não pode ser nulo");

        ArrayList<CardConnector> cartoes = null;

        if(conexao == null)
            preparaConexao();

        try {
            String querry = "SELECT cartis.index, catis.NumCartao, cartis.NumCartao, cartis.Senha, catis.Bandeira, cartis.Validade, cartis.Limite, cartis.Bloqueado FROM cartoes cartao\n"+
                            "JOIN conta NumConta on fk_NumConta_ct = numConta.id\n"+
                            "JOIN cliente CPF on fk_CPF_ct = cliente.id\n"+
                            "WHERE cliente.CPF = ?;";



            preparedStatement = conexao.prepareStatement(querry);
            preparedStatement.setString(1, CPF);
            ResultSet resultado = preparedStatement.executeQuery();

            if(resultado.next()){
                cartoes = new ArrayList<>();
                CardConnector conector;
                do{
                    conector = new CardConnector();
                    conector.setIndex(resultado.getInt("index"));
                    conector.setNumCartao(resultado.getString("NumCartao"));
                    conector.setCodSeg(resultado.getString("CodSeg"));
                    conector.setSenha(resultado.getString("Senha"));
                    conector.setBandeira(resultado.getString("Bandeira"));
                    conector.setValidade(resultado.getString("Validade"));
                    conector.setLimite(resultado.getString("Limite"));
                    conector.setBloq(resultado.getBoolean("Bloqueado"));

                    cartoes.add(conector);
                }while (resultado.next());
            }
            else{
                fechaConexao();
                return cartoes;
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        fechaConexao();
        return  cartoes;
    }
    public boolean bloqueado(String NumCartao){
        if(conexao == null)
            preparaConexao();

        try {

            String querry = "SELECT Bloqueado FROM cartoes WHERE NumCartao = ?";
                    preparedStatement = conexao.prepareStatement(querry);
                    preparedStatement.setString(1, NumCartao);

            ResultSet resultado = preparedStatement.executeQuery();

            if (resultado.next()){
                if (resultado.getBoolean("Bloqueado"))
                {
                    fechaConexao();
                    return true;
                }
            }
            else {
                fechaConexao();
                return false;
            }
            fechaConexao();
            return false;

        }catch (Exception E){
            E.printStackTrace();
        }
        fechaConexao();
        return false;
    }
    public boolean bloquear(String NumCartao){
        if(!bloqueado(NumCartao))
            return false;

        if (conexao == null)
            preparaConexao();

        try {
            String querry = "UPDATE cartoes SET bloqueado = 0 WHERE NumCartao = ?";

             preparedStatement = conexao.prepareStatement(querry);
            preparedStatement.setString(1, NumCartao);

            int ps = preparedStatement.executeUpdate();
            if(ps > 0)
                fechaConexao();
                return true;
        }catch (Exception E){
            E.printStackTrace();
        }
        fechaConexao();
        return false;

    }






}