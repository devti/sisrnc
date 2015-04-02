package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.interfacesDao.IRepositorioPessoa;
import rnc.sismedicao.model.util.Conexao;

public class PessoaDAO implements IRepositorioPessoa {

	public PessoaDAO(IRepositorioPessoa repositorio) throws Exception {

	}

	public int inserir(Pessoa pessoa) {

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

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				pessoa.setCodPessoa(resultSet.getInt(1));

			}

		} catch (SQLException e) {

		}
		return pessoa.getCodPessoa();

	}

	public void removerPessoa(int codPessoa) throws SQLException,
			RepositorioException {

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

	public Pessoa procurar(int codPessoa) throws SQLException,
			PessoaNaoEncontradaException, RepositorioException {
		Pessoa pessoa = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PESSOA WHERE CODPESSOA = ?";

		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
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

	@Override
	public ArrayList<Pessoa> pesquisaAvancada(String atributo, String pesquisa) 
			throws SQLException {
		ArrayList<Pessoa> pesq = new ArrayList<Pessoa>();
		ResultSet rs = null;
		String sql = "SELECT * FROM PESSOA WHERE PESSOA."+atributo+" LIKE '%" + pesquisa + "%'";
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa(rs.getString("NOME"),
						rs.getString("CPF"), rs.getString("EMAIL"), rs.getString("TELEFONE"));
				pessoa.setCodPessoa(rs.getInt("CODPESSOA"));
				pesq.add(pessoa);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return pesq;
	}

	@Override
	public ArrayList<Pessoa> listar() throws SQLException, RepositorioException {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		String sql = "SELET * FROM PESSOA";
		try {
			PreparedStatement stmt  = Conexao.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa (rs.getString("NOME"),
						rs.getString("CPF"), rs.getString("EMAIL"), rs.getString("TELEFONE"));
				pessoa.setCodPessoa(rs.getInt("CODPESSOA"));
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		return pessoas;
	}

}
