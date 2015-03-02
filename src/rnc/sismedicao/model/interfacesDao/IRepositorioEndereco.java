package rnc.sismedicao.model.interfacesDao;

import rnc.sismedicao.model.beans.Endereco;

public interface IRepositorioEndereco {

	public int insertEndereco (int codEndereco) throws Exception;
	
	public void removerEndereco (int codEndereco) throws Exception;
	
	public Endereco procurar (int codEndereco) throws Exception;
}
