package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.Falha;

public class FalhaTableModel extends AbstractTableModel {
	
	private ArrayList<Falha> falhas;
	private String[] nomeColunas = {"CODIGO", "CATEGORIA", "DESCRIÇÃO"};
	
	public FalhaTableModel() {
		this.falhas = falhas;
	}
	
	public FalhaTableModel(final ArrayList<Falha> falhas) {
		this.falhas = falhas;
	}
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "CODIGO";
		case 1:
			return "CATEGORIA";
		case 2:
			return "DESCRIÇÃO";
		}
		return "?";
	}

	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}

	@Override
	public int getRowCount() {
		return falhas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Falha falha = falhas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return falha.getId();
		case 1:
			return falha.getCategoriaFalha();
		case 2:
			return falha.getProblema();
		}
		return null;
	}
	
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
