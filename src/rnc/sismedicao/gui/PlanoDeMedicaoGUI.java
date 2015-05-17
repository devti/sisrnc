package rnc.sismedicao.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import rnc.sismedicao.controller.exception.DadosObrigatoriosException;
import rnc.sismedicao.fachada.Fachada;
import rnc.sismedicao.model.beans.*;
import rnc.sismedicao.model.util.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class PlanoDeMedicaoGUI extends JFrame {

	private JPanel contentPane;
	private static PlanoDeMedicaoGUI abrirOSGUI;
	private Fachada fachada;
	private ArrayList<Equipamento> lista;
	private JTextField tF_Equipamento;
	private JTextField tF_GrupoTecnico;
	private ProcuraEquipamentoGUI telaProcurarEquipamento;
	private ProcuraGrupoTecnicoGUI teleProcuraGrupoTecnico;
	private Equipamento equipamento = null;
	private GrupoTecnico grupoTecnico = null;
	private JFormattedTextField fTF_DataInicio;
	private JFormattedTextField fTF_DataFim;
	private JFormattedTextField fTF_Hora;
	private JComboBox CB_Tipo;
	private JComboBox CB_DiaMes;
	private JComboBox CB_DiaSemana;
	private JCheckBox cb_Ativo;
	private Calendar dtInicial = Calendar.getInstance();
	private Calendar dtFinal = Calendar.getInstance();
	private Calendar dtContagem = Calendar.getInstance();
	private PlanoDeMedicao planoDeMedicao;
	private OrdemServico ordemServico;
	private JTextField tF_Descricao;
	private ProcuraPlanoDeMedicaoGUI tela;
	private JTextField tF_codigoPlanoDeMedicao;
	private JButton BT_Apagar;
	private int codigoPlanoDeMedicao;
	//private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");  

	public static PlanoDeMedicaoGUI getInstance() {
		if (abrirOSGUI == null) {
			return abrirOSGUI = new PlanoDeMedicaoGUI();
		}
		return abrirOSGUI;
	}

	/**
	 * Create the frame.
	 */
	public PlanoDeMedicaoGUI() {
		setTitle("Abrir Plano de Medi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Equipamento",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(10, 111, 539, 62);
		contentPane.add(panel);
		panel.setLayout(null);

		tF_Equipamento = new JTextField();
		tF_Equipamento.setEditable(false);
		tF_Equipamento.setBounds(10, 23, 430, 20);
		panel.add(tF_Equipamento);
		tF_Equipamento.setColumns(10);

		/**
		 * BOTAO PROCURAR EQUIPAMENTO
		 */
		JButton BT_Pesq_Equipamento = new JButton("");
		BT_Pesq_Equipamento.setToolTipText("Localizar Equipamento");
		BT_Pesq_Equipamento
				.setIcon(new ImageIcon(
						PlanoDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		BT_Pesq_Equipamento.setBounds(481, 17, 30, 30);
		panel.add(BT_Pesq_Equipamento);
		BT_Pesq_Equipamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procurarEquipamento();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Grupo T\u00E9cnico Responsavel", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 186, 539, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		tF_GrupoTecnico = new JTextField();
		tF_GrupoTecnico.setEditable(false);
		tF_GrupoTecnico.setColumns(10);
		tF_GrupoTecnico.setBounds(10, 25, 430, 20);
		panel_1.add(tF_GrupoTecnico);

		/**
		 * METODO PROCURAR GRUPO TECNICO
		 */
		JButton BT_Pesq_GrupoTec = new JButton("");
		BT_Pesq_GrupoTec.setToolTipText("Localizar Grupo Tecnico");
		BT_Pesq_GrupoTec
				.setIcon(new ImageIcon(
						PlanoDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Search.png")));
		BT_Pesq_GrupoTec.setBounds(481, 17, 30, 30);
		panel_1.add(BT_Pesq_GrupoTec);
		BT_Pesq_GrupoTec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procurarGrupoTecnico();
			}
		});

		JButton BT_Primeiro = new JButton("");
		BT_Primeiro.setEnabled(false);
		BT_Primeiro
				.setIcon(new ImageIcon(
						PlanoDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/First.png")));
		BT_Primeiro.setBounds(45, 11, 30, 30);
		contentPane.add(BT_Primeiro);

		JButton BT_Anterior = new JButton("");
		BT_Anterior.setEnabled(false);
		BT_Anterior.setIcon(new ImageIcon(PlanoDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Back.png")));
		BT_Anterior.setBounds(78, 11, 30, 30);
		contentPane.add(BT_Anterior);

		JButton BT_Proximo = new JButton("");
		BT_Proximo.setEnabled(false);
		BT_Proximo
				.setIcon(new ImageIcon(
						PlanoDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Forward.png")));
		BT_Proximo.setBounds(110, 11, 30, 30);
		contentPane.add(BT_Proximo);

		JButton BT_Ultimo = new JButton("");
		BT_Ultimo.setEnabled(false);
		BT_Ultimo.setIcon(new ImageIcon(PlanoDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Last.png")));
		BT_Ultimo.setBounds(142, 11, 30, 30);
		contentPane.add(BT_Ultimo);

		JButton BT_Procurar = new JButton("");
		BT_Procurar.setToolTipText("Pesquisar");
		BT_Procurar.setIcon(new ImageIcon(PlanoDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/Find.png")));
		BT_Procurar.setBounds(175, 11, 30, 30);
		contentPane.add(BT_Procurar);
		BT_Procurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});

		BT_Apagar = new JButton("");
		BT_Apagar.setToolTipText("Excluir");
		BT_Apagar.setEnabled(false);
		BT_Apagar
				.setIcon(new ImageIcon(
						PlanoDeMedicaoGUI.class
								.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png")));
		BT_Apagar.setBounds(207, 11, 30, 30);
		contentPane.add(BT_Apagar);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Plano de Medi\u00E7\u00E3o", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 253, 539, 154);
		contentPane.add(panel_2);

		CB_Tipo = new JComboBox();
		CB_Tipo.setModel(new DefaultComboBoxModel(new String[] { "Di\u00E1rio",
				"Semanal", "Mensal" }));
		CB_Tipo.setBounds(41, 23, 157, 20);
		panel_2.add(CB_Tipo);
		CB_Tipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CB_Tipo.getSelectedItem() == "Semanal") {
					CB_DiaSemana.setEnabled(true);
					CB_DiaMes.setEnabled(false);
				}
				if (CB_Tipo.getSelectedItem() == "Mensal") {
					CB_DiaMes.setEnabled(true);
					CB_DiaSemana.setEnabled(false);
				}

			}
		});

		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(10, 61, 82, 14);
		panel_2.add(lblDataInicio);

		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(128, 61, 82, 14);
		panel_2.add(lblDataFim);

		CB_DiaSemana = new JComboBox();
		CB_DiaSemana.setEnabled(false);
		CB_DiaSemana.setModel(new DefaultComboBoxModel(new String[] {
				"Domingo", "Segunda", "Ter\u00E7a", "Quarta", "Quinta",
				"Sexta", "S\u00E1bado" }));
		CB_DiaSemana.setBounds(350, 23, 157, 20);
		panel_2.add(CB_DiaSemana);

		JLabel LBL_Tipo = new JLabel("Tipo");
		LBL_Tipo.setBounds(10, 26, 46, 14);
		panel_2.add(LBL_Tipo);

		JLabel lblDiasDaSemana = new JLabel("Dias da Semana");
		lblDiasDaSemana.setBounds(264, 26, 106, 14);
		panel_2.add(lblDiasDaSemana);

		CB_DiaMes = new JComboBox();
		CB_DiaMes.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		CB_DiaMes.setEnabled(false);
		CB_DiaMes.setBounds(350, 58, 157, 20);
		panel_2.add(CB_DiaMes);

		JLabel lblDiasDoMs = new JLabel("Dias do M\u00EAs");
		lblDiasDoMs.setBounds(264, 61, 106, 14);
		panel_2.add(lblDiasDoMs);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 106, 52, 14);
		panel_2.add(lblHora);

		fTF_DataFim = new JFormattedTextField((setMascara("##/##/####")));
		fTF_DataFim.setBounds(126, 76, 86, 20);
		panel_2.add(fTF_DataFim);
		fTF_DataFim.setColumns(10);

		fTF_Hora = new JFormattedTextField((setMascara("##:##")));
		fTF_Hora.setBounds(10, 121, 86, 20);
		panel_2.add(fTF_Hora);

		fTF_DataInicio = new JFormattedTextField((setMascara("##/##/####")));
		fTF_DataInicio.setBounds(10, 76, 86, 20);
		panel_2.add(fTF_DataInicio);
		fTF_DataInicio.setColumns(10);

		/**
		 * Check BOX ATIVO
		 */
		cb_Ativo = new JCheckBox("Ativo");
		cb_Ativo.setBounds(446, 120, 61, 23);
		panel_2.add(cb_Ativo);
		cb_Ativo.setSelected(true);

		/**
		 * BOTAO CANCELAR
		 */
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBounds(460, 414, 89, 23);
		contentPane.add(btn_Cancelar);
		btn_Cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparTela();
				dispose();

			}
		});

		/**
		 * BOTAO SALVAR
		 */
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(365, 414, 89, 23);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					salvar();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton button = new JButton("");
		button.setToolTipText("Novo");
		button.setIcon(new ImageIcon(PlanoDeMedicaoGUI.class
				.getResource("/rnc/sismedicao/gui/icons/icons16x16/1.png")));
		button.setBounds(10, 11, 30, 30);
		contentPane.add(button);
		
		JLabel lDescricao = new JLabel("Descri\u00E7\u00E3o");
		lDescricao.setBounds(21, 63, 64, 14);
		contentPane.add(lDescricao);
		
		tF_Descricao = new JTextField();
		tF_Descricao.setBounds(21, 77, 433, 20);
		contentPane.add(tF_Descricao);
		tF_Descricao.setColumns(10);
		
		tF_codigoPlanoDeMedicao = new JTextField();
		tF_codigoPlanoDeMedicao.setHorizontalAlignment(SwingConstants.RIGHT);
		tF_codigoPlanoDeMedicao.setEditable(false);
		tF_codigoPlanoDeMedicao.setBounds(463, 24, 86, 20);
		contentPane.add(tF_codigoPlanoDeMedicao);
		tF_codigoPlanoDeMedicao.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(408, 27, 46, 14);
		contentPane.add(lblCodigo);
	}

	/**
	 * METODO PARA PROCURAR EQUIPAMENTO
	 */
	public void procurarEquipamento() {
		telaProcurarEquipamento = new ProcuraEquipamentoGUI();
		telaProcurarEquipamento.setVisible(true);
		if (telaProcurarEquipamento.getFocusableWindowState()
				&& telaProcurarEquipamento.pegarEquipamento() != null) {
			this.equipamento = telaProcurarEquipamento.pegarEquipamento();
			tF_Equipamento.setText(equipamento.getDescricao());

		}
	}

	/**
	 * METODO PARA PROCURAR GRUPO TECNICO
	 */
	public void procurarGrupoTecnico() {
		teleProcuraGrupoTecnico = new ProcuraGrupoTecnicoGUI();
		teleProcuraGrupoTecnico.setVisible(true);
		if (teleProcuraGrupoTecnico.getFocusableWindowState()
				&& teleProcuraGrupoTecnico.pegarGrupoTecnico() != null) {
			grupoTecnico = teleProcuraGrupoTecnico.pegarGrupoTecnico();
			tF_GrupoTecnico.setText(grupoTecnico.getNomeGrupoTecnico());
		}
	}

	/**
	 * METODO PARA FORMATAR UM CAMPO
	 */
	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
		}
		return mask;
	}

	/**
	 * METODO PARA SALVAR
	 * 
	 * @throws ParseException
	 * @throws Exception
	 */
	public void salvar() throws ParseException {
		try {
			if (tF_Equipamento.getText().isEmpty()
					|| tF_Descricao.getText().isEmpty()
					|| tF_GrupoTecnico.getText().isEmpty()
					|| fTF_DataFim.getText().isEmpty()
					|| fTF_DataInicio.getText().isEmpty()
					|| fTF_Hora.getText().isEmpty())
				throw new DadosObrigatoriosException();
			// Valida as data e hora
			dtValida(fTF_DataInicio.getText());
			dtValida(fTF_DataFim.getText());
			validarHora(fTF_Hora.getText());
			fachada = Fachada.getInstance();
			// Converte para tipo Calendar
			dtInicial
					.set(Integer.parseInt(fTF_DataInicio.getText().substring(6,
							10)), (Integer.parseInt(fTF_DataInicio.getText()
							.substring(3, 5)) - 1), Integer
							.parseInt(fTF_DataInicio.getText().substring(0, 2)));
			dtFinal.set(
					Integer.parseInt(fTF_DataFim.getText().substring(6, 10)),
					(Integer.parseInt(fTF_DataFim.getText().substring(3, 5)) - 1),
					Integer.parseInt(fTF_DataFim.getText().substring(0, 2)));
			// Salvo o Plano de Medicao na tabela PlnadoDeMedicao
			planoDeMedicao = new PlanoDeMedicao(tF_Descricao.getText(),grupoTecnico, equipamento,
					converteCalendarString(dtInicial,fTF_Hora.getText()),
					converteCalendarString(dtFinal,fTF_Hora.getText()), fTF_Hora.getText(),
					CB_DiaSemana.getSelectedItem().toString(), CB_DiaMes
							.getSelectedItem().toString(), CB_Tipo.getSelectedItem().toString());
			// Verifica se a data inicial e maior ou igual que a data final
			if (dtFinal.after(dtInicial) || dtInicial.equals(dtFinal)) {
				fachada.cadastrar(planoDeMedicao);
				dtContagem = dtInicial;
				// tipo diario
				if (CB_Tipo.getSelectedItem() == "Diário") {
					int quantidadeDias = diasEntre(fTF_DataInicio.getText(),
							fTF_DataFim.getText());
					for (int i = 0; i < quantidadeDias; i++) {
						ordemServico = new OrdemServico(
								fachada.consultarUltimoCodigoPlanoMedicao(),
								grupoTecnico, equipamento,
								converteCalendarString(dtContagem,fTF_Hora.getText()),
								fTF_Hora.getText());
						//System.out.println(converteCalendarString(dtContagem,fTF_Hora.getText()));
						fachada.cadastrar(ordemServico);
						dtContagem.add(Calendar.DATE, 1);
					}
				}
				// tipo semanal
				if (CB_Tipo.getSelectedItem() == "Semanal") {
					int quantidadeDias = diasEntre(fTF_DataInicio.getText(),
							fTF_DataFim.getText());
					for (int i = 0; i <= quantidadeDias; i++) {
						dtContagem.add(Calendar.DATE, 1);
						if (dtContagem.get(Calendar.DAY_OF_WEEK) == (CB_DiaSemana
								.getSelectedIndex()+1)) {
							ordemServico = new OrdemServico(fachada.consultarUltimoCodigoPlanoMedicao(),
									grupoTecnico, equipamento,
									converteCalendarString(dtContagem,fTF_Hora.getText()), fTF_Hora
											.getText());
							fachada.cadastrar(ordemServico);
						}
					}
				}
				// Tipo Mensal
				if (CB_Tipo.getSelectedItem() == "Mensal") {
					int quantidadeDias = diasEntre(fTF_DataInicio.getText(),
							fTF_DataFim.getText());
					for (int i = 0; i <= quantidadeDias; i++) {
						dtContagem.add(Calendar.DATE, 1);
						if (CB_DiaMes.getSelectedItem().equals(
								Integer.toString(dtContagem
										.get(Calendar.DAY_OF_MONTH)))) {
							ordemServico = new OrdemServico(
									fachada.consultarUltimoCodigoPlanoMedicao(),
									grupoTecnico, equipamento,
									converteCalendarString(dtContagem,fTF_Hora.getText()), fTF_Hora
											.getText());
							fachada.cadastrar(ordemServico);
						}
					}
				}
				limparTela();
				dispose();
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
						"Data inicial MENOR que a data final!", "Aviso",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (DadosObrigatoriosException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"Aviso", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * METODO PARA LIMPAR A TELA
	 */
	private void limparTela() {
		tF_Descricao.setText(null);;
		tF_Equipamento.setText(null);
		tF_GrupoTecnico.setText(null);
		fTF_DataFim.setText(null);
		fTF_DataInicio.setText(null);
		fTF_Hora.setText(null);
		cb_Ativo.setSelected(true);
		tF_codigoPlanoDeMedicao.setText(null);
	}
	
	/**
	 * METODO PARA PROCURAR PLANO DE MEDICAO
	 */
	public void procurar() {
		tela = new ProcuraPlanoDeMedicaoGUI();
		tela.setVisible(true);
		if (tela.getFocusableWindowState() && tela.pegarPlanoDeMedicao() != null) {
			PlanoDeMedicao planoDeMedicao = tela.pegarPlanoDeMedicao();
			tF_Descricao.setText(planoDeMedicao.getDescricao());
			tF_Descricao.setEnabled(false);
			tF_Equipamento.setText(planoDeMedicao.getEquipamento().getDescricao());
			tF_GrupoTecnico.setText(planoDeMedicao.getGrupoTecnico().getLocalizacao());
			tF_codigoPlanoDeMedicao.setText(Integer.toString(planoDeMedicao.getCodigo()));
			fTF_DataInicio.setText(Data.converteDataStringTextField(planoDeMedicao.getDataInicial()));
			fTF_DataInicio.setEditable(false);
			fTF_DataFim.setText(Data.converteDataStringTextField(planoDeMedicao.getDataFinal()));
			fTF_DataFim.setEditable(false);
			fTF_Hora.setText(planoDeMedicao.getHorario());
			fTF_Hora.setEditable(false);
			CB_Tipo.setSelectedItem(planoDeMedicao.getTipo());
			CB_Tipo.setEnabled(false);
			CB_DiaMes.setSelectedItem(planoDeMedicao.getDiaMes());
			CB_DiaMes.setEnabled(false);
			CB_DiaSemana.setSelectedItem(planoDeMedicao.getDiaSemana());
			CB_DiaSemana.setEnabled(false);
			tF_codigoPlanoDeMedicao.setText(Integer.toString(planoDeMedicao.getCodigo()));
			codigoPlanoDeMedicao = planoDeMedicao.getCodigo();
			/*
			 * ativando botoes
			 */
			BT_Apagar.setEnabled(true);

			//btnRemover.setEnabled(true);
			
		}
	}
	/**
	 * METODO PARA VALIDAR UMA DATA
	 */
	private void dtValida(String data) throws ParseException {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		dt.setLenient(false); // aqui o pulo do gato
		try {
			dt.parse(data);
			// data válida
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(),
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * METODO PARA VALIDAR HORA
	 */
	private void validarHora(String hora) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		sdf.setLenient(false);
		try {
			sdf.parse(hora);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(),
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * METODO PARA QUANTIDADE DE DIAS ENTRE DUAS DATA
	 */
	public int diasEntre(String a, String b) {
		Calendar dInicial = Calendar.getInstance();
		dInicial.set(Integer.parseInt(a.substring(6, 10)),
				(Integer.parseInt(a.substring(3, 5)) - 1),
				Integer.parseInt(a.substring(0, 2)));
		;
		Calendar dFinal = Calendar.getInstance();
		dFinal.set(Integer.parseInt(b.substring(6, 10)),
				(Integer.parseInt(b.substring(3, 5)) - 1),
				Integer.parseInt(b.substring(0, 2)));

		return Data.calculateDays(dInicial, dFinal);
	}

	/**
	 * CONVERTER CALENDAR EM STRING
	 * 
	 */
	public String converteCalendarString(Calendar data, String hora) {
		String dt, dd, mm, aaaa = null;
		dd = zeroEsquerda(
				Integer.toString(data.get(Calendar.DAY_OF_MONTH)), "0", 2);
		mm = zeroEsquerda(Integer.toString(dtContagem.get(Calendar.MONTH) + 1),
				"0", 2);
		aaaa = Integer.toString(data.get(Calendar.YEAR));
		dt = aaaa + "-" + dd + "-" + mm +" "+hora.substring(0, 2)+":"+hora.substring(3, 4);
		return dt;
	}

	/**
	 * Zero a Esquerda
	 */
	public static String zeroEsquerda(String valueToPad, String filler, int size) {
		while (valueToPad.length() < size) {
			valueToPad = filler + valueToPad;
		}
		return valueToPad;
	}

}