package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import jdk.nashorn.internal.scripts.JO;
import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.UsuarioJaCadastradoException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;
import rnc.sismedicao.model.beans.Pessoa;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.util.LimparCampos;

public class CadastroUsuarioGUI extends NewJFrameForm implements InterfaceFormGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TF_Login;
	private JPasswordField PF_Senha;
	private JTextField TF_Pessoa;
	private Usuario usuario;
	private Fachada fachada;
	private ProcuraPessoaGUI tela;
	private ProcuraUsuarioGUI tpu;

	private static CadastroUsuarioGUI formUsuarioGui;

	private static final int TELA_WIDTH = 500;
	private static final int TELA_HEIGTH = 300;
	private JTextField TF_CodPessoa;
	private JButton btnRemover;


	public static CadastroUsuarioGUI getInstance() {
		if (formUsuarioGui == null) {
			formUsuarioGui = new CadastroUsuarioGUI();
		}
		return formUsuarioGui;
	}

	private CadastroUsuarioGUI() {
		// setBounds(0, 0, 370, 280);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		setMinimumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));
		setMaximumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));

		setTitle("Cadastrar Usuário");

		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH,
				TELA_HEIGTH, false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 49, 460, 171);
		getContentPane().add(panel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 0, 440, 171);
		panel.add(tabbedPane);

		JPanel PN_Identificacao = new JPanel();
		PN_Identificacao.setLayout(null);
		PN_Identificacao.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, PN_Identificacao,
				null);

		JLabel LB_Pessoa = new JLabel("Pessoa:");
		LB_Pessoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Pessoa.setBounds(10, 8, 46, 14);
		PN_Identificacao.add(LB_Pessoa);

		JLabel LB_Login = new JLabel("Login:");
		LB_Login.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Login.setBounds(10, 47, 46, 14);
		PN_Identificacao.add(LB_Login);

		JLabel LB_Senha = new JLabel("Senha:");
		LB_Senha.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Senha.setBounds(10, 86, 46, 14);
		PN_Identificacao.add(LB_Senha);

		TF_Login = new NewJTextField();
		TF_Login.setColumns(10);
		TF_Login.setBounds(10, 62, 147, 20);
		PN_Identificacao.add(TF_Login);

		PF_Senha = new JPasswordField();
		PF_Senha.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211,
				211, 211), null, null, null));
		PF_Senha.setBounds(10, 102, 147, 20);
		PN_Identificacao.add(PF_Senha);

		TF_Pessoa = new NewJTextField();
		TF_Pessoa.setEditable(false);
		TF_Pessoa.setColumns(10);
		TF_Pessoa.setBounds(10, 23, 282, 20);
		PN_Identificacao.add(TF_Pessoa);

		TF_CodPessoa = new JTextField();
		TF_CodPessoa.setEditable(false);
		TF_CodPessoa.setBounds(195, 62, 97, 20);
		PN_Identificacao.add(TF_CodPessoa);
		TF_CodPessoa.setColumns(10);

		JButton BT_PesquisaPessoa = new JButton("");
		BT_PesquisaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}

		});
		BT_PesquisaPessoa
				.setIcon(new ImageIcon(
						CadastroUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		BT_PesquisaPessoa.setBounds(297, 23, 27, 22);
		PN_Identificacao.add(BT_PesquisaPessoa);

		JLabel LB_CodPessoa = new JLabel("Codigo:");
		LB_CodPessoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_CodPessoa.setBounds(195, 47, 46, 14);
		PN_Identificacao.add(LB_CodPessoa);

		JPanel PN_Pessoa = new JPanel();
		PN_Pessoa.setBackground(Color.WHITE);
		tabbedPane.addTab("Pessoa", null, PN_Pessoa, null);

		btnRemover = new JButton("");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluir();
			}
		});
		btnRemover
				.setIcon(new ImageIcon(
						CadastroUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setBounds(172, 8, 30, 30);
		getContentPane().add(btnRemover);

		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(270, 231, 89, 23);
		getContentPane().add(BT_Salvar);

		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.setBounds(369, 231, 89, 23);
		getContentPane().add(BT_Cancelar);
		BT_Cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

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

		JButton btnPrimeiro = new JButton("");
		btnPrimeiro
				.setIcon(new ImageIcon(
						CadastroUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(10, 8, 30, 30);
		getContentPane().add(btnPrimeiro);

		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(CadastroUsuarioGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(42, 8, 30, 30);
		getContentPane().add(btnAnterior);

		JButton btnProximo = new JButton("");
		btnProximo
				.setIcon(new ImageIcon(
						CadastroUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(74, 8, 30, 30);
		getContentPane().add(btnProximo);

		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(CadastroUsuarioGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(107, 8, 30, 30);
		getContentPane().add(btnUltimo);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarUsuario();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(CadastroUsuarioGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(139, 8, 30, 30);
		getContentPane().add(btnPesquisar);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(
				CadastroUsuarioGUI.class
						.getResource("/rnc/sismedicao/gui/icons/icons16x16/clear 1.png")));
		button.setBounds(206, 8, 30, 30);
		getContentPane().add(button);
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BT_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});

	}

	@Override
	public void requestDefaultFocus() {
		TF_Login.requestFocus();

	}

	public void procurar() {
		tela = new ProcuraPessoaGUI();
		tela.setVisible(true);
		if (tela.getFocusableWindowState() && tela.pegarPessoa() != null) {
			Pessoa p = tela.pegarPessoa();
			TF_Pessoa.setText(p.getNome());
			TF_CodPessoa.setText(Integer.toString(p.getCodPessoa()));
		}
	}

	public void pesquisarUsuario() {
		tpu = new ProcuraUsuarioGUI();
		tpu.setVisible(true);
		if (tpu.getFocusableWindowState() && tpu.pegarUsuario() != null) {
			Usuario u = tpu.pegarUsuario();
			TF_Pessoa.setText(u.getNome());
			TF_Login.setText(u.getLogin());
			TF_CodPessoa.setText(Integer.toString(u.getCodPessoa()));
			btnRemover.setEnabled(true);
		}
	}

	public void salvar() {
		try {
			// obriga a preencher os campos
			if (TF_Login.getText().isEmpty()
					|| TF_CodPessoa.getText().isEmpty()
					|| TF_Pessoa.getText().isEmpty())
				throw new DadosObrigatoriosException();
			fachada = Fachada.getInstance();
			usuario = new Usuario(TF_Login.getText(), new String(
					PF_Senha.getPassword()), TF_Pessoa.getText());
			usuario.setCodPessoa(Integer.parseInt(TF_CodPessoa.getText()));
			// verifica se e novo ou alteracao e manda para o metodo na fachada
			fachada.cadastrar(usuario);
			JOptionPane.showMessageDialog(null,
					"Usuario cadastrado com sucesso!");
		} catch (UsuarioJaCadastradoException e) {
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
					"Tem certeza que deseja excluir o usuario?", "Confirmação",
					JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
				fachada.usuarioRemover(Integer.parseInt(TF_CodPessoa.getText()));
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
