package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.util.Conexao;

public class ItemMedicaoDAO {
	
	
	public ItemMedicaoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertItemMedicao(ItemMedicao itemMedicao, int codEquipamento, int codUnidade){
				
		String query = "INSERT INTO ITEMMEDICAO(CODEQUIPAMENTO, CODUNIDADE, VALORMIN, VALORMAX) VALUES (?, ?, ?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(++i, codEquipamento);
				preparedStatement.setInt(++i, codUnidade);
				preparedStatement.setDouble(++i, itemMedicao.getValorMIN());
				preparedStatement.setDouble(++i, itemMedicao.getValorMAX());
				
				preparedStatement.execute();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					itemMedicao.setCodItemMedicao(resultSet.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	return itemMedicao.getCodItemMedicao();
	}
	
	public void removerItemDeMedicao(int codItemMedicao) throws Exception {

		String sql = "DELETE FROM ITEMMEDICAO WHERE CODITEMMEDICAO = ?";

		try {

			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codItemMedicao);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}
	
	private List<ItemMedicao> listAll(){
		
		String query = "SELECT * FROM ITEMMEDICAO";

		List<ItemMedicao> itens = new ArrayList<ItemMedicao>();

		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			Conexao.getConnection().commit();
			
			itens = carregaList(resultSet);
			
//			JOptionPane.showMessageDialog(null,
//					"Todos os registro foram \nrecuperados com sucesso",
//					"Recuperação com sucesso", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Todos os Itens de Medição foram recuperados com sucesso");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return itens;
		
	}
	
	private List<ItemMedicao> carregaList(ResultSet resultSet) {

		List<ItemMedicao> itens = new ArrayList<ItemMedicao>();

		try {
			while (resultSet.next()) {
				ItemMedicao itemMedicao = new ItemMedicao();

				itens.add(itemMedicao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}

		return itens;

	}
	
}
