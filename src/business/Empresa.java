package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * 
 * @author Boris Morales R.
 * 
 * Clase encargada de la logica de negocio de la aplicacion
 * su tarea es la de efectuar transacciones con la BD
 *
 */
public class Empresa {

	private int idE;
	private String rut;
	private String nombre;
	
	/**
	 * Constructor vacio de Empresa
	 */
	public Empresa(){
		
	}
	
	/**
	 * Metodo que agrega una Empresa a la Base de datos
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
			orm.EmpresaDAO.save(lormEmpresa);
			t.commit();
			return "Data Ingresada en la BD";
		}catch (PersistentException e){
			t.rollback();
			return "Business PersistentException: "+e.getMessage();
		}		
	}
	
	/**
	  * Metodo que elimina una empresa de la Base de datos
	  * usando el rut de la Empresa recibida
	  *
	  * @param Empresa Objeto del que se extrae el rut para eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  * @throws PersistentException
	  */
	public String delEmpresaBusinessIdE(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.idE = '"+empresa.idE+"'", null);
			// Delete the persistent object
			orm.EmpresaDAO.delete(lormEmpresa);
			t.commit();
			return "Data Eliminada";
		}

		catch (PersistentException e){
			return "Business PersistentException: "+e.getMessage();
		}
	}
	
	/**
	  * Metodo que elimina una empresa de la Base de datos
	  * usando el id de la Empresa recibida
	  *
	  * @param Empresa Objeto del que se extrae el id para eliminar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  * @throws PersistentException
	  */
	public String delEmpresaBusiness(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.rut = '"+empresa.rut+"'", null);
			// Delete the persistent object
			orm.EmpresaDAO.delete(lormEmpresa);
			t.commit();
			return "Data Eliminada";
		}

		catch (PersistentException e){
			return "Business PersistentException: "+e.getMessage();
		}
	}

	/**
	  * Metodo que edita una empresa de la Base de datos
	  * usando el ID de la Empresa recibida
	  *
	  * @param Empresa Objeto del que se extrae el rut para editar
	  * @return String Mensaje que indica si se ralizo la transaccion
	  */
	public String editEmpresaBusiness(Empresa empresa){
		PersistentTransaction t;
		try {
			t = orm.PDSN1PersistentManager.instance().getSession().beginTransaction();
			try {
				
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.idE = '"+empresa.idE+"'", null);
				// Update the properties of the persistent object
				lormEmpresa.setRut(empresa.rut);
				lormEmpresa.setNombre(empresa.nombre);
								
				orm.EmpresaDAO.save(lormEmpresa);
				t.commit();
				return "Data Editada";
			}
			catch (Exception e) {
				t.rollback();
				return "ERROR: no se edito la data ";
			}
		} catch (PersistentException e1) {
			return "Business PersistentException: "+e1.getMessage();
		}
	}

	/**
	  * Metodo que genera una Lista con las Empresa de la Base de datos
	  * 
	  * @return List<Empresa> Contiene la lista
	  */
	@SuppressWarnings("unchecked")
	public List<Empresa> listEmpresaBusiness() throws PersistentException{
		List<Empresa> listaEmpresa = new ArrayList<Empresa>();
		List<orm.Empresa> listaEmpresasBD = new ArrayList<orm.Empresa>();
		
		listaEmpresasBD = orm.EmpresaDAO.queryEmpresa("Empresa.rut='*' ",null);
		
		if(!listaEmpresasBD.isEmpty()){			
			for( orm.Empresa empresaORM : listaEmpresasBD){
				
				Empresa empresaB = new Empresa();
				
				empresaB.setIdE(empresaORM.getIdE());
				empresaB.setRut(empresaORM.getRut());
				empresaB.setNombre(empresaORM.getNombre());				
								
				listaEmpresa.add(empresaB);
			}
		}				
		return listaEmpresa;
	}
	
	/**
	 * metodo que retorna un ArrayList con las empresas agregadas
	 * 
	 * @return ArrayList<orm.Empresa>
	 * @throws PersistentException
	 */
	public ArrayList<orm.Empresa> listEmpresaArray()throws PersistentException{
		ArrayList<orm.Empresa> empresas = null;
		orm.Empresa[] aux;
		aux = orm.EmpresaDAO.listEmpresaByQuery(null, null);
		empresas = new ArrayList<>(Arrays.asList(aux));
		return empresas;		
	}
		

	/**
	 * @return int id de la Empresa
	 */
	public int getIdE() {
		return idE;
	}

	/**
	 * @param id el idE a asignar
	 */
	public void setIdE(int idE) {
		this.idE = idE;
	}

	/**
	 * @return String el rut
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param rut el rut a asignar
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * @return String el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
