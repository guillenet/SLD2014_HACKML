/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author H3rn4n
 */
@Entity
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findByIdLocal", query = "SELECT l FROM Local l WHERE l.idLocal = :idLocal"),
    @NamedQuery(name = "Local.findByNombre", query = "SELECT l FROM Local l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Local.findByDescripcion", query = "SELECT l FROM Local l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Local.findByLocation", query = "SELECT l FROM Local l WHERE l.location = :location"),
    @NamedQuery(name = "Local.findByEsServicio", query = "SELECT l FROM Local l WHERE l.esServicio = :esServicio")})
public class Local implements Serializable {
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_local")
    private Integer idLocal;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "location")
    private String location;
    @Column(name = "esServicio")
    private Boolean esServicio;
    //@JoinTable(name = "pedido_local", joinColumns = {
    //    @JoinColumn(name = "id_local", referencedColumnName = "id_local")}, inverseJoinColumns = {
    //    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")})
    //@ManyToMany
    //private List<Pedido> pedidoList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocal")
    //private List<Vendedor> vendedorList;
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    @ManyToOne(optional = false)
    private Rubro rubro;

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
