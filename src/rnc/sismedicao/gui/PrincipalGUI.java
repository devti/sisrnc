package rnc.sismedicao.gui;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.DesktopBackgroundGUI;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

@SuppressWarnings("serial")
public class PrincipalGUI extends JFrame {

	private JPanel contentPane;
	private FormUnidadeDeMedicaoGUI formUnidadeDeMedicaoGUI;
	private FormEquipamentoGUI formEquipamentoGUI;
	private FormPessoaGUI formPessoaGUI;
	private CadastroItemGUI cadastroItemGUI;
	private CadastroEquipamentoGUI cadastroEquipamentoGUI;
	private String usuario;
	private Fachada fachada;

	private DesktopBackgroundGUI desktopBackgroundGUI;

	private static final int TELA_WIDTH = 1280;
	private static final int TELA_HEIGTH = 700;

	
	/**
	 * Create the frame.
	 */
	public PrincipalGUI() {

		getContentPane().setLayout(new GridLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setTitle("SisMedi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension());
		setMaximumSize(new Dimension());
		//setMinimumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));
		//setMaximumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));

		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH,
				TELA_HEIGTH);

		try {
			fachada = Fachada.getInstance();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Login",
					JOptionPane.ERROR_MESSAGE);
		}

		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar.setIgnoreRepaint(true);
		setJMenuBar(menuBar);

		JMenu MN_Arquivo = new JMenu("Arquivo");
		MN_Arquivo.setDoubleBuffered(true);
		menuBar.add(MN_Arquivo);

		JMenuItem MT_EfetuarLogout = new JMenuItem("Efetuar Logout");
		MT_EfetuarLogout.setDoubleBuffered(true);
		MN_Arquivo.add(MT_EfetuarLogout);
		MT_EfetuarLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();

			}
		});
		
		// Captura do ESC para fechar Janela
				JRootPane meurootpane = getRootPane();
				meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
				meurootpane.getRootPane().getActionMap()
						.put("ESCAPE", new AbstractAction("ESCAPE") {
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							public void actionPerformed(ActionEvent e) {
								if (JOptionPane.showConfirmDialog(null,
										"Deseja Sair do Programa?", "Confirmação",
										JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
									sair();
								} else {

								}
							}
						});


		JMenuItem MT_Fechar = new JMenuItem("Fechar");
		MT_Fechar.setDoubleBuffered(true);
		MN_Arquivo.add(MT_Fechar);
		MT_Fechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa?"
						, "Confirmação",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					fechar();
				} else {
					
				}
				
			}
		});

		JSeparator separator = new JSeparator();
		separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		separator.setMinimumSize(new Dimension(0, 15));
		separator.setMaximumSize(new Dimension(5, 15));
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);

		JMenu MN_Cadastros = new JMenu("Cadastros");
		MN_Cadastros.setDoubleBuffered(true);
		menuBar.add(MN_Cadastros);

		JMenuItem MT_Itens = new JMenuItem("Itens");
		MT_Itens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroItemGUI = CadastroItemGUI.getInstance();
				cadastroItemGUI.setVisible(true);

			}
		});
		
		MT_Itens.setDoubleBuffered(true);
		MN_Cadastros.add(MT_Itens);

		JMenuItem MT_UnidadeDeMedio = new JMenuItem(
				"Unidade de Medi\u00E7\u00E3o");
		MT_UnidadeDeMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formUnidadeDeMedicaoGUI = FormUnidadeDeMedicaoGUI.getInstance();
				formUnidadeDeMedicaoGUI.setVisible(true);
				formUnidadeDeMedicaoGUI.requestDefaultFocus();
			}
		});
		MT_UnidadeDeMedio.setDoubleBuffered(true);
		MN_Cadastros.add(MT_UnidadeDeMedio);

		JMenuItem MT_Equipamentos = new JMenuItem("Equipamentos");
		MT_Equipamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastroEquipamentoGUI = CadastroEquipamentoGUI.getInstance();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cadastroEquipamentoGUI.setVisible(true);
				cadastroEquipamentoGUI.requestDefaultFocus();
			}
		});
		MT_Equipamentos.setDoubleBuffered(true);
		MN_Cadastros.add(MT_Equipamentos);

		JMenuItem MT_Pessoa = new JMenuItem("Pessoa");
		MT_Pessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formPessoaGUI = FormPessoaGUI.getInstance();
				formPessoaGUI.setVisible(true);
				formPessoaGUI.requestDefaultFocus();
			}
		});
		MN_Cadastros.add(MT_Pessoa);

		JMenu MN_Seguranca = new JMenu("Segurança");
		MN_Seguranca.setDoubleBuffered(true);
		MN_Cadastros.add(MN_Seguranca);

		JMenuItem MT_Usuario = new JMenuItem("Usuario");
		MT_Usuario.setDoubleBuffered(true);
		MN_Seguranca.add(MT_Usuario);
		MT_Usuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});

		JMenuItem MT_Perfil = new JMenuItem("Perfil");
		MT_Perfil.setDoubleBuffered(true);
		MN_Seguranca.add(MT_Perfil);

		JMenu MN_OrdemDeServico = new JMenu("Ordem de Servi\u00E7o");
		MN_OrdemDeServico.setDoubleBuffered(true);
		menuBar.add(MN_OrdemDeServico);

		JMenuItem mntmAbrirNovaOrdem = new JMenuItem("Abrir nova OS");
		mntmAbrirNovaOrdem.setDoubleBuffered(true);
		MN_OrdemDeServico.add(mntmAbrirNovaOrdem);

		JMenuItem mntmOssEmAberto = new JMenuItem("OS's em aberto");
		mntmOssEmAberto.setDoubleBuffered(true);
		MN_OrdemDeServico.add(mntmOssEmAberto);

		JMenuItem mntmHistrico = new JMenuItem("Hist\u00F3rico");
		mntmHistrico.setDoubleBuffered(true);
		MN_OrdemDeServico.add(mntmHistrico);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setMinimumSize(new Dimension(0, 15));
		separator_1.setMaximumSize(new Dimension(5, 15));
		separator_1.setAlignmentY(1.0f);
		menuBar.add(separator_1);

		JMenu MN_Relatrios = new JMenu("Relat\u00F3rios");
		MN_Relatrios.setDoubleBuffered(true);
		menuBar.add(MN_Relatrios);

		JMenu MN_Utilitarios = new JMenu("Utilit\u00E1rios");
		MN_Utilitarios.setDoubleBuffered(true);
		menuBar.add(MN_Utilitarios);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setMinimumSize(new Dimension(0, 15));
		separator_2.setMaximumSize(new Dimension(5, 15));
		separator_2.setAlignmentY(1.0f);
		menuBar.add(separator_2);

		JMenu MN_Ajuda = new JMenu("Ajuda");
		MN_Ajuda.setDoubleBuffered(true);
		menuBar.add(MN_Ajuda);

		JMenuItem MT_Sobre = new JMenuItem("Sobre");
		MT_Sobre.setDoubleBuffered(true);
		MN_Ajuda.add(MT_Sobre);

		JMenuItem MT_Ajuda = new JMenuItem("Ajuda");
		MT_Ajuda.setDoubleBuffered(true);
		MN_Ajuda.add(MT_Ajuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		desktopBackgroundGUI = new DesktopBackgroundGUI();
		getContentPane().add(desktopBackgroundGUI);
		desktopBackgroundGUI.setLayout(null);

	}

	public void sair() {
		LoginGUI tela;
		usuario = null;
		tela = new LoginGUI();
		tela.setVisible(true);
		fechar();
	}

	public void fechar() {
		this.dispose();
	}
}