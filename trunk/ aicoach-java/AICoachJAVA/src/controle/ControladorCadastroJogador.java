package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;

import gui.TelaCadastrarJogador;
import gui.TelaCriarTime;
import gui.TelaTime;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import negocio.interfaces.InterfaceBotao;

import dominio.Jogador;
import dominio.Posicao;
import dominio.Time;
import perssistencia.JogadorDAO;
import perssistencia.TimeDAO;

public class ControladorCadastroJogador implements InterfaceBotao{
	
	private JogadorDAO jogadorDAO;
	
	public ControladorCadastroJogador(){
		
	}
	
	private void inserirJogador(){
		String nome;
		float altura, peso;
		int idade;
		ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
		checkBoxList.add(TelaCadastrarJogador.getChckbGoleiro());
		checkBoxList.add(TelaCadastrarJogador.getChckbxCentroAvante());
		checkBoxList.add(TelaCadastrarJogador.getChckbxLateralDireito());
		checkBoxList.add(TelaCadastrarJogador.getChckbxLateralEsquerdo());
		checkBoxList.add(TelaCadastrarJogador.getChckbxMeiaAtacante());
		checkBoxList.add(TelaCadastrarJogador.getChckbxMeiaCentral());
		checkBoxList.add(TelaCadastrarJogador.getChckbxMeiaLateral());
		checkBoxList.add(TelaCadastrarJogador.getChckbxPonta());
		checkBoxList.add(TelaCadastrarJogador.getChckbxSegundoAtacante());
		checkBoxList.add(TelaCadastrarJogador.getChckbxVolante());
		checkBoxList.add(TelaCadastrarJogador.getChckbxZagueiro());
		nome = TelaCadastrarJogador.getTxtNome().getText();
		idade = Integer.parseInt(TelaCadastrarJogador.getTxtIdade().getText());
		altura = Float.parseFloat(TelaCadastrarJogador.getTxtAltura().getText());
		peso = Float.parseFloat(TelaCadastrarJogador.getTxtPeso().getText());
		
		Jogador jogador = new Jogador(nome, peso, altura, idade);
		ArrayList<Posicao> l=new ArrayList<Posicao>();
		jogador.setPosicoes(l);
		for (int i = 0; i < checkBoxList.size(); i++) {
			if(checkBoxList.get(i).isSelected()){
				Posicao posicao = new Posicao(checkBoxList.get(i).getText());
				posicao.setPosicaoDeOrigem(true);
				jogador.getPosicoes().add(posicao);
			}
			
		}
		
		
		this.inserirJogador(jogador);
		
	}
	
	private void inserirJogador(Jogador jogador){	
		jogador.setTime(Time.getTime());
		/*for(Posicao p: jogador.getPosicoes()){
			System.out.println(p.getNome());
		}*/
		jogadorDAO=new JogadorDAO();
		jogadorDAO.inserirJogador(jogador);
		jogador.getTime().getJogadores().add(jogador);
	
	}
	

	@Override
	public void acaoBotao(final JFrame tela) {
		TelaCadastrarJogador.getBtnConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inserirJogador();
				TelaTime telaTime = new TelaTime();
				telaTime.setVisible(true);
				tela.dispose();
				
			}
		});
	
		
	}
	
	
	

}
