package rnc.sismedicao.model.interfacesDao;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.model.beans.GrupoTecnico;

public interface  IRepositorioGrupoTecnico {

	public int inserir (GrupoTecnico grupoTecnico) throws Exception;
	
	public int consultarUltimoCodigoGrupoTecnico() throws Exception;
	
	public ArrayList<GrupoTecnico> pesquisaAvancada(String atributo, String pesquisa) throws SQLException;
	
}
