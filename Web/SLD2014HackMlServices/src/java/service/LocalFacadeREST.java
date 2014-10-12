/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import clases.Local;
import java.util.AbstractMap;
import java.util.List;
import java.util.Vector;
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
@Path("clases.local")
public class LocalFacadeREST extends AbstractFacade<Local> {
    public LocalFacadeREST() {
        super(Local.class);
    }

    @POST
    @Override
    @Consumes({"application/json", "application/json"})
    public void create(Local entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/json", "application/json"})
    public void edit(Local entity) {
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
    public Local find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json", "application/json"})
    public List<Local> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json", "application/json"})
    public List<Local> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("byFilter/{from}/{to}")
    @Produces({"application/json", "application/json"})
    @Consumes({"application/json", "application/json"})
    public List<Local> findByFilterTo(Local t,@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<AbstractMap.SimpleEntry<String,String>> listParameters = new Vector<AbstractMap.SimpleEntry<String, String>>();
        
        if(t.getIdLocal() != null){
            if(t.getIdLocal() != 0){
                listParameters.add(new AbstractMap.SimpleEntry<String, String>("idLocal",t.getIdLocal().toString()));
            }
        }
        if(t.getIdRubro() != null){
            if(t.getIdRubro()!= 0){
                listParameters.add(new AbstractMap.SimpleEntry<String, String>("idRubro",t.getIdRubro().toString()));
            }
        }
        if(t.getNombre() != null){
            if(!t.getNombre().equals("")){
                listParameters.add(new AbstractMap.SimpleEntry<String, String>("idNombre",t.getNombre().toString()));
            }
        }
        
        //return super.findByListMapRange(listParameters, new int[]{from, to});
        return super.findByListMapRange(listParameters,new int[]{from, to});
    }
    
    @POST
    @Path("byFilter")
    @Produces({"application/json", "application/json"})
    @Consumes({"application/json", "application/json"})
    public List<Local> findByFilter(Local t) {
        List<AbstractMap.SimpleEntry<String,String>> listParameters = new Vector<AbstractMap.SimpleEntry<String, String>>();
        
        if(t.getIdLocal() != null){
            if(t.getIdLocal() != 0){
                listParameters.add(new AbstractMap.SimpleEntry<String, String>("idLocal",t.getIdLocal().toString()));
            }
        }
        if(t.getIdRubro() != null){
            if(t.getIdRubro()!= 0){
                listParameters.add(new AbstractMap.SimpleEntry<String, String>("idRubro",t.getIdRubro().toString()));
            }
        }
        if(t.getNombre() != null){
            if(!t.getNombre().equals("")){
                listParameters.add(new AbstractMap.SimpleEntry<String, String>("idNombre",t.getNombre().toString()));
            }
        }
        
        //return super.findByListMapRange(listParameters, new int[]{from, to});
        return super.findByListMap(listParameters);
    }
}
