package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.util.Conexao;

public class EquipamentoDAO {
	
	
	public EquipamentoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertEquipamento(Equipamento equipamento, int codLocal, int codItem){
		
		if(JOptionPane.showConfirmDialog(null, "tem certeza que quer cadastrar este equipamento?"
										 , "Confirmar cadastro"
										 , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
			
		String query = "INSERT INTO EQUIPAMENTO(CODLOCAL, CODITEM, CODCLIENTE, REGISTRO, DESCRICAO) VALUES (?, ?, ?, ?, ?) ";
		
			try {
				int i = 0;
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(++i, codLocal);
				preparedStatement.setInt(++i, codItem);
				preparedStatement.setString(++i, equipamento.getCodCliente());
				preparedStatement.setString(++i, equipamento.getRegistro());
				preparedStatement.setString(++i, equipamento.getDescricao());
				
				preparedStatement.execute();
				
				Conexao.getConnection().commit();
				
				resultSet = preparedStatement.getGeneratedKeys();
				
				if(resultSet.next()){
					equipamento.setCodEquipamento(resultSet.getInt(1));
				}
				
				JOptionPane.showMessageDialog(null, "Equipamento criado com sucesso", "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	return equipamento.getCodEquipamento();
	}
	
	public void removerEquipamento (int codEquipamento) throws Exception {
		
		String sql = "DELETE FROM EQUIPAMENTO WHERE CODEQUIPAMETNTO = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codEquipamento);
			ps.execute();
			Conexao.getConnection().commit();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
	}
	
	public Equipamento procurar (int codEquipamento, int codLocal, int codItem) throws Exception {
		Equipamento equipamento = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EQUIPAMENTO WHERE CODEQUIPAMENTO = ?";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, codEquipamento);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new EquipamentoNaoEncontrandoException(codEquipamento);
			equipamento = new Equipamento();
			equipamento.setCodEquipamento(rs.getInt("codEquipamento"));
		} catch (SQLException e) {
			throw new RepositorioException(e);
		}
		
		return equipamento;
	}
	
}
