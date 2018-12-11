package Chat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ClienteDao extends ClienteVariaveis {

	public boolean salvarCliente(ClienteVariaveis clientevariaveis) {
		boolean salvou = true;
		Connection con = null;
		ConexaoBanco c = new ConexaoBanco(); // aqui eu crio um objeto atraves da primeira classe
		try {
			con = c.getConexao();
			if (con != null) {
				// aqui eu mando jogar na tabela do banco(Cliente) nos
				// campos(nome,endereco,estado e biografia) o que esta salvo dentro das
				// variaveis daquele objeto cliente que criamos la em cima.
				Statement stmt = con.createStatement();
				stmt.executeUpdate("insert into Cliente(nome,msg) values ('" + clientevariaveis.getNome() + "' , '"
						+ clientevariaveis.getMsg() + "')");
				salvou = false;
				System.out.println("Operação realizada com sucesso!");
			} else {
				System.out.println("Conexão nula.");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao tentar salvar registro no banco det dados." + ex);
		} finally {
			c.fechaConexao();
		}
		return salvou;
	}
}
