package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.interfacesDao.IRepositorioUsuario;
import rnc.sismedicao.model.util.Conexao;

public class UsuarioDAO implements IRepositorioUsuario {

	public UsuarioDAO(IRepositorioUsuario repositorioUsuario) {

	}

	public int inserir(Usuario usuario) throws Exception {

			String query = "INSERT INTO USUARIO(CODPESSOA, LOGIN, SENHA) VALUES (?, ?, ?) ";

			try {
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection()
						.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, usuario.getCodPessoa());
				preparedStatement.setString(2, usuario.getLogin());
				preparedStatement.setString(3, usuario.getSenha());
				preparedStatement.executeUpdate();
				Conexao.getConnection().commit();

				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					usuario.setCodUsuario(resultSet.getInt(1));
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		return usuario.getCodUsuario();

	}

	public void removerUsuario(int codPessoa) throws RepositorioException, SQLException {
		String sql = "DELETE FROM USUARIO WHERE CODPESSOA = ?";

		try {

			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codPessoa);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}

	public Usuario procurar(int codPessoa) throws UsuarioNaoEncontradoException, SQLException,
			RepositorioException {
		Usuario usuario = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USUARIO WHERE CODPESSOA = ?";

		try {
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codPessoa);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new UsuarioNaoEncontradoException(codPessoa);
			usuario = new Usuario(rs.getString("LOGIN"),
					rs.getString("SENHA"));
			usuario.setCodPessoa(rs.getInt("codPessoa"));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return usuario;

	}

	@Override
	public boolean login(String usuario, String senha)
			throws SenhaInvalidaException, RepositorioException, SQLException {
		ResultSet rs;
		try {
			String sql = "SELECT * FROM USUARIO USUARIO WHERE LOGIN = ? AND SENHA = ?";
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			throw new RepositorioException(e);

		}
	}

	@Override
	public ArrayList<Usuario> listar() throws SQLException, RepositorioException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet rs = null;
		String sql = "SELECT * FROM USUARIO";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getString("LOGIN"),
						rs.getString("SENHA"));
				usuario.setCodPessoa(rs.getInt("CODPESSOA"));
				usuario.setCodUsuario(rs.getInt("CODUSUARIO"));
				usuarios.add(usuario);
			} 
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return usuarios;
	}

	@Override
	public ArrayList<Usuario> pesquisaAvancada(String atributo, String pesquisa)
			throws SQLException {
		ArrayList<Usuario> pesq = new ArrayList<Usuario>();
		ResultSet rs = null;
		String sql = "SELECT * FROM USUARIO WHERE USUARIO."+atributo+" LIKE '%" + pesquisa + "%'";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getString("LOGIN"),
						rs.getString("SENHA"));
				usuario.setCodPessoa(rs.getInt("CODPESSOA"));
				usuario.setCodUsuario(rs.getInt("CODUSUARIO"));
				pesq.add(usuario);
			} 
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}
}
