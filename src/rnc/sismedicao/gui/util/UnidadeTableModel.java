package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.UnidadeDeMedicao;

public class UnidadeTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<UnidadeDeMedicao> unidades;
	private String[] nomeColunas = {"CODIGO", "DESCRIÇÃO"};
	
	public UnidadeTableModel(final ArrayList<UnidadeDeMedicao> unidades) {
		this.unidades = unidades;
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
		}
		return "?";
	}

	@Override
	public int getRowCount() {
		
		return unidades.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UnidadeDeMedicao unidade = unidades.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return unidade.getCodigo();
		case 1:
			return unidade.getDescricao();
		default:
			return null;
		}
	}
	
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
