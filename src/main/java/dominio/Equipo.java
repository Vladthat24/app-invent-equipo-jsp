package dominio;

public class Equipo{

	private int idequipo;
	private int idpais;
	private int idmarca;
	private String nombre;
	private String descripcion;
	private String estado;
	
	public Equipo(int idequipo) {
		// TODO Auto-generated constructor stub
		this.idequipo = idequipo;
	}

	public Equipo(int idequipo, int idpais, int idmarca, String nombre, String descripcion, String estado) {
		super();
		this.idequipo = idequipo;
		this.idpais = idpais;
		this.idmarca = idmarca;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public Equipo(int idpais, int idmarca, String nombre, String descripcion, String estado) {
		super();

		this.idpais = idpais;
		this.idmarca = idmarca;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public Equipo() {
		super();
	}

	public int getIdequipo() {
		return idequipo;
	}

	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}

	public int getIdpais() {
		return idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	public int getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Equipo [idequipo=" + idequipo + ", idpais=" + idpais + ", idmarca=" + idmarca + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
