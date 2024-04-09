package integración;

import java.util.List;

import Negocio.TransferPedido;
import Negocio.TransferProducto;

public interface DAOPedidos {

	public TransferPedido buscarPedido(String idPedido);
	public boolean crearPedido(int idPedido,String batidos,int precio, int unidades,int idUsuario);
	public List<TransferPedido> sacarListaPedidos(int idPedido);
	
}
