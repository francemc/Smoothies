package Negocio;

import java.util.List;

public interface SAProductos {

	public boolean crearProducto(String nombre,int id, int calorias);
	boolean buscarProducto(String correo, int id, int calorias);
	List<TransferProducto> listaIngredientes(boolean especifico);
}
