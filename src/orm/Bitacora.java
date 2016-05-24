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

public class Bitacora {
	public Bitacora() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_BITACORA_PERSONAIDP) {
			this.personaidP = (orm.Persona) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idB;
	
	private String entrada;
	
	private orm.Persona personaidP;
	
	private void setIdB(int value) {
		this.idB = value;
	}
	
	public int getIdB() {
		return idB;
	}
	
	public int getORMID() {
		return getIdB();
	}
	
	public void setEntrada(String value) {
		this.entrada = value;
	}
	
	public String getEntrada() {
		return entrada;
	}
	
	public void setPersonaidP(orm.Persona value) {
		if (personaidP != null) {
			personaidP.bitacora.remove(this);
		}
		if (value != null) {
			value.bitacora.add(this);
		}
	}
	
	public orm.Persona getPersonaidP() {
		return personaidP;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_PersonaidP(orm.Persona value) {
		this.personaidP = value;
	}
	
	private orm.Persona getORM_PersonaidP() {
		return personaidP;
	}
	
	public String toString() {
		return String.valueOf(getIdB());
	}
	
}
