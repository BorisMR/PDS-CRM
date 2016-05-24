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

public class PersonaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idP;
	public final StringExpression run;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression email;
	public final StringExpression fono;
	public final StringExpression direccion;
	public final StringExpression genero;
	public final StringExpression foto_e64;
	public final IntegerExpression empresaidEId;
	public final AssociationExpression empresaidE;
	public final CollectionExpression bitacora;
	
	public PersonaDetachedCriteria() {
		super(orm.Persona.class, orm.PersonaCriteria.class);
		idP = new IntegerExpression("idP", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		fono = new StringExpression("fono", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		genero = new StringExpression("genero", this.getDetachedCriteria());
		foto_e64 = new StringExpression("foto_e64", this.getDetachedCriteria());
		empresaidEId = new IntegerExpression("empresaidE.idE", this.getDetachedCriteria());
		empresaidE = new AssociationExpression("empresaidE", this.getDetachedCriteria());
		bitacora = new CollectionExpression("ORM_Bitacora", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.PersonaCriteria.class);
		idP = new IntegerExpression("idP", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		fono = new StringExpression("fono", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		genero = new StringExpression("genero", this.getDetachedCriteria());
		foto_e64 = new StringExpression("foto_e64", this.getDetachedCriteria());
		empresaidEId = new IntegerExpression("empresaidE.idE", this.getDetachedCriteria());
		empresaidE = new AssociationExpression("empresaidE", this.getDetachedCriteria());
		bitacora = new CollectionExpression("ORM_Bitacora", this.getDetachedCriteria());
	}
	
	public EmpresaDetachedCriteria createEmpresaidECriteria() {
		return new EmpresaDetachedCriteria(createCriteria("empresaidE"));
	}
	
	public BitacoraDetachedCriteria createBitacoraCriteria() {
		return new BitacoraDetachedCriteria(createCriteria("ORM_Bitacora"));
	}
	
	public Persona uniquePersona(PersistentSession session) {
		return (Persona) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Persona[] listPersona(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

