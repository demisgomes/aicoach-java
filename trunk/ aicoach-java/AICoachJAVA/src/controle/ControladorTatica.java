package controle;

import gui.TelaTatica;

import java.awt.Color;
import java.util.ArrayList;

import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Time;

public class ControladorTatica {
	
	
	public void acaoBotoes(){
		//todo
	}
	

	
	public static void mostrarBotoes(){
		ArrayList<ButtonAiCoach> listaBotoes =TelaTatica.getListaBotoes();
		ArrayList<Integer> listaJogador = TelaTatica.getListaJogador();
		ArrayList<Posicao> listaIdPosicoes = TelaTatica.getListaIdPosicoes();
		Time time = TelaTatica.getTime();

		for(int j=0;j<listaBotoes.size();j++){
			listaBotoes.get(j).setVisible(false);
			listaBotoes.get(j).setBackground(Color.GRAY);
			listaBotoes.get(j).setJogador(null);
		}
		
			listaJogador.clear();
			
		
		listaIdPosicoes.clear();				
		for(Posicao p: time.getTatica().getPosicoes()){
			listaIdPosicoes.add(p);
		}
		//for (Posicao p : time.getTatica().getPosicoes()) {
			//System.out.println(p.getNome()+" será "+ p.getJogador().getNome()+ " "+ p.getIdPosicaoTela());
			//}
		for(int i=0;i<11;i++){
			for(int j=0;j<listaBotoes.size();j++){
				
				if(listaIdPosicoes.get(i).getIdPosicaoTela()==listaBotoes.get(j).getId()){
					listaBotoes.get(j).setBackground(Color.GREEN);
					
					//listaBotoes.get(j).setLabel(listaIdPosicoes.get(i).getNome());
					break;
				}
			}
			
		}
		
		for(int j=0;j<listaBotoes.size();j++){
			if(listaBotoes.get(j).getBackground()==Color.green){
				listaBotoes.get(j).setVisible(true);
				for(int k=0;k<time.getTatica().getPosicoes().size();k++){
					if(listaBotoes.get(j).getId()==time.getTatica().getPosicoes().get(k).getIdPosicaoTela()){
						listaBotoes.get(j).setJogador(time.getTatica().getPosicoes().get(k).getJogador());
						//System.out.println("Botão "+time.getTatica().getPosicoes().get(k).getJogador().getNome());
						listaBotoes.get(j).setLabel("<html><p style='margin-left: -15pt;'>"+time.getTatica().getPosicoes().get(k).getJogador().getNome()+"<br> ("+time.getTatica().getPosicoes().get(k).getPontuacao()+")</p><html>");
						//listaBotoes.get(j).setLabel(time.getTatica().getPosicoes().get(k).getJogador().getNome()+" ("+time.getTatica().getPosicoes().get(k).getPontuacao()+")");
						
						listaBotoes.get(j).setSize(62, 62);
						//listaBotoes.get(j).setBorder(new RoundedBorder(20));
						//listaBotoes.get(j).setLabel("<html>FINALIZAR<br>COMPRA</html>");
						break;
					}
				}
			}
		}
		
		for(int i=0;i<listaBotoes.size();i++){
			if(listaBotoes.get(i).getJogador()!=null){
				listaJogador.add(listaBotoes.get(i).getJogador().getId());
				//System.out.println(listaBotoes.get(i).getJogador().getId()+" "+listaBotoes.get(i).getJogador()+" Botões"+" "+listaBotoes.get(i).getId());
			}
		}
		
	
	}
	
	

}
