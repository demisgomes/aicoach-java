package teste;

import java.util.ArrayList;

import negocio.AlgoritmoTatica;
import negocio.FormulaPosicao;
import dominio.Jogador;
import dominio.PontuacaoPosicao;
import dominio.Posicao;
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
		
		/*for(Jogador j : time.getJogadores()){
			System.out.println(j.getNome()+" escolhido? "+j.getEscolhido()+ " "+j.getPosicoes().get(0).getPontuacao());
		
		}
		*/
		TaticaDAO taticaDAO=new TaticaDAO();
		Tatica tatica = taticaDAO.retornarTatica("4-4-2");
		
		Tatica tatica433=taticaDAO.retornarTatica("4-3-3");
		
		Tatica tatica451=taticaDAO.retornarTatica("4-5-1");
		
		AlgoritmoTatica ATatica=new AlgoritmoTatica();
		
		ArrayList<Tatica> listaTaticas=taticaDAO.retornarListaTaticas();
		//listaTaticas.add(tatica);
		//listaTaticas.add(tatica433);
		//listaTaticas.add(tatica451);
		
		Tatica taticaUsada=ATatica.sugerirTatica(time, listaTaticas);
		System.out.println("T�tica usada ser�: "+taticaUsada.getNome());
		
		for (Posicao p : time.getTatica().getPosicoes()) {
			System.out.println(p.getNome()+" ser� "+ p.getJogador().getNome());
		}
		System.out.println(time.getEstiloDeJogo().getNome());
		
		/*time.setTatica(tatica);
		ATatica.SugerirJogadores(time);
		
		for(int j=0; j<time.getTatica().getPosicoes().size();j++){
			System.out.println(time.getTatica().getPosicoes().get(j).getNome()+" � "+time.getTatica().getPosicoes().get(j).getJogador().getNome());
		}
		
		time.setTatica(tatica433);
		System.out.println(tatica433.getPosicoes().size());
		System.out.println(time.getTatica().getPosicoes().size());
		ATatica.SugerirJogadores(time);
		
		System.out.println("4-3-3");
		System.out.println("------------------------------------------");
		System.out.println(time.getTatica().getPosicoes().size());
		for(int k=0; k<time.getTatica().getPosicoes().size();k++){
			System.out.println(time.getTatica().getPosicoes().get(k).getNome()+" � "+time.getTatica().getPosicoes().get(k).getJogador().getNome());
		}
		
		time.setTatica(tatica451);
		ATatica.SugerirJogadores(time);
		System.out.println("4-5-1");
		System.out.println("------------------------------------------");
		for(int l=0; l<time.getTatica().getPosicoes().size();l++){
			System.out.println(time.getTatica().getPosicoes().get(l).getNome()+" � "+time.getTatica().getPosicoes().get(l).getJogador().getNome());
		}*/
		
	}

}
