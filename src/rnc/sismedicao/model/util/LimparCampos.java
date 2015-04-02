package rnc.sismedicao.model.util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import rnc.sismedicao.gui.util.DecimalFormattedField;

public class LimparCampos {
	public static void limparCampos(Container container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof DecimalFormattedField) {
					DecimalFormattedField field = (DecimalFormattedField) component;
					field.setValue(0);
			} else if (component instanceof JTextField) {
				JTextField field = (JTextField) component;
				field.setText("");
			} else if (component instanceof JSpinner) {
				JSpinner js = (JSpinner) component;
				js.setValue(1);
			} else if (component instanceof JTextArea) {
				JTextArea area = (JTextArea) component;
				area.setText("");
			} else if (component instanceof Container) {
				limparCampos((Container) component);
			}
		}
	}
}

