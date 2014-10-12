package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {
  
    private Integer idPersona;
    private String nombre;
    private String apellido;
    
    public ArrayList<Persona> retrievePersonas()
    {
    	ArrayList<Persona> response = new ArrayList<Persona>();
    	for (int i = 0; i < 2; i++)
    	{
    		Persona persona = new Persona();
    		persona.setApellido("Apellido Persona " + i+1);
    		persona.setNombre("Nombre " + i+1);
    		persona.setIdPersona(new Integer(i));
    		response.add(persona);    		
    	}
    	return response;
    }

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /*@XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Persona[ idPersona=" + idPersona + " ]";
    }


    
}
