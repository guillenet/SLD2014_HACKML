/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import clases.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author H3rn4n
 */
@Stateless
@Path("clases.pedido")
public class PedidoFacadeREST extends AbstractFacade<Pedido> {
    public PedidoFacadeREST() {
        super(Pedido.class);
    }

    @POST
    @Override
    @Consumes({"application/json", "application/json"})
    public void create(Pedido entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/json", "application/json"})
    public void edit(Pedido entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json", "application/json"})
    public Pedido find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json", "application/json"})
    public List<Pedido> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json", "application/json"})
    public List<Pedido> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
}
