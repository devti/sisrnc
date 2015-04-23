package rnc.sismedicao.model.interfacesDao;


import java.util.ArrayList;

import rnc.sismedicao.model.beans.ItemMedicao;

public interface IRepositorioItemMedicao {
	
	public int inserir(ItemMedicao itemMedicao) throws  Exception;
	
	public ArrayList<ItemMedicao> procurar (int codItem) throws Exception;
	
	public void remover(int codItemMedicao) throws Exception;
	
	public void alterar(ItemMedicao itemMedicao) throws  Exception;
	
	public void removerAll(int codItem) throws Exception;

}
