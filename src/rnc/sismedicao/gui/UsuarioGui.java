package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UsuarioGui extends JFrame {

	private JPanel contentPane;
	private JTextField TF_Login;
	private JPasswordField PF_Senha;
	private JTextField TF_Pessoa;
	private static UsuarioGui usuarioGui;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UsuarioGui frame = new UsuarioGui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static UsuarioGui getInstance(){
		if(usuarioGui == null){
			return usuarioGui = new UsuarioGui();
		}
		return usuarioGui;
	}
	
	/**
	 * Create the frame.
	 */
	private UsuarioGui() {
		setTitle("Cadastrar Usu\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 31, 337, 166);
		contentPane.add(tabbedPane);

		JPanel PN_Cadastro = new JPanel();
		PN_Cadastro.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, PN_Cadastro, null);
		PN_Cadastro.setLayout(null);

		JLabel LB_Login = new JLabel("Login");
		LB_Login.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Login.setBounds(10, 47, 46, 14);
		PN_Cadastro.add(LB_Login);

		JLabel LB_Senha = new JLabel("Senha");
		LB_Senha.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Senha.setBounds(10, 86, 46, 14);
		PN_Cadastro.add(LB_Senha);

		TF_Login = new JTextField();
		TF_Login.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		TF_Login.setBounds(10, 62, 147, 20);
		PN_Cadastro.add(TF_Login);
		TF_Login.setColumns(10);

		PF_Senha = new JPasswordField();
		PF_Senha.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		PF_Senha.setBounds(10, 102, 147, 20);
		PN_Cadastro.add(PF_Senha);

		JLabel LB_Pessoa = new JLabel("Pessoa");
		LB_Pessoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Pessoa.setBounds(10, 8, 46, 14);
		PN_Cadastro.add(LB_Pessoa);

		TF_Pessoa = new JTextField();
		TF_Pessoa.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		TF_Pessoa.setColumns(10);
		TF_Pessoa.setBounds(10, 23, 282, 20);
		PN_Cadastro.add(TF_Pessoa);

		JButton BT_PesquisarPessoa = new JButton("...");
		BT_PesquisarPessoa.setBounds(297, 23, 27, 22);
		PN_Cadastro.add(BT_PesquisarPessoa);

		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(145, 208, 89, 23);
		contentPane.add(BT_Salvar);

		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		BT_Cancelar.setBounds(242, 208, 89, 23);
		contentPane.add(BT_Cancelar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 5, 356, 22);
		contentPane.add(toolBar);
		
		JLabel label = new JLabel("");
		label.setMinimumSize(new Dimension(8, 16));
		label.setMaximumSize(new Dimension(8, 16));
		toolBar.add(label);
		
		JLabel LB_NovoIcon = new JLabel("");
		LB_NovoIcon.setIcon(new ImageIcon(UsuarioGui.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		LB_NovoIcon.setMinimumSize(new Dimension(24, 16));
		LB_NovoIcon.setMaximumSize(new Dimension(24, 16));
		toolBar.add(LB_NovoIcon);
		
		JLabel LB_ExcluirIcon = new JLabel("");
		LB_ExcluirIcon.setIcon(new ImageIcon(UsuarioGui.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		LB_ExcluirIcon.setMinimumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setMaximumSize(new Dimension(24, 16));
		toolBar.add(LB_ExcluirIcon);
		
		JSeparator separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
	}
}
