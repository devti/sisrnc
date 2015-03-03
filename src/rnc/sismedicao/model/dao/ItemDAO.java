package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.controller.ItemController;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.util.Conexao;

public class ItemDAO {
	
	private Item item;
	
	public ItemDAO() {
		item = new Item();
	}

	public int insertItem(Item item) {

		if (JOptionPane.showConfirmDialog(null,
				"tem certeza que quer cadastrar este Item?",
				"Confirmar cadastro", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

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

				if (resultSet.next()) {
					item.setCodItem(resultSet.getInt(1));
				}

				JOptionPane.showMessageDialog(null,
						"Item cadastrado com sucesso",
						"Cadastrado com sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return item.getCodItem();
	}

	public void removerItem(int codItem) throws Exception {

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
	
	
	private List<Item> carregaList(ResultSet resultSet){
		
		List<Item> itens = new ArrayList<Item>();
		
		try {
			while (resultSet.next()) {
				Item item = new Item();
				item.setCodItem(resultSet.getInt(1));
				item.setCodCliente(resultSet.getString(2));
				item.setNome(resultSet.getString(3));
				item.setDescricao(resultSet.getString(4));
				item.setMarca(resultSet.getString(5));

				itens.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}
				
		return itens;
				
	}

	public List<Item> ListAll() {

		String query = "SELECT * FROM ITEM";

		List<Item> itens = new ArrayList<Item>();

		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			Conexao.getConnection().commit();
			
			itens = carregaList(resultSet);
	
			JOptionPane.showMessageDialog(null,
					"Todos os registro foram \nrecuperados com sucesso",
					"Recuperação com sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return itens;

	}

	public void update(Item item) {

		String query = "UPDATE ITEM SET CODCLIENTE = ?, NOME = ?, DESCRICAO = ?, MARCA = ? WHERE CODITEM = ?";

		try {
			int i = 0;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);

			preparedStatement.setString(++i, item.getCodCliente());
			preparedStatement.setString(++i, item.getNome());
			preparedStatement.setString(++i, item.getDescricao());
			preparedStatement.setString(++i, item.getMarca());
			preparedStatement.setInt(++i, item.getCodItem());

			preparedStatement.executeQuery();

			Conexao.getConnection().commit();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso",
					"Atualização com sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

		
	public void searchRealTime(int opcao, String pesquisa, DefaultTableModel modelo){
		
		String campo;
		
		switch (opcao) {
		case ItemController.PESQUISAR_CODIGO:
			campo = "CODCLIENTE";
			break;
		case ItemController.PESQUISAR_NOME:
			campo = "NOME";
			break;
		default:
			throw new RuntimeException("Opção inválida");
		} 
		
		String query = "SELECT * FROM ITEM WHERE "+campo+" LIKE '%"+pesquisa+"%';";		
		
		ResultSet resultSet = null; 
		
		try {
			
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				modelo.addRow(new Object[]{resultSet.getString("CODCLIENTE"), resultSet.getString("NOME")});
			}
		
		} catch(SQLException e){ 
			throw new RuntimeException(e);
		}
	}
	
	public Item getItem(String codItem){
		String query = "SELECT * FROM ITEM WHERE CODCLIENTE = '"+codItem+"';";		
		ResultSet resultSet = null; 
		try {
			
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				item.setCodItem(resultSet.getInt("CODITEM"));
				item.setCodCliente(resultSet.getString("CODCLIENTE"));
				item.setNome(resultSet.getString("NOME"));
				item.setDescricao(resultSet.getString("DESCRICAO"));
				item.setMarca(resultSet.getString("MARCA"));
			}
			
		} catch(SQLException e){ 
			throw new RuntimeException(e);
		}
				
		return item;
	}
}
