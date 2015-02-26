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
import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;

@SuppressWarnings("serial")
public class FormEquipamentoGUI extends NewJFrameForm implements InterfaceFormGUI{
	
	private static final int TELA_WIDTH = 568;
	private static final int TELA_HEIGTH = 485;
	
	private static FormEquipamentoGUI formEquipamentoGUI;
	private JTable table;
	private JTable table_1;
	
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
		tabbedPane.addTab("Item", null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		NewJTextField newJTextField = new NewJTextField();
		newJTextField.setBounds(66, 11, 84, 18);
		panel.add(newJTextField);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 13, 46, 14);
		panel.add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 42, 50, 14);
		panel.add(lblDescrio);
		
		NewJTextField newJTextField_1 = new NewJTextField();
		newJTextField_1.setBounds(66, 40, 460, 18);
		panel.add(newJTextField_1);
		
		JLabel lblRegistro = new JLabel("Registro/n\u00BA S\u00E9rie:");
		lblRegistro.setBounds(176, 13, 92, 14);
		panel.add(lblRegistro);
		
		NewJTextField newJTextField_2 = new NewJTextField();
		newJTextField_2.setBounds(278, 11, 131, 18);
		panel.add(newJTextField_2);
		
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
