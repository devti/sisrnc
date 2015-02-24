package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UnidadeDeMedicaoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField TF_Codigo;
	private JTextField TF_Descricao;
	private static UnidadeDeMedicaoGUI unidadeDeMedicaoGUI = null ;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UnidadeDeMedicaoGUI frame = new UnidadeDeMedicaoGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void requestDefaultFocus(){
		this.TF_Codigo.requestFocus();
		this.TF_Codigo.selectAll();
	}
	
	public static UnidadeDeMedicaoGUI getInstance(){
		if(unidadeDeMedicaoGUI == null){
			return unidadeDeMedicaoGUI = new UnidadeDeMedicaoGUI();
		}
		return unidadeDeMedicaoGUI;
	}
	
	/**
	 * Create the frame.
	 */
	private UnidadeDeMedicaoGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		setMinimumSize(new Dimension(420, 239));
		setMaximumSize(new Dimension(420, 239));

		setTitle("Cadastrar Unidade de Medi\u00E7\u00E3o");
		setResizable(false);
		setBounds(0, 0, 420, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setDoubleBuffered(true);
		tabbedPane.setBounds(10, 32, 394, 133);
		contentPane.add(tabbedPane);
		
		JPanel PN_Identificacao = new JPanel();
		PN_Identificacao.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, PN_Identificacao, null);
		
		JLabel LB_Codigo = new JLabel("C\u00F3digo:");
		LB_Codigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Codigo.setBounds(10, 11, 66, 14);
		
		TF_Codigo = new JTextField();
		TF_Codigo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		TF_Codigo.setBackground(Color.WHITE);
		TF_Codigo.setBounds(10, 25, 86, 20);
		TF_Codigo.setColumns(10);
		
		JLabel LB_Descricao = new JLabel("Descri\u00E7\u00E3o:");
		LB_Descricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Descricao.setBounds(10, 56, 66, 14);
		
		TF_Descricao = new JTextField();
		TF_Descricao.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		TF_Descricao.setBackground(Color.WHITE);
		TF_Descricao.setBounds(10, 71, 365, 20);
		TF_Descricao.setColumns(10);
		PN_Identificacao.setLayout(null);
		PN_Identificacao.add(LB_Codigo);
		PN_Identificacao.add(TF_Codigo);
		PN_Identificacao.add(LB_Descricao);
		PN_Identificacao.add(TF_Descricao);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 5, 414, 22);
		contentPane.add(toolBar);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Novo");
		label.setMinimumSize(new Dimension(24, 16));
		label.setMaximumSize(new Dimension(8, 16));
		label.setDoubleBuffered(true);
		label.setAlignmentX(0.5f);
		toolBar.add(label);
		
		JLabel LB_NovoIcon = new JLabel("");
		LB_NovoIcon.setToolTipText("Novo");
		LB_NovoIcon.setIcon(new ImageIcon(UnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		LB_NovoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		LB_NovoIcon.setMinimumSize(new Dimension(24, 16));
		LB_NovoIcon.setMaximumSize(new Dimension(24, 16));
		LB_NovoIcon.setDoubleBuffered(true);
		toolBar.add(LB_NovoIcon);
		
		JLabel LB_ExcluirIcon = new JLabel("");
		LB_ExcluirIcon.setIcon(new ImageIcon(UnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		LB_ExcluirIcon.setToolTipText("Excluir");
		LB_ExcluirIcon.setMinimumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setMaximumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setDoubleBuffered(true);
		LB_ExcluirIcon.setAlignmentX(0.5f);
		toolBar.add(LB_ExcluirIcon);
		
		JSeparator separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setDoubleBuffered(true);
		toolBar.add(separator);
		
		JButton BT_Ok = new JButton("OK");
		BT_Ok.setBounds(147, 176, 76, 23);
		contentPane.add(BT_Ok);
		
		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(233, 176, 76, 23);
		contentPane.add(BT_Salvar);
		
		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BT_Cancelar.setBounds(315, 176, 75, 23);
		contentPane.add(BT_Cancelar);
		
	}
}
