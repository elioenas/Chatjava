package Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements ServerIf {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public Servidor() throws RemoteException {
		super();
	}

	public static void main(String args[]) {
		try {
			Naming.rebind("Server1", new Servidor());
			System.out.println("Servidor Iniciado");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void connect(Usuario usuario) throws RemoteException {
		usuarios.add(usuario);
		try {
			usuario.setCallback((ComClient) Naming.lookup("//127.0.0.1/" + usuario.getNome()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("Usuario" + usuario.getNome() + "conectado");
	}

	@Override
	// desconectar o usuario
	public void disconnect(Usuario usuario) throws RemoteException {
		usuarios.remove(usuario);
		System.out.println("Usuario" + usuario.getNome() + "desconectou");
	}

	@Override
	public void broadcastmessage(Usuario usuario, String msg) throws RemoteException {
		// verifica os usuarios e envia para todos
		for (Usuario usuarioX : usuarios) {
			usuarioX.getCallback().receiveMessage(usuario.getNome() + " diz: " + msg);
		}
	}

}
