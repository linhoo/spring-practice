package org.tobby.spring.remoting.rest.domain;

public class Spittle {
	
	private long id;
	
	private String text;
	
	public Spittle() {
	}
	
	public Spittle(long id, String text) {
		this.id = id;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
