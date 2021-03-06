package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.OrdemServico;

public class OrdemServicoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<OrdemServico> ordens;
	private String[] nomeColunas = {"DATA", "CODIGO", "EQUIPAMENTO", "GRUPO TECNICO"};
	
	public OrdemServicoTableModel() {
		this.ordens = new ArrayList<OrdemServico>();
	}
	
	public OrdemServicoTableModel(final ArrayList<OrdemServico> ordens) {
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
	
	public String getColumnName(final int column) {
		switch (column) {
		case 0:
			return "DATA";
		case 1:
			return "CODIGO";
		case 2:
			return "EQUIPAMENTO";
		case 3:
			return "GRUPO TECNICO";
		}
		return "?";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrdemServico ordem = ordens.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return ordem.getData();
		case 1:
			return ordem.getCodigo();
		case 2:
			return ordem.getEquipamento().getDescricao();
		case 3:
			return ordem.getGrupoTecnico().getNomeGrupoTecnico();
		}
		return null;
	}
	
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
