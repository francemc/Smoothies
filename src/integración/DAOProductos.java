package integración;

import java.util.List;

import Negocio.TransferProducto;

public interface DAOProductos {
	public TransferProducto buscarProducto(String nombre);

	public boolean añadirProducto(String nombre,int id, int calorias);
	
	public List<TransferProducto> sacarListaIngredientes(boolean especifico);
	public boolean cambiarEstado(String nombre, boolean disponibilidad); 
}
