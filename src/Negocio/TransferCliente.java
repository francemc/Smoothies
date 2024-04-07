package negocio;

import integración.DAOClientesImp;

public class TransferCliente extends DAOClientesImp{

	protected String id;
	protected String correo;
	protected String contraseña;
	protected String nombre;
	
	public TransferCliente(){
		
	}
	public TransferCliente(String id, String nombre, String correo , String contraseña){
		this.id = id ; 
		this.nombre = nombre ; 
		this.correo = correo  ; 
		this.contraseña = contraseña; 
	}
	

	public String getContraseña() {
		return contraseña;
	}
	

}
