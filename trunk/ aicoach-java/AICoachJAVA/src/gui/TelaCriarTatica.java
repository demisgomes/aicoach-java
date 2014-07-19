package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

import javax.swing.JButton;
import javax.swing.JTextField;

import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;

public class TelaCriarTatica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	static ArrayList<Posicao> listaPosicaoTaticaNova=new ArrayList<Posicao>();
	
	ButtonAiCoach btnSa;
	Time time;
	ArrayList<ButtonAiCoach> listaBotoes = new ArrayList<ButtonAiCoach>();
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarTatica frame = new TelaCriarTatica();
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
	public TelaCriarTatica(){}
	public TelaCriarTatica(final Time time) {
		setTitle("Criar T\u00E1tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.time=time;
		TimeDAO timeDAO=new TimeDAO();
		timeDAO.retornarTime(time.getIdTime());
		
		
		final 
		ButtonAiCoach btnGL = new ButtonAiCoach("GL");
		btnGL.setBackground(Color.GREEN);
		
		btnGL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		listaPosicaoTaticaNova.add(new Posicao(1));
		contentPane.setLayout(null);
		btnGL.setBounds(42, 277, 64, 54);
		btnGL.setId(1);
		listaBotoes.add(btnGL);
		contentPane.add(btnGL);
		
		
		final ButtonAiCoach btnZc_2 = new ButtonAiCoach("ZC");
		btnZc_2.setBackground(Color.GRAY);
		btnZc_2.setBounds(128, 192, 58, 54);
		btnZc_2.setId(5);
		btnZc_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnZc_2);
			}
		});
		listaBotoes.add(btnZc_2);
		contentPane.add(btnZc_2);
		
		final ButtonAiCoach btnZc = new ButtonAiCoach("ZC");
		btnZc.setBackground(Color.GRAY);
		btnZc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnZc);
			}
		});
		btnZc.setId(3);
		listaBotoes.add(btnZc);
		btnZc.setBounds(128, 361, 58, 55);
		contentPane.add(btnZc);
		
		
		
		final ButtonAiCoach btnLd = new ButtonAiCoach("LD");
		btnLd.setBackground(Color.GRAY);
		btnLd.setBounds(130, 452, 56, 54);
		btnLd.setId(2);
		btnLd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnLd);
			}
		});
		listaBotoes.add(btnLd);
		contentPane.add(btnLd);
		
		final ButtonAiCoach btnZc_1 = new ButtonAiCoach("ZC");
		btnZc_1.setBackground(Color.GRAY);
		btnZc_1.setBounds(128, 277, 58, 54);
		btnZc_1.setId(4);
		btnZc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnZc_1);
			}
		});
		listaBotoes.add(btnZc_1);
		contentPane.add(btnZc_1);
		
		final ButtonAiCoach btnLe = new ButtonAiCoach("LE");
		btnLe.setId(6);
		btnLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnLe);
			}
		});
		btnLe.setBackground(Color.GRAY);
		btnLe.setBounds(130, 113, 56, 54);
		listaBotoes.add(btnLe);
		contentPane.add(btnLe);
		
		final ButtonAiCoach btnVol = new ButtonAiCoach("VOL");
		btnVol.setBackground(Color.GRAY);
		btnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnVol);
			}
		});
		btnVol.setBounds(225, 373, 58, 54);
		btnVol.setId(8);
		listaBotoes.add(btnVol);
		contentPane.add(btnVol);
		
		
		final ButtonAiCoach btnVol_1 = new ButtonAiCoach("VOL");
		btnVol_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnVol_1);
			}
		});
		btnVol_1.setBackground(Color.GRAY);
		btnVol_1.setBounds(225, 277, 58, 54);
		btnVol_1.setId(9);
		listaBotoes.add(btnVol_1);
		contentPane.add(btnVol_1);
		
		final ButtonAiCoach btnVol_2 = new ButtonAiCoach("VOL");
		btnVol_2.setBackground(Color.GRAY);
		btnVol_2.setBounds(225, 192, 58, 54);
		btnVol_2.setId(10);
		btnVol_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnVol_2);
			}
		});
		listaBotoes.add(btnVol_2);
		contentPane.add(btnVol_2);
		
		final ButtonAiCoach btnLd_1 = new ButtonAiCoach("LD");
		btnLd_1.setBackground(Color.GRAY);
		btnLd_1.setBounds(225, 452, 58, 54);
		btnLd_1.setId(7);
		btnLd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnLd_1);
			}
		});
		listaBotoes.add(btnLd_1);
		contentPane.add(btnLd_1);
		
		final ButtonAiCoach btnLe_1 = new ButtonAiCoach("LE");
		btnLe_1.setId(11);
		btnLe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnLe_1);
			}
		});
		btnLe_1.setBackground(Color.GRAY);
		btnLe_1.setBounds(225, 113, 58, 54);
		listaBotoes.add(btnLe_1);
		contentPane.add(btnLe_1);
		
		final ButtonAiCoach btnMld = new ButtonAiCoach("MLD");
		
		btnMld.setBackground(Color.GRAY);
		btnMld.setId(12);
		listaBotoes.add(btnMld);
		btnMld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnMld);
			}
		});
		btnMld.setBounds(322, 452, 58, 54);
		
		contentPane.add(btnMld);
		
		final ButtonAiCoach btnMc = new ButtonAiCoach("MC");
		btnMc.setBackground(Color.GRAY);
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnMc);
			}
		});
		btnMc.setId(13);
		btnMc.setBounds(322, 373, 58, 54);
		listaBotoes.add(btnMc);
		contentPane.add(btnMc);
		
		final ButtonAiCoach btnMc_1 = new ButtonAiCoach("MC");
		btnMc_1.setBackground(Color.GRAY);
		btnMc_1.setBounds(322, 277, 58, 54);
		btnMc_1.setId(14);
		btnMc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMc_1);
			}
		});
		listaBotoes.add(btnMc_1);
		contentPane.add(btnMc_1);
		
		final ButtonAiCoach btnMc_2 = new ButtonAiCoach("MC");
		btnMc_2.setBackground(Color.GRAY);
		btnMc_2.setBounds(322, 192, 58, 54);
		btnMc_2.setId(15);
		btnMc_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMc_2);
			}
		});
		listaBotoes.add(btnMc_2);
		contentPane.add(btnMc_2);
		
		final ButtonAiCoach btnMle = new ButtonAiCoach("MLE");
		btnMle.setBackground(Color.GRAY);
		btnMle.setBounds(322, 113, 58, 54);
		btnMle.setId(16);
		btnMle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMle);
			}
		});
		listaBotoes.add(btnMle);
		contentPane.add(btnMle);
		
		final ButtonAiCoach btnMle_1 = new ButtonAiCoach("MLE");
		btnMle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaCorBotao(btnMle_1);
			}
		});
		btnMle_1.setBackground(Color.GRAY);
		btnMle_1.setBounds(423, 113, 58, 54);
		btnMle_1.setId(21);
		listaBotoes.add(btnMle_1);
		contentPane.add(btnMle_1);
		
		final ButtonAiCoach btnMat_2 = new ButtonAiCoach("MAT");
		btnMat_2.setBackground(Color.GRAY);
		btnMat_2.setBounds(423, 192, 58, 54);
		btnMat_2.setId(20);
		btnMat_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMat_2);
			}
		});
		listaBotoes.add(btnMat_2);
		contentPane.add(btnMat_2);
		
		final ButtonAiCoach btnMat_1 = new ButtonAiCoach("MAT");
		btnMat_1.setBackground(Color.GRAY);
		btnMat_1.setBounds(423, 277, 58, 54);
		btnMat_1.setId(19);
		btnMat_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMat_1);
			}
		});
		listaBotoes.add(btnMat_1);
		contentPane.add(btnMat_1);
		
		final ButtonAiCoach btnMat = new ButtonAiCoach("MAT");
		btnMat.setBackground(Color.GRAY);
		btnMat.setBounds(423, 373, 58, 54);
		btnMat.setId(18);
		btnMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMat);
			}
		});
		listaBotoes.add(btnMat);
		contentPane.add(btnMat);
		
		final ButtonAiCoach btnMld_1 = new ButtonAiCoach("MLD");
		btnMld_1.setBackground(Color.GRAY);
		btnMld_1.setBounds(423, 452, 58, 54);
		btnMld_1.setId(17);
		btnMld_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnMld_1);
			}
		});
		listaBotoes.add(btnMld_1);
		contentPane.add(btnMld_1);
		
		final ButtonAiCoach btnPte = new ButtonAiCoach("PTE");
		btnPte.setBackground(Color.GRAY);
		btnPte.setBounds(534, 113, 59, 54);
		btnPte.setId(26);
		btnPte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnPte);
			}
		});
		listaBotoes.add(btnPte);
		contentPane.add(btnPte);
		
		final ButtonAiCoach btnSa_1 = new ButtonAiCoach("SA");
		btnSa_1.setBackground(Color.GRAY);
		btnSa_1.setBounds(534, 203, 59, 54);
		btnSa_1.setId(25);
		btnSa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnSa_1);
			}
		});
		listaBotoes.add(btnSa_1);
		contentPane.add(btnSa_1);
		
		final ButtonAiCoach btnCa = new ButtonAiCoach("CA");
		btnCa.setBounds(548, 277, 64, 63);
		btnCa.setBackground(Color.GRAY);
		btnCa.setId(24);
		btnCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnCa);
			}
		});
		listaBotoes.add(btnCa);
		contentPane.add(btnCa);
		
		btnSa = new ButtonAiCoach("SA");
		btnSa.setBackground(Color.GRAY);
		btnSa.setBounds(534, 361, 59, 55);
		btnSa.setId(23);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnSa);
			}
		});
		listaBotoes.add(btnSa);
		contentPane.add(btnSa);
		
		final ButtonAiCoach btnPtd = new ButtonAiCoach("PTD");
		btnPtd.setBackground(Color.GRAY);
		btnPtd.setBounds(534, 452, 59, 54);
		btnPtd.setId(22);
		btnPtd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mudaCorBotao(btnPtd);
			}
		});
		
		listaBotoes.add(btnPtd);
		contentPane.add(btnPtd);
		
		JButton btnNewButton = new JButton("Criar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaPosicaoTaticaNova.size()==11){
					TaticaDAO tDAO=new TaticaDAO();
					Tatica tatica=tDAO.retornarTatica(textField.getText());
					if(tatica==null){
						tDAO.inserirTatica(new Tatica(textField.getText(), listaPosicaoTaticaNova));
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
		btnNewButton.setBounds(296, 11, 101, 33);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(171, 14, 104, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(88, 20, 46, 14);
		contentPane.add(lblNome);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTatica tela=new TelaTatica(time);
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(471, 16, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTatica.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(10, 45, 688, 520);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
	}
	
	public void mudaCorBotao(ButtonAiCoach button){
		if(button.getBackground()==Color.gray){
			if(listaPosicaoTaticaNova.size()<11){
				button.setBackground(Color.GREEN);
				listaPosicaoTaticaNova.add(new Posicao(button.getId()));
			}
			else{
				//JOptionPane.showMessageDialog("O Máximo é de 11 jogadores.", null);
			}
		}
		else
		if(button.getBackground()==Color.GREEN){
			button.setBackground(Color.GRAY);
			for(Posicao p:listaPosicaoTaticaNova){
				if(p.getIdPosicaoTela()==button.getId()){
					listaPosicaoTaticaNova.remove(p);
				}
				
			}
		}
	}
}
