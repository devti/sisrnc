package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.LocalNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Local;
import rnc.sismedicao.model.util.Conexao;

public class LocalDAO {

	public LocalDAO() {
		
	}

	public int insertLocal(Local local, int codEndereco) throws Exception {

		if (JOptionPane.showConfirmDialog(null,
				"Tem certeza que quer cadastrar este local?",
				"Confirmar cadastro", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

			String query = "INSERT INTO LOCAL(CODENDERECO, TIPO, DESCRICAO, CODFILIAL) VALUES (?, ?, ?, ?) ";

			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection()
						.prepareStatement(query,
								PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(++i, codEndereco);
				preparedStatement.setString(++i, local.getTipo());
				preparedStatement.setString(++i, local.getDescricao());
				preparedStatement.setInt(++i, local.getCodFilial());

				preparedStatement.execute();

				Conexao.getConnection().commit();

				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					local.setCodLocal(resultSet.getInt(1));
				}

				JOptionPane.showMessageDialog(null,
						"Item cadastrado com sucesso",
						"Cadastrado com sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return local.getCodLocal();
	}

	public void removerLocal(int codLocal) throws Exception {
		
		String sql = "DELETE FROM LOCAL WHERE CODLOCAL = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codLocal);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}
	
	public Local procurar (int codLocal) throws Exception, LocalNaoEncontradoException {
		Local local = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM LOCAL WHERE CODLOCAL = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codLocal);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new LocalNaoEncontradoException(codLocal);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		
		return local;
	}

}
