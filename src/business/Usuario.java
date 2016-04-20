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
	private String user;	
	private String pass;
		
	public Usuario() {
	}
	
	/**
	  * Metodo que añade un usuario a la Base de datos
	  *
	  * @param Usuario Objeto que contiene la data a ingresar
	  * @return String Mensaje que indica si se realizo la transaccion
	  */
	public String addUsuarioBusiness(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		
		try {
			orm.Usuario lormUsuario = orm.UsuarioDAO.createUsuario();
			// Initialize the properties of the persistent object here
			lormUsuario.setUser(usuario.user);
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
				lormUsuario.setUser(usuario.user);
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
	  * Metodo que genera una tabla con los Usuario de la Base de datos
	  * 
	  * @return String Contiene la tabla generada con los datos
	  */
	public String listarUsuarioBusiness() throws PersistentException{
		final int ROW_COUNT = 100;
		orm.Usuario[] ormUsuario;
		String salida = "";
		int i = 0;
		
		try {
			ormUsuario = orm.UsuarioDAO.listUsuarioByQuery(null, null);
			int length = Math.min(ormUsuario.length, ROW_COUNT);
			
			List<orm.Usuario> lista = new ArrayList<orm.Usuario>();
			
			//crea lista con todos los usuarios
			for (i = 0; i < length; i++) {
				lista.add(ormUsuario[i]);
				
			}
			//insertar bootstrap y div a salida
			salida += "<table>";
			salida += "<tr><th>Usuario</th><th>Password</th></tr>";
			if(ormUsuario.length > 0){
				
				for (i = 0; i < ormUsuario.length; i++) {
					salida += "<tr>";
					salida += ("<td>"+ormUsuario[i].getUser()+"</td>");
					salida += ("<td>"+ormUsuario[i].getPass()+"</td>");
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
	 * 
	 * @param Usuario
	 * @return Verdadero solo si el usuario existe en la BD
	 * @throws PersistentException
	 */
	public boolean validarUsuarioBusiness(Usuario usuario) throws PersistentException{
		orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		
		//orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByQuery("Usuario.uidu = '"+usuario.idU+"'", null);
		//List<orm.Usuario> listaUsuarios 
		orm.Usuario[] usuarioQ = orm.UsuarioDAO.listUsuarioByQuery
				("Usuario.user = '"+usuario.user+"', Usuario.pass = '"+usuario.pass+"'", null);
		
		if(!usuarioQ[0].equals("")){
			return true;
		}else{
			return false;
		}
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
		return user;
	}
	
	/**
	 * 
	 * @param String User para el usuario
	 */
	public void setUser(String user) {
		this.user = user;
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
