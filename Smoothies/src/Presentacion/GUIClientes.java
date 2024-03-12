package Presentacion;


public abstract class GUIClientes {
	private static GUIClientes instancia = null;

	public static GUIClientes getInstancia() {
		if (instancia == null)
			instancia = new GUIClientesImp();
		return instancia;
	}
	
	public abstract void actualizar(int evento, Object datos);
}
