package com.security.classes;


import java.io.Serializable;

import java.util.ArrayList;
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVendedor;
    private Local idLocal;
    private Usuario idUsuario;
    
    public ArrayList<Vendedor> retrieveVendedor()
    {
    	ArrayList<Vendedor> response = new ArrayList<Vendedor>();
    	for (int i = 0; i < 2; i++)
    	{
    		Vendedor vendedor = new Vendedor();
    		Local local = new Local();
    		Usuario user = new Usuario();
    		vendedor.setIdLocal(local.retrieveLocales().get(i%local.retrieveLocales().size()));
    		vendedor.setIdUsuario(user.retrieveUsuarios().get(i));
    		vendedor.setIdVendedor(new Integer(i));
    		response.add(vendedor);    		
    	}
    	return response;
    }

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    /*@XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }*/

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Vendedor[ idVendedor=" + idVendedor + " ]";
    }
    
}
