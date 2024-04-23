package integración;

import java.util.List;

import Negocio.TransferPedido;
import Negocio.TransferProducto;

public interface DAOPedidos {

	public TransferPedido buscarPedido(int idPedido);
	public boolean crearPedido(int idPedido,String batidos,int precio, int unidades,String idUsuario);
	public List<TransferPedido> sacarListaPedidos(String idUsuario);
	public List<TransferPedido> sacarTodosPedidos();
}
