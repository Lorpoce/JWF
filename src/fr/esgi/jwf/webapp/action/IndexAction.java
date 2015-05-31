package fr.esgi.jwf.webapp.action;

import java.util.List;

import org.esgi.web.framework.action.interfaces.IActionRenderable;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

import fr.esgi.jwf.webapp.renderer.IndexRenderer;

public class IndexAction implements IActionRenderable {

	private IRenderer renderer;
	private IContext context;
	private List<String> roles;
	private int priority;

	@Override
	public int setPriority(int priority) {
		this.priority = priority;
		return priority;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public void addCredential(String role) {
		this.roles.add(role);
	}

	@Override
	public boolean needsCredentials() {
		return false;
	}

	@Override
	public boolean hasCredential(String[] roles) {

		for (String role : roles) {
			if (this.roles.contains(role)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void proceed(IContext context) {
		this.context = context;
		this.setRenderer(new IndexRenderer());
		this.render();
	}

	@Override
	public void setRenderer(IRenderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public String render() {
		return renderer.render(context);
	}

}
