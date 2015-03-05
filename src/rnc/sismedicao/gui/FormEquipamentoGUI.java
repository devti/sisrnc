package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import rnc.sismedicao.controller.ItemController;
import rnc.sismedicao.controller.UnidadeDeMedicaoController;
import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import rnc.sismedicao.gui.util.NewJTextField;
import rnc.sismedicao.model.util.VerificadoresEFormatadores;

@SuppressWarnings("serial")
public class FormEquipamentoGUI extends NewJFrameForm implements InterfaceFormGUI{
	
	private static final int TELA_WIDTH = 568;
	private static final int TELA_HEIGTH = 485;

	private static final int CHAR_MINIMO_PESQUISA = 3;

	private static FormEquipamentoGUI formEquipamentoGUI;
	private JTable TB_UnidadeMedicao;
	private JTable TB_UnidadeMedicaoEscolhido;
	private JTable TB_Item;

	private NewJTextField TF_PesquisaItem;

	private JLabel LB_DescricaoItem;
	private JLabel LB_MarcaItem;
	private JLabel LB_CodClienteItem;
	private JLabel LB_NomeItem;
	private JLabel LB_ReferenciaItem;
	private JLabel LB_CodigoEquipamento;
	private JLabel LB_DescricaoEquipamento;
	private JLabel LB_RegistroEquipamento;

	private NewJTextField TF_CodigoEquipamento;
	private NewJTextField TF_DescricaoEquipamento;

	@SuppressWarnings("rawtypes")
	private JComboBox CB_Item;

	private JTabbedPane tabbedPane;
	private JTabbedPane tabbedPane_1;

	private JPanel PN_InformacaoItem;
	private JPanel PN_Identificacao;

	private DefaultTableModel itemDefaultTableModel;
	private DefaultTableModel unidadeMedicaoDefaultTableModel;
	
	private ItemController itemController;
	private UnidadeDeMedicaoController unidadeDeMedicaoController;
	
