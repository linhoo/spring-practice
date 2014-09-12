package dataserver.entry;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import dataserver.rmi.UserManagerImpl;
import dataserver.rmi.stub.UserManagerInterface;

public class Entry {
	public static void main(String[] args) throws RemoteException {
		UserManagerImpl userManager = new UserManagerImpl();
		UserManagerInterface userManagerI = (UserManagerInterface)UnicastRemoteObject
				.exportObject(userManager, 0);
		Registry registry = LocateRegistry.createRegistry(2001);
		registry.rebind("userManager", userManagerI);
		System.out.println("Server is ready");
	}
}
