/**
 * 
 */
package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.PessoaJaCadastradaException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.util.LimparCampos;
import rnc.sismedicao.model.util.VerificadoresEFormatadores;

import javax.swing.JTextField;

/**
 * @author Administrador
 *
 */
@SuppressWarnings("serial")
public class FormPessoaGUI extends NewJFrameForm implements InterfaceFormGUI {

	private NewJTextField TF_Nome;
	private NewJTextField TF_Email;
	private NewJTextField TF_Endereco;
	private NewJTextField TF_Numero;
	private NewJTextField TF_Bairro;
	private NewJTextField TF_Cidade;
	private Fachada fachada;
	private ProcuraPessoaGUI tela;
	private Pessoa pessoa;
	private JFormattedTextField FT_CPF;
	private JFormattedTextField FT_Telefone;
	private JButton btnRemover;

	private JTable TB_Endereco;

	private JTabbedPane tabbedPane;

	private static FormPessoaGUI formPessoaGUI;

	private static final int TELA_WIDTH = 520;
	private static final int TELA_HEIGTH = 380;

	private DefaultTableModel enderecoDefaultTableModel;
	private JTextField TF_CodPessoa;

	public static FormPessoaGUI getInstance() {
		if (formPessoaGUI == null) {
			return formPessoaGUI = new FormPessoaGUI();
		}
		return formPessoaGUI;
	}

