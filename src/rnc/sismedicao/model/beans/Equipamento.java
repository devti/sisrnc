package rnc.sismedicao.model.beans;

public class Equipamento {	
	
	private int codEquipamento;
	private String codCliente;
	private String registro;
	private String descricao;
	private Item item;
	private Local local;
	private ItemMedicao itemMedicao;
	
	public Equipamento(int id,String codCliente, String registro, String descricao, Item item,
			Local local, ItemMedicao itemMedicao) {
		this.codCliente = codCliente;
		this.registro = registro;
		this.descricao = descricao;
		this.item = item;
		this.local = local;
		this.itemMedicao = itemMedicao;
	}
	
	public Equipamento(String codCliente, String registro, String descricao, Item item, Local local) {
		this.codCliente = codCliente;
		this.registro = registro;
		this.descricao = descricao;
		this.item = item;
		this.local = local;
	}

	public Equipamento() {
	
	}

	public int getCodEquipamento() {
		return codEquipamento;
	}
	public void setCodEquipamento(int codEquipamento) {
		this.codEquipamento = codEquipamento;
	}
	
	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public ItemMedicao getItemMedicao() {
		return itemMedicao;
	}
	public void setItemMedicao(ItemMedicao itemMedicao) {
		this.itemMedicao = itemMedicao;
	}
	
	
	
}
