package rnc.sismedicao.gui;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ItemTableModel;
import rnc.sismedicao.model.beans.Item;

public class FinalizarOSGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Equipamento;
	private JTextField tf_Data;
	private JTable table;
	private ArrayList<Item> lista;
	private ItemTableModel itm;
	private Fachada fachada;

	
	/**
	 * Create the frame.
	 */
	public FinalizarOSGUI() {
		setTitle("Finaliza OS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_Equipamento = new JTextField();
		tf_Equipamento.setEditable(false);
		tf_Equipamento.setBounds(10, 11, 258, 20);
		contentPane.add(tf_Equipamento);
		tf_Equipamento.setColumns(10);
		
		tf_Data = new JTextField();
		tf_Data.setEditable(false);
		tf_Data.setColumns(10);
		tf_Data.setBounds(10, 42, 157, 20);
		contentPane.add(tf_Data);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Itens", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 73, 526, 129);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 506, 95);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		listarItemEquipamento();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Itens de Medi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 213, 526, 129);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 506, 95);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 370, 516, 75);
		contentPane.add(textArea);
		
		JLabel lb_Obs = new JLabel("Observa\u00E7\u00F5es:");
		lb_Obs.setBounds(19, 350, 74, 14);
		contentPane.add(lb_Obs);
	}

	private void listarItemEquipamento() {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.listarItemEquipamento();
			itm = new ItemTableModel(lista);
			table.setModel(itm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
