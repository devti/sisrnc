package rnc.sismedicao.model.beans;

import java.util.Date;

public class OrdemServico {
	
	private int codOS;
	private Date dataAbertura;
	private Usuario usuario;
	
	public OrdemServico() {
	
	}
	public OrdemServico(int codOS, Date dataAbertura, Usuario usuario) {
		this.codOS = codOS;
		this.dataAbertura = dataAbertura;
		this.usuario = usuario;
	}
	public int getCodOS() {
		return codOS;
	}
	public void setCodOS(int codOS) {
		this.codOS = codOS;
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
