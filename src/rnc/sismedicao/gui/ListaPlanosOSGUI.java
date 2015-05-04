package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ListaPlanosOSGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListaPlanosOSGUI() {
		setTitle("Planos em Aberto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Leituras de Medi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 51, 573, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 19, 553, 185);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ListaPlanosOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Refresh.png")));
		btnNewButton.setBounds(20, 6, 30, 30);
		contentPane.add(btnNewButton);
	}
}
