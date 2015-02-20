package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class LoginGui extends JFrame {

	private JPanel contentPane;
	private JTextField TF_Login;
	private JPasswordField PF_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
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
	public LoginGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogin.setBounds(22, 107, 45, 14);
		contentPane.add(lblLogin);

		TF_Login = new JTextField();
		TF_Login.setBounds(22, 126, 200, 20);
		contentPane.add(TF_Login);
		TF_Login.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(22, 160, 45, 14);
		contentPane.add(lblSenha);

		PF_Senha = new JPasswordField();
		PF_Senha.setBounds(22, 176, 200, 20);
		contentPane.add(PF_Senha);

		JButton BT_Confirmar = new JButton("LOGIN");
		BT_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					login(TF_Login.getText(), PF_Senha.getPassword());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Aviso", JOptionPane.ERROR_MESSAGE);
				}
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
						System.exit(0);
					}
				});
		BT_Confirmar.setBounds(22, 207, 86, 23);
		contentPane.add(BT_Confirmar);

		JButton BT_Cancelar = new JButton("SAIR");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		BT_Cancelar.setBounds(124, 207, 98, 23);
		contentPane.add(BT_Cancelar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginGui.class
				.getResource("/rnc/sismedicao/gui/img/MARCA-TI.png")));
		label.setBounds(22, 32, 200, 48);
		contentPane.add(label);

		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setBounds(93, 274, 57, 14);
		contentPane.add(lblVerso);
	}

	private void login(String usuario, char[] password) {

	}

}
