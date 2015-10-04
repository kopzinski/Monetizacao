package model;

public class Cliente {
    
    private String cpf;
    private String nome;
    private String email;
    private Conta conta;

    public Cliente() {
         conta = new Conta();
    }

    public Cliente(String nome, String cpf, String email, Conta conta) {
        this.nome = nome;        
        this.cpf = cpf;
        this.email = email;
        this.conta = conta;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}   