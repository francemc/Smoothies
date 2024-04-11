package Negocio;

import java.util.List;

import integración.DAOPedidos;
import integración.FactoriaDAO;

public class SAPedidosImp implements SAPedidos{

	@Override
	public boolean crearPedido(int idPedido, String batidos, int precio, int unidades, int idUsuario) {
		DAOPedidos daoPedidos = (DAOPedidos) FactoriaDAO.getInstancia().nuevoDAOPedidos();
		boolean ok = false;
		
		try {
			ok = daoPedidos.crearPedido(idPedido, batidos, precio, unidades, idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public boolean buscarPedido(int idPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TransferPedido> listaPedidos(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
