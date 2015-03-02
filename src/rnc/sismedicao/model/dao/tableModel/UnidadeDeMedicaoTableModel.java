package rnc.sismedicao.model.dao.tableModel;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.dao.UnidadeDeMedicaoDAO;

@SuppressWarnings("serial")
public class UnidadeDeMedicaoTableModel extends AbstractTableModel implements TableModelListener{

	private List<UnidadeDeMedicao> unidadesDeMedicao;
	private List<String> colunas;
	private UnidadeDeMedicaoDAO dao;
	
	
	
	public UnidadeDeMedicaoTableModel() {
		this.dao = new UnidadeDeMedicaoDAO();
		this.unidadesDeMedicao = this.dao.ListAll();
		System.out.println(this.unidadesDeMedicao.get(1).getCodigo());
		System.out.println(this.unidadesDeMedicao.get(1).getDescricao());
		colunas = Arrays.asList("Código", "Descrição");
		this.addTableModelListener(this);
	}

	@Override
	public int getRowCount() {
		return unidadesDeMedicao.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.size();
	}
	
	@Override
	public String getColumnName(int coluna) {
		return colunas.get(coluna);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UnidadeDeMedicao unidadeDeMedicao = unidadesDeMedicao.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return unidadeDeMedicao.getCodigo();
		case 1:
			return unidadeDeMedicao.getDescricao();
		}
		return null;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int i = e.getFirstRow();
		UnidadeDeMedicao unidadeDeMedicao = unidadesDeMedicao.get(i);
		System.out.println(i);
		dao.update(unidadeDeMedicao);
		
	}
	
	@Override
	public Class getColumnClass(int coluna){
		return getValueAt(0, coluna).getClass();
	}

}
