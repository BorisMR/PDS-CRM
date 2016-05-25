package business;

import javax.persistence.PersistenceException;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * 
 * @author Boris Morales R.
 * 
 * Clase encargada de la logica de negocio de la aplicacion
 * su tarea es la de efectuar transacciones con la BD 
 * para efectos de la bitacora
 *
 */
public class Bitacora {
	
	private int idB;
	private String entrada;
	
	/**
	 * Constructor vacio de Bitacora
	 */
	public Bitacora(){
		
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	
	/**
	 * Metodo que agrega una Entrada a la Base de datos
	 
	Public String addEntradaBusiness(Bitacora bitacora) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try{
			
		}catch(PersistenceException e){
			t.rollback();
			return "Business PersistentException: "+e.getMessage();
		}
	}
	*/
	
	

}
