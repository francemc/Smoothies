package Presentacion;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Negocio.FactoriaSA;
import Negocio.SAClientes;
import Negocio.SAProductos;
import Negocio.SAProductosImp;
import Negocio.SASmoothies;
import Negocio.SASmoothiesImp;
import Negocio.TransferProducto;
import Negocio.TransferSmoothies;


public class ControladorImp extends Controlador{

	public void accion(int evento, Object datos) {
		
		switch (evento) {
		case (Eventos.CAMPOS_VACIOS): {
			JOptionPane.showMessageDialog(null, "Alg�n campo est� vacio");
			GUISmoothies.getInstancia(Controlador.getInstancia()).actualizar(Eventos.CLIENTES_LIMPIAR, null);
		}
		
		
		case (Eventos.AÑADIR_CLIENTE):{
			HashMap<String, String> ids = (HashMap<String, String>) datos;
			String nombre = new String(ids.get("nombre"));
			String correo = new String(ids.get("correo"));
			String contraseña = new String(ids.get("contraseña"));
			String idUsuario = new String(ids.get("idUsuario"));

			
			SAClientes saClientes = FactoriaSA.getInstancia().nuevoSAClientes();
			if(saClientes.crearUsuario(nombre, correo, contraseña, idUsuario)) {
				JOptionPane.showMessageDialog(null,"Usuario creado correctamente \n      id : "+ idUsuario);
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al crear el usuario");
			}
			GUISmoothies.getInstancia(Controlador.getInstancia()).actualizar(Eventos.AÑADIR_CLIENTE, null);
		}
		
		
		case (Eventos.INICIAR_SESION):{
			HashMap<String, String> ids = (HashMap<String, String>) datos;
			String correo = new String(ids.get("correo"));
			String contraseña = new String(ids.get("contraseña"));
			SAClientes saClientes = FactoriaSA.getInstancia().nuevoSAClientes();
			if(saClientes.accesoCliente(correo, contraseña)) {
				
				GUIClientes.getInstancia(Controlador.getInstancia(), datos).actualizar(Eventos.CLIENTE_REGISTRADO, datos);
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al cargar el usuario");
			}
		}
		
		case (Eventos.LISTA_INGREDIENTES):{
			
            SAProductos saProductos = new SAProductosImp();
            
            List<TransferProducto> listaIngredientes = saProductos.listaIngredientes();

            datos = listaIngredientes;
			
			break;
		}
	
		case (Eventos.ELIMINAR_CLIENTE):{
			
			HashMap<String, String> ids = (HashMap<String, String>) datos;
			String correo = new String(ids.get("correo"));
			String contraseña = new String(ids.get("contraseña"));
			SAClientes saClientes = FactoriaSA.getInstancia().nuevoSAClientes();

			if(saClientes.borrarCliente(correo, contraseña)) {
				JOptionPane.showMessageDialog(null, "Eliminado con exito");
			}else {
				JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");

			}
			break;
		}

		default: {
			break;
		}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public <T>List<T> devolverLista(String producto){
		
		if (producto == "ingredientes"){
			SAProductos saProductos = new SAProductosImp();
	        
	        List<TransferProducto> listaIngredientes = saProductos.listaIngredientes();
	        
	        return (List<T>) listaIngredientes;
		}
		else if(producto == "smoothies") {
			SASmoothies saSmoothies = new SASmoothiesImp();
			List<TransferSmoothies> listaSmoothies = saSmoothies.listaSmoothies();
			
			return (List<T>) listaSmoothies;
		}
		return null;
	}
	
	public String devolver_id(String objeto) {
		
		
		
		if(objeto == "idCliente") {
			 
		}
		else if(objeto == "batido") {
			
		}
		return null;
	}

}
