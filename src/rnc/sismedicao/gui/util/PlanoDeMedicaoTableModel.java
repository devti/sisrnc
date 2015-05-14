package rnc.sismedicao.gui.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.PlanoDeMedicao;

public class PlanoDeMedicaoTableModel extends AbstractTableModel {
	
	private static final long SerialVersionUID = 1L;
	
	private ArrayList<PlanoDeMedicao> planos;
	private String[] nomeColunas = {"CODIGO","DESCRICAO", "EQUIPAMENTO", "GRUPO TÉCNICO"};
	
	public  PlanoDeMedicaoTableModel() {
		this.planos = new ArrayList<PlanoDeMedicao>();
	}
	
	public PlanoDeMedicaoTableModel(final ArrayList<PlanoDeMedicao> planos) {
		this.planos = planos;
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
			return "DESCRICAO";
		case 2:
			return "EQUIPAMENTO";
		case 3:
			return "GRUPOTECNICO";
		}
		return "?";
	}
	
	@Override
	public int getRowCount() {
		return planos.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PlanoDeMedicao plano = planos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return plano.getCodigo();
		case 1:
			return plano.getDescricao();
		case 2:
			return plano.getEquipamento().getDescricao();
		case 3:
			return plano.getGrupoTecnico().getNomeGrupoTecnico();
		}
		return null;
	}
	public String[] getNomeColunas() {
		return nomeColunas;
	}

}
 