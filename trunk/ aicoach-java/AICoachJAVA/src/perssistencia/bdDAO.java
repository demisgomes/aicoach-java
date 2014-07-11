package perssistencia;

import java.sql.Connection;

import bd.Banco;

public class bdDAO {
	
	private Connection conn;
	Banco banco = new Banco();
	
	public bdDAO() {
		setConn(banco.iniciaBanco());
		getConn();
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
}
