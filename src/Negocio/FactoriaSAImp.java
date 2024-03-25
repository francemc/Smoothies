package negocio;


public  class FactoriaSAImp extends FactoriaSA{
	public SAClientes nuevoSAClientes() {
		return new SAClientesImp();
	}

	@Override
	public SAProductos nuevoSAProducto() {
		return new SAProductosImp();
	}

	@Override
	public SASmoothies nuevoSASmoothies() {
		return new SASmoothiesImp();
	}
}