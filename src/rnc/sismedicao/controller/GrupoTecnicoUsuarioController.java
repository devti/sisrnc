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
	public GrupoTecnicoUsuarioController() throws Exception {
		this.repositorioGrupoTecnicoUsuario = new GrupoTecnicoUsuarioDAO(this.repositorioGrupoTecnicoUsuario);

	}

	/**
	 * CADASTRA O GRUPO TECNICO USUARIOS
	 */
	public void cadastrar(int codigoGrupoTecnico, int codigoUsuario)throws Exception {
		this.repositorioGrupoTecnicoUsuario.inserir(codigoGrupoTecnico, codigoUsuario);

	}
	
	/**
	 * metodo para remover todos os usuario do grupo tecnico
	 * @param codigoGrupoTecnico
	 * @throws Exception
	 */
	public void removerAll(int codigoGrupoTecnico) throws Exception{
		repositorioGrupoTecnicoUsuario.removerAll(codigoGrupoTecnico);
	}
	/**
	 * metodo para remover o usuario especifico do grupo Tecnico
	 * @param codigoUsuario
	 * @throws Exception
	 */
	public void remover(int codigoUsuario) throws Exception{
		repositorioGrupoTecnicoUsuario.remover(codigoUsuario);
	}
	
	/**
	 * metodo que pesquisa um grupo tecnico de usuarios em um arraylist
	 */
	public ArrayList<Usuario> procurarGrupoTecnicoUsuarios(int codigoGrupoTecnico)
			throws SQLException{
		return repositorioGrupoTecnicoUsuario.procurarGrupoTecnicoUsuarios(codigoGrupoTecnico);
	}
	
	public int[] consultarGrupoTecnico(int codigoUsuario) throws Exception{
		return repositorioGrupoTecnicoUsuario.consultarGrupoTecnico(codigoUsuario);
	}
}
