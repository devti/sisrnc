package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.util.Conexao;

public class ItemDAO {
	
	
	public ItemDAO() {
		
	}
	
	public int insertItem(Item item){
		
		if(JOptionPane.showConfirmDialog(null, "tem certeza que quer cadastrar este Item?"
										 , "Confirmar cadastro"
										 , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
			
		String query = "INSERT INTO ITEM(DESCRICAO, MARCA) VALUES (?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, item.getDescricao());
				preparedStatement.setString(++i, item.getMarca());
				
				preparedStatement.execute();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					item.setCodItem(resultSet.getInt(1));
				}
				
				JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	return item.getCodItem();
	}
	
	public void removerItem (int codItem) throws Exception {
		
		String sql = "DELETE FROM ITEM WHERE CODITEM = ?";
		
		try {
			
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codItem);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}
	
}
