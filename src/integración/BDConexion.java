package integración;
import java.sql.*;
public class BDConexion { 
	/**Parametros de conexion**/ // Aun me falta decifrar que funcione ...
	
	static String bd       ; // ="cliente" 
	static String login     ;// = "XYZ
	static String password  ; //= "ABC"
	static String url    ; // = "jbc:mysql://localhost/ "+bd 
	
   Connection connection = null; 
	public BDConexion() { 
		try { 
			//  String url = " jdbc : mysql :// hostname / database - name "; 
			connection = DriverManager.getConnection (url,login,password);
			} 
		catch ( SQLException ex) { 
			connection = null ;
			ex. printStackTrace (); 
			System.out.println (" SQLException : " + ex. getMessage ());
			System.out.println (" SQLState : " + ex. getSQLState ()); 
			System.out.println (" VendorError : " + ex. getErrorCode ()); 
			}
		} 
	public Connection getConnection(){ 
		return connection;
		} 
	public void desconectar(){ 
		connection = null; 
		} 
	}
