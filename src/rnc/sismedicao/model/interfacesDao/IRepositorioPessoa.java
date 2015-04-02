package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Pessoa;

public interface IRepositorioPessoa {

	public int inserir (Pessoa pessoa) throws Exception;
	
	public void removerPessoa (int codPessoa) throws SQLException, RepositorioException;
	
	public Pessoa procurar (int codPessoa) throws PessoaNaoEncontradaException, RepositorioException, SQLException;

	public ArrayList <Pessoa> pesquisaAvancada(String atributo, String pesquisa) throws SQLException;

	public ArrayList<Pessoa> listar() throws SQLException, RepositorioException;

}
