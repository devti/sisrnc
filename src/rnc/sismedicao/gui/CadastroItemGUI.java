package rnc.sismedicao.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.controller.exception.ItemJaCadastradoException;
import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.ItemMedicaoTableModel;
import rnc.sismedicao.gui.util.UnidadeTableModel;
import rnc.sismedicao.model.beans.Item;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.beans.UnidadeDeMedicao;

public class CadastroItemGUI extends JDialog implements InterfaceFormGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_Nome;
	private JTextField tf_Descricao;
	private JTextField tf_Marca;
	private JTextField tf_Serial;
	private JTable table;
	private JTable table_1;
	private ItemMedicao itemMedicao;
	private Fachada fachada;
	private ArrayList<UnidadeDeMedicao> lista;
	private ArrayList<ItemMedicao> listaItemMedicao = new ArrayList<ItemMedicao>();
	private UnidadeTableModel utm;
	private Component btnOk;
	private Item item;
	private static CadastroItemGUI cadastroItemGui;
	private static final int TELA_WIDTH = 585;
	private static final int TELA_HEIGTH = 630;

	public static CadastroItemGUI getInstance() {
		if (cadastroItemGui == null) {
			cadastroItemGui = new CadastroItemGUI();
		}
		return cadastroItemGui;
	}

	/**
	 * Create the frame.
	 */
	public CadastroItemGUI() {
		setTitle("Cadastro de Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// setBounds(100, 100, 594, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setMinimumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));
		setMaximumSize(new Dimension(TELA_WIDTH, TELA_HEIGTH));

		JButton btnPrimeiro = new JButton("");
		btnPrimeiro
				.setIcon(new ImageIcon(
						FormUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(10, 8, 30, 30);
		getContentPane().add(btnPrimeiro);

		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(FormUsuarioGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(42, 8, 30, 30);
		getContentPane().add(btnAnterior);

		JButton btnProximo = new JButton("");
		btnProximo
				.setIcon(new ImageIcon(
						FormUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(74, 8, 30, 30);
		getContentPane().add(btnProximo);

		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(FormUsuarioGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(107, 8, 30, 30);
		getContentPane().add(btnUltimo);

		tf_Marca = new JTextField();
		tf_Marca.setColumns(10);
		tf_Marca.setBounds(301, 77, 244, 20);
		contentPane.add(tf_Marca);

		tf_Serial = new JTextField();
		tf_Serial.setColumns(10);
		tf_Serial.setBounds(301, 125, 244, 20);
		contentPane.add(tf_Serial);

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 39, 547, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		tf_Descricao = new JTextField();
		tf_Descricao.setBounds(10, 87, 244, 20);
		panel.add(tf_Descricao);
		tf_Descricao.setColumns(10);

		tf_Nome = new JTextField();
		tf_Nome.setBounds(10, 38, 244, 20);
		panel.add(tf_Nome);
		tf_Nome.setColumns(10);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(291, 21, 42, 14);
		panel.add(lblMarca);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 21, 42, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 69, 78, 14);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblSerial = new JLabel("Serial:");
		lblSerial.setBounds(288, 69, 42, 14);
		panel.add(lblSerial);
		lblSerial.setFont(new Font("Tahoma", Font.BOLD, 11));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Medi\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 195, 547, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 23, 501, 138);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		listar();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Item de Medi\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 395, 547, 159);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 22, 496, 126);
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(1, 1, 1, 1,
				(Color) new Color(0, 0, 0)));
		table_1.setBackground(Color.WHITE);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table_1);

		table_1.setModel(new ItemMedicaoTableModel(listaItemMedicao));

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(CadastroItemGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(140, 8, 30, 30);
		contentPane.add(btnPesquisar);

		JButton btnRemover = new JButton("");
		btnRemover
				.setIcon(new ImageIcon(
						CadastroItemGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setEnabled(false);
		btnRemover.setBounds(173, 8, 30, 30);
		contentPane.add(btnRemover);

		JButton btnAdcionar = new JButton("");
		btnAdcionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fachada = Fachada.getInstance();
					// cria a unidade de medição selecionada na Table
					UnidadeDeMedicao um = fachada
							.unidadeProcurar((String) table.getModel()
									.getValueAt(table.getSelectedRow(), 0));
					// cria o item de medição com a unidade criada antes
					ItemMedicao im = new ItemMedicao(0, 0, um);
					//variavel logica
					boolean entrou = false;
					// percorre a lista de itens de medição pra ver se já existe um com o mesmo codigo do que vai entrar
					for (int i = 0; i<listaItemMedicao.size(); i++) {
						//compara se na lista já existe um item com uma unidade com o codigo igual o que vai entrar
						//se sim, ele ativa a variaval
						if (listaItemMedicao.get(i).getUnidadeDeMedicao().getCodigo()
								.equals(um.getCodigo()))
							entrou = true;
						// se não ele deixa como false
						else
							entrou = false;
					}
					//se não tiver entrardo ele faz a inserção na tabela de baixo
					if (!entrou) {
						listaItemMedicao.add(im);
						table_1.setModel(new ItemMedicaoTableModel(
								listaItemMedicao));
					} else {
						//se tiver entrado e já tiver o codigo em baixo ele da o aviso .. la em cima onde tem 0,0, um tu ta passando a um e 0 no min e 0 no max ne?
						JOptionPane.showMessageDialog(getContentPane(),
								"Item de Medição já existente", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			// }
		});
		btnAdcionar.setIcon(new ImageIcon(CadastroItemGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Down.png")));
		btnAdcionar.setBounds(495, 370, 36, 25);
		contentPane.add(btnAdcionar);

		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(342, 559, 89, 23);
		contentPane.add(BT_Salvar);
		BT_Salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
				
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(456, 559, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}
    
	
	//Metodo para SALVA as informações da tela ITEM e ITEMMedicao
	public void salvar() {
		try {
			
			if(tf_Descricao.getText().isEmpty() 
					|| tf_Nome.getText().isEmpty() )
				throw new DadosObrigatoriosException();
			fachada = Fachada.getInstance();
			item = new Item(tf_Nome.getText(), tf_Descricao.getText(), tf_Marca.getText(), tf_Serial.getText());
			fachada.cadastrar(item);
			System.out.println(fachada.consultarUltimoCodigoItem());
			
			JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
			dispose();
		} catch (ItemJaCadastradoException e) {
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
	public void listar() {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.listarUnidadeMedicao();
			utm = new UnidadeTableModel(lista);
			table.setModel(utm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					if (evt.getKeyCode() == 10 && table.getRowCount() > 0) {
						ok();
					}
				}
			});
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			btnOk.setEnabled(false);
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	protected void ok() {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestDefaultFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClickedNovo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClickedExcluir() {
		// TODO Auto-generated method stub

	}
}
