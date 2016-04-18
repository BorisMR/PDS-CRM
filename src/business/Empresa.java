package business;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * 
 * @author Boris Morales R.
 * 
 * Clase encargada de la logica de negocio de la aplicacion
 * su tarea es la de enviar transacciones a la BD
 *
 */
public class Empresa {

	private int idE;
	private String rut;
	private String nombre;
	private String email;
	private String fono;
	private String direccion;
	
	public Empresa(){
		
	}
	
	/**
	 * Metodo que agrega una Empresa a la Base de datos
	 *
	 * @param Empresa Objeto que contiene la data a ingresar
	 * @return String Mensaje que indica si se ralizo la transaccion
	 * @throws PersistentException
	 */
	public String addEmpresaBusiness(Empresa empresa) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction(); 
		try{
			orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
			lormEmpresa.setRut(empresa.rut);
			lormEmpresa.setNombre(empresa.nombre);
			lormEmpresa.setEmail(empresa.email);
			lormEmpresa.setFono(empresa.fono);
			lormEmpresa.setDireccion(empresa.direccion);
			orm.EmpresaDAO.save(lormEmpresa);
			t.commit();
			return "Data Ingresada";

		}catch (NullPointerException e){
			return "ERROR: No existe una Empresa con ese RUT";
		}catch(Exception e) {
			t.rollback();
			return "ERROR";			
		}		
	}

	/**
	 * @return int id de la Empresa
	 */
	public int getIdE() {
		return idE;
	}

	/**
	 * @param id el idE a asignar
	 */
	public void setIdE(int idE) {
		this.idE = idE;
	}

	/**
	 * @return String el rut
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param rut el rut a asignar
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * @return String el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return String el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email El email a asignar
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return String el telefono
	 */
	public String getFono() {
		return fono;
	}

	/**
	 * @param fono el telefono a asignar
	 */
	public void setFono(String fono) {
		this.fono = fono;
	}

	/**
	 * @return String la direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion la direccion a asignar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
