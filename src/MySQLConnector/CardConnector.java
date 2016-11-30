package MySQLConnector;

/**
 * Created by Calebe Lustosa on 10/11/2016.
 */

public class CardConnector {

    private  int index;
    private String numCartao;
    private String codSeg;
    private String senha;
    private String bandeira;
    private String limite;
    private String validade;
    private boolean internacional;
    private boolean bloq;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String  getNumCartao(){
        return numCartao;
    }

    public void setNumCartao(String numCartao){
        this.numCartao = numCartao;
    }

    public String getCodSeg(){
        return codSeg;
    }

    public void setCodSeg(String codSeg){
        this.codSeg = codSeg;
    }

    public String getBandeira(){
        return bandeira;
    }

    public void setBandeira(String bandeira){
        this.bandeira = bandeira;
    }

    public String getLimite(){
        return limite;
    }

    public void setLimite(String limite){
        this.limite = limite;
    }

    public String getValidade(){
        return validade;
    }

    public void setValidade(String validade){
        this.validade = validade;
    }

    public boolean isInternacional(){
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    public boolean isBloq() {
        return bloq;
    }

    public void setBloq(boolean bloq) {
        this.bloq = bloq;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString(){
        return "CardConnector{ " +
                "index = " + index +
                "numCartao = " + numCartao +
                "codSeg = " + codSeg +
                "bandeira = " + bandeira +
                "validade = " + validade +
                "internacional = " + internacional +
                "bloq = " + bloq +
                "}";
    }
}
