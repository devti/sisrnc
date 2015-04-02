package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.controller.UnidadeDeMedicaoController;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.UnidadeDeMedicaoNaoEncontradaException;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.interfacesDao.IRepositorioUnidadeDeMedicao;
import rnc.sismedicao.model.util.Conexao;

public class UnidadeDeMedicaoDAO implements IRepositorioUnidadeDeMedicao {

	public UnidadeDeMedicaoDAO(IRepositorioUnidadeDeMedicao repositorio) throws Exception {

	}

	public String inserir(UnidadeDeMedicao unidadeDeMedicao) throws Exception {

		String query = "INSERT INTO UNIDADEMEDICAO(CODUNIDADE, DESCRICAO) VALUES (?, ?) ";

		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query,
							PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, unidadeDeMedicao.getCodigo());
			preparedStatement.setString(2, unidadeDeMedicao.getDescricao());
			preparedStatement.executeUpdate();
			Conexao.getConnection().commit();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return unidadeDeMedicao.getCodigo();
	}

	public void update(UnidadeDeMedicao unidadeDeMedicao) {

		String query = "UPDATE UNIDADEMEDICAO SET CODUNIDADE = ?, DESCRICAO = ? WHERE CODUNIDADE = ?";

		try {
			int i = 0;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query);

			preparedStatement.setString(++i, unidadeDeMedicao.getCodigo());
			preparedStatement.setString(++i, unidadeDeMedicao.getCodigo());

			preparedStatement.executeQuery();

			Conexao.getConnection().commit();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso",
					"Atualização com sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<UnidadeDeMedicao> ListAll() {
		String query = "SELECT * FROM UNIDADEMEDICAO";

		List<UnidadeDeMedicao> unidadesDeMedicao = new ArrayList<UnidadeDeMedicao>();

		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			Conexao.getConnection().commit();

			while (resultSet.next()) {
				UnidadeDeMedicao unidadeDeMedicao = new UnidadeDeMedicao();
				unidadeDeMedicao.setCodigo(resultSet.getString(1));
				unidadeDeMedicao.setDescricao(resultSet.getString(2));

				unidadesDeMedicao.add(unidadeDeMedicao);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return unidadesDeMedicao;
	}

	public void searchRealTime(int opcao, String pesquisa,
			DefaultTableModel modelo) {
		String campo;

		switch (opcao) {
		case UnidadeDeMedicaoController.PESQUISAR_CODIGO:
			campo = "CODUNIDADE";
			break;
		case UnidadeDeMedicaoController.PESQUISAR_NOME:
			campo = "DESCRICAO";
			break;
		default:
			throw new RuntimeException("Opção inválida");
		}

		String query = "SELECT * FROM UNIDADEMEDICAO WHERE " + campo
				+ " LIKE '%" + pesquisa + "%';";

		ResultSet resultSet = null;

		try {

			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				modelo.addRow(new Object[] { resultSet.getString("CODUNIDADE"),
						resultSet.getString("DESCRICAO") });
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public UnidadeDeMedicao getUnidadeDeMedicao(String codUnidadeDeMedicao) {

		return null;
	}


	@Override
	public void removerUnidadeDeMedicao(String codUnidade)
			throws RepositorioException, SQLException {
		
		
	}

	@Override
	public UnidadeDeMedicao procurar(String codUnidade) throws UnidadeDeMedicaoNaoEncontradaException, SQLException,
			RepositorioException  {
		UnidadeDeMedicao unidade = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM UNIDADEMEDICAO WHERE CODUNIDADE = ?";
		
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			stmt.setString(1, codUnidade);
			rs = stmt.executeQuery();
			if (!rs.next()) 
				throw new UnidadeDeMedicaoNaoEncontradaException(codUnidade);
			unidade = new UnidadeDeMedicao(rs.getString("CODUNIDADE"), 
					rs.getString("DESCRICAO"));
			
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return unidade;
	}
	
	public ArrayList<UnidadeDeMedicao> listar() throws SQLException, RepositorioException {
		ArrayList<UnidadeDeMedicao> unidades = new ArrayList<UnidadeDeMedicao>();
		ResultSet rs = null;
		String sql = "SELECT * FROM UNIDADEMEDICAO";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UnidadeDeMedicao medicao = new UnidadeDeMedicao(rs.getString("CODUNIDADE"), 
						rs.getString("DESCRICAO"));
				unidades.add(medicao);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return unidades;
		
	}

	@Override
	public ArrayList<UnidadeDeMedicao> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException {
		ArrayList<UnidadeDeMedicao> pesq = new ArrayList<UnidadeDeMedicao>();
		ResultSet rs = null;
		String sql = "SELECT * FROM UNIDADEMEDICAO WHERE UNIDADEMEDICAO."+atributo+" LIKE '%" + pesquisa +"%'";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UnidadeDeMedicao unidadeMedicao = new UnidadeDeMedicao(rs.getString("CODUNIDADE"), 
						rs.getString("DESCRICAO"));
				pesq.add(unidadeMedicao);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}

}
