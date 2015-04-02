package rnc.sismedicao.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.UnidadeDeMedicaoNaoEncontradaException;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.dao.UnidadeDeMedicaoDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioUnidadeDeMedicao;

public class UnidadeDeMedicaoController {
	
	private IRepositorioUnidadeDeMedicao repositorioUnidadeDeMedicao; 
	
	//private UnidadeDeMedicaoDAO unidadeDeMedicaoDAO  = new UnidadeDeMedicaoDAO();
	
	private UnidadeDeMedicao unidadeDeMedicao;
	
	
	public static final int PESQUISAR_CODIGO = 0;
	public static final int PESQUISAR_NOME = 1;
	
 	public UnidadeDeMedicaoController() throws Exception {
 		this.repositorioUnidadeDeMedicao = new UnidadeDeMedicaoDAO(this.repositorioUnidadeDeMedicao);
 	}
	
	public UnidadeDeMedicao getUnidadeMedicao() {
		return this.unidadeDeMedicao;
	}

	public void setUnidadeDeMedicao(UnidadeDeMedicao unidadeDeMedicao) {
		this.unidadeDeMedicao = unidadeDeMedicao;
	}

	public void tablePesquisa(int opcao, String pesquisa, DefaultTableModel modelo){
		repositorioUnidadeDeMedicao.searchRealTime(opcao, pesquisa, modelo);
	}
	
	public UnidadeDeMedicao getItemDao(String codUnidadeDeMedicao){
		return repositorioUnidadeDeMedicao.getUnidadeDeMedicao(codUnidadeDeMedicao);
	}

	public void cadastrar(UnidadeDeMedicao unidadeDeMedicao) throws Exception {
		repositorioUnidadeDeMedicao.inserir(unidadeDeMedicao);
	}

	public ArrayList<UnidadeDeMedicao> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException {
		
		return repositorioUnidadeDeMedicao.pesquisaAvancada(atributo, pesquisa);
	}
	
	public ArrayList<UnidadeDeMedicao> listarUnidadeMedicao() throws SQLException, RepositorioException {
		return repositorioUnidadeDeMedicao.listar();
		
	}

	public UnidadeDeMedicao procurar(String codUnidade) throws UnidadeDeMedicaoNaoEncontradaException,
			RepositorioException, SQLException {
		return repositorioUnidadeDeMedicao.procurar(codUnidade);
	}
	
	
	
}
