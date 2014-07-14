package bd;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

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
		
		/*public void criarBd(){
			String sql = "CREATE DATABASE IF NOT EXISTS '"+getNome()+"'";
		}*/
		
		public Connection iniciaBanco(){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				try {
					 conn = DriverManager.getConnection(getUrl(),getRoot(),getSenha());
					 System.out.println("conectou(1)");
				} catch (Exception e) {
					System.out.println("Erro na coneccao(1)");
					try {
						setUrl("jdbc:mysql://localhost"); 
						conn = DriverManager.getConnection(getUrl(),getRoot(),getSenha());
						System.out.println("conectou(2)");
					} catch (Exception e2) {
						System.out.println("Erro na coneccao(2)");
					}
				}
			} catch (Exception e) {
				System.out.println("Erro no driver");
			}
			return conn;
		}

		
}
