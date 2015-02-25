package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.util.Conexao;

public class UsuarioDAO {

	public UsuarioDAO() {

	}

	public int insertUsuario(Usuario usuario) throws Exception {

		if (JOptionPane.showConfirmDialog(
				null,
				"tem certeza que quer cadastrar o usuário: "
						+ usuario.getLogin() + "?", "Confirmação de cadastro",
				JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

			String query = "INSERT INTO USUARIO(LOGIN, SENHA) VALUES (?, ?, ?) ";

			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection()
						.prepareStatement(query);
				preparedStatement.setString(++i, usuario.getLogin());
				preparedStatement.setString(++i, usuario.getSenha());
				preparedStatement.setInt(++i, usuario.getCodPessoa());
				preparedStatement.execute();
				Conexao.getConnection().commit();

				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					usuario.setCodUsuario(resultSet.getInt(1));
				}

				JOptionPane.showMessageDialog(null,
						"Usuário: " + usuario.getLogin()
								+ " cadastrado com sucesso",
						"Cadastrado com sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return usuario.getCodUsuario();

	}

	public void removerUsuario(int codUsuario) throws Exception {
		String query = "DELETE FROM USUARIO WHERE CODUSUARIO = ?";

		try {

			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(query);
			ps.setInt(1, codUsuario);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}
	public Usuario procurar (int codUsuario) throws UsuarioNaoEncontradoException, Exception {
		Usuario usuario = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USUARIO WHERE ID = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codUsuario);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new UsuarioNaoEncontradoException(codUsuario);
			usuario = new Usuario(codUsuario, rs.getString("LOGIN"), rs.getString("SENHA"));
			usuario.setCodUsuario(rs.getInt("codUsuario"));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return usuario;
		
	}
}
