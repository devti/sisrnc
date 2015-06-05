package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.FalhaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Falha;
import rnc.sismedicao.model.interfacesDao.IRepositorioFalha;
import rnc.sismedicao.model.util.Conexao;

public class FalhaDAO implements IRepositorioFalha {

	public FalhaDAO(IRepositorioFalha repositorioFalha) {
		
	}

	@Override
	public int cadastrar(Falha falha) throws RepositorioException, SQLException {
		int id = 0;
		try {
			String sql = "INSERT INTO FALHA () VALUES ()";
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setString(1, falha.getDataFalha());
			ps.setString(2, falha.getHoraFalha());
			ps.setString(3, falha.getHoraFalha());
			ps.setString(4, falha.getImpactoFalha());
			ps.setString(5, falha.getProblema());
			ps.setString(6, falha.getResponsavel());
			ps.setString(7, falha.getSolucao());
			ps.execute();
			
			falha.setId(id);
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void remover(int id) throws RepositorioException, SQLException {
		try {
			String sql = "DELETE FROM FALHA WHERE CODFALHA = ?";
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		
	}

	@Override
	public Falha procurar(int id) throws RepositorioException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Falha falha) throws RepositorioException,
			SQLException, Exception {
		if (falha != null) {
			try {
				String sql = "UPDATE FALHA SET";
				PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
				stmt.setString(1, falha.getDataFalha());
				stmt.setString(2, falha.getHoraFalha());
				stmt.setString(3, falha.getHoraFalha());
				stmt.setString(4, falha.getImpactoFalha());
				stmt.setString(5, falha.getProblema());
				stmt.setString(6, falha.getResponsavel());
				stmt.setString(7, falha.getSolucao());
				stmt.setInt(8, falha.getId());
				Integer resultado = stmt.executeUpdate();
				if (resultado == 0)
					throw new FalhaNaoEncontradaException(falha.getId());
			} catch (SQLException e) {
				throw new RepositorioException(e);
			}
		}
		
	}

	@Override
	public ArrayList<Falha> listar() throws SQLException, RepositorioException {
		ArrayList<Falha> falhas = new ArrayList<Falha>();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM FALHA";
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Falha falha = new Falha(rs.getString("RESPONSAVEL"), rs.getString("PROBLEMA"), rs.getString("SOLUCAO")
						, rs.getString("IMPACTOFALHA"), rs.getString("HORAFALHA"),
						rs.getString("DATAFALHA"));
				falha.setId(rs.getInt("ID"));
				falhas.add(falha);
			}
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return null;
	}
}
