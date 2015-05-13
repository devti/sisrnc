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
	
	public void atualizar(Item item) throws Exception {
		repositorioItem.alterar(item);
	}	
	
	public int consultarUltimoCodigoItem() throws Exception{
		return repositorioItem.consultarUltimoCodigoItem();
	}
	
	public ArrayList<Item> pesquisaAvancada(String atributo, String pesquisa)
			throws SQLException, RepositorioException {
		return repositorioItem.pesquisaAvancada(atributo, pesquisa);
	}
	
	public void removerItem(int codItem) throws Exception{
		repositorioItem.removerItem(codItem);
	}
	
	public ArrayList <Item> procurarEquipamentoItem (int codEquipamento) throws Exception {
		return repositorioItem.procurarEquipamentoItem(codEquipamento);
	}

	public ArrayList<Item> listarItem() throws SQLException, RepositorioException {
		return repositorioItem.listar();
	}

	public Item procurar(int codItem) throws ItemNaoEncontradoException, SQLException, RepositorioException {
		return repositorioItem.procurar(codItem);
	}

	public void removerItemEquipamento(int codItem) throws Exception {
		repositorioItem.removerItemEquipamento(codItem);
		
	}
	
	
}
