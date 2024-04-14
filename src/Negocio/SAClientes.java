package Negocio;

public interface SAClientes {

	public boolean crearUsuario(String nombre, String correo, String contraseña, String idUsuario);
	public boolean accesoCliente(String correo, String contraseña);
	public boolean borrarCliente(String correo, String contraseña);
	public String buscarIdUsuario(String correo,String contraseña);
}
