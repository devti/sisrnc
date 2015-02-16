package rnc.sismedicao.model.beans;

public class ItemMedicao {
	
	private String descricao;
	private double valorMIN;
	private double valorMAX;
	private UnidadeDeMedicao unidadeDeMedicao;

	public ItemMedicao() {

	}
	public ItemMedicao(String descricao, double valorMIN, double valorMAX,
			UnidadeDeMedicao unidadeDeMedicao) {
		this.descricao = descricao;
		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
		this.unidadeDeMedicao = unidadeDeMedicao;
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
	public UnidadeDeMedicao getUnidadeDeMedicao() {
		return unidadeDeMedicao;
	}
	public void setUnidadeDeMedicao(UnidadeDeMedicao unidadeDeMedicao) {
		this.unidadeDeMedicao = unidadeDeMedicao;
	}
	
	
	
}
