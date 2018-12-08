package Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComClient extends Remote {

	void receiveMessage(String string) throws RemoteException;
}
