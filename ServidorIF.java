package Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorIF extends Remote {
	
	// vai conter as funcoes do cliente
	void conectado(ClienteIF cliente) throws RemoteException;
	void desconectado(ClienteIF cliente) throws RemoteException;
	void BroadcastMessage(String Message) throws RemoteException;
}
