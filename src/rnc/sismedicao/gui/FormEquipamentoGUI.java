package rnc.sismedicao.gui;

import rnc.sismedicao.gui.util.ConfiguracaoDeComponentesGUI;
import rnc.sismedicao.gui.util.InterfaceFormGUI;
import rnc.sismedicao.gui.util.NewJFrameForm;
import javafx.scene.control.ToolBar;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import rnc.sismedicao.gui.util.NewJTextField;

@SuppressWarnings("serial")
public class FormEquipamentoGUI extends NewJFrameForm implements InterfaceFormGUI{
	
	private static final int TELA_WIDTH = 600;
	private static final int TELA_HEIGTH = 400;
	
	private static FormEquipamentoGUI formEquipamentoGUI;
	
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
		tabbedPane.setBounds(10, 35, 541, 263);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		NewJTextField newJTextField = new NewJTextField();
		panel.add(newJTextField);
		
	}
	
	
	@Override
	public void mouseClickedNovo() {
		System.out.println("Teste na GUI");
	}
	
	@Override
	public void requestDefaultFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClickedExcluir() {
		// TODO Auto-generated method stub
		
	}
}
