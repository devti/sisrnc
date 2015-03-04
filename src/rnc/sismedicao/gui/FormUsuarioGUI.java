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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;

public class FormUsuarioGUI extends NewJFrameForm {
	
	
	private JTextField TF_Login;
	private JPasswordField PF_Senha;
	private JTextField TF_Pessoa;
	
	private static FormUsuarioGUI formUsuarioGui; 
	
	private static final int TELA_WIDTH = 370;
	private static final int TELA_HEIGTH = 280;

	/**
	 * Launch the application.
	 */
	
	public static FormUsuarioGUI getInstance(){
		if(formUsuarioGui == null){
			return formUsuarioGui = new FormUsuarioGUI();
		}
		return formUsuarioGui;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUsuarioGUI frame = new FormUsuarioGUI();
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
	private FormUsuarioGUI() {
		//setBounds(0, 0, 370, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		setMinimumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));
		setMaximumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));
		
		setTitle("Cadastrar Usuário");
		
		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH, TELA_HEIGTH, false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 33, 354, 238);
		getContentPane().add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 1, 337, 166);
		panel.add(tabbedPane);
		
		JPanel PN_Identificacao = new JPanel();
		PN_Identificacao.setLayout(null);
		PN_Identificacao.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, PN_Identificacao, null);
		
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
		PF_Senha.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		PF_Senha.setBounds(10, 102, 147, 20);
		PN_Identificacao.add(PF_Senha);
		
		TF_Pessoa = new NewJTextField();
		TF_Pessoa.setEditable(false);
		TF_Pessoa.setColumns(10);
		TF_Pessoa.setBounds(10, 23, 282, 20);
		PN_Identificacao.add(TF_Pessoa);
		
		JButton BT_PesquisaPessoa = new JButton("");
		BT_PesquisaPessoa.setIcon(new ImageIcon(FormUsuarioGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		BT_PesquisaPessoa.setBounds(297, 23, 27, 22);
		PN_Identificacao.add(BT_PesquisaPessoa);
		
		JPanel PN_Pessoa = new JPanel();
		PN_Pessoa.setBackground(Color.WHITE);
		tabbedPane.addTab("Pessoa", null, PN_Pessoa, null);
		
		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(144, 177, 89, 23);
		panel.add(BT_Salvar);
		
		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BT_Cancelar.setBounds(241, 177, 89, 23);
		panel.add(BT_Cancelar);

	}

}
