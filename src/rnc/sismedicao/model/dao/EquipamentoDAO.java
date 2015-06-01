package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.interfacesDao.IRepositorioEquipamento;
import rnc.sismedicao.model.util.Conexao;

public class EquipamentoDAO implements IRepositorioEquipamento {

	public EquipamentoDAO(IRepositorioEquipamento repositorio) throws Exception {

	}

	public int insertEquipamento(Equipamento equipamento) throws Exception {

		String query = "INSERT INTO EQUIPAMENTO(REGISTRO, DESCRICAO, OBSERVACOES) VALUES (?, ?, ?) ";

		int id = 0;
		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query);
			preparedStatement.setString(1, equipamento.getRegistro());
			preparedStatement.setString(2, equipamento.getDescricao());
			preparedStatement.setString(3, equipamento.getObs());
			preparedStatement.execute();
			
			id = consultarUltimoCodigoEquipamento();
			equipamento.setCodEquipamento(id);
			inserirEquipamentoItem(equipamento);

			Conexao.getConnection().commit();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	public int inserirEquipamentoItem(Equipamento equipamento) throws Exception {
		try {
			PreparedStatement ps = null;
			for (int j = 0; j < equipamento.getItens().size(); j++) {
				String sql = "INSERT INTO EQUIPAMENTOITEM(CODEQUIPAMENTO, CODITEM) VALUES (?, ?)";

				ps = Conexao.getConnection()
						.prepareStatement(sql);
				ps.setInt(1, equipamento.getCodEquipamento());
				ps.setInt(2, equipamento.getItens().get(j).getCodItem());
				ps.execute();
			}

		Conexao.getConnection().commit();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void removerEquipamento(int codEquipamento) throws Exception {

		String sql = "DELETE FROM EQUIPAMENTO WHERE CODEQUIPAMENTO = ?";

		try {
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codEquipamento);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}

	@Override
	public void removerEquipamentoItem(int codigoEquipamento) throws Exception {

		String sql = "DELETE FROM EQUIPAMENTOITEM WHERE CODEQUIPAMENTO = ?";

		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(
					sql);
			stmt.setInt(1, codigoEquipamento);
			stmt.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}

	}

	public Equipamento procurar(int codEquipamento)
			throws EquipamentoNaoEncontrandoException, SQLException,
			RepositorioException {
		Equipamento equipamento = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EQUIPAMENTO WHERE CODEQUIPAMENTO = ?";
		try {
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codEquipamento);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new EquipamentoNaoEncontrandoException(codEquipamento);
			equipamento = new Equipamento(rs.getInt("CODEQUIPAMENTO"),
					rs.getString("REGISTRO"), rs.getString("DESCRICAO"),
					rs.getString("OBSERVACOES"));
			equipamento.setItens(listarItemEquipamento(codEquipamento));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}

		return equipamento;
	}

	@Override
	public ArrayList<Equipamento> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException {
		ArrayList<Equipamento> pesq = new ArrayList<Equipamento>();
		ResultSet rs = null;
		String sql = "SELECT * FROM EQUIPAMENTO WHERE EQUIPAMENTO." + atributo
				+ " LIKE '%" + pesquisa + "%'";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(
					sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Equipamento equipamento = new Equipamento(
						rs.getInt("CODEQUIPAMENTO"), rs.getString("REGISTRO"),
						rs.getString("DESCRICAO"), rs.getString("OBSERVACOES"));
				pesq.add(equipamento);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}

	@Override
	public int consultarUltimoCodigoEquipamento() throws Exception {
		int codigo = 0;
		ResultSet rs = null;
		String sql = "SELECT TOP(1) CODEQUIPAMENTO FROM EQUIPAMENTO ORDER BY CODEQUIPAMENTO DESC";
		try {
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				codigo = rs.getInt("CODEQUIPAMENTO");
			}
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return codigo;
	}

	public ArrayList<Item> listarItemEquipamento(int id) throws SQLException,
			RepositorioException {
		ArrayList<Item> itens = new ArrayList<Item>();
		ResultSet rs = null;
		String sql = "SELECT ITEM.CODITEM, ITEM.NOME, ITEM.SERIAL, ITEM.DESCRICAO, ITEM.MARCA FROM ITEM, EQUIPAMENTO, EQUIPAMENTOITEM WHERE"
				+ " EQUIPAMENTO.CODEQUIPAMENTO = EQUIPAMENTOITEM.CODEQUIPAMENTO AND "
				+ "EQUIPAMENTOITEM.CODITEM = ITEM.CODITEM AND EQUIPAMENTO.CODEQUIPAMENTO = ?";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(
					sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("CODITEM"),
						rs.getString("NOME"), rs.getString("MARCA"),
						rs.getString("SERIAL"), rs.getString("DESCRICAO"));
				itens.add(item);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return itens;
	}

	@Override
	public void atualizarEquipamento(Equipamento equipamento) {

	}

}
