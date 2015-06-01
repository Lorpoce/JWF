package fr.esgi.jwf.webapp.renderer;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

import fr.esgi.jwf.Constantes;
import fr.esgi.jwf.webapp.context.Context;

public class CreateRenderer implements IRenderer {

	@Override
	public String render(IContext context) {

		try {

			context._getResponse().setContentType("text/html");

			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class",
					ClasspathResourceLoader.class.getName());
			ve.init();

			Template t = ve.getTemplate(Constantes.PATH_TEMPLATE + "create.vm");

			VelocityContext contextV = new VelocityContext();

			Context htmlContext = (Context) context.toHtmlContext();
			htmlContext.setPageTitle(Constantes.TITLE);

			contextV.put("context", htmlContext);

			StringWriter writer = new StringWriter();
			t.merge(contextV, writer);

			context._getResponse().getOutputStream().println(writer.toString());

			return writer.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

}
