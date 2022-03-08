import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private Conta Conta;

    public Cliente(String nome, String cpf, Conta conta) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setConta(conta);
    }

    public Conta getConta() {
        return Conta;
    }

    public void setConta(Conta contas) {
        this.Conta = contas;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
