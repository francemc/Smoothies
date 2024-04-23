package integración;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Negocio.TransferPedido;

public class DAOPedidosImp implements DAOPedidos{

	@Override
	public TransferPedido buscarPedido(int idPedido) {

		TransferPedido tP = new TransferPedido();
		String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";
		
	    try {
	    	// Registrar el driver de MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Conectar a la base de datos
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            String query = "SELECT * FROM pedidos WHERE nombre = ?";
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            stmt.setInt(1, idPedido);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	tP.setIdPedido(rs.getInt("idPedido"));
	            	tP.setBatidos(rs.getString("batidos"));
	            	tP.setPrecio(rs.getInt("precio"));
	            	tP.setUnidades(rs.getInt("unidades"));
	            	tP.setIdUsuario(rs.getString("idUsuario"));	            } else {
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
	public boolean crearPedido(int idPedido, String batidos, int precio, int unidades, String idUsuario) {
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";

	    try {
	        // Registrar el driver de MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Conectar a la base de datos
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            // Preparar la consulta SQL para insertar el pedido
	            String query = "INSERT INTO pedidos (idPedido, batidos, precio, unidades, idUsuario) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            stmt.setInt(1, idPedido);
	            stmt.setString(2, batidos);
	            stmt.setInt(3, precio);
	            stmt.setInt(4, unidades);
	            stmt.setString(5, idUsuario);

	            // Ejecutar la consulta
	            int filasAfectadas = stmt.executeUpdate();
	            // Verificar si se insertó correctamente el pedido
	            if (filasAfectadas > 0) {
	                return true; // Se creó el pedido exitosamente
	            }
	        }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error: no se pudo cargar el driver de MySQL");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("Error al conectar a la base de datos MySQL");
	        e.printStackTrace();
	    }
	    return false; // No se pudo crear el pedido
	}


	@Override
	public List<TransferPedido> sacarListaPedidos(String idUsuario) {
	    List<TransferPedido> listaPedidos = new ArrayList<>();
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            String query = "SELECT * FROM pedidos WHERE idUsuario = ?";
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            stmt.setString(1, idUsuario);
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                TransferPedido tP = new TransferPedido();
	                tP.setIdPedido(rs.getInt("idPedido"));
	                tP.setBatidos(rs.getString("batidos"));
	                tP.setPrecio(rs.getInt("precio"));
	                tP.setUnidades(rs.getInt("unidades"));
	                tP.setIdUsuario(rs.getString("idUsuario"));
	                listaPedidos.add(tP);
	            }
	        }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error: no se pudo cargar el driver de MySQL");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("Error al conectar a la base de datos MySQL");
	        e.printStackTrace();
	    }
	    return listaPedidos;
	}

	@Override
	public List<TransferPedido> sacarTodosPedidos() {
	    List<TransferPedido> listaPedidos = new ArrayList<>();
	    String url = "jdbc:mysql://localhost:3306/smoothies";
	    String usuario = "root";
	    String contraseña2 = "contraseñaSQL";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña2)) {
	            String query = "SELECT * FROM pedidos"; 
	            PreparedStatement stmt = conexion.prepareStatement(query);
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                TransferPedido tP = new TransferPedido();
	                tP.setIdPedido(rs.getInt("idPedido"));
	                tP.setBatidos(rs.getString("batidos"));
	                tP.setPrecio(rs.getInt("precio"));
	                tP.setUnidades(rs.getInt("unidades"));
	                tP.setIdUsuario(rs.getString("idUsuario"));
	                listaPedidos.add(tP);
	            }
	        }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error: no se pudo cargar el driver de MySQL");
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("Error al conectar a la base de datos MySQL");
	        e.printStackTrace();
	    }
	    return listaPedidos;
	}


	
	

}
