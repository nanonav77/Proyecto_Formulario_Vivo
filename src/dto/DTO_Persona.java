package dto;

public class DTO_Persona {
	
	public int cedula;
	public String nombre;
	public String apellido1;
	public String apellido2;
	public String fechaNacimiento;
	public String sexo;
	public String provincia;
	public String canton;
	public String correo;
	public String contrasena;
	public int celular;
	public int telTrabajo;
	public String orcid;
	public String descripcion;
	
	
	
	
	

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrcid() {
		return orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getTelTrabajo() {
		return telTrabajo;
	}

	public void setTelTrabajo(int telTrabajo) {
		this.telTrabajo = telTrabajo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String date) {
		this.fechaNacimiento = date;
	}
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}
 
	public String toString() {
		return cedula +"," +  nombre + "," + apellido1 + "," + apellido2 + "," + sexo
				+  "," + provincia + "," + canton + ", fechaNacimiento=" + fechaNacimiento 
				+ ", correo=" + correo + ", contrasena=" + contrasena
				+ ", celular=" + celular + ", telTrabajo=" + telTrabajo
				+ ", orcid=" + orcid + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
