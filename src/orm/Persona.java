/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

public class Persona {
	public Persona() {
	}
	
	private int idP;
	
	private int run;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String fono;
	
	private String direccion;
	
	private int genero;
	
	private void setIdP(int value) {
		this.idP = value;
	}
	
	public int getIdP() {
		return idP;
	}
	
	public int getORMID() {
		return getIdP();
	}
	
	public void setRun(int value) {
		this.run = value;
	}
	
	public int getRun() {
		return run;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFono(String value) {
		this.fono = value;
	}
	
	public String getFono() {
		return fono;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setGenero(int value) {
		this.genero = value;
	}
	
	public int getGenero() {
		return genero;
	}
	
	public String toString() {
		return String.valueOf(getIdP());
	}
	
}
