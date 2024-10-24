package modelo.vo;

public class UsuarioVo {
	
	private String nombre;
	private String documento;
	private String profesion;
	private int edad;
	private String direccion;
	private String telefono;
	private int tipo;
	private String password;
	private int estado;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	public int getEstado() {return estado;}
	public void setEstado(int estado) {this.estado = estado;}

	@Override
	public String toString() {
		return
						"Id       : " + documento + "\n" +
						"Nombre   : " + nombre + "\n" +
						"Profesion  : " + profesion + "\n" +
						"edad   : " + edad + "\n" +
						"direccion   : " + direccion + "\n" +
						"telefono   : " + telefono + "\n";
	}
}
