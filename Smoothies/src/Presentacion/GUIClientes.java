package Presentacion;

public abstract class GUIClientes {
    private static GUIClientes instancia = null;

    public static GUIClientes getInstancia(Controlador controlador) {
        if (instancia == null)
            instancia = new GUIClientesImp(controlador);
        return instancia;
    }

    public abstract void actualizar(int evento, Object datos);
}

