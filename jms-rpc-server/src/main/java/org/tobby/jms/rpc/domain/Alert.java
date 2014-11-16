package org.tobby.jms.rpc.domain;

import java.io.Serializable;

public class Alert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5775836976167128245L;

	private int id;
	
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
