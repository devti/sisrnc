package rnc.sismedicao.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.interfacesDao.*;
import rnc.sismedicao.model.dao.*;

public class PlanoDeMedicaoController {
	private IRepositorioPlanoDeMedicao repositorioPlanoDeMedicao;
	
	public PlanoDeMedicaoController(){
		this.repositorioPlanoDeMedicao = new PlanoDeMedicaoDAO(this.repositorioPlanoDeMedicao);
			
	}
	
	public void inserir (PlanoDeMedicao planoDeMedicao) throws Exception{
		repositorioPlanoDeMedicao.inserir(planoDeMedicao);
	}
	
	public int consultarUltimoCodigoPlanoMedicao() throws Exception{
		return repositorioPlanoDeMedicao.consultarUltimoCodigoPlanoMedicao();
	}
	public ArrayList<PlanoDeMedicao> pesquisaAvancada(String atributo, String pesquisa)
			throws SQLException, RepositorioException {
		return repositorioPlanoDeMedicao.pesquisaAvancada(atributo, pesquisa);
	}
	public PlanoDeMedicao procurar(int codigo) throws SQLException, RepositorioException {
		return repositorioPlanoDeMedicao.procurar(codigo);
	}
	
	public void removerPlanoDeMedicao(int codigo) throws Exception{
		repositorioPlanoDeMedicao.removerPlanoDeMedicao(codigo);
	}
}
