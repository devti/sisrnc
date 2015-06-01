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
import rnc.sismedicao.model.beans.OrdemServico;
import java.awt.Font;
import javax.swing.JButton;

public class FinalizarOSGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_CodEquip;
	private JTextField tf_DescEquipamento;
	private JTable table;
	private ArrayList<Item> lista;
	private ItemTableModel itm;
	private Fachada fachada;

	
	/**
	 * Create the frame.
	 */
	public FinalizarOSGUI(OrdemServico os) {
		setTitle("Finaliza OS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_CodEquip = new JTextField();
		tf_CodEquip.setEditable(false);
		tf_CodEquip.setBounds(10, 26, 56, 20);
		contentPane.add(tf_CodEquip);
		tf_CodEquip.setColumns(10);
		
		tf_CodEquip.setText(Integer.toString(os.getEquipamento().getCodEquipamento()));
		
		tf_DescEquipamento = new JTextField();
		tf_DescEquipamento.setEditable(false);
		tf_DescEquipamento.setColumns(10);
		tf_DescEquipamento.setBounds(9, 75, 178, 20);
		contentPane.add(tf_DescEquipamento);
		
		tf_DescEquipamento.setText(os.getEquipamento().getDescricao());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Itens", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 109, 526, 129);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 506, 95);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		table.setModel(new ItemTableModel(os.getEquipamento().getItens()));
		
		//listarItemEquipamento();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Itens de Medi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 249, 526, 129);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 506, 95);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 406, 516, 75);
		contentPane.add(textArea);
		
		JLabel lb_Obs = new JLabel("Observa\u00E7\u00F5es:");
		lb_Obs.setBounds(19, 386, 74, 14);
		contentPane.add(lb_Obs);
		
		JLabel lbCodEquipamento = new JLabel("C\u00F3digo Equipamento");
		lbCodEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbCodEquipamento.setBounds(10, 11, 128, 14);
		contentPane.add(lbCodEquipamento);
		
		JLabel lbDescricaoEquipamento = new JLabel("Equipamento");
		lbDescricaoEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbDescricaoEquipamento.setBounds(10, 55, 128, 14);
		contentPane.add(lbDescricaoEquipamento);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(447, 515, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(352, 515, 89, 23);
		contentPane.add(btnSalvar);
	}

	private void listarItemEquipamento() {
		/*
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
		*/
		
	}
}
