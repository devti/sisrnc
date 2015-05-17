package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.PlanoDeMedicao;

public interface IRepositorioPlanoDeMedicao {

	public void inserir (PlanoDeMedicao planoDeMedicao) throws Exception;
	
	public int consultarUltimoCodigoPlanoMedicao() throws Exception;
	
	public ArrayList <PlanoDeMedicao> pesquisaAvancada(String atributo, String pesquisa) throws SQLException;
	
	public PlanoDeMedicao procurar(int codigo) throws SQLException, RepositorioException;
	
	public void removerPlanoDeMedicao(int codigo) throws Exception;
}
