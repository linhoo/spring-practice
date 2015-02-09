package org.tobby.spring.mail.domain;

public class Spittle {

	private String text;
	
	public Spittle(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
