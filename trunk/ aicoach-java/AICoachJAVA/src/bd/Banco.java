package bd;


	import java.beans.Statement;
import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

	public class Banco {
		
		private static String nome="aicoach";
		private static String url="jdbc:mysql://localhost/aicoach", senha="root", root="root";
		private  Connection conn;
		
		public Banco(String url, String senha, String root) {
			setUrl(url);
			setSenha(senha);
			setRoot(root);
		}

		public Banco() {
			
		}	
		
		
		public static String getNome() {
			return nome;
		}

		public static void setNome(String nome) {
			Banco.nome = nome;
		}

		public static String getUrl() {
			return url;
		}

		public static void setUrl(String url) {
			Banco.url = url;
		}

		public static String getSenha() {
			return senha;
		}

		public static void setSenha(String senha) {
			Banco.senha = senha;
		}

		public static String getRoot() {
			return root;
		}

		public static void setRoot(String root) {
			Banco.root = root;
		}

		private Connection iniciarBanco(){
			
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
		
		
		private void fecharBanco(){
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
			
				PreparedStatement pst = iniciarBanco().prepareStatement(sql);
				pst.execute(); // executa comando
				pst.close();
				
			} catch (Exception er5) {
				System.out.println("erro result set/n");
				er5.printStackTrace();
			}	
			finally{
				fecharBanco();
			}
		}
		
		public ResultSet executarSelect(String sql){
			ResultSet rs = null;
			try {
			
				java.sql.Statement st = iniciarBanco().createStatement();
				rs = st.executeQuery(sql); 
				
			} catch (Exception er5) {
				System.out.println("erro result set/n");
				er5.printStackTrace();
			}	
			finally{
				fecharBanco();
			}
			return rs;
		}
}

