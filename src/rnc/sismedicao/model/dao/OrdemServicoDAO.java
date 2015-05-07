package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.interfacesDao.*;
import rnc.sismedicao.model.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdemServicoDAO implements IRepositorioOrdemServico {
	
	public OrdemServicoDAO(
			IRepositorioOrdemServico repositorioOrdemServico) {

	}
	public void inserir(OrdemServico ordemServico) throws Exception {
		String query = "INSERT INTO ORDEMSERVICO (codigoGrupoTecnico, codigoEquipamento, data, hora,  DATA_CRIACAO) VALUES (?,?,?,?, getdate())";
		try {
			int i = 0;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query,
							PreparedStatement.RETURN_GENERATED_KEYS);
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
}
