package rnc.sismedicao.model.beans;

public class OrdemServico {

	private int codigo;
	private int codigoPlanoMedicao;
	private GrupoTecnico grupoTecnico;
	private Equipamento equipamento; 
	private String dataCriacao;
	private String dataAlteracao;
	private String data;
	private String hora;
	private Usuario usuario;
	private int codEquipamento;
	private int idGrupoTecnico;

	public OrdemServico() {

	}

	public OrdemServico(int codigoPlanoMedicao, GrupoTecnico grupoTecnico,
			Equipamento equipamento, String data, String hora) {
		this.codigoPlanoMedicao = codigoPlanoMedicao;
		this.grupoTecnico = grupoTecnico;
		this.equipamento = equipamento;
		this.data = data;
		this.hora = hora;
	}
	
	public OrdemServico(int codigoPlanoMedicao, int idGrupoTecnico,
			int idEquipamento, String data, String hora) {
		this.codigoPlanoMedicao = codigoPlanoMedicao;
		this.idGrupoTecnico = idGrupoTecnico;
		this.codEquipamento = idEquipamento;
		this.data = data;
		this.hora = hora;
	}

	public OrdemServico(int codigo, GrupoTecnico grupoTecnico,
			Equipamento equipamento, String dataCriacao, String dataAlteracao,
			String data, String hora, Usuario usuario) {
		this.codigo = codigo;
		this.grupoTecnico = grupoTecnico;
		this.equipamento = equipamento;
		this.dataCriacao = dataCriacao;
		this.dataAlteracao = dataAlteracao;
		this.data = data;
		this.hora = hora;
		this.usuario = usuario;
	}

	public int getCodEquipamento() {
		return codEquipamento;
	}

	public void setCodEquipamento(int codEquipamento) {
		this.codEquipamento = codEquipamento;
	}

	public int getIdGrupoTecnico() {
		return idGrupoTecnico;
	}

	public void setIdGrupoTecnico(int idGrupoTecnico) {
		this.idGrupoTecnico = idGrupoTecnico;
	}

	public int getCodigoPlanoMedicao() {
		return codigoPlanoMedicao;
	}

	public void setCodigoPlanoMedicao(int codigoPlanoMedicao) {
		this.codigoPlanoMedicao = codigoPlanoMedicao;
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

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
