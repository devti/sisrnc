package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.util.Conexao;


public class UnidadeDeMedicaoDAO {
	
	
	public UnidadeDeMedicaoDAO() {
		
	}
	
	public String insertUnidadeDeMedicao(UnidadeDeMedicao unidadeDeMedicao){
		
		if(JOptionPane.showConfirmDialog(null, "tem certeza que quer cadastrar esta unidade?"
										 , "Confirmar cadastro"
										 , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
			
		String query = "INSERT INTO UNIDADEMEDICAO(CODUNIDADE, DESCRICAO) VALUES (?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, unidadeDeMedicao.getCodigo());
				preparedStatement.setString(++i, unidadeDeMedicao.getDescricao());
				
				preparedStatement.execute();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					unidadeDeMedicao.setCodigo(resultSet.getString(1));
				}
				
				JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				try {
					Conexao.getConnection().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
		}
	return unidadeDeMedicao.getCodigo();
	}
	
	public void update(UnidadeDeMedicao unidadeDeMedicao){
		
		String query = "UPDATE UNIDADEMEDICAO SET CODUNIDADE = ?, DESCRICAO = ? WHERE CODUNIDADE = ?";
		
		try {
			int i = 0;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			
			preparedStatement.setString(++i, unidadeDeMedicao.getCodigo());
			preparedStatement.setString(++i, unidadeDeMedicao.getCodigo());
			
			preparedStatement.executeQuery();
			
			Conexao.getConnection().commit();
						
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso", "Atualização com sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	public List<UnidadeDeMedicao> ListAll(){
		String query = "SELECT * FROM UNIDADEMEDICAO";
		
		List<UnidadeDeMedicao> unidadesDeMedicao = new ArrayList<UnidadeDeMedicao>();
		
		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			Conexao.getConnection().commit();
			
			//UnidadeDeMedicao unidadeDeMedicao = new UnidadeDeMedicao();
			
			while(resultSet.next()){
				UnidadeDeMedicao unidadeDeMedicao = new UnidadeDeMedicao();	
				unidadeDeMedicao.setCodigo(resultSet.getString(1));
				unidadeDeMedicao.setDescricao(resultSet.getString(2));
				
				unidadesDeMedicao.add(unidadeDeMedicao);
				System.out.println(unidadeDeMedicao.getCodigo()+": "+unidadeDeMedicao.getDescricao());
			}
			
			JOptionPane.showMessageDialog(null, "Todos os registro foram \nrecuperados com sucesso", "Recuperação com sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		return unidadesDeMedicao;
	}
	
	
	
	
	
}
