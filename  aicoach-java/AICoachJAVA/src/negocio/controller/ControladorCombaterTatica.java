package negocio.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import gui.TelaInserirAlterarEsquema;
import gui.TelaInserirCombaterTatica;
import negocio.AlgoritmoTatica;
import negocio.interfaces.InterfaceBotao;
import negocio.model.AlterarEsquema;
import negocio.model.CombateTatica;
import negocio.view.ObservadorCombateTatica;
import negocio.view.ObservadorTime;
import perssistencia.TaticaDAO;
import dominio.Tatica;
import dominio.Time;

public class ControladorCombaterTatica implements InterfaceBotao {
	public void controlar(String func){
		
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
			Document doc = docBuilder.parse(new File("alteraresquema.xml"));
			org.w3c.dom.Element xmlTag= doc.getDocumentElement();
			/*org.w3c.dom.Element p1Tag = doc.createElement("p");

            //p1Tag.setAttribute("class", "nome");

            p1Tag.setTextContent(time.getNome());
            
*/            Element bodyTag =(Element) xmlTag.getElementsByTagName(func).item(0);
            System.out.println(bodyTag.getTagName());
            if(bodyTag!=null){

        		TaticaDAO tDAO=new TaticaDAO();
        		Time timeEscolhido=Time.getListaTimes().get(TelaInserirCombaterTatica.comboBox.getSelectedIndex());
        		AlgoritmoTatica aTatica=new AlgoritmoTatica();
        		//aTatica.combaterTatica(TelaInserirCombaterTatica.time, timeEscolhido, tDAO.retornarListaTaticas());
        		CombateTatica c=new CombateTatica();
        		Observer obs=new ObservadorCombateTatica();
        		c.addObserver(obs);
        		c.acao(TelaInserirCombaterTatica.time, timeEscolhido, tDAO.retornarListaTaticas());

            }
            //Element bod1yTag =(Element) xmlTag.getElementsByTagName("time").item(1);

           // bodyTag.appendChild(p1Tag);
        

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	
	@Override
	public void acaoBotao(JFrame tela) {
		TelaInserirCombaterTatica.getBtnCombater().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				controlar("combaterTatica");
			}
		});
	}
}
