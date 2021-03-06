package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.interfacesDao.IRepositorioItemMedicao;
import rnc.sismedicao.model.util.Conexao;

public class ItemMedicaoDAO implements IRepositorioItemMedicao{
	
	
	public ItemMedicaoDAO(IRepositorioItemMedicao repositorioItemMedicao){
		// TODO Auto-generated constructor stub
	}
	
	public int inserir(ItemMedicao itemMedicao, int codItem, int codUnidade) throws  Exception{
				
		String query = "INSERT INTO ITEMMEDICAO(CODITEM, CODUNIDADE, VALORMIN, VALORMAX) VALUES (?, ?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(++i, codItem);
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
	//--------------------------------------------------------
	//METODO PARA INSERIR UM ITEM DE MEDICAO NO BANCO DE DADOS
	//--------------------------------------------------------
	public int inserir(ItemMedicao itemMedicao) throws  Exception{
		
		String query = "INSERT INTO ITEMMEDICAO(CODITEM, CODUNIDADE, DESCRICAO, VALORMIN, VALORMAX) VALUES (?, ?, ?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(++i, itemMedicao.getItem().getCodItem());
				preparedStatement.setString(++i, itemMedicao.getUnidadeDeMedicao().getCodigo());
				preparedStatement.setString(++i, itemMedicao.getUnidadeDeMedicao().getDescricao());
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
	//---------------------------------------------------------
	//METODO PARA REMOVER UM ITEM DE MEDICAO NO BANCO DE DADOS
	//---------------------------------------------------------
	public void remover(int codItemMedicao) throws Exception {

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

	//-------------------------------------------------------------------------------------
	//METODO PARA REMOVER todos os ITEM DE MEDICAO NO BANCO DE DADOS de um determinado item
	//-------------------------------------------------------------------------------------
	public void removerAll(int codItem) throws Exception {

		String sql = "DELETE FROM ITEMMEDICAO WHERE CODITEM = ?";

		try {

			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codItem);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}

	
	//---------------------------------------------------------
	//METODO PARA ATUALIZAR UM ITEM DE MEDICAO NO BANCO DE DADOS
	//---------------------------------------------------------
	public void alterar(ItemMedicao itemMedicao) throws  Exception{
		
		String query = "UPDATE ITEMMEDICAO SET VALORMIN = ?, VALORMAX = ? WHERE CODITEMMEDICAO= ? ";
		
			try {
				int i = 0;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setDouble(++i, itemMedicao.getValorMIN());
				preparedStatement.setDouble(++i, itemMedicao.getValorMAX());
				preparedStatement.setInt(++i, itemMedicao.getCodItemMedicao());
				preparedStatement.execute();
				Conexao.getConnection().commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
//					"Recupera��o com sucesso", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Todos os Itens de Medi��o foram recuperados com sucesso");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return itens;
		
	}
	public ArrayList<ItemMedicao> procura(int codItem){
		
		String query = "SELECT * FROM ITEMMEDICAO WHERE CODITEM=?";

		ArrayList<ItemMedicao> itensMedicao = new ArrayList<ItemMedicao>();

		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, codItem);
			resultSet = preparedStatement.executeQuery();

			Conexao.getConnection().commit();
			while (resultSet.next()){
				ItemMedicao itemMedicao = new ItemMedicao(resultSet.getInt("CODITEMMEDICAO"), resultSet.getString("DESCRICAO"),resultSet.getDouble("VALORMIN"),resultSet.getDouble("VALORMAX") );
				itensMedicao.add(itemMedicao);
			}
			//itensMedicao = carregaList(resultSet);
			
//			JOptionPane.showMessageDialog(null,
//					"Todos os registro foram \nrecuperados com sucesso",
//					"Recupera��o com sucesso", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Todos os Itens de Medi��o foram recuperados com sucesso");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return itensMedicao;
		
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

	@Override
	public ArrayList<ItemMedicao> procurar(int codItem) throws Exception {
		String query = "SELECT * FROM ITEMMEDICAO WHERE CODITEM=?";

		ArrayList<ItemMedicao> itensMedicao = new ArrayList<ItemMedicao>();
		
		int cont = 0;
		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, codItem);
			resultSet = preparedStatement.executeQuery();
			Conexao.getConnection().commit();
			while (resultSet.next()){
				ItemMedicao itemMedicao = new ItemMedicao();
				UnidadeDeMedicao unidadeMedicao = new UnidadeDeMedicao();
				itemMedicao.setCodItemMedicao(resultSet.getInt("CODITEMMEDICAO"));
				itemMedicao.setDescricao(resultSet.getString("DESCRICAO"));
				itemMedicao.setValorMIN(resultSet.getDouble("VALORMIN"));
				itemMedicao.setValorMAX(resultSet.getDouble("VALORMAX"));
				unidadeMedicao.setDescricao(resultSet.getString("DESCRICAO"));
				unidadeMedicao.setCodigo(resultSet.getString("CODUNIDADE"));
				itemMedicao.setUnidadeDeMedicao(unidadeMedicao);
			    //System.out.println(cont+'-'+unidadeMedicao.getDescricao());
				
			    itensMedicao.add(cont, itemMedicao);


			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return itensMedicao;
		// TODO Auto-generated method stub
		//return null;
	}
	
}
