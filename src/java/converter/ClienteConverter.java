/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import bean.MonetizacaoMB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Cliente;

/**
 *
 * @author kopzinski
 */
    @FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        MonetizacaoMB bean = context.getApplication().evaluateExpressionGet(context, "#{monetizacaoMB}", MonetizacaoMB.class);
        Cliente cliente = bean.findClienteByCpf(value);
        return cliente;        
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cliente) {
            
            Cliente entity= (Cliente) value;
            
            if(entity == null) {
                System.out.println("Kop! entity esta NULO");
            }
            
            if (entity != null && entity instanceof Cliente && entity.getNome()!= null) {
                component.getAttributes().put( entity.getNome().toString(), entity);
                System.out.println("Kop! temos o toString..."+ entity.getNome().toString()  );
                return entity.getNome().toString();
            } 
        }
        return "";
    }
    
}
