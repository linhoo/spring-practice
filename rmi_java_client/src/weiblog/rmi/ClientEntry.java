package weiblog.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataserver.rmi.stub.UserManagerInterface;

public class ClientEntry {
	public static void main(String[] args) {
			try {
				Registry registry = LocateRegistry.getRegistry(2001);
				UserManagerInterface userManager = (UserManagerInterface)registry
						.lookup("userManager");
				System.out.println(userManager.getAdminAcount().getUsername()
						+ " " + userManager.getAdminAcount().getPassword());
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}


	}
}
