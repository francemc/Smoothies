package Presentacion;

public abstract class GUIMenu {

	private static GUIMenu instancia = null;
	private static Object datos = null;
	public static GUIMenu getInstancia(Controlador controlador,Object datos ) {
		if(instancia == null) 
			instancia = new GUIMenuImp(controlador,datos);
		return instancia;	
		
	}
	
	public abstract void actualizar(int evento, Object datos);
}
