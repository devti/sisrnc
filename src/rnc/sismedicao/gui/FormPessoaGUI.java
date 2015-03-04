/**
 * 
 */
package rnc.sismedicao.gui;

import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.model.util.VerificadoresEFormatadores;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import rnc.sismedicao.gui.util.NewJTextField;

import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import java.awt.Component;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Administrador
 *
 */
@SuppressWarnings("serial")
public class FormPessoaGUI extends NewJFrameForm implements InterfaceFormGUI {
	
	private NewJTextField TF_Nome;
	private NewJTextField TF_Email;
	private NewJTextField TF_Endereco;
	private NewJTextField TF_Numero;
	private NewJTextField TF_Bairro;
	private NewJTextField TF_Cidade;
	
	private JFormattedTextField FT_CPF;
	private JFormattedTextField FT_Telefone;
	private JFormattedTextField FT_Cep;
	
	private JTable TB_Endereco;
	
	private JTabbedPane tabbedPane;
	
	private static FormPessoaGUI formPessoaGUI;
	
	private static final int TELA_WIDTH = 445;
	private static final int TELA_HEIGTH = 350;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPessoaGUI formPessoaGUI = new FormPessoaGUI();
					formPessoaGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public static FormPessoaGUI getInstance(){
		if(formPessoaGUI == null){
			return formPessoaGUI = new FormPessoaGUI();
		}
		return formPessoaGUI;
	}
	
