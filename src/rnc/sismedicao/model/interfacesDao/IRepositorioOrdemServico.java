package rnc.sismedicao.model.interfacesDao;

import rnc.sismedicao.model.beans.OrdemServico;

public interface IRepositorioOrdemServico {
	public void inserir(OrdemServico ordemServico) throws Exception;

	public void removerOrdemServico(int codigoPlanoDeMedicao) throws Exception;
}