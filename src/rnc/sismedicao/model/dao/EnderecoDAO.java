package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.model.beans.Endereco;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.util.Conexao;

public class EnderecoDAO {
	
	
	public EnderecoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertEndereco(Endereco endereco){
		
		if(JOptionPane.showConfirmDialog(null, "tem certeza que quer cadastrar o endereço?"
										 , "Confirmar cadastro"
										 , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
			
		String query = "INSERT INTO ENDERECO(CEP, RUA, NUMERO, BAIRRO, CIDADE) VALUES (?, ?, ?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, endereco.getCep());
				preparedStatement.setString(++i, endereco.getRua());
				preparedStatement.setInt(++i, endereco.getNumero());
				preparedStatement.setString(++i, endereco.getCidade());
				
				preparedStatement.execute();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					endereco.setCodEndereco(resultSet.getInt(1));
				}
				
				JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return endereco.getCodEndereco();
	}
	
}
