package rnc.sismedicao.gui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ConfiguracaoDeComponentesGUI {
	
	
	private static Toolkit toolKit = null;
	private static Dimension dimension = null;
	
	private ConfiguracaoDeComponentesGUI(){
		
	}
	
	/*
	 * In�cio do Overload do m�todo contralizaFrame
	 * */
	
	public static void centralizaFrame(Frame Frame){
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
        int x = (int)(dimension.getWidth() - Frame.getWidth()) / 2;  
        int y = (int)(dimension.getHeight() - Frame.getHeight()) / 6;  
		
		Frame.setBounds(x, y, Frame.getWidth(), Frame.getHeight());
		
		System.out.println("Inicializando tela: "+Frame.getTitle()+
				"\n Posi��o H: "+x+
				"\nPosi��o V: "+y+
				"\nResolu��o do Monitor: "+(int)dimension.getWidth()+"x"+(int)dimension.getHeight());
	}
	
	public static void centralizaFrame(Frame Frame, boolean resizable){
		
		centralizaFrame(Frame);
		
		Frame.setResizable(resizable);
		
		System.out.println("Resizable: " +resizable+	"\n");
	}
	
	public static void centralizaFrame(Frame Frame, int width, int heigth){
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
        int x = (int)(dimension.getWidth() - width) / 2;  
        int y = (int)(dimension.getHeight() - heigth) / 6;  
		        
		Frame.setBounds(x, y, width, heigth);
		
		System.out.printf("Inicializando tela: "+Frame.getTitle()+
				"\nPosi��o H: "+x+
				"\nPosi��o V: "+y+
				"\nResolu��o da tela: "+width+"x"+heigth+
				"\nResolu��o do Monitor: "+(int)dimension.getWidth()+"x"+(int)dimension.getHeight()+ "\n");
	}
	
	public static void centralizaFrame(Frame Frame, int width, int heigth, boolean resizable){

		centralizaFrame(Frame, width, heigth);
		
		Frame.setResizable(resizable);
		
		System.out.println("Resizable: " +resizable+ "\n");
		
	}
	
	/*
	 * Fim do Overload do m�todo centralizaFrame
	 * */
	
	
	
	public static void configuraJTextField(JTextField jTextField){
		jTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		jTextField.setBackground(Color.WHITE);
		jTextField.setColumns(10);
		
	}
	
	
}
