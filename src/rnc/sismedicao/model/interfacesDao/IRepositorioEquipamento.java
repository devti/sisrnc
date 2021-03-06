package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.beans.Item;

public interface IRepositorioEquipamento {

	public int insertEquipamento (Equipamento equipamento) throws Exception;
	
	public void removerEquipamento (int codEquipamento) throws Exception;

	public ArrayList<Equipamento> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException, RepositorioException;

	public Equipamento procurar(int codEquipamento) throws EquipamentoNaoEncontrandoException, SQLException,
	RepositorioException;

	public int consultarUltimoCodigoEquipamento() throws Exception;
	
	public int inserirEquipamentoItem (Equipamento e) throws Exception;

	public void removerEquipamentoItem(int codigoEquipamento) throws Exception;

	public void atualizarEquipamento(Equipamento equipamento);
	
	public ArrayList<Item> listarItemEquipamento(int id) throws SQLException, RepositorioException;	
}
