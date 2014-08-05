package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.interfaces.InterfaceBotao;

import perssistencia.TaticaDAO;

import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Tatica;

import gui.TelaCriarTatica;
import gui.TelaTatica;

public class ControladorCadastroTatica implements InterfaceBotao {
	
	public void mudaCorBotao(ButtonAiCoach button){
		if(button.getBackground()==Color.gray){
			if(TelaCriarTatica.getListaPosicaoTaticaNova().size()<11){
				button.setBackground(Color.GREEN);
				TelaCriarTatica.getListaPosicaoTaticaNova().add(new Posicao(button.getId()));
			}
			else{
				//JOptionPane.showMessageDialog("O Máximo é de 11 jogadores.", null);
			}
		}
		else
		if(button.getBackground()==Color.GREEN){
			button.setBackground(Color.GRAY);
			for(Posicao p:TelaCriarTatica.getListaPosicaoTaticaNova()){
				if(p.getIdPosicaoTela()==button.getId()){
					TelaCriarTatica.getListaPosicaoTaticaNova().remove(p);
				}
				
			}
		}
	}


	@Override
	public void acaoBotao(final JFrame tela) {
		TelaCriarTatica.getBtnCa().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnCa());	
			}
		});
		
		TelaCriarTatica.getBtnLd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnLd());			
			}
		});
		
		TelaCriarTatica.getBtnLd_1().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnLd_1());	
			}
		});
		
		TelaCriarTatica.getBtnLe().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnLe());	
			}
		});
		
		TelaCriarTatica.getBtnLe_1().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnLe_1());
			}
		});
		
		TelaCriarTatica.getBtnMat().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMat());
			}
		});
		
		TelaCriarTatica.getBtnMat_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMat_1());
			}
		});
		
		TelaCriarTatica.getBtnMat_2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMat_2());
			}
		});
		
		TelaCriarTatica.getBtnMc().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMc());
			}
		});
		
		TelaCriarTatica.getBtnMc_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMc_1());
				
			}
		});
		
		TelaCriarTatica.getBtnMc_2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMc_2());
			}
		});
		
		TelaCriarTatica.getBtnMld().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMld());
			}
		});
		
		TelaCriarTatica.getBtnMld_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMld_1());
			}
		});
		
		TelaCriarTatica.getBtnMle().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMle());
				
			}
		});
		
		TelaCriarTatica.getBtnMle_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnMle_1());
			}
		});
		
		TelaCriarTatica.getBtnPtd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnPtd());			
			}
		});
		
		TelaCriarTatica.getBtnPte().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnPte());			
			}
		});
		
		TelaCriarTatica.getBtnSa_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnSa_1());			
			}
		});
		
		TelaCriarTatica.getBtnVol().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnVol());			
			}
		});
		
		TelaCriarTatica.getBtnVol_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnVol_1());			
			}
		});
		
		TelaCriarTatica.getBtnVol_2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnVol_2());			
			}
		});
		
		TelaCriarTatica.getBtnZc().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnZc());			
			}
		});
		
		TelaCriarTatica.getBtnZc_1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnZc_1());			
			}
		});
		
		TelaCriarTatica.getBtnZc_2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(TelaCriarTatica.getBtnZc_2());			
			}
		});
		
		TelaCriarTatica.getBtnVoltar().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaTatica telaTatica = new TelaTatica();
				telaTatica.setVisible(true);
				tela.dispose();
			}
		});
		
		TelaCriarTatica.getBtnNewButton().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TelaCriarTatica.getListaPosicaoTaticaNova().size()==11){
					TaticaDAO tDAO=new TaticaDAO();
					Tatica tatica=tDAO.retornarTatica(TelaCriarTatica.getTextField().getText());
					if(tatica==null){
						tDAO.inserirTatica(new Tatica(TelaCriarTatica.getTextField().getText(), TelaCriarTatica.getListaPosicaoTaticaNova()));
						JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Já há uma tática com esse nome.");
						
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Apenas 11 jogadores");
				}
			}
		});
		
	}
	
	
	
	
	
	

}
