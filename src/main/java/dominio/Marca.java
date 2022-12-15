package dominio;

public class Marca {
	private int idmarca;
	private String codigo;
	private String descripcion;
	

	public Marca() {
		super();
	}
	
	
	public Marca(int idmarca, String codigo, String descripcion) {
		super();
		this.idmarca = idmarca;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	public int getIdmarca() {
		return idmarca;
	}


	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
	
}
