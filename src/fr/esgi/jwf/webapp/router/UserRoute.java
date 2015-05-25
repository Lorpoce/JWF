package fr.esgi.jwf.webapp.router;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.router.interfaces.IRewriteRule;

import fr.esgi.jwf.webapp.action.LoginAction;

public class UserRoute implements IRewriteRule {

	@Override
	public boolean matches(IContext context) {
		return true;
	}

	@Override
	public void rewrite(IContext context) {

		context.setActionClass(LoginAction.class.getCanonicalName());

	}

}
