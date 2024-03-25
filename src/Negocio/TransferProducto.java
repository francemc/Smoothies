package negocio;

import integración.DAOProductosImp;

public class TransferProducto extends DAOProductosImp{

	protected String nombre;
	protected int id;
	protected int calorias;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCalorias() {
		return calorias;
	}
	
	
}
