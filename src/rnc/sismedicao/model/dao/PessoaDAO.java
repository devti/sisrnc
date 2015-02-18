package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.util.Conexao;

public class PessoaDAO {
	
	
	public PessoaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertPessoa(Pessoa pessoa){
		
		if(JOptionPane.showConfirmDialog(null, "tem certeza que quer cadastrar a pessoa: "+pessoa.getNome()+"?"
										, "Confirmação de cadastro"
										, JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
			
		String query = "INSERT INTO PESSOA(NOME, CPF, EMAIL, TELEFONE) VALUES (?, ?, ?, ?) ";
		
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, pessoa.getNome());
				preparedStatement.setString(++i, pessoa.getCpf());
				preparedStatement.setString(++i, pessoa.getEmail());
				preparedStatement.setString(++i, pessoa.getTelefone());
				
				preparedStatement.executeUpdate();
				
				Conexao.getConnection().commit();
				
				JOptionPane.showMessageDialog(null, "Pessoa: "+pessoa.getNome()+" cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
				
				resultSet = preparedStatement.getGeneratedKeys();
			
				if(resultSet.next()){
					pessoa.setCodPessoa(resultSet.getInt(1));
				
				}
			
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar incluir uma pessoa no Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} 
		
		
		}
	return pessoa.getCodPessoa();
		
	}
	
}
