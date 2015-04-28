package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;

public interface IRepositorioItem {
	
	public int inserir(Item item) throws  Exception;
	
	public int consultarUltimoCodigoItem() throws Exception;
	
	public int alterar(Item item) throws Exception;
	
	public ArrayList<Item> listar() throws SQLException, RepositorioException;

	public Item procurar(int codItem) throws ItemNaoEncontradoException, SQLException, RepositorioException;
	
	public ArrayList <Item> pesquisaAvancada(String atributo, String pesquisa) throws SQLException;
	
	public void removerItem(int codItem) throws Exception;

	public ArrayList<Item> procurarEquipamentoItem(int codEquipamento) throws Exception;

}


