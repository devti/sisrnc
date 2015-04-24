package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;

import rnc.sismedicao.controller.exception.PessoaNaoEncontradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.PessoaTableModel;
import rnc.sismedicao.gui.util.UsuarioTableModel;
import rnc.sismedicao.model.beans.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProcuraUsuarioGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfPesquisa;
	private ArrayList<Usuario> lista;
	private UsuarioTableModel utm;
	private JTable table;
	private Fachada fachada;
	private JButton btnOk;
	private Usuario usuario = null;
	private JComboBox cbAtributo_1;

	/**
	 * Create the dialog.
	 */
	public ProcuraUsuarioGUI() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Procurar Usuario");
		setBounds(100, 100, 539, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cbAtributo_1 = new JComboBox();
		cbAtributo_1.setToolTipText("");
		cbAtributo_1
				.setModel(new DefaultComboBoxModel(new String[] { "Login", "Nome" }));
		cbAtributo_1.setSelectedIndex(0);
		cbAtributo_1.setBackground(Color.WHITE);
		cbAtributo_1.setBounds(10, 11, 119, 20);
		contentPanel.add(cbAtributo_1);
		{
			tfPesquisa = new JTextField();
			tfPesquisa.setColumns(10);
			tfPesquisa.setBounds(139, 11, 209, 20);
			contentPanel.add(tfPesquisa);
		}
		{
			JButton btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						procurar();
					} catch (RepositorioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
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
			btnPesquisar.setBounds(358, 10, 119, 23);
			contentPanel.add(btnPesquisar);
		}
		{
			JScrollPane sp = new JScrollPane();
			sp.setBounds(10, 48, 501, 170);
			contentPanel.add(sp);
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setFillsViewportHeight(true);
				table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(
						0, 0, 0)));
				table.setBackground(Color.WHITE);
				sp.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btOk = new JButton("Confirmar");
				btOk.setActionCommand("OK");
				buttonPane.add(btOk);
				getRootPane().setDefaultButton(btOk);
				btOk.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ok();

					}
				});
			}
			{
				JButton btCancelar = new JButton("Cancel");
				btCancelar.setActionCommand("Cancel");
				buttonPane.add(btCancelar);
			}
		}
	}

	private void procurar() throws RepositorioException {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.usuarioPesquisaAvancada(cbAtributo_1
					.getSelectedItem().toString(), tfPesquisa.getText());
			utm = new UsuarioTableModel(lista);
			table.setModel(utm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(30);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
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
				int codPessoa = (int) utm.getValueAt(table.getSelectedRow(), 1);
				usuario = fachada.usuarioProcurar(codPessoa);
				dispose();
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Selecione uma Opção", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (PessoaNaoEncontradaException e) {
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

	public Usuario pegarUsuario() {
		return usuario;
	}

}
