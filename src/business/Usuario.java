package business;

import java.util.ArrayList;
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
public class Usuario {

	private int idU;	
	private String usser;	
	private String pass;
		
	public Usuario() {
	}
	
	/**
	  * Metodo que agrega un usuario a la Base de datos
	  *
	  * @param Usuario Objeto que contiene la data a ingresar
	  * @return String Mensaje que indica si se realizo la transaccion
	  */
	public String addUsuarioBusiness(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		
		try {
			orm.Usuario lormUsuario = orm.UsuarioDAO.createUsuario();
			// Initialize the properties of the persistent object here
			lormUsuario.setUsser(usuario.usser);
			lormUsuario.setPass(usuario.pass);
			
			orm.UsuarioDAO.save(lormUsuario);
			t.commit();
			return "Data Ingresada";
		}
		catch (Exception e) {
			t.rollback();
			return "ERROR";
		}
		
	}
	
	/**
	  * Metodo que elimina un usuario de la Base de datos
	  * usando el ID del Usuario recibido
	  *
	  * @param Usuario Objeto del que se extrae el ID a eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  */
	public String delUsuarioBusiness(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByQuery("Usuario.idU = '"+usuario.idU+"'", null);
			// Delete the persistent object
			orm.UsuarioDAO.delete(lormUsuario);
			t.commit();
			return "Data Eliminada";
		}
		catch (Exception e) {
			t.rollback();
			return "ERROR: No existe un usuario con ese ID";
		}
		
	}
	
	/**
	  * Metodo que edita un Usuario de la Base de datos
	  * usando el ID del Usuario recibido
	  *
	  * @param Usuario Objeto del que se extrae el ID a editar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  */
	public String editUsuarioBusiness(Usuario usuario){
		PersistentTransaction t;
		try {
			t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
			try {
				
				orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByQuery("Usuario.idU = '"+usuario.idU+"'", null);
				// Update the properties of the persistent object
				lormUsuario.setUsser(usuario.usser);
				lormUsuario.setPass(usuario.pass);
				
				orm.UsuarioDAO.save(lormUsuario);
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
	 * valida si el usuario y su pass, existen en la BD
	 * 
	 * @param Usuario
	 * @return boolean Validacion
	 * @throws PersistentException
	 */
	public boolean validarUsuarioBusiness(Usuario usuario) throws PersistentException{
		orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		boolean validador = false;
		
		orm.Usuario[] usuarioQ;
		usuarioQ = orm.UsuarioDAO.listUsuarioByQuery("Usuario.usser = '"+usuario.usser+"' AND Usuario.pass = '"+usuario.pass+"'", null);
				
		validador = (usuarioQ.length > 0) ? true : false;
		
		return validador;
	}
	
	/**
	 * Efectua una busqueda simple de usuarios basada en una cadena de texto
	 * 
	 * @param busqueda
	 * @return
	 * @throws PersistentException
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> busquedaSimpleUsuario(String busqueda) throws PersistentException {
		List<Usuario> listaUsuariosFinded = new ArrayList<Usuario>();
		List<orm.Usuario> listaUsuariosQuery = new ArrayList<orm.Usuario>();
		
		listaUsuariosQuery = orm.UsuarioDAO.queryUsuario("Usuario.usser='"+busqueda, null);
				//+"' OR Usuario.pass='"+busqueda
				//+"' ",null);
		if(!listaUsuariosQuery.isEmpty()){
			for (orm.Usuario usuarioORM : listaUsuariosQuery) {
				Usuario usuario = new Usuario();
				
				usuario.setUser(usuarioORM.getPass());
				usuario.setPassword(usuarioORM.getPass());
				
				listaUsuariosFinded.add(usuario);
			}
		}		
		return listaUsuariosFinded;
	}
	
	/**
	 * 
	 * @return int Id del usuario
	 */
	public int getIdU() {
		return idU;
	}
	/**
	 * 
	 * @param int Id del usuario
	 */
	public void setIdU(int idU) {
		this.idU = idU;
	}
	/**
	 * 
	 * @return String User del usuario
	 */
	public String getUser() {
		return usser;
	}
	
	/**
	 * 
	 * @param String User para el usuario
	 */
	public void setUser(String user) {
		this.usser = user;
	}
	
	/**
	 * 
	 * @return String Password del usuario
	 */
	public String getPassword() {
		return pass;
	}
	/**
	 * 
	 * @param String Password para el usuario
	 */
	public void setPassword(String pass) {
		this.pass = pass;
	}
	
}
