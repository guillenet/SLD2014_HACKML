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
@Table(name = "comprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c"),
    @NamedQuery(name = "Comprador.findByIdComprador", query = "SELECT c FROM Comprador c WHERE c.idComprador = :idComprador"),
    @NamedQuery(name = "Comprador.findByDireccion", query = "SELECT c FROM Comprador c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Comprador.findByClientId", query = "SELECT c FROM Comprador c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Comprador.findByClientSecret", query = "SELECT c FROM Comprador c WHERE c.clientSecret = :clientSecret")})
public class Comprador implements Serializable {
    @Column(name = "mailMercado")
    private String mailMercado;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprador")
    private Integer idComprador;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprador")
    //private List<Pedido> pedidoList;

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
