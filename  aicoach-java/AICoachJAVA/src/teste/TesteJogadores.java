package teste;

import java.util.ArrayList;

import negocio.FormulaPosicao;
import dominio.Jogador;
import dominio.PontuacaoPosicao;
import dominio.Time;
import perssistencia.JogadorDAO;
import perssistencia.PontuacaoPosicaoDAO;
import perssistencia.TimeDAO;

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
		//ppDAO.inserirPontuacaoPosicoesJogador(jogador);
		
		listaJogador=jDAO.retornarJogadores(3);
		/*for(Jogador j : listaJogador){
			form.calculeTudo(j);
			for(int i=0;i<j.getPosicoes().size();i++){
				System.out.println(j.getNome()+" "+ j.getPosicoes().get(i).getNome()+ " "+j.getPosicoes().get(i).getPontuacao()+ " "+ j.getPosicoes().get(i).isPosicaoDeOrigem());
				//ppDAO.inserirPontuacaoPosicoesJogador(j);
			}
		}*/
		
		TimeDAO tDAO= new TimeDAO();
		Time time= tDAO.retornarTime(3);
		time.setJogadores(listaJogador);
		
		System.out.println(time.getNome());
		System.out.println(time.getJogadores().size()+" jogadores");
		
		for(Jogador j : time.getJogadores()){
			System.out.println(j.getNome());
		
		}
		
	}

}
