package rnc.sismedicao.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

public class CadastroEquipamentoGUI extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private static CadastroEquipamentoGUI cadastroEquipamentoGUI;

	/**
	 * Create the frame.
	 */
	public CadastroEquipamentoGUI() {
		setTitle("Cadastro de Equipamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(22, 80, 215, 14);
		contentPane.add(lblDescrio);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		button.setBounds(10, 11, 30, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		button_1.setBounds(40, 11, 30, 30);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		button_2.setBounds(71, 11, 30, 30);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		button_3.setBounds(102, 11, 30, 30);
		contentPane.add(button_3);
		
		textField = new JTextField();
		textField.setBounds(22, 98, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		button_4.setBounds(135, 11, 30, 30);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setIcon(new ImageIcon(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		button_5.setBounds(168, 11, 30, 30);
		contentPane.add(button_5);
		
		JLabel lblSrie = new JLabel("S\u00E9rie:");
		lblSrie.setBounds(249, 80, 222, 14);
		contentPane.add(lblSrie);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(247, 98, 224, 20);
		contentPane.add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Equipamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 52, 476, 96);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 187, 476, 142);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 456, 110);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Item de Medi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 361, 476, 151);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 27, 456, 110);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(287, 513, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(382, 513, 89, 23);
		contentPane.add(btnCancelar);
	}


	public static CadastroEquipamentoGUI getInstance() {
		if (cadastroEquipamentoGUI == null) {
			return cadastroEquipamentoGUI = new CadastroEquipamentoGUI();
		}
		return cadastroEquipamentoGUI;
	}


	public void requestDefaultFocus() {
		
		
	}
}
