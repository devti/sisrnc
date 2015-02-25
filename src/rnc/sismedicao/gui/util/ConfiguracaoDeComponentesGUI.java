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
	
	private static final int DIVISOR_LARGURA = 2;
	private static final int DIVISOR_ALTURA = 6;
	
	private ConfiguracaoDeComponentesGUI(){
		
	}
	
	/*
	 * Início do Overload do método contralizaFrame
	 * */
	
	public static void centralizaFrame(Frame Frame){
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
        int x = (int)(dimension.getWidth() - Frame.getWidth()) / DIVISOR_LARGURA;  
        int y = (int)(dimension.getHeight() - Frame.getHeight()) / DIVISOR_ALTURA;  
		
		Frame.setBounds(x, y, Frame.getWidth(), Frame.getHeight());
		
		System.out.println("\nInicializando tela: "+Frame.getTitle()+
				"\n Posição H: "+x+
				"\nPosição V: "+y+
				"\nResolução do Monitor: "+(int)dimension.getWidth()+"x"+(int)dimension.getHeight());
	}
	
	public static void centralizaFrame(Frame Frame, boolean resizable){
		
		centralizaFrame(Frame);
		
		Frame.setResizable(resizable);
		
		System.out.println("Resizable: " +resizable+	"\n");
	}
	
	public static void centralizaFrame(Frame Frame, int width, int heigth){
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
        int x = (int)(dimension.getWidth() - width) / DIVISOR_LARGURA;  
        int y = (int)(dimension.getHeight() - heigth) / DIVISOR_ALTURA;  
		        
		Frame.setBounds(x, y, width, heigth);
		
		System.out.printf("\nInicializando tela: "+Frame.getTitle()+
				"\nPosição H: "+x+
				"\nPosição V: "+y+
				"\nResolução da tela: "+width+"x"+heigth+
				"\nResolução do Monitor: "+(int)dimension.getWidth()+"x"+(int)dimension.getHeight()+ "\n");
	}
	
	public static void centralizaFrame(Frame Frame, int width, int heigth, boolean resizable){

		centralizaFrame(Frame, width, heigth);
		
		Frame.setResizable(resizable);
		
		System.out.println("Resizable: " +resizable+ "\n");
		
	}
	
	/*
	 * Fim do Overload do método centralizaFrame
	 * */
	
	
	
	public static void configuraJTextField(JTextField jTextField){
		jTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		jTextField.setBackground(Color.WHITE);
		jTextField.setColumns(10);
		
	}
	
	
}
