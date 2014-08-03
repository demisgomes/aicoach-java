package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import negocio.FormulaPosicao;

import perssistencia.CaracteristicaDAO;
import perssistencia.PontuacaoPosicaoDAO;

import dominio.CaracteristicasJogadores;
import dominio.Jogador;

public class TelaCaracteristicas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaracteristicas frame = new TelaCaracteristicas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCaracteristicas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("finaliza\u00E7\u00E3o");
		lblNewLabel.setBounds(6, 96, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblBolaParada = new JLabel("bola parada");
		lblBolaParada.setBounds(228, 96, 62, 14);
		contentPane.add(lblBolaParada);
		
		JLabel lblRessistncia = new JLabel("ressist\u00EAncia");
		lblRessistncia.setBounds(10, 11, 66, 14);
		contentPane.add(lblRessistncia);
		
		JLabel lblQualidadeDoPasse = new JLabel("qualidade do passe");
		lblQualidadeDoPasse.setBounds(229, 11, 99, 14);
		contentPane.add(lblQualidadeDoPasse);
		
		JLabel lblVelocidade = new JLabel("velocidade");
		lblVelocidade.setBounds(6, 53, 66, 14);
		contentPane.add(lblVelocidade);
		
		JLabel lblCabeceio = new JLabel("cabeceio");
		lblCabeceio.setBounds(228, 53, 66, 14);
		contentPane.add(lblCabeceio);
		
		JLabel lblControleDeBola = new JLabel("controle de bola");
		lblControleDeBola.setBounds(6, 134, 87, 14);
		contentPane.add(lblControleDeBola);
		
		JLabel lblDrible = new JLabel("drible");
		lblDrible.setBounds(228, 134, 66, 14);
		contentPane.add(lblDrible);
		
		JLabel lblDesarme = new JLabel("desarme");
		lblDesarme.setBounds(6, 176, 66, 14);
		contentPane.add(lblDesarme);
		
		JLabel lblDefesa = new JLabel("defesa");
		lblDefesa.setBounds(224, 176, 66, 14);
		contentPane.add(lblDefesa);
		
		
		
		Integer [] lista=new Integer[10];
		for (int i = 0; i < lista.length; i++) {
			lista[i]=i+1;
		}
		
		final JComboBox cBRessistencia = new JComboBox(lista);
		cBRessistencia.setBounds(103, 8, 80, 20);
		contentPane.add(cBRessistencia);
		
		final JComboBox cBVelocidade = new JComboBox(lista);
		cBVelocidade.setBounds(103, 50, 80, 20);
		contentPane.add(cBVelocidade);
		
		final JComboBox cBFinalizacao = new JComboBox(lista);
		cBFinalizacao.setBounds(103, 93, 80, 20);
		contentPane.add(cBFinalizacao);
		
		final JComboBox cBControleBola = new JComboBox(lista);
		cBControleBola.setBounds(103, 131, 80, 20);
		contentPane.add(cBControleBola);
		
		final JComboBox cBDesarme = new JComboBox(lista);
		cBDesarme.setBounds(103, 173, 80, 20);
		contentPane.add(cBDesarme);
		
		final JComboBox cBQualidadePasse = new JComboBox(lista);
		cBQualidadePasse.setBounds(338, 8, 80, 20);
		contentPane.add(cBQualidadePasse);
		
		final JComboBox cBCabeceio = new JComboBox(lista);
		cBCabeceio.setBounds(338, 50, 80, 20);
		contentPane.add(cBCabeceio);
		
		final JComboBox cBBolaParada = new JComboBox(lista);
		cBBolaParada.setBounds(338, 93, 80, 20);
		contentPane.add(cBBolaParada);
		
		final JComboBox cBDrible = new JComboBox(lista);
		cBDrible.setBounds(338, 134, 80, 20);
		contentPane.add(cBDrible);
		
		final JComboBox cBDefesa = new JComboBox(lista);
		cBDefesa.setBounds(338, 173, 80, 20);
		contentPane.add(cBDefesa);
		
		
		//LÓGICA A SER IMPLEMENTADA NO CONTROLADOR
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(160, 228, 89, 23);
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res, cab, bp, cb, def, des, dri, fin, qp, vel;
				
				res=cBRessistencia.getSelectedIndex()+1;
				cab= cBCabeceio.getSelectedIndex()+1;
				bp=cBBolaParada.getSelectedIndex()+1;
				cb= cBControleBola.getSelectedIndex()+1;
				def= cBDefesa.getSelectedIndex()+1;
				des= cBDesarme.getSelectedIndex()+1;
				dri= cBDrible.getSelectedIndex()+1;
				fin= cBFinalizacao.getSelectedIndex()+1;
				qp= cBQualidadePasse.getSelectedIndex()+1;
				vel =cBVelocidade.getSelectedIndex()+1;
				
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
				dispose();
			}
		});
		contentPane.add(btnConfirmar);
		
	}
}
