package Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class DriverServidor {

	public static void main(String[] args) throws RemoteException, MalformedURLException {

		Naming.rebind("Servidor", new Servidor());
	}

}
