package rnc.sismedicao.gui.util;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.Document;


@SuppressWarnings("serial")
public class NewJTextField extends JTextField {
	
	public NewJTextField() {
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		this.setColumns(10);
	}

	public NewJTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		// TODO Auto-generated constructor stub
	}

	public NewJTextField(int columns) {
		super(columns);
		// TODO Auto-generated constructor stub
	}

	public NewJTextField(String text, int columns) {
		super(text, columns);
		// TODO Auto-generated constructor stub
	}

	public NewJTextField(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
