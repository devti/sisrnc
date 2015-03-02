package rnc.sismedicao.controller;

import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.model.dao.ItemDAO;
import rnc.sismedicao.model.dao.tableModel.ItemTableModel;

public class ItemController {
	
	private ItemDAO itemDAO = new ItemDAO();
	
//	public static final int PESQUISAR_CODIGO = 0;
//	public static final int PESQUISAR_NOME = 1;
	
	public void controlePesquisa(String pesquisa, ItemTableModel modelo){
		itemDAO.searchRealTime(pesquisa, modelo);
		modelo.fireTableDataChanged();
	}
	
	
	public void tablePesquisa(String pesquisa, DefaultTableModel modelo){
		itemDAO.searchRealTime2(pesquisa, modelo);
	}
	
}
