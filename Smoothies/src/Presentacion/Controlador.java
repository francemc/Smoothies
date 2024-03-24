package Presentacion;

import java.util.List;

import Negocio.TransferProducto;

public abstract class Controlador {
	private static Controlador instancia = null;

	static public Controlador getInstancia() {
		if (instancia == null)
			instancia = new ControladorImp();
		return instancia;
	} // Patr�n Singleton!!!
	
	public abstract void accion(int evento, Object datos);
	public abstract List<TransferProducto> devolverLista(String producto);
}
