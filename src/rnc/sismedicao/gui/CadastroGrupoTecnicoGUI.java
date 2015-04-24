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

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

import java.awt.Color;

public class CadastroGrupoTecnicoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nomeDoGrupo;
	private JTextField tf_localizacao;
	private JTable table;
	private static CadastroGrupoTecnicoGUI formCadastroGrupoTecnicoGui;
	
	public static CadastroGrupoTecnicoGUI getInstance() {
		if (formCadastroGrupoTecnicoGui == null) {
			formCadastroGrupoTecnicoGui = new CadastroGrupoTecnicoGUI();
		}
		return formCadastroGrupoTecnicoGui;
	}
	public CadastroGrupoTecnicoGUI() {
		setTitle("Grupo de Responsaveis T\u00E9cnicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 505);
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
		panelGrupo.setBounds(10, 146, 414, 132);
		contentPane.add(panelGrupo);
		panelGrupo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 394, 100);
		panelGrupo.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
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
		
		TextArea ta_observacao = new TextArea();
		ta_observacao.setBounds(13, 315, 411, 95);
		contentPane.add(ta_observacao);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setBounds(10, 289, 61, 20);
		contentPane.add(lblObservao);
		
		JButton btnAddUsuario = new JButton("");
		btnAddUsuario.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		btnAddUsuario.setBounds(345, 122, 38, 23);
		contentPane.add(btnAddUsuario);
		
		JButton btnExcluirUsuario = new JButton("");
		btnExcluirUsuario.setIcon(new ImageIcon(CadastroGrupoTecnicoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		btnExcluirUsuario.setBounds(386, 122, 38, 23);
		contentPane.add(btnExcluirUsuario);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(236, 434, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 434, 89, 23);
		contentPane.add(btnCancelar);
	}
}
