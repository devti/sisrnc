package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;

@SuppressWarnings("serial")
public class UnidadeDeMedicaoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static UnidadeDeMedicaoGUI unidadeDeMedicaoGUI = null ;
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
	
	public static UnidadeDeMedicaoGUI getInstance(){
		if(unidadeDeMedicaoGUI == null){
			return unidadeDeMedicaoGUI = new UnidadeDeMedicaoGUI();
		}
		
		return unidadeDeMedicaoGUI;
	}
	
	/**
	 * Create the frame.
	 */
	private UnidadeDeMedicaoGUI() {
		
		setTitle("Cadastrar Unidade de Medi\u00E7\u00E3o");
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setDoubleBuffered(true);
		tabbedPane.setBounds(10, 32, 394, 133);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, panel, null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(10, 11, 66, 14);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 25, 86, 20);
		textField.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setBounds(10, 56, 66, 14);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), null, null, null));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(10, 71, 365, 20);
		textField_1.setColumns(10);
		panel.setLayout(null);
		panel.add(lblCdigo);
		panel.add(textField);
		panel.add(lblDescrio);
		panel.add(textField_1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 5, 394, 22);
		contentPane.add(toolBar);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Novo");
		label.setIcon(new ImageIcon(UnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setMinimumSize(new Dimension(24, 16));
		label.setMaximumSize(new Dimension(24, 16));
		label.setDoubleBuffered(true);
		toolBar.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(UnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		label_1.setToolTipText("Excluir");
		label_1.setMinimumSize(new Dimension(24, 16));
		label_1.setMaximumSize(new Dimension(24, 16));
		label_1.setDoubleBuffered(true);
		label_1.setAlignmentX(0.5f);
		toolBar.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setDoubleBuffered(true);
		toolBar.add(separator);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(147, 176, 76, 23);
		contentPane.add(btnOk);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(233, 176, 76, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 176, 75, 23);
		contentPane.add(btnCancelar);
	}
}
