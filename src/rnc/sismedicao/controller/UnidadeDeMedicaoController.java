package rnc.sismedicao.controller;

import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.dao.UnidadeDeMedicaoDAO;

public class UnidadeDeMedicaoController {
	
	private UnidadeDeMedicaoDAO unidadeDeMedicaoDAO  = new UnidadeDeMedicaoDAO();
	
	private UnidadeDeMedicao unidadeDeMedicao;
	
	
	public static final int PESQUISAR_CODIGO = 0;
	public static final int PESQUISAR_NOME = 1;
	
	
	public UnidadeDeMedicao getUnidadeMedicao() {
		return this.unidadeDeMedicao;
	}

	public void setUnidadeDeMedicao(UnidadeDeMedicao unidadeDeMedicao) {
		this.unidadeDeMedicao = unidadeDeMedicao;
	}

	public void tablePesquisa(int opcao, String pesquisa, DefaultTableModel modelo){
		unidadeDeMedicaoDAO.searchRealTime(opcao, pesquisa, modelo);
	}
	
	public UnidadeDeMedicao getItemDao(String codUnidadeDeMedicao){
		return unidadeDeMedicaoDAO.getUnidadeDeMedicao(codUnidadeDeMedicao);
	}
	
	
	
}
