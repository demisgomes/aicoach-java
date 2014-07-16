package bd;


	import java.beans.Statement;
import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

	public class Banco {
		
		private String nome;
		private String url, senha, root;
		private Connection conn;
		
		public Banco(String url, String senha, String root) {
			setUrl(url);
			setSenha(senha);
			setRoot(root);
		}

		public Banco() {
			setUrl("jdbc:mysql://localhost/aicoach");
			setSenha("root");
			setRoot("root");
		}
		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getRoot() {
			return root;
		}

		public void setRoot(String root) {
			this.root = root;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
		public Connection iniciaBanco(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				try {
					 conn = DriverManager.getConnection(getUrl(),getRoot(),getSenha());
					 System.out.println("conectou(1)");
				} catch (Exception e1) {
					System.out.println("Erro na coneccao(1)");
					e1.printStackTrace();
					try {
						setUrl("jdbc:mysql://localhost"); 
						conn = DriverManager.getConnection(getUrl(),getRoot(),getSenha());
						System.out.println("conectou(2)");
					} catch (Exception e2) {
						System.out.println("Erro na coneccao(2)");
						e2.printStackTrace();
					}
				}
			} catch (Exception e) {
				System.out.println("Erro no driver");
				e.printStackTrace();
			}
			return conn;
		}
		
		public void criaBanco(String nomeBanco){
			setNome(nomeBanco);
			String sql = "CREATE DATABASE IF NOT EXISTS '"+getNome()+"'";
	
			try {
				java.sql.Statement stmt = iniciaBanco().createStatement();
				
				try {
					ResultSet rs;
					rs = stmt.executeQuery(sql);
				} catch (Exception er) {
					System.out.println("erro result set/n");
					er.printStackTrace();}
			} catch (SQLException er1) {
				System.out.println("erro statement/n");
				er1.printStackTrace();
			}
		}
		
		public void excluirBanco(String nomeBanco){
			setNome(nomeBanco);
			String sql = "DROP DATABASE '"+getNome()+"'";
	
			try {
				java.sql.Statement stmt = iniciaBanco().createStatement();
				
				try {
					ResultSet rs;
					rs = stmt.executeQuery(sql);
				} catch (Exception er2) {
					System.out.println("erro result set/n");
					er2.printStackTrace();
				}
			} catch (SQLException er3) {
				System.out.println("erro statement/n");
				er3.printStackTrace();
			}
		}
}

