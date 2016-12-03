package MySQLConnector;
import java.sql.Date;
import java.util.ArrayList;
/**
 * Created by Calebe Lustosa on 12/11/2016.
 */
public class FaturaConnector{

    private int index;
    private String codFatura;
    private Date dateAbert;
    private Date dataFech;
    private boolean paga;
    private ArrayList<LancamentoConnector> lancamentos;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCodFatura() {
        return codFatura;
    }

    public void setCodFatura(String codFatura) {
        this.codFatura = codFatura;
    }

    public Date getDateAbert() {
        return dateAbert;
    }

    public void setDateAbert(Date dateAbert) {
        this.dateAbert = dateAbert;
    }

    public Date getDataFech() {
        return dataFech;
    }

    public void setDataFech(Date dataFech) {
        this.dataFech = dataFech;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public ArrayList<LancamentoConnector> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(ArrayList<LancamentoConnector> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @Override
    public String toString() {
        return "FaturaConnector{" +
                "index=" + index +
                ", codFatura='" + codFatura + '\'' +
                ", dateAbert='" + dateAbert + '\'' +
                ", dataFech='" + dataFech + '\'' +
                ", paga=" + paga +
                '}';
    }
}