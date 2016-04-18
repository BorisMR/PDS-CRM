package business;

import java.util.ArrayList;
import java.util.List;

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
	  * Metodo que elimina una empresa de la Base de datos
	  * usando el rut de la Empresa recibida
	  *
	  * @param Empresa Objeto del que se extrae el rut para eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  * @throws PersistentException
	  */
	public String delEmpresaBusiness(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.rut = '"+empresa.rut+"'", null);
			// Delete the persistent object
			orm.EmpresaDAO.delete(lormEmpresa);
			t.commit();
			return "Data Eliminada";
		}

		catch (NullPointerException e){
			return "ERROR: No existe una Empresa con ese RUT";
		}
		catch (Exception e) {
			t.rollback();
			return "ERROR: No existe una Persona con ese RUT";
		}
	}

	/**
	  * Metodo que edita una empresa de la Base de datos
	  * usando el rut de la Empresa recibida
	  *
	  * @param Empresa Objeto del que se extrae el rut para editar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  */
	public String editEmpresaBusiness(Empresa empresa){
		PersistentTransaction t;
		try {
			t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
			try {
				
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.rut = '"+empresa.rut+"'", null);
				// Update the properties of the persistent object
				lormEmpresa.setRut(empresa.rut);
				lormEmpresa.setNombre(empresa.nombre);
				lormEmpresa.setEmail(empresa.email);
				lormEmpresa.setEmail(empresa.fono);
				lormEmpresa.setFono(empresa.direccion);
								
				orm.EmpresaDAO.save(lormEmpresa);
				t.commit();
				return "Data Editada";
			}
			catch (Exception e) {
				t.rollback();
				return "ERROR: no se edito la data ";
			}
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "NONE";
	}

	/**
	  * Metodo que genera una tabla con las Empresa de la Base de datos
	  * 
	  * @return String Contiene la tabla generada con los datos en html
	  */
	public String listEmpresaBusiness() throws PersistentException{
		final int ROW_COUNT = 100;
		orm.Empresa[] ormEmpresas;
		String salida = "";
		int i = 0;
		
		try {
			ormEmpresas = orm.EmpresaDAO.listEmpresaByQuery(null, null);
			int length = Math.min(ormEmpresas.length, ROW_COUNT);
			
			List<orm.Empresa> lista = new ArrayList<orm.Empresa>();
			
			//crea lista con todas las personas
			for (i = 0; i < length; i++) {
				lista.add(ormEmpresas[i]);
				
			}
			//insertar bootstrap y div a salida
			salida += "<table>";
			salida += "<tr><th>Rut</th><th>Nombre</th><th>Email</th><th>Fono</th><th>Direccion</th></tr>";
			
			if(ormEmpresas.length > 0){
				for (i = 0; i < ormEmpresas.length; i++) {
					salida += "<tr>";
					salida += ("<td>"+ormEmpresas[i].getRut())+"</td>";
					salida += ("<td>"+ormEmpresas[i].getNombre())+"</td>";
					salida += ("<td>"+ormEmpresas[i].getEmail()+"</td>");
					salida += ("<td>"+ormEmpresas[i].getFono()+"</td>");
					salida += ("<td>"+ormEmpresas[i].getDireccion()+"</td>");
					salida += "</tr>";
				}
				salida += "</table>";
			}else{
				salida += "</table>";
			}			
			return salida;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return salida;
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
