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
import javax.swing.JFrame;
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

import rnc.sismedicao.controller.exception.ItemNaoEncontradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ItemTableModel;
import rnc.sismedicao.gui.util.PlanoDeMedicaoTableModel;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.beans.PlanoDeMedicao;

public class ProcuraPlanoDeMedicaoGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Fachada fachada;
	private JTextField tfPesquisa;
	private JButton btnOk;
	private PlanoDeMedicaoTableModel pln;
	private PlanoDeMedicao planoDeMedicao = null;
	private ArrayList<PlanoDeMedicao> listaPlanoDeMedicao = null;
	private JComboBox cbAtributo;

	/**
	 * Create the frame.
	 */
	public ProcuraPlanoDeMedicaoGUI() {
		setTitle("Procurar Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 537, 309);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbAtributo = new JComboBox();
		cbAtributo.setBackground(Color.WHITE);
		cbAtributo.setModel(new DefaultComboBoxModel(new String[] { "Descricao", "NomeGrupoTecnico", "DescricaoEquipamento"}));
		cbAtributo.setSelectedIndex(0);
		cbAtributo.setToolTipText("");
		cbAtributo.setBounds(10, 11, 119, 20);
		contentPane.add(cbAtributo);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(10, 54, 501, 170);
		contentPane.add(sp);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		sp.setViewportView(table);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		btnOk.setBounds(306, 239, 89, 23);
		contentPane.add(btnOk);
		
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
		btnPesquisar.setBounds(375, 10, 119, 23);
		contentPane.add(btnPesquisar);

		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(139, 11, 209, 20);
		contentPane.add(tfPesquisa);
		tfPesquisa.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(405, 239, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		contentPane.add(btnCancelar);
	}

	public void procurar() throws RepositorioException {
		try {			
			fachada = Fachada.getInstance();
			listaPlanoDeMedicao = fachada.planoDeMedicaoPesquisaAvancada(cbAtributo.getSelectedItem().toString(), tfPesquisa.getText());
			pln = new PlanoDeMedicaoTableModel(listaPlanoDeMedicao);
			table.setModel(pln);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			//table.getColumnModel().getColumn(4).setPreferredWidth(150); 
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
				int codigo = (int) pln.getValueAt(table.getSelectedRow(), 0);
				planoDeMedicao = fachada.planoDeMedicaoProcurar(codigo);
				dispose();
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Selecione uma Opção", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (ItemNaoEncontradoException e) {
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
	
	public PlanoDeMedicao pegarPlanoDeMedicao(){
		return planoDeMedicao;
	}
	public ArrayList<PlanoDeMedicao> pegarPlanoDeMedicoes(){
		return listaPlanoDeMedicao;
	}

}
