package rnc.sismedicao.model.beans;

public class ItemMedicao {
	
	private int codItemMedicao;
	private String descricao;
	private double valorMIN;
	private double valorMAX;
	private Equipamento equipamento;
	private UnidadeDeMedicao unidadeDeMedicao;

	public ItemMedicao() {

	}
	
	public ItemMedicao(String descricao, double valorMIN, double valorMAX,
			Equipamento equipamento, UnidadeDeMedicao unidadeDeMedicao) {
		this.descricao = descricao;
		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
		this.equipamento = equipamento;
		this.unidadeDeMedicao = unidadeDeMedicao;
	}
	
	public ItemMedicao(int codItemMedicao, String descricao, double valorMIN,
			double valorMAX) {
		this.codItemMedicao = codItemMedicao;
		this.descricao = descricao;
		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
	}

	public int getCodItemMedicao() {
		return codItemMedicao;
	}

	public void setCodItemMedicao(int codItemMedicao) {
		this.codItemMedicao = codItemMedicao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorMIN() {
		return valorMIN;
	}
	public void setValorMIN(double valorMIN) {
		this.valorMIN = valorMIN;
	}
	public double getValorMAX() {
		return valorMAX;
	}
	public void setValorMAX(double valorMAX) {
		this.valorMAX = valorMAX;
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public UnidadeDeMedicao getUnidadeDeMedicao() {
		return unidadeDeMedicao;
	}
	public void setUnidadeDeMedicao(UnidadeDeMedicao unidadeDeMedicao) {
		this.unidadeDeMedicao = unidadeDeMedicao;
	}
	
	
	
}
