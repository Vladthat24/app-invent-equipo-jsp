package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dominio.Marca;

public class MarcaDaoJDBC {
	private static final String SQL_SELECT_MARCA="select * from marca";
	
	 public List<Marca> listar(){
	     Connection conn=null;
	     PreparedStatement stmt=null;
	     ResultSet rs=null;
	     List<Marca> marcas= new ArrayList<Marca>();
	     
	     try {
	         conn=Conexion.getConnection();
	         stmt=conn.prepareStatement(SQL_SELECT_MARCA);
	         rs=stmt.executeQuery();
	         while (rs.next()) {             
	             int idMarca=rs.getInt("idmarca");
	             String codigo=rs.getString("codigo");
	             String descripcion=rs.getString("descripcion");
	             System.out.println(idMarca+" "+codigo+" "+descripcion);
	             
	             marcas.add(new Marca(idMarca, codigo, descripcion));
	         }
	         
	     } catch (Exception e) {
	         e.printStackTrace(System.out);
	     }finally{
	         Conexion.Close(rs);
	         Conexion.Close(stmt);
	         Conexion.Close(conn);
	                 
	     }
	     
	     return marcas;
	 }
}
