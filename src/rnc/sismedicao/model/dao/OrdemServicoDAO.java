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

	public OrdemServicoDAO(IRepositorioOrdemServico repositorioOrdemServico) {

	}

	public void inserir(OrdemServico ordemServico) throws Exception {
		String query = "INSERT INTO ORDEMSERVICO (codigoPlanoMedicao,codigoGrupoTecnico, codigoEquipamento, data, hora,  DATACRIACAO) VALUES (?,?,?,?,?, getdate())";
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

	/*
	 * Excluir ordem de servico
	 */
	public void removerOrdemServico(int codigoPlanoDeMedicao) throws Exception {

		String sql = "DELETE FROM ORDEMSERVICO WHERE CODIGOPLANOMEDICAO = ?";

		try {

			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codigoPlanoDeMedicao);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}

	@Override
	public ArrayList<OrdemServico> listarOS(int[] codigosGruposTecnicos) throws SQLException,
			RepositorioException {
		int[] codigoGTs = codigosGruposTecnicos;
		ArrayList<OrdemServico> ordens = new ArrayList<OrdemServico>();
		ResultSet rs = null;
		String sql = "SELECT * FROM ORDEMSERVICO AS o WHERE CONVERT (date, o.[DATA]) = CONVERT (date, GETDATE()) and codigoGrupoTecnico = ?";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			for (int i = 0; i < codigoGTs.length; i++) {
				if (codigoGTs[i] != 0) {
					stmt.setInt(1, codigosGruposTecnicos[i]);
					rs = stmt.executeQuery();
					while (rs.next()) {

						OrdemServico ordem = new OrdemServico(
								rs.getInt("CODIGO"),
								rs.getInt("CODIGOGRUPOTECNICO"),
								rs.getInt("CODIGOEQUIPAMENTO"),
								rs.getString("DATA"), rs.getString("HORA"));
						ordem.setCodigo(rs.getInt("CODIGO"));
						ordens.add(ordem);

					}
				}
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		
		return ordens;
	}}
