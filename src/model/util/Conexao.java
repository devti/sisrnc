package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
	
	private String URL = "jdbc:sqlserver://localhost:1433;databaseName=SisMedicao";
	private String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String usuario = "SisMedicao";
	private String senha = "#SisRNC#";
	private static Connection connection;
	
	private Conexao() {
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(URL, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectado com sucesso ao Banco de Dados", "Sucesso ao conectar ao Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar conectar ao Banco de Dados", "Erro ao conectar ao Banco de Dados", JOptionPane.ERROR_MESSAGE);
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
	
	public static void main(String[] args) {
		Conexao.getConnection();
	}
	
	
}
