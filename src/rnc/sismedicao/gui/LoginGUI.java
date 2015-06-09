package rnc.sismedicao.gui;

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
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.SenhaInvalidaException;
import rnc.sismedicao.fachada.Fachada;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField TF_Login;
	private JPasswordField PF_Senha;
	private Fachada fachada;
	private PrincipalGUI tela;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/icone_Relogio.png")));
		setTitle("SisRNC - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 390);
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

		//captura o enter para fazer login
		getRootPane().setDefaultButton(BT_Confirmar);

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
		label.setIcon(new ImageIcon(PrincipalGUI.class
				.getResource("/rnc/sismedicao/gui/img/MARCA-TI.png")));
		label.setBounds(22, 32, 200, 48);
		contentPane.add(label);

		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setBounds(96, 327, 72, 14);
		contentPane.add(lblVerso);
	}

	private void login(String usuario, char[] password)
			throws SenhaInvalidaException, RepositorioException, SQLException {
		try {
			fachada = Fachada.getInstance();
			String senha = new String(password);
			if (!fachada.usuarioLogin(usuario, senha))
				throw new SenhaInvalidaException();
			tela = new PrincipalGUI();
			tela.setVisible(true);
			dispose();
		} catch (SenhaInvalidaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Login",
					JOptionPane.ERROR_MESSAGE);
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Login",
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Login",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String pegaLogin(){
		
		return this.TF_Login.getText();
	}
}