package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;

import dominio.PontuacaoPosicao;


public class PontuacaoPosicaoDAO {

	Banco banco = new Banco("jdbc:mysql://localhost/aicoach","1234","root");
	
	
	
	public ArrayList<PontuacaoPosicao> retornaPosicao(int idJogador){
		String sql = "SELECT * FROM pontuacaoposicoes WHRE jogador = '"+idJogador+"'";
		ResultSet rs = banco.executarSelect(sql);
		
		ArrayList<String> posicoes = null;
		posicoes.add("zagueiro");
		posicoes.add("lateral esquerdo");
		posicoes.add("lateral direito");
		posicoes.add("volante");
		posicoes.add("ala");
		posicoes.add("meia lateral direito");
		posicoes.add("meia lateral esquerdo");
		posicoes.add("meio campo central");
		posicoes.add("meia atacante");
		posicoes.add("segundo atacante");
		posicoes.add("centro avante");
		posicoes.add("ponta esquerda");
		posicoes.add("ponta direita");
		
		ArrayList<PontuacaoPosicao> listaPontuacaoPosicoes = null;
		for (int i = 0; i < posicoes.size(); i++) {
			
			PontuacaoPosicao obj = new PontuacaoPosicao();
			obj.setIdJogador(idJogador);
			obj.setNomePosicao(posicoes.get(i));
			int pontuacao = 0;
			
			try {
				pontuacao = rs.getInt(posicoes.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			obj.setPontuacao(pontuacao);
			listaPontuacaoPosicoes.add(obj);
		}
			
		
		return listaPontuacaoPosicoes;
	}
}
