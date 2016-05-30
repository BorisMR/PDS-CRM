package service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import business.*;

/**
 * Clase que utiliza el patron DAO para acceder a las funciones
 * de busqueda, utilizada para funciones de WebServlet
 * 
 * @author Boris Morales Rios
 *
 */
public class ServiceDAO {
	
	/**
	 * Verifica que los datos de para iniciar sesion sean  correctos
	 * @param usser
	 * @param pass
	 * @return String "v" si es valido y "f" si es invalido.
	 */
	@WebMethod(operationName = "verificarUsuario")
	public String verificarUsuario(
			@WebParam(name = "usser") String usser,
			@WebParam(name = "pass") String pass) throws PersistentException{
		
		Usuario usuario = new Usuario();
		String valido = "f";
		
		if(usser != null){
			usuario.setUser(usser);
		}			
		else{
			usuario.setUser("");
		}
		
		if(pass != null){
			usuario.setPassword(pass);
		}			
		else{
			usuario.setPassword("");
		}
		
		valido = usuario.validarUsuarioBusiness(usuario) ? "s" : "n";
		
		return valido;
	}
	
	/**
	 * Efectua una busqueda simple en base a una cadena de texto
	 * 
	 * @param cadenaBusqueda
	 * @return json 
	 * @throws PersistentException
	 */
	@WebMethod(operationName = "busquedaSimple")
	public String busquedaSimple(@WebParam(name = "cadenaBusqueda") String cadenaBusqueda) throws PersistentException{
		String resultado = "";		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Persona persona = new Persona();
		
		Gson gson = new GsonBuilder().create();	
				
		try{
			listaPersonas = persona.busquedaSimple(cadenaBusqueda);
			if(listaPersonas.isEmpty()){
				resultado = "No se encontraron datos";
			}else{
				resultado = gson.toJson(listaPersonas);
			}			
		}catch(PersistentException p){
			resultado = p.getMessage();
		}
		return resultado;
	}
	
	/**
	 * Efectua una busqueda avanzada segun los parametros con datos
	 * ingresados, no considerando aquellos que vienen vacios.
	 * 
	 * @param run
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param fono
	 * @param direccion
	 * @param genero
	 * @return json 
	 * @throws PersistentException
	 */
	@WebMethod(operationName = "busquedaAvanzada")
	public String busquedaAvanzada(
			@WebParam(name = "run") String run, 
			@WebParam(name = "nombre") String nombre, 
			@WebParam(name = "apellido") String apellido,
			@WebParam(name = "email") String email,
			@WebParam(name = "fono") String fono,
			@WebParam(name = "direccion") String direccion,
			@WebParam(name = "genero") String genero) throws PersistentException{
		
		String resultado = "";
		List<business.Persona> listaPersonasB = new ArrayList<business.Persona>();
		business.Persona persona = new business.Persona();
		
		if(run != null){
			persona.setRun(run);
		}			
		else{
			persona.setRun("");
		}
		
		if(nombre != null){
			persona.setNombre(nombre);
		}else{
			persona.setNombre("");
		}
		
		if(apellido != null){
			persona.setApellido(apellido);
		}else{
			persona.setApellido("");
		}
		
		if(email != null){
			persona.setEmail(email);
		}else{
			persona.setEmail("");
		}
		
		if(fono != null){
			persona.setFono(fono);
		}else{
			persona.setFono("");
		}
		
		if(direccion != null){
			persona.setDireccion(direccion);
		}else{
			persona.setDireccion("");
		}
		
		if(genero != null){
			persona.setGenero(genero);
		}else{
			persona.setGenero("");
		}
		
		Gson gson = new GsonBuilder().create();
		
		try{
			listaPersonasB = persona.busquedaAvanzada(persona);
			if(listaPersonasB.isEmpty()){
				resultado = "No se encontraron datos";
			}else{
				resultado = gson.toJson(listaPersonasB);
			}			
		}catch(PersistentException p){
			resultado = p.getMessage();
		}
		return resultado;
	}
	
	/**
	 * Entrega los datos de un perfil mediante su rut
	 * 
	 * @param cadenaBusqueda
	 * @return json 
	 * @throws PersistentException
	 */
	@WebMethod(operationName = "verPerfil")
	public String verPerfil(@WebParam(name = "run") String run) throws PersistentException{
		String resultado = "";		
		Persona persona = new Persona();
		persona.setRun(run);
		
		Gson gson = new GsonBuilder().create();	
				
		try{
			
			resultado = gson.toJson(persona = persona.getPersonaBusinessByRun(persona));
					
		}catch(PersistentException p){
			resultado = null;
		}
		return resultado;
	}
}
