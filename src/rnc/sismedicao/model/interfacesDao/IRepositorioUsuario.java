package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Usuario;

public interface IRepositorioUsuario {
	

	public int inserir(Usuario usuario) throws  Exception;
	
	public void removerUsuario (int codPessoa) throws RepositorioException, SQLException;
	
	public Usuario procurar (int codPessoa) throws SQLException, RepositorioException, UsuarioNaoEncontradoException;
	
	public boolean login (String usuario, String senha) throws SenhaInvalidaException, RepositorioException, SQLException;

	public ArrayList<Usuario> pesquisaAvancada(String atributo, String pesquisa) throws SQLException;

	public ArrayList<Usuario> listar() throws SQLException, RepositorioException;	
	
}
