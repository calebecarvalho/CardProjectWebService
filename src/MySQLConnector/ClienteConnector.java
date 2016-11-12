package MySQLConnector;

/**
 * Created by Calebe Lustosa on 10/11/2016.
 */
public class ClienteConnector {

    private int index;
    private String cpf;
    private String nome;
    private String senha;
    private String cep;
    private String end;
    private String email;
    private String telefone;
    private String celular;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "ClienteConnector{" +
                "index=" + index +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cep='" + cep + '\'' +
                ", end='" + end + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
