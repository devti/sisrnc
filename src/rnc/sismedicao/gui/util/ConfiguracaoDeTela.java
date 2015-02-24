package rnc.sismedicao.gui.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ConfiguracaoDeTela {
	
	
	private static Toolkit toolKit = null;
	private static Dimension dimension = null;
	
	private ConfiguracaoDeTela(){
		
	}
	
	public static void centralizaJFrame(JFrame jFrame){
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
        int x = (int)(dimension.getWidth() - jFrame.getWidth()) / 2;  
        int y = (int)(dimension.getHeight() - jFrame.getHeight()) / 6;  
		
		jFrame.setBounds(x, y, jFrame.getWidth(), jFrame.getHeight());
		
		System.out.println(x +", "+y+", "+jFrame.getWidth()+", "+jFrame.getHeight()+", "+dimension.getWidth()+", "+dimension.getHeight());
	}
	
	
	
	
}
