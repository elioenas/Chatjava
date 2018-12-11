package Chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Cliente extends UnicastRemoteObject implements ClienteIF {

	private ServidorIF servidor;
	private String nome = null;

	protected Cliente(String nome, ServidorIF servidor) throws RemoteException {

		this.nome = nome;
		this.servidor = servidor;
		servidor.conectado(this);

	}

	@Override
	public void RecebendoMensagem(String message) throws RemoteException {
		// TODO Auto-generated method stub

	}

	// chamando a thread pra ler os dados
	public void run() {

		// lendo os dados
		Scanner input = new Scanner(System.in);
		String msg;
		System.out.println("Nickname:");

		while (true) {
			msg = input.nextLine();
			mome = input.nextLine();
			try {
				servidor.BroadcastMessage("nickname" + ":" + msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	//capturar e mandar pro banco
	public void run1() throws RemoteException {

		ClienteDao ClienteDao = new ClienteDao();
	    ClienteDao.salvarCliente(ClienteDao);
	}

}
