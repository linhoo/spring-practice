package org.tobby.ws.spring.standalone.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	
	@WebMethod
	public String sayHello(String name);
	
}
