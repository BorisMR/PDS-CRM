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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EmpresaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idE;
	public final StringExpression rut;
	public final StringExpression nombre;
	public final StringExpression email;
	public final StringExpression fono;
	public final StringExpression direccion;
	public final CollectionExpression persona;
	
	public EmpresaDetachedCriteria() {
		super(orm.Empresa.class, orm.EmpresaCriteria.class);
		idE = new IntegerExpression("idE", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		fono = new StringExpression("fono", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		persona = new CollectionExpression("ORM_Persona", this.getDetachedCriteria());
	}
	
	public EmpresaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.EmpresaCriteria.class);
		idE = new IntegerExpression("idE", this.getDetachedCriteria());
		rut = new StringExpression("rut", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		fono = new StringExpression("fono", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		persona = new CollectionExpression("ORM_Persona", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria createPersonaCriteria() {
		return new PersonaDetachedCriteria(createCriteria("ORM_Persona"));
	}
	
	public Empresa uniqueEmpresa(PersistentSession session) {
		return (Empresa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Empresa[] listEmpresa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Empresa[]) list.toArray(new Empresa[list.size()]);
	}
}

