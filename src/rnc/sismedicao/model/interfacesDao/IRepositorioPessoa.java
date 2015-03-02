package rnc.sismedicao.model.interfacesDao;

import rnc.sismedicao.model.beans.Pessoa;

public interface IRepositorioPessoa {

	public int insertPessoa (Pessoa pessoa) throws Exception;
	
	public void removerPessoa (int codPessoa) throws Exception;
	
	public Pessoa procurar (int codPessoa) throws Exception;
}
