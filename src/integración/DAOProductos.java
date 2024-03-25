package integración;

import java.util.List;

import negocio.TransferProducto;

public interface DAOProductos {
	public TransferProducto buscarProducto(String nombre,int id, int calorias);

	public boolean añadirProducto(String nombre,int id, int calorias);
	
	public List<TransferProducto> sacarListaIngredientes();
}
