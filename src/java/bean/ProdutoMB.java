package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import entity.Produto;

@ManagedBean(eager = true)
@ApplicationScoped 
public class ProdutoMB {
    
    private boolean novo ;
    private List<Produto> listaProdutos;
    private Produto clienteSelecionado;

    public ProdutoMB() {
        clienteSelecionado = new Produto();
        listaProdutos = new ArrayList<>();
    }

    public String novoProduto() {
        novo = true;
        clienteSelecionado = new Produto();
        return("/admin/formProdutos?faces-redirect=true");
    }

    public String editarProduto(Produto u) {
        clienteSelecionado = u;
        novo = false;
        return("/admin/formProdutos?faces-redirect=true");
    }
    
    public String salvarProduto() {
        if(novo) {
            listaProdutos.add(clienteSelecionado);
            clienteSelecionado = new Produto();
        } 
        novo = true;
        return("/admin/listaProdutos?faces-redirect=true");    
    }

    public void removerProduto(Produto cliente) {
        listaProdutos.remove(cliente);
    }

    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    public Produto getProdutoSelecionado() {
        return clienteSelecionado;
    }
    public void setProdutoSelecionado(Produto clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }    
    
    
}
