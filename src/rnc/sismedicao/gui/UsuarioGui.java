package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class UsuarioGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGui frame = new UsuarioGui();
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
	public UsuarioGui() {
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

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 50, 46, 14);
		panel.add(lblLogin);

		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 89, 46, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		textField.setBounds(10, 62, 147, 20);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		passwordField.setBounds(10, 102, 147, 20);
		panel.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("Pessoa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 23, 282, 20);
		panel.add(textField_1);

		JButton button = new JButton("...");
		button.setBounds(297, 23, 27, 22);
		panel.add(button);

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
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(UsuarioGui.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		label_1.setMinimumSize(new Dimension(24, 16));
		label_1.setMaximumSize(new Dimension(24, 16));
		toolBar.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(UsuarioGui.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		label_2.setMinimumSize(new Dimension(24, 16));
		label_2.setMaximumSize(new Dimension(24, 16));
		toolBar.add(label_2);
		
		JSeparator separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
	}
}
