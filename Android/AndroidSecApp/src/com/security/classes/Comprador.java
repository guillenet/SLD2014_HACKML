/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;


public class Comprador implements Serializable {
    private String mailMercado;
    private static final long serialVersionUID = 1L;
    private Integer idComprador;
    private String direccion;
    private String clientId;
    private String clientSecret;
    private Usuario idUsuario;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprador")
    //private List<Pedido> pedidoList;
    
    public ArrayList<Comprador> retrieveCompradores(){
    	Usuario user = new Usuario();
    	ArrayList<Comprador> response = new ArrayList<Comprador>();
    	for (int i = 0; i < 2; i++)
    	{
    		Comprador comp = new Comprador();
    		comp.setClientId("CLIENT_ID"+1);
    		comp.setClientSecret("CLIENT_SECRET"+i);
    		comp.setDireccion("Direccion del Comprador " + i);
    		comp.setIdComprador(new Integer(i));
    		comp.setIdUsuario(user.retrieveUsuarios().get(i));
    		response.add(comp);    		
    	}
    	return response;
    }

    public Comprador() {
    }

    public Comprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /*@XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprador != null ? idComprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprador)) {
            return false;
        }
        Comprador other = (Comprador) object;
        if ((this.idComprador == null && other.idComprador != null) || (this.idComprador != null && !this.idComprador.equals(other.idComprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Comprador[ idComprador=" + idComprador + " ]";
    }

    public String getMailMercado() {
        return mailMercado;
    }

    public void setMailMercado(String mailMercado) {
        this.mailMercado = mailMercado;
    }
    
}
