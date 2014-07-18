package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;

import dominio.PontuacaoPosicao;


public class PontuacaoPosicaoDAO {

	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
	
	public ArrayList<PontuacaoPosicao> retornaPosicao(int idJogador){
		String sql = "SELECT * FROM pontuacaoposicoes WHERE jogador = '"+idJogador+"'";
		ResultSet rs = banco.executarSelect(sql);
		
		ArrayList<String> posicoes = new ArrayList<>();
		posicoes.add("zagueiro");
		posicoes.add("lateral_esquerdo");
		posicoes.add("lateral_direito");
		posicoes.add("volante");
		posicoes.add("ala");
		posicoes.add("meia_lateral_direito");
		posicoes.add("meia_lateral_esquerdo");
		posicoes.add("meio_campo_central");
		posicoes.add("meia_atacante");
		posicoes.add("segundo_atacante");
		posicoes.add("centro_avante");
		posicoes.add("ponta_esquerda");
		posicoes.add("ponta_direita");
		posicoes.add("goleiro");
		
		ArrayList<PontuacaoPosicao> listaPontuacaoPosicoes = new ArrayList<>();
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
			
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPontuacaoPosicoes;
	}
}
