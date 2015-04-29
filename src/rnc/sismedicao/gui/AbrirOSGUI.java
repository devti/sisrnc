package rnc.sismedicao.gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.model.beans.Equipamento;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class AbrirOSGUI extends JFrame {

	private JPanel contentPane;
	private static AbrirOSGUI abrirOSGUI;
	private Fachada fachada;
	private ArrayList<Equipamento> lista;
	private JTextField TF_Equipamento;
	private JTextField TF_GrupoTecnico;
	private JTextField TF_DtInicio;
	private JTextField TF_DtFim;
	private JTextField TF_Hora;

	
	public static AbrirOSGUI getInstance() {
		if (abrirOSGUI == null) {
			return abrirOSGUI = new AbrirOSGUI();
		}
		return abrirOSGUI;
	}
	/**
	 * Create the frame.
	 */
	public AbrirOSGUI() {
		setTitle("Abrir Plano de Medi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(10, 68, 539, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TF_Equipamento = new JTextField();
		TF_Equipamento.setEditable(false);
		TF_Equipamento.setBounds(10, 23, 430, 20);
		panel.add(TF_Equipamento);
		TF_Equipamento.setColumns(10);
		
		JButton BT_Pesq_Equipamento = new JButton("");
		BT_Pesq_Equipamento.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		BT_Pesq_Equipamento.setBounds(481, 17, 30, 30);
		panel.add(BT_Pesq_Equipamento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Grupo T\u00E9cnico Responsavel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 161, 539, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		TF_GrupoTecnico = new JTextField();
		TF_GrupoTecnico.setEditable(false);
		TF_GrupoTecnico.setColumns(10);
		TF_GrupoTecnico.setBounds(10, 25, 430, 20);
		panel_1.add(TF_GrupoTecnico);
		
		JButton BT_Pesq_GrupoTec = new JButton("");
		BT_Pesq_GrupoTec.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		BT_Pesq_GrupoTec.setBounds(481, 17, 30, 30);
		panel_1.add(BT_Pesq_GrupoTec);
		
		JButton BT_Primeiro = new JButton("");
		BT_Primeiro.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		BT_Primeiro.setBounds(10, 11, 30, 30);
		contentPane.add(BT_Primeiro);
		
		JButton BT_Anterior = new JButton("");
		BT_Anterior.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		BT_Anterior.setBounds(43, 11, 30, 30);
		contentPane.add(BT_Anterior);
		
		JButton BT_Proximo = new JButton("");
		BT_Proximo.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		BT_Proximo.setBounds(75, 11, 30, 30);
		contentPane.add(BT_Proximo);
		
		JButton BT_Ultimo = new JButton("");
		BT_Ultimo.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		BT_Ultimo.setBounds(107, 11, 30, 30);
		contentPane.add(BT_Ultimo);
		
		JButton BT_Procurar = new JButton("");
		BT_Procurar.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		BT_Procurar.setBounds(140, 11, 30, 30);
		contentPane.add(BT_Procurar);
		
		JButton BT_Apagar = new JButton("");
		BT_Apagar.setEnabled(false);
		BT_Apagar.setIcon(new ImageIcon(AbrirOSGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		BT_Apagar.setBounds(172, 11, 30, 30);
		contentPane.add(BT_Apagar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Plano de Medi\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 253, 539, 154);
		contentPane.add(panel_2);
		
		JComboBox CB_Tipo = new JComboBox();
		CB_Tipo.setModel(new DefaultComboBoxModel(new String[] {"Di\u00E1rio", "Semanal", "Mensal"}));
		CB_Tipo.setBounds(41, 23, 157, 20);
		panel_2.add(CB_Tipo);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(10, 61, 82, 14);
		panel_2.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(128, 61, 82, 14);
		panel_2.add(lblDataFim);
		
		TF_DtInicio = new JTextField();
		TF_DtInicio.setBounds(10, 76, 86, 20);
		panel_2.add(TF_DtInicio);
		TF_DtInicio.setColumns(10);
		
		TF_DtFim = new JTextField();
		TF_DtFim.setColumns(10);
		TF_DtFim.setBounds(128, 76, 86, 20);
		panel_2.add(TF_DtFim);
		
		JComboBox CB_DiaSemana = new JComboBox();
		CB_DiaSemana.setEnabled(false);
		CB_DiaSemana.setModel(new DefaultComboBoxModel(new String[] {"Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta", "S\u00E1bado", "Domingo"}));
		CB_DiaSemana.setBounds(350, 23, 157, 20);
		panel_2.add(CB_DiaSemana);
		
		JLabel LBL_Tipo = new JLabel("Tipo");
		LBL_Tipo.setBounds(10, 26, 46, 14);
		panel_2.add(LBL_Tipo);
		
		JLabel lblDiasDaSemana = new JLabel("Dias da Semana");
		lblDiasDaSemana.setBounds(264, 26, 106, 14);
		panel_2.add(lblDiasDaSemana);
		
		JComboBox CB_DiaMes = new JComboBox();
		CB_DiaMes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		CB_DiaMes.setEnabled(false);
		CB_DiaMes.setBounds(350, 58, 157, 20);
		panel_2.add(CB_DiaMes);
		
		JLabel lblDiasDoMs = new JLabel("Dias do M\u00EAs");
		lblDiasDoMs.setBounds(264, 61, 106, 14);
		panel_2.add(lblDiasDoMs);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 106, 52, 14);
		panel_2.add(lblHora);
		
		TF_Hora = new JTextField();
		TF_Hora.setColumns(10);
		TF_Hora.setBounds(10, 123, 86, 20);
		panel_2.add(TF_Hora);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBounds(460, 414, 89, 23);
		contentPane.add(btn_Cancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(365, 414, 89, 23);
		contentPane.add(btnSalvar);
	}
}
