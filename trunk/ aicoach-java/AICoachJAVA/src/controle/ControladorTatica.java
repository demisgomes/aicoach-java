package controle;

import gui.TelaCriarTatica;
import gui.TelaInserirAlterarEsquema;
import gui.TelaInserirCombaterTatica;
import gui.TelaListaTimes;
import gui.TelaTatica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import perssistencia.JogadorDAO;
import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;

import negocio.AlgoritmoTatica;
import negocio.interfaces.InterfaceBotao;

import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class ControladorTatica implements InterfaceBotao {
	
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



	@Override
	public void acaoBotao(final JFrame tela) {
		TelaTatica.getBtnAlterarEsquema().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInserirAlterarEsquema telaInserir=new TelaInserirAlterarEsquema(TelaTatica.getTime());
				telaInserir.setVisible(true);
				
			}
		});
		
		TelaTatica.getBtnSugerirTtica().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Time time = TelaTatica.getTime();
				for (int j = 0; j < time.getJogadores().size(); j++) {
					time.getJogadores().get(j).setEscolhido(0);
					
				}
				
				AlgoritmoTatica aTatica=new AlgoritmoTatica();
				aTatica.sugerirTatica(time, TelaTatica.getListaTaticas());
				mostrarBotoes();
				TelaTatica.naoSalvar=false;
			}
		});
		
		TelaTatica.getBtnEscolherMelhoresJogadores().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Time time = TelaTatica.getTime();
				for (int j = 0; j < time.getJogadores().size(); j++) {
					time.getJogadores().get(j).setEscolhido(0);
					
				}

				TaticaDAO taticaDAO=new TaticaDAO();
				Tatica taticaEscolhida=taticaDAO.retornarTatica(TelaTatica.getComboBox().getSelectedItem().toString());
				
				
				
				time.setTatica(taticaEscolhida);
				AlgoritmoTatica aTatica= new AlgoritmoTatica();
				aTatica.SugerirJogadores(time);
				mostrarBotoes();
				TelaTatica.naoSalvar=false;
			}
			
		});
		
		TelaTatica.getBtnCombaterTtica().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInserirCombaterTatica telaCombaterTatica=new TelaInserirCombaterTatica(TelaTatica.getTime());
				telaCombaterTatica.setVisible(true);
			
			}
		});
		
		TelaTatica.getBtnCriarNovaTtica().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCriarTatica telaCriarTatica= new TelaCriarTatica();
				telaCriarTatica.setVisible(true);
				tela.dispose();
			}
		});
		
		TelaTatica.getBtnSalvarTtica().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ButtonAiCoach> listaBotoes =TelaTatica.getListaBotoes();
				ArrayList<Integer> listaJogador = TelaTatica.getListaJogador();
				Time time = TelaTatica.getTime();
				
				if(TelaTatica.naoSalvar){
					JOptionPane.showMessageDialog(null, "Por enquanto, o Combater Tática não pode ser salvo.");
				}
				
				else{
					
					JogadorDAO jdao=new JogadorDAO();
					jdao.tirarIdPosicaoJogador(time);
					for(int i=0;i<listaBotoes.size();i++){
						if(listaBotoes.get(i).getJogador()!=null){
							jdao.inserirIdPosicaoJogador(listaBotoes.get(i).getJogador(), listaBotoes.get(i).getId());
							//listaJogador.add(listaBotoes.get(i).getJogador().getId());
						}
					}
					TimeDAO timeDAO=new TimeDAO();
					timeDAO.inserirTimeTatica(time, listaJogador);
					JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
				}
			}
		});
		
		TelaTatica.getBtnSubstituir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Time time = TelaTatica.getTime();
				TaticaDAO taDAO=new TaticaDAO();
				boolean substituir = TelaTatica.isSubstituir();
				
				AlgoritmoTatica tatica= new AlgoritmoTatica();
				tatica.alterarEsquema(time, 1, taDAO.retornarTatica(time.getTatica().getNome()));
				substituir=true;
				mostrarBotoes();
				System.out.println("depois da confusão");
				System.out.println("-----------------------");
				for (Posicao p : time.getTatica().getPosicoes()) {
					System.out.println(p.getNome()+" será "+ p.getJogador().getNome()+ " "+ p.getJogador().getPosicaoAtual().getPontuacao()+" "+p.getIdPosicaoTela());
				}
				TelaTatica.naoSalvar=false;
			}
		});
		
		TelaTatica.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaListaTimes telaTimes = new TelaListaTimes();
				telaTimes.setVisible(true);
				tela.dispose();
			}
		});
		
	}
	
	

}
