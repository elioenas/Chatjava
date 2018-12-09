package Chat;

import java.io.Serializable;

public class Usuario implements Serializable {

	//atributos
	private String nome;
	private ComClient callback;
        private String msg;

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
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
