package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;


public class Presupuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPresupuesto;
    private String titulo;
    private String presupuesto;
    private Double monto;
    private Pedido idPedido;
    private Vendedor idVendedor;

    public Presupuesto() {
    }
    
    public ArrayList<Presupuesto> retrievePresupuestos()
    {
    	ArrayList<Presupuesto> response = new ArrayList<Presupuesto>();
    	for (int i = 0; i < 20; i++)
    	{
    		Pedido pedido = new Pedido();
    		Vendedor vendedor = new Vendedor();
    		Presupuesto presupuesto = new Presupuesto();
    		presupuesto.setIdPedido(pedido.retrievePedidos().get(i%pedido.retrievePedidos().size()));
    		presupuesto.setIdPresupuesto(new Integer(i));
    		presupuesto.setIdVendedor(vendedor.retrieveVendedor().get(i%vendedor.retrieveVendedor().size()));
    		presupuesto.setMonto(new Double((i + 1) + 200d));
    		presupuesto.setPresupuesto("Detalle del presupuesto nro " + i);
    		presupuesto.setTitulo("Titulo del presupuesto nro " + i);
    		response.add(presupuesto);    		
    	}
    	return response;
    }

    public Presupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Presupuesto[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
