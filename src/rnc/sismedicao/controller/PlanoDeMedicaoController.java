package rnc.sismedicao.controller;

import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.interfacesDao.*;
import rnc.sismedicao.model.dao.*;

public class PlanoDeMedicaoController {
	private IRepositorioPlanoDeMedicao repositorioPlanoDeMedicao;
	
	public PlanoDeMedicaoController(){
		this.repositorioPlanoDeMedicao = new PlanoDeMedicaoDAO(this.repositorioPlanoDeMedicao);
			
	}
	
	public void inserir (PlanoDeMedicao planoDeMedicao) throws Exception{
		repositorioPlanoDeMedicao.inserir(planoDeMedicao);
	}
	
	public int consultarUltimoCodigoPlanoMedicao() throws Exception{
		return repositorioPlanoDeMedicao.consultarUltimoCodigoPlanoMedicao();
	}
}
