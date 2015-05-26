package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import rnc.sismedicao.controller.exception.RepositorioException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.gui.util.OrdemServicoTableModel;
import rnc.sismedicao.model.beans.Equipamento;
import rnc.sismedicao.model.beans.GrupoTecnico;
import rnc.sismedicao.model.beans.OrdemServico;

public class ListaPlanosOSGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Fachada fachada;
	private ArrayList<OrdemServico> lista;
	private OrdemServicoTableModel ostm;
	private JTextField tf_UsuarioLogado;
	private static ListaPlanosOSGUI listaOSGUI;
	
	public static ListaPlanosOSGUI getInstance() {
		if (listaOSGUI == null) {
			return listaOSGUI = new ListaPlanosOSGUI();
		}
		return listaOSGUI;
	}

	/**
	 * Create the frame.
	 */
	public ListaPlanosOSGUI() {
		setTitle("Planos em Aberto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Captura do ESC para fechar Janela
				JRootPane meurootpane = getRootPane();
				meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
				meurootpane.getRootPane().getActionMap()
						.put("ESCAPE", new AbstractAction("ESCAPE") {
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							public void actionPerformed(ActionEvent e) {
								sair();
							}
						});
				try {
					fachada = Fachada.getInstance();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Leituras de Medi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 51, 573, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 19, 553, 185);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		listar();
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ListaPlanosOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Refresh.png")));
		btnNewButton.setBounds(20, 6, 30, 30);
		contentPane.add(btnNewButton);
		
		tf_UsuarioLogado = new JTextField();
		tf_UsuarioLogado.setEditable(false);
		tf_UsuarioLogado.setBounds(451, 6, 132, 20);
		contentPane.add(tf_UsuarioLogado);
		//tf_UsuarioLogado.setText(fachada.getUsuarioLogado().getLogin());
		tf_UsuarioLogado.setColumns(10);
	}

	private void listar() {
		try {
			fachada = Fachada.getInstance();
			lista = fachada.listarOS();
			for (OrdemServico os : lista) {
				Equipamento e = fachada.equipamentoProcurar(os.getCodEquipamento());
				GrupoTecnico gt = fachada.grupoTecnicoPesquisar(os.getIdGrupoTecnico());
				os.setEquipamento(e);
				os.setGrupoTecnico(gt);
			}
			ostm = new OrdemServicoTableModel(lista);
			table.setModel(ostm);
			table.setVisible(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(60);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			
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

	protected void sair() {
		// TODO Auto-generated method stub
		
	}
}
