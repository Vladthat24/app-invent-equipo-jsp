package dominio;

public class Pais {

	private int idpais;
	private String codigo;
	private String nombre;
	
	
	public Pais(int idpais, String codigo, String nombre) {
		super();
		this.idpais = idpais;
		this.codigo = codigo;
		this.nombre = nombre;
	}


	public Pais() {
		super();
	}


	public int getIdpais() {
		return idpais;
	}


	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
