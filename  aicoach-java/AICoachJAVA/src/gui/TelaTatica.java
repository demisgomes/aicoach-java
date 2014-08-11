package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.controller.FachadaTatica;
import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;
import controle.ControladorTatica;
import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class TelaTatica extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ArrayList<Posicao> listaIdPosicoes=new ArrayList<Posicao>();
	public static Time time;
	public static boolean daTelaInserir;
	private static boolean substituir = false;
	public static boolean daTelaCombater;
	public static  boolean naoSalvar; //private ArrayList<Posicao> listaPosicoes=new ArrayList<Posicao>();
	private static JButton btnAlterarEsquema,btnSugerirTtica,btnEscolherMelhoresJogadores,btnCriarNovaTtica,btnSalvarTtica,btnSubstituir,
	btnCombaterTtica,btnVoltar;
	private static ArrayList<ButtonAiCoach> listaBotoes = new ArrayList<ButtonAiCoach>();
	private static ArrayList<Integer> listaJogador=new ArrayList<Integer>();
	private static ArrayList<Tatica> listaTaticas;
	private static JComboBox<String> comboBox;
	
	
	
	

	public static boolean isSubstituir() {
		return substituir;
	}


	public static void setSubstituir(boolean substituir) {
		TelaTatica.substituir = substituir;
	}


	public static JComboBox<String> getComboBox() {
		return comboBox;
	}


	public static void setComboBox(JComboBox<String> comboBox) {
		TelaTatica.comboBox = comboBox;
	}


	public static ArrayList<Tatica> getListaTaticas() {
		return listaTaticas;
	}


	public static void setListaTaticas(ArrayList<Tatica> listaTaticas) {
		TelaTatica.listaTaticas = listaTaticas;
	}


	public static JButton getBtnSugerirTtica() {
		return btnSugerirTtica;
	}


	public static void setBtnSugerirTtica(JButton btnSugerirTtica) {
		TelaTatica.btnSugerirTtica = btnSugerirTtica;
	}


	public static JButton getBtnSubstituir() {
		return btnSubstituir;
	}


	public static void setBtnSubstituir(JButton btnSubstituir) {
		TelaTatica.btnSubstituir = btnSubstituir;
	}


	public static Time getTime() {
		return time;
	}


	public static void setTime(Time time) {
		TelaTatica.time = time;
	}


	public static ArrayList<Posicao> getListaIdPosicoes() {
		return listaIdPosicoes;
	}


	public static void setListaIdPosicoes(ArrayList<Posicao> listaIdPosicoes) {
		TelaTatica.listaIdPosicoes = listaIdPosicoes;
	}


	public static ArrayList<Integer> getListaJogador() {
		return listaJogador;
	}


	public static void setListaJogador(ArrayList<Integer> listaJogador) {
		TelaTatica.listaJogador = listaJogador;
	}


	public static JButton getBtnAlterarEsquema() {
		return btnAlterarEsquema;
	}


	public static void setBtnAlterarEsquema(JButton btnAlterarEsquema) {
		TelaTatica.btnAlterarEsquema = btnAlterarEsquema;
	}


	public static JButton getBtnEscolherMelhoresJogadores() {
		return btnEscolherMelhoresJogadores;
	}


	public static void setBtnEscolherMelhoresJogadores(
			JButton btnEscolherMelhoresJogadores) {
		TelaTatica.btnEscolherMelhoresJogadores = btnEscolherMelhoresJogadores;
	}


	public static JButton getBtnCriarNovaTtica() {
		return btnCriarNovaTtica;
	}


	public static void setBtnCriarNovaTtica(JButton btnCriarNovaTtica) {
		TelaTatica.btnCriarNovaTtica = btnCriarNovaTtica;
	}


	public static JButton getBtnSalvarTtica() {
		return btnSalvarTtica;
	}


	public static void setBtnSalvarTtica(JButton btnSalvarTtica) {
		TelaTatica.btnSalvarTtica = btnSalvarTtica;
	}


	public static JButton getBtnCombaterTtica() {
		return btnCombaterTtica;
	}


	public static void setBtnCombaterTtica(JButton btnCombaterTtica) {
		TelaTatica.btnCombaterTtica = btnCombaterTtica;
	}


	public static JButton getBtnVoltar() {
		return btnVoltar;
	}


	public static void setBtnVoltar(JButton btnVoltar) {
		TelaTatica.btnVoltar = btnVoltar;
	}


	public static ArrayList<ButtonAiCoach> getListaBotoes() {
		return listaBotoes;
	}


	public static void setListaBotoes(ArrayList<ButtonAiCoach> listaBotoes) {
		TelaTatica.listaBotoes = listaBotoes;
	}
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
   
	public TelaTatica() {
		setTitle("Tela T\u00E1tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.time=Time.getTime();
		
		
		
		TaticaDAO taticaDAO=new TaticaDAO();
		listaTaticas= taticaDAO.retornarListaTaticas();
		
		
		
		
		btnAlterarEsquema = new JButton("Alterar Esquema");
		
		btnAlterarEsquema.setBounds(27, 23, 135, 23);
		contentPane.add(btnAlterarEsquema);
		
		
		
		final String[] formacoes= new String[listaTaticas.size()];
		
		for (int i = 0; i < formacoes.length; i++) {
			formacoes[i]=listaTaticas.get(i).getNome();
		}
		
		

		
		comboBox = new JComboBox(formacoes);
		comboBox.setBounds(200, 24, 130, 20);
		contentPane.add(comboBox);
		
		
		
		ButtonAiCoach btnGL = new ButtonAiCoach("GL");
		btnGL.setBackground(Color.GRAY);
		
		
		btnGL.setBounds(42, 277, 64, 54);
		btnGL.setId(1);
		listaBotoes.add(btnGL);
		contentPane.add(btnGL);
		
		ButtonAiCoach btnLd_1 = new ButtonAiCoach("LD");
		btnLd_1.setBackground(Color.GRAY);
		btnLd_1.setBounds(225, 452, 58, 54);
		btnLd_1.setId(7);
		listaBotoes.add(btnLd_1);
		contentPane.add(btnLd_1);
		
		
		ButtonAiCoach btnLd = new ButtonAiCoach("LD");
		btnLd.setBackground(Color.GRAY);
		btnLd.setBounds(130, 452, 56, 54);
		btnLd.setId(2);
		listaBotoes.add(btnLd);
		contentPane.add(btnLd);
		
		ButtonAiCoach btnZc = new ButtonAiCoach("ZC");
		btnZc.setBackground(Color.GRAY);
		
		btnZc.setId(3);
		listaBotoes.add(btnZc);
		btnZc.setBounds(128, 361, 58, 55);
		contentPane.add(btnZc);
		

		ButtonAiCoach btnZc_1 = new ButtonAiCoach("ZC");
		btnZc_1.setBackground(Color.GRAY);
		btnZc_1.setBounds(128, 277, 58, 54);
		btnZc_1.setId(4);
		listaBotoes.add(btnZc_1);
		contentPane.add(btnZc_1);
		
		ButtonAiCoach btnZc_2 = new ButtonAiCoach("ZC");
		btnZc_2.setBackground(Color.GRAY);
		btnZc_2.setBounds(128, 192, 58, 54);
		btnZc_2.setId(5);
		listaBotoes.add(btnZc_2);
		contentPane.add(btnZc_2);
		
		
		
		ButtonAiCoach btnLe = new ButtonAiCoach("LE");
		btnLe.setId(6);
		
		btnLe.setBackground(Color.GRAY);
		btnLe.setBounds(130, 113, 56, 54);
		listaBotoes.add(btnLe);
		contentPane.add(btnLe);
		

		ButtonAiCoach btnLe_1 = new ButtonAiCoach("LE");
		btnLe_1.setId(11);

		btnLe_1.setBackground(Color.GRAY);
		btnLe_1.setBounds(225, 113, 58, 54);
		listaBotoes.add(btnLe_1);
		contentPane.add(btnLe_1);
		
		
		ButtonAiCoach btnMld_1 = new ButtonAiCoach("MLD");
		btnMld_1.setBackground(Color.GRAY);
		btnMld_1.setBounds(423, 452, 58, 54);
		btnMld_1.setId(17);
		listaBotoes.add(btnMld_1);
		contentPane.add(btnMld_1);
		
		ButtonAiCoach btnMld = new ButtonAiCoach("MLD");
		
		btnMld.setBackground(Color.GRAY);
		btnMld.setId(12);
		listaBotoes.add(btnMld);
		btnMld.setBounds(322, 452, 58, 54);
		
		contentPane.add(btnMld);
		
		ButtonAiCoach btnVol = new ButtonAiCoach("VOL");
		btnVol.setBackground(Color.GRAY);
		
		btnVol.setBounds(225, 373, 58, 54);
		btnVol.setId(8);
		listaBotoes.add(btnVol);
		contentPane.add(btnVol);
		
		
		ButtonAiCoach btnVol_1 = new ButtonAiCoach("VOL");
		
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
		
		
		
	
		
		ButtonAiCoach btnMc = new ButtonAiCoach("MC");
		btnMc.setBackground(Color.GRAY);
		
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
		
		btnMle_1.setBackground(Color.GRAY);
		btnMle_1.setBounds(423, 113, 58, 54);
		btnMle_1.setId(21);
		listaBotoes.add(btnMle_1);
		contentPane.add(btnMle_1);
		
		
		ButtonAiCoach btnMat = new ButtonAiCoach("MAT");
		btnMat.setBackground(Color.GRAY);
		btnMat.setBounds(423, 373, 58, 54);
		btnMat.setId(18);
		listaBotoes.add(btnMat);
		contentPane.add(btnMat);
		
		ButtonAiCoach btnMat_1 = new ButtonAiCoach("MAT");
		btnMat_1.setBackground(Color.GRAY);
		btnMat_1.setBounds(423, 277, 58, 54);
		btnMat_1.setId(19);
		listaBotoes.add(btnMat_1);
		contentPane.add(btnMat_1);
		
		ButtonAiCoach btnMat_2 = new ButtonAiCoach("MAT");
		btnMat_2.setBackground(Color.GRAY);
		btnMat_2.setBounds(423, 192, 58, 54);
		btnMat_2.setId(20);
		listaBotoes.add(btnMat_2);
		contentPane.add(btnMat_2);
		
		
	
		ButtonAiCoach btnPtd = new ButtonAiCoach("PTD");
		btnPtd.setBackground(Color.GRAY);
		btnPtd.setBounds(534, 452, 59, 54);
		btnPtd.setId(22);
		
		listaBotoes.add(btnPtd);
		contentPane.add(btnPtd);
		
		
		ButtonAiCoach btnSa = new ButtonAiCoach("SA");
		btnSa.setBackground(Color.GRAY);
		btnSa.setBounds(534, 361, 59, 55);
		btnSa.setId(23);
		listaBotoes.add(btnSa);
		contentPane.add(btnSa);
		
		ButtonAiCoach btnSa_1 = new ButtonAiCoach("SA");
		btnSa_1.setBackground(Color.GRAY);
		btnSa_1.setBounds(534, 203, 59, 54);
		btnSa_1.setId(25);
		listaBotoes.add(btnSa_1);
		contentPane.add(btnSa_1);
		
		
		ButtonAiCoach btnPte = new ButtonAiCoach("PTE");
		btnPte.setBackground(Color.GRAY);
		btnPte.setBounds(534, 113, 59, 54);
		btnPte.setId(26);
		listaBotoes.add(btnPte);
		contentPane.add(btnPte);
		

		ButtonAiCoach btnCa = new ButtonAiCoach("CA");
		btnCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCa.setBounds(548, 277, 64, 63);
		btnCa.setBackground(Color.GRAY);
		btnCa.setId(24);
		listaBotoes.add(btnCa);
		contentPane.add(btnCa);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTatica.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(10, 81, 688, 438);
		contentPane.add(lblNewLabel);
		
		
		//------------------------------------
		//SUGERIR TÀTICA
		//------------------------------------
		btnSugerirTtica = new JButton("Sugerir T\u00E1tica");
		btnSugerirTtica.setBounds(27, 553, 135, 23);
		
		
		
		
		contentPane.add(btnSugerirTtica);
		btnEscolherMelhoresJogadores = new JButton("Sugerir Jogadores");
		
	
		btnEscolherMelhoresJogadores.setBounds(354, 23, 167, 23);
		contentPane.add(btnEscolherMelhoresJogadores);
		
		btnCriarNovaTtica = new JButton("Criar Nova T\u00E1tica");
	
		btnCriarNovaTtica.setBounds(534, 23, 167, 23);
		contentPane.add(btnCriarNovaTtica);
		
		btnSalvarTtica = new JButton("Salvar T\u00E1tica");
		
		btnSalvarTtica.setBounds(569, 547, 129, 35);
		contentPane.add(btnSalvarTtica);
		
		btnSubstituir = new JButton("Substituir");
		
		btnSubstituir.setBounds(376, 553, 135, 23);
		contentPane.add(btnSubstituir);
		
		btnCombaterTtica = new JButton("Combater t\u00E1tica");
		btnCombaterTtica.setBounds(203, 553, 129, 23);
	
		contentPane.add(btnCombaterTtica);
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setBounds(37, 47, 89, 23);
		contentPane.add(btnVoltar);
		
		FachadaTatica fachada = new FachadaTatica();
		fachada.taticas(this);
		ControladorTatica controlador = new ControladorTatica();
		//controlador.acaoBotao(this);
		
		
		TimeDAO timeDAO = new TimeDAO();
		Tatica taticaTime=timeDAO.retornarTaticaTime(time);
		
		if(taticaTime!=null && !daTelaInserir){
			time.setTatica(taticaTime);
			System.out.println(taticaTime.getNome());
			for (Posicao p : time.getTatica().getPosicoes()) {
			System.out.println(p.getNome()+" será "+ p.getJogador().getNome());//+ " "+ p.getJogador().getPosicaoAtual().getPontuacao());
			}
			controlador.mostrarBotoes();
			daTelaInserir=false;
			
		}
		
		if(daTelaInserir){
			
			controlador.mostrarBotoes();
			daTelaInserir=false;
			
		}
		
}
}







