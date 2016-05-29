package business;

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
	private int idP_reg;
	
	/**
	 * Constructor vacio de Bitacora
	 */
	public Bitacora(){
		
	}
	
	/**
	 * Agregar registro a BD
	 * @param Bitacora bitacora con entrada a almacenar
	 * @return String Mensaje que indica si se almaceno el registro correctamente
	 * @throws PersistentException
	 */
	public String addBitacoraBusiness(Bitacora bit) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction(); 
		
		try{
			orm.Bitacora lormBitacora = orm.BitacoraDAO.createBitacora();
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByORMID(bit.getIdP_reg());
			
			lormBitacora.setEntrada(bit.entrada);
			lormBitacora.setPersonaidP(lormPersona);
			
			orm.BitacoraDAO.save(lormBitacora);
						
			t.commit();
			return "Registro guardado";
		}catch(PersistentException e) {
			t.rollback();
			return "No se pudo almacenar el registro";
		}	
	}

	/**
	 * @return the idB
	 */
	public int getIdB() {
		return idB;
	}

	/**
	 * @param idB the idB to set
	 */
	public void setIdB(int idB) {
		this.idB = idB;
	}

	/**
	 * @return the entrada
	 */
	public String getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the idP_reg
	 */
	public int getIdP_reg() {
		return idP_reg;
	}

	/**
	 * @param idP_reg the idP_reg to set
	 */
	public void setIdP_reg(int idP_reg) {
		this.idP_reg = idP_reg;
	}

	

}
