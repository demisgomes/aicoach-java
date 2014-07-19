package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import negocio.AlgoritmoTatica;
import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;

import java.awt.Color;
import java.util.ArrayList;

public class TelaTatica extends JFrame {

	private JPanel contentPane;
	private ArrayList<Posicao> listaIdPosicoes=new ArrayList<Posicao>();
	public Time time;
	public static boolean daTelaInserir;
	//private ArrayList<Posicao> listaPosicoes=new ArrayList<Posicao>();

	ArrayList<ButtonAiCoach> listaBotoes = new ArrayList<ButtonAiCoach>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTatica frame = new TelaTatica();
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
	public TelaTatica(){}
	public TelaTatica(final Time time) {
		setTitle("Tela T\u00E1tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.time=time;
		
		
		
		TaticaDAO taticaDAO=new TaticaDAO();
		final ArrayList<Tatica> listaTaticas= taticaDAO.retornarListaTaticas();
		
		
		
		
		JButton btnNewButtonAiCoach = new JButton("Alterar Esquema");
		btnNewButtonAiCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaInserirAlterarEsquema tela=new TelaInserirAlterarEsquema(time);
				tela.setVisible(true);
				//dispose();
			}
		});
		btnNewButtonAiCoach.setBounds(27, 57, 135, 23);
		contentPane.add(btnNewButtonAiCoach);
		
		
		
		final String[] formacoes= new String[listaTaticas.size()];
		
		for (int i = 0; i < formacoes.length; i++) {
			formacoes[i]=listaTaticas.get(i).getNome();
		}
		
		

		
		final JComboBox<String> comboBox = new JComboBox<String>(formacoes);
		comboBox.setBounds(239, 24, 93, 20);
		contentPane.add(comboBox);
		
		
		
		ButtonAiCoach btnGL = new ButtonAiCoach("GL");
		btnGL.setBackground(Color.GRAY);
		
		btnGL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGL.setBounds(42, 277, 64, 54);
		btnGL.setId(1);
		listaBotoes.add(btnGL);
		contentPane.add(btnGL);
		
		
		ButtonAiCoach btnZc_2 = new ButtonAiCoach("ZC");
		btnZc_2.setBackground(Color.GRAY);
		btnZc_2.setBounds(128, 192, 58, 54);
		btnZc_2.setId(5);
		listaBotoes.add(btnZc_2);
		contentPane.add(btnZc_2);
		
		ButtonAiCoach btnZc = new ButtonAiCoach("ZC");
		btnZc.setBackground(Color.GRAY);
		btnZc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnZc.setId(3);
		listaBotoes.add(btnZc);
		btnZc.setBounds(128, 361, 58, 55);
		contentPane.add(btnZc);
		
		
		
		ButtonAiCoach btnLd = new ButtonAiCoach("LD");
		btnLd.setBackground(Color.GRAY);
		btnLd.setBounds(130, 452, 56, 54);
		btnLd.setId(2);
		listaBotoes.add(btnLd);
		contentPane.add(btnLd);
		
		ButtonAiCoach btnZc_1 = new ButtonAiCoach("ZC");
		btnZc_1.setBackground(Color.GRAY);
		btnZc_1.setBounds(128, 277, 58, 54);
		btnZc_1.setId(4);
		listaBotoes.add(btnZc_1);
		contentPane.add(btnZc_1);
		
		ButtonAiCoach btnLe = new ButtonAiCoach("LE");
		btnLe.setId(6);
		btnLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLe.setBackground(Color.GRAY);
		btnLe.setBounds(130, 113, 56, 54);
		listaBotoes.add(btnLe);
		contentPane.add(btnLe);
		
		ButtonAiCoach btnVol = new ButtonAiCoach("VOL");
		btnVol.setBackground(Color.GRAY);
		btnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVol.setBounds(225, 373, 58, 54);
		btnVol.setId(8);
		listaBotoes.add(btnVol);
		contentPane.add(btnVol);
		
		
		ButtonAiCoach btnVol_1 = new ButtonAiCoach("VOL");
		btnVol_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVol_1.setBackground(Color.GRAY);
		btnVol_1.setBounds(225, 277, 58, 54);
		btnVol_1.setId(9);
		listaBotoes.add(btnVol_1);
		contentPane.add(btnVol_1);
		
		ButtonAiCoach btnVol_2 = new ButtonAiCoach("VOL");
		btnVol_2.setBackground(Color.GRAY);
		btnVol_2.setBounds(225, 192, 58, 54);
		btnVol_2.setId(10);
		listaBotoes.add(btnVol_2);
		contentPane.add(btnVol_2);
		
		ButtonAiCoach btnLd_1 = new ButtonAiCoach("LD");
		btnLd_1.setBackground(Color.GRAY);
		btnLd_1.setBounds(225, 452, 58, 54);
		btnLd_1.setId(7);
		listaBotoes.add(btnLd_1);
		contentPane.add(btnLd_1);
		
		ButtonAiCoach btnLe_1 = new ButtonAiCoach("LE");
		btnLe_1.setId(11);
		btnLe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLe_1.setBackground(Color.GRAY);
		btnLe_1.setBounds(225, 113, 58, 54);
		listaBotoes.add(btnLe_1);
		contentPane.add(btnLe_1);
		
		ButtonAiCoach btnMld = new ButtonAiCoach("MLD");
		btnMld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMld.setBackground(Color.GRAY);
		btnMld.setId(12);
		listaBotoes.add(btnMld);
		btnMld.setBounds(322, 452, 58, 54);
		
		contentPane.add(btnMld);
		
		ButtonAiCoach btnMc = new ButtonAiCoach("MC");
		btnMc.setBackground(Color.GRAY);
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMc.setId(13);
		btnMc.setBounds(322, 373, 58, 54);
		listaBotoes.add(btnMc);
		contentPane.add(btnMc);
		
		ButtonAiCoach btnMc_1 = new ButtonAiCoach("MC");
		btnMc_1.setBackground(Color.GRAY);
		btnMc_1.setBounds(322, 277, 58, 54);
		btnMc_1.setId(14);
		listaBotoes.add(btnMc_1);
		contentPane.add(btnMc_1);
		
		ButtonAiCoach btnMc_2 = new ButtonAiCoach("MC");
		btnMc_2.setBackground(Color.GRAY);
		btnMc_2.setBounds(322, 192, 58, 54);
		btnMc_2.setId(15);
		listaBotoes.add(btnMc_2);
		contentPane.add(btnMc_2);
		
		ButtonAiCoach btnMle = new ButtonAiCoach("MLE");
		btnMle.setBackground(Color.GRAY);
		btnMle.setBounds(322, 113, 58, 54);
		btnMle.setId(16);
		listaBotoes.add(btnMle);
		contentPane.add(btnMle);
		
		ButtonAiCoach btnMle_1 = new ButtonAiCoach("MLE");
		btnMle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMle_1.setBackground(Color.GRAY);
		btnMle_1.setBounds(423, 113, 58, 54);
		btnMle_1.setId(21);
		listaBotoes.add(btnMle_1);
		contentPane.add(btnMle_1);
		
		ButtonAiCoach btnMat_2 = new ButtonAiCoach("MAT");
		btnMat_2.setBackground(Color.GRAY);
		btnMat_2.setBounds(423, 192, 58, 54);
		btnMat_2.setId(20);
		listaBotoes.add(btnMat_2);
		contentPane.add(btnMat_2);
		
		ButtonAiCoach btnMat_1 = new ButtonAiCoach("MAT");
		btnMat_1.setBackground(Color.GRAY);
		btnMat_1.setBounds(423, 277, 58, 54);
		btnMat_1.setId(19);
		listaBotoes.add(btnMat_1);
		contentPane.add(btnMat_1);
		
		ButtonAiCoach btnMat = new ButtonAiCoach("MAT");
		btnMat.setBackground(Color.GRAY);
		btnMat.setBounds(423, 373, 58, 54);
		btnMat.setId(18);
		listaBotoes.add(btnMat);
		contentPane.add(btnMat);
		
		ButtonAiCoach btnMld_1 = new ButtonAiCoach("MLD");
		btnMld_1.setBackground(Color.GRAY);
		btnMld_1.setBounds(423, 452, 58, 54);
		btnMld_1.setId(17);
		listaBotoes.add(btnMld_1);
		contentPane.add(btnMld_1);
		
		ButtonAiCoach btnPte = new ButtonAiCoach("PTE");
		btnPte.setBackground(Color.GRAY);
		btnPte.setBounds(534, 113, 59, 54);
		btnPte.setId(26);
		listaBotoes.add(btnPte);
		contentPane.add(btnPte);
		
		ButtonAiCoach btnSa_1 = new ButtonAiCoach("SA");
		btnSa_1.setBackground(Color.GRAY);
		btnSa_1.setBounds(534, 203, 59, 54);
		btnSa_1.setId(25);
		listaBotoes.add(btnSa_1);
		contentPane.add(btnSa_1);
		
		ButtonAiCoach btnCa = new ButtonAiCoach("CA");
		btnCa.setBounds(548, 277, 64, 63);
		btnCa.setBackground(Color.GRAY);
		btnCa.setId(24);
		listaBotoes.add(btnCa);
		contentPane.add(btnCa);
		
		ButtonAiCoach btnSa = new ButtonAiCoach("SA");
		btnSa.setBackground(Color.GRAY);
		btnSa.setBounds(534, 361, 59, 55);
		btnSa.setId(23);
		listaBotoes.add(btnSa);
		contentPane.add(btnSa);
		
		ButtonAiCoach btnPtd = new ButtonAiCoach("PTD");
		btnPtd.setBackground(Color.GRAY);
		btnPtd.setBounds(534, 452, 59, 54);
		btnPtd.setId(22);
		
		listaBotoes.add(btnPtd);
		contentPane.add(btnPtd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTatica.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(10, 81, 688, 438);
		contentPane.add(lblNewLabel);
		
		
		//------------------------------------
		//SUGERIR TÀTICA
		//------------------------------------
		JButton btnSugerirTtica = new JButton("Sugerir T\u00E1tica");
		btnSugerirTtica.setBounds(27, 23, 135, 23);
		
		
		btnSugerirTtica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						for (int j = 0; j < time.getJogadores().size(); j++) {
							time.getJogadores().get(j).setEscolhido(0);
							
						}
						
						AlgoritmoTatica aTatica=new AlgoritmoTatica();
						aTatica.sugerirTatica(time, listaTaticas);
						mostrarBotoes();
			}
		});
		
		contentPane.add(btnSugerirTtica);
