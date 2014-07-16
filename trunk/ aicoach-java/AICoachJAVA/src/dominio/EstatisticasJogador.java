package dominio;

public class EstatisticasJogador extends Estatisticas {

	private int defesasDificeis;
	private int assistencias;
	
	
	
	public EstatisticasJogador(int faltasCometidas, int faltasSofridas,
			int passesCertos, int passesErrados, int cartoesAmarelos,
			int cartoesVermelhos, int finalizacoesErradas, int impedimentos,
			int gols, int roubadasBola, int jogos, int defesasDificeis, int assistencias) {
		super(faltasCometidas, faltasSofridas, passesCertos, passesErrados,
				cartoesAmarelos, cartoesVermelhos, finalizacoesErradas, impedimentos,
				gols, roubadasBola, jogos);
		
		this.defesasDificeis=defesasDificeis;
		this.assistencias=assistencias;
		// TODO Auto-generated constructor stub
	}
	
	public EstatisticasJogador(){
		
	}
	public int getDefesasDificeis() {
		return defesasDificeis;
	}

	public void setDefesasDificeis(int defesasDificeis) {
		this.defesasDificeis = defesasDificeis;
	}

	public int getAssistencias() {
		return assistencias;
	}

	public void setAssistencias(int assistencias) {
		this.assistencias = assistencias;
	}

	
}
