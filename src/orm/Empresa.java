/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package orm;

public class Empresa {
	public Empresa() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_EMPRESA_PERSONA) {
			return ORM_persona;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idE;
	
	private String rut;
	
	private String nombre;
	
	private String email;
	
	private String fono;
	
	private String direccion;
	
	private java.util.Set ORM_persona = new java.util.HashSet();
	
	private void setIdE(int value) {
		this.idE = value;
	}
	
	public int getIdE() {
		return idE;
	}
	
	public int getORMID() {
		return getIdE();
	}
	
	public void setRut(String value) {
		this.rut = value;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
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
	
	private void setORM_Persona(java.util.Set value) {
		this.ORM_persona = value;
	}
	
	private java.util.Set getORM_Persona() {
		return ORM_persona;
	}
	
	public final orm.PersonaSetCollection persona = new orm.PersonaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_EMPRESA_PERSONA, orm.ORMConstants.KEY_PERSONA_EMPRESAIDE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdE());
	}
	
}
