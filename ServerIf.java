package Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIf extends Remote {

	void connect(Usuario usuario) throws RemoteException;

	void broadcastmessage(Usuario usuario, String msg) throws RemoteException;

	void disconnect(Usuario usuario) throws RemoteException;

}
