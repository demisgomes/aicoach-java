package dominio;

public class DiferencaTime {
	
	private String tipoDiferenca;
	private boolean meuTimeFavorito;
	public String getTipoDiferenca() {
		return tipoDiferenca;
	}
	public DiferencaTime(String tipoDiferenca, boolean meuTimeFavorito) {
		super();
		this.tipoDiferenca = tipoDiferenca;
		this.meuTimeFavorito = meuTimeFavorito;
	}
	public void setTipoDiferenca(String tipoDiferenca) {
		this.tipoDiferenca = tipoDiferenca;
	}
	public boolean isMeuTimeFavorito() {
		return meuTimeFavorito;
	}
	public void setMeuTimeFavorito(boolean meuTimeFavorito) {
		this.meuTimeFavorito = meuTimeFavorito;
	}

}
