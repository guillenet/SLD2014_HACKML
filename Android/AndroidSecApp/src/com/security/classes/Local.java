package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;


public class Local implements Serializable {
    private byte[] imagen;
    private String clientId;
    private String clientSecret;
    private static final long serialVersionUID = 1L;
    private Integer idLocal;
    private String nombre;
    private String descripcion;
    private String location;
    private Boolean esServicio;
    //@JoinTable(name = "pedido_local", joinColumns = {
    //    @JoinColumn(name = "id_local", referencedColumnName = "id_local")}, inverseJoinColumns = {
    //    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")})
    //@ManyToMany
    //private List<Pedido> pedidoList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocal")
    //private List<Vendedor> vendedorList;
    private Rubro rubro;
	public ArrayList<Local> retrieveLocales()
	{
		Rubro rubro = new Rubro();
		ArrayList<String> positions = new ArrayList<String>();
		positions.add("-33.274315, -66.300595");
		positions.add("-33.287213, -66.340611");
		positions.add("-33.318109, -66.312684");
		positions.add("-33.315499, -66.365931");
		positions.add("-33.292633, -66.328009");
		positions.add("-33.285687, -66.349331");
		positions.add("-33.303995, -66.330438");
		positions.add("-33.285068, -66.287319");
		positions.add("-33.292570, -66.306352");
		positions.add("-33.303995, -66.300595");
		
		ArrayList<Local> response = new ArrayList<Local>();
    	for (int i = 0; i < 10; i++)
    	{
    		Local local = new Local();
    		local.setClientId("CLIENT_ID"+i);
    		local.setClientSecret("9870"+i);
        	local.setDescripcion("Local " + i);
        	local.setEsServicio(true);
        	local.setIdLocal(new Integer(i));
        	local.setLocation(positions.get(i));
        	local.setNombre("LOCAL " + i);
        	local.setRubro(rubro.retrieveRubros().get(i%rubro.retrieveRubros().size()));
    		response.add(local);    		
    	}
        
    	return response;
	}

    public Local() {
    }

    public Local(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getEsServicio() {
        return esServicio;
    }

    public void setEsServicio(Boolean esServicio) {
        this.esServicio = esServicio;
    }

    /*@XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }*/

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
    public Integer getIdRubro() {
        return rubro.getIdRubro();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocal != null ? idLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Local[ idLocal=" + idLocal + " ]";
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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
    
}
