package Presentacion;

public abstract class GUICarrito {
	private static GUICarrito instancia = null;
	private static Object datos = null;
	
    public static GUICarrito getInstancia(Controlador controlador,Object datos) {
        if (instancia == null)
            instancia = new GUICarritoImp(controlador,datos);
        return instancia;
    }

    public abstract void actualizar(int evento, Object datos);
}
