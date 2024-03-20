package Integracion;

public class FactoriaDAOImp extends FactoriaDAO {
	
	
	public DAOCliente nuevoDAOClientes() {
		return new DAOClientesImp();
	}
	
}
