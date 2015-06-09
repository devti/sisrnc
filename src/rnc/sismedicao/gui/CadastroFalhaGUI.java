package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.FalhaJaCadastradaException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.model.beans.Falha;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.util.Data;

import java.awt.Toolkit;

public class CadastroFalhaGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfData;
	private JTextField tfHora;
	private Fachada fachada;
	private Falha falha;
	private int codFalha = 0;
	private static CadastroFalhaGUI cadastroFalhaGUI = null;
	private JTextField tfFalha;
	private JTextField tfSolucao;
	private JTextField tfImpactoFalha;
	private JTextField textField;
	private JTextField tfResponsavel;
	private JComboBox cbCategoria;
	private ProcuraUsuarioGUI tpu;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/icone_Relogio.png")));
		setTitle("Cadastro de Falhas");
		setBounds(100, 100, 483, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Falha:");
		lblNewLabel.setBounds(10, 101, 99, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblSoluo = new JLabel("Solu\u00E7\u00E3o:");
		lblSoluo.setBounds(10, 147, 99, 14);
		contentPanel.add(lblSoluo);
		
		JLabel lblImpactoDaFalha = new JLabel("Impacto da Falha:");
		lblImpactoDaFalha.setBounds(10, 194, 99, 14);
		contentPanel.add(lblImpactoDaFalha);
		
		JLabel lblQuemResolveuA = new JLabel("Categoria da Falha:");
		lblQuemResolveuA.setBounds(254, 53, 121, 14);
		contentPanel.add(lblQuemResolveuA);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setBounds(13, 53, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(158, 53, 46, 14);
		contentPanel.add(lblHora);
		
		tfData = new JFormattedTextField((setMascara("##/##/####")));
		tfData.setBounds(10, 69, 127, 20);
		contentPanel.add(tfData);
		tfData.setColumns(10);
		
		tfHora = new JFormattedTextField((setMascara("##:##")));
		tfHora.setColumns(10);
		tfHora.setBounds(158, 69, 86, 20);
		contentPanel.add(tfHora);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(265, 313, 89, 23);
		contentPanel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarFalha();
				limparTela();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(364, 313, 89, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparTela();
				dispose();
			}
		});
		
		tfFalha = new JTextField();
		tfFalha.setBounds(10, 120, 365, 20);
		contentPanel.add(tfFalha);
		tfFalha.setColumns(10);
		
		tfSolucao = new JTextField();
		tfSolucao.setColumns(10);
		tfSolucao.setBounds(10, 166, 364, 20);
		contentPanel.add(tfSolucao);
		
		tfImpactoFalha = new JTextField();
		tfImpactoFalha.setColumns(10);
		tfImpactoFalha.setBounds(10, 213, 364, 20);
		contentPanel.add(tfImpactoFalha);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		button.setBounds(10, 11, 30, 30);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		button_1.setBounds(43, 12, 30, 30);
		contentPanel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		button_2.setBounds(75, 11, 30, 30);
		contentPanel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		button_3.setBounds(107, 11, 30, 30);
		contentPanel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		button_4.setBounds(140, 11, 30, 30);
		contentPanel.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		button_5.setBounds(173, 12, 30, 30);
		contentPanel.add(button_5);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(314, 11, 46, 14);
		contentPanel.add(lblCdigo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(367, 8, 86, 20);
		contentPanel.add(textField);
		
		cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(new String[] {"PROBLEMAS TECNICOS", "PROBLEMAS OPERACIONAIS", "PROBLEMAS DA OPEC", "PROBLEMAS DA COORDENA\u00C7\u00C3O RECIFE", "PROBLEMAS DO JORNALISMO"}));
		cbCategoria.setBounds(254, 69, 199, 20);
		contentPanel.add(cbCategoria);
		
		JLabel lblQuemResolveuA_1 = new JLabel("Quem resolveu a falha:");
		lblQuemResolveuA_1.setBounds(10, 244, 140, 14);
		contentPanel.add(lblQuemResolveuA_1);
		
		tfResponsavel = new JTextField();
		tfResponsavel.setEditable(false);
		tfResponsavel.setColumns(10);
		tfResponsavel.setBounds(11, 261, 320, 20);
		contentPanel.add(tfResponsavel);
		
		JButton btnPesquisarUsuario = new JButton("");
		btnPesquisarUsuario.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		btnPesquisarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarUsuario();
			}
		});
		btnPesquisarUsuario.setBounds(345, 261, 30, 20);
		contentPanel.add(btnPesquisarUsuario);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
	}

	//METODO PARA FORMATAR O CAMPO HORA
	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
		}
		return mask;
	}


	protected void pesquisarUsuario() {
		tpu = new ProcuraUsuarioGUI();
		tpu.setVisible(true);
		if(tpu.getFocusableWindowState() && tpu.pegarUsuario() != null) {
			Usuario u = tpu.pegarUsuario();
			tfResponsavel.setText(u.getLogin());
		}
		
	}


	public void cadastrarFalha() {
		try {
			if (tfData.getText().isEmpty() || tfHora.getText().isEmpty())
				throw new DadosObrigatoriosException();
			fachada = Fachada.getInstance();
			falha = new Falha(tfResponsavel.getText(), tfFalha.getText(),
					tfSolucao.getText(), tfImpactoFalha.getText(), tfHora.getText(),
					tfData.getText(),
					cbCategoria.getSelectedItem().toString());
			System.out.println(Data.converteTextFieldFORDataTime(tfData.getText()));
			if (codFalha == 0) {
				fachada.cadastrar(falha);
			} else {
				fachada.atualizarFalha(falha);
				JOptionPane.showMessageDialog(null, "Falha atualizada!");
			}
			
			JOptionPane.showMessageDialog(null, "Falha cadastrada com sucesso!");
			limparTela();
		} catch (FalhaJaCadastradaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (DadosObrigatoriosException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void limparTela() {
		codFalha = 0;
		tfFalha.setText(null);
		tfSolucao.setText(null);
		tfImpactoFalha.setText(null);
		textField.setText(null);
		tfResponsavel.setText(null);
		tfData.setText(null);
		tfHora.setText(null);
	}

}