	private FormPessoaGUI() {
		setTitle("Cadastrar Pessoa");
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 418, 237);
		getContentPane().add(tabbedPane);
		
		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH, TELA_HEIGTH, false);
		
		JPanel PN_Identificacao = new JPanel();
		PN_Identificacao.setLayout(null);
		PN_Identificacao.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, PN_Identificacao, null);
		
		JLabel LB_Nome = new JLabel("Nome:");
		LB_Nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Nome.setBounds(10, 11, 49, 14);
		PN_Identificacao.add(LB_Nome);
		
		TF_Nome = new NewJTextField();
		TF_Nome.setColumns(10);
		TF_Nome.setBounds(10, 25, 393, 20);
		PN_Identificacao.add(TF_Nome);
		
		JLabel LB_CPF = new JLabel("CPF:");
		LB_CPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_CPF.setBounds(10, 50, 33, 14);
		PN_Identificacao.add(LB_CPF);
		
		FT_CPF = new JFormattedTextField(VerificadoresEFormatadores.setDefaultMaskFormat(VerificadoresEFormatadores.CPF_FORMAT));
		FT_CPF.setColumns(10);
		ConfiguracaoDeComponentesGUI.configuraJTextField(FT_CPF);
		FT_CPF.setBounds(10, 64, 144, 20);
		PN_Identificacao.add(FT_CPF);
		
		JLabel LB_Email = new JLabel("Email:");
		LB_Email.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Email.setBounds(10, 117, 33, 14);
		PN_Identificacao.add(LB_Email);
		
		TF_Email = new NewJTextField();
		TF_Email.setColumns(10);
		TF_Email.setBounds(10, 131, 393, 20);
		PN_Identificacao.add(TF_Email);
		
		JLabel LB_Telefone = new JLabel("Telefone:");
		LB_Telefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Telefone.setBounds(10, 158, 60, 14);
		PN_Identificacao.add(LB_Telefone);
		
		FT_Telefone = new JFormattedTextField(VerificadoresEFormatadores.setDefaultMaskFormat(VerificadoresEFormatadores.FONE_FORMAT));
		FT_Telefone.setColumns(10);
		ConfiguracaoDeComponentesGUI.configuraJTextField(FT_Telefone);
		FT_Telefone.setBounds(10, 172, 125, 20);
		PN_Identificacao.add(FT_Telefone);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(56, 100, 347, 8);
		PN_Identificacao.add(separator);
		
		JLabel LB_Contato = new JLabel("Contato");
		LB_Contato.setForeground(Color.LIGHT_GRAY);
		LB_Contato.setBounds(13, 94, 46, 14);
		PN_Identificacao.add(LB_Contato);
		
		JPanel PN_Endereco = new JPanel();
		PN_Endereco.setBackground(Color.WHITE);
		tabbedPane.addTab("Endere\u00E7o", null, PN_Endereco, null);
		PN_Endereco.setLayout(null);
		
		JScrollPane SP_TBEndereco = new JScrollPane();
		SP_TBEndereco.setBounds(10, 129, 393, 69);
		PN_Endereco.add(SP_TBEndereco);
		
		TB_Endereco = new JTable();
		TB_Endereco.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Endere\u00E7o", "N\u00FAmero", "Bairro", "Cidade", "CEP"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		SP_TBEndereco.setViewportView(TB_Endereco);
		
		JLabel LB_Endereco = new JLabel("Endere\u00E7o:");
		LB_Endereco.setBounds(10, 11, 49, 14);
		PN_Endereco.add(LB_Endereco);
		
		JLabel LB_Cep = new JLabel("CEP:");
		LB_Cep.setBounds(10, 86, 46, 14);
		PN_Endereco.add(LB_Cep);
		
		JLabel LB_Bairro = new JLabel("Bairro:");
		LB_Bairro.setBounds(62, 51, 49, 14);
		PN_Endereco.add(LB_Bairro);
		
		JLabel LB_Cidade = new JLabel("Cidade:");
		LB_Cidade.setBounds(249, 51, 46, 14);
		PN_Endereco.add(LB_Cidade);
		
		JLabel LB_Numero = new JLabel("N\u00FAmero:");
		LB_Numero.setBounds(10, 51, 46, 14);
		PN_Endereco.add(LB_Numero);
		
		TF_Endereco = new NewJTextField();
		TF_Endereco.setBounds(10, 27, 393, 18);
		PN_Endereco.add(TF_Endereco);
		
		TF_Numero = new NewJTextField();
		TF_Numero.setBounds(10, 65, 49, 18);
		PN_Endereco.add(TF_Numero);
		
		TF_Bairro = new NewJTextField();
		TF_Bairro.setBounds(62, 65, 180, 18);
		PN_Endereco.add(TF_Bairro);
		
		TF_Cidade = new NewJTextField();
		TF_Cidade.setBounds(249, 65, 154, 18);
		PN_Endereco.add(TF_Cidade);
		
		FT_Cep = new JFormattedTextField(VerificadoresEFormatadores.setDefaultMaskFormat(VerificadoresEFormatadores.CEP_FORMAT));
		FT_Cep.setBounds(10, 101, 102, 18);
		ConfiguracaoDeComponentesGUI.configuraJTextField(FT_Cep);
		PN_Endereco.add(FT_Cep);
		
		JButton BT_Adicionar = new JButton("Adicionar Novo");
		BT_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		BT_Adicionar.setBounds(123, 96, 112, 23);
		PN_Endereco.add(BT_Adicionar);
		
		JButton BT_Remover = new JButton("Remover");
		BT_Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		BT_Remover.setBounds(314, 96, 89, 23);
		PN_Endereco.add(BT_Remover);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(241, 96, 69, 23);
		PN_Endereco.add(btnSalvar);
		
		JLabel LB_Limpar = new JLabel("");
		LB_Limpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				limparCamposEndereco();
			}
		});
		LB_Limpar.setToolTipText("Limpar Formul\u00E1rio");
		LB_Limpar.setHorizontalAlignment(SwingConstants.CENTER);
		LB_Limpar.setAlignmentX(Component.CENTER_ALIGNMENT);
		LB_Limpar.setIcon(new ImageIcon(FormPessoaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/clear 1.png")));
		LB_Limpar.setBounds(367, 3, 35, 20);
		ConfiguracaoDeComponentesGUI.CriarButtonBevelDeLabel(LB_Limpar);
		PN_Endereco.add(LB_Limpar);
		
		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(226, 286, 89, 23);
		getContentPane().add(BT_Salvar);
		
		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BT_Cancelar.setBounds(323, 286, 89, 23);
		getContentPane().add(BT_Cancelar);
	}

	@Override
	public void requestDefaultFocus() {
		tabbedPane.setSelectedIndex(0);
		TF_Nome.requestFocus();
	}
	
	private void limparCamposEndereco(){
		TF_Endereco.setText("");
		TF_Numero.setText("");
		TF_Bairro.setText("");
		TF_Cidade.setText("");
		FT_Cep.setText("");
		TF_Endereco.requestFocus();
	}

}
