package rnc.sismedicao.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.dao.EquipamentoDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioEquipamento;

public class EquipamentoController {
	
	private IRepositorioEquipamento repositorioEquipamento;
	
	public EquipamentoController() throws Exception {
		this.repositorioEquipamento = new EquipamentoDAO(this.repositorioEquipamento);
	}

	public void cadastrar(Equipamento equipamento) throws Exception {
		repositorioEquipamento.insertEquipamento(equipamento);
		
	}

	public ArrayList<Equipamento> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException {
		return repositorioEquipamento.pesquisaAvancada(atributo, pesquisa);
	}

	public Equipamento procurar(int codEquipamento) throws EquipamentoNaoEncontrandoException, SQLException,
			RepositorioException {
		return this.repositorioEquipamento.procurar(codEquipamento);
	}
	
	public int consultarUltimoCodigoEquipamento() throws Exception {
		return repositorioEquipamento.consultarUltimoCodigoEquipamento();
	}

	public void cadastrarEquipamentoItem(Equipamento e) throws Exception {
		repositorioEquipamento.inserirEquipamentoItem(e);
	}

}
