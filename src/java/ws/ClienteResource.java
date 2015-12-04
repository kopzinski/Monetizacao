package ws;

import dao.ClienteDaoJpa;
import entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("clientes")
public class ClienteResource {
    
    
    private ClienteDaoJpa dao;

    @Context
    private UriInfo context;

    public ClienteResource() {}

    @GET
    @Produces("application/json")
    public List<ClienteBeanWs> getClientes() {
        System.out.println("Kop! hahahaha");
        dao = new ClienteDaoJpa();
        List<ClienteBeanWs> l = new ArrayList<>();        
        List<Cliente> listar = dao.listar();
        for (Cliente cliente : listar) {
            l.add(new ClienteBeanWs(cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getId()));   
        }
        
        return(l);
    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String adicionarCliente(Cliente cliente) {
        dao = new ClienteDaoJpa();
        dao.salvar(cliente);
        return "OK";
    }
}
