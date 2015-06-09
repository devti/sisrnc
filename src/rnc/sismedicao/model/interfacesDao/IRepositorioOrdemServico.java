package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.OrdemServico;

public interface IRepositorioOrdemServico {
	public void inserir(OrdemServico ordemServico) throws Exception;

	public void removerOrdemServico(int codigoPlanoDeMedicao) throws Exception;

	public ArrayList<OrdemServico> listarOS(int[] codigosGruposTecnicos) throws SQLException,
	RepositorioException;
}