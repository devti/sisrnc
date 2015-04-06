package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.Item;

public class ItemTableModel extends AbstractTableModel {

	private ArrayList<Item> itens;
	private String[] nomeColunas = { "NOME", "MARCA", "SERIAL" };

	public ItemTableModel() {
		this.itens = new ArrayList<Item>();
	}

	public ItemTableModel(final ArrayList<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}

	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "NOME";
		case 1:
			return "MARCA";
		case 2:
			return "SERIAL";
		}
		return "?";
	}

	@Override
	public int getRowCount() {
		return itens.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Item item = itens.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return item.getNome();
		case 1:
			return item.getMarca();
		case 2:
			return item.getSerial();
		default:
			return null;
		}
	}

}
