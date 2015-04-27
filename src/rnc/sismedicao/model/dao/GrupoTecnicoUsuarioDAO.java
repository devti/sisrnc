package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.GrupoTecnico;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.interfacesDao.IRepositorioGrupoTecnico;
import rnc.sismedicao.model.interfacesDao.IRepositorioGrupoTecnicoUsuario;
import rnc.sismedicao.model.util.Conexao;

public class GrupoTecnicoUsuarioDAO implements IRepositorioGrupoTecnicoUsuario{

	public GrupoTecnicoUsuarioDAO(IRepositorioGrupoTecnicoUsuario repositorioGrupoTecnicoUsuario) throws Exception{
		
	}
	
	public void inserir(int codigoGrupoTecnico, int codigoUsuairo) throws  Exception{
		String query = "INSERT INTO GrupoTecnicoUsuarios (codigoGrupoTecnico, codigoUsuario, dtCriacao) VALUES(?, ?, GETDATE())";
		try{
			int i=0;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(++i, codigoGrupoTecnico);
			preparedStatement.setInt(++i, codigoUsuairo);
			preparedStatement.executeUpdate();
			Conexao.getConnection().commit();
			resultSet = preparedStatement.getGeneratedKeys();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
}
