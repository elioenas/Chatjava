package Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClienteIF extends Remote {

	void RecebendoMensagem(String message) throws RemoteException;
}
