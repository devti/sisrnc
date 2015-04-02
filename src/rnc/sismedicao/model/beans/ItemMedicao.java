package rnc.sismedicao.model.beans;

public class ItemMedicao {

	private int codItemMedicao;
	private double valorMIN;
	private double valorMAX;
	private Item item;
	private UnidadeDeMedicao unidadeDeMedicao;

	public ItemMedicao() {

	}

	public ItemMedicao(double valorMIN, double valorMAX,
			UnidadeDeMedicao unidadeDeMedicao) {

		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
		this.unidadeDeMedicao = unidadeDeMedicao;
	}

	public ItemMedicao(int codItemMedicao, String descricao, double valorMIN,
			double valorMAX) {
		this.codItemMedicao = codItemMedicao;
		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
	}

	public int getCodItemMedicao() {
		return codItemMedicao;
	}

	public void setCodItemMedicao(int codItemMedicao) {
		this.codItemMedicao = codItemMedicao;
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

	public Object get(int row) {
		// TODO Auto-generated method stub
		return null;
	}

}
