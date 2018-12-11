package Chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements ServidorIF {

	private static final long serialVersionUID = 1L;
	private ArrayList<ClienteIF> clientes;

	protected Servidor() throws RemoteException {
		super();
		clientes = new ArrayList<ClienteIF>();
	}

	@Override
	public synchronized void conectado(ClienteIF cliente) throws RemoteException {
		this.clientes.add(cliente);

	}

	@Override
	public synchronized void desconectado(ClienteIF cliente) throws RemoteException {
		this.clientes.remove(cliente);

	}

	@Override
	public synchronized void BroadcastMessage(String Message) throws RemoteException {
		int i = 0;
		while (i < clientes.size()) {
			clientes.get(i++).RecebendoMensagem(Message);
		}

	}

}
