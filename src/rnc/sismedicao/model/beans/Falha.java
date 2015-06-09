package rnc.sismedicao.model.beans;

public class Falha {
	
	private int id;
	private String responsavel;
	private String problema;
	private String solucao;
	private String categoriaFalha;
	private String impactoFalha;
	private String horaFalha;
	private String dataFalha;
	private String duracaoFalha;
		
	public Falha(String responsavel, String problema, String solucao,
			String impactoFalha, String horaFalha, String dataFalha, String categoriaFalha, String duracaoFalha) {
		this.responsavel = responsavel;
		this.problema = problema;
		this.solucao = solucao;
		this.impactoFalha = impactoFalha;
		this.horaFalha = horaFalha;
		this.dataFalha = dataFalha;
		this.categoriaFalha = categoriaFalha;
		this.duracaoFalha = duracaoFalha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getProblema() {
		return problema;
	}


	public void setProblema(String problema) {
		this.problema = problema;
	}


	public String getSolucao() {
		return solucao;
	}


	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}


	public String getImpactoFalha() {
		return impactoFalha;
	}


	public void setImpactoFalha(String impactoFalha) {
		this.impactoFalha = impactoFalha;
	}


	public String getHoraFalha() {
		return horaFalha;
	}


	public void setHoraFalha(String horaFalha) {
		this.horaFalha = horaFalha;
	}


	public String getDataFalha() {
		return dataFalha;
	}


	public void setDataFalha(String dataFalha) {
		this.dataFalha = dataFalha;
	}

	

	public String getCategoriaFalha() {
		return categoriaFalha;
	}


	public void setCategoriaFalha(String categoriaFalha) {
		this.categoriaFalha = categoriaFalha;
	}


	public String getDuracaoFalha() {
		return duracaoFalha;
	}


	public void setDuracaoFalha(String duracaoFalha) {
		this.duracaoFalha = duracaoFalha;
	}
	
	
	
	

}
