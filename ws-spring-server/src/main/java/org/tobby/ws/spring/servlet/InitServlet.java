package org.tobby.ws.spring.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.Endpoint;

import org.tobby.ws.spring.endpoint.HelloServiceEndpoint;

public class InitServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		HelloServiceEndpoint endpoint = new HelloServiceEndpoint();
		Endpoint.publish("http://localhost:8779/services/HellosService", endpoint);
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
