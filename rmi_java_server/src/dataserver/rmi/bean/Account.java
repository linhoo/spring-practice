package dataserver.rmi.bean;

import java.io.Serializable;

public class Account implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4066349000006686569L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
