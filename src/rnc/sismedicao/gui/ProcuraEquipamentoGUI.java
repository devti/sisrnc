package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import rnc.sismedicao.controller.exception.EquipamentoNaoEncontrandoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.EquipamentoTableModel;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.beans.Item;

public class ProcuraEquipamentoGUI extends JDialog {

	private JPanel contentPane;
	private JTextField tfPesquisa;
	private JScrollPane sp;
	private JTable table;
	private JButton btnCancelar;
	private Fachada fachada;
	private JButton btnConfirmar;
	private JButton btnOk;
	private ArrayList<Equipamento> lista;
	private JComboBox cbAtributo;
	private Equipamento equipamento = null;
	private ArrayList<Item> listaItens = null;
	private EquipamentoTableModel etm;

	/**
	 * Create the frame.
	 */
	public ProcuraEquipamentoGUI() {
		setTitle("Procura Equipamento");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbAtributo = new JComboBox();
		cbAtributo.setBackground(Color.WHITE);
		cbAtributo.setModel(new DefaultComboBoxModel(new String[] {"Registro"}));
		cbAtributo.setSelectedIndex(0);
		cbAtributo.setBounds(10, 11, 115, 20);
		contentPane.add(cbAtributo);

		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(135, 11, 264, 20);
		contentPane.add(tfPesquisa);
		tfPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					procurar();
				} catch (RepositorioException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		
		btnPesquisar.setBounds(415, 10, 119, 23);
		contentPane.add(btnPesquisar);

		sp = new JScrollPane();
		sp.setBounds(10, 57, 524, 170);
		contentPane.add(sp);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		sp.setViewportView(table);
		
		// Captura do ESC para fechar Janela
				JRootPane meurootpane = getRootPane();
				meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
				meurootpane.getRootPane().getActionMap()
						.put("ESCAPE", new AbstractAction("ESCAPE") {
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCancelar.setBounds(445, 235, 89, 23);
		contentPane.add(btnCancelar);

		btnConfirmar = new JButton("OK");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ok();
			}
		});
		btnConfirmar.setBounds(352, 235, 89, 23);
		contentPane.add(btnConfirmar);
	}

	public void procurar() throws RepositorioException {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.equipamentoPesquisaAvancada(cbAtributo
					.getSelectedItem().toString(), tfPesquisa.getText());
			etm = new EquipamentoTableModel(lista);
			table.setModel(etm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
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
				int codEquipamento = (int) etm.getValueAt(
						table.getSelectedRow(), 0);
				equipamento = fachada.equipamentoProcurar(codEquipamento);
				listaItens = fachada.procurarEquipamentoItem(codEquipamento);	
				dispose();
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Selecione uma Opção", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (EquipamentoNaoEncontrandoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
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

	public Equipamento pegarEquipamento() {
		return equipamento;
	}

	public ArrayList<Item> pegarItens() {
		return listaItens;
	}
	
}
