package perssistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Banco;

import dominio.CaracteristicasJogadores;

public class CaracteristicaDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(), Banco.getRoot());
	
	
	
	public void inserirCaracteristicas(CaracteristicasJogadores caracteristicas){
		String sql = "Insert into caracteristicas (resistencia, cabeceio, qualidadepasse, velocidade, finalizacao, bolaparada, " +
				"controlebola, drible, " + "desarme, defesas, jogador) VALUES('"
				+ caracteristicas.getResistencia()
				+ "','"
				+ caracteristicas.getCabeceio()
				+ "','"
				+ caracteristicas.getQualidadePasse()
				+ "','"
				+ caracteristicas.getVelocidade()
				+ "','"
				+ caracteristicas.getFinalizacao()
				+ "','"
				+ caracteristicas.getBolaParada()
				+ "','"
				+ caracteristicas.getControleBola()
				+ "','"
				+ caracteristicas.getDrible()
				+ "','"
				+ caracteristicas.getDesarme()
				+ "','"
				+ caracteristicas.getDefesas()+ "')";
				
		
		banco.executarSQL(sql);
	}
	
	public CaracteristicasJogadores retornarCaracteristicas(int idJogador){
		String sql = "SELECT * FROM caracteristicas WHERE jogador = '"+idJogador+"'";
		ResultSet rs = banco.executarSelect(sql);
		CaracteristicasJogadores caracteristicas = new CaracteristicasJogadores();
		
		int bolaParada=0, cabeceio=0, controleBola=0, defesas=0, desarme=0, velocidade=0,finalizacao=0,resistencia=0,qualidadePasse=0,drible=0;
		
		try {
			if(rs.next()){
				bolaParada = rs.getInt("bolaparada");
				cabeceio = rs.getInt("cabeceio");
				controleBola = rs.getInt("controlebola");
				defesas = rs.getInt("defesas");
				desarme = rs.getInt("desarme");
				velocidade= rs.getInt("velocidade");
				finalizacao= rs.getInt("finalizacao");
				resistencia= rs.getInt("resistencia");
				qualidadePasse= rs.getInt("qualidadepasse");
				drible= rs.getInt("drible");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		caracteristicas.setBolaParada(bolaParada);
		caracteristicas.setCabeceio(cabeceio);
		caracteristicas.setControleBola(controleBola);
		caracteristicas.setDefesas(defesas);
		caracteristicas.setDesarme(desarme);
		caracteristicas.setDrible(drible);
		caracteristicas.setFinalizacao(finalizacao);
		caracteristicas.setQualidadePasse(qualidadePasse);
		caracteristicas.setResistencia(resistencia);
		caracteristicas.setVelocidade(velocidade);
		
		return caracteristicas;
	}
}
