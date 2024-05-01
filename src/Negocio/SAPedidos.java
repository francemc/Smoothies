package Negocio;

import java.util.List;

public interface SAPedidos {

	public boolean crearPedido(TransferPedido pedido);
	boolean buscarPedido(int idPedido);
	List<TransferPedido> listaPedidos(String producto);
	List<TransferPedido> listaTodosPedidos();
}
