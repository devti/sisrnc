package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.OrdemServico;

public class PlanoTableModel extends AbstractTableModel {
	
	private static final long SerialVersionUID = 1L;
	
	private ArrayList<OrdemServico> ordens;
	private String[] nomeColunas = {"CÓDIGO", "EQUIPAMENTO", "GRUPO TÉCNICO"};
	
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
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "CODIGO";
		case 1:
			return "EQUIPAMENTO";
		case 2:
			return "GRUPO TECNICO";
		}
		
		return "?";
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
			 ordem.getCodigo();
		case 1:
			ordem.getEquipamento();
		case 2:
			ordem.getGrupoTecnico();
		default:
			return null;
		}
	
	}
	
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
