package datos;

import dominio.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC {
	

	private static final String SQL_SELECT_BY_ID = "select * from equipo where idequipo=?";
	private static final String SQL_INSERT = "insert into equipo (idpais,idmarca,nombre,descripcion,estado,precio) VALUES(?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE equipo SET idpais=?, idmarca=?, nombre=?, descripcion=?, estado=?, precio=? WHERE idequipo=?";
	private static final String SQL_DELETE = "DELETE FROM equipo WHERE idequipo=?";

	public List<Object[]> listar() {
		List<Object[]> equipo = null;
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT ")
        .append("e.idequipo,")
        .append("p.codigo as cod_pais,")
        .append("p.nombre as nom_pais,")
        .append("m.codigo as cod_marca,")
        .append("m.descripcion as descp_marca,")
        .append("e.nombre as nom_equipo,")
        .append("e.descripcion as descp_equipo,")
        .append("e.estado as estado_equipo,")
        .append("e.precio as precio")
        .append(" FROM equipo e")
        .append(" inner join pais p on e.idpais=p.idpais inner join marca m on e.idmarca=m.idmarca");
        
        
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		equipo = new ArrayList<>();

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object[] eq = new Object[9];
				eq[0] = rs.getInt(1);
				eq[1] = rs.getString(2);
				eq[2] = rs.getString(3);
				eq[3] = rs.getString(4);
				eq[4] = rs.getString(5);
				eq[5] = rs.getString(6);
				eq[6] = rs.getString(7);
				eq[7] = rs.getString(8);
				eq[8] = rs.getString(9);
				
				equipo.add(eq);
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(rs);
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}

		return equipo;
	}
	
	public List<Object[]> listarBusqueda(String precio) {
		List<Object[]> equipo = null;
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT ")
        .append("e.idequipo,")
        .append("p.codigo as cod_pais,")
        .append("p.nombre as nom_pais,")
        .append("m.codigo as cod_marca,")
        .append("m.descripcion as descp_marca,")
        .append("e.nombre as nom_equipo,")
        .append("e.descripcion as descp_equipo,")
        .append("e.estado as estado_equipo,")
        .append("e.precio as precio")
        .append(" FROM equipo e")
        .append(" inner join pais p on e.idpais=p.idpais inner join marca m on e.idmarca=m.idmarca where precio like '%"+precio+"%'");
        
        
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		equipo = new ArrayList<>();

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object[] eq = new Object[9];
				eq[0] = rs.getInt(1);
				eq[1] = rs.getString(2);
				eq[2] = rs.getString(3);
				eq[3] = rs.getString(4);
				eq[4] = rs.getString(5);
				eq[5] = rs.getString(6);
				eq[6] = rs.getString(7);
				eq[7] = rs.getString(8);
				eq[8] = rs.getString(9);
				
				equipo.add(eq);
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(rs);
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}

		return equipo;
	}

	public Equipo buscar(Equipo equipo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, equipo.getIdequipo());
			rs = stmt.executeQuery();
			rs.next();
			int idEquipo = rs.getInt("idequipo");
			int idpais = rs.getInt("idpais");
			int idmarca = rs.getInt("idmarca");
			String nombre = rs.getString("nombre");
			String descripcion = rs.getString("descripcion");
			String estado = rs.getString("estado");
			Double precio = rs.getDouble("precio");

			equipo.setIdequipo(idEquipo);
			equipo.setIdpais(idpais);
			equipo.setIdmarca(idmarca);
			equipo.setNombre(nombre);
			equipo.setDescripcion(descripcion);
			equipo.setEstado(estado);
			equipo.setPrecio(precio);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(rs);
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}

		return equipo;

	}

	public int insertar(Equipo equipo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setInt(1, equipo.getIdpais());
			stmt.setInt(2, equipo.getIdmarca());
			stmt.setString(3, equipo.getNombre());
			stmt.setString(4, equipo.getDescripcion());
			stmt.setString(5, equipo.getEstado());
			stmt.setDouble(6, equipo.getPrecio());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return rows;
	}

	public int actualizar(Equipo equipo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setInt(1, equipo.getIdpais());
			stmt.setInt(2, equipo.getIdmarca());
			stmt.setString(3, equipo.getNombre());
			stmt.setString(4, equipo.getDescripcion());
			stmt.setString(5, equipo.getEstado());
			stmt.setDouble(6, equipo.getPrecio());
			stmt.setInt(7, equipo.getIdequipo());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return rows;
	}

	public int eliminar(Equipo equipo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, equipo.getIdequipo());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return rows;
	}

	public static void main(String[] args) {
		ClienteDaoJDBC cliente = new ClienteDaoJDBC();
		cliente.listar();
	}
}
