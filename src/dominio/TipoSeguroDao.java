package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";


	//obtenemos el listado de todos los tipos de seguros que hay 
	public ArrayList<TipoSeguro> obtenerTiposSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<TipoSeguro> lista = new ArrayList<TipoSeguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * FROM tiposeguros");
			
			while(rs.next()){
				
				TipoSeguro seguroRs = new TipoSeguro();
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
	public TipoSeguro obtenerTipoSeguro(String id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		TipoSeguro ts = new TipoSeguro();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * FROM tiposeguros WHERE IdTipo =" + id);
			
			while(rs.next()){

				ts.setIdTipo(rs.getInt("idTipo"));
				ts.setDescripcion(rs.getString("descripcion"));
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return ts;
	}
}
