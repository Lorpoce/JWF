package fr.esgi.jwf.webapp.router;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.router.interfaces.IRewriteRule;

import fr.esgi.jwf.webapp.action.CreateAction;
import fr.esgi.jwf.webapp.action.IndexAction;

public class UserRoute implements IRewriteRule {

	@Override
	public boolean matches(IContext context) {
		return true;
	}

	@Override
	public void rewrite(IContext context) {

		if (context._getRequest().getRequestURI().contains("create")) {
			context.setActionClass(CreateAction.class.getCanonicalName());
		} else {
			context.setActionClass(IndexAction.class.getCanonicalName());
		}
	}

}
