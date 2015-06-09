package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.FalhaJaCadastradaException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.model.beans.Falha;
import rnc.sismedicao.model.beans.Usuario;
import rnc.sismedicao.model.util.Data;
import java.awt.Color;

public class CadastroFalhaGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfData;
	private JTextField tfHora;
	private Fachada fachada;
	private Falha falha;
	private int codFalha = 0;
	private static CadastroFalhaGUI cadastroFalhaGUI = null;
	private JTextField textField;
	private JTextField tfResponsavel;
	private JTextField tfTempoAr;
	private JComboBox cbCategoria;
	private ProcuraUsuarioGUI tpu;
	private JTextPane tP_falha;
	private JTextPane tP_solucao;
	private JTextPane tP_impacto;
	
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
		setBounds(100, 100, 483, 527);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Falha:");
		lblNewLabel.setBounds(10, 101, 99, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblSoluo = new JLabel("Solu\u00E7\u00E3o:");
		lblSoluo.setBounds(10, 187, 99, 14);
		contentPanel.add(lblSoluo);
		
		JLabel lblImpactoDaFalha = new JLabel("Impacto da Falha:");
		lblImpactoDaFalha.setBounds(10, 271, 99, 14);
		contentPanel.add(lblImpactoDaFalha);
		
		JLabel lblQuemResolveuA = new JLabel("Categoria da Falha:");
		lblQuemResolveuA.setBounds(241, 53, 121, 14);
		contentPanel.add(lblQuemResolveuA);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setBounds(13, 53, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(144, 53, 46, 14);
		contentPanel.add(lblHora);
		
		tfData = new JFormattedTextField((setMascara("##/##/####")));
		tfData.setBounds(10, 69, 127, 20);
		contentPanel.add(tfData);
		tfData.setColumns(10);
		
		tfHora = new JFormattedTextField((setMascara("##:##")));
		tfHora.setColumns(5);
		tfHora.setBounds(144, 69, 86, 20);
		contentPanel.add(tfHora);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(269, 455, 89, 23);
		contentPanel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarFalha();
				limparTela();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(368, 455, 89, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparTela();
				dispose();
			}
		});
		
		JButton btnPrimeiro = new JButton("");
		btnPrimeiro.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(10, 11, 30, 30);
		contentPanel.add(btnPrimeiro);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(43, 12, 30, 30);
		contentPanel.add(btnAnterior);
		
		JButton btnProximo = new JButton("");
		btnProximo.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(75, 11, 30, 30);
		contentPanel.add(btnProximo);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(107, 11, 30, 30);
		contentPanel.add(btnUltimo);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(140, 11, 30, 30);
		contentPanel.add(btnPesquisar);
		
		JButton btnRemover = new JButton("");
		btnRemover.setEnabled(false);
		btnRemover.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setBounds(173, 12, 30, 30);
		contentPanel.add(btnRemover);
		
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
		cbCategoria.setBounds(240, 69, 213, 20);
		contentPanel.add(cbCategoria);
		
		JLabel lblQuemResolveuA_1 = new JLabel("Quem resolveu a falha:");
		lblQuemResolveuA_1.setBounds(10, 357, 140, 14);
		contentPanel.add(lblQuemResolveuA_1);
		
		tfResponsavel = new JTextField();
		tfResponsavel.setEditable(false);
		tfResponsavel.setColumns(10);
		tfResponsavel.setBounds(11, 374, 320, 20);
		contentPanel.add(tfResponsavel);
		
		JButton btnPesquisarUsuario = new JButton("");
		btnPesquisarUsuario.setIcon(new ImageIcon(CadastroFalhaGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		btnPesquisarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarUsuario();
			}
		});
		btnPesquisarUsuario.setBounds(345, 374, 30, 20);
		contentPanel.add(btnPesquisarUsuario);
		
		tP_falha = new JTextPane();
		tP_falha.setBackground(Color.WHITE);
		tP_falha.setBounds(10, 117, 443, 59);
		contentPanel.add(tP_falha);
		
		tP_solucao = new JTextPane();
		tP_solucao.setBackground(Color.WHITE);
		tP_solucao.setBounds(10, 201, 443, 59);
		contentPanel.add(tP_solucao);
		
		tP_impacto = new JTextPane();
		tP_impacto.setBackground(Color.WHITE);
		tP_impacto.setBounds(10, 287, 443, 59);
		contentPanel.add(tP_impacto);
		
		JLabel lblTempoDeFalha = new JLabel("Tempo de falha no Ar:");
		lblTempoDeFalha.setBounds(10, 405, 140, 14);
		contentPanel.add(lblTempoDeFalha);
		
		tfTempoAr = new JFormattedTextField((setMascara("##:##")));
		tfTempoAr.setColumns(5);
		tfTempoAr.setBounds(10, 423, 86, 20);
		contentPanel.add(tfTempoAr);
		

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
			falha = new Falha(tfResponsavel.getText(), tP_falha.getText(),
					tP_solucao.getText(), tP_impacto.getText(), tfHora.getText(),
					tfData.getText(),
					cbCategoria.getSelectedItem().toString(), tfTempoAr.getText());
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
		tP_falha.setText(null);
		tP_impacto.setText(null);
		tP_solucao.setText(null);
		textField.setText(null);
		tfResponsavel.setText(null);
		tfData.setText(null);
		tfHora.setText(null);
	}
}
