package rnc.sismedicao.testPackage;

import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.dao.PessoaDAO;

public class MainParaTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pessoa pessoa = new Pessoa("Charles Arruda", "067.276.794-52", "charlesinsane@hotmail.com", "8199263338");
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.insertPessoa(pessoa);
	}

}
