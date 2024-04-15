package Presentacion;

import javax.swing.JOptionPane;

import Negocio.FactoriaSA;
import Negocio.SAPedidos;
import Negocio.TransferPedido;

public class PedidoImp extends Pedido {

	@Override
	public void agregarProducto(String idBatido) {
				
		if(getUnidades() != 0) {
			setBatidos(getBatidos() + ",");
		}
		setBatidos(getBatidos() + idBatido);
		
		setUnidades(getUnidades() + 1);
	}

	@Override
	public void eliminarProducto(String idBatido) {
	    if (getUnidades() == 1) {
	        setBatidos(""); // Limpiar la lista de batidos
	        setUnidades(0); // Reiniciar el número de unidades
	    } else {
	        // Buscar el ID del batido en la listaBatidos
	        String[] batidos = getBatidos().split(",");
	        boolean encontrado = false;

	        for (int i = 0; i < batidos.length; i++) {
	            if (batidos[i].equals(idBatido)) {
	                // Eliminar el ID del batido de la lista
	                StringBuilder sb = new StringBuilder(getBatidos());
	                if (i == 0) {
	                    // Si es el primer elemento, también eliminamos la coma después
	                    sb.delete(i * (idBatido.length() + 1), (i * (idBatido.length() + 1)) + idBatido.length() + 1);
	                } else {
	                    // Si es un elemento en medio o al final, eliminamos la coma anterior
	                    sb.delete((i * (idBatido.length() + 1)) - 1, (i * (idBatido.length() + 1)) + idBatido.length());
	                }
	                setBatidos(sb.toString());
	                encontrado = true;
	                break;
	            }
	        }

	        if (encontrado) {
	            setUnidades(getUnidades() - 1); // Decrementar el número de unidades si se eliminó un producto
	        }
	    }
	}


	@Override
    public void vaciarCarrito() {
        setBatidos(""); // Limpiar la lista de batidos
        setUnidades(0); // Reiniciar el número de unidades
    }

	@Override
	public void realizarPedido(int idPedido, String batidos, int cantidad, int precio, String idUsuario) {
		SAPedidos saPedidos = FactoriaSA.getInstancia().nuevoSAPedidos();
		
		if(saPedidos.crearPedido(idPedido, batidos, precio, cantidad, idUsuario)) {
			JOptionPane.showMessageDialog(null, "Exito al crear el pedido");
		}else {
			JOptionPane.showMessageDialog(null, "Error al crear el pedido");

		}
		
		
		
	}

}
