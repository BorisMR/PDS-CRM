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

public class BitacoraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idB;
	public final StringExpression entrada;
	public final IntegerExpression personaidPId;
	public final AssociationExpression personaidP;
	
	public BitacoraDetachedCriteria() {
		super(orm.Bitacora.class, orm.BitacoraCriteria.class);
		idB = new IntegerExpression("idB", this.getDetachedCriteria());
		entrada = new StringExpression("entrada", this.getDetachedCriteria());
		personaidPId = new IntegerExpression("personaidP.idP", this.getDetachedCriteria());
		personaidP = new AssociationExpression("personaidP", this.getDetachedCriteria());
	}
	
	public BitacoraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.BitacoraCriteria.class);
		idB = new IntegerExpression("idB", this.getDetachedCriteria());
		entrada = new StringExpression("entrada", this.getDetachedCriteria());
		personaidPId = new IntegerExpression("personaidP.idP", this.getDetachedCriteria());
		personaidP = new AssociationExpression("personaidP", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria createPersonaidPCriteria() {
		return new PersonaDetachedCriteria(createCriteria("personaidP"));
	}
	
	public Bitacora uniqueBitacora(PersistentSession session) {
		return (Bitacora) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Bitacora[] listBitacora(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Bitacora[]) list.toArray(new Bitacora[list.size()]);
	}
}

