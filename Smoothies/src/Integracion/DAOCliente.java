package Integracion;

import java.security.NoSuchAlgorithmException;

import Negocio.TransferCliente;


public interface DAOCliente {
	public TransferCliente buscarCliente(String idCliente);
	public boolean registrarCliente(String nombre, String correo, String contraseña, String idCliente) throws NoSuchAlgorithmException;

}
