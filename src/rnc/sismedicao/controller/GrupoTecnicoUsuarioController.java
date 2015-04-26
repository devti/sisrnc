package rnc.sismedicao.controller;

import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.interfacesDao.*;
import rnc.sismedicao.model.dao.*;

import java.sql.SQLException;
import java.util.ArrayList;

import rnc.sismedicao.controller.exception.*;

public class GrupoTecnicoUsuarioController {
	private IRepositorioGrupoTecnicoUsuario repositorioGrupoTecnicoUsuario;

	/**
	 * 
	 * @param CONTRUTOR
	 *            DA CLASSE
	 */
	public GrupoTecnicoUsuarioController() {
		this.repositorioGrupoTecnicoUsuario = repositorioGrupoTecnicoUsuario;

	}

	/**
	 * CADASTRA O GRUPO TECNICO USUARIOS
	 */
	public void cadastrar(int codigoGrupoTecnico, int codigoUsuario)
			throws Exception {
		repositorioGrupoTecnicoUsuario.inserir(codigoGrupoTecnico,
				codigoUsuario);

	}
}
