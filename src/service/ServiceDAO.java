package service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.apache.log4j.Logger;
import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import business.*;

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
}
