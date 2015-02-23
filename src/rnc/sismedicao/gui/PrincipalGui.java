package rnc.sismedicao.gui;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.gui.util.DesktopBackgroundGUI;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

@SuppressWarnings("serial")
public class PrincipalGui extends JFrame {
	
	private JPanel contentPane;
	private UnidadeDeMedicaoGUI unidadeDeMedicaoGUI;
	private DesktopBackgroundGUI desktopBackgroundGUI;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new WindowsLookAndFeel());
					PrincipalGui frame = new PrincipalGui();
					frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalGui() {
		
		Dimension dimension = this.getSize();  
        int x = (int)(dimension.getWidth() - this.getWidth()) / 2;  
        int y = (int)(dimension.getHeight() - this.getHeight()) / 2;  
		
		getContentPane().setLayout(new GridLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setTitle("SisMedi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 800, 600);
		
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
		
		JMenuItem MT_Fechar = new JMenuItem("Fechar");
		MT_Fechar.setDoubleBuffered(true);
		MN_Arquivo.add(MT_Fechar);
		
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
		MT_Itens.setDoubleBuffered(true);
		MN_Cadastros.add(MT_Itens);
		
		JMenuItem MT_UnidadeDeMedio = new JMenuItem("Unidade de Medi\u00E7\u00E3o");
		MT_UnidadeDeMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unidadeDeMedicaoGUI = UnidadeDeMedicaoGUI.getInstance();
				if(unidadeDeMedicaoGUI.isClosed()){
					unidadeDeMedicaoGUI.dispose();
					desktopBackgroundGUI.remove(unidadeDeMedicaoGUI);
				}
				desktopBackgroundGUI.add(unidadeDeMedicaoGUI);
				unidadeDeMedicaoGUI.setBounds(0, 0, 420, 239);
				unidadeDeMedicaoGUI.setVisible(true);
				unidadeDeMedicaoGUI.requestFocusDefault();
			}
		});
		MT_UnidadeDeMedio.setDoubleBuffered(true);
		MN_Cadastros.add(MT_UnidadeDeMedio);
		
		JMenuItem MT_Equipamentos = new JMenuItem("Equipamentos");
		MT_Equipamentos.setDoubleBuffered(true);
		MN_Cadastros.add(MT_Equipamentos);
		
		JMenu MN_Seguranca = new JMenu("Seguran\u00E7a");
		MN_Seguranca.setDoubleBuffered(true);
		MN_Cadastros.add(MN_Seguranca);
		
		JMenuItem MT_Usuario = new JMenuItem("Usu\u00E1rio");
		MT_Usuario.setDoubleBuffered(true);
		MN_Seguranca.add(MT_Usuario);
		
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
}