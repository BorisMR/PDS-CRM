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

public class PersonaCriteria extends AbstractORMCriteria {
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
	
	public PersonaCriteria(Criteria criteria) {
		super(criteria);
		idP = new IntegerExpression("idP", this);
		run = new StringExpression("run", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		email = new StringExpression("email", this);
		fono = new StringExpression("fono", this);
		direccion = new StringExpression("direccion", this);
		genero = new StringExpression("genero", this);
		foto_e64 = new StringExpression("foto_e64", this);
		empresaidEId = new IntegerExpression("empresaidE.idE", this);
		empresaidE = new AssociationExpression("empresaidE", this);
		bitacora = new CollectionExpression("ORM_Bitacora", this);
	}
	
	public PersonaCriteria(PersistentSession session) {
		this(session.createCriteria(Persona.class));
	}
	
	public PersonaCriteria() throws PersistentException {
		this(orm.PDSN1PersistentManager.instance().getSession());
	}
	
	public EmpresaCriteria createEmpresaidECriteria() {
		return new EmpresaCriteria(createCriteria("empresaidE"));
	}
	
	public BitacoraCriteria createBitacoraCriteria() {
		return new BitacoraCriteria(createCriteria("ORM_Bitacora"));
	}
	
	public Persona uniquePersona() {
		return (Persona) super.uniqueResult();
	}
	
	public Persona[] listPersona() {
		java.util.List list = super.list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

