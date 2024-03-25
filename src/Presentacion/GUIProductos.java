package presentacion;

public abstract class GUIProductos {

	private static GUIProductos instancia = null;
	
	public static GUIProductos getInstancia(Controlador controlador) {
		if(instancia == null) 
			instancia = new GUIProductosImp(controlador);
		return instancia;
	}
	
	public abstract void actualizar(int evento, Object datos);
}
