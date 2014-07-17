package perssistencia;

import java.sql.ResultSet;
import java.util.ArrayList;

import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;
import bd.Banco;

public class TaticaDAO {
	Banco banco = new Banco("jdbc:mysql://localhost/aicoach","1234","root");
	
	public void inserirTatica(Tatica tatica){
		String sql = "Insert into taticas (nome,posicoes,time) VALUES('"
				+tatica.getNome()
				+"','"
				+tatica.getPosicoes()
				+"','"
				+tatica.getTime().getIdTime() + "')";
		
		banco.executarSQL(sql);
		tatica.setIdTatica(retornarIdTatica());
	}
	
	public Tatica retornarTatica(Tatica tatica){
		String sql = "SELECT * from taticas WHERE idtatica LIKE'"+tatica.getIdTatica()+"'";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0, idTime = 0;
		String nome = null, posicoes = null;
		//ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		
		try {
			if(rs.next()){
				idTatica = rs.getInt("idtatica");
				nome = rs.getString("nome");
				posicoes = rs.getString("posicoes");
				idTime = rs.getInt("time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Time time = new Time();
		TimeDAO timeDAO = new TimeDAO();
		time = timeDAO.retornarTime(idTime);
		
		 tatica = new Tatica(idTatica, nome, null, time);

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
