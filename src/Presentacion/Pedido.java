package Presentacion;

public abstract class Pedido {
	private static Pedido instancia = null;
	private String batidos="";
	private int precio = 0;
	private int unidades= 0;
	private int id;
	
	static public Pedido getInstancia() {
		if(instancia == null)
			instancia = new PedidoImp();
		return instancia;
	}
	
	public abstract void agregarProducto(String idBatido);
	public abstract void eliminarProducto(String idBatido);
	public abstract void vaciarCarrito();
	
	public int getUnidades() {
		return unidades;
	}

	public String getBatidos() {
		return batidos;
	}

	public void setBatidos(String batidos) {
		this.batidos = batidos;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
}
