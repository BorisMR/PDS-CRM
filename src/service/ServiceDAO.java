package service;

import org.orm.PersistentException;

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
	
	public String busquedaSimpleUsuario(String cadenaBusqueda){
		Usuario usuario = new Usuario();
		
		try {
			usuario.busquedaSimpleUsuario(cadenaBusqueda);
			return "Busqueda Existosa";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}
	
	public String busquedaSimplePersona(String cadenaBusqueda){
		Persona persona = new Persona();
		
		try {
			persona.busquedaSimplePersona(cadenaBusqueda);
			return "Busqueda Existosa";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}
	
	public String busquedaSimpleEmpresa(String cadenaBusqueda){
		Empresa empresa = new Empresa();
		
		try {
			empresa.busquedaSimpleEmpresa(cadenaBusqueda);
			return "Busqueda Existosa";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}
	
}
