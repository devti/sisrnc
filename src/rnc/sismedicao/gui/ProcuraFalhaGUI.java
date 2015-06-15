package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.FalhaTableModel;
import rnc.sismedicao.model.beans.Falha;

public class ProcuraFalhaGUI extends JDialog {

	private JPanel contentPane;
	private JTextField tfPesquisa;
	private Fachada fachada;
	private ArrayList<Falha> lista;
	private JTable table;
	private FalhaTableModel ftm;
	private Falha falha = null;
	private JButton btnOk;
	private JComboBox cbAtributo;

	/**
	 * Create the frame.
	 */
	public ProcuraFalhaGUI() {
		setTitle("Procura Falha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbAtributo = new JComboBox();
		cbAtributo.setModel(new DefaultComboBoxModel(
				new String[] { "Descri\u00E7\u00E3o" }));
		cbAtributo.setSelectedIndex(0);
		cbAtributo.setBackground(Color.WHITE);
		cbAtributo.setBounds(10, 11, 115, 20);
		contentPane.add(cbAtributo);

		tfPesquisa = new JTextField();
		tfPesquisa.setColumns(10);
		tfPesquisa.setBounds(135, 11, 264, 20);
		contentPane.add(tfPesquisa);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(404, 10, 119, 23);
		contentPane.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					procurar();
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 513, 179);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(434, 247, 89, 23);
		contentPane.add(btnCancelar);

		btnOk = new JButton("Confirmar");
		btnOk.setBounds(341, 247, 89, 23);
		contentPane.add(btnOk);
	}

	public void procurar() throws RepositorioException {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.falhaPesquisaAvancada(cbAtributo.getSelectedItem()
					.toString(), tfPesquisa.getText());
			ftm = new FalhaTableModel(lista);
			table.setModel(ftm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					if (evt.getKeyCode() == 10 && table.getRowCount() > 0) {
						ok();
					}
				}
			});
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (IllegalArgumentException e) {
			btnOk.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	private void ok() {
		try {
			if (table.getSelectedRow() != -1) {
				fachada = Fachada.getInstance();
				int codFalha = (int) ftm.getValueAt(table.getSelectedRow(), 0);
				falha = fachada.falhaProcurar(codFalha);
				dispose();
			} else {
				JOptionPane.showMessageDialog(getContentPane(), "Selecione uma Opção", "Erro",
						JOptionPane.ERROR_MESSAGE);
			} 
		}  catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public Falha pegarFalha() {
		return falha;
	}
}
