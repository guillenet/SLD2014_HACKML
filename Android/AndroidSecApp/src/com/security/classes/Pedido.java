package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPedido;
    private String titulo;
    private String descripcion;
    private Comprador idComprador;
    
    public ArrayList<Pedido> retrievePedidos(){
    	ArrayList<Pedido> response = new ArrayList<Pedido>();
    	for (int i = 0; i < 10; i++)
    	{
    		Pedido pedido = new Pedido();
    		Comprador comp = new Comprador();
    		pedido.setDescripcion("Description del pedido " + i);
    		pedido.setIdComprador(comp.retrieveCompradores().get(i%comp.retrieveCompradores().size()));
    		pedido.setIdPedido(new Integer(i));
    		pedido.setTitulo("Titulo del Pedido de Presupuesto " + i);
    		response.add(pedido);    		
    	}
        
    	return response;
    }

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*@XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }*/

    public Comprador getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Comprador idComprador) {
        this.idComprador = idComprador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
