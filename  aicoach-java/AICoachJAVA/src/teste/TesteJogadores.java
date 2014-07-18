package teste;

import java.util.ArrayList;

import negocio.FormulaPosicao;
import dominio.Jogador;
import dominio.PontuacaoPosicao;
import perssistencia.JogadorDAO;
import perssistencia.PontuacaoPosicaoDAO;

public class TesteJogadores {
	
	public static void main(String[] args){
		ArrayList <Jogador> listaJogador=new ArrayList<Jogador>();
		JogadorDAO jDAO=new JogadorDAO();
		
		Jogador jogador= jDAO.retornarJogador(17);
		System.out.println(jogador.getNome());
		FormulaPosicao form=new FormulaPosicao();
		form.calculeTudo(jogador);
		for(int i=0;i<jogador.getPosicoes().size();i++){
			System.out.println(jogador.getPosicoes().get(i).getNome()+ " "+jogador.getPosicoes().get(i).getPontuacao()+ " "+ jogador.getPosicoes().get(i).isPosicaoDeOrigem());
			
		}
		
		PontuacaoPosicaoDAO ppDAO=new PontuacaoPosicaoDAO();
		ppDAO.inserirPontuacaoPosicoesJogador(jogador);
		
	}

}
