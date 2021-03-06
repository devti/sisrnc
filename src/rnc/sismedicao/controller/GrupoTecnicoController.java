package rnc.sismedicao.controller;

import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.interfacesDao.*;
import rnc.sismedicao.model.dao.*;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.*;

public class GrupoTecnicoController {
	
	private IRepositorioGrupoTecnico repositorioGrupoTecnico;
	
	public GrupoTecnicoController(){
		this.repositorioGrupoTecnico = new GrupoTecnicoDAO(this.repositorioGrupoTecnico);
	}
	
	public int cadastrar (GrupoTecnico grupoTecnico) throws Exception{
		return repositorioGrupoTecnico.inserir(grupoTecnico);
	}
	
	public void alterar(GrupoTecnico grupoTecnico) throws Exception{
		repositorioGrupoTecnico.alterar(grupoTecnico);
	}
	
	public void remover(int codigoGrupoTecnico) throws Exception{
		repositorioGrupoTecnico.remover(codigoGrupoTecnico);
	}
	
	public int consultarUltimoCodigoGrupoTecnico() throws Exception{
		return repositorioGrupoTecnico.consultarUltimoCodigoGrupoTecnico();
	}
	
	public ArrayList<GrupoTecnico> pesquisaAvancada(String atributo, String pesquisa) throws SQLException{
		return repositorioGrupoTecnico.pesquisaAvancada(atributo, pesquisa);
	}
	
	public GrupoTecnico pesquisa(int codigoGrupoTecnico)  throws SQLException,GrupoTecnicoNaoEncontradoException,RepositorioException{
		return repositorioGrupoTecnico.procurar(codigoGrupoTecnico);
	}

}
