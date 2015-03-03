package rnc.sismedicao.controller;

import java.sql.SQLException;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.dao.UsuarioDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioUsuario;

public class UsuarioController {

	private IRepositorioUsuario repositorioUsuario;

	public void inserir(Usuario usuario) throws Exception {

	}

	public boolean login(String usuario, String senha)
			throws RepositorioException, SQLException, SenhaInvalidaException {
		UsuarioDAO usuarioLogin = new UsuarioDAO(this.repositorioUsuario);
		return usuarioLogin.login(usuario, senha);

	}
}
