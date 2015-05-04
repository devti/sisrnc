package rnc.sismedicao.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 * Classe utilitária para efetuar a conexão com o Banco de Dados MS SQL Server
 * @author Charles Arruda
 * @version 1.0
 */

public class Conexao {
	
	//private String servidor = "localhost";
	private String servidor = "ABSERVER35";
	private String bancoDeDados = "SisMedicao";
	
	private String URL = "jdbc:sqlserver://"+ servidor +":1433;databaseName="+ bancoDeDados;
	private String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private String usuario = "SisMedicao";
	private String senha = "#SisMed#";
	private static Connection connection;
	
	/**
	 * Construtor que efetua a conexão retornando sucesso ou falha
	 * @author Charles Arruda
	 */
	private Conexao() {
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(URL, usuario, senha);
			connection.setAutoCommit(false);
			//JOptionPane.showMessageDialog(null, "Conectado com sucesso ao Banco de Dados", "Sucesso ao conectar ao Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Conexão com o Banco de Dados efetuado com Sucesso.");
		} catch (ClassNotFoundException | SQLException e) {
			//JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar conectar ao Banco de Dados", "Erro ao conectar ao Banco de Dados", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao conectar ao Banco de Dados", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		if(connection == null){
			new Conexao();
		}
		return connection;
	}
	
	public static void closeConnection(){
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		Conexao.getConnection();
//	}
	
	
}