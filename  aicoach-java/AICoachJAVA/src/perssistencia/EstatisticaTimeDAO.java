package perssistencia;

import bd.Banco;

public class EstatisticaTimeDAO {
	Banco banco = new Banco(Banco.getUrl(),Banco.getSenha(),Banco.getRoot());
}
