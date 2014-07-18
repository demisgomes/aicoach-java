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
		
		ArrayList<String> posicoes = new ArrayList<String>();
		

		posicoes.add("zagueiro");
		//posicoes.add("lateral_esquerdo");
		//posicoes.add("lateral_direito");
		posicoes.add("lateral");
		posicoes.add("volante");
		//posicoes.add("meia_lateral_direito");
		//posicoes.add("meia_lateral_esquerdo");
		posicoes.add("meia lateral");
		//posicoes.add("meio_campo_central");
		posicoes.add("meia central");
		posicoes.add("meia atacante");
		posicoes.add("segundo atacante");
		posicoes.add("centro avante");
		//posicoes.add("ponta_esquerda");
		//posicoes.add("ponta_direita");
		posicoes.add("goleiro");

		ArrayList<PontuacaoPosicao> listaPontuacaoPosicoes = new ArrayList<PontuacaoPosicao>();

		for (int i = 0; i < posicoes.size(); i++) {
			
			PontuacaoPosicao obj = new PontuacaoPosicao();
			obj.setIdJogador(idJogador);
			obj.setNomePosicao(posicoes.get(i));
			int pontuacao = 0;
			
			try {
				if(rs.last()){
					
					if(posicoes.get(i).equals("lateral") || posicoes.get(i).equals("meia lateral") || posicoes.get(i).equals("ponta")){
						if(posicoes.get(i).equals("lateral")){
							pontuacao=rs.getInt("lateral direito");
						}
						if(posicoes.get(i).equals("meia lateral")){
							pontuacao=rs.getInt("meia lateral esquerdo");
							
						}
						if(posicoes.get(i).equals("ponta")){
							pontuacao=rs.getInt("ponta direita");
						}
					}
					
					else{
						pontuacao = rs.getInt(posicoes.get(i));
						
					}
					
					
				}
				
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
