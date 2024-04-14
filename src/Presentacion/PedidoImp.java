package Presentacion;

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
		// TODO Auto-generated method stub
		
		if(getUnidades()==1) {
			setBatidos(""); // Limpiar la lista de batidos
	        setUnidades(0); // Reiniciar el número de unidades
		}else {
			// Buscar el ID del batido en la listaBatidos
	        String[] batidos = getBatidos().split(",");
	        boolean encontrado = false;
	        
	        for (int i = 0; i < batidos.length; i++) {
	            if (batidos[i].equals(idBatido)) {
	                // Eliminar el ID del batido de la lista
	                StringBuilder sb = new StringBuilder(getBatidos());
	                sb.delete(i * (idBatido.length() + 1), i * (idBatido.length() + 1) + idBatido.length()); // +1 para considerar la coma
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

}
