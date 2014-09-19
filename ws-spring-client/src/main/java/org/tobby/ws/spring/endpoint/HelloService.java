package org.tobby.ws.spring.endpoint;

import javax.jws.WebService;

@WebService
public interface HelloService {
	
	public String sayHello(String name);
	
}
