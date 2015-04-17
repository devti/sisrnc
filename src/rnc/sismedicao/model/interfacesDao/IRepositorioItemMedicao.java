package rnc.sismedicao.model.interfacesDao;


import java.util.ArrayList;

import rnc.sismedicao.model.beans.ItemMedicao;

public interface IRepositorioItemMedicao {
	
	public int inserir(ItemMedicao itemMedicao) throws  Exception;
	
	public ArrayList<ItemMedicao> procurar (int codItem) throws Exception;

}
