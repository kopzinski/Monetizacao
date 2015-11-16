package entity;

public class Produto {
    
    private String codigo;
    private String nome;
    private String preco;

    public Produto() {
    }

    public Produto(String codigo, String nome, String preco) {
        this.nome = nome;        
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
}   