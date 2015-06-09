package rnc.sismedicao.controller;

import java.sql.SQLException;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Falha;
import rnc.sismedicao.model.dao.FalhaDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioFalha;

public class FalhaController {
	
	private IRepositorioFalha repositorioFalhas;
	
	public FalhaController() {
		this.repositorioFalhas = new FalhaDAO(this.repositorioFalhas);
	}

	public void cadastrar(Falha falha) throws RepositorioException, SQLException {
		repositorioFalhas.cadastrar(falha);
		
	}

	public void atualizarFalha(Falha falha) {
		// TODO Auto-generated method stub
		
	}

}
