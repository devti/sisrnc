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

public class PlanoDeMedicaoDAO implements IRepositorioPlanoDeMedicao {

	public PlanoDeMedicaoDAO(
			IRepositorioPlanoDeMedicao repositorioPlanoDeMedicao) {

	}
	/**
	 * INSERIR 
	 */
	public void inserir(PlanoDeMedicao planoDeMedicao) throws Exception {
		String query = "INSERT INTO PLANOMEDICAO (descricao,codigoGrupoTecnico, codigoEquipamento, DATA_INICIO, DATA_FIM, horario, Dia_Semana, Dia_Mes,  DATA_CRIACAO) VALUES (?,?,?,?,?,?,?,?, getdate())";
		try {
			int i = 0;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query,
							PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(++i, planoDeMedicao.getDescricao());
			preparedStatement.setInt(++i, planoDeMedicao.getGrupoTecnico()
					.getCodigo());
			preparedStatement.setInt(++i, planoDeMedicao.getEquipamento()
					.getCodEquipamento());
			preparedStatement.setString(++i, planoDeMedicao.getDataInicial());
			preparedStatement.setString(++i, planoDeMedicao.getDataFinal());
			preparedStatement.setString(++i, planoDeMedicao.getHorario());
			preparedStatement.setString(++i, planoDeMedicao.getDiaSemana());
			preparedStatement.setString(++i, planoDeMedicao.getDiaMes());
			//preparedStatement.setString(++i, planoDeMedicao.getStatus());
			preparedStatement.executeUpdate();
			Conexao.getConnection().commit();
			resultSet = preparedStatement.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * CONSULTA ULTIMO CODIGO DO PLANO DE MANUTENCAO
	 */
	
	public int consultarUltimoCodigoPlanoMedicao() throws Exception {
		int codigo = 0;
		ResultSet result = null;
		String sql = "SELECT TOP(1) codigo FROM planomedicao ORDER BY codigo desc";
		try {
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			result = ps.executeQuery();
			while (result.next()) {
				codigo = result.getInt("CODIGO");
			}
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return codigo;
	}

}
