package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import negocio.formulas.FormulaPosicao;
import negocio.interfaces.InterfaceBotao;

import dominio.CaracteristicasJogadores;
import dominio.Jogador;

import perssistencia.CaracteristicaDAO;
import perssistencia.PontuacaoPosicaoDAO;

import gui.TelaCaracteristicas;
import gui.TelaJogadores;

public class ControladorCaracteristicas implements InterfaceBotao {

	@Override
	public void acaoBotao(final JFrame tela) {
		TelaCaracteristicas.getBtnConfirmar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res, cab, bp, cb, def, des, dri, fin, qp, vel;
				
				res=TelaCaracteristicas.getcBRessistencia().getSelectedIndex()+1;
				cab=TelaCaracteristicas.getcBCabeceio().getSelectedIndex()+1;
				bp=TelaCaracteristicas.getcBBolaParada().getSelectedIndex()+1;
				cb= TelaCaracteristicas.getcBControleBola().getSelectedIndex()+1;
				def= TelaCaracteristicas.getcBDefesa().getSelectedIndex()+1;
				des= TelaCaracteristicas.getcBDesarme().getSelectedIndex()+1;
				dri= TelaCaracteristicas.getcBDrible().getSelectedIndex()+1;
				fin= TelaCaracteristicas.getcBFinalizacao().getSelectedIndex()+1;
				qp= TelaCaracteristicas.getcBQualidadePasse().getSelectedIndex()+1;
				vel =TelaCaracteristicas.getcBVelocidade().getSelectedIndex()+1;
				
				CaracteristicasJogadores c = new CaracteristicasJogadores();
				
				c.setBolaParada(bp);
				c.setCabeceio(cab);
				c.setControleBola(cb);
				c.setDefesas(def);
				c.setDesarme(des);
				c.setDrible(dri);
				c.setFinalizacao(fin);
				c.setQualidadePasse(qp);
				c.setResistencia(res);
				c.setVelocidade(vel);
				
				CaracteristicaDAO cDAO=new CaracteristicaDAO();
				PontuacaoPosicaoDAO pDAO=new PontuacaoPosicaoDAO();
				
				if(Jogador.getJogadorEscolhido().getCaracteristicas()==null){
				
					
					//Insere em caracteristicas
					cDAO.inserirCaracteristicas(c, Jogador.getJogadorEscolhido());
					Jogador.getJogadorEscolhido().setCaracteristicas(c);
					//calcula a pontuação das posições
					Jogador.getJogadorEscolhido().calculeTudo();
					//Insere na tabelaPontuacaoPosicoes
					pDAO.inserirPontuacaoPosicoesJogador(Jogador.getJogadorEscolhido());
				}
				
				else{
					System.out.println("entrou no else");
					cDAO.updateCaracteristicas(c, Jogador.getJogadorEscolhido());
					Jogador.getJogadorEscolhido().setCaracteristicas(c);
					System.out.println(Jogador.getJogadorEscolhido().getCaracteristicas().getVelocidade());
					Jogador.getJogadorEscolhido().calculeTudo();
					System.out.println(Jogador.getJogadorEscolhido().getPosicoes().get(0).getPontuacao()+" "+Jogador.getJogadorEscolhido().getPosicoes().get(0).getNome());
					pDAO.updatePontuacaoPosicoesJogador(Jogador.getJogadorEscolhido());
				}
				
				TelaJogadores t=new TelaJogadores();
				t.setVisible(true);
				tela.dispose();
				
			}
		});
		
	}
	
	public void setCaracteristicas(){
		CaracteristicasJogadores c=Jogador.getJogadorEscolhido().getCaracteristicas();
		if(c!=null){
			
			TelaCaracteristicas.getcBBolaParada().setSelectedIndex(c.getBolaParada()-1);
			TelaCaracteristicas.getcBCabeceio().setSelectedIndex(c.getCabeceio()-1);
			TelaCaracteristicas.getcBControleBola().setSelectedIndex(c.getControleBola()-1);
			TelaCaracteristicas.getcBDefesa().setSelectedIndex(c.getDefesas()-1);
			TelaCaracteristicas.getcBDesarme().setSelectedIndex(c.getDesarme()-1);
			TelaCaracteristicas.getcBDrible().setSelectedIndex(c.getDrible()-1);
			TelaCaracteristicas.getcBFinalizacao().setSelectedIndex(c.getFinalizacao()-1);
			TelaCaracteristicas.getcBQualidadePasse().setSelectedIndex(c.getQualidadePasse()-1);
			TelaCaracteristicas.getcBRessistencia().setSelectedIndex(c.getResistencia()-1);
			TelaCaracteristicas.getcBVelocidade().setSelectedIndex(c.getVelocidade()-1);
		}
	}

}
