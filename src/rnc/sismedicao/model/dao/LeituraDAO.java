package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rnc.sismedicao.model.beans.OrdemServico;
import rnc.sismedicao.model.interfacesDao.ILeituraDAO;
import rnc.sismedicao.model.util.Conexao;

public class LeituraDAO implements ILeituraDAO {

	public LeituraDAO(ILeituraDAO repositorioLeitura) {
		
	}

	@Override
	public void inserir(OrdemServico os) throws Exception {
		String sql = "INSERT INTO LEITURAOS ()";
		try {
			int i = 0;
			ResultSet rs = null;
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, os.getCodigo());
			rs = ps.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
