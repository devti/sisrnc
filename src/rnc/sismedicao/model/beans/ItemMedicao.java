package rnc.sismedicao.model.beans;

public class ItemMedicao {

	private int codItemMedicao;
	private double valorMIN;
	private double valorMAX;
	private double valorAtual;
	private String descricao;
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
	
	public ItemMedicao(int codItemMedicao,double valorMIN, double valorMAX,
			UnidadeDeMedicao unidadeDeMedicao) {
		this.codItemMedicao = codItemMedicao;
		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
		this.unidadeDeMedicao = unidadeDeMedicao;
	}

	public ItemMedicao(int codItemMedicao, String descricao, double valorMIN,
			double valorMAX) {
		this.unidadeDeMedicao.setDescricao(descricao);
		this.descricao = descricao;
		this.codItemMedicao = codItemMedicao;
		this.valorMIN = valorMIN;
		this.valorMAX = valorMAX;
	}

	public ItemMedicao(int codItemMedicao, double valorAtual, String descricao) {
		super();
		this.codItemMedicao = codItemMedicao;
		this.valorAtual = valorAtual;
		this.descricao = descricao;
	}

	public double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
