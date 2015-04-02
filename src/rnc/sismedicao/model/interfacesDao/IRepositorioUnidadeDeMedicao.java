package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.UnidadeDeMedicaoNaoEncontradaException;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;

public interface IRepositorioUnidadeDeMedicao {

	public String inserir (UnidadeDeMedicao unidadeDeMedicao) throws Exception;
	
	public void removerUnidadeDeMedicao (String codUnidade) throws RepositorioException, SQLException;
	
	public UnidadeDeMedicao procurar (String codUnidade) throws SQLException, RepositorioException, UnidadeDeMedicaoNaoEncontradaException;

	public void searchRealTime(int opcao, String pesquisa,
			DefaultTableModel modelo);

	public UnidadeDeMedicao getUnidadeDeMedicao(String codUnidadeDeMedicao);

	public ArrayList<UnidadeDeMedicao> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException;
	
	public ArrayList<UnidadeDeMedicao> listar() throws SQLException, RepositorioException;
}
