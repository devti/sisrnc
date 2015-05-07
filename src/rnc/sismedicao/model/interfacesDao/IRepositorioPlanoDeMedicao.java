package rnc.sismedicao.model.interfacesDao;

import rnc.sismedicao.model.beans.PlanoDeMedicao;

public interface IRepositorioPlanoDeMedicao {

	public void inserir (PlanoDeMedicao planoDeMedicao) throws Exception;
	
	public int consultarUltimoCodigoPlanoMedicao() throws Exception;
	
}
