package business;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Persona {
	
	private int idP;
	private String run;
	private String nombre;
	private String apellido;
	private String email;
	private String fono;
	private String direccion;
	private String genero;
	
	public Persona(){
		
	}
	
	/**
	 * Metodo que añade una Persona a la Base de datos
	 *
	 * @param Persona Objeto que contiene la data a ingresar
	 * @return String Mensaje que indica si se ralizo la transaccion
	 * @throws PersistentException
	 */
	public String addPersonaBusiness(Persona persona) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction(); 
		try{
			orm.Persona lormPersona = orm.PersonaDAO.createPersona();
			lormPersona.setRun(persona.run);
			lormPersona.setNombre(persona.nombre);
			lormPersona.setApellido(persona.apellido);
			lormPersona.setEmail(persona.email);
			lormPersona.setFono(persona.fono);
			lormPersona.setDireccion(persona.direccion);
			lormPersona.setGenero(persona.genero);
			orm.PersonaDAO.save(lormPersona);
			t.commit();
			return "Data Ingresada";
		}catch(Exception e) {
			t.rollback();
			return "ERROR: No se pudo ingresar a la Persona";			
		}		
	}
	
	/**
	  * Metodo que elimina una persona de la Base de datos
	  * usando el rut de la Persona recibida
	  *
	  * @param Persona Objeto del que se extrae el run para eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  * @throws PersistentException
	  */
	public String delPersonaBusiness(Persona persona) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery("Persona.run = '"+persona.run+"'", null);
			// Delete the persistent object
			orm.PersonaDAO.delete(lormPersona);
			t.commit();
			return "Data Eliminada";
		}

		catch (NullPointerException e){
			return "ERROR: No existe una Persona con ese RUN";
		}
		catch (Exception e) {
			t.rollback();
			return "ERROR: No existe una Persona con ese RUN";
		}
	}
	
	/**
	  * Metodo que edita una persona de la Base de datos
	  * usando el run de la Persona recibida
	  *
	  * @param Persona Objeto del que se extrae el ID a editar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  */
	public String editPersonaBusiness(Persona persona){
		PersistentTransaction t;
		try {
			t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
			try {
				
				orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery("Persona.run = '"+persona.run+"'", null);
				// Update the properties of the persistent object
				lormPersona.setRun(persona.run);
				lormPersona.setNombre(persona.nombre);
				lormPersona.setApellido(persona.apellido);
				lormPersona.setEmail(persona.email);
				lormPersona.setFono(persona.fono);
				lormPersona.setDireccion(persona.direccion);
				lormPersona.setGenero(persona.genero);
								
				orm.PersonaDAO.save(lormPersona);
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
	  * Metodo que genera una tabla con las Personas de la Base de datos
	  * 
	  * @return String Contiene la tabla generada con los datos en html
	  */
	public String listPersonaBusiness() throws PersistentException{
		final int ROW_COUNT = 100;
		orm.Persona[] ormPersonas;
		String salida = "";
		int i = 0;
		
		try {
			ormPersonas = orm.PersonaDAO.listPersonaByQuery(null, null);
			int length = Math.min(ormPersonas.length, ROW_COUNT);
			
			List<orm.Persona> lista = new ArrayList<orm.Persona>();
			
			//crea lista con todas las personas
			for (i = 0; i < length; i++) {
				lista.add(ormPersonas[i]);
				
			}
			//insertar bootstrap y div a salida
			salida += "<table>";
			salida += "<tr><th>Run</th><th>Nombre</th><th>Apellido</th><th>eMail</th><th>Telefono</th>"
					+ "<th>Direccion</th><th>Genero</th></tr>";
			
			if(ormPersonas.length > 0){
				for (i = 0; i < ormPersonas.length; i++) {
					salida += "<tr>";
					salida += ("<td>"+ormPersonas[i].getRun())+"</td>";
					salida += ("<td>"+ormPersonas[i].getNombre())+"</td>";
					salida += ("<td>"+ormPersonas[i].getApellido()+"</td>");
					salida += ("<td>"+ormPersonas[i].getEmail()+"</td>");
					salida += ("<td>"+ormPersonas[i].getFono()+"</td>");
					salida += ("<td>"+ormPersonas[i].getDireccion()+"</td>");
					salida += ("<td>"+ormPersonas[i].getGenero()+"</td>");
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
	 * LISTA ARRAYLIST
	 */
	public ArrayList<orm.Persona> listaRegistros()throws PersistentException{
		ArrayList<orm.Persona> personas = null;
		orm.Persona[] aux;
		aux = orm.PersonaDAO.listPersonaByQuery(null, null);
		personas = new ArrayList<>(Arrays.asList(aux));
		return personas;
		
	}
	
	/**
	 * 
	 * @return int Id de la persona
	 */
	public int getIdP() {
		return idP;
	}
	
	/**
	 * 
	 * @param int Id de la persona
	 */
	public void setIdP(int idP) {
		this.idP = idP;
	}
	
	/**
	 * 
	 * @return String run de la persona
	 */
	public String getRun() {
		return run;
	}

	/**
	 * 
	 * @param String run de la persona
	 */
	public void setRun(String run) {
		this.run = run;
	}
	
	/**
	 * 
	 * @return String nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param String nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return String apellido de la persona
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param String apellido de la persona
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * 
	 * @return String email de la persona
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param String eMail de la persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return String fono de la persona
	 */
	public String getFono() {
		return fono;
	}

	/**
	 * 
	 * @param String telefono de la persona
	 */
	public void setFono(String fono) {
		this.fono = fono;
	}
	
	/**
	 * 
	 * @return String direccion de la persona
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @param String direccion de la persona
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @return String genero de la persona
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * 
	 * @param String genero de la persona
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
