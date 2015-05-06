package rnc.sismedicao.model.beans;

public class GrupoTecnico {
	private int codigoGrupoTecnico;
	private String nomeGrupoTecnico;
	private String observacao;
	private String localizacao;
	
	public GrupoTecnico(String nomeGrupoTecnico, String observacao,
			String localizacao) {
		this.nomeGrupoTecnico = nomeGrupoTecnico;
		this.observacao = observacao;
		this.localizacao = localizacao;
	}
	public GrupoTecnico() {
		
	}
	public GrupoTecnico(int codigoGrupoTecnico, String nomeGrupoTecnico,
			String observacao, String localizacao) {
		this.codigoGrupoTecnico = codigoGrupoTecnico;
		this.nomeGrupoTecnico = nomeGrupoTecnico;
		this.observacao = observacao;
		this.localizacao = localizacao;
	}

	public int getCodigo() {
		return codigoGrupoTecnico;
	}

	public void setCodigoGrupoTecnico(int codigoGrupoTecnico) {
		this.codigoGrupoTecnico = codigoGrupoTecnico;
	}

	public String getNomeGrupoTecnico() {
		return nomeGrupoTecnico;
	}

	public void setNomeGrupoTecnico(String nomeGrupoTecnico) {
		this.nomeGrupoTecnico = nomeGrupoTecnico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	

	
	
	
	

	
}
