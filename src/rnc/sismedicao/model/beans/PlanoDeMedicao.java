package rnc.sismedicao.model.beans;

public class PlanoDeMedicao {
private int codigo;
private String descricao;
private GrupoTecnico grupoTecnico;
private Equipamento equipamento;
private String dataInicial;
private String dataFinal;
private String horario;
private String diaSemana;
private String diaMes;
private String status;
private String dataCriacao;
private Usuario usuario;
private String dataAlteracao;


public PlanoDeMedicao(int codigo, String descricao,GrupoTecnico grupoTecnico,Equipamento equipamento, String dataInicial,
		String dataFinal, String horario, String diaSemana, String diaMes,String status, String dataCriacao, String dataAlteracao) {
	this.codigo = codigo;
	this.descricao=descricao;
	this.grupoTecnico = grupoTecnico;
	this.equipamento = equipamento;
	this.dataInicial = dataInicial;
	this.dataFinal = dataFinal;
	this.horario = horario;
	this.diaSemana = diaSemana;
	this.diaMes = diaMes;
	this.status = status;
	this.dataCriacao = dataCriacao;
	this.dataAlteracao = dataAlteracao;

}

public PlanoDeMedicao(String descricao,GrupoTecnico grupoTecnico,Equipamento equipamento, String dataInicial,
		String dataFinal, String horario, String diaSemana, String diaMes) {
	this.descricao = descricao;
	this.grupoTecnico = grupoTecnico;
	this.equipamento = equipamento;
	this.dataInicial = dataInicial;
	this.dataFinal = dataFinal;
	this.horario = horario;
	this.diaSemana = diaSemana;
	this.diaMes = diaMes;

}


public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getDiaSemana() {
	return diaSemana;
}


public void setDiaSemana(String diaSemana) {
	this.diaSemana = diaSemana;
}


public String getDiaMes() {
	return diaMes;
}


public void setDiaMes(String diaMes) {
	this.diaMes = diaMes;
}


public int getCodigo() {
	return codigo;
}


public void setCodigo(int codigo) {
	this.codigo = codigo;
}


public GrupoTecnico getGrupoTecnico() {
	return grupoTecnico;
}


public void setGrupoTecnico(GrupoTecnico grupoTecnico) {
	this.grupoTecnico = grupoTecnico;
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


public Usuario getUsuario() {
	return usuario;
}


public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public Equipamento getEquipamento() {
	return equipamento;
}


public void setEquipamento(Equipamento equipamento) {
	this.equipamento = equipamento;
}


public String getDataAlteracao() {
	return dataAlteracao;
}


public void setDataAlteracao(String dataAlteracao) {
	this.dataAlteracao = dataAlteracao;
}


	
	
}
