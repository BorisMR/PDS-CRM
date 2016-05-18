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

public class Usuario {
	public Usuario() {
	}
	
	private int idU;
	
	private String usser;
	
	private String pass;
	
	private void setIdU(int value) {
		this.idU = value;
	}
	
	public int getIdU() {
		return idU;
	}
	
	public int getORMID() {
		return getIdU();
	}
	
	public void setUsser(String value) {
		this.usser = value;
	}
	
	public String getUsser() {
		return usser;
	}
	
	public void setPass(String value) {
		this.pass = value;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String toString() {
		return String.valueOf(getIdU());
	}
	
}
