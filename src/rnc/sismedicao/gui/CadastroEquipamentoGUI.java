package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.EquipamentoJaCadastradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ItemTableModel;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.util.LimparCampos;
import java.awt.Toolkit;

public class CadastroEquipamentoGUI extends JDialog {

	private JPanel contentPane;
	private JTextField TF_Descricao;
	private JTextField TF_Serie;
	private JTextArea TF_OBS;
	private JTable table;
	private JTable table_1;
	private Fachada fachada;
	private ArrayList<Item> lista;
	private ArrayList<Item> listaItens = new ArrayList<Item>();
	private ArrayList<Item> listaItensAtualizacao = new ArrayList<Item>();
	private ItemTableModel itm;
	private ProcuraEquipamentoGUI tela;
	private Equipamento equipamento;
	private Component btnOk;
	private JButton btnRemover;
	private int codigoEquipamento = 0;
	private static CadastroEquipamentoGUI cadastroEquipamentoGUI;
	private JTextField TF_CodEquipamento;

	/**
	 * Create the frame.
	 */
	public CadastroEquipamentoGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/icone_Relogio.png")));
		setTitle("Cadastro de Equipamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(22, 80, 71, 14);
		contentPane.add(lblDescrio);

		JButton btnPrimeiro = new JButton("");
		btnPrimeiro
				.setIcon(new ImageIcon(
						CadastroEquipamentoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(10, 11, 30, 30);
		contentPane.add(btnPrimeiro);

		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(CadastroEquipamentoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(40, 11, 30, 30);
		contentPane.add(btnAnterior);

		JButton btnProximo = new JButton("");
		btnProximo
				.setIcon(new ImageIcon(
						CadastroEquipamentoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(71, 11, 30, 30);
		contentPane.add(btnProximo);

		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(CadastroEquipamentoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(102, 11, 30, 30);
		contentPane.add(btnUltimo);

		TF_Descricao = new JTextField();
		TF_Descricao.setBounds(22, 98, 215, 20);
		contentPane.add(TF_Descricao);
		TF_Descricao.setColumns(10);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(CadastroEquipamentoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(135, 11, 30, 30);
		contentPane.add(btnPesquisar);

		btnRemover = new JButton("");
		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnRemover.setEnabled(false);
		btnRemover
				.setIcon(new ImageIcon(
						CadastroEquipamentoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setBounds(168, 11, 30, 30);
		contentPane.add(btnRemover);

		JLabel lblSrie = new JLabel("S\u00E9rie:");
		lblSrie.setBounds(249, 80, 222, 14);
		contentPane.add(lblSrie);

		TF_Serie = new JTextField();
		TF_Serie.setColumns(10);
		TF_Serie.setBounds(247, 98, 224, 20);
		contentPane.add(TF_Serie);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Equipamento",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 52, 476, 180);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o:");
		lblObservao.setBounds(10, 75, 85, 14);
		panel.add(lblObservao);

		TF_OBS = new JTextArea();
		TF_OBS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		TF_OBS.setRows(4);
		TF_OBS.setBounds(10, 94, 449, 55);
		panel.add(TF_OBS);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 243, 476, 142);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 456, 110);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		listar();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Item de Medi\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 417, 476, 151);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 27, 456, 110);
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setBorder(new MatteBorder(1, 1, 1, 1,
				(Color) new Color(0, 0, 0)));
		table_1.setFillsViewportHeight(true);
		table_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table_1);

		table_1.setModel(new ItemTableModel());

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();

			}
		});
		btnSalvar.setBounds(287, 577, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(382, 577, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limparTela();
				dispose();

			}
		});

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fachada = Fachada.getInstance();//
					Item item = fachada.itemProcurar((int) table.getModel()
							.getValueAt(table.getSelectedRow(), 0));
					boolean entrou = false;
					for (int i = 0; i < listaItens.size(); i++) {
						if (listaItens.get(i).getCodItem() == item.getCodItem())
							entrou = true;
					}
					if (!entrou) {
						if (codigoEquipamento == 0) {
							listaItens.add(item);
						}else {
							listaItensAtualizacao.add(item);
							equipamento.setItens(listaItensAtualizacao);
							fachada.cadastraEquipamentoItem(equipamento);
							listaItens.add(item);
							listaItensAtualizacao.remove(item);
						}
					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Item ja existente", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
					table_1.setModel(new ItemTableModel(listaItens));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdicionar.setIcon(new ImageIcon(CadastroEquipamentoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Down.png")));
		btnAdicionar.setBounds(415, 387, 30, 30);
		contentPane.add(btnAdicionar);

		TF_CodEquipamento = new JTextField();
		TF_CodEquipamento.setEnabled(false);
		TF_CodEquipamento.setBounds(400, 21, 86, 20);
		contentPane.add(TF_CodEquipamento);
		TF_CodEquipamento.setColumns(10);

		JLabel LB_CodEquipamento = new JLabel("Codigo do Equipamento");
		LB_CodEquipamento.setBounds(249, 24, 145, 14);
		contentPane.add(LB_CodEquipamento);

		JButton btn_RemoverIM = new JButton("");
		btn_RemoverIM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fachada = Fachada.getInstance();
					Item item = fachada.itemProcurar((int) table_1.getModel()
							.getValueAt(table_1.getSelectedRow(), 0));
					for (int cont = 0; cont < listaItens.size(); cont++) {
						item = listaItens.get(cont);
					}
					if (JOptionPane.showConfirmDialog(null,
							"Deseja realmente EXCLUIR este item de Medicao ?",
							"Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (codigoEquipamento == 0) {
							listaItens.remove(item);
						} else {
							fachada.removerItemEquipamento(item.getCodItem());
							listaItens.remove(item);
						}
					} else {

					}
					listarItem(listaItens);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btn_RemoverIM
				.setIcon(new ImageIcon(
						CadastroEquipamentoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		btn_RemoverIM.setBounds(449, 387, 30, 30);
		contentPane.add(btn_RemoverIM);
	}

	protected void excluir() {
		try {
			fachada = Fachada.getInstance();
			if (JOptionPane.showConfirmDialog(this,
					"Tem certeza que deseja excluir o Equipamento?",
					"Confirmação", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
				fachada.equipamentoItemRemover(Integer
						.parseInt(TF_CodEquipamento.getText()));
				fachada.equipamentoRemover(Integer.parseInt(TF_CodEquipamento
						.getText()));
				LimparCampos.limparCampos(getContentPane());
				JOptionPane.showMessageDialog(this, "Removido com sucesso!",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				btnRemover.setEnabled(false);
				limparTela();
			} else {

			}
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void procurar() {
		tela = new ProcuraEquipamentoGUI();
		tela.setVisible(true);
		if (tela.getFocusableWindowState() && tela.pegarEquipamento() != null) {
			equipamento= tela.pegarEquipamento();
			TF_Descricao.setText(equipamento.getDescricao());
			TF_OBS.setText(equipamento.getObs());
			TF_Serie.setText(equipamento.getRegistro());
			TF_CodEquipamento.setText(Integer.toString(equipamento.getCodEquipamento()));
			codigoEquipamento = equipamento.getCodEquipamento();
			listaItens = tela.pegarItens();
			listarItem(listaItens);
			btnRemover.setEnabled(true);
		}
	}

	public void salvar() {
		try {
			if (TF_Descricao.getText().isEmpty() || TF_OBS.getText().isEmpty()
					|| TF_Serie.getText().isEmpty())
				throw new DadosObrigatoriosException();
			fachada = Fachada.getInstance();
			Equipamento equipamento = new Equipamento(codigoEquipamento ,TF_Serie.getText(),
					TF_Descricao.getText(), TF_OBS.getText());
			if (codigoEquipamento == 0) {
				equipamento.setItens(listaItens);
				fachada.cadastrar(equipamento);
				JOptionPane.showMessageDialog(null,
						"Equipamento cadastrado com sucesso!");

			} else {
				fachada.atualizarEquipamento(equipamento);
				JOptionPane.showMessageDialog(null, "Equipamento atualizado!");
			}

			limparTela();
		} catch (EquipamentoJaCadastradoException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (DadosObrigatoriosException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void listarItem(ArrayList<Item> listaItem) {
		try {
			itm = new ItemTableModel(listaItem);
			table_1.setModel(itm);
			table_1.setModel(new ItemTableModel(listaItem));
			table_1.setVisible(true);
			table_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					if (evt.getKeyCode() == 10 && table_1.getRowCount() > 0) {
						ok();
					}
				}
			});
		} catch (IllegalArgumentException e) {
			btnOk.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	protected void ok() {
		// TODO Auto-generated method stub

	}

	/**
	 * lista o itens a serem associado ao equipamento
	 */
	private void listar() {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.listarItem();
			itm = new ItemTableModel(lista);
			table.setModel(itm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			btnOk.setEnabled(false);
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

	/**
	 * limpa o campos de toda a tela
	 */
	public void limparTela() {
		TF_Descricao.setText(null);
		TF_OBS.setText(null);
		TF_Serie.setText(null);
		listaItens.clear();
		listarItem(listaItens);
		codigoEquipamento = 0;
		TF_CodEquipamento.setText(null);
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
