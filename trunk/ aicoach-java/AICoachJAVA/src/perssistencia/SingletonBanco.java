package perssistencia;

import bd.Banco;

public abstract class SingletonBanco {
	
	private static Banco banco;
	private static boolean estanciado = false;
	
	public static Banco getBanco() {
		criarBanco();
		return banco;
	}


	private static void criarBanco(){
		if(!estanciado){
			banco = new Banco(Banco.getUrl(),Banco.getSenha(), Banco.getRoot());
			estanciado = true;
		}
	}

}