	private FormPessoaGUI() {
		setTitle("Cadastrar Pessoa");

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 50, 478, 237);
		getContentPane().add(tabbedPane);

		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH,
				TELA_HEIGTH, false);

		JPanel PN_Identificacao = new JPanel();
		PN_Identificacao.setLayout(null);
		PN_Identificacao.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, PN_Identificacao,
				null);

		JLabel LB_Nome = new JLabel("Nome:");
		LB_Nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Nome.setBounds(10, 11, 49, 14);
		PN_Identificacao.add(LB_Nome);

		TF_Nome = new NewJTextField();
		TF_Nome.setColumns(10);
		TF_Nome.setBounds(10, 25, 290, 20);
		PN_Identificacao.add(TF_Nome);

		JLabel LB_CPF = new JLabel("CPF:");
		LB_CPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_CPF.setBounds(10, 50, 33, 14);
		PN_Identificacao.add(LB_CPF);

		FT_CPF = new JFormattedTextField(
				VerificadoresEFormatadores
						.setDefaultMaskFormat(VerificadoresEFormatadores.CPF_FORMAT));
		FT_CPF.setColumns(10);
		ConfiguracaoDeComponentesGUI.configuraJTextField(FT_CPF);
		FT_CPF.setBounds(10, 64, 144, 20);
		PN_Identificacao.add(FT_CPF);

		JLabel LB_Email = new JLabel("Email:");
		LB_Email.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Email.setBounds(10, 117, 33, 14);
		PN_Identificacao.add(LB_Email);

		TF_Email = new NewJTextField();
		TF_Email.setColumns(10);
		TF_Email.setBounds(10, 131, 393, 20);
		PN_Identificacao.add(TF_Email);

		JLabel LB_Telefone = new JLabel("Telefone:");
		LB_Telefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Telefone.setBounds(10, 158, 60, 14);
		PN_Identificacao.add(LB_Telefone);

		FT_Telefone = new JFormattedTextField(
				VerificadoresEFormatadores
						.setDefaultMaskFormat(VerificadoresEFormatadores.FONE_FORMAT));
		FT_Telefone.setColumns(10);
		ConfiguracaoDeComponentesGUI.configuraJTextField(FT_Telefone);
		FT_Telefone.setBounds(10, 172, 125, 20);
		PN_Identificacao.add(FT_Telefone);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(56, 100, 347, 8);
		PN_Identificacao.add(separator);

		JLabel LB_Contato = new JLabel("Contato");
		LB_Contato.setForeground(Color.LIGHT_GRAY);
		LB_Contato.setBounds(13, 94, 46, 14);
		PN_Identificacao.add(LB_Contato);

		JLabel LB_Codigo = new JLabel("Codigo:");
		LB_Codigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Codigo.setBounds(319, 11, 49, 14);
		PN_Identificacao.add(LB_Codigo);

		TF_CodPessoa = new JTextField();
		TF_CodPessoa.setEditable(false);
		TF_CodPessoa.setBounds(317, 25, 86, 20);
		PN_Identificacao.add(TF_CodPessoa);
		TF_CodPessoa.setColumns(10);

		JPanel PN_Endereco = new JPanel();
		PN_Endereco.setBackground(Color.WHITE);
		tabbedPane.addTab("Endere\u00E7o", null, PN_Endereco, null);
		PN_Endereco.setLayout(null);

		JScrollPane SP_TBEndereco = new JScrollPane();
		SP_TBEndereco.setBounds(10, 129, 429, 69);
		PN_Endereco.add(SP_TBEndereco);

		TB_Endereco = new JTable();
		TB_Endereco.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Endere\u00E7o", "N\u00FAmero", "Bairro",
						"Cidade", "CEP" }) {
			boolean[] columnEditables = new boolean[] { false, true, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		SP_TBEndereco.setViewportView(TB_Endereco);
		enderecoDefaultTableModel = (DefaultTableModel) TB_Endereco.getModel();

		JLabel LB_Endereco = new JLabel("Endere\u00E7o:");
		LB_Endereco.setBounds(10, 11, 49, 14);
		PN_Endereco.add(LB_Endereco);

		JLabel LB_Bairro = new JLabel("Bairro:");
		LB_Bairro.setBounds(62, 51, 49, 14);
		PN_Endereco.add(LB_Bairro);

		JLabel LB_Cidade = new JLabel("Cidade:");
		LB_Cidade.setBounds(249, 51, 46, 14);
		PN_Endereco.add(LB_Cidade);

		JLabel LB_Numero = new JLabel("N\u00FAmero:");
		LB_Numero.setBounds(10, 51, 46, 14);
		PN_Endereco.add(LB_Numero);

		TF_Endereco = new NewJTextField();
		TF_Endereco.setBounds(10, 27, 429, 18);
		PN_Endereco.add(TF_Endereco);

		TF_Numero = new NewJTextField();
		TF_Numero.setBounds(10, 65, 49, 18);
		PN_Endereco.add(TF_Numero);

		TF_Bairro = new NewJTextField();
		TF_Bairro.setBounds(62, 65, 180, 18);
		PN_Endereco.add(TF_Bairro);

		TF_Cidade = new NewJTextField();
		TF_Cidade.setBounds(249, 65, 191, 18);
		PN_Endereco.add(TF_Cidade);

		JButton BT_Adicionar = new JButton("Adicionar Novo");
		BT_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enderecoDefaultTableModel.addRow(getEnderecoForm());
				limparEnderecoForm();
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
		BT_Adicionar.setBounds(123, 96, 119, 23);
		PN_Endereco.add(BT_Adicionar);

		JButton BT_Remover = new JButton("Remover");
		BT_Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		BT_Remover.setBounds(349, 96, 89, 23);
		PN_Endereco.add(BT_Remover);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(247, 96, 100, 23);
		PN_Endereco.add(btnSalvar);

		JLabel LB_Limpar = new JLabel("Novo");
		LB_Limpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				limparEnderecoForm();
			}
		});
		LB_Limpar
				.setToolTipText("Limpa o formul\u00E1rio para incluir um novo endere\u00E7o.");
		LB_Limpar.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Limpar.setAlignmentX(Component.CENTER_ALIGNMENT);
		LB_Limpar
				.setIcon(new ImageIcon(
						FormPessoaGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		LB_Limpar.setBounds(381, 3, 69, 20);
		ConfiguracaoDeComponentesGUI.CriarButtonBevelDeLabel(LB_Limpar);
		PN_Endereco.add(LB_Limpar);

		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});

		BT_Salvar.setBounds(304, 298, 89, 23);
		getContentPane().add(BT_Salvar);

		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BT_Cancelar.setBounds(399, 298, 89, 23);
		getContentPane().add(BT_Cancelar);

		JButton brnPrimeiro = new JButton("");
		brnPrimeiro.setIcon(new ImageIcon(FormPessoaGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		brnPrimeiro.setBounds(10, 9, 30, 30);
		getContentPane().add(brnPrimeiro);

		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(FormPessoaGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(42, 9, 30, 30);
		getContentPane().add(btnAnterior);

		JButton btnProximo = new JButton("");
		btnProximo.setIcon(new ImageIcon(
				FormPessoaGUI.class
						.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(75, 9, 30, 30);
		getContentPane().add(btnProximo);

		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(FormPessoaGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(107, 9, 30, 30);
		getContentPane().add(btnUltimo);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(FormPessoaGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(141, 9, 30, 30);
		getContentPane().add(btnPesquisar);

		btnRemover = new JButton("");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				excluir();
				
			}
		});
		btnRemover.setIcon(new ImageIcon(
						FormPessoaGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setBounds(174, 9, 30, 30);
		getContentPane().add(btnRemover);
	}

	private Object[] getEnderecoForm() {
		return new Object[] { TF_Endereco.getText(), TF_Numero.getText(),
				TF_Bairro.getText(), TF_Cidade.getText() };
	}

	@Override
	public void requestDefaultFocus() {
		tabbedPane.setSelectedIndex(0);
		TF_Nome.requestFocus();
	}

	private void limparEnderecoForm() {
		TF_Endereco.setText("");
		TF_Numero.setText("");
		TF_Bairro.setText("");
		TF_Cidade.setText("");

		TF_Endereco.requestFocus();
	}

	public void procurar() {
		tela = new ProcuraPessoaGUI();
		tela.setVisible(true);
		if (tela.getFocusableWindowState() && tela.pegarPessoa() != null) {
			Pessoa p = tela.pegarPessoa();
			TF_Nome.setText(p.getNome());
			TF_CodPessoa.setText(Integer.toString(p.getCodPessoa()));
			TF_Email.setText(p.getEmail());
			FT_CPF.setText(p.getCpf());
			FT_Telefone.setText(p.getTelefone());
			btnRemover.setEnabled(true);
		}
	}

	public void salvar() {
		try {
			// obriga a preencher todos os campos
			if (TF_Nome.getText().isEmpty() || TF_Email.getText().isEmpty()
					|| FT_CPF.getText().isEmpty()
					|| FT_Telefone.getText().isEmpty())
				throw new DadosObrigatoriosException();
			// instacia a fachada
			fachada = Fachada.getInstance();
			// constroi a pessoa
			pessoa = new Pessoa(TF_Nome.getText(), FT_CPF.getText(),
					TF_Email.getText(), FT_Telefone.getText());
			// verifica se é alteração ou novo usuario e manda para seu
			// respectivo metodo na fachada
			fachada.cadastrar(pessoa);
			JOptionPane.showMessageDialog(null,
					"Pessoa cadastrada com sucesso!");
		} catch (PessoaJaCadastradaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {

		} catch (DadosObrigatoriosException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void excluir() {
		try {
			fachada = Fachada.getInstance();
			if (JOptionPane.showConfirmDialog(this,
					"Tem certeza que deseja excluir a pessoa?", "Confirmação",
					JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
				fachada.pessoaRemover(Integer.parseInt(TF_CodPessoa.getText()));
				LimparCampos.limparCampos(getContentPane());
				JOptionPane.showMessageDialog(this, "Removido com Sucesso",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				btnRemover.setEnabled(false);
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
}
