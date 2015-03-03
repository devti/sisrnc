package rnc.sismedicao.testPackage;

import rnc.sismedicao.model.util.Criptografar;

public class MainParaTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String senha = "Senha";
				
		System.out.println(Criptografar.convertToSHA256(senha));
		System.out.println(Criptografar.convertToHashBigInteger32(senha.getBytes()));
		
//		Pessoa pessoa = new Pessoa("Charles Arruda", "067.276.794-52", "charlesinsane@hotmail.com", "8199263338");
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		pessoaDAO.insertPessoa(pessoa);
	}

}
