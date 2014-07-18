package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;
import dominio.Jogador;
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
		posicoes.add("ponta");
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
	
	public void inserirPontuacaoPosicoesJogador(Jogador jogador){
		int ptGol=0, ptLat=0, ptZag=0, ptVol=0, ptMC=0, ptML=0, ptMAT=0, ptSA=0, ptPT=0, ptCA=0;
		for (int i = 0; i < jogador.getPosicoes().size(); i++) {
			if(jogador.getPosicoes().get(i).getNome().equals("goleiro")){
				ptGol=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("zagueiro")){
				ptZag=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("lateral")){
				ptLat=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("volante")){
				ptVol=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("meia central")){
				ptMC=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("meia lateral")){
				ptML=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("meia atacante")){
				ptMAT=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("segundo atacante")){
				ptSA=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("ponta")){
				ptPT=jogador.getPosicoes().get(i).getPontuacao();
			}
			if(jogador.getPosicoes().get(i).getNome().equals("centro avante")){
				ptCA=jogador.getPosicoes().get(i).getPontuacao();
			}
		}
		String sql = "Insert into pontuacaoposicoes (`zagueiro`, `lateral esquerdo`, `lateral direito`, `volante`, `meia lateral direito`, `meia lateral esquerdo`, `meia central`, `meia atacante`, `segundo atacante`, `centro avante`, `ponta esquerda`, `ponta direita`, `jogador`, `goleiro`) VALUES ("
				+ "'"+ptZag+"',"
				+ "'"+ptLat+"',"
				+ "'"+ptLat+"',"
				+ "'"+ptVol+"',"
				+ "'"+ptML+"',"
				+ "'"+ptML+"',"
				+ "'"+ptMC+"',"
				+ "'"+ptMAT+"',"
				+ "'"+ptSA+"',"
				+ "'"+ptCA+"',"
				+ "'"+ptPT+"',"
				+ "'"+ptPT+"',"
				+ "'"+jogador.getId()+"',"
				+ "'"+ptGol+"')";
		
		banco.executarSQL(sql);
	}
}
