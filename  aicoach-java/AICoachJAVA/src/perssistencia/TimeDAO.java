package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;
import dominio.Jogador;
import dominio.Time;

public class TimeDAO {
	Banco banco = new Banco("jdbc:mysql://localhost/aicoach","root","root");
	public Time retornarTime(int idTime){
		String sql = "SELECT * FROM time WHERE idTime = '"+idTime+"'" ;
		ResultSet rs = banco.executarSelect(sql);
		
		String nome=null;
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		try {
			nome = rs.getString("nometime");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Time time = new Time();
		time.setNome(nome);
		time.setJogadores(jogadores);
		//time.setTatica(tatica);
		return time;
	}
}
