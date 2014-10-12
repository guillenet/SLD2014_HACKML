/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import clases.Presupuesto;
import com.mpago.checkout.Payment;
import com.mpago.domain.Item;
import com.mpago.domain.PaymentRequest;
import com.mpago.domain.Transaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author H3rn4n
 */
@Stateless
@Path("clases.mpago")
public class mercadoPagoFacadeREST {
    
    
    @GET
    @Path("{mail}")
    @Produces({"application/json", "application/json"})
    public List<Transaction> findLastPayment(@PathParam("mail") String mail) {
        try {
            Payment p = new Payment(new PaymentRequest());
            return p.retrieveLastTransactions("mail");
        } catch (JSONException ex) {
            Logger.getLogger(mercadoPagoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(mercadoPagoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Consumes({"application/json", "application/json"})
    public String payment(Presupuesto presupuesto){
        Payment p = new Payment(new PaymentRequest());
        Item i = new Item(presupuesto.getTitulo(),presupuesto.getMonto().toString());
        
        return p.performPayment(i);
    }
    
    @GET
    @Path("getPay")
    public String getPayment(){
        PaymentRequest pr = new PaymentRequest();
        pr.setPayerEmail("hernanfsantiago@hotmail.com");
        Payment p = new Payment(pr);
        Item i = new Item("Servicios de Jardineria","220.50");
        
        return p.performPayment(i);
    }
}
