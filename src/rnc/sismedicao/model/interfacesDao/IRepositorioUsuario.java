package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Usuario;

public interface IRepositorioUsuario {

	public int insertUsuario (Usuario usuario) throws Exception;
	
	public void removerUsuario (int codUsuario) throws Exception;
	
	public Usuario procurar (int codUsuario) throws Exception, UsuarioNaoEncontradoException;
	
	public boolean login (String usuario, String senha) throws SenhaInvalidaException, RepositorioException, SQLException;
}
