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
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_PERSONA_BITACORA) {
			return ORM_bitacora;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_PERSONA_EMPRESAIDE) {
			this.empresaidE = (orm.Empresa) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idP;
	
	private String run;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String fono;
	
	private String direccion;
	
	private String genero;
	
	private String foto_e64;
	
	private orm.Empresa empresaidE;
	
	private java.util.Set ORM_bitacora = new java.util.HashSet();
	
	private void setIdP(int value) {
		this.idP = value;
	}
	
	public int getIdP() {
		return idP;
	}
	
	public int getORMID() {
		return getIdP();
	}
	
	public void setRun(String value) {
		this.run = value;
	}
	
	public String getRun() {
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
	
	public void setGenero(String value) {
		this.genero = value;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setFoto_e64(String value) {
		this.foto_e64 = value;
	}
	
	public String getFoto_e64() {
		return foto_e64;
	}
	
	public void setEmpresaidE(orm.Empresa value) {
		if (empresaidE != null) {
			empresaidE.persona.remove(this);
		}
		if (value != null) {
			value.persona.add(this);
		}
	}
	
	public orm.Empresa getEmpresaidE() {
		return empresaidE;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_EmpresaidE(orm.Empresa value) {
		this.empresaidE = value;
	}
	
	private orm.Empresa getORM_EmpresaidE() {
		return empresaidE;
	}
	
	private void setORM_Bitacora(java.util.Set value) {
		this.ORM_bitacora = value;
	}
	
	private java.util.Set getORM_Bitacora() {
		return ORM_bitacora;
	}
	
	public final orm.BitacoraSetCollection bitacora = new orm.BitacoraSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_PERSONA_BITACORA, orm.ORMConstants.KEY_BITACORA_PERSONAIDP, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdP());
	}
	
}
