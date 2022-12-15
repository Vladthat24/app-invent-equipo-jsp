package datos;

import dominio.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaisDaoJDBC {
	private static final String SQL_SELECT_PAIS="select * from pais";
	
	 public List<Pais> listar(){
	     Connection conn=null;
	     PreparedStatement stmt=null;
	     ResultSet rs=null;
	     List<Pais> paiss= new ArrayList<Pais>();
	     
	     try {
	         conn=Conexion.getConnection();
	         stmt=conn.prepareStatement(SQL_SELECT_PAIS);
	         rs=stmt.executeQuery();
	         while (rs.next()) {             
	             int idPais=rs.getInt("idpais");
	             String codigo=rs.getString("codigo");
	             String nombre=rs.getString("nombre");
	             System.out.println(nombre+" "+codigo+" "+nombre);
	             
	             paiss.add(new Pais(idPais, codigo, nombre));
	         }
	         
	     } catch (Exception e) {
	         e.printStackTrace(System.out);
	     }finally{
	         Conexion.Close(rs);
	         Conexion.Close(stmt);
	         Conexion.Close(conn);
	                 
	     }
	     
	     return paiss;
	 }
}
