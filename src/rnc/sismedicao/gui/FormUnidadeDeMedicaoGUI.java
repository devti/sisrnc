package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FormUnidadeDeMedicaoGUI extends NewJFrameForm implements InterfaceFormGUI {
	
	private NewJTextField TF_Codigo;
	private NewJTextField TF_Descricao;

	private static FormUnidadeDeMedicaoGUI formUnidadeDeMedicaoGUI = null;
	
	private static final int TELA_WIDTH = 420;
	private static final int TELA_HEIGTH = 240;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UnidadeDeMedicaoGUI frame = new UnidadeDeMedicaoGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public static FormUnidadeDeMedicaoGUI getInstance(){
		if(formUnidadeDeMedicaoGUI == null){
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
		
		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH, TELA_HEIGTH, false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 394, 133);
		getContentPane().add(tabbedPane);
		tabbedPane.setDoubleBuffered(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel LB_Codigo = new JLabel("C\u00F3digo:");
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
		BT_Salvar.setBounds(209, 180, 89, 23);
		getContentPane().add(BT_Salvar);
		
		JButton BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.setBounds(305, 180, 89, 23);
		getContentPane().add(BT_Cancelar);
		
		JButton BT_OK = new JButton("OK");
		BT_OK.setBounds(113, 180, 89, 23);
		getContentPane().add(BT_OK);
		
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
	public void requestDefaultFocus(){
		this.TF_Codigo.requestFocus();
		this.TF_Codigo.selectAll();
	}
}
