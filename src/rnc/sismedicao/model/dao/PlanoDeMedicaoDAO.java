package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
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
	
	/**
	 * METODO DE PESQUISA AVANCADA
	 */
	public ArrayList<PlanoDeMedicao> pesquisaAvancada(String atributo,
			String pesquisa) throws SQLException {
		ArrayList<PlanoDeMedicao> pesq = new ArrayList<PlanoDeMedicao>();
		ResultSet rs = null;
		String sql = "select * from (select PL.codigo codigoPlanoDeMedicao, pl.descricao descricao, pl.codigoGrupoTecnico codigoGrupoTecnico, pl.codigoEquipamento codigoEquipamento, pl.data_inicio dataInicio, pl.data_fim dataFinal, pl.horario horario, pl.Status statusPlanoDeMedicao, pl.data_Criacao dataDaCriacao, pl.data_Alteracao dataAlteracao, pl.dia_Semana diaDaSemana, pl.Dia_mes diaDoMes, pl.Loginusuario loginUsuariop, e.registro registroEquipamento, e.descricao descricaoEquipamento, e.observacoes observacaoEquipamento, gt.Nome nomeGrupoTecnico, gt.localizacao localizacaoGrupoTecnico, gt.observacao observacaoGrupoTecnico	 FROM planomedicao AS PL LEFT JOIN EQUIPAMENTO AS E ON PL.CODIGOEQUIPAMENTO=E.CODEQUIPAMENTO LEFT JOIN GRUPOTECNICO AS GT ON PL.CODIGOGRUPOTECNICO=GT.CODIGO) as plano where plano."
				+ atributo
				+ " LIKE '%"
				+ pesquisa
				+ "%' ORDER BY descricao ASC";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(
					sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				GrupoTecnico grupoTecnico = new GrupoTecnico(
						Integer.parseInt(rs.getString("codigoGrupoTecnico")),
						rs.getString("nomeGrupoTecnico"),
						rs.getString("observacaoGrupoTecnico"),
						rs.getString("localizacaoGrupoTecnico"));
				Equipamento equipamento = new Equipamento(Integer.parseInt(rs
						.getString("codigoEquipamento")),
						rs.getString("registroEquipamento"),
						rs.getString("descricaoEquipamento"),
						rs.getString("observacaoEquipamento"));
				PlanoDeMedicao planoDeMedicao = new PlanoDeMedicao(
						Integer.parseInt(rs.getString("codigoPlanoDeMedicao")),
						rs.getString("descricao"), grupoTecnico, equipamento,
						rs.getString("dataInicio"), rs.getString("dataFinal"),
						rs.getString("horario"), rs.getString("diaDaSemana"),
						rs.getString("diaDoMes"),
						rs.getString("statusPlanoDeMedicao"),
						rs.getString("dataDaCriacao"),
						rs.getString("dataAlteracao"));
				pesq.add(planoDeMedicao);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}
	
	/**
	 * METODO DE PROCURAR ATRAVES DE UM CODIGO DO PLANO DE MEDICAO
	 */
	public PlanoDeMedicao procurar(int codigo) throws SQLException, RepositorioException {
		GrupoTecnico grupoTecnico = null;
		Equipamento equipamento = null;
		PlanoDeMedicao planoDeMedicao = null;
		ResultSet rs = null;
		String sql = "select * from (select PL.codigo codigoPlanoDeMedicao, pl.descricao descricao, pl.codigoGrupoTecnico codigoGrupoTecnico, pl.codigoEquipamento codigoEquipamento, pl.data_inicio dataInicio, pl.data_fim dataFinal, pl.horario horario, pl.Status statusPlanoDeMedicao, pl.data_Criacao dataDaCriacao, pl.data_Alteracao dataAlteracao, pl.dia_Semana diaDaSemana, pl.Dia_mes diaDoMes, pl.Loginusuario loginUsuariop, e.registro registroEquipamento, e.descricao descricaoEquipamento, e.observacoes observacaoEquipamento, gt.Nome nomeGrupoTecnico, gt.localizacao localizacaoGrupoTecnico, gt.observacao observacaoGrupoTecnico	 FROM planomedicao AS PL LEFT JOIN EQUIPAMENTO AS E ON PL.CODIGOEQUIPAMENTO=E.CODEQUIPAMENTO LEFT JOIN GRUPOTECNICO AS GT ON PL.CODIGOGRUPOTECNICO=GT.CODIGO) as plano where plano.codigoPlanoDeMedicao = "
				+ codigo
				+ "%' ORDER BY descricao ASC";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(
					sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (!rs.next())
				 grupoTecnico = new GrupoTecnico(
						Integer.parseInt(rs.getString("codigoGrupoTecnico")),
						rs.getString("nomeGrupoTecnico"),
						rs.getString("observacaoGrupoTecnico"),
						rs.getString("localizacaoGrupoTecnico"));
				equipamento = new Equipamento(Integer.parseInt(rs
						.getString("codigoEquipamento")),
						rs.getString("registroEquipamento"),
						rs.getString("descricaoEquipamento"),
						rs.getString("observacaoEquipamento"));
				planoDeMedicao = new PlanoDeMedicao(
						Integer.parseInt(rs.getString("codigoPlanoDeMedicao")),
						rs.getString("descricao"), grupoTecnico, equipamento,
						rs.getString("dataInicio"), rs.getString("dataFinal"),
						rs.getString("horario"), rs.getString("diaDaSemana"),
						rs.getString("diaDoMes"),
						rs.getString("statusPlanoDeMedicao"),
						rs.getString("dataDaCriacao"),
						rs.getString("dataAlteracao"));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return planoDeMedicao;
	}
}
