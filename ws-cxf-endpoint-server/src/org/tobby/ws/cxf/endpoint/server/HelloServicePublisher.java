package org.tobby.ws.cxf.endpoint.server;

import javax.xml.ws.Endpoint;

import org.tobby.ws.cxf.endpoint.service.HelloServiceImpl;

public class HelloServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8899/helloService", new HelloServiceImpl());
		System.out.println("Hello Service Server Started...");
	}
}
