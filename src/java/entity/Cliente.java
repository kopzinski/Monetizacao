package entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return this.cpf == ((Cliente) o).cpf;
    }

    @Override
    public int hashCode() {
        return (int) cpf.hashCode() + nome.hashCode();
    }

}
