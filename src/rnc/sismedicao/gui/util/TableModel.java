package rnc.sismedicao.gui.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel{
	
	private List<Object> valores; 
	
	public TableModel(List<Object> valores) {
		this.valores = valores;
	}

	@Override
	public int getRowCount() {
		return valores.size(); 
	}

	@Override
	public int getColumnCount() {
		
		return 0;
	} 

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
