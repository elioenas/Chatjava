package Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class DriverCliente {

	// vai criar o rmi pra se comunicar
	// localhost e o ip da sua maquina
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		String ServidorUrl = "rmi://192.168.0.22/Servidor";
		ServidorIF Servidor = (ServidorIF) Naming.lookup(ServidorUrl);
		// criar um thread pra iniciar servidor
		new Thread((Runnable) new Cliente(args[0],Servidor)).start();
	}
}
