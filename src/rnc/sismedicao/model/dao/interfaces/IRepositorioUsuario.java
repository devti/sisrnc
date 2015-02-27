package rnc.sismedicao.model.dao.interfaces;

import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Usuario;

public interface IRepositorioUsuario {

	public int insertUsuario (Usuario usuario) throws Exception;
	
	public void removerUsuario (int codUsuario) throws Exception;
	
	public Usuario procurar (int codUsuario) throws Exception, UsuarioNaoEncontradoException;
}
