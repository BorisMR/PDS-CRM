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
 * CRUD de las clases y facilitar al WS el manejo de la capa de negocio
 * 
 * @author Boris Morales Ríos
 *
 */
public class ServiceDAO {
	
	public String addUsuario(String user, String pass){
		
		Usuario usuario = new Usuario();
		
		usuario.setUser(user);
		usuario.setPassword(pass);
		
		try {
			usuario.addUsuarioBusiness(usuario);
			return "Usuario Ingresado a la BD";
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return "No se pudo ingresar Usuario a la BD";
	}
	
	/**
	 * Efectua una busqueda simple en base a una cadena de texto
	 * 
	 * @param cadenaBusqueda
	 * @return
	 * @throws PersistentException
	 */
	@WebMethod(operationName = "busquedaSimple")
	public String busquedaSimple(@WebParam(name = "cadenaBusqueda") String cadenaBusqueda) throws PersistentException{
		String resultado = "";		
		List<Persona> lista = new ArrayList<Persona>();
		Persona persona = new Persona();
		Gson gson = new GsonBuilder().create();
		
		lista = persona.busquedaSimplePersona(cadenaBusqueda);
		resultado = gson.toJson(lista);
		
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
		
		//asignaciones
		
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
				return "No se encontraron datos";
			}else{
				return gson.toJson(listaPersonasB);
				//return listaPersonasB.get(0).getNombre();
			}			
		}catch(PersistentException p){
			return "PersistentException";
		}
		
	}
}
