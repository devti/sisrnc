package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.model.beans.Usuario;

public interface IRepositorioGrupoTecnicoUsuario {

	public void inserir(int codigoGrupoTecnico, int codigoUsuairo)
			throws Exception;
	
	public void removerAll(int codigoGrupoTecnico) throws Exception;
	
	public void remover(int codigoUsuario) throws Exception;
	
	public ArrayList<Usuario> procurarGrupoTecnicoUsuarios(int codigoGrupoTecnico)
			throws SQLException;
	
	public int[] consultarGrupoTecnico(int codigoUsuario) throws Exception;
}
