package bd;


	import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

	public class Banco {
		
		private static Banco banco;
		private static boolean estanciado = false;
		private static String nome="aicoach";
		private static String url="jdbc:mysql://localhost/aicoach", senha="1234", root="root";
		private  Connection conn;
		
		private Banco(String url, String senha, String root) {
			setUrl(url);
			setSenha(senha);
			setRoot(root);
		}	
		
		public static Banco getInstance(){
			if(!estanciado){
				banco = new Banco(Banco.getUrl(),Banco.getSenha(), Banco.getRoot());
				estanciado = true;
			}
			return banco;
		}
		
		private static String getNome() {
			return nome;
		}

		private static void setNome(String nome) {
			Banco.nome = nome;
		}

		private static String getUrl() {
			return url;
		}

		private static void setUrl(String url) {
			Banco.url = url;
		}

		private static String getSenha() {
			return senha;
		}

		private static void setSenha(String senha) {
			Banco.senha = senha;
		}

		private static String getRoot() {
			return root;
		}

		private static void setRoot(String root) {
			Banco.root = root;
		}

		private Connection iniciarBanco(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				try {
					 conn = DriverManager.getConnection(getUrl(),getRoot(),getSenha());
					 //System.out.println("conectou(1)");
				} catch (Exception e1) {
					//System.out.println("Erro na coneccao(1)");
					e1.printStackTrace();
					try {
						setUrl("jdbc:mysql://localhost"); 
						conn = DriverManager.getConnection(getUrl(),getRoot(),getSenha());
						//System.out.println("conectou(2)");
					} catch (Exception e2) {
						//System.out.println("Erro na coneccao(2)");
						e2.printStackTrace();
					}
				}
			} catch (Exception e) {
				//System.out.println("Erro no driver");
				e.printStackTrace();
			}
			
			
			return conn;
		}
		
		
		public void fecharBanco(){
			try {
				conn.close();
				//System.out.println("desconectado");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void criarBanco(String nomeBanco){
			
			String sql = "CREATE DATABASE IF NOT EXISTS '"+nomeBanco+"'";			
				executarSQL(sql);
			
		}
		
		private void excluirBanco(String nomeBanco){
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
				//System.out.println("erro result set/n");
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
				//System.out.println("erro result set/n");
				er5.printStackTrace();
			}	
			finally{
				//fecharBanco();
			}
			return rs;
		}
}

