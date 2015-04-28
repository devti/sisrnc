package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.*;

public class GrupoTecnicoTableModel extends AbstractTableModel {

	private ArrayList<GrupoTecnico> grupoTecnico;
	private String[] nomeColunas = { "CODIGO", "NOME", "LOCALIZACAO" };


	public GrupoTecnicoTableModel(){
		this.grupoTecnico = new ArrayList<GrupoTecnico>();
	}
	public GrupoTecnicoTableModel(final ArrayList<GrupoTecnico> grupoTecnico) {
		this.grupoTecnico = grupoTecnico;
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
			return "NOME";
		case 2:
			return "LOCALIZACAO";
		}
		return "?";
	}

	@Override
	public int getRowCount() {
		return grupoTecnico.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		GrupoTecnico gt = grupoTecnico.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return gt.getCodigoGrupoTecnico();
		case 1:
			return gt.getNomeGrupoTecnico();
		case 2:
			return gt.getLocalizacao();
		default:
			return null;
		}
	}

}
