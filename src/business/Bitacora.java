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
	 * Obtiene un ID de persona y devuelve una lista de bitacoras
	 * @param int ID de Persona
	 */
	public List<Bitacora> ListBitacorasByIDP(int idP){
		List<Bitacora> listaBitacoras = new ArrayList<Bitacora>();
		orm.Bitacora[] listabitacoraORM;
		
		try {
			listabitacoraORM = orm.BitacoraDAO.listBitacoraByQuery("Bitacora.personaidP="+idP, null);
			if(listabitacoraORM.length > 0){
				for (orm.Bitacora bitacora : listabitacoraORM) {
					Bitacora bitacoraB = new Bitacora();
					
					bitacoraB.setEntrada(bitacora.getEntrada());
					bitacoraB.setIdB(bitacora.getIdB());					
					
					listaBitacoras.add(bitacoraB);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaBitacoras;
	}
	
	/**
	 * Elimina todas las bitacoras asociadas al IDP
	 * 
	 * @param int ID Persona
	 */
	public boolean delBitacorasByIDP(int idP){
		//List<Bitacora> listaBitacoras = new ArrayList<Bitacora>();
		orm.Bitacora[] listabitacoraORM;
		
		try {
			listabitacoraORM = orm.BitacoraDAO.listBitacoraByQuery("Bitacora.personaidP="+idP, null);
			if(listabitacoraORM.length > 0){
				for (orm.Bitacora bitacora : listabitacoraORM) {					
					orm.BitacoraDAO.deleteAndDissociate(bitacora);
				}				
			}
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			return false;
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
