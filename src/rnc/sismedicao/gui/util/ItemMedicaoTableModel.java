package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.ItemMedicao;

public class ItemMedicaoTableModel extends AbstractTableModel {

	private ArrayList<ItemMedicao> itens;
	private String[] nomeColunas = { "CODIGO", "DESCRIÇÃO", "VALOR MIN",
			"VALOR MAX" };

	
	public ItemMedicaoTableModel() {
		this.itens = new ArrayList<ItemMedicao>();
	}
	
	public ItemMedicaoTableModel(final ArrayList<ItemMedicao> itens) {
		this.itens = itens;
	}


	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}

	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "CODIGO";
		case 1:
			return "DESCRIÇÃO";
		case 2:
			return "VALOR MIN";
		case 3:
			return "VALOR MAX";
		}
		return "?";
	}

	@Override
	public int getRowCount() {
		return itens.size();
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ItemMedicao item = itens.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return item.getUnidadeDeMedicao().getCodigo();
		case 1:
			return item.getUnidadeDeMedicao().getDescricao();
		case 2:
			return item.getValorMIN();
		case 3:
			return item.getValorMAX();
		default:
			return null;
		}
	}

	public String[] getNomeColunas() {
		return nomeColunas;
	}

	public boolean isCellEditable(int row, int column) {
		if (column <= 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public ItemMedicao get (int row) {
		return this.itens.get(row);
	}
	
	public void setValueAt(Object valor, int row, int column) {
		ItemMedicao item = itens.get(row);
		if (valor == null) return;
		
		switch(column) {
		case 0:
			item.getUnidadeDeMedicao().getCodigo();break;
		case 1:
			 item.getUnidadeDeMedicao().getDescricao();break;
		case 2:
			 item.setValorMIN(Double.parseDouble((String) valor));break;
		case 3:
			item.setValorMAX(Double.parseDouble((String) valor));break;
		}
		this.fireTableCellUpdated(row, row);
	}


	public void setNomeColunas(String[] nomeColunas) {
		this.nomeColunas = nomeColunas;
	}

}
