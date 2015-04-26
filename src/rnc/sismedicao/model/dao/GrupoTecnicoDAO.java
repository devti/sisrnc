package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.GrupoTecnico;
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
	 * METODO PARA INSER��O DO REGISTRO DE GRUPO TECNICO
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
}
