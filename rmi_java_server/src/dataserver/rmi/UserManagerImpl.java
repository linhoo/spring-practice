package dataserver.rmi;

import java.rmi.RemoteException;

import dataserver.rmi.bean.Account;
import dataserver.rmi.stub.UserManagerInterface;

public class UserManagerImpl implements UserManagerInterface {

	public String getUserName() throws RemoteException {
		return "Tobby Lee";
	}

	public Account getAdminAcount() throws RemoteException {
		Account account = new Account();
		account.setUsername("admin");
		account.setPassword("admin");
		return account;
	}

}
