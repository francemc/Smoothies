package Integracion;

public class FactoriaDAOImp extends FactoriaDAO {
	
	
	public DAOCliente nuevoDAOClientes() {
		return new DAOClientesImp();
	}

	@Override
	public DAOProductos nuevoDAOProductos() {
		return new DAOProductosImp();
	}

	@Override
	public DAOSmoothies nuevoDAOSmoothies() {
		return new DAOSmoothiesImp();
	}
}
