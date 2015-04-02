package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.EnderecoNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Endereco;
import rnc.sismedicao.model.util.Conexao;

public class EnderecoDAO {

	public EnderecoDAO() {

	}

	public int insertEndereco(Endereco endereco) {

			String query = "INSERT INTO ENDERECO( RUA, NUMERO, BAIRRO, CIDADE) VALUES ( ?, ?, ?, ?) ";

			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection()
						.prepareStatement(query,
								PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, endereco.getRua());
				preparedStatement.setInt(++i, endereco.getNumero());
				preparedStatement.setString(++i, endereco.getCidade());

				preparedStatement.execute();

				Conexao.getConnection().commit();

				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					endereco.setCodEndereco(resultSet.getInt(1));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		return endereco.getCodEndereco();
	}

	public void removerEndereco(int codEndereco) throws Exception {

		String sql = "DELETE FROM ENDERECO WHERE CODENDERECO = ?";

		try {

			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codEndereco);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}

	public Endereco procurar (int codEndereco) throws Exception {
		
		Endereco endereco = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ENDERECO WHERE CODENDERECO = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codEndereco);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new EnderecoNaoEncontradoException(codEndereco);
			endereco = new Endereco(rs.getString("RUA"), rs.getString("BAIRRO"), rs.getString("CIDADE"),
					rs.getString("CEP"));
			endereco.setCodEndereco(rs.getInt("codEndereco"));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		
		return endereco;
	}
}
