package rnc.sismedicao.gui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ConfiguracaoDeComponentesGUI {
	
	
	private static Toolkit toolKit = null;
	private static Dimension dimension = null;
	
	private ConfiguracaoDeComponentesGUI(){
		
	}
	
	public static void centralizaJFrame(JFrame jFrame){
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
        int x = (int)(dimension.getWidth() - jFrame.getWidth()) / 2;  
        int y = (int)(dimension.getHeight() - jFrame.getHeight()) / 6;  
		
		jFrame.setBounds(x, y, jFrame.getWidth(), jFrame.getHeight());
		
		System.out.println(x+", "+y+", "+jFrame.getWidth()+", "+jFrame.getHeight()+", "+dimension.getWidth()+", "+dimension.getHeight());
	}
	
	public static void configuraJTextField(JTextField jTextField){
		jTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		jTextField.setBackground(Color.WHITE);
		jTextField.setColumns(10);
		
	}
	
	
}
