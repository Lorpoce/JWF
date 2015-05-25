package fr.esgi.jwf.webapp.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.esgi.web.framework.context.interfaces.IHtmlContext;

public class HtmlContext implements IHtmlContext {

	private String actionClass;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private List<File> uploadedFiles = new ArrayList<File>();
	private Map<String, Object> attributes = new HashMap<String, Object>();
	private Map<String, Object> sessionAttribute = new HashMap<String, Object>();
	private String title;
	private String description;
	private List<String> keywords = new ArrayList<String>();
	private List<String> cssLinks = new ArrayList<String>();
	private List<String> jsLinks = new ArrayList<String>();

	@Override
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	@Override
	public String getActionClass() {
		return this.actionClass;
	}

	@Override
	public HttpServletRequest _getRequest() {
		return request;
	}

	@Override
	public HttpServletResponse _getResponse() {
		return response;
	}

	@Override
	public Object getParameter(String key) {
		return parameters.get(key);
	}

	@Override
	public String[] getParameterKeys() {
		return (String[]) parameters.keySet().toArray();
	}

	@Override
	public File[] getUploadedFiles() {
		return (File[]) uploadedFiles.toArray();
	}

	@Override
	public void setAttribute(String key, Object o) {
		attributes.put(key, o);
	}

	@Override
	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	@Override
	public void setSessionAttribute(String key, Object value) {
		sessionAttribute.put(key, value);
	}

	@Override
	public Object getSessionAttribute(String key) {
		return sessionAttribute.get(key);
	}

	@Override
	public String[] getUserCredentials() {
		// TODO
		return null;
	}

	@Override
	public boolean resetSession() {
		// TODO
		return false;
	}

	@Override
	public IHtmlContext toHtmlContext() {
		return this;
	}

	@Override
	public void setPageTitle(String title) {
		this.title = title;
	}

	@Override
	public void setPageDescription(String description) {
		this.description = description;
	}

	@Override
	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}

	@Override
	public void addCssLink(String url) {
		cssLinks.add(url);
	}

	@Override
	public void addJsLink(String url) {
		jsLinks.add(url);
	}

	@Override
	public String getPageTitle() {
		return title;
	}

	@Override
	public String getPageDescription() {
		return description;
	}

	@Override
	public String[] getKeywords() {
		return (String[]) keywords.toArray();
	}

	@Override
	public String[] getCssLinks() {
		return (String[]) cssLinks.toArray();
	}

	@Override
	public String[] getJsLinks() {
		return (String[]) jsLinks.toArray();
	}

}
