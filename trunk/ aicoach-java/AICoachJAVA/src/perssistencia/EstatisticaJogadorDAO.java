package perssistencia;

import bd.Banco;

public class EstatisticaJogadorDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
}
