package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.UnidadeDeMedicaoJaCadastradaException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;

import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FormUnidadeDeMedicaoGUI extends NewJFrameForm implements InterfaceFormGUI {

	private NewJTextField TF_Codigo;
	private NewJTextField TF_Descricao;
	private Fachada fachada;
	private UnidadeDeMedicao unidadeDeMedicao;
	private ProcuraUnidadeMedicaoGUI tpu;
	private JButton btnRemover;

	private static FormUnidadeDeMedicaoGUI formUnidadeDeMedicaoGUI = null;

	private static final int TELA_WIDTH = 420;
	private static final int TELA_HEIGTH = 260;

	/**
	 * Launch the application.
	 */

	public static FormUnidadeDeMedicaoGUI getInstance() {
		if (formUnidadeDeMedicaoGUI == null) {
			return formUnidadeDeMedicaoGUI = new FormUnidadeDeMedicaoGUI();
		}
		return formUnidadeDeMedicaoGUI;
	}

	/**
	 * Create the frame.
	 */
	private FormUnidadeDeMedicaoGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		setMinimumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));
		setMaximumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));

		setTitle("Cadastrar Unidade de Medi\u00E7\u00E3o");

		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH,
				TELA_HEIGTH, false);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 46, 394, 133);
		getContentPane().add(tabbedPane);
		tabbedPane.setDoubleBuffered(true);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel LB_Codigo = new JLabel("Sigla:");
		LB_Codigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Codigo.setBounds(10, 11, 66, 14);
		panel.add(LB_Codigo);

		JLabel LB_Descricao = new JLabel("Descri\u00E7\u00E3o:");
		LB_Descricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_Descricao.setBounds(10, 56, 66, 14);
		panel.add(LB_Descricao);

		TF_Codigo = new NewJTextField();
		TF_Codigo.setBounds(10, 25, 111, 18);
		panel.add(TF_Codigo);

		TF_Descricao = new NewJTextField();
		TF_Descricao.setBounds(10, 71, 369, 18);
		panel.add(TF_Descricao);

		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();

			}
		});
		BT_Salvar.setBounds(209, 190, 89, 23);
		getContentPane().add(BT_Salvar);

		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.setBounds(305, 190, 89, 23);
		BT_Cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		getContentPane().add(BT_Cancelar);

		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(FormUnidadeDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(105, 11, 30, 30);
		getContentPane().add(btnUltimo);

		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(FormUnidadeDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(40, 11, 30, 30);
		getContentPane().add(btnAnterior);

		JButton btnPrimeiro = new JButton("");
		btnPrimeiro
				.setIcon(new ImageIcon(
						FormUnidadeDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(8, 11, 30, 30);
		getContentPane().add(btnPrimeiro);

		JButton btnProximo = new JButton("");
		btnProximo
				.setIcon(new ImageIcon(
						FormUnidadeDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(72, 11, 30, 30);
		getContentPane().add(btnProximo);

		JButton btnPesquisa = new JButton("");
		btnPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pesquisarUnidadeMedicao();
				
			}
		});
		btnPesquisa.setIcon(new ImageIcon(FormUnidadeDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisa.setBounds(138, 11, 30, 30);
		getContentPane().add(btnPesquisa);

		btnRemover = new JButton("");
		btnRemover.setEnabled(false);
		btnRemover
				.setIcon(new ImageIcon(
						FormUnidadeDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setBounds(171, 11, 30, 30);
		getContentPane().add(btnRemover);

	}

	public void pesquisarUnidadeMedicao() {
		tpu = new ProcuraUnidadeMedicaoGUI();
		tpu.setVisible(true);
		if (tpu.getFocusableWindowState() && tpu.pegarUnidade() != null) {
			UnidadeDeMedicao u = tpu.pegarUnidade();
			TF_Codigo.setText(u.getCodigo());
			TF_Descricao.setText(u.getDescricao());
			btnRemover.setEnabled(true);
		}	
	}

	public void salvar() {
		try {
			if (TF_Codigo.getText().isEmpty()
					|| TF_Descricao.getText().isEmpty())
			throw new DadosObrigatoriosException();
			
			fachada = Fachada.getInstance();
			
			unidadeDeMedicao = new UnidadeDeMedicao(TF_Codigo.getText(),
					TF_Descricao.getText());
			
			fachada.cadastrar(unidadeDeMedicao);
			JOptionPane.showMessageDialog(null,
					"Unidade cadastrada com sucesso!");
			
		} catch (UnidadeDeMedicaoJaCadastradaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {

		} catch (DadosObrigatoriosException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} 
	}

	@Override
	public void mouseClickedNovo() {
		System.out.println("Teste na GUI, Novo");
	}

	@Override
	public void mouseClickedExcluir() {
		System.out.println("Teste na GUI, Excluir");
	}

	@Override
	public void requestDefaultFocus() {
		this.TF_Codigo.requestFocus();
		this.TF_Codigo.selectAll();
	}
}
