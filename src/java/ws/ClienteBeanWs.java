package ws;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteBeanWs implements Serializable {
    
    private Long id;
    private String cpf;
    private String nome;
    private String email;

    public ClienteBeanWs() {
    }

    public ClienteBeanWs(String nome, String email, String cpf, Long id) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + '}';
    }

        
}
