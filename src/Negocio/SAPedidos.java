package Negocio;

import java.util.List;

public interface SAPedidos {

	public boolean crearPedido(int idPedido,String batidos,int precio,int unidades,int idUsuario);
	boolean buscarPedido(int idPedido);
	List<TransferPedido> listaPedidos(String producto);
}
