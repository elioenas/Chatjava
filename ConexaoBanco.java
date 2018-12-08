package Chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {

	private static Connection con;
	// java.sql.Connection conexao = null;
	// a linha abaxo vai chamar o driver baixado
	final static String driver = "com.mysql.jdbc.Driver";
	// informacoes do banco
	//*****trocar a porta depois
	final static String url = "jdbc:mysql://localhost:3306/";
	final static String name = "Projeto";
	final static String user = "root";
	final static String password = "";

	public static Connection getConexao() throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url + name, user, password);
		}
		return con;
	}

	public static void fechaConexao() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void fechaStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
