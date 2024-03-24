package Integracion;

import java.util.List;

import Negocio.TransferProducto;

public interface DAOProductos {
	public TransferProducto buscarProducto(String nombre,int id, int calorias);

	public boolean añadirProducto(String nombre,int id, int calorias);
	
	public List<TransferProducto> sacarListaIngredientes();
}
