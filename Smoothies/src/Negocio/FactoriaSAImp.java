package Negocio;


public  class FactoriaSAImp extends FactoriaSA{
	public SAClientes nuevoSAClientes() {
		return new SAClientesImp();
	}
}
