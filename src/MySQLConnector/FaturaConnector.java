package MySQLConnector;
import java.util.ArrayList;
/**
 * Created by Calebe Lustosa on 12/11/2016.
 */
public class FaturaConnector{

    private int index;
    private String codFatura;
    private String dateAbert;
    private String dataFech;
    private boolean paga;
    private ArrayList<FaturaConnector> lancamentos;


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

    public String getDateAbert() {
        return dateAbert;
    }

    public void setDateAbert(String dateAbert) {
        this.dateAbert = dateAbert;
    }

    public String getDataFech() {
        return dataFech;
    }

    public void setDataFech(String dataFech) {
        this.dataFech = dataFech;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public ArrayList<FaturaConnector> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(ArrayList<FaturaConnector> lancamentos) {
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