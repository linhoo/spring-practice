package org.tobby.spring.jndi.origin;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OriginJndiTest {

	public static void main(String[] args) {
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc.otm");
			System.out.println(ds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
