package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.model.beans.Item;
//import rnc.sismedicao.model.beans.ItemMedicao;


public interface IRepositorioItem {
	
	public int inserir(Item item) throws  Exception;
	public int consultarUltimoCodigoItem() throws Exception;

}


