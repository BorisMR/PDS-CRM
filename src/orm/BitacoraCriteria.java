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

public class BitacoraCriteria extends AbstractORMCriteria {
	public final IntegerExpression idB;
	public final StringExpression entrada;
	public final IntegerExpression personaidPId;
	public final AssociationExpression personaidP;
	
	public BitacoraCriteria(Criteria criteria) {
		super(criteria);
		idB = new IntegerExpression("idB", this);
		entrada = new StringExpression("entrada", this);
		personaidPId = new IntegerExpression("personaidP.idP", this);
		personaidP = new AssociationExpression("personaidP", this);
	}
	
	public BitacoraCriteria(PersistentSession session) {
		this(session.createCriteria(Bitacora.class));
	}
	
	public BitacoraCriteria() throws PersistentException {
		this(orm.PDSN1PersistentManager.instance().getSession());
	}
	
	public PersonaCriteria createPersonaidPCriteria() {
		return new PersonaCriteria(createCriteria("personaidP"));
	}
	
	public Bitacora uniqueBitacora() {
		return (Bitacora) super.uniqueResult();
	}
	
	public Bitacora[] listBitacora() {
		java.util.List list = super.list();
		return (Bitacora[]) list.toArray(new Bitacora[list.size()]);
	}
}

