package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.OrdemServico;
import rnc.sismedicao.model.interfacesDao.IRepositorioOrdemServico;
import rnc.sismedicao.model.util.Conexao;

public class OrdemServicoDAO implements IRepositorioOrdemServico {
	
	public OrdemServicoDAO(
			IRepositorioOrdemServico repositorioOrdemServico) {

	}
	public void inserir(OrdemServico ordemServico) throws Exception {
		String query = "INSERT INTO ORDEMSERVICO (codigoPlanoMedicao,codigoGrupoTecnico, codigoEquipamento,"
				+ " data, hora,  DATACRIACAO) VALUES (?,?,?,?,?, getdate())";
		try {
			int i = 0;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query,
							PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(++i, ordemServico.getCodigoPlanoMedicao());
			preparedStatement.setInt(++i, ordemServico.getGrupoTecnico()
					.getCodigo());
			preparedStatement.setInt(++i, ordemServico.getEquipamento()
					.getCodEquipamento());
			preparedStatement.setString(++i, ordemServico.getData());
			preparedStatement.setString(++i, ordemServico.getHora());
			preparedStatement.executeUpdate();
			Conexao.getConnection().commit();
			resultSet = preparedStatement.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<OrdemServico> listarOS() throws SQLException, RepositorioException {
		ArrayList<OrdemServico> ordens = new ArrayList<OrdemServico>();
		ResultSet rs = null;
		String sql = "SELECT * FROM ORDEMSERVICO";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				OrdemServico os = new OrdemServico();
				ordens.add(os);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return ordens;
	}
}
