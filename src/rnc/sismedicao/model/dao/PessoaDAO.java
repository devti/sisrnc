package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.interfacesDao.IRepositorioPessoa;
import rnc.sismedicao.model.util.Conexao;

public class PessoaDAO implements IRepositorioPessoa {

	public PessoaDAO() {
		
	}

	public int insertPessoa(Pessoa pessoa) {

		if (JOptionPane.showConfirmDialog(null,
				"tem certeza que quer cadastrar a pessoa: " + pessoa.getNome()
						+ "?", "Confirmação de cadastro",
				JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

			String query = "INSERT INTO PESSOA(NOME, CPF, EMAIL, TELEFONE) VALUES (?, ?, ?, ?) ";

			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection()
						.prepareStatement(query,
								PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(++i, pessoa.getNome());
				preparedStatement.setString(++i, pessoa.getCpf());
				preparedStatement.setString(++i, pessoa.getEmail());
				preparedStatement.setString(++i, pessoa.getTelefone());

				preparedStatement.executeUpdate();

				Conexao.getConnection().commit();

				JOptionPane.showMessageDialog(null,
						"Pessoa: " + pessoa.getNome()
								+ " cadastrado com sucesso",
						"Cadastrado com sucesso",
						JOptionPane.INFORMATION_MESSAGE);

				resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {
					pessoa.setCodPessoa(resultSet.getInt(1));

				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao tentar incluir uma pessoa no Banco de Dados",
						"Erro", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}
		return pessoa.getCodPessoa();

	}

	public void removerPessoa(int codPessoa) throws Exception {

		String sql = "DELETE FROM PESSOA WHERE CODPESSOA = ?";

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

	public Pessoa procurar(int codPessoa) throws Exception {
		Pessoa pessoa = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USUARIO WHERE CODPESSOA = ?";

		try {
			PreparedStatement ps = Conexao.getConnection()
					.prepareStatement(sql);
			ps.setInt(1, codPessoa);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new PessoaNaoEncontradaException(codPessoa);
			pessoa = new Pessoa(rs.getString("NOME"), rs.getString("CPF"),
					rs.getString("EMAIL"), rs.getString("TELEFONE"));
			pessoa.setCodPessoa(rs.getInt("codPessoa"));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}

		return pessoa;
	}

}
