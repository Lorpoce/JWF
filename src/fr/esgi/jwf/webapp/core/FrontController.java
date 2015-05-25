package fr.esgi.jwf.webapp.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.core.interfaces.IFrontController;
import org.esgi.web.framework.router.interfaces.IDispatcher;
import org.esgi.web.framework.router.interfaces.IRewriter;

import fr.esgi.jwf.webapp.context.Context;
import fr.esgi.jwf.webapp.router.Dispatcher;
import fr.esgi.jwf.webapp.router.Rewriter;
import fr.esgi.jwf.webapp.router.UserRoute;

/**
 * HttpServlet implementation class FrontController
 */
public class FrontController extends HttpServlet implements IFrontController {
	private static final long serialVersionUID = 1L;
	private IDispatcher dispatcher;
	private IRewriter rewriter;

	@Override
	public void init() throws ServletException {
		super.init();
		dispatcher = new Dispatcher();
		rewriter = new Rewriter(new UserRoute());
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		IContext context = createContext(request, response);
		rewriter.rewrite(context);
		dispatcher.dispatch(context);
	}

	private IContext createContext(HttpServletRequest request,
			HttpServletResponse response) {
		return new Context(request, response);
	}
}
