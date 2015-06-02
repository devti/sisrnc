package rnc.sismedicao.gui.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.ItemMedicao;

public class ItemMedicaoLeituraTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<ItemMedicao> itens;
	private String[] nomeColunas = { "CODIGO", "DESCRIÇÃO", "VALOR" };

	public ItemMedicaoLeituraTableModel() {
		this.itens = new ArrayList<ItemMedicao>();
	}

	public ItemMedicaoLeituraTableModel(final List<ItemMedicao> itens) {
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
			return "VALOR";
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
		case 1:
			return item.getUnidadeDeMedicao().getCodigo();
		case 2:
			return item.getUnidadeDeMedicao().getDescricao();
		case 3:
			return item.getValorAtual();
		}
		return null;
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
