package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.FormulaPosicao;

import dominio.CaracteristicasJogadores;
import dominio.Jogador;

import perssistencia.CaracteristicaDAO;
import perssistencia.PontuacaoPosicaoDAO;

import gui.TelaCaracteristicas;
import gui.TelaJogadores;

public class ControladorCaracteristicas {
	
	public void insereCaracteristicas(final TelaCaracteristicas tela){
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
				
				//Insere em caracteristicas
				cDAO.inserirCaracteristicas(c, Jogador.getJogadorEscolhido());
				Jogador.getJogadorEscolhido().setCaracteristicas(c);
				FormulaPosicao f=new FormulaPosicao();
				//calcula a pontuação das posições
				f.calculeTudo(Jogador.getJogadorEscolhido());
				//Insere na tabelaPontuacaoPosicoes
				pDAO.inserirPontuacaoPosicoesJogador(Jogador.getJogadorEscolhido());
				
				TelaJogadores t=new TelaJogadores();
				t.setVisible(true);
				tela.dispose();
				
			}
		});
		
	}

}
