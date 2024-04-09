package Presentacion;

public abstract class GUICarrito {
	private static GUICarrito instancia = null;

    public static GUICarrito getInstancia(Controlador controlador) {
        if (instancia == null)
            instancia = new GUICarritoImp(controlador);
        return instancia;
    }

    public abstract void actualizar(int evento, Object datos);
}
