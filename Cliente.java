package Chat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.Thread;

public class Cliente extends UnicastRemoteObject implements ComClient {

	protected Cliente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ComClient callback;

		try {
			callback = (ComClient) Naming.lookup("//127.0.0.1/Server1");
			try {
				String nome = null;
				String msg;
				Naming.rebind(nome, new Cliente());
				System.out.println("----------------------------------------");
				System.out.println("-------------Seja Bem vindo"------------);
				System.out.println("-------------------------------=--------");
				System.out.println("Nickname:");
				Usuario usuario = new Usuario();
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// thread pra capturar as mensagens
	public void run() {

	}

	@Override
	public void receiveMessage(String string) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
