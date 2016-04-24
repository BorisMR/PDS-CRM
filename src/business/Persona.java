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
	private Empresa empresa;
	
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
			orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
			lormEmpresa.setNombre(persona.getEmpresa().getNombre());
			orm.EmpresaDAO.save(lormEmpresa);
			
			orm.Persona lormPersona = orm.PersonaDAO.createPersona();
			lormPersona.setRun(persona.run);
			lormPersona.setNombre(persona.nombre);
			lormPersona.setApellido(persona.apellido);
			lormPersona.setEmail(persona.email);
			lormPersona.setFono(persona.fono);
			lormPersona.setDireccion(persona.direccion);
			lormPersona.setGenero(persona.genero);
			orm.PersonaDAO.save(lormPersona);
			orm.PersonaDAO.refresh(lormPersona);
			t.commit();
			//return = lormPersona.getUidP(); // para metodo int
			return "Data Ingresada";
		}catch(PersistentException e) {
			t.rollback();
			return "No se pudo ingresar a la Persona en la BD";			
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
			//orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery("Persona.run = '"+persona.run+"'", null);
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByORMID(persona.getIdP());
			orm.PersonaDAO.delete(lormPersona);
			//borra empresa al borrar persona
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(persona.getEmpresa().getIdE());
			orm.EmpresaDAO.delete(lormEmpresa);
			
			t.commit();
			return "Data Eliminada";
		}

		catch (NullPointerException e){
			return "ERROR: No existe una Persona con el ID:"+persona.getIdP();
		}
		catch (Exception e) {
			t.rollback();
			return "ERROR: No existe una Persona con el ID:"+persona.getIdP();
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
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(persona.getEmpresa().getIdE());
				lormEmpresa.setNombre(persona.getEmpresa().getNombre());
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
				//orm.PersonaDAO.refresh(lormPersona);
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
	 * metodo que retorna un ArrayList con las personas agregadas
	 * 
	 * @return ArrayList<orm.Persona>
	 * @throws PersistentException
	 */
	public ArrayList<orm.Persona> listPersonaArray()throws PersistentException{
		ArrayList<orm.Persona> personas = null;
		orm.Persona[] aux;
		aux = orm.PersonaDAO.listPersonaByQuery(null, null);
		personas = new ArrayList<>(Arrays.asList(aux));
		return personas;		
	}
	
	/**
	 * Efectua una busqueda simple utilizando una cadena de texto comun
	 * 
	 * @param busqueda
	 * @return
	 * @throws PersistentException
	 */
	@SuppressWarnings("unchecked") // por simple comodidad
	public List<Persona> busquedaSimplePersona(String cadenaBusqueda) throws PersistentException {
		List<Persona> listaPersona = new ArrayList<Persona>();
		List<orm.Persona> listaPersonas = new ArrayList<orm.Persona>();
		
		if( cadenaBusqueda != null || !cadenaBusqueda.equals("") ){	
			//cadena compuesta por OR para encontrar al el dato en al menos uno de los campos
			listaPersonas = orm.PersonaDAO.queryPersona("Persona.run='"+cadenaBusqueda
				+"' OR Persona.nombre ='"+cadenaBusqueda
				+"' OR Persona.apellido ='"+cadenaBusqueda
				+"' OR Persona.email = '"+cadenaBusqueda
				+"' OR Persona.fono = '"+cadenaBusqueda
				+"' OR Persona.direccion ='"+cadenaBusqueda
				+"' OR Persona.genero ='"+cadenaBusqueda
				+"' ",null);
		}
		
		if(listaPersonas != null){			
			for( orm.Persona personaORM : listaPersonas){
				
				Empresa empresaB = new Empresa();				
				
				orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(personaORM.getEmpresaidE().getIdE());
				
				empresaB.setIdE(empresaORM.getIdE());
				empresaB.setNombre(empresaORM.getNombre());
				empresaB.setEmail(empresaORM.getEmail());
				empresaB.setFono(empresaORM.getFono());
				empresaB.setDireccion(empresaORM.getDireccion());
				empresaB.setRut(empresaORM.getRut());
				
				Persona personaB = new Persona();
				
				personaB.setEmpresa(empresaB);
				personaB.setRun(personaORM.getRun());
				personaB.setNombre(personaORM.getNombre());
				personaB.setApellido(personaORM.getApellido());
				personaB.setEmail(personaORM.getEmail());
				personaB.setFono(personaORM.getFono());
				personaB.setDireccion(personaORM.getDireccion());
				personaB.setGenero(personaORM.getGenero());
				
				listaPersona.add(personaB);
			}
		}
		return listaPersona;
	}
	
	/**
	 * Efectua una busqueda avanzada segun los parametros con datos
	 * ingresados, no considerando aquellos que vienen vacios.
	 * 
	 * @param Persona clase con lso datos a buscar
	 * @return List<Persona>
	 * @throws PersistentException
	 */
	public List<Persona> busquedaAvanzada(Persona persona) throws PersistentException{
		
		String queryToSearch="";
		List<Persona> listaPersona = new ArrayList<Persona>();
		List<orm.Persona> listaPersonas = new ArrayList<orm.Persona>();
		
		if(persona.getRun()!= null && !persona.getRun().trim().equals("")){
			queryToSearch += "Persona.run='"+persona.getRun()+"' ";
		}
		
		if((persona.getRun()!= null && !persona.getRun().equals(""))
				&& (persona.getNombre()!=null && !persona.getNombre().equals(""))){
			queryToSearch += "AND ";
		}
		if(persona.getNombre()!=null && !persona.getNombre().equals("")){
			queryToSearch += "Persona.nombre='"+persona.getNombre()+"' ";
		}
		
		if(((persona.getRun()!=null && !persona.getRun().equals(""))
				|| (persona.getNombre()!=null && !persona.getNombre().equals(""))
				)&& (persona.getApellido()!=null && !persona.getApellido().equals(""))){
			queryToSearch += "AND ";
		}
		if(persona.getApellido()!=null && !persona.getApellido().trim().equals("")){
			queryToSearch += "Persona.apellido='"+persona.getApellido()+"' ";
		}
		
		if((persona.getRun()!=null && !persona.getRun().equals("")
				|| persona.getNombre()!=null && !persona.getNombre().equals("")
				|| persona.getApellido()!=null && !persona.getApellido().equals(""))
				&& (persona.getEmail() != null && !persona.getEmail().equals(""))){
			queryToSearch += "AND ";
		}
		if(persona.getEmail() != null && !persona.getEmail().trim().equals("")){
			queryToSearch += "Persona.email='"+persona.getEmail()+"' ";
		}
		
		if((persona.getRun()!=null && !persona.getRun().equals("")
				|| persona.getNombre()!=null && !persona.getNombre().equals("")
				|| persona.getApellido()!=null && !persona.getApellido().equals("")
				|| persona.getEmail() != null && !persona.getEmail().equals(""))
				&& (persona.getFono() != null && !persona.getFono().equals(""))){
			queryToSearch += "AND ";
		}
		if(persona.getFono() != null && !persona.getFono().trim().equals("")){
			queryToSearch += "Persona.fono='"+persona.getFono()+ "' ";
		}
		
		if((persona.getRun()!=null && !persona.getRun().equals("")
				|| persona.getNombre()!=null && !persona.getNombre().equals("")
				|| persona.getApellido()!=null && !persona.getApellido().equals("")
				|| persona.getEmail() != null && !persona.getEmail().equals("")
				|| persona.getFono() != null && !persona.getFono().equals(""))
				&& (persona.getDireccion() != null && !persona.getDireccion().equals(""))){
			queryToSearch += "AND ";
		}
		if(persona.getDireccion() != null && !persona.getDireccion().trim().equals("")){
			queryToSearch += "Persona.direccion='"+persona.getDireccion()+ "' ";
		}
		
		if((persona.getRun()!=null && !persona.getRun().equals("")
				|| persona.getNombre()!=null && !persona.getNombre().equals("")
				|| persona.getApellido()!=null && !persona.getApellido().equals("")
				|| persona.getEmail() != null && !persona.getEmail().equals("")
				|| persona.getFono() != null && !persona.getFono().equals("")
				|| persona.getDireccion() != null && !persona.getDireccion().equals(""))
				&& (persona.getGenero() != null && !persona.getGenero().equals(""))){
			queryToSearch += "AND ";
		}
		if(persona.getGenero() != null && !persona.getGenero().trim().equals("")){
			queryToSearch += "Persona.genero='"+persona.getGenero()+ "' ";
		}		
		
		listaPersonas = orm.PersonaDAO.queryPersona(queryToSearch, null);
		
		for( orm.Persona personaORM : listaPersonas){			
			Empresa empresaB = new Empresa();				
			
			orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(personaORM.getEmpresaidE().getIdE());
			
			empresaB.setIdE(empresaORM.getIdE());
			empresaB.setRut(empresaORM.getRut());
			empresaB.setNombre(empresaORM.getNombre());
			empresaB.setEmail(empresaORM.getEmail());
			empresaB.setFono(empresaORM.getFono());
			empresaB.setDireccion(empresaORM.getDireccion());			
			
			Persona personaB = new Persona();
			
			personaB.setIdP(personaORM.getIdP());
			personaB.setEmpresa(empresaB);
			personaB.setRun(personaORM.getRun());
			personaB.setNombre(personaORM.getNombre());
			personaB.setApellido(personaORM.getApellido());
			personaB.setEmail(personaORM.getEmail());
			personaB.setFono(personaORM.getFono());
			personaB.setDireccion(personaORM.getDireccion());
			personaB.setGenero(personaORM.getGenero());
			
			personaB.setEmpresa(empresaB);
			
			listaPersona.add(personaB);
		}
		return listaPersona;
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

	/**
	 * @return Empresa retorna un objeto de tipo empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param Empresa La empresa a asignar
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
}
