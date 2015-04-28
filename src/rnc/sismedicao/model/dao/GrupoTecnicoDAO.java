package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.GrupoTecnico;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.interfacesDao.IRepositorioGrupoTecnico;
import rnc.sismedicao.model.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoTecnicoDAO implements IRepositorioGrupoTecnico {
 
	public GrupoTecnicoDAO(IRepositorioGrupoTecnico repositorioGrupoTecnico){
		
	}
	
	/**
	 * METODO PARA INSERÇÃO DO REGISTRO DE GRUPO TECNICO
	 */
	public int inserir (GrupoTecnico grupoTecnico) throws Exception{
		String query = "INSERT INTO grupotecnico (nome, localizacao, observacao, dtcriacao) VALUES (?, ?, ?, GETDATE())";
		try{
			int i = 0;
			ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection()
						.prepareStatement(query,
								PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, grupoTecnico.getNomeGrupoTecnico());
				preparedStatement.setString(++i, grupoTecnico.getLocalizacao());
				preparedStatement.setString(++i, grupoTecnico.getObservacao());
				preparedStatement.executeUpdate();
				Conexao.getConnection().commit();
				resultSet = preparedStatement.getGeneratedKeys();

		}catch (SQLException e){
			
			e.printStackTrace();	
		}
		return grupoTecnico.getCodigoGrupoTecnico();
		
	}
	/**
	 *  Metodo para retorna o ultimo codigo do Grupo Tecnico cadastrado
	 */
	public int consultarUltimoCodigoGrupoTecnico() throws Exception{
		int codigo = 0;
		ResultSet result = null;
		String sql = "SELECT TOP(1) CODIGO FROM GRUPOTECNICO ORDER BY CODIGO DESC";
		try{
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			result = ps.executeQuery();
			while (result.next()){
				codigo = result.getInt("CODIGO");
			}
		}catch (SQLException e){
			throw new RepositorioException(e);
		}
		return codigo;
	}
	
	/**
	 * METODO QUE REALIZA A PESQUISA AVANCADA NA TELA DE PROCURAR GRUPO TECNICO
	 */
	
	public ArrayList<GrupoTecnico> pesquisaAvancada(String atributo, String pesquisa) throws SQLException{
		ArrayList<GrupoTecnico> pesq = new ArrayList<GrupoTecnico>();
		ResultSet rs= null;
		String sql = "SELECT * FROM grupotecnico as gt WHERE gt." + atributo + " LIKE '%"
				+ pesquisa + "%' ORDER BY CODITEM, NOME ASC";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(
					sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				GrupoTecnico gt = new GrupoTecnico(rs.getInt("CODIGO"),rs.getString("NOME"),
						rs.getString("LOCALIZACAO"), rs.getString("OBSERVACAO"));
				pesq.add(gt);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}
}
