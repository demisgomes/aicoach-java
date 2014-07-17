package perssistencia;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.omg.CORBA.OBJ_ADAPTER;

import com.mysql.fabric.xmlrpc.base.Value;

import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;
import bd.Banco;

public class TaticaDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
	
	public void inserirTatica(Tatica tatica){
		ArrayList <Integer> idPosicoes=new ArrayList<Integer>();
		for(int i=0;i<tatica.getPosicoes().size();i++){
			idPosicoes.add(tatica.getPosicoes().get(i).getIdPosicaoTela());
		}
		String sql = "Insert into taticas (nome,posicoes,time) VALUES('"
				+tatica.getNome()
				+"','"
				+idPosicoes	+"','"
				+tatica.getTime().getIdTime() + "')";
		
		banco.executarSQL(sql);
		tatica.setIdTatica(retornarIdTatica());
	}
	
	public Tatica retornarTatica(Tatica tatica){
		String sql = "SELECT * from taticas WHERE idtatica LIKE'"+tatica.getIdTatica()+"'";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0, idTime = 0;
		String nome = null, posicoes = null;
		ArrayList<Posicao> posicoesTatica = new ArrayList<Posicao>();
		
		try {
			if(rs.next()){
				idTatica = rs.getInt("idtatica");
				nome = rs.getString("nome");
				posicoes=rs.getString("posicoes");
				idTime = rs.getInt("time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Time time = new Time();
		TimeDAO timeDAO = new TimeDAO();
		time = timeDAO.retornarTime(idTime);
		String [] posicoesSeparadas=posicoes.split(",");
		for (int i = 0; i < posicoesSeparadas.length; i++) {
			posicoesSeparadas[i]=posicoesSeparadas[i].substring(1);
			if(i==posicoesSeparadas.length-1){
				posicoesSeparadas[i]=posicoesSeparadas[i].substring(0, posicoesSeparadas[i].length()-1);
			}
			int int1 = Integer.parseInt(posicoesSeparadas[i]);
			Posicao p= new Posicao(int1);
			posicoesTatica.add(p);
		}
		 tatica = new Tatica(idTatica, nome, posicoesTatica, time);
		


		return tatica;
	}
	
	public int retornarIdTatica(){
		String sql = "SELECT idtatica from taticas";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0;
		try {
			while(rs.next()){
				idTatica = rs.getInt("idtatica");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			banco.fecharBanco();
		}
		
		return idTatica;
		
	}
}
