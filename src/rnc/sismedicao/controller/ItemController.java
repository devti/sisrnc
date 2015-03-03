package rnc.sismedicao.controller;

import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.dao.ItemDAO;

public class ItemController {
	
	private ItemDAO itemDAO = new ItemDAO();
	
	private Item item;
	
	
	
//	public static final int PESQUISAR_CODIGO = 0;
//	public static final int PESQUISAR_NOME = 1;
	
//	public void controlePesquisa(String pesquisa, ItemTableModel modelo){
//		itemDAO.searchRealTime(pesquisa, modelo);
//		modelo.fireTableDataChanged();
//	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void tablePesquisa(String pesquisa, DefaultTableModel modelo){
		itemDAO.searchRealTime(pesquisa, modelo);
	}
	
	public Item getItemDao(String codItem){
		return itemDAO.getItem(codItem);
	}
	
	
	
}
