package rnc.sismedicao.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.UnidadeTableModel;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;

public class ProcuraUnidadeMedicaoGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private Fachada fachada;
	private UnidadeDeMedicao unidade = null;
	private JTextField tfPesquisa;
	private JTable table;
	private ArrayList<UnidadeDeMedicao> lista;
	private UnidadeTableModel utm;
	private JComboBox cbAtributo_2;
	private JButton btnOk;

	/**
	 * Create the frame.
	 */
	public ProcuraUnidadeMedicaoGUI() {
		setTitle("Procurar Unidade de Medi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 506, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		cbAtributo_2 = new JComboBox();
		cbAtributo_2.setToolTipText("");
		cbAtributo_2.setModel(new DefaultComboBoxModel(
				new String[] { "descricao" }));
		cbAtributo_2.setSelectedIndex(0);
		cbAtributo_2.setBackground(Color.WHITE);
		cbAtributo_2.setBounds(10, 11, 119, 20);
		contentPanel.add(cbAtributo_2);

		tfPesquisa = new JTextField();
		tfPesquisa.setColumns(10);
		tfPesquisa.setBounds(139, 11, 209, 20);
		contentPanel.add(tfPesquisa);

		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {

			@Override
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
		
		// Captura do ESC para fechar Janela
					JRootPane meurootpane = getRootPane();
					meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
							KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
					meurootpane.getRootPane().getActionMap()
							.put("ESCAPE", new AbstractAction("ESCAPE") {
								private static final long serialVersionUID = 1L;

								public void actionPerformed(ActionEvent e) {
									dispose();
								}
							});
		btPesquisar.setBounds(358, 10, 119, 23);
		contentPanel.add(btPesquisar);

		JScrollPane sp = new JScrollPane();
		sp.setBounds(10, 42, 470, 170);
		contentPanel.add(sp);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		sp.setViewportView(table);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(388, 221, 89, 23);
		contentPanel.add(btnCancelar);
		
		JButton btnOk = new JButton("Confirmar");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ok();
				
			}
		});
		btnOk.setBounds(271, 221, 106, 23);
		contentPanel.add(btnOk);

			
	}

	public void procurar() throws RepositorioException {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.unidadeDeMedicaoPesquisaAvancada(cbAtributo_2
					.getSelectedItem().toString(), tfPesquisa.getText());
			utm = new UnidadeTableModel(lista);
			table.setModel(utm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
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
				String codUnidade = (String) utm.getValueAt(table.getSelectedRow(), 0);
				unidade = fachada.unidadeProcurar(codUnidade);//a unidade está chegando aki .. eu vi
				dispose();
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Selecione uma Opção", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (PessoaNaoEncontradaException e) {//kkkkk
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

	public UnidadeDeMedicao pegarUnidade() {
		return unidade;
	}
}
