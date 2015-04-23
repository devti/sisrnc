package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.Equipamento;

public class EquipamentoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	
	private ArrayList<Equipamento> equipamentos;
	private String[] nomeColunas = {"CODEQUIPAMENTO", "DESCRIÇÃO", "SERIE"};
	
	public  EquipamentoTableModel() {
		this.equipamentos = new ArrayList<Equipamento>();
	}
	
	public EquipamentoTableModel(final ArrayList<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	

	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "CODEQUIPAMENTO";
		case 1:
			return "DESCRIÇÃO";
		case 2:
			return "SERIE";
		}
		return "?";
		
	}

	@Override
	public int getRowCount() {
		return equipamentos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Equipamento equipamento = equipamentos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return equipamento.getCodEquipamento();
		case 1:
			return equipamento.getDescricao();
		case 2:
			return equipamento.getRegistro();
		default:
			return null;
		}
	}

}
