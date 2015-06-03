package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

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
	private ArrayList<ItemMedicao> listaItemMedicaoChecagem = new ArrayList<ItemMedicao>(); //utilizado para realizar a checagem 
	private UnidadeTableModel utm;
	private ItemMedicaoTableModel itm;
	private Component btnOk;
	private Item item;
	private static CadastroItemGUI cadastroItemGui;
	private static final int TELA_WIDTH = 585;
	private static final int TELA_HEIGTH = 630;
	private ProcuraItemGUI tela;
	private JButton btnRemover;
	private JTextField tf_CodigoItem;
	private int codigoItem = 0;

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
						CadastroUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(10, 8, 30, 30);
		getContentPane().add(btnPrimeiro);

		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(CadastroUsuarioGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(42, 8, 30, 30);
		getContentPane().add(btnAnterior);

		JButton btnProximo = new JButton("");
		btnProximo
				.setIcon(new ImageIcon(
						CadastroUsuarioGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(74, 8, 30, 30);
		getContentPane().add(btnProximo);

		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(CadastroUsuarioGUI.class
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
		
		JLabel lblCodigoItem = new JLabel("Codigo do Item:");
		lblCodigoItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoItem.setBounds(329, 18, 124, 20);
		contentPane.add(lblCodigoItem);
		
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
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(CadastroItemGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(140, 8, 30, 30);
		contentPane.add(btnPesquisar);

		//---------------------------------
		// Botao remover Item
		//---------------------------------
		JButton btnRemover = new JButton("");
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (codigoItem == 0) {
						JOptionPane
								.showMessageDialog(
										getContentPane(),
										"E necessario primeiro realizar a pesquisa do Item para poder realizar a EXCLUSAO!",
										"Aviso",
										JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (JOptionPane.showConfirmDialog(null,
								"Deseja realmente EXCLUIR este item ?",
								"Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							fachada.removerItem(codigoItem);
							fachada.removerAllItemDeMedicao(codigoItem);
							limparTela();
						}

					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemover
				.setIcon(new ImageIcon(
						CadastroItemGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
			btnRemover.setEnabled(true);
			
		btnRemover.setBounds(173, 8, 30, 30);
		contentPane.add(btnRemover);
		
		//-----------------------------------
		// Botao adicionar Items de Medicao
		//-----------------------------------
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
						if (codigoItem==0){
							// incluir da Tabela de Item de Medicao
							listaItemMedicao.add(im);
						}else {
							if (JOptionPane
									.showConfirmDialog(
											null,
											"Deseja realmente INSERIR este item de Medicao ?",
											"Confirmação",
											JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								Item itemT = new Item();
								itemT.setCodItem(codigoItem);
								UnidadeDeMedicao udm = new UnidadeDeMedicao();
								ItemMedicao iMedicao = new ItemMedicao();
								iMedicao.setItem(itemT);
								iMedicao.setValorMAX(im.getValorMAX());
								iMedicao.setValorMIN(im.getValorMIN());
								udm.setCodigo(im.getUnidadeDeMedicao()
										.getCodigo());
								udm.setDescricao(im.getUnidadeDeMedicao()
										.getDescricao());
								iMedicao.setUnidadeDeMedicao(udm);
								fachada.cadastrar(iMedicao);
								listaItemMedicao.add(im);

							} else {

							}
							// incluir da Tabela de Item de Medicao
							
						}
						table_1.setModel(new ItemMedicaoTableModel(listaItemMedicao));
					} else {
						JOptionPane.showMessageDialog(getContentPane(),
								"Item de Medição já existente", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAdcionar.setIcon(new ImageIcon(CadastroItemGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Down.png")));
		btnAdcionar.setBounds(438, 370, 36, 25);
		contentPane.add(btnAdcionar);

		//--------------------------------
		// BOTAO SALVAR
		//--------------------------------
		JButton BT_Salvar = new JButton("Salvar");
		BT_Salvar.setBounds(342, 559, 89, 23);
		contentPane.add(BT_Salvar);
		BT_Salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
				
			}
		});

	
		
		//---------------------------------------------------------
		// BOTAO REMOVER ITENS DE MEDICAO DA TABELA ITEM DE MEDICAO 
		//---------------------------------------------------------
		JButton btnRemoverItemMedicao = new JButton("");
		btnRemoverItemMedicao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fachada = Fachada.getInstance();
					// cria a unidade de medição selecionada na Table
					UnidadeDeMedicao um = fachada
							.unidadeProcurar((String) table_1.getModel()
									.getValueAt(table_1.getSelectedRow(), 0));
					// cria o item de medição com a unidade criada antes
					ItemMedicao im = new ItemMedicao(codigoItem, 0, 0, um);
					// procura o item selecionado na tela, e atribui para o
					// objeto im
					for (int cont = 0; cont < listaItemMedicao.size(); cont++) {
						if (listaItemMedicao.get(cont).getUnidadeDeMedicao()
								.getCodigo().equals(um.getCodigo())) {
							im = listaItemMedicao.get(cont);
						}
					}
					if (JOptionPane.showConfirmDialog(null,
							"Deseja realmente EXCLUIR este item de Medicao ?",
							"Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (codigoItem ==0){
							// Remove do  Arraylist item de medicao da tabela
							listaItemMedicao.remove(im);
						}else{
							//Remove do Banco de Dados
							fachada.removerItemDeMedicao(im.getCodItemMedicao());
							// Remove do arraylist item de medicao da tabela
							listaItemMedicao.remove(im);
						}
					} else {

					}
					// Monta a Tabela do Item de Medicao
					table_1.setModel(new ItemMedicaoTableModel(listaItemMedicao));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		btnRemoverItemMedicao.setIcon(new ImageIcon(CadastroItemGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		btnRemoverItemMedicao.setBounds(484, 370, 36, 25);
		contentPane.add(btnRemoverItemMedicao);
		
				
		tf_CodigoItem = new JTextField();
		tf_CodigoItem.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_CodigoItem.setEditable(false);
		tf_CodigoItem.setBounds(459, 18, 98, 20);
		contentPane.add(tf_CodigoItem);
		tf_CodigoItem.setColumns(10);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(456, 559, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limparTela();
				dispose();

			}
		});
	}
    
	
	//-----------------------------------------------------------
	//Metodo para SALVA as informações da tela ITEM e ITEMMedicao
	//-----------------------------------------------------------
	public void salvar() {
		try {
			 
			if(tf_Descricao.getText().isEmpty() 
					|| tf_Nome.getText().isEmpty() )
				throw new DadosObrigatoriosException();
			fachada = Fachada.getInstance();
			item = new Item(codigoItem, tf_Nome.getText(), tf_Descricao.getText(), tf_Marca.getText(), tf_Serial.getText());
			if (codigoItem == 0) {
				fachada.cadastrar(item);
				int codItem = fachada.consultarUltimoCodigoItem();
				UnidadeDeMedicao udm = new UnidadeDeMedicao();
				Item itemT = new Item();
				itemT.setCodItem(codItem);
				for (int i = 0; i < listaItemMedicao.size(); i++) {
					ItemMedicao im = new ItemMedicao();
					im.setItem(itemT);
					System.out.println("Codigo Item: "
							+ im.getItem().getCodItem());
					im.setValorMAX(listaItemMedicao.get(i).getValorMAX());
					im.setValorMIN(listaItemMedicao.get(i).getValorMIN());
					udm.setCodigo(listaItemMedicao.get(i).getUnidadeDeMedicao()
							.getCodigo());
					udm.setDescricao(listaItemMedicao.get(i)
							.getUnidadeDeMedicao().getDescricao());
					im.setUnidadeDeMedicao(udm);
					fachada.cadastrar(im);

				}
				JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
			}else {
				fachada.atualizarItem(item);
				for(int i=0;listaItemMedicao.size()>i;i++){
					fachada.alterarItemDeMedicao(listaItemMedicao.get(i));
				}
				JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!");
				
			}
			limparTela();
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

	//-------------------------------------------------------
	// METODO QUE REALIZA A PROCURA DO ITEM E DOS ITEMMEDICAO
	//-------------------------------------------------------
	public void procurar() {
		tela = new ProcuraItemGUI();
		tela.setVisible(true);
		if (tela.getFocusableWindowState() && tela.pegarItem() != null) {
			Item i = tela.pegarItem();
			tf_Nome.setText(i.getNome());
			tf_Descricao.setText(i.getDescricao());
			tf_Marca.setText(i.getMarca());
			tf_Serial.setText(i.getSerial());
			tf_CodigoItem.setText(Integer.toString(i.getCodItem()));
			codigoItem = i.getCodItem();
			listaItemMedicao = tela.pegarItems();
			listaItemMedicaoChecagem = listaItemMedicao;
			listarItemMedicao(listaItemMedicao);
			//btnRemover.setEnabled(true);
			
		}
	}
	
	//-----------------------------------------------------
	//metodo para limpar a tela
	//-----------------------------------------------------
	public void limparTela(){
		tf_Nome.setText(null);
		tf_Descricao.setText(null);
		tf_Marca.setText(null);
		tf_Serial.setText(null);
		tf_CodigoItem.setText(null);
		codigoItem = 0;
		listaItemMedicao.clear();
		listarItemMedicao(listaItemMedicao);
	}
	
	
	//------------------------------------------------
	//Monta a tabela de Item de Medicao
	//------------------------------------------------
	public void listarItemMedicao(ArrayList<ItemMedicao> listaItemMedicao ) {
		try {
			itm = new ItemMedicaoTableModel(listaItemMedicao);
			table_1.setModel(itm);
			table_1.setModel(new ItemMedicaoTableModel(listaItemMedicao));
			table_1.setVisible(true);
			table_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					if (evt.getKeyCode() == 10 && table_1.getRowCount() > 0) {
						ok();
					}
				}
			});
		} catch (IllegalArgumentException e) {
			btnOk.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	//-------------------------------------------------------
	//lista a unidade de medicao na tabela
	//-------------------------------------------------------
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
