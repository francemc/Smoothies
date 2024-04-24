package Negocio;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import integración.DAOProductos;
import integración.FactoriaDAO;

public class SAProductosImp implements SAProductos {

	@Override
	public boolean crearProducto(String nombre, int id, int calorias) {
		DAOProductos daoProductos = (DAOProductos) FactoriaDAO.getInstancia().nuevoDAOProductos();
		
		boolean ok = false;
		
		try {
			ok = daoProductos.añadirProducto(nombre, id, calorias);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public boolean buscarProducto(String correo, int id, int calorias) {
		DAOProductos daoProductos = (DAOProductos) FactoriaDAO.getInstancia().nuevoDAOProductos();
		TransferProducto ok;
		
		try {
			ok = daoProductos.buscarProducto(correo, id, calorias);
			if (ok != null) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<TransferProducto> listaIngredientes(boolean especifico) {
        DAOProductos daoProductos = FactoriaDAO.getInstancia().nuevoDAOProductos();
        List<TransferProducto> listaIngredientes = null;

        try {
            listaIngredientes = daoProductos.sacarListaIngredientes(especifico);
        } catch (Exception e) {
            e.printStackTrace();
        }      
        return listaIngredientes;	
    }

}
