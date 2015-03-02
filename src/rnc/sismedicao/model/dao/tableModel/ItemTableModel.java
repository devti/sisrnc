package rnc.sismedicao.model.dao.tableModel;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;
import rnc.sismedicao.model.dao.ItemDAO;

@SuppressWarnings("serial")
public class ItemTableModel extends AbstractTableModel implements TableModelListener{

	public List<Item> itens;
	private List<String> colunas;
	private ItemDAO dao;
	
	public ItemTableModel() {
		this.dao = new ItemDAO();
		this.itens = this.dao.ListAll();
		colunas = Arrays.asList("Código", "Descrição");
		this.addTableModelListener(this);
	}
	
	@Override
	public int getRowCount() {
		return itens.size();
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
		Item item = itens.get(rowIndex);
		System.out.print(rowIndex + "  -  ");
		System.out.println(item.getCodCliente() +" - "+ item.getNome());
		switch (columnIndex) {
		case 0:
			return item.getCodCliente();
		case 1:
			return item.getNome();
		}
		return null;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
//		int i = e.getFirstRow();
//		Item item = itens.get(i);
//		System.out.println(i);
//		dao.update(item);
		
	}
	
	@Override
	public Class getColumnClass(int coluna){
		return getValueAt(0, coluna).getClass();
	}

	
}
