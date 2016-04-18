package business;

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
public class Empresa {

	private int idE;
	private String rut;
	private String nombre;
	private String email;
	private String fono;
	private String direccion;
	
	public Empresa(){
		
	}
	
	/**
	 * Metodo que añade una Empresa a la Base de datos
	 *
	 * @param Empresa Objeto que contiene la data a ingresar
	 * @return String Mensaje que indica si se ralizo la transaccion
	 * @throws PersistentException
	 */
	public String addEmpresaBusiness(Empresa empresa) throws PersistentException{
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction(); 
		try{
			orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
			lormEmpresa.setRut(empresa.rut);
			lormEmpresa.setNombre(empresa.nombre);
			lormEmpresa.setEmail(empresa.email);
			lormEmpresa.setFono(empresa.fono);
			lormEmpresa.setDireccion(empresa.direccion);
			orm.EmpresaDAO.save(lormEmpresa);
			t.commit();
			return "Data Ingresada";

		}catch (NullPointerException e){
			return "ERROR: No existe una Empresa con ese RUT";
		}catch(Exception e) {
			t.rollback();
			return "ERROR";			
		}		
	}
	
}