	private JLabel LB_Nome;
	private JLabel LB_Descricao;
	private JLabel LB_Marca;
	private JLabel LB_Codigo;
	private JLabel LB_Referencia;
	private JPanel PN_Item;
	private NewJTextField TF_RegistroEquipamento;
	private JPanel PN_SelecionarItem;
	private JScrollPane scrollPane_3;
	private JLabel LB_PesquisaItem;
	private JButton BT_SelecionaItem;
	private JButton BT_NovoItem;
	private JButton BT_ListaTodosItem;
	private JPanel PN_ItemMedicao;
	private NewJTextField TF_PesquisaItemMedicao;
	private JLabel LB_PesquisaItemMedicao;
	private JComboBox CB_ItemMedicao;
	private JScrollPane SP_TBItemMedicao;
	private JScrollPane SP_TBItemMedicaoEscolhido;
	private JLabel lblAdicionar;
	private JLabel lblRetirar;
	private JButton btnTodos_1;
	private JPanel PN_Local;
	private JPanel PN_Complemento;
	private JLabel LB_Observacao;
	private JScrollPane SP_TPObservacao;
	private JTextPane TP_Observacao;
	private JButton BT_Salvar;
	private JButton BT_Cancelar;
	
	
	public static FormEquipamentoGUI getInstance(){
		if(formEquipamentoGUI == null){
			return formEquipamentoGUI = new FormEquipamentoGUI();
		}
		return formEquipamentoGUI;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private FormEquipamentoGUI() {

		itemController = new ItemController();
		unidadeDeMedicaoController = new UnidadeDeMedicaoController();
		
		setTitle("Criar Equipamento");
		
		ConfiguracaoDeComponentesGUI.centralizaFrame(this, TELA_WIDTH, TELA_HEIGTH, false);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 541, 369);
		getContentPane().add(tabbedPane);
		
		PN_Identificacao = new JPanel();
		PN_Identificacao.setBackground(Color.WHITE);
		tabbedPane.addTab("Identifica\u00E7\u00E3o", null, PN_Identificacao, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		PN_Identificacao.setLayout(null);
		
		TF_CodigoEquipamento = new NewJTextField();
		TF_CodigoEquipamento.setBounds(66, 11, 84, 18);
		PN_Identificacao.add(TF_CodigoEquipamento);
		
		LB_CodigoEquipamento = new JLabel("C\u00F3digo:");
		LB_CodigoEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_CodigoEquipamento.setBounds(10, 13, 46, 14);
		PN_Identificacao.add(LB_CodigoEquipamento);
		
		LB_DescricaoEquipamento = new JLabel("Descri\u00E7\u00E3o:");
		LB_DescricaoEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_DescricaoEquipamento.setBounds(10, 42, 58, 14);
		PN_Identificacao.add(LB_DescricaoEquipamento);
		
		TF_DescricaoEquipamento = new NewJTextField();
		TF_DescricaoEquipamento.setBounds(76, 40, 450, 18);
		PN_Identificacao.add(TF_DescricaoEquipamento);
		
		LB_RegistroEquipamento = new JLabel("Registro/n\u00BA S\u00E9rie:");
		LB_RegistroEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LB_RegistroEquipamento.setBounds(160, 13, 108, 14);
		PN_Identificacao.add(LB_RegistroEquipamento);
		
		TF_RegistroEquipamento = new NewJTextField();
		TF_RegistroEquipamento.setBounds(278, 11, 131, 18);
		PN_Identificacao.add(TF_RegistroEquipamento);
		
		PN_Item = new JPanel();
		PN_Item.setBackground(Color.WHITE);
		PN_Item.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PN_Item.setBounds(10, 69, 516, 261);
		PN_Identificacao.add(PN_Item);
		PN_Item.setLayout(null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 21, 496, 229);
		PN_Item.add(tabbedPane_1);
		
		PN_InformacaoItem = new JPanel();
		tabbedPane_1.addTab("Informa\u00E7\u00F5es do Item", null, PN_InformacaoItem, null);
		PN_InformacaoItem.setLayout(null);
		
		LB_Nome = new JLabel("Nome:");
		LB_Nome.setBounds(10, 36, 46, 14);
		PN_InformacaoItem.add(LB_Nome);
		
		LB_Descricao = new JLabel("Descri\u00E7\u00E3o:");
		LB_Descricao.setBounds(10, 76, 63, 14);
		PN_InformacaoItem.add(LB_Descricao);
		
		LB_Marca = new JLabel("Marca:");
		LB_Marca.setBounds(10, 101, 46, 14);
		PN_InformacaoItem.add(LB_Marca);
		
		LB_Codigo = new JLabel("C\u00F3digo:");
		LB_Codigo.setBounds(10, 11, 46, 14);
		PN_InformacaoItem.add(LB_Codigo);
		
		LB_Referencia = new JLabel("Refer\u00EAncia:");
		LB_Referencia.setBounds(287, 11, 70, 14);
		PN_InformacaoItem.add(LB_Referencia);
		
		LB_DescricaoItem = new JLabel("");
		LB_DescricaoItem.setBounds(65, 76, 416, 14);
		PN_InformacaoItem.add(LB_DescricaoItem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 62, 471, 2);
		PN_InformacaoItem.add(separator);
		
		LB_MarcaItem = new JLabel("");
		LB_MarcaItem.setBounds(65, 101, 112, 14);
		PN_InformacaoItem.add(LB_MarcaItem);
		
		LB_CodClienteItem = new JLabel("");
		LB_CodClienteItem.setBounds(51, 11, 112, 14);
		PN_InformacaoItem.add(LB_CodClienteItem);
		
		LB_NomeItem = new JLabel("");
		LB_NomeItem.setBounds(51, 36, 430, 14);
		PN_InformacaoItem.add(LB_NomeItem);
		
		LB_ReferenciaItem = new JLabel("000000");
		LB_ReferenciaItem.setBounds(353, 11, 128, 14);
		PN_InformacaoItem.add(LB_ReferenciaItem);
		
		PN_SelecionarItem = new JPanel();
		tabbedPane_1.addTab("Selecionar Item", null, PN_SelecionarItem, null);
		PN_SelecionarItem.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 41, 471, 129);
		PN_SelecionarItem.add(scrollPane_3);
		
		
		TB_Item = new JTable();
		TB_Item.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					selecionaItem();
				}
			}
		});
		TB_Item.setModel(new DefaultTableModel(
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
		TB_Item.getColumnModel().getColumn(0).setResizable(false);
		TB_Item.getColumnModel().getColumn(0).setMaxWidth(75);
		TB_Item.getColumnModel().getColumn(1).setResizable(false);
		itemDefaultTableModel = (DefaultTableModel)TB_Item.getModel();		
		
		scrollPane_3.setViewportView(TB_Item);
		
		LB_PesquisaItem = new JLabel("Busca r\u00E1pida:");
		LB_PesquisaItem.setBounds(29, 14, 73, 14);
		PN_SelecionarItem.add(LB_PesquisaItem);
		

		CB_Item = new JComboBox();
		CB_Item.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Nome"}));
		CB_Item.setSelectedIndex(1);
		
		
		TF_PesquisaItem = new NewJTextField();
		TF_PesquisaItem.setToolTipText("Digite sua busca, no m\u00EDnimo 3 caracteres para realizar a busca");
		
		TF_PesquisaItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(TF_PesquisaItem.getText().length() >= CHAR_MINIMO_PESQUISA){
					itemDefaultTableModel.setRowCount(0);
					itemController.tablePesquisa(comboBoxItemSelected(), TF_PesquisaItem.getText(), itemDefaultTableModel );
				}
			}
		});
		TF_PesquisaItem.setBounds(108, 12, 187, 18);
		PN_SelecionarItem.add(TF_PesquisaItem);

		CB_Item.setBounds(301, 11, 102, 20);
		PN_SelecionarItem.add(CB_Item);
		
		BT_SelecionaItem = new JButton("Selecionar");
		BT_SelecionaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionaItem();
			}

		});
		BT_SelecionaItem.setBounds(360, 176, 102, 21);
		PN_SelecionarItem.add(BT_SelecionaItem);
		
		BT_NovoItem = new JButton("Cadastrar Novo Item");
		BT_NovoItem.setBounds(26, 175, 141, 21);
		PN_SelecionarItem.add(BT_NovoItem);
		
		BT_ListaTodosItem = new JButton("Todos");
		BT_ListaTodosItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemDefaultTableModel.setRowCount(0);
				itemController.tablePesquisa(ItemController.PESQUISAR_NOME,"", itemDefaultTableModel );
				TF_PesquisaItem.setText("");
			}
		});
		BT_ListaTodosItem.setBounds(412, 10, 69, 23);
		PN_SelecionarItem.add(BT_ListaTodosItem);
		
		PN_ItemMedicao = new JPanel();
		PN_ItemMedicao.setBackground(Color.WHITE);
		tabbedPane.addTab("Itens de Medi\u00E7\u00E3o", null, PN_ItemMedicao, null);
		PN_ItemMedicao.setLayout(null);
		
		TF_PesquisaItemMedicao = new NewJTextField();
		TF_PesquisaItemMedicao.setBounds(94, 11, 226, 18);
		PN_ItemMedicao.add(TF_PesquisaItemMedicao);
		
		LB_PesquisaItemMedicao = new JLabel("Busca r\u00E1pida:");
		LB_PesquisaItemMedicao.setBounds(22, 13, 84, 14);
		PN_ItemMedicao.add(LB_PesquisaItemMedicao);
		
		CB_ItemMedicao = new JComboBox();
		CB_ItemMedicao.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Descri\u00E7\u00E3o"}));
		CB_ItemMedicao.setBounds(330, 10, 84, 20);
		PN_ItemMedicao.add(CB_ItemMedicao);
		
		SP_TBItemMedicao = new JScrollPane();
		SP_TBItemMedicao.setBounds(10, 40, 516, 112);
		PN_ItemMedicao.add(SP_TBItemMedicao);
		
		TB_UnidadeMedicao = new JTable();
		SP_TBItemMedicao.setViewportView(TB_UnidadeMedicao);
		
		TB_UnidadeMedicao.setModel(new DefaultTableModel(
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
		TB_UnidadeMedicao.getColumnModel().getColumn(0).setResizable(false);
		TB_UnidadeMedicao.getColumnModel().getColumn(0).setMaxWidth(75);
		TB_UnidadeMedicao.getColumnModel().getColumn(1).setResizable(false);
		TB_UnidadeMedicao.getColumnModel().getColumn(1).setPreferredWidth(200);
		unidadeMedicaoDefaultTableModel = (DefaultTableModel)TB_UnidadeMedicao.getModel();
		
		SP_TBItemMedicaoEscolhido = new JScrollPane();
		SP_TBItemMedicaoEscolhido.setBounds(10, 208, 516, 122);
		PN_ItemMedicao.add(SP_TBItemMedicaoEscolhido);
		
		TB_UnidadeMedicaoEscolhido = new JTable();
		TB_UnidadeMedicaoEscolhido.setModel(new DefaultTableModel(
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
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(0).setResizable(false);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(0).setMinWidth(75);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(0).setMaxWidth(75);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(1).setResizable(false);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(1).setMinWidth(75);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(1).setMaxWidth(75);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(2).setResizable(false);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(2).setMinWidth(75);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(2).setMaxWidth(75);
		TB_UnidadeMedicaoEscolhido.getColumnModel().getColumn(3).setResizable(false);
		SP_TBItemMedicaoEscolhido.setViewportView(TB_UnidadeMedicaoEscolhido);
		
		lblAdicionar = new JLabel("Adicionar");
		lblAdicionar.setDoubleBuffered(true);
		lblAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		
		ConfiguracaoDeComponentesGUI.CriarButtonBevelDeLabel(lblAdicionar);

		lblAdicionar.setToolTipText("Adiciona Item de Medi\u00E7\u00E3o selecionada");
		lblAdicionar.setIcon(new ImageIcon(FormEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Down.png")));
		lblAdicionar.setBounds(174, 161, 84, 28);
		PN_ItemMedicao.add(lblAdicionar);
		
		lblRetirar = new JLabel("Retirar");
		lblRetirar.setDoubleBuffered(true);
		lblRetirar.setHorizontalAlignment(SwingConstants.CENTER);
		
		ConfiguracaoDeComponentesGUI.CriarButtonBevelDeLabel(lblRetirar);
		
		lblRetirar.setToolTipText("Retira Item de Medi\u00E7\u00E3o do Equipamento");
		lblRetirar.setIcon(new ImageIcon(FormEquipamentoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		lblRetirar.setBounds(278, 173, 84, 28);
		PN_ItemMedicao.add(lblRetirar);
		
		unidadeDeMedicaoController.tablePesquisa(UnidadeDeMedicaoController.PESQUISAR_NOME,"", unidadeMedicaoDefaultTableModel );
		
		btnTodos_1 = new JButton("Todos");
		btnTodos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unidadeMedicaoDefaultTableModel.setRowCount(0);
				unidadeDeMedicaoController.tablePesquisa(UnidadeDeMedicaoController.PESQUISAR_NOME,"", unidadeMedicaoDefaultTableModel );
				TF_PesquisaItemMedicao.setText("");
			}
		});
		btnTodos_1.setBounds(424, 9, 84, 23);
		PN_ItemMedicao.add(btnTodos_1);
		
		PN_Local = new JPanel();
		PN_Local.setBackground(Color.WHITE);
		tabbedPane.addTab("Local", null, PN_Local, null);
		PN_Local.setLayout(null);
		
		PN_Complemento = new JPanel();
		PN_Complemento.setBackground(Color.WHITE);
		tabbedPane.addTab("Dados Complementares", null, PN_Complemento, null);
		PN_Complemento.setLayout(null);
		
		LB_Observacao = new JLabel("Observa\u00E7\u00F5es:");
		LB_Observacao.setBounds(10, 11, 73, 14);
		PN_Complemento.add(LB_Observacao);
		
		SP_TPObservacao = new JScrollPane();
		SP_TPObservacao.setBounds(10, 29, 516, 99);
		PN_Complemento.add(SP_TPObservacao);
		
		TP_Observacao = new JTextPane();
		SP_TPObservacao.setViewportView(TP_Observacao);
		
		BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(345, 415, 89, 23);
		getContentPane().add(BT_Salvar);
		
		BT_Cancelar = new JButton("Cancelar");
		BT_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BT_Cancelar.setBounds(444, 415, 89, 23);
		getContentPane().add(BT_Cancelar);
		
		
	}
	
	private void selecionaItem() {
		try {
			itemController.setItem( itemController.getItemDao( itemDefaultTableModel.getValueAt(TB_Item.getSelectedRow(), 0 ).toString() ) );
			
			preencheCamposItem(itemController.getItem().getCodCliente(), itemController.getItem().getCodItem(),
					   			itemController.getItem().getNome(), itemController.getItem().getDescricao(),
					   			itemController.getItem().getMarca());
			
			tabbedPane_1.setSelectedIndex(0);
			TF_PesquisaItem.setText("");
			itemDefaultTableModel.setRowCount(0);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um Item", "Erro", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} 
	}
	
	private void preencheCamposItem(String codCliente, int referencia, String nome, String descricao, String marca){
		this.LB_CodClienteItem.setText(codCliente);
		this.LB_ReferenciaItem.setText(VerificadoresEFormatadores.zeroFillNumber(referencia, 6));
		this.LB_NomeItem.setText(nome);
		this.LB_DescricaoItem.setText(descricao);
		this.LB_MarcaItem.setText(marca);
	}
	
	private int comboBoxItemSelected(){
		return CB_Item.getSelectedIndex();
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
		tabbedPane_1.setSelectedIndex(1);
		TF_PesquisaItem.requestFocus();
	}
}
