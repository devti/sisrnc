package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AbrirOSGUI extends JFrame {

	private JPanel contentPane;
	private static AbrirOSGUI abrirOSGUI;

	/**
	 * Create the frame.
	 */
	public AbrirOSGUI() {
		setTitle("Abrir Plano de Medi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Equipamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(10, 68, 539, 178);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Grupo T\u00E9cnico Responsavel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 389, 539, 113);
		contentPane.add(panel_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		button.setBounds(10, 11, 30, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		button_1.setBounds(43, 11, 30, 30);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		button_2.setBounds(75, 11, 30, 30);
		contentPane.add(button_2);
	}
	
	public static AbrirOSGUI getInstance() {
		if (abrirOSGUI == null) {
			return abrirOSGUI = new AbrirOSGUI();
		}
		return abrirOSGUI;
	}
}
