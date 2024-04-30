package integración;

import java.security.NoSuchAlgorithmException;

import Negocio.TransferCliente;


public interface DAOCliente {
	public TransferCliente buscarCliente(String idCliente);
	public boolean registrarCliente(TransferCliente cliente) throws NoSuchAlgorithmException;
	public boolean eliminarCliente(String correo, String contraseña);
}
