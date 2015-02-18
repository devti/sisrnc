package rnc.sismedicao.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return equipamento.getCodEquipamento();
	}
	
}
