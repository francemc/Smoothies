package integración;

import java.util.List;

import negocio.TransferProducto;
import negocio.TransferSmoothies;

public interface DAOSmoothies {

	public TransferSmoothies buscarSmoothies(String nombre,int id);
	
	public void añadirSmoothie(String nombre, List<TransferProducto> ingredientes, int id, int calorias);
	
	public List<TransferSmoothies> sacarListaSmoothies();
}
