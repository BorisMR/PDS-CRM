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

public class UsuarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idU;
	public final StringExpression usser;
	public final StringExpression pass;
	
	public UsuarioDetachedCriteria() {
		super(orm.Usuario.class, orm.UsuarioCriteria.class);
		idU = new IntegerExpression("idU", this.getDetachedCriteria());
		usser = new StringExpression("usser", this.getDetachedCriteria());
		pass = new StringExpression("pass", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.UsuarioCriteria.class);
		idU = new IntegerExpression("idU", this.getDetachedCriteria());
		usser = new StringExpression("usser", this.getDetachedCriteria());
		pass = new StringExpression("pass", this.getDetachedCriteria());
	}
	
	public Usuario uniqueUsuario(PersistentSession session) {
		return (Usuario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Usuario[] listUsuario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}

