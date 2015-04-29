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
	/**
	 * metodo para inserir grupoTecnico
	 */
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
			System.out.println("Salvo" + codigoUsuairo);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	/**
	 *  Metodo para gerar um ArrayList de GrupoTecnico de Usuarios
	 */
	public ArrayList<Usuario> procurarGrupoTecnicoUsuarios(int codigoGrupoTecnico)
			throws SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT u.codusuario codUsuario, u.CODPESSOA codPessoa, u.LOGIN Login, p.nome nome FROM   GrupoTecnicoUsuarios  AS gtu LEFT JOIN USUARIO     AS u  ON  gtu.codigoUsuario = u.CODUSUARIO LEFT JOIN PESSOA AS p ON u.CODPESSOA = p.CODPESSOA WHERE  gtu.codigoGrupoTecnico = ?";
		
		try {
			ResultSet rs = null;
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codigoGrupoTecnico);
			rs = ps.executeQuery();
			Conexao.getConnection().commit();
			while (rs.next()){
				Usuario u = new Usuario(rs.getString("NOME"),rs.getString("LOGIN"), rs.getInt("CODPESSOA"), rs.getInt("CODUSUARIO"));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return usuarios;
	}
	
}
