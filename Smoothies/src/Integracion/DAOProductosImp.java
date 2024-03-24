package Integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Negocio.TransferProducto;

public class DAOProductosImp implements DAOProductos {

	@Override
	public TransferProducto buscarProducto(String nombre, int id, int calorias) {

		TransferProducto tP = new TransferProducto();
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
		
	    try {
	    	// Registrar el driver de MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Conectar a la base de datos
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            String query = "SELECT * FROM ingredientes WHERE nombre = ?";
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            stmt.setString(1, nombre);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	tP.setNombre(rs.getString("nombre"));
	            	tP.setCalorias(rs.getInt("calorias"));
	            	tP.setId(rs.getInt("id"));

	                return tP;
	            } else {
	                return null;
	            }
	        }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error: no se pudo cargar el driver de MySQL");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("Error al conectar a la base de datos MySQL");
	        e.printStackTrace();
	    }
	    return tP;
	}

	@Override
	public boolean añadirProducto(String nombre, int id, int calorias) {

		TransferProducto tP = this.buscarProducto(nombre,id,calorias);
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
		
	    if (tP == null) { // significa que el cliente no existe
	        try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Conectar a la base de datos
	            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            	            	
	                String query = "INSERT INTO ingredientes (nombre ,id, calorias) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conexion.prepareStatement(query);
	                stmt.setString(1, nombre);
	                stmt.setInt(2, id);
	                stmt.setInt(3, calorias);
	             
	                int resultado = stmt.executeUpdate();
	                if (resultado > 0) {
	                    return true;
	                } else {
	                    return false;
	                }
	            }

	        } catch (ClassNotFoundException e) {
	            System.out.println("Error: no se pudo cargar el driver de MySQL");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Error al conectar a la base de datos MySQL");
	            e.printStackTrace();
	        }
	    }
		return false;
	}

	@Override
    public List<TransferProducto> sacarListaIngredientes() {
        List<TransferProducto> listaIngredientes = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/smoothies";
        String usuario = "root";
        String contraseña2 = "contraseñaSQL";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
            	
                String query = "SELECT * FROM ingredientes";
                PreparedStatement stmt = conexion.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    TransferProducto tP = new TransferProducto();
                    tP.setNombre(rs.getString("nombre"));
                    tP.setCalorias(rs.getInt("calorias"));
                    tP.setId(rs.getInt("id"));
                    listaIngredientes.add(tP);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no se pudo cargar el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL");
            e.printStackTrace();
        }
        return listaIngredientes;
    }

	
}
