package rnc.sismedicao.controller;

import rnc.sismedicao.model.beans.Falha;
import rnc.sismedicao.model.dao.FalhaDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioFalha;

public class FalhaController {
	
	private IRepositorioFalha repositorioFalhas;
	
	public FalhaController() {
		this.repositorioFalhas = new FalhaDAO(this.repositorioFalhas);
	}

	public void cadastrar(Falha element) {
		// TODO Auto-generated method stub
		
	}

	public void atualizarFalha(Falha falha) {
		// TODO Auto-generated method stub
		
	}

}
