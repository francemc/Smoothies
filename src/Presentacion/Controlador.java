package presentacion;

import java.util.List;

import negocio.TransferProducto;

public abstract class Controlador {
	private static Controlador instancia = null;

	static public Controlador getInstancia() {
		if (instancia == null)
			instancia = new ControladorImp();
		return instancia;
	} // Patr�n Singleton!!!
	
	public abstract void accion(int evento, Object datos);
	public abstract <T>List<T> devolverLista(String producto); //programación genérica
}