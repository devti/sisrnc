package rnc.sismedicao.gui;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;

@SuppressWarnings("serial")
public class FormEquipamentoGUI extends NewJFrameForm implements InterfaceFormGUI{
	
	private static final int TELA_WIDTH = 568;
	private static final int TELA_HEIGTH = 485;
	
	private static FormEquipamentoGUI formEquipamentoGUI;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	public static FormEquipamentoGUI getInstance(){
		if(formEquipamentoGUI == null){
			return formEquipamentoGUI = new FormEquipamentoGUI();
		}
		return formEquipamentoGUI;
	}
	
	
	private FormEquipamentoGUI() {
		setTitle("Criar Equipamento");
		
		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH, TELA_HEIGTH, false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 541, 369);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		NewJTextField newJTextField = new NewJTextField();
		newJTextField.setBounds(66, 11, 84, 18);
		panel.add(newJTextField);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(10, 13, 46, 14);
		panel.add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setBounds(10, 42, 58, 14);
		panel.add(lblDescrio);
		
		NewJTextField newJTextField_1 = new NewJTextField();
		newJTextField_1.setBounds(76, 40, 450, 18);
		panel.add(newJTextField_1);
		
		JLabel lblRegistro = new JLabel("Registro/n\u00BA S\u00E9rie:");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro.setBounds(160, 13, 108, 14);
		panel.add(lblRegistro);
		
		NewJTextField newJTextField_2 = new NewJTextField();
		newJTextField_2.setBounds(278, 11, 131, 18);
		panel.add(newJTextField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 69, 516, 261);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 21, 496, 229);
		panel_3.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Informa\u00E7\u00F5es do Item", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 36, 46, 14);
		panel_4.add(lblNome);
		
		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio_1.setBounds(10, 76, 63, 14);
		panel_4.add(lblDescrio_1);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 101, 46, 14);
		panel_4.add(lblMarca);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo:");
		lblCdigo_1.setBounds(10, 11, 46, 14);
		panel_4.add(lblCdigo_1);
		
		JLabel lblReferncia = new JLabel("Refer\u00EAncia:");
		lblReferncia.setBounds(287, 11, 70, 14);
		panel_4.add(lblReferncia);
		
		JLabel label = new JLabel("");
		label.setBounds(65, 76, 416, 14);
		panel_4.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 62, 471, 2);
		panel_4.add(separator);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Selecionar Item", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 41, 471, 129);
		panel_5.add(scrollPane_3);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(0).setMinWidth(75);
		table_2.getColumnModel().getColumn(0).setMaxWidth(75);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		scrollPane_3.setViewportView(table_2);
		
		JLabel lblBuscaRpida_1 = new JLabel("Busca r\u00E1pida:");
		lblBuscaRpida_1.setBounds(29, 14, 73, 14);
		panel_5.add(lblBuscaRpida_1);
		
		NewJTextField newJTextField_4 = new NewJTextField();
		newJTextField_4.setBounds(108, 12, 187, 18);
		panel_5.add(newJTextField_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Nome"}));
		comboBox_1.setBounds(305, 11, 102, 20);
		panel_5.add(comboBox_1);
		
		JButton btnOk = new JButton("Selecionar");
		btnOk.setBounds(360, 176, 102, 21);
		panel_5.add(btnOk);
		
		JButton btnCadastrarNovoItem = new JButton("Cadastrar Novo Item");
		btnCadastrarNovoItem.setBounds(26, 175, 141, 21);
		panel_5.add(btnCadastrarNovoItem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Itens de Medi\u00E7\u00E3o", null, panel_1, null);
		panel_1.setLayout(null);
		
		NewJTextField newJTextField_3 = new NewJTextField();
		newJTextField_3.setBounds(136, 11, 226, 18);
		panel_1.add(newJTextField_3);
		
		JLabel lblBuscaRpida = new JLabel("Busca r\u00E1pida:");
		lblBuscaRpida.setBounds(64, 13, 84, 14);
		panel_1.add(lblBuscaRpida);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Descri\u00E7\u00E3o"}));
		comboBox.setBounds(372, 10, 84, 20);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 516, 112);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
					
					
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 208, 516, 122);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Valor M\u00EDnimo", "Valor M\u00E1ximo", "Descri\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setMinWidth(75);
		table_1.getColumnModel().getColumn(0).setMaxWidth(75);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setMinWidth(75);
		table_1.getColumnModel().getColumn(1).setMaxWidth(75);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setMinWidth(75);
		table_1.getColumnModel().getColumn(2).setMaxWidth(75);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblAdicionar = new JLabel("Adicionar");
		lblAdicionar.setDoubleBuffered(true);
		lblAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		
		ConfiguracaoDeComponentesGUI.CriarButtonBevelDeLabel(lblAdicionar);

		lblAdicionar.setToolTipText("Adiciona Item de Medi\u00E7\u00E3o selecionada");
		lblAdicionar.setIcon(new ImageIcon(FormEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Down.png")));
		lblAdicionar.setBounds(174, 161, 84, 28);
		panel_1.add(lblAdicionar);
		
		final JLabel lblRetirar = new JLabel("Retirar");
		lblRetirar.setDoubleBuffered(true);
		lblRetirar.setHorizontalAlignment(SwingConstants.CENTER);
		
		ConfiguracaoDeComponentesGUI.CriarButtonBevelDeLabel(lblRetirar);
		
		lblRetirar.setToolTipText("Retira Item de Medi\u00E7\u00E3o do Equipamento");
		lblRetirar.setIcon(new ImageIcon(FormEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		lblRetirar.setBounds(278, 173, 84, 28);
		panel_1.add(lblRetirar);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMaxWidth(75);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Local", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		tabbedPane.addTab("Dados Complementares", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(10, 11, 73, 14);
		panel_6.add(lblObservaes);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 29, 516, 99);
		panel_6.add(scrollPane_2);
		
		JTextPane textPane = new JTextPane();
		scrollPane_2.setViewportView(textPane);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(345, 415, 89, 23);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(444, 415, 89, 23);
		getContentPane().add(btnCancelar);
		
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
		// TODO Auto-generated method stub
		
	}
}
