package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.OrdemServico;

public class PlanoTableModel extends AbstractTableModel {
	
	private static final long SerialVersionUID = 1L;
	
	private ArrayList<OrdemServico> ordens;
	private String[] nomeColunas = {"CÓDIGO", "EQUIPAMENTO", "GRUPO TÉCNICO", "TIPO"};
	
	public  PlanoTableModel() {
		this.ordens = new ArrayList<OrdemServico>();
	}
	
	public PlanoTableModel(final ArrayList<OrdemServico> ordens) {
		this.ordens = ordens;
	}

	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}

	@Override
	public int getRowCount() {
		return ordens.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrdemServico ordem = ordens.get(rowIndex);
		switch (columnIndex) {
		case 0:
			// ordem.getCodOS();
		case 1:
		}
		return null;
	}

}
