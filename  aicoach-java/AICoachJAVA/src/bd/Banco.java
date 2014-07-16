package bd;


	import java.beans.Statement;
import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

	public class Banco {
		
		private String nome="aicoach";
		private String url="jdbc:mysql://localhost/aicoach", senha="root", root="root";
		private Connection conn;
		
		public Banco(String url, String senha, String root) {
			setUrl(url);
			setSenha(senha);
			setRoot(root);
		}

		public Banco() {
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
		
		
		public Connection iniciarBanco(){
			
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
		
		
		public void fecharBanco(){
			try {
				conn.close();
				System.out.println("desconectado");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void criarBanco(String nomeBanco){
			
			String sql = "CREATE DATABASE IF NOT EXISTS '"+nomeBanco+"'";			
				executarSQL(sql);
			
		}
		
		public void excluirBanco(String nomeBanco){
			setNome(nomeBanco);
			String sql = "DROP DATABASE '"+getNome()+"'";
	
			
				executarSQL(sql);
				
			
		}
		
		public void executarSQL(String sql){
			try {
			
				PreparedStatement st = iniciarBanco().prepareStatement(sql);
				st.execute(); // executa comando
				st.close();
				
			} catch (Exception er5) {
				System.out.println("erro result set/n");
				er5.printStackTrace();
			}	
			finally{
				fecharBanco();
			}
		}
}

