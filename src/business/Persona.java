package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import orm.PersonaCriteria;


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
			
			t.commit();
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
	 * Obtener perfil por rut
	 * 
	 * @param persona
	 * @return persona
	 */
	public Persona getPersonaBusiness(Persona persona) throws PersistentException {
		//PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try{
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery("Persona.run = '"+persona.run+"'", null);
			persona.setIdP(lormPersona.getIdP());
			persona.setRun(lormPersona.getRun());
			persona.setNombre(lormPersona.getNombre());
			persona.setApellido(lormPersona.getApellido());
			persona.setEmail(lormPersona.getEmail());
			persona.setFono(lormPersona.getFono());
			persona.setDireccion(lormPersona.getDireccion());
			persona.setGenero(lormPersona.getGenero());
			persona.setFoto_b64(lormPersona.getFoto_e64());
			
			return persona;
		}catch(PersistentException e){
			return null;
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
			return "No se pudo editar la data ";
		}
	}
	
	/**
	 * Metodo que genera una Lista con las Personas de la Base de datos
	 * 
	 * @return List<Persona> Contiene la lista
	 */
	@SuppressWarnings("unchecked")
	public List<Persona> listPersonaBusiness() throws PersistentException{
		List<Persona> listaPersona = new ArrayList<Persona>();
		List<orm.Persona> listaPersonasBD = new ArrayList<orm.Persona>();
		
		listaPersonasBD = orm.PersonaDAO.queryPersona(null, null);
		
		if(!listaPersonasBD.isEmpty()){
			for (orm.Persona personaORM : listaPersonasBD) {
				
				Empresa empresaB = new Empresa();

				orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(personaORM.getEmpresaidE().getIdE());
				
				empresaB.setIdE(empresaORM.getIdE());				
				empresaB.setRut(empresaORM.getRut());
				empresaB.setNombre(empresaORM.getNombre());
				
				Persona personaB = new Persona();
				
				personaB.setIdP(personaORM.getIdP());
				personaB.setRun(personaORM.getRun());
				personaB.setNombre(personaORM.getNombre());
				personaB.setApellido(personaORM.getApellido());
				personaB.setEmail(personaORM.getEmail());
				personaB.setFono(personaORM.getFono());
				personaB.setDireccion(personaORM.getDireccion());
				personaB.setGenero(personaORM.getGenero());
				personaB.setFoto_b64(personaORM.getFoto_e64());
				
				personaB.setEmpresa(empresaB);
				
				listaPersona.add(personaB);
			}
		}
		
		return listaPersona;
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
	 * Efectua una busqueda simple utilizando una cadena de texto simple
	 * 
	 * @param busqueda
	 * @return
	 * @throws PersistentException
	 */
	public List<Persona> busquedaSimple(String cadenaBusqueda) throws PersistentException {
		
		List<Persona> listaPersona = new ArrayList<Persona>();
		List<orm.Persona> listaPersonasBD = new ArrayList<orm.Persona>();
		
		Criterion run = Restrictions.ilike("run", cadenaBusqueda.toLowerCase());
		Criterion nombre = Restrictions.ilike("nombre", cadenaBusqueda.toLowerCase());
		Criterion apellido = Restrictions.ilike("apellido", cadenaBusqueda.toLowerCase());
		Criterion email = Restrictions.ilike("email", cadenaBusqueda.toLowerCase());
		Criterion fono = Restrictions.ilike("fono", cadenaBusqueda.toLowerCase());
		Criterion direccion = Restrictions.ilike("direccion", cadenaBusqueda.toLowerCase());
		Criterion genero = Restrictions.ilike("genero", cadenaBusqueda.toLowerCase());
		
		PersonaCriteria ccr= new PersonaCriteria();
		Disjunction dis = Restrictions.or(run, nombre, apellido, email, fono, direccion, genero);
		
		ccr.add(dis); //No agregar para considerar como AND
		
		listaPersonasBD = Arrays.asList(orm.PersonaDAO.listPersonaByCriteria(ccr));		
		
		if(!listaPersonasBD.isEmpty()){			
			for( orm.Persona personaORM : listaPersonasBD){
				
				Empresa empresaB = new Empresa();

				orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(personaORM.getEmpresaidE().getIdE());
				
				empresaB.setIdE(empresaORM.getIdE());				
				empresaB.setRut(empresaORM.getRut());
				empresaB.setNombre(empresaORM.getNombre());
				
				Persona personaB = new Persona();
				
				personaB.setRun(personaORM.getRun());
				personaB.setNombre(personaORM.getNombre());
				personaB.setApellido(personaORM.getApellido());
				personaB.setEmail(personaORM.getEmail());
				personaB.setFono(personaORM.getFono());
				personaB.setDireccion(personaORM.getDireccion());
				personaB.setGenero(personaORM.getGenero());
				personaB.setFoto_b64(personaORM.getFoto_e64());
				
				personaB.setEmpresa(empresaB);
				
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
		
		List<orm.Persona> listaPersonasFromQuery = new ArrayList<orm.Persona>();
		List<Persona> listaPersonaBD = new ArrayList<Persona>();
		
		String gRun = persona.getRun().toLowerCase();
		String gNombre = persona.getNombre().toLowerCase();
		String gApellido = persona.getApellido().toLowerCase();
		String gEmail = persona.getEmail().toLowerCase();
		String gFono = persona.getFono().toLowerCase();
		String gDireccion = persona.getDireccion().toLowerCase();
		String gGenero = persona.getGenero().toLowerCase();		
		
		PersonaCriteria ccr= new PersonaCriteria();
		
		if(gRun!= null && !gRun.trim().equals("")){
			ccr.add(Restrictions.ilike("run", gRun));
		}
		
		if(gNombre!=null && !gNombre.equals("")){
			ccr.add(Restrictions.ilike("nombre", gNombre));			
		}
		
		if(gApellido!=null && !gApellido.trim().equals("")){
			ccr.add(Restrictions.ilike("apellido", gApellido));
		}
		
		if(gEmail != null && !gEmail.trim().equals("")){
			ccr.add(Restrictions.ilike("email", gEmail));			
		}
		
		if(gFono != null && !gFono.trim().equals("")){
			ccr.add(Restrictions.ilike("fono", gFono));
		}
		
		if(gDireccion != null && !gDireccion.trim().equals("")){
			ccr.add(Restrictions.ilike("direccion", gDireccion));
		}
		
		if(gGenero != null && !gGenero.trim().equals("")){
			ccr.add(Restrictions.ilike("genero", gGenero));
		}
		
		listaPersonasFromQuery = Arrays.asList(orm.PersonaDAO.listPersonaByCriteria(ccr));
		
		
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
