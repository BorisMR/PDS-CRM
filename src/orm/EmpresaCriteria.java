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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EmpresaCriteria extends AbstractORMCriteria {
	public final IntegerExpression idE;
	public final StringExpression rut;
	public final StringExpression nombre;
	public final CollectionExpression persona;
	
	public EmpresaCriteria(Criteria criteria) {
		super(criteria);
		idE = new IntegerExpression("idE", this);
		rut = new StringExpression("rut", this);
		nombre = new StringExpression("nombre", this);
		persona = new CollectionExpression("ORM_Persona", this);
	}
	
	public EmpresaCriteria(PersistentSession session) {
		this(session.createCriteria(Empresa.class));
	}
	
	public EmpresaCriteria() throws PersistentException {
		this(orm.PDSN1PersistentManager.instance().getSession());
	}
	
	public PersonaCriteria createPersonaCriteria() {
		return new PersonaCriteria(createCriteria("ORM_Persona"));
	}
	
	public Empresa uniqueEmpresa() {
		return (Empresa) super.uniqueResult();
	}
	
	public Empresa[] listEmpresa() {
		java.util.List list = super.list();
		return (Empresa[]) list.toArray(new Empresa[list.size()]);
	}
}

