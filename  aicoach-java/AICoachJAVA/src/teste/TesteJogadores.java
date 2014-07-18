package teste;

import java.util.ArrayList;

import negocio.AlgoritmoTatica;
import negocio.FormulaPosicao;
import dominio.Jogador;
import dominio.PontuacaoPosicao;
import dominio.Tatica;
import dominio.Time;
import perssistencia.JogadorDAO;
import perssistencia.PontuacaoPosicaoDAO;
import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;

public class TesteJogadores {
	
	public static void main(String[] args){
		/*
		
		
		Jogador jogador= jDAO.retornarJogador(17);
		System.out.println(jogador.getNome());
		for(int i=0;i<jogador.getPosicoes().size();i++){
			System.out.println(jogador.getPosicoes().get(i).getNome()+ " "+jogador.getPosicoes().get(i).getPontuacao()+ " "+ jogador.getPosicoes().get(i).isPosicaoDeOrigem());
			
		}*/
		
		PontuacaoPosicaoDAO ppDAO=new PontuacaoPosicaoDAO();
		//ppDAO.inserirPontuacaoPosicoesJogador(jogador);
		ArrayList <Jogador> listaJogador=new ArrayList<Jogador>();
		JogadorDAO jDAO=new JogadorDAO();
		//listaJogador=jDAO.retornarJogadores(3);
		/*for(Jogador j : listaJogador){
			form.calculeTudo(j);
			for(int i=0;i<j.getPosicoes().size();i++){
				System.out.println(j.getNome()+" "+ j.getPosicoes().get(i).getNome()+ " "+j.getPosicoes().get(i).getPontuacao()+ " "+ j.getPosicoes().get(i).isPosicaoDeOrigem());
				//ppDAO.inserirPontuacaoPosicoesJogador(j);
			}
		}*/
		
		TimeDAO tDAO= new TimeDAO();
		Time time= tDAO.retornarTime(3);
		//time.setJogadores(listaJogador);
		
		System.out.println(time.getNome());
		System.out.println(time.getJogadores().size()+" jogadores");
		
		for(Jogador j : time.getJogadores()){
			System.out.println(j.getNome()+" escolhido? "+j.getEscolhido()+ " "+j.getPosicoes().get(0).getPontuacao());
		
		}
		
		TaticaDAO taticaDAO=new TaticaDAO();
		Tatica tatica = taticaDAO.retornarTatica("4-4-2");
		
		AlgoritmoTatica ATatica=new AlgoritmoTatica();
		time.setTatica(tatica);
		ATatica.SugerirJogadores(time);
		
	}

}
