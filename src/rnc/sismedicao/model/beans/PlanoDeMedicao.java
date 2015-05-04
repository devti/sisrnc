package rnc.sismedicao.model.beans;

public class PlanoDeMedicao {
private int codigo;
private int codigoGrupoTecnico;
private String dataInicial;
private String dataFinal;
private String horario;
private String status;
private String dataCriacao;
private String login;
private String dataAlteracao;


public PlanoDeMedicao(int codigo, int codigoGrupoTecnico, String dataInicial,
		String dataFinal, String horario, String status, String dataCriacao,
		String login, String dataAlteracao) {
	this.codigo = codigo;
	this.codigoGrupoTecnico = codigoGrupoTecnico;
	this.dataInicial = dataInicial;
	this.dataFinal = dataFinal;
	this.horario = horario;
	this.status = status;
	this.dataCriacao = dataCriacao;
	this.login = login;
	this.dataAlteracao = dataAlteracao;
}


public int getCodigo() {
	return codigo;
}


public void setCodigo(int codigo) {
	this.codigo = codigo;
}


public int getCodigoGrupoTecnico() {
	return codigoGrupoTecnico;
}


public void setCodigoGrupoTecnico(int codigoGrupoTecnico) {
	this.codigoGrupoTecnico = codigoGrupoTecnico;
}


public String getDataInicial() {
	return dataInicial;
}


public void setDataInicial(String dataInicial) {
	this.dataInicial = dataInicial;
}


public String getDataFinal() {
	return dataFinal;
}


public void setDataFinal(String dataFinal) {
	this.dataFinal = dataFinal;
}


public String getHorario() {
	return horario;
}


public void setHorario(String horario) {
	this.horario = horario;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getDataCriacao() {
	return dataCriacao;
}


public void setDataCriacao(String dataCriacao) {
	this.dataCriacao = dataCriacao;
}


public String getLogin() {
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getDataAlteracao() {
	return dataAlteracao;
}


public void setDataAlteracao(String dataAlteracao) {
	this.dataAlteracao = dataAlteracao;
}


	
	
}
