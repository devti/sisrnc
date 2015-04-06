package rnc.sismedicao.model.interfacesDao;


import rnc.sismedicao.model.beans.ItemMedicao;

public interface IRepositorioItemMedicao {
	public int inserir(ItemMedicao itemMedicao, int codItem, int codUnidade) throws  Exception;

}
