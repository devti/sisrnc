package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Equipamento;

public interface IRepositorioEquipamento {

	public int insertEquipamento (Equipamento equipamento) throws Exception;
	
	public void removerEquipamento (int codEquipamento) throws Exception;

	public ArrayList<Equipamento> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException;

	public Equipamento procurar(int codEquipamento) throws EquipamentoNaoEncontrandoException, SQLException,
	RepositorioException;
	
}
