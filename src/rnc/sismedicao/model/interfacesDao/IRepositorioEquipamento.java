package rnc.sismedicao.model.interfacesDao;

import rnc.sismedicao.model.beans.Equipamento;

public interface IRepositorioEquipamento {

	public int insertEquipamento (Equipamento equipamento, int codLocal, int codItem) throws Exception;
	
	public void removerEquipamento (int codEquipamento) throws Exception;
	
	public Equipamento procurar (int codEquipamento, int codLocal, int codItem) throws Exception;
	
}
