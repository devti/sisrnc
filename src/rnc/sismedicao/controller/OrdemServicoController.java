package rnc.sismedicao.controller;

import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.interfacesDao.*;
import rnc.sismedicao.model.dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import rnc.sismedicao.controller.exception.*;

public class OrdemServicoController {
	private IRepositorioOrdemServico repositorioOrdemServico;
	
	public OrdemServicoController(){
		this.repositorioOrdemServico = new OrdemServicoDAO(this.repositorioOrdemServico);
	}
	public void inserir (OrdemServico ordemServico) throws Exception{
		repositorioOrdemServico.inserir(ordemServico);
	}
}
