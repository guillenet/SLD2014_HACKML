package com.security.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private Integer idUsuario;
    private String usrName;
    private String usrLogin;
    private Persona idPersona;
    
    public ArrayList<Usuario> retrieveUsuarios()
    {
    	Persona person = new Persona();
    	ArrayList<Usuario> response = new ArrayList<Usuario>();
    	for (int i = 0; i < 2; i++)
    	{
    		Usuario user = new Usuario();
    		user.setIdPersona(person.retrievePersonas().get(i));
    		user.setIdUsuario(new Integer(i));
    		user.setUsrLogin("PASS"+i);
    		user.setUsrName("USER"+i);
    		response.add(user);    		
    	}
    	return response;
    }
	
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    /*@XmlTransient
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }*/

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    /*@XmlTransient
    public List<Comprador> getCompradorList() {
        return compradorList;
    }

    public void setCompradorList(List<Comprador> compradorList) {
        this.compradorList = compradorList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
