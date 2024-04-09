package Negocio;

import java.security.NoSuchAlgorithmException;

import integración.DAOCliente;
import integración.FactoriaDAO;



public class SAClientesImp implements SAClientes {

	public boolean crearUsuario(String nombre, String correo, String contraseña, String idUsuario) {
		DAOCliente daoCliente = (DAOCliente) FactoriaDAO.getInstancia().nuevoDAOClientes();
		boolean ok = false;
		try {
			ok = daoCliente.registrarCliente(nombre, correo, contraseña, idUsuario);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return ok;
		
	}
	
	public boolean accesoCliente(String correo, String contraseña) {
		DAOCliente daoCliente = (DAOCliente) FactoriaDAO.getInstancia().nuevoDAOClientes();
		TransferCliente ok;
		try {
			ok = daoCliente.buscarCliente(correo);

			if(ok.getContraseña().equals(contraseña)) { 
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean borrarCliente(String correo, String contraseña) {
		DAOCliente daoCliente = (DAOCliente) FactoriaDAO.getInstancia().nuevoDAOClientes();
		boolean ok = false;
		try {
			ok = daoCliente.eliminarCliente(correo, contraseña);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;	
		
	}
}
