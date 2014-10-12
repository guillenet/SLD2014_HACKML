package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Rubro implements Serializable {
    private static final long serialVersionUID = 1L;
	
    private Integer idRubro;
    private String nombre;
    private String descripcion;

    public ArrayList<Rubro> retrieveRubros()
    {
    	ArrayList<Rubro> response = new ArrayList<Rubro>();
    	for (int i = 0; i < 4; i++)
    	{
    		Rubro rubro = new Rubro();
    		rubro.setIdRubro(new Integer(i));
    		rubro.setDescripcion("Descripcion del rubro " + i);
    		rubro.setNombre("Rubro Numero" + i);
    		response.add(rubro);    		
    	}
    	return response;
    }
    
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
