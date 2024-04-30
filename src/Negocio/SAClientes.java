package Negocio;

public interface SAClientes {

	public boolean crearUsuario(TransferCliente cliente);
	public boolean accesoCliente(String correo, String contraseña);
	public boolean borrarCliente(String correo, String contraseña);
	public String buscarIdUsuario(String correo,String contraseña);
}
