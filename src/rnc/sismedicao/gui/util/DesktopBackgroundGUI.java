package rnc.sismedicao.gui.util;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class DesktopBackgroundGUI extends JDesktopPane{
	
	private Image imagem;
	
	public DesktopBackgroundGUI(String image){
		this.imagem = new ImageIcon(image).getImage();
		this.setBackground(Color.getColor("240, 240, 240"));
	}
	
	@Override
	public void paintComponent(Graphics graphics){
		graphics.drawImage(this.imagem, 0, 0, getWidth(), getHeight(), this);
	}

}
