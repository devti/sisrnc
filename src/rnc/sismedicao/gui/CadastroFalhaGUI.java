package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroFalhaGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static CadastroFalhaGUI cadastroFalhaGUI = null;
	
	public static CadastroFalhaGUI getInstance() {
		if (cadastroFalhaGUI == null) {
			return cadastroFalhaGUI = new CadastroFalhaGUI();
		}
		return cadastroFalhaGUI;
	}


	/**
	 * Create the dialog.
	 */
	public CadastroFalhaGUI() {
		setTitle("Cadastro de Falhas");
		setBounds(100, 100, 517, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Falha:");
		lblNewLabel.setBounds(10, 75, 99, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblSoluo = new JLabel("Solu\u00E7\u00E3o:");
		lblSoluo.setBounds(10, 163, 99, 14);
		contentPanel.add(lblSoluo);
		
		JLabel lblImpactoDaFalha = new JLabel("Impacto da Falha:");
		lblImpactoDaFalha.setBounds(10, 240, 99, 14);
		contentPanel.add(lblImpactoDaFalha);
		
		JLabel lblQuemResolveuA = new JLabel("Quem resolveu a Falha?");
		lblQuemResolveuA.setBounds(10, 328, 156, 14);
		contentPanel.add(lblQuemResolveuA);
		
		JLabel lblNewLabel_1 = new JLabel("Data");
		lblNewLabel_1.setBounds(13, 11, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(158, 11, 46, 14);
		contentPanel.add(lblHora);
		
		JLabel lblQuantoTempoAfetou = new JLabel("Quanto tempo afetou no Ar?");
		lblQuantoTempoAfetou.setBounds(176, 328, 193, 14);
		contentPanel.add(lblQuantoTempoAfetou);
		
		textField = new JTextField();
		textField.setBounds(10, 27, 127, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 27, 86, 20);
		contentPanel.add(textField_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 93, 473, 50);
		contentPanel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 181, 473, 50);
		contentPanel.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(10, 262, 473, 50);
		contentPanel.add(textArea_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 344, 143, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 344, 68, 20);
		contentPanel.add(textField_3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(295, 381, 89, 23);
		contentPanel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(394, 381, 89, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
}
