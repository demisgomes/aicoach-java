package teste;

import java.util.ArrayList;

import dominio.Jogador;
import perssistencia.JogadorDAO;

public class TesteJogadores {
	
	public static void main(String[] args){
		ArrayList <Jogador> listaJogador=new ArrayList<Jogador>();
		JogadorDAO jDAO=new JogadorDAO();
		
		Jogador jogador= jDAO.retornarJogador(25);
		System.out.println(jogador.getNome());
		System.out.println(jogador.getCaracteristicas().getVelocidade());
		System.out.println(jogador.getCaracteristicas().getBolaParada());
		System.out.println(jogador.getCaracteristicas().getCabeceio());
		System.out.println(jogador.getCaracteristicas().getControleBola());
		System.out.println(jogador.getCaracteristicas().getDrible());
		for(int i=0;i<jogador.getPosicoes().size();i++){
			System.out.println(jogador.getPosicoes().get(i).getNome()+ " "+jogador.getPosicoes().get(i).getPontuacao()+ " "+ jogador.getPosicoes().get(i).isPosicaoDeOrigem());
			
		}
		
	}

}
