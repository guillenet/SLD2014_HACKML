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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author H3rn4n
 */
@Entity
@Table(name = "rubro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rubro.findAll", query = "SELECT r FROM Rubro r"),
    @NamedQuery(name = "Rubro.findByIdRubro", query = "SELECT r FROM Rubro r WHERE r.idRubro = :idRubro"),
    @NamedQuery(name = "Rubro.findByNombre", query = "SELECT r FROM Rubro r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Rubro.findByDescripcion", query = "SELECT r FROM Rubro r WHERE r.descripcion = :descripcion")})
public class Rubro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rubro")
    private Integer idRubro;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRubro")
    //private List<Local> localList;

    public Rubro() {
    }

    public Rubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
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

    /*@XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubro != null ? idRubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rubro)) {
            return false;
        }
        Rubro other = (Rubro) object;
        if ((this.idRubro == null && other.idRubro != null) || (this.idRubro != null && !this.idRubro.equals(other.idRubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Rubro[ idRubro=" + idRubro + " ]";
    }
    
}
