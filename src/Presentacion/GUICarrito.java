package Presentacion;

import Negocio.TransferPedido;

public abstract class GUICarrito {
	private static GUICarrito instancia = null;
	private static Object datos = null;
	
    public static GUICarrito getInstancia(Controlador controlador,Object datos,TransferPedido pedido) {
        if (instancia == null)
            instancia = new GUICarritoImp(controlador,datos,pedido);
        return instancia;
    }

    public abstract void actualizar(int evento, Object datos);
}
