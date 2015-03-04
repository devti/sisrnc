package rnc.sismedicao.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JToolBar;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import rnc.sismedicao.model.util.VerificadoresEFormatadores;

@SuppressWarnings("serial")
public class FormPessoaGui extends JFrame {

	private JPanel contentPane;
	private JTextField TF_Nome;
	private JTextField TF_CPF;
	private JTextField TF_Email;
	private JTextField TF_Tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPessoaGui frame = new FormPessoaGui();
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
	public FormPessoaGui() {
		setTitle("Cadastro Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 43, 418, 164);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel LB_Nome = new JLabel("Nome");
		LB_Nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Nome.setBounds(10, 11, 33, 14);
		panel.add(LB_Nome);
		
		TF_Nome = new JTextField();
		TF_Nome.setBounds(10, 25, 242, 20);
		panel.add(TF_Nome);
		TF_Nome.setColumns(10);
		
		JLabel LB_CPF = new JLabel("CPF");
		LB_CPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_CPF.setBounds(10, 50, 33, 14);
		panel.add(LB_CPF);
		
		TF_CPF = new JFormattedTextField(VerificadoresEFormatadores.setDefaultMaskFormat(VerificadoresEFormatadores.CPF_FORMAT));
		TF_CPF.setColumns(10);
		TF_CPF.setBounds(10, 64, 144, 20);
		panel.add(TF_CPF);
		
		JLabel LB_Email = new JLabel("Email");
		LB_Email.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Email.setBounds(10, 90, 33, 14);
		panel.add(LB_Email);
		
		TF_Email = new JTextField();
		TF_Email.setColumns(10);
		TF_Email.setBounds(10, 104, 242, 20);
		panel.add(TF_Email);
		
		JLabel LB_Telefone = new JLabel("Telefone");
		LB_Telefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Telefone.setBounds(274, 11, 49, 14);
		panel.add(LB_Telefone);
		
		TF_Tel = new JFormattedTextField(VerificadoresEFormatadores.setDefaultMaskFormat(VerificadoresEFormatadores.FONE_FORMAT));
		TF_Tel.setColumns(10);
		TF_Tel.setBounds(274, 25, 125, 20);
		panel.add(TF_Tel);
		
		JButton button = new JButton("Salvar");
		button.setBounds(221, 218, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(318, 218, 89, 23);
		contentPane.add(button_1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 11, 520, 26);
		contentPane.add(toolBar);
		
		JLabel label = new JLabel("");
		label.setMinimumSize(new Dimension(24, 16));
		label.setMaximumSize(new Dimension(24, 16));
		label.setIcon(new ImageIcon(FormPessoaGui.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		toolBar.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setMinimumSize(new Dimension(24, 16));
		label_1.setMaximumSize(new Dimension(24, 16));
		label_1.setIcon(new ImageIcon(FormPessoaGui.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		toolBar.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
	}
}
