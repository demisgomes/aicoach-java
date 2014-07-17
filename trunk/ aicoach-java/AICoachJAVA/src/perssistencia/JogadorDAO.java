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
	Banco banco = new Banco("jdbc:mysql://localhost/aicoach","1234","root");
	
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
			timeId=rs.getInt("time");
			nome = rs.getString("nome");			
			peso = rs.getFloat("peso");
			altura =rs.getFloat("altura");
			temCondicao=rs.getInt("temCondicao");
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
		
		return jogador;
	}
	
	public ArrayList<Jogador> retornarJogadores(int idTime){
		String sql = "SELECT * FROM jogador WHERE time = '"+idTime+"'";
		ResultSet rs = banco.executarSelect(sql);
		ArrayList<Jogador> listaJogadores = new ArrayList<>();
		
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
				listaJogadores.add(jogador);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaJogadores;
	}
	
}
