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
	
	public void cadastrar (GrupoTecnico grupoTecnico) throws Exception{
		repositorioGrupoTecnico.inserir(grupoTecnico);
	}

}