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

	public void inserir(PlanoDeMedicao planoDeMedicao) throws Exception {
		String query = "INSERT INTO PLANOMEDICAO (codigoGrupoMedicao, codigoEquipamento, DATA_INICIO, DATA_FIM, horario, Dia_Semana, Dia_Mes, STATUS, DATA_CRIACAO) VALUES (?,?,?,?,?,?,?, getdate())";
		try {
			int i = 0;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection()
					.prepareStatement(query,
							PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(++i, planoDeMedicao.getGrupoTecnico()
					.getCodigo());
			preparedStatement.setInt(++i, planoDeMedicao.getEquipamento()
					.getCodEquipamento());
			preparedStatement.setString(++i, planoDeMedicao.getDataInicial());
			preparedStatement.setString(++i, planoDeMedicao.getDataFinal());
			preparedStatement.setString(++i, planoDeMedicao.getHorario());
			preparedStatement.setString(++i, planoDeMedicao.getDiaSemana());
			preparedStatement.setString(++i, planoDeMedicao.getDiaMes());
			preparedStatement.setString(++i, planoDeMedicao.getStatus());
			preparedStatement.executeUpdate();
			Conexao.getConnection().commit();
			resultSet = preparedStatement.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
