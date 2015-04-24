package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	//--------------------------------------------------
	//METODO PARA INSERÇÃO DO REGISTRO DE GRUPO TECNICO
	//--------------------------------------------------
	public void inserir (GrupoTecnico grupoTecnico) throws Exception{
		String query = "INSERT INTO GRUPOTECNICO(NOME, LOCALIZACAO, OBSERVACAO) VALUES (?,?,?)";
		
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
		
	}
	
	
}
