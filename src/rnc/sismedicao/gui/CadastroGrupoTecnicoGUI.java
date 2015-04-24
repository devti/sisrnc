package rnc.sismedicao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.TextArea;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.ScrollPane;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.controller.exception.UsuarioNaoEncontradoException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.ItemMedicaoTableModel;
import rnc.sismedicao.gui.util.UsuarioTableModel;
import rnc.sismedicao.model.beans.ItemMedicao;
import rnc.sismedicao.model.beans.Usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JEditorPane;


public class CadastroGrupoTecnicoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nomeDoGrupo;
	private JTextField tf_localizacao;
	private JTable table;
	private static CadastroGrupoTecnicoGUI formCadastroGrupoTecnicoGui;
	private ProcuraUsuarioGUI tpu;
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private UsuarioTableModel grpusuarios;
	private Fachada fachada;
	private int codigoUsuario=0;
	private int codigoGrupoTecnico =0;
	
	public static CadastroGrupoTecnicoGUI getInstance() {
		if (formCadastroGrupoTecnicoGui == null) {
			formCadastroGrupoTecnicoGui = new CadastroGrupoTecnicoGUI();
		}
		return formCadastroGrupoTecnicoGui;
	}
	public CadastroGrupoTecnicoGUI() {
		setTitle("Grupo de Responsaveis T\u00E9cnicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_nomeDoGrupo = new JTextField();
		tf_nomeDoGrupo.setBounds(111, 57, 200, 20);
		contentPane.add(tf_nomeDoGrupo);
		tf_nomeDoGrupo.setColumns(10);
		
		JPanel panelGrupo = new JPanel();
		panelGrupo.setBorder(new TitledBorder(null, "Grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrupo.setBounds(10, 238, 414, 132);
		contentPane.add(panelGrupo);
		panelGrupo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 394, 100);
		panelGrupo.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		listarGrupoTecnico(listaUsuarios);
		
		JLabel lb_nomeDoGrupo = new JLabel("Nome do Grupo");
		lb_nomeDoGrupo.setBounds(10, 57, 103, 20);
		contentPane.add(lb_nomeDoGrupo);
		
		JLabel lb_localizao = new JLabel("Localiza\u00E7\u00E3o");
		lb_localizao.setBounds(10, 88, 97, 20);
		contentPane.add(lb_localizao);
		
		tf_localizacao = new JTextField();
		tf_localizacao.setColumns(10);
		tf_localizacao.setBounds(111, 88, 200, 20);
		contentPane.add(tf_localizacao);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setBounds(10, 119, 61, 20);
		contentPane.add(lblObservao);
		
		
		//------------------------
		//Botao adicionar Usuario
		//------------------------
		JButton btnAddUsuario = new JButton("");
		btnAddUsuario.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		btnAddUsuario.setBounds(335, 214, 38, 23);
		contentPane.add(btnAddUsuario);
		btnAddUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarUsuario();
			}
		});
		
		
		//---------------------------
		//Botao Excluir Usuario
		//---------------------------
		JButton btnExcluirUsuario = new JButton("");
		btnExcluirUsuario.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		btnExcluirUsuario.setBounds(383, 214, 38, 23);
		contentPane.add(btnExcluirUsuario);
		btnExcluirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					fachada = Fachada.getInstance();
					Usuario u = fachada.usuarioProcurar((int) table.getModel()
							.getValueAt(table.getSelectedRow(), 0));
					for (int cont = 0; cont < listaUsuarios.size(); cont++) {
						if (u.getCodUsuario() == listaUsuarios.get(cont)
								.getCodUsuario()) {
							u = listaUsuarios.get(cont);
						}
					}
					if (JOptionPane
							.showConfirmDialog(
									null,
									"Deseja realmente EXCLUIR este usuario da lista de Grupo Tecnico ?",
									"Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (codigoUsuario == 0) {
							// Remove do Arraylist item de medicao da tabela
							listaUsuarios.remove(u);
						} else {
							// Remove do Banco de Dados
							// fachada.removerItemDeMedicao(im.getCodItemMedicao());
							// Remove do arraylist item de medicao da tabela
							listaUsuarios.remove(u);
						}
					} else {

					}
					listarGrupoTecnico(listaUsuarios);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(235, 381, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 381, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		btnUltimo.setBounds(107, 11, 30, 30);
		contentPane.add(btnUltimo);
		
		JButton btnProximo = new JButton("");
		btnProximo.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		btnProximo.setBounds(74, 11, 30, 30);
		contentPane.add(btnProximo);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		btnAnterior.setBounds(42, 11, 30, 30);
		contentPane.add(btnAnterior);
		
		JButton btnPrimeiro = new JButton("");
		btnPrimeiro.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		btnPrimeiro.setBounds(10, 11, 30, 30);
		contentPane.add(btnPrimeiro);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		btnPesquisar.setBounds(139, 11, 30, 30);
		contentPane.add(btnPesquisar);
		
		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		btnRemover.setEnabled(false);
		btnRemover.setBounds(172, 11, 30, 30);
		contentPane.add(btnRemover);
	}
	
	//-------------------
	// Procurar Usuarios
	//-------------------
	public void pesquisarUsuario() {
		tpu = new ProcuraUsuarioGUI();
		tpu.setVisible(true);
		if (tpu.getFocusableWindowState() && tpu.pegarUsuario() != null) {
			Usuario u = tpu.pegarUsuario();
			boolean entrou = false;
			for (int i = 0; i < listaUsuarios.size(); i++) {
				if (u.getCodUsuario() == listaUsuarios.get(i).getCodUsuario()) {
					entrou = true;
				} else {
					entrou = false;
				}
			}
			if (!entrou){
				if(listaUsuarios.size()==0){
					codigoUsuario = u.getCodUsuario();
					listaUsuarios.add(u);
				}else{
					codigoUsuario = u.getCodUsuario();					
					listaUsuarios.add(u);
				}
			}else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Usuario já existente no Grupo Tecnico!", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}

			listarGrupoTecnico(listaUsuarios);
		}
	}
	//------------------------------------------------
	//Monta a tabela grupo de Usuarios
	//------------------------------------------------
	public void listarGrupoTecnico(ArrayList<Usuario> listaUsuarios ) {
		try {
			grpusuarios = new UsuarioTableModel(listaUsuarios);
			table.setModel(grpusuarios);
			table.setModel(new UsuarioTableModel(listaUsuarios));
			table.setVisible(true);
			table.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent evt) {
					if (evt.getKeyCode() == 10 && table.getRowCount() > 0) {
						ok();
					}
				}
			});
		} catch (IllegalArgumentException e) {
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
}
