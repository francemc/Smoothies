package Presentacion;

public abstract class GUIMenu {

	private static GUIMenu instancia = null;
	
	public static GUIMenu getInstancia(Controlador controlador ) {
		if(instancia == null) 
			instancia = new GUIMenuImp(controlador);
		return instancia;	
		
	}
	
	public abstract void actualizar(int evento, Object datos);
}
