package integración;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Negocio.TransferCliente;

public class DAOClientesImp implements DAOCliente{

	@Override
	public TransferCliente buscarCliente(String correo) {
		TransferCliente tE = new TransferCliente() ; 
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
	    
	    try {
	    	// Registrar el driver de MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Conectar a la base de datos
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            String query = "SELECT * FROM usuario WHERE correo = ?";
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            stmt.setString(1, correo);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	tE = new TransferCliente(rs.getString("idUsuario"),rs.getString("nombre"),rs.getString("correo"),rs.getString("password"));
	                return tE;
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
	    return tE;
	}

	@Override
	public boolean registrarCliente(String nombre, String correo, String contraseña,String idCliente) throws NoSuchAlgorithmException {
		TransferCliente tE;
	    tE = this.buscarCliente(correo);
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
	    if (tE == null) { // significa que el cliente no existe
	        try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Conectar a la base de datos
	            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            	            	
	                String query = "INSERT INTO usuario (idUsuario ,nombre, correo, password) VALUES (?, ?, ?, ?)";
	                PreparedStatement stmt = conexion.prepareStatement(query);
	                stmt.setString(1, idCliente);
	                stmt.setString(2, nombre);
	                stmt.setString(3, correo);
	                stmt.setString(4, contraseña);
	             
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
	public boolean eliminarCliente(String correo, String contraseña) {
		TransferCliente tE;
	    tE = this.buscarCliente(correo);
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
	    
	    if (tE == null) { // significa que el cliente no existe
	    	try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Conectar a la base de datos
	            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            	            	
	                String query = "DELETE FROM usuario WHERE correo = ? AND password = ?";
	                PreparedStatement stmt = conexion.prepareStatement(query);
	                stmt.setString(1, correo);
	                stmt.setString(2, contraseña);
	             
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

}
