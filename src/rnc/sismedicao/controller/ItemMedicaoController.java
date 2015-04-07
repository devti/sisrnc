package rnc.sismedicao.controller;

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
}