JButton btnEscolherMelhoresJogadores = new JButton("Escolher Melhores Jogadores");
		
		btnEscolherMelhoresJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int j = 0; j < time.getJogadores().size(); j++) {
					time.getJogadores().get(j).setEscolhido(0);
					
				}
				
				TaticaDAO taticaDAO=new TaticaDAO();
				Tatica taticaEscolhida=taticaDAO.retornarTatica(comboBox.getSelectedItem().toString());
				
				
				
				time.setTatica(taticaEscolhida);
				AlgoritmoTatica aTatica= new AlgoritmoTatica();
				aTatica.SugerirJogadores(time);
				mostrarBotoes();
			}
		});
		
		for(int j=0;j<listaBotoes.size();j++){
			listaBotoes.get(j).setVisible(false);
		}
		btnEscolherMelhoresJogadores.setBounds(354, 23, 185, 23);
		contentPane.add(btnEscolherMelhoresJogadores);
		
		JButton btnCriarNovaTtica = new JButton("Criar Nova T\u00E1tica");
		btnCriarNovaTtica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriarTatica tela=new TelaCriarTatica(time);
				tela.setVisible(true);
				dispose();
			}
		});
		btnCriarNovaTtica.setBounds(354, 57, 192, 23);
		contentPane.add(btnCriarNovaTtica);
		
		JButton btnSalvarTtica = new JButton("Salvar T\u00E1tica");
		btnSalvarTtica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeDAO timeDAO=new TimeDAO();
				timeDAO.inserirTimeTatica(time);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
			}
		});
		btnSalvarTtica.setBounds(599, 23, 99, 35);
		contentPane.add(btnSalvarTtica);
		
		TimeDAO timeDAO = new TimeDAO();
		Tatica taticaTime=timeDAO.retornarTaticaTime(time);
		
		if(taticaTime!=null && !daTelaInserir){
			time.setTatica(taticaTime);
			AlgoritmoTatica aTatica=new AlgoritmoTatica();
			aTatica.SugerirJogadores(time);
			
			mostrarBotoes();
		}
		
		if(daTelaInserir){
			mostrarBotoes();
			daTelaInserir=false;
			
		}
		
}
	public void mostrarBotoes(){
		
		for(int j=0;j<listaBotoes.size();j++){
			listaBotoes.get(j).setVisible(false);
			listaBotoes.get(j).setBackground(Color.GRAY);
		}
		listaIdPosicoes.clear();				
		for(Posicao p: time.getTatica().getPosicoes()){
			listaIdPosicoes.add(p);
		}
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
		
	
	}
	
	
}


