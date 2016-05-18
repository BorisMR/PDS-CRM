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
 * @author Boris Morales R�os
 *
 */
public class ServiceDAO {
	
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
		
		//verificar campos nulos y efectuar asignaciones vacias en caso de.
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
		// FIN asignaciones
		
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
}
