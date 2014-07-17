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
		String sql = "Insert into taticas (nome,posicoes,time) VALUES('"
				+tatica.getNome()
				+"','"
				+tatica.getNome()
				+"','"
				+tatica.getTime().getIdTime() + "')";
		
		banco.executarSQL(sql);
		tatica.setIdTatica(retornarIdTatica());
	}
	
	public Tatica retornarTatica(Tatica tatica){
		String sql = "SELECT * from taticas WHERE idtatica LIKE'"+tatica.getIdTatica()+"'";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0, idTime = 0;
		String nome = null;
		ArrayList<Posicao> posicao = new ArrayList<Posicao>();
		try {
			if(rs.next()){
				idTatica = rs.getInt("idtatica");
				nome = rs.getString("nome");
				idTime = rs.getInt("time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Time time = new Time();
		TimeDAO timeDAO = new TimeDAO();
		time = timeDAO.retornarTime(idTime);
		
		
		 tatica = new Tatica(idTatica, nome, posicao, time);

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
