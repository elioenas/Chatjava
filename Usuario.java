package Chat;

import java.io.Serializable;

public class Usuario implements Serializable {

	//atributos
	private String nome;
	private ComClient callback;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ComClient getCallback() {
		return callback;
	}

	public void setCallback(ComClient callback) {
		this.callback = callback;
	}

}
