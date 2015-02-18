package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.util.Conexao;

public class ItemMedicaoDAO {
	
	
	public ItemMedicaoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertItemMedicao(ItemMedicao itemMedicao, int codEquipamento, int codUnidade){
		
		if(JOptionPane.showConfirmDialog(null, "Tem certeza que quer associar este Item para medição ao Equipamento?"
										 , "Confirmar associação"
										 , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
			
		String query = "INSERT INTO ITEMMEDICAO(CODEQUIPAMENTO, CODUNIDADE, DESCRICAO, VALORMIN, VALORMAX) VALUES (?, ?, ?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(++i, codEquipamento);
				preparedStatement.setInt(++i, codUnidade);
				preparedStatement.setString(++i, itemMedicao.getDescricao());
				preparedStatement.setDouble(++i, itemMedicao.getValorMIN());
				preparedStatement.setDouble(++i, itemMedicao.getValorMAX());
				
				preparedStatement.execute();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					itemMedicao.setCodItemMedicao(resultSet.getInt(1));
				}
				
				JOptionPane.showMessageDialog(null, "Item de medição associado com sucesso", "Associado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return itemMedicao.getCodItemMedicao();
	}
	
}
