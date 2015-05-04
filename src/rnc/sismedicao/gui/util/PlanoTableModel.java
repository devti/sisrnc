package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.OrdemServico;

public class PlanoTableModel extends AbstractTableModel {
	
	private static final long SerialVersionUID = 1L;
	
	private ArrayList<OrdemServico> ordens;
	private String[] nomeColunas = {"C�DIGO", "EQUIPAMENTO", "GRUPO T�CNICO", "TIPO"};
	
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
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
