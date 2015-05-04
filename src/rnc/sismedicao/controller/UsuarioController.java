package rnc.sismedicao.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.dao.UsuarioDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioUsuario;

public class UsuarioController {

	private IRepositorioUsuario repositorioUsuario;

	public UsuarioController() throws Exception {
		this.repositorioUsuario = new UsuarioDAO(this.repositorioUsuario);
	}

	public void cadastrar(Usuario usuario) throws Exception {
		repositorioUsuario.inserir(usuario);
	}

	public boolean login(String usuario, String senha)
			throws RepositorioException, SQLException, SenhaInvalidaException {
		UsuarioDAO usuarioLogin = new UsuarioDAO(this.repositorioUsuario);
		return usuarioLogin.login(usuario, senha);

	}

	public void remover(int codPessoa) throws RepositorioException,
			SQLException {
		repositorioUsuario.removerUsuario(codPessoa);

	}

	public Usuario procurar(int codPessoa) throws UsuarioNaoEncontradoException, RepositorioException,
			SQLException {
		return repositorioUsuario.procurar(codPessoa);
	}

	public ArrayList<Usuario> pesquisaAvancada(String atributo, String pesquisa)
			throws SQLException, RepositorioException {
		return repositorioUsuario.pesquisaAvancada(atributo, pesquisa);
	}

	public Usuario getUsuarioLogado() {
		return repositorioUsuario.getUsuarioLogado();
	}

}
