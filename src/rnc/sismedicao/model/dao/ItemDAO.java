package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





import rnc.sismedicao.controller.ItemController;
import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.util.Conexao;
import rnc.sismedicao.model.interfacesDao.IRepositorioItem;

public class ItemDAO implements IRepositorioItem {
	
	public ItemDAO(IRepositorioItem repositorioItem) {

	}

	public int inserir(Item item) throws Exception{

			String query = "INSERT INTO ITEM(NOME, DESCRICAO, MARCA, SERIAL) VALUES (?, ?, ?, ?) ";

			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, item.getNome());
				preparedStatement.setString(++i, item.getDescricao());
				preparedStatement.setString(++i, item.getMarca());
				preparedStatement.setString(++i, item.getSerial());

				preparedStatement.execute();
				Conexao.getConnection().commit();
				System.out.println("Salvado..."+ item.getNome());
				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					item.setCodItem(resultSet.getInt(1));
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		return item.getCodItem();
	}
	
	
	//Metodo consulta o ultimo codigo do item 
	
	public int consultarUltimoCodigoItem()  throws Exception {
		int codigo = 0;
		ResultSet result = null;
		String sql = "SELECT TOP(1) CODITEM FROM ITEM ORDER BY CODITEM DESC";
		try{
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			result = ps.executeQuery();
			while (result.next()) {
				codigo = result.getInt("CODITEM");
			}
		}catch (SQLException e){
			throw new RepositorioException(e);
		}
		return codigo;
	}
	
/**
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
				item.setNome(resultSet.getString(2));
				item.setDescricao(resultSet.getString(3));
				item.setMarca(resultSet.getString(4));

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
					"Recupera��o com sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return itens;

	}

	public void update(Item item) {

		String query = "UPDATE ITEM SET CODCLIENTE = ?, NOME = ?, DESCRICAO = ?, MARCA = ? , SERIAL = ? WHERE CODITEM = ?";

		try {
			int i = 0;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);

			preparedStatement.setString(++i, item.getNome());
			preparedStatement.setString(++i, item.getDescricao());
			preparedStatement.setString(++i, item.getMarca());
			preparedStatement.setInt(++i, item.getCodItem());

			preparedStatement.executeQuery();

			Conexao.getConnection().commit();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso",
					"Atualiza��o com sucesso", JOptionPane.INFORMATION_MESSAGE);
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
			throw new RuntimeException("Op��o inv�lida");
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
				item.setNome(resultSet.getString("NOME"));
				item.setDescricao(resultSet.getString("DESCRICAO"));
				item.setMarca(resultSet.getString("MARCA"));
			}
			
		} catch(SQLException e){ 
			throw new RuntimeException(e);
		}
				
		return item;
	}
	**/
}
