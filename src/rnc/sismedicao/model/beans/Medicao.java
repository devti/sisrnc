package rnc.sismedicao.model.beans;

public class Medicao {

	private Equipamento equipamento;
	private OrdemServico ordemServico;
	
	public Medicao() {
		
	}

	public Medicao(Equipamento equipamento, OrdemServico ordemServico) {
		this.equipamento = equipamento;
		this.ordemServico = ordemServico;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
	
	
	
	
}
