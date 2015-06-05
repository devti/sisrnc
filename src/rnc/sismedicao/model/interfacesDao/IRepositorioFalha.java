package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.model.beans.Falha;

public interface IRepositorioFalha {
	
	public int cadastrar(Falha falha) throws RepositorioException, SQLException;
	
	public void remover(int id) throws RepositorioException, SQLException;
	
	public Falha procurar(int id) throws RepositorioException, SQLException;
	
	public void atualizar (Falha falha) throws RepositorioException, SQLException, Exception;
	
	public ArrayList<Falha> listar() throws SQLException, RepositorioException;

}
