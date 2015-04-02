package rnc.sismedicao.gui.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CellEditor extends DefaultTableCellRenderer {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String formato;
	private int nCol;
	private boolean entra = true;
	private boolean zebrado;

	public CellEditor() {
		entra = false;
		zebrado = true;
	}

	public CellEditor(int col, String formato) {
		this.formato = formato;
		this.nCol = col;
		zebrado = true;
	}

	public CellEditor(int col, String formato, boolean zebrado) {
		this.formato = formato;
		this.nCol = col;
		this.zebrado = zebrado;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component cellComponent = super.getTableCellRendererComponent(table,
				value, isSelected, hasFocus, row, column);
		if (zebrado) {
			Color background, foreground;
			if (isSelected) {
				foreground = Color.black;
			} else if (row % 2 == 0) {
				foreground = Color.black;
				background = Color.WHITE;
			} else {
				foreground = Color.black;
				background = new Color(235, 235, 235);
			}
		//	this.setBackground(background);
			this.setForeground(foreground);
		}
		if (nCol == column && entra) {
			JFormattedTextField tf = new DecimalFormattedField(this.formato);
			tf.setValue(value);
			this.setText(tf.getText());
			this.setHorizontalAlignment(SwingConstants.RIGHT);
		} else {
			this.setHorizontalAlignment(SwingConstants.LEADING);
		}

		return this;
	}

}
