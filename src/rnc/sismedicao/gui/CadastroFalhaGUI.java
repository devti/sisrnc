package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.FalhaJaCadastradaException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.model.beans.Falha;
import javax.swing.ImageIcon;

public class CadastroFalhaGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfData;
	private JTextField tfHora;
	private JTextField tfResponsavel;
	private JTextField tfTempoFalha;
	private Fachada fachada;
	private Falha falha;
	private int codFalha = 0;
	private static CadastroFalhaGUI cadastroFalhaGUI = null;
	private JTextField tfFalha;
	private JTextField tfSolucao;
	private JTextField tfImpactoFalha;
	
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
		lblNewLabel.setBounds(10, 117, 99, 14);
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
		lblNewLabel_1.setBounds(13, 53, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(158, 53, 46, 14);
		contentPanel.add(lblHora);
		
		JLabel lblQuantoTempoAfetou = new JLabel("Quanto tempo afetou no Ar?");
		lblQuantoTempoAfetou.setBounds(176, 328, 193, 14);
		contentPanel.add(lblQuantoTempoAfetou);
		
		tfData = new JTextField();
		tfData.setBounds(10, 69, 127, 20);
		contentPanel.add(tfData);
		tfData.setColumns(10);
		
		tfHora = new JTextField();
		tfHora.setColumns(10);
		tfHora.setBounds(158, 69, 86, 20);
		contentPanel.add(tfHora);
		
		tfResponsavel = new JTextField();
		tfResponsavel.setColumns(10);
		tfResponsavel.setBounds(10, 344, 143, 20);
		contentPanel.add(tfResponsavel);
		
		tfTempoFalha = new JTextField();
		tfTempoFalha.setColumns(10);
		tfTempoFalha.setBounds(176, 344, 68, 20);
		contentPanel.add(tfTempoFalha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(295, 381, 89, 23);
		contentPanel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarFalha();
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(394, 381, 89, 23);
		contentPanel.add(btnCancelar);
		
		tfFalha = new JTextField();
		tfFalha.setBounds(10, 136, 260, 20);
		contentPanel.add(tfFalha);
		tfFalha.setColumns(10);
		
		tfSolucao = new JTextField();
		tfSolucao.setColumns(10);
		tfSolucao.setBounds(10, 182, 260, 20);
		contentPanel.add(tfSolucao);
		
		tfImpactoFalha = new JTextField();
		tfImpactoFalha.setColumns(10);
		tfImpactoFalha.setBounds(10, 265, 260, 20);
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
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
	}


	public void cadastrarFalha() {
		try {
			if (tfData.getText().isEmpty() || tfHora.getText().isEmpty())
				throw new DadosObrigatoriosException();
			fachada = Fachada.getInstance();
			falha = new Falha(tfResponsavel.getText(), tfFalha.getText(),
					tfSolucao.getText(), tfImpactoFalha.getText(), tfHora.getText(),
					tfData.getText());
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
		// TODO Auto-generated method stub
		
	}
}
