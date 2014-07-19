package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Banco;
import dominio.Jogador;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class TimeDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
	
	public void inserirTime(Time time){
		String sql = "Insert into time (nometime) VALUES('"
				+time.getNome()+ "')";
		
		banco.executarSQL(sql);
		time.setIdTime(retornarIdTime());
	}
	
	public void inserirTimeTatica(Time time, ArrayList<Integer> listaIdIitulares){
		/*ArrayList <Integer> idJogadores=new ArrayList<Integer>();
		for(int i=0;i<time.getTatica().getPosicoes().size();i++){
			idJogadores.add(time.getTatica().getPosicoes().get(i).getJogador().getId());
		}*/
		String sql = "update time SET idtatica =  '"+time.getTatica().getIdTatica()+"', jogadorestitulares='"+listaIdIitulares+"'  WHERE idtime = '"+time.getIdTime()+"'";
		
		banco.executarSQL(sql);
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
		JogadorDAO jDAO=new JogadorDAO();
		jogadores=jDAO.retornarJogadores(idTime);
		Time time = new Time();
		time.setNome(nome);
		time.setIdTime(idTime);
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
			JogadorDAO jDAO=new JogadorDAO();
			jogadores=jDAO.retornarJogadores(idTime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Time time = new Time();
		time.setNome(nome);
		time.setJogadores(jogadores);
		time.setIdTime(idTime);//time.setTatica(tatica);
		return time;
	}
	
	/*public Time retornarTimeTatica(String nomeTime){
		String sql = "SELECT * FROM time WHERE nometime = '"+nomeTime+"'" ;
		ResultSet rs = banco.executarSelect(sql);
		
		String nome=null;int idTatica=0;
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		int idTime=0;
		try {
			if(rs.next()){
				nome = rs.getString("nometime");
				idTime=rs.getInt("idtime");
				idTatica=rs.getInt("idtatica");
			}
			JogadorDAO jDAO=new JogadorDAO();
			jogadores=jDAO.retornarJogadores(idTime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Time time = new Time();
		time.setNome(nome);
		time.setJogadores(jogadores);
		time.setIdTime(idTime);//time.setTatica(tatica);
		return time;
	}*/
	
	public Tatica retornarTaticaTime(Time  time){
		ArrayList <Integer> idJogadores=new ArrayList<Integer>();
		String sql="SELECT * FROM time";
		ResultSet rs=banco.executarSelect(sql);
		String idFakeJogadores=null;
		
		try {
			int idTatica=0;
			if(rs.last()){
				idTatica=rs.getInt("idtatica");	
				idFakeJogadores=rs.getString("jogadorestitulares");
			}
			Tatica tatica=null;
			
			if(idTatica!=0){
				TaticaDAO tDAO=new TaticaDAO();
				tatica=tDAO.retornarTatica(idTatica);
			}
			String [] posicoesSeparadas=idFakeJogadores.split(",");
			for (int i = 0; i < posicoesSeparadas.length; i++) {
				posicoesSeparadas[i]=posicoesSeparadas[i].substring(1);
				if(i==posicoesSeparadas.length-1){
					posicoesSeparadas[i]=posicoesSeparadas[i].substring(0, posicoesSeparadas[i].length()-1);
				}
				int int1 = Integer.parseInt(posicoesSeparadas[i]);
				JogadorDAO jDAO=new JogadorDAO();
				Jogador j = jDAO.retornarJogador(int1);
				tatica.getPosicoes().get(i).setJogador(j);
				tatica.getPosicoes().get(i).getJogador().setEscolhido(1);
				for(Jogador x : time.getJogadores()){
					if (x.getId()==j.getId()){
						x.setEscolhido(1);
					}
				}
				tatica.getPosicoes().get(i).getJogador().setPosicaoAtual(tatica.getPosicoes().get(i));
			}
			
			return tatica;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			banco.fecharBanco();
		}
	}
	
	
	public ArrayList<Time> retornarListaTimes(){
		String sql="SELECT * FROM time";
		ResultSet rs=banco.executarSelect(sql);
		ArrayList<Time> lista=new ArrayList<Time>();
		
		try {
			while(rs.next()){
				Time t= retornarTime(rs.getInt("idtime"));
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
