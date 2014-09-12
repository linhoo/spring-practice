package dataserver.rmi.stub;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataserver.rmi.bean.Account;

public interface UserManagerInterface extends Remote {
	public String getUserName() throws RemoteException;
	public Account getAdminAcount() throws RemoteException;
}
