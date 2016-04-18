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
}
