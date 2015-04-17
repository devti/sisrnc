package rnc.sismedicao.controller;

import java.util.ArrayList;

import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.dao.ItemMedicaoDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioItemMedicao;

public class ItemMedicaoController {
	private IRepositorioItemMedicao repositorioItemMedicao;

	public ItemMedicaoController() throws Exception {
		this.repositorioItemMedicao = new ItemMedicaoDAO(this.repositorioItemMedicao);
	}
	
	public void cadastrar(ItemMedicao itemMedicao) throws Exception {
		repositorioItemMedicao.inserir( itemMedicao);
	}

	public ArrayList <ItemMedicao> procurar(int codItem) throws Exception {
		return repositorioItemMedicao.procurar(codItem);
	}	
}
