package rnc.sismedicao.report;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.util.Conexao;

public class RelListaDeItensMedicao {
	
	public static void listagem() throws JRException{
		
		String query = "SELECT i.NOME as nome, im.CODUNIDADE as unidade, im.VALORMIN as minima,im.VALORMAX as maxima FROM ITEMMEDICAO AS im LEFT JOIN ITEM AS i ON im.CODITEM=i.CODITEM";


		try {
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			JRResultSetDataSource relatResult = new JRResultSetDataSource(resultSet);
			JasperPrint jpPrint = JasperFillManager.fillReport("ireport/ListagemItemMedicao.jasper", new HashMap(), relatResult);
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.toFront();
			System.out.println("ok rel");
			Conexao.getConnection().commit();
			
			System.out.println("Todos os Itens de Medi��o foram recuperados com sucesso");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (JRException ex){
			System.out.println("Erro: " + ex);
		}

	}
	
}
