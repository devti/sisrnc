package rnc.sismedicao.fachada;

import java.sql.SQLException;


import rnc.sismedicao.controller.UsuarioController;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;


public class Fachada {

	private static Fachada instance = null;
	private UsuarioController controladorUsuario;

	Fachada() throws Exception {
		this.controladorUsuario = new UsuarioController();
	}

	public static Fachada getInstance() throws Exception {
		if (Fachada.instance == null) {
			try {
				Fachada.instance = new Fachada();
			} catch (Exception e) {
				throw new Exception("Erro => " + e.getMessage());
			}
		}
		return Fachada.instance;
	}
	
	public boolean usuarioLogin(String usuario, String senha)
		throws RepositorioException, SQLException, SenhaInvalidaException {
		return controladorUsuario.login(usuario, senha);
	}
}
