package rnc.sismedicao.gui.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.gui.FormUnidadeDeMedicaoGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class NewJFrameForm extends JFrame {

	public JPanel contentPane;
	public JToolBar toolBar;
	public JLabel label; 
	
	public NewJFrameForm() throws HeadlessException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 5, 434, 22);
		toolBar.setFloatable(false);
		contentPane.add(toolBar);
		
		label = new JLabel("");
		label.setMinimumSize(new Dimension(24, 16));
		label.setMaximumSize(new Dimension(8, 16));
		label.setDoubleBuffered(true);
		label.setAlignmentX(0.5f);
		toolBar.add(label);
		
		JLabel LB_NovoIcon = new JLabel("");
		LB_NovoIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedNovo();
				System.out.println("Novo");
			}

		});
		LB_NovoIcon.setToolTipText("Novo");
		LB_NovoIcon.setIcon(new ImageIcon(FormUnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png")));
		LB_NovoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		LB_NovoIcon.setMinimumSize(new Dimension(24, 16));
		LB_NovoIcon.setMaximumSize(new Dimension(24, 16));
		LB_NovoIcon.setDoubleBuffered(true);
		toolBar.add(LB_NovoIcon);
		
		JLabel LB_ExcluirIcon = new JLabel("");
		LB_ExcluirIcon.setIcon(new ImageIcon(FormUnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png")));
		LB_ExcluirIcon.setToolTipText("Excluir");
		LB_ExcluirIcon.setMinimumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setMaximumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setDoubleBuffered(true);
		LB_ExcluirIcon.setAlignmentX(0.5f);
		toolBar.add(LB_ExcluirIcon);
		
		JSeparator separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setDoubleBuffered(true);
		toolBar.add(separator);
	}

	public NewJFrameForm(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public NewJFrameForm(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public NewJFrameForm(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void mouseClickedNovo() {
		System.out.println("Teste na NewJFrameForm");
	}

	
	
	
}
