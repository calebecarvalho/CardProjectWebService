package MySQLTranslator;
import MySQLConnector.FaturaConnector;
import MySQLConnector.LancamentoConnector;
import java.sql.*;
import java.util.ArrayList;
/**
 * Created by CalebeLustosa on 14/11/2016.
 */
public class FaturaTranslator {

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

    public ArrayList<LancamentoConnector> recebeLancamentos (int lancamento){

        ArrayList<LancamentoConnector> lancamentos = null;

        if(conexao == null)
            preparaConexao();

        try {
            String querry = "SELECT lancamento.NumLancamento, lancamento.Data, lancamento.Valor, lancamento.NumParcelas\n"+
                    "JOIN estabelecimentos CodEstabelecimento on fk_CodEstabelecimento_ft = estabelecimentos.CodEstabelecimento\n"+
                    "WHERE fk_NumLancamento_fat = ?\n;";

            preparedStatement = conexao.prepareStatement(querry);
            preparedStatement.setInt('1', lancamento);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                lancamentos = new ArrayList<>();

                LancamentoConnector lancamentoConnector = new LancamentoConnector();

                do{
                    lancamentoConnector.setNumLancamento(resultSet.getString("numLancamento"));
                    lancamentoConnector.setData(resultSet.getDate("data"));
                    lancamentoConnector.setValor(resultSet.getString("valor"));
                    lancamentoConnector.setNumParcela(resultSet.getString("parcelas"));
                    lancamentoConnector.setIndex(resultSet.getInt("index"));
                }while (resultSet.next());
            }else fechaConexao();
                return lancamentos;

        }catch (SQLException E){
                E.getMessage();
        }
        fechaConexao();
        return lancamentos;
    }
    public ArrayList<FaturaConnector> recebeFatura (String NumCartao){

        ArrayList<FaturaConnector> faturas = null;

        if (conexao == null){
            preparaConexao();
        }
        try {
            String querry = "SELECT lancamento.NumLancamento, lancamento.Data, lancamento.Valor, lancamento,NumParcelas\n"+
                            "FROM lancamento lancamento\n"+
                            "JOIN estabelecimentos NumEstabelecimento ON estabelcimentos.NumEstabelecimento = fk_CodEstabelecimento_lan\n"+
                            "WHERE NumCartao = ?;";

            preparedStatement = conexao.prepareStatement(querry);
            preparedStatement.setString('1', NumCartao);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                faturas = new ArrayList<>();
                FaturaConnector faturaConnector = new FaturaConnector();

                do{
                    faturaConnector.setIndex(resultSet.getInt("index"));
                    faturaConnector.setCodFatura(resultSet.getString("codFatura"));
                    faturaConnector.setDataFech(resultSet.getDate("DataFech"));
                    faturaConnector.setDateAbert(resultSet.getDate("DataAbert"));
                    faturaConnector.setPaga(resultSet.getBoolean("paga"));
                    faturaConnector.setLancamentos(recebeLancamentos(faturaConnector.getIndex()));

                    faturas.add(faturaConnector);
                }while(resultSet.next());
            }else {
                fechaConexao();
                return faturas;
            }
        }catch (Exception E){
            E.getStackTrace();
        }
        fechaConexao();
        return faturas;
    }
}