package perssistencia;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String sql = "Insert into taticas (nome,posicoes) VALUES('"
				+tatica.getNome()
				+"','"
				+idPosicoes	+"')";
		
		banco.executarSQL(sql);
		tatica.setIdTatica(retornarIdTatica());
	}
	
	public Tatica retornarTatica(Tatica tatica){
		String sql = "SELECT * from taticas WHERE nome LIKE'"+tatica.getNome()+"'";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0;
		String nome = null, posicoes = null;
		ArrayList<Posicao> posicoesTatica = new ArrayList<Posicao>();
		
		try {
			if(rs.next()){
				idTatica = rs.getInt("idtatica");
				nome = rs.getString("nome");
				posicoes=rs.getString("posicoes");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		 tatica = new Tatica(idTatica, nome, posicoesTatica);
		


		return tatica;
	}
	
	public Tatica retornarTatica(int idDaTatica){
		String sql = "SELECT * from taticas WHERE idtatica LIKE'"+idDaTatica+"'";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0;
		String nome = null, posicoes = null;
		ArrayList<Posicao> posicoesTatica = new ArrayList<Posicao>();
		
		try {
			if(rs.next()){
				idTatica = rs.getInt("idtatica");
				nome = rs.getString("nome");
				posicoes=rs.getString("posicoes");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		 Tatica tatica = new Tatica(idTatica, nome, posicoesTatica);
		


		return tatica;
	}
	
	public Tatica retornarTatica(String nomeTatica){
		String sql = "SELECT * from taticas WHERE nome LIKE'"+nomeTatica+"'";
		ResultSet rs = banco.executarSelect(sql);
		int idTatica = 0;
		String nome = null, posicoes = null;
		ArrayList<Posicao> posicoesTatica = new ArrayList<Posicao>();
		
		try {
			if(rs.next()){
				idTatica = rs.getInt("idtatica");
				nome = rs.getString("nome");
				posicoes=rs.getString("posicoes");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		Tatica  tatica = new Tatica(idTatica, nome, posicoesTatica);
		


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
	
	public ArrayList <Tatica> retornarListaTaticas(){
		String sql = "SELECT * FROM taticas";
		ResultSet rs = banco.executarSelect(sql);
		ArrayList<Tatica> lista=new ArrayList<Tatica>();
		
		try {
			while(rs.next()){
				Tatica t=retornarTatica(rs.getInt("idtatica"));
				lista.add(t);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			banco.fecharBanco();
		}
	}
}
