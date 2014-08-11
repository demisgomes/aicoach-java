package negocio.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.swing.JFrame;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import gui.TelaInserirAlterarEsquema;
import gui.TelaTatica;
import perssistencia.TaticaDAO;
import negocio.interfaces.InterfaceBotao;
import negocio.model.AlterarEsquema;
import negocio.view.ObservadorCombateTatica;
import negocio.view.ObservadorTime;
import dominio.Tatica;
import dominio.Time;


public class ControladorAlterarEsquema implements InterfaceBotao {
	private AlterarEsquema alterarEsquema;
	
	public void controlar(Time time, String xml){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setNamespaceAware(false);

		DocumentBuilder docBuilder = null;
		try {
			docBuilder = dbf.newDocumentBuilder();
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Document doc = docBuilder.parse(new File(xml));
			org.w3c.dom.Element xmlTag= doc.getDocumentElement();
			org.w3c.dom.Element p1Tag = doc.createElement("p");

            //p1Tag.setAttribute("class", "nome");

            p1Tag.setTextContent(time.getNome());
            
            Element bodyTag =(Element) xmlTag.getElementsByTagName("time").item(0);
            System.out.println(bodyTag.getTagName());
            Element bod1yTag =(Element) xmlTag.getElementsByTagName("time").item(1);

            bodyTag.appendChild(p1Tag);
        

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		TaticaDAO tDAO=new TaticaDAO();
		System.out.println(TelaInserirAlterarEsquema.comboBoxFormacoes.getSelectedItem().toString());
		Tatica taticaNova=tDAO.retornarTatica(TelaInserirAlterarEsquema.comboBoxFormacoes.getSelectedItem().toString());
		int substituicoes=TelaInserirAlterarEsquema.comboBoxSubstituicoes.getSelectedIndex();
		AlterarEsquema a=new AlterarEsquema();
		//TelaTatica tela=new TelaTatica();
		Observer obs=new ObservadorTime();
		a.addObserver(obs);
		a.acao(time, substituicoes, taticaNova);
	}
	

	/**
	 * @return the alterarEsquema
	 */
	public AlterarEsquema getAlterarEsquema() {
		return alterarEsquema;
	}

	/**
	 * @param alterarEsquema the alterarEsquema to set
	 */
	public void setAlterarEsquema(AlterarEsquema alterarEsquema) {
		this.alterarEsquema = alterarEsquema;
	}


	@Override
	public void acaoBotao(JFrame tela) {
		TelaInserirAlterarEsquema.getBtnConfirmar().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				controlar(TelaInserirAlterarEsquema.getTime(), "alteraresquema.xml");
			}
		});
	}
}
