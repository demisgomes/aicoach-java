package dominio;

public class Estatisticas {
	
	private int faltasCometidas;
	private int faltasSofridas;
	private int passesCertos;
	private int passesErrados;
	private int cartoesAmarelos;
	private int cartoesVermelhos;
	private int finalizacoesErradas;
	private int impedimentos;
	private int gols;
	private int roubadasBola;
	private int jogos;
	
	public Estatisticas(int faltasCometidas, int faltasSofridas,
			int passesCertos, int passesErrados, int cartoesAmarelos,
			int cartoesVermelhos, int finalizacoesErradas, int impedimentos,
			int gols, int roubadasBola, int jogos) {
		this.faltasCometidas = faltasCometidas;
		this.faltasSofridas = faltasSofridas;
		this.passesCertos = passesCertos;
		this.passesErrados = passesErrados;
		this.cartoesAmarelos = cartoesAmarelos;
		this.cartoesVermelhos = cartoesVermelhos;
		this.finalizacoesErradas = finalizacoesErradas;
		this.impedimentos = impedimentos;
		this.gols = gols;
		this.roubadasBola = roubadasBola;
		this.jogos = jogos;
	}
	
	public Estatisticas(){
		
	}

	public int getFaltasCometidas() {
		return faltasCometidas;
	}

	public void setFaltasCometidas(int faltasCometidas) {
		this.faltasCometidas = faltasCometidas;
	}

	public int getFaltasSofridas() {
		return faltasSofridas;
	}

	public void setFaltasSofridas(int faltasSofridas) {
		this.faltasSofridas = faltasSofridas;
	}

	public int getPassesCertos() {
		return passesCertos;
	}

	public void setPassesCertos(int passesCertos) {
		this.passesCertos = passesCertos;
	}

	public int getPassesErrados() {
		return passesErrados;
	}

	public void setPassesErrados(int passesErrados) {
		this.passesErrados = passesErrados;
	}

	public int getCartoesAmarelos() {
		return cartoesAmarelos;
	}

	public void setCartoesAmarelos(int cartoesAmarelos) {
		this.cartoesAmarelos = cartoesAmarelos;
	}

	public int getCartoesVermelhos() {
		return cartoesVermelhos;
	}

	public void setCartoesVermelhos(int cartoesVermelhos) {
		this.cartoesVermelhos = cartoesVermelhos;
	}

	public int getFinalizacoesErradas() {
		return finalizacoesErradas;
	}

	public void setFinalizacoesErradas(int finalizacoesErradas) {
		this.finalizacoesErradas = finalizacoesErradas;
	}

	public int getImpedimentos() {
		return impedimentos;
	}

	public void setImpedimentos(int impedimentos) {
		this.impedimentos = impedimentos;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getRoubadasBola() {
		return roubadasBola;
	}

	public void setRoubadasBola(int roubadasBola) {
		this.roubadasBola = roubadasBola;
	}

	public int getJogos() {
		return jogos;
	}

	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	
	

}
