package org.tobby.spring.remoting.hessian.server;

public class HelloServiceImpl implements HelloService {
	public String sayHello(String name) {
		System.out.println(name);
		return "My name TOBBY is Haaaaaaa ****** " + name;
	}
}
