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

public class JogadorDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
	
	public JogadorDAO () {
		
		
	}
	
	public void inserirJogador(Jogador jogador){
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
				+ jogador.getTime() + "')";
		
		banco.executarSQL(sql);
		
	}
	public void excluirJogador(Jogador jogador){
		String sql = "DELETE FROM jogador WHERE id LIKE '"+jogador.getId()+"'";
		banco.executarSQL(sql);
	}
	
	public Jogador retornarJogador(int idJogador){
		String sql = "SELECT * FROM jogador WHERE idjogador = '"+idJogador+"'";
		ResultSet rs = banco.executarSelect(sql);
		int timeId=0;
		String nome=null;
		Time time = null ;
		Float peso = null;
		Float altura =null;
		int temCondicao = 0;
		
		try {
			if(rs.next()){
				
				timeId=rs.getInt("time");
				nome = rs.getString("nome");			
				peso = rs.getFloat("peso");
				altura =rs.getFloat("altura");
				temCondicao=rs.getInt("temCondicao");
			}
			
		} catch (SQLException e) {
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
		
		
		Jogador jogador = new Jogador(nome, time, peso, altura, temCondicao, posicoes, estatisticas, caracteristicas);
		jogador.setId(idJogador);
		for (int i = 0; i < jogador.getPosicoes().size(); i++) {
			jogador.getPosicoes().get(i).setJogador(jogador);;
		}
		insiraPosicaoOrigem(jogador);
		return jogador;
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
				try {
					idJogador = rs.getInt("idjogador");
					timeId=rs.getInt("time");
					nome = rs.getString("nome");			
					peso = rs.getFloat("peso");
					altura =rs.getFloat("altura");
					temCondicao=rs.getInt("temCondicao");
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
				Jogador jogador = new Jogador(nome, time, peso, altura, temCondicao, posicoes, estatisticas, caracteristicas);
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
		}
		
	}
	
}