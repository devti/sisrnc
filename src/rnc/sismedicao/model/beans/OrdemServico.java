package rnc.sismedicao.model.beans;

import java.util.Date;

public class OrdemServico {
	
	private int codigo;
	private int codigoGrupoTecnico;
	private int codigoEquipamento;
	private String dataCriacao;
	private String dataAlteracao;
	private String data;
	private String hora;
	private Usuario usuario;
	
	public OrdemServico() {
	
	}
	

	public OrdemServico(int codigoGrupoTecnico, int codigoEquipamento,
			String data, String hora) {
		this.codigoGrupoTecnico = codigoGrupoTecnico;
		this.codigoEquipamento = codigoEquipamento;
		this.data = data;
		this.hora = hora;
	}


	public OrdemServico(int codigo, int codigoGrupoTecnico,
			int codigoEquipamento, String dataCriacao, String dataAlteracao,
			String data, String hora, Usuario usuario) {
		this.codigo = codigo;
		this.codigoGrupoTecnico = codigoGrupoTecnico;
		this.codigoEquipamento = codigoEquipamento;
		this.dataCriacao = dataCriacao;
		this.dataAlteracao = dataAlteracao;
		this.data = data;
		this.hora = hora;
		this.usuario = usuario;
	}


	public int getCodOS() {
		return codigo;
	}
	public void setCodOS(int codOS) {
		this.codigo = codOS;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
