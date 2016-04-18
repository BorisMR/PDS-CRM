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
public class Persona {
	
	private int idP;
	private String run;
	private String nombre;
	private String apellido;
	private String email;
	private String fono;
	private String direccion;
	private int genero;
	
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
			return "ERROR";			
		}
		
	}

}
