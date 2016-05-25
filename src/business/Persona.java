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
	private String foto_b64;
	private Empresa empresa;
	private ArrayList<Bitacora> bitacora = new ArrayList<>();
	
	/**
	 * Constructor vacio.
	 */
	public Persona(){
		
	}
	
	/**
	 * Agrega una Persona a la Base de datos
	 *
	 * @param Persona Objeto que contiene la data a ingresar
	 * @return String Mensaje que indica si se ralizo la transaccion
	 * @throws PersistentException
	 */
	public String addPersonaBusiness(Persona persona) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction(); 
		
		try{			
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(persona.getEmpresa().getIdE());
			orm.Persona lormPersona = orm.PersonaDAO.createPersona();
			
			orm.EmpresaDAO.save(lormEmpresa);
			
			lormPersona.setRun(persona.run);
			lormPersona.setNombre(persona.nombre);
			lormPersona.setApellido(persona.apellido);
			lormPersona.setEmail(persona.email);
			lormPersona.setFono(persona.fono);
			lormPersona.setDireccion(persona.direccion);
			lormPersona.setGenero(persona.genero);
			lormPersona.setFoto_e64(persona.foto_b64);
			lormPersona.setEmpresaidE(lormEmpresa);
			
			orm.PersonaDAO.save(lormPersona);
			//orm.PersonaDAO.refresh(lormPersona);
			t.commit();
			//return = lormPersona.getUidP(); // para metodo int
			return "Data Ingresada";
		}catch(PersistentException e) {
			t.rollback();
			return "Business PersistentException:"+e.getMessage();			
		}		
	}
	
	/**
	  * Metodo que elimina una persona de la Base de datos
	  * usando el id de la Persona recibida
	  *
	  * @param Persona Objeto del que se extrae el id para eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  * @throws PersistentException
	  */
	public String delPersonaBusinessIdP(Persona persona) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByORMID(persona.getIdP());
			orm.PersonaDAO.delete(lormPersona);
			//borra empresa al borrar persona
			//orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(persona.getEmpresa().getIdE());
			//orm.EmpresaDAO.delete(lormEmpresa);
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
	  * Metodo que elimina una persona de la Base de datos
	  * usando el run de la Persona recibida
	  *
	  * @param Persona Objeto del que se extrae el run para eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  * @throws PersistentException
	  */
	public String delPersonaBusinessRun(Persona persona) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery("Persona.run = '"+persona.run+"'", null);
			//orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByORMID(persona.getIdP());
			orm.PersonaDAO.delete(lormPersona);
			
			//orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(persona.getEmpresa().getIdE());
			//orm.EmpresaDAO.delete(lormEmpresa);
			
			t.commit();
			return "Data Eliminada";
		}

		catch (NullPointerException e){
			return "ERROR: No existe una Persona con el Run:"+persona.getRun();
		}
		catch (Exception e) {
			t.rollback();
			return "ERROR: No existe una Persona con el Run:"+persona.getRun();
		}
	}
	
	/**
	  * Metodo que edita una persona de la Base de datos
	  * usando el run de la Persona recibida
	  *
	  * @param Persona Objeto del que se extrae el ID a editar
	  * @return String Mensaje que indica si se ralizo la transaccion
	 * @throws PersistentException 
	  */
	public String editPersonaBusiness(Persona persona) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		
		try {
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(persona.getEmpresa().getIdE());
			lormEmpresa.setNombre(persona.getEmpresa().getNombre());
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery("Persona.run='"+persona.run+"'", null);
			
			//Actualiza las propiedades del objeto persistente
			lormPersona.setRun(persona.run);
			lormPersona.setNombre(persona.nombre);
			lormPersona.setApellido(persona.apellido);
			lormPersona.setEmail(persona.email);
			lormPersona.setFono(persona.fono);
			lormPersona.setDireccion(persona.direccion);
			lormPersona.setGenero(persona.genero);
			lormPersona.setFoto_e64(persona.foto_b64);
							
			orm.PersonaDAO.save(lormPersona);
			orm.PersonaDAO.refresh(lormPersona);
			t.commit();
			return "Data Editada";
		}catch (Exception e) {
			t.rollback();
			return "ERROR: no se edito la data ";
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
	public List<Persona> busquedaSimple(String cadenaBusqueda) throws PersistentException {
		List<Persona> listaPersona = new ArrayList<Persona>();
		List<orm.Persona> listaPersonasBD = new ArrayList<orm.Persona>();
		
		if( cadenaBusqueda != null && !cadenaBusqueda.trim().equals("")){	
			//cadena compuesta por OR para encontrar al el dato en al menos uno de los campos
			listaPersonasBD = orm.PersonaDAO.queryPersona(
					  "Persona.run='"+cadenaBusqueda
				+"' OR Persona.nombre ='"+cadenaBusqueda
				+"' OR Persona.apellido ='"+cadenaBusqueda
				+"' OR Persona.email = '"+cadenaBusqueda
				+"' OR Persona.fono = '"+cadenaBusqueda
				+"' OR Persona.direccion ='"+cadenaBusqueda
				+"' OR Persona.genero ='"+cadenaBusqueda
				+"' ",null);
		}
		
		if(!listaPersonasBD.isEmpty()){			
			for( orm.Persona personaORM : listaPersonasBD){
				
				Empresa empresaB = new Empresa();				
				//obetener empresa asociada a la persona
				orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(personaORM.getEmpresaidE().getIdE());
				
				empresaB.setIdE(empresaORM.getIdE());				
				empresaB.setRut(empresaORM.getRut());
				empresaB.setNombre(empresaORM.getNombre());
				
				Persona personaB = new Persona();
				
				personaB.setEmpresa(empresaB);
				
				personaB.setRun(personaORM.getRun());
				personaB.setNombre(personaORM.getNombre());
				personaB.setApellido(personaORM.getApellido());
				personaB.setEmail(personaORM.getEmail());
				personaB.setFono(personaORM.getFono());
				personaB.setDireccion(personaORM.getDireccion());
				personaB.setGenero(personaORM.getGenero());
				personaB.setFoto_b64(personaORM.getFoto_e64());
								
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
	@SuppressWarnings("unchecked")
	public List<Persona> busquedaAvanzada(Persona persona) throws PersistentException{
		
		String queryToSearch="";		
		List<orm.Persona> listaPersonasFromQuery = new ArrayList<orm.Persona>();
		List<Persona> listaPersonaBD = new ArrayList<Persona>();
		
		//String usados para disminuir cantidad de gets en validaciones
		String gRun = persona.getRun();
		String gNombre = persona.getNombre();
		String gApellido = persona.getApellido();
		String gEmail = persona.getEmail();
		String gFono = persona.getFono();
		String gDireccion = persona.getDireccion();
		String gGenero = persona.getGenero();		
		//
		
		
		/*	
		 * verificar si el parametro x de la persona viene con datos
		 * en caso de que venga con datos adjuntar el parametro a la query de busqueda
		 * mediante el AND y posteriormente el parametro a concatenar
		*/
		if(gRun!= null && !gRun.trim().equals("")){
			queryToSearch += "Persona.run='"+gRun+"' ";
		}
		
		if((gRun!= null && !gRun.equals(""))
				&& (gNombre!=null && !gNombre.equals(""))){
			queryToSearch += "AND ";
		}
		if(gNombre!=null && !gNombre.equals("")){
			queryToSearch += "Persona.nombre='"+gNombre+"' ";
		}
		
		if(((gRun!=null && !gRun.equals(""))
				|| (gNombre!=null && !gNombre.equals(""))
				)&& (gApellido!=null && !gApellido.equals(""))){
			queryToSearch += "AND ";
		}
		if(gApellido!=null && !gApellido.trim().equals("")){
			queryToSearch += "Persona.apellido='"+gApellido+"' ";
		}
		
		if((gRun!=null && !gRun.equals("")
				|| gNombre!=null && !gNombre.equals("")
				|| gApellido!=null && !gApellido.equals(""))
				&& (gEmail != null && !gEmail.equals(""))){
			queryToSearch += "AND ";
		}
		if(gEmail != null && !gEmail.trim().equals("")){
			queryToSearch += "Persona.email='"+gEmail+"' ";
		}
		
		if((gRun!=null && !gRun.equals("")
				|| gNombre!=null && !gNombre.equals("")
				|| gApellido!=null && !gApellido.equals("")
				|| gEmail != null && !gEmail.equals(""))
				&& (gFono != null && !gFono.equals(""))){
			queryToSearch += "AND ";
		}
		if(gFono != null && !gFono.trim().equals("")){
			queryToSearch += "Persona.fono='"+gFono+ "' ";
		}
		
		if((gRun!=null && !gRun.equals("")
				|| gNombre!=null && !gNombre.equals("")
				|| gApellido!=null && !gApellido.equals("")
				|| gEmail != null && !gEmail.equals("")
				|| gFono != null && !gFono.equals(""))
				&& (gDireccion != null && !gDireccion.equals(""))){
			queryToSearch += "AND ";
		}
		if(gDireccion != null && !gDireccion.trim().equals("")){
			queryToSearch += "Persona.direccion='"+gDireccion+ "' ";
		}
		
		if((gRun!=null && !gRun.equals("")
				|| gNombre!=null && !gNombre.equals("")
				|| gApellido!=null && !gApellido.equals("")
				|| gEmail != null && !gEmail.equals("")
				|| gFono != null && !gFono.equals("")
				|| gDireccion != null && !gDireccion.equals(""))
				&& (gGenero != null && !gGenero.equals(""))){
			queryToSearch += "AND ";
		}
		if(gGenero != null && !gGenero.trim().equals("")){
			queryToSearch += "Persona.genero='"+gGenero+ "' ";
		}
		
		listaPersonasFromQuery = orm.PersonaDAO.queryPersona(queryToSearch, null);
		
		if(!listaPersonasFromQuery.isEmpty()){
			for( orm.Persona personaORM : listaPersonasFromQuery){			
				Empresa empresaB = new Empresa();				
				
				orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(personaORM.getEmpresaidE().getIdE());
				
				empresaB.setIdE(empresaORM.getIdE());
				empresaB.setRut(empresaORM.getRut());
				empresaB.setNombre(empresaORM.getNombre());			
				
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
				personaB.setFoto_b64(personaORM.getFoto_e64());
				
				personaB.setEmpresa(empresaB);
				
				listaPersonaBD.add(personaB);
			}
		}		
		return listaPersonaBD;
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

	public String getFoto_b64() {
		return foto_b64;
	}

	public void setFoto_b64(String foto_e64) {
		this.foto_b64 = foto_e64;
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
	
	/**
	 * Agrega un registro de bitacora a la Persona
	 * @param bit
	 */
	public void addBitacora(Bitacora bit){
		this.bitacora.add(bit);
	}

}
