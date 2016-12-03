package MySQLConnector;

import java.sql.Date;

/**
 * Created by Calebe Lustosa on 14/11/2016.
 */
public class LancamentoConnector {

    private int index;
    private String numLancamento;
    private String data;
    private String hora;
    private String valor;
    private String numParcela;
    private int fatura;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNumLancamento() {
        return numLancamento;
    }

    public void setNumLancamento(String numLancamento) {
        this.numLancamento = numLancamento;
    }

    public String getData() {
        return data;
    }

    public int getFatura() {
        return fatura;
    }

    public void setFatura(int fatura) {
        this.fatura = fatura;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(String numParcela) {
        this.numParcela = numParcela;
    }

    @Override
    public String toString() {
        return "LancamentoConnector{" +
                "index=" + index +
                ", numLancamento='" + numLancamento + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", valor='" + valor + '\'' +
                ", numParcela='" + numParcela + '\'' +
                ", fatura=" + fatura +
                '}';
    }
}