package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;
import dominio.CaracteristicasJogadores;
import dominio.EstatisticasJogador;
import dominio.Jogador;
import dominio.PontuacaoPosicao;
import dominio.Posicao;
import dominio.Time;

public class JogadorDAO{
	
	//Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
	private Banco banco;
	
	public JogadorDAO () {
		banco = Banco.getInstance();
		
	}
	
	public void inserirJogador(Jogador jogador){
		jogador.setId(retorneUltimoId()+1);
		String sql = "Insert into jogador (nome, peso, altura, idade, temcondicao, time) VALUES('"
				+ jogador.getNome()
				+ "','"
				+ jogador.getPeso()
				+ "','"
				+ jogador.getAltura()
				+ "','"
				+ jogador.getIdade()
				+ "','"
				+ jogador.getEscolhido()
				+ "','"
				+ jogador.getTime().getIdTime() + "')";
		
		banco.executarSQL(sql);
		
		
		for(Posicao p: jogador.getPosicoes()){
			if(p.isPosicaoDeOrigem()){
				String sql2="";
				
				if(p.getNome().toLowerCase().equals("goleiro")){
					sql2="UPDATE jogador SET goleiro =1  WHERE idjogador = '"+jogador.getId()+"'";
				}
				
				if(p.getNome().toLowerCase().equals("zagueiro")){
					sql2="UPDATE jogador SET zagueiro =1 WHERE idjogador = '"+jogador.getId()+"'";
				
				}

				if(p.getNome().toLowerCase().equals("lateral direito") || p.getNome().toLowerCase().equals("lateral esquerdo")){
					sql2="UPDATE jogador SET `lateral direito` =1,`lateral esquerdo` =1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}

				if(p.getNome().toLowerCase().equals("volante")){
					sql2="UPDATE jogador SET volante =1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}

				if(p.getNome().toLowerCase().equals("meia central")){
					sql2="UPDATE jogador SET `meia central` =1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}

				if(p.getNome().toLowerCase().equals("meia lateral")){
					sql2="UPDATE jogador SET `meia lateral direito` =1,`meia lateral esquerdo`=1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}

				if(p.getNome().toLowerCase().equals("meia atacante")){
					sql2="UPDATE jogador SET `meia atacante` =1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}

				if(p.getNome().toLowerCase().equals("ponta")){
					sql2="UPDATE jogador SET `ponta direita` =1,`ponta esquerda`=1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}	

				if(p.getNome().toLowerCase().equals("segundo atacante")){
					sql2="UPDATE jogador SET `segundo atacante` =1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}

				if(p.getNome().toLowerCase().equals("centro avante")){
					sql2="UPDATE jogador SET `centro avante` =1 WHERE idjogador = '"+jogador.getId()+"'";
					
				}
				
				banco.executarSQL(sql2);
			}
		}
		
	}
	public void excluirJogador(Jogador jogador){
		String sql = "DELETE FROM jogador WHERE id LIKE '"+jogador.getId()+"'";
		banco.executarSQL(sql);
	}
	
	public Jogador retornarJogador(int idJogador){
		String sql = "SELECT * FROM jogador WHERE idjogador = '"+idJogador+"'";
		ResultSet rs = banco.executarSelect(sql);
		int timeId=0;
		int posicaoTela=0;
		String nome=null;
		Time time = null ;
		Float peso = null;
		Float altura =null;
		int pontuacaoPosicaoAtual=0;
		int temCondicao = 0;
		int idade = 0;
		
		try {
			if(rs.next()){
				
				timeId=rs.getInt("time");
				nome = rs.getString("nome");			
				peso = rs.getFloat("peso");
				altura =rs.getFloat("altura");
				temCondicao=rs.getInt("temCondicao");
				posicaoTela=rs.getInt("posicaoTela");
				pontuacaoPosicaoAtual=rs.getInt("pontuacao_posicao_atual");
				idade = rs.getInt("idade");
			}
			
			CaracteristicaDAO caracDAO = new CaracteristicaDAO();
			CaracteristicasJogadores caracteristicas = caracDAO.retornarCaracteristicas(idJogador);
			
			ArrayList<Posicao> posicoes= new ArrayList<>();
			PontuacaoPosicaoDAO pontuacaoPosicaoDAO = new PontuacaoPosicaoDAO();
			ArrayList<PontuacaoPosicao> listapontuacao = pontuacaoPosicaoDAO.retornaPosicao(idJogador);
			
			for (int i = 0; i < listapontuacao.size(); i++) {
				Posicao posicao = new Posicao();
				PontuacaoPosicao pontuacaoPosicao  = listapontuacao.get(i);
				
				posicao.setNome(pontuacaoPosicao.getNomePosicao());
				posicao.setPontuacao(pontuacaoPosicao.getPontuacao());
				posicoes.add(posicao);
			}
			
			EstatisticasJogador estatisticas = new EstatisticasJogador();
			
			
			Jogador jogador = new Jogador(nome, time, peso, altura, temCondicao, posicoes, estatisticas, caracteristicas, idade);
			jogador.setId(idJogador);
			for (int i = 0; i < jogador.getPosicoes().size(); i++) {
				jogador.getPosicoes().get(i).setJogador(jogador);;
			}
			jogador.setIdPosicaoTela(posicaoTela);
			jogador.setPontuacaoPosicaoAtual(pontuacaoPosicaoAtual);
			insiraPosicaoOrigem(jogador);
			return jogador;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		
		
		
		
		finally{
			banco.fecharBanco();
		}
	}
	
	public ArrayList<Jogador> retornarJogadores(int idTime){
		String sql = "SELECT * FROM jogador WHERE time = '"+idTime+"'";
		ResultSet rs = banco.executarSelect(sql);
		ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
		
		try {
			while(rs.next()){
				int timeId=0;
				String nome=null;
				Time time = null ;
				Float peso = null;
				Float altura =null;
				int temCondicao = 0;
				int idJogador =0;
				int idade = 0;
				try {
					idJogador = rs.getInt("idjogador");
					timeId=rs.getInt("time");
					nome = rs.getString("nome");			
					peso = rs.getFloat("peso");
					altura =rs.getFloat("altura");
					temCondicao=rs.getInt("temCondicao");
					idade = rs.getInt("idade");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				CaracteristicaDAO caracDAO = new CaracteristicaDAO();
				CaracteristicasJogadores caracteristicas = caracDAO.retornarCaracteristicas(idJogador);
				
				ArrayList<Posicao> posicoes= new ArrayList<>();
				PontuacaoPosicaoDAO pontuacaoPosicaoDAO = new PontuacaoPosicaoDAO();
				ArrayList<PontuacaoPosicao> listapontuacao = pontuacaoPosicaoDAO.retornaPosicao(idJogador);
				
				for (int i = 0; i < listapontuacao.size(); i++) {
					Posicao posicao = new Posicao();
					PontuacaoPosicao pontuacaoPosicao  = listapontuacao.get(i);
					
					posicao.setNome(pontuacaoPosicao.getNomePosicao());
					posicao.setPontuacao(pontuacaoPosicao.getPontuacao());
					posicoes.add(posicao);
				}
				
				EstatisticasJogador estatisticas = new EstatisticasJogador();
				Jogador jogador = new Jogador(nome, time, peso, altura, temCondicao, posicoes, estatisticas, caracteristicas, idade);
				jogador.setId(idJogador);
				insiraPosicaoOrigem(jogador);
				for (int i = 0; i < jogador.getPosicoes().size(); i++) {
					jogador.getPosicoes().get(i).setJogador(jogador);;
				}
				listaJogadores.add(jogador);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		finally{
			banco.fecharBanco();
		}
		return listaJogadores;
	}
	
	public void insiraPosicaoOrigem(Jogador jogador){
		
		String sql = "SELECT * FROM jogador WHERE idjogador = "+jogador.getId()+"";
		ResultSet rs=banco.executarSelect(sql);
		
		for (int i = 0; i < jogador.getPosicoes().size(); i++) {
			try {
				if(rs.last()){
					if(jogador.getPosicoes().get(i).getNome().equals("lateral") || jogador.getPosicoes().get(i).getNome().equals("meia lateral") || jogador.getPosicoes().get(i).getNome().equals("ponta")){
						if(jogador.getPosicoes().get(i).getNome().equals("lateral")){
							
							
							if(rs.getInt("lateral direito")==1 || rs.getInt("lateral esquerdo")==1){
								jogador.getPosicoes().get(i).setPosicaoDeOrigem(true);
							}
						}
						if(jogador.getPosicoes().get(i).getNome().equals("meia lateral")){
							if(rs.getInt("meia lateral direito")==1 || rs.getInt("meia lateral esquerdo")==1){
								jogador.getPosicoes().get(i).setPosicaoDeOrigem(true);
							}
							
						}
						if(jogador.getPosicoes().get(i).getNome().equals("ponta")){
							if(rs.getInt("ponta direita")==1 || rs.getInt("ponta esquerda")==1){
								jogador.getPosicoes().get(i).setPosicaoDeOrigem(true);
							}
						}
					}
					
					else{
						if (rs.getInt(jogador.getPosicoes().get(i).getNome())==1){
							jogador.getPosicoes().get(i).setPosicaoDeOrigem(true);
						}
						
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				//banco.fecharBanco();
			}
		}
		
	}
	
	public void inserirIdPosicaoJogador(Jogador jogador, int id){
		String sql="UPDATE jogador SET posicaotela = '"+id+"', pontuacao_posicao_atual = '"+jogador.getPosicaoAtual().getPontuacao()+"' WHERE idjogador = '"+jogador.getId()+"'";
		banco.executarSQL(sql);
	}
	
	public void tirarIdPosicaoJogador(Time time){
		String sql="UPDATE jogador SET posicaotela = '0', pontuacao_posicao_atual= '0' WHERE time = '"+time.getIdTime()+"'";
		banco.executarSQL(sql);
	}
	
	
	public int retornarIdPosicaoJogador(Jogador jogador){
		String sql="SELECT posicaotela FROM jogador WHERE idjogador = '"+jogador.getId()+"'";
		ResultSet rs=banco.executarSelect(sql);
		int id=0;
		try {
			if(rs.next()){
				id=rs.getInt("posicaotela");
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally{
			banco.fecharBanco();
		}
	}
	
	public int retorneUltimoId(){
		try{
			String sql="Select * from jogador";
			ResultSet rs= banco.executarSelect(sql);
			int id=0;
			if(rs.last()){
				id=rs.getInt("idjogador");
			}
			
			return id;
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
		finally{
			banco.fecharBanco();
		}
	}
	
}
