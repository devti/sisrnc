package rnc.sismedicao.model.beans;

public class Equipamento {	
	
	private int id;
	private String registro;
	private String descricao;
	private Item item;
	private Local local;
	private ItemMedicao[] itemMedicao;
	
	public Equipamento(int id, String registro, String descricao, Item item,
			Local local, ItemMedicao[] itemMedicao) {
		this.id = id;
		this.registro = registro;
		this.descricao = descricao;
		this.item = item;
		this.local = local;
		this.itemMedicao = itemMedicao;
	}
	
	public Equipamento() {
	
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ItemMedicao[] getItemMedicao() {
		return itemMedicao;
	}
	public void setItemMedicao(ItemMedicao[] itemMedicao) {
		this.itemMedicao = itemMedicao;
	}
	
	
	
}
