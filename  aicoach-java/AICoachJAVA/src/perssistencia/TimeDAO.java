package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;
import dominio.Jogador;
import dominio.Tatica;
import dominio.Time;

public class TimeDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
	
	public void inserirTime(Time time){
		String sql = "Insert into time (nometime,jogadores) VALUES('"
				+time.getNome()+ "')";
		
		banco.executarSQL(sql);
		time.setIdTime(retornarIdTime());
	}
	
	public int retornarIdTime(){
		String sql = "SELECT idtime from time";
		ResultSet rs = banco.executarSelect(sql);
		int idTime = 0;
		try {
			while(rs.next()){
				idTime = rs.getInt("idtime");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			banco.fecharBanco();
		}
		
		return idTime;
		
	}
	
	public Time retornarTime(int idTime){
		String sql = "SELECT * FROM time WHERE idTime = '"+idTime+"'" ;
		ResultSet rs = banco.executarSelect(sql);
		
		String nome=null;
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		try {
			if(rs.next()){
				nome = rs.getString("nometime");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Time time = new Time();
		time.setNome(nome);
		time.setJogadores(jogadores);
		//time.setTatica(tatica);
		return time;
	}
	
	public Time retornarTime(String nomeTime){
		String sql = "SELECT * FROM time WHERE nometime = '"+nomeTime+"'" ;
		ResultSet rs = banco.executarSelect(sql);
		
		String nome=null;
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		int idTime=0;
		try {
			if(rs.next()){
				nome = rs.getString("nometime");
				idTime=rs.getInt("idtime");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Time time = new Time();
		time.setNome(nome);
		time.setJogadores(jogadores);
		time.setIdTime(idTime);//time.setTatica(tatica);
		return time;
	}
}
