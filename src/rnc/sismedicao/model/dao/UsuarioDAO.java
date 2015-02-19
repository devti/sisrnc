package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return usuario.getCodUsuario();
	}

}
