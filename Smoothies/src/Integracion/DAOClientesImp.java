package Integracion;

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
	    TransferCliente tE = new TransferCliente();
	    String url = "jdbc:mysql://localhost:3306/base_datos";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
	    
	    try {
	    	// Registrar el driver de MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Conectar a la base de datos
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            String query = "SELECT * FROM Usuarios WHERE Correo = ?";
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            stmt.setString(1, correo);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                tE.setId(rs.getString("idUsuarios"));
	                tE.setNombre(rs.getString("nombre"));
	                tE.setCorreo(rs.getString("correo"));
	                tE.setContraseña(rs.getString("contraseña"));
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
	    String url = "jdbc:mysql://localhost:3306/base_datos";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
	    if (tE == null) { // significa que el cliente no existe
	        try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Conectar a la base de datos
	            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            	            	
	                String query = "INSERT INTO Usuarios (idUsuarios,nombre, correo, contraseña) VALUES (?, ?, ?, ?)";
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

}
