package rnc.sismedicao.model.beans;

public class Local extends Endereco{
	
	private int codLocal;
	private String tipo;
	private String descricao;
	private int codFilial;

	public Local() {

	}
	
	public Local(String tipo, String descricao, int codFilial) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.codFilial = codFilial;
	}

	public int getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(int codLocal) {
		this.codLocal = codLocal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(int codFilial) {
		this.codFilial = codFilial;
	}
	
	
}
