package org.tobby.ws.spring.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.tobby.ws.spring.service.HelloService;

@WebService(serviceName="helloService")
public class HelloServiceEndpoint extends SpringBeanAutowiringSupport {

	@Autowired
	HelloService helloService;
	
	@WebMethod
	public String sayHello(String name) {
		return helloService.sayHello(name);
	}
	
}
