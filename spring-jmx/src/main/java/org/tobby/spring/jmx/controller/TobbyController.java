package org.tobby.spring.jmx.controller;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("spitter:name=TobbyController")
public class TobbyController {

	@ManagedOperation
	public String setSpittlesPerPage33(){
		return "HASSSSSSSSSSSSS";
	}
}
