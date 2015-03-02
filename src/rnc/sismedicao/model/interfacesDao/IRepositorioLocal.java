package rnc.sismedicao.model.interfacesDao;

import rnc.sismedicao.controller.exception.LocalNaoEncontradoException;
import rnc.sismedicao.model.beans.Local;

public interface IRepositorioLocal {

	public int insertLocal (int codLocal) throws Exception;
	
	public void removerLocal (int codLocal) throws Exception;
	
	public Local procurar (int codLocal) throws Exception, LocalNaoEncontradoException;
}
