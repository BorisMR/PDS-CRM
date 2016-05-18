/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class UsuarioDAO {
	public static Usuario loadUsuarioByORMID(int idU) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, idU);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(int idU) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return getUsuarioByORMID(session, idU);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(int idU, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, idU, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(int idU, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return getUsuarioByORMID(session, idU, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(PersistentSession session, int idU) throws PersistentException {
		try {
			return (Usuario) session.load(orm.Usuario.class, new Integer(idU));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(PersistentSession session, int idU) throws PersistentException {
		try {
			return (Usuario) session.get(orm.Usuario.class, new Integer(idU));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(PersistentSession session, int idU, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario) session.load(orm.Usuario.class, new Integer(idU), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(PersistentSession session, int idU, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario) session.get(orm.Usuario.class, new Integer(idU), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy, lockMode);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}
	
	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy, lockMode);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.PDSN1PersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario createUsuario() {
		return new orm.Usuario();
	}
	
	public static boolean save(orm.Usuario usuario) throws PersistentException {
		try {
			orm.PDSN1PersistentManager.instance().saveObject(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Usuario usuario) throws PersistentException {
		try {
			orm.PDSN1PersistentManager.instance().deleteObject(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Usuario usuario) throws PersistentException {
		try {
			orm.PDSN1PersistentManager.instance().getSession().refresh(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Usuario usuario) throws PersistentException {
		try {
			orm.PDSN1PersistentManager.instance().getSession().evict(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		Usuario[] usuarios = listUsuarioByCriteria(usuarioCriteria);
		if(usuarios == null || usuarios.length == 0) {
			return null;
		}
		return usuarios[0];
	}
	
	public static Usuario[] listUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		return usuarioCriteria.listUsuario();
	}
}
