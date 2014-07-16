package perssistencia;

import bd.Banco;
import dominio.Jogador;

public class JogadorDAO {
	Banco banco = new Banco();
	
	public void JogadorDAO () {
		
		
	}
	
	public void inserirJogador(Jogador jogador){
		String sql = "Insert into Jogador (nome, email, data_de_nascimento, senha) VALUES('"
				+ jogador.getNome()
				+ "','"
				+ jogador.getPeso()
				+ "','"
				+ jogador.getAltura()
				+ "','"
				+ jogador.getTime()
				+ "','"
				+ jogador.isTemCondicao()
				+ "','"
				+ jogador.getIdade() + "')";
		
		banco.executarSQL(sql);
		
	}
	public void excluirJogador(Jogador jogador){
		String sql = "DELETE FROM jogador WHERE id LIKE '"+jogador.getId()+"'";
		banco.executarSQL(sql);
	}
	
	
}
