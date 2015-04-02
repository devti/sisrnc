package rnc.sismedicao.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.CPFInvalidoException;
import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.dao.PessoaDAO;
import rnc.sismedicao.model.interfacesDao.IRepositorioPessoa;
import rnc.sismedicao.model.util.Validacao;

public class PessoaController {

	private IRepositorioPessoa repositorioPessoa; // aki tu ta criando uma variavel do tipo IRepositorio Pessoa, tu pode dar um new nela com qualquer classe que implemente essa interface
	
	public PessoaController() throws Exception {
		this.repositorioPessoa = new PessoaDAO(this.repositorioPessoa); // aqui é o construtor, quando tu der um new em PessoaControler ele vai dar o new em Pessoa DAO .. 
	}
	
	public void cadastrar(Pessoa pessoa) throws Exception {
		if(!Validacao.validaCPF(pessoa.getCpf()))
			throw new CPFInvalidoException(pessoa.getCpf());
		pessoa.setCpf(pessoa.getCpf().replaceAll("\\.|\\-|\\ ", ""));
		repositorioPessoa.inserir(pessoa);
	}

	public void remover(int codPessoa) throws RepositorioException, SQLException {
		repositorioPessoa.removerPessoa(codPessoa);
		}
	
	public Pessoa procurar (int codPessoa) throws PessoaNaoEncontradaException,
			RepositorioException, SQLException {		
		return repositorioPessoa.procurar(codPessoa);
	}

	public ArrayList<Pessoa> pesquisaAvancada(String atributo, String pesquisa)
			throws SQLException, RepositorioException {
		return repositorioPessoa.pesquisaAvancada(atributo, pesquisa);
	}
		
	}
	

