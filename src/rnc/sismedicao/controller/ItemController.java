package rnc.sismedicao.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.dao.ItemDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioItem;


public class ItemController {
	
	private IRepositorioItem repositorioItem;

	public ItemController() throws Exception {
		this.repositorioItem = new ItemDAO(this.repositorioItem);
	}
	
	public void cadastrar(Item item) throws Exception {
		repositorioItem.inserir(item);
	}	
	
	public int consultarUltimoCodigoItem() throws Exception{
		return repositorioItem.consultarUltimoCodigoItem();
	}
	// --- codigo desativado em 02/04/2015 
	/**	private ItemDAO itemDAO = new ItemDAO();
	
	private Item item;
	
	
	
	public static final int PESQUISAR_CODIGO = 0;
	public static final int PESQUISAR_NOME = 1;
	
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

	public void tablePesquisa(int opcao, String pesquisa, DefaultTableModel modelo){
		itemDAO.searchRealTime(opcao, pesquisa, modelo);
	}
	
	public Item getItemDao(String codItem){
		return itemDAO.getItem(codItem);
	}
	**/

	public ArrayList<Item> listarItem() throws SQLException, RepositorioException {
		return repositorioItem.listar();
	}

	public Item procurar(int codItem) throws ItemNaoEncontradoException, SQLException, RepositorioException {
		return repositorioItem.procurar(codItem);
	}
	
	
}
