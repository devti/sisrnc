package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.beans.Pessoa;

public class GrupoTecnicoTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pessoa> pessoas;
	private String[] nomeColunas = {"LOGIN"};
	
	public GrupoTecnicoTableModel() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public GrupoTecnicoTableModel(final ArrayList<Pessoa> unidades) {
		this.pessoas = pessoas;
	}

	@Override
	public int getColumnCount() {
		
		return nomeColunas.length;
	}
	
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "LOGIN";
		}
		return "?";
	}

	@Override
	public int getRowCount() {
		
		return pessoas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pessoa pessoa = pessoas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return pessoa.getNome();
		default:
			return null;
		}
	}
	
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
