package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.interfacesDao.IRepositorioEquipamento;
import rnc.sismedicao.model.util.Conexao;

public class EquipamentoDAO implements IRepositorioEquipamento {
	
	
	public EquipamentoDAO(IRepositorioEquipamento repositorio) throws Exception {
		
	}
	
	public int insertEquipamento(Equipamento equipamento){
			
		String query = "INSERT INTO EQUIPAMENTO(REGISTRO, DESCRICAO, OBSERVACOES) VALUES (?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement
						(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, equipamento.getRegistro());
				preparedStatement.setString(++i, equipamento.getDescricao());
				preparedStatement.setString(++i, equipamento.getObs());
				preparedStatement.executeUpdate();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					equipamento.setCodEquipamento(resultSet.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	return equipamento.getCodEquipamento();
	}
	
	public void removerEquipamento (int codEquipamento) throws Exception {
		
		String sql = "DELETE FROM EQUIPAMENTO WHERE CODEQUIPAMETNTO = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codEquipamento);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}
	
	public Equipamento procurar (int codEquipamento) throws EquipamentoNaoEncontrandoException, SQLException,
			RepositorioException {
		Equipamento equipamento = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EQUIPAMENTO WHERE CODEQUIPAMENTO = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codEquipamento);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new EquipamentoNaoEncontrandoException(codEquipamento);
			equipamento = new Equipamento(rs.getInt("CODEQUIPAMENTO"), rs.getString("REGISTRO"), rs.getString("DESCRICAO"),
					rs.getString("OBSERVACOES"));
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
		String sql = "SELECT * FROM EQUIPAMENTO WHERE EQUIPAMENTO."+atributo+" LIKE '%" + pesquisa + "%'";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Equipamento equipamento = new Equipamento(rs.getInt("CODEQUIPAMENTO"), rs.getString("REGISTRO"), rs.getString("DESCRICAO"),
						rs.getString("OBSERVACOES"));
				pesq.add(equipamento);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}
	
}
