package com.mpago.domain;

public class Item {
	
	private String _descripcion;
	private String _precio;
	
	public Item(String desc, String precio) {
		setDescripcion(desc);
		setPrecio(precio);
	}
	
	public String getDescripcion() {
		return _descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}
	
	public String getPrecio() {
		return _precio;
	}
	
	public void setPrecio(String precio) {
		_precio = precio;
	}
	
	

}
