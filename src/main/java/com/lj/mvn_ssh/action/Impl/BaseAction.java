package com.lj.mvn_ssh.action.Impl;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * 这个基础类用于获取基本的request和response
 * @author Administrator
 *
 */
public class BaseAction implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	private HttpServletRequest request;
	private ServletContext servletContext;
	private HttpServletResponse response;
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.servletContext = context;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	
	

}
