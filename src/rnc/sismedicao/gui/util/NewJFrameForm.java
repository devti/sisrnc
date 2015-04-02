package rnc.sismedicao.gui.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import rnc.sismedicao.gui.FormUnidadeDeMedicaoGUI;

@SuppressWarnings("serial")
public class NewJFrameForm extends JFrame {

	public JPanel toolBarPane;
	public JLabel label;
	public JLabel LB_NovoIcon;
	public JLabel LB_ExcluirIcon;
	public JSeparator separator;
	
	public ImageIcon imageIconNovoMouseOut;
	public ImageIcon imageIconNovoMouseIn;
	private ImageIcon imageIconExcluirMouseOut;
	private ImageIcon imageIconExcluirMouseIn;
	
	public NewJFrameForm() throws HeadlessException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setRootPaneCheckingEnabled(false);
		
		toolBarPane = new JPanel();
		toolBarPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(toolBarPane);
		toolBarPane.setLayout(null);
		
		
		label = new JLabel("");
		label.setMinimumSize(new Dimension(24, 16));
		label.setMaximumSize(new Dimension(8, 16));
		label.setDoubleBuffered(true);
		label.setAlignmentX(0.5f);
		
		
		LB_NovoIcon = new JLabel("");
		imageIconNovoMouseOut = new ImageIcon(FormUnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/New document.png"));
		imageIconNovoMouseIn = new ImageIcon(FormUnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/2.png"));
		LB_NovoIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedNovo();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				LB_NovoIcon.setIcon(imageIconNovoMouseIn);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LB_NovoIcon.setIcon(imageIconNovoMouseOut);
			}
		});
		LB_NovoIcon.setToolTipText("Novo");
		LB_NovoIcon.setIcon(imageIconNovoMouseOut);
		LB_NovoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		LB_NovoIcon.setMinimumSize(new Dimension(24, 16));
		LB_NovoIcon.setMaximumSize(new Dimension(24, 16));
		LB_NovoIcon.setDoubleBuffered(true);
		
		LB_ExcluirIcon = new JLabel("");
		imageIconExcluirMouseOut = new ImageIcon(FormUnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Erase.png"));
		imageIconExcluirMouseIn = new ImageIcon(FormUnidadeDeMedicaoGUI.class.getResource("/rnc/sismedicao/gui/icons/icons16x16/Delete.png"));
		LB_ExcluirIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedExcluir();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				LB_ExcluirIcon.setIcon(imageIconExcluirMouseIn);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LB_ExcluirIcon.setIcon(imageIconExcluirMouseOut);
			}
		});
		LB_ExcluirIcon.setIcon(imageIconExcluirMouseOut);
		LB_ExcluirIcon.setToolTipText("Excluir");
		LB_ExcluirIcon.setMinimumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setMaximumSize(new Dimension(24, 16));
		LB_ExcluirIcon.setDoubleBuffered(true);
		LB_ExcluirIcon.setAlignmentX(0.5f);	
		
		separator = new JSeparator();
		separator.setMinimumSize(new Dimension(8, 16));
		separator.setMaximumSize(new Dimension(8, 16));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setDoubleBuffered(true);
	}

	
	public void mouseClickedNovo() {
		System.out.println("Esse método deve ser sobreescrito");
	}

//	public void requestDefaultFocus() {
//		System.out.println("Esse método deve ser sobreescrito");
//	}

	public void mouseClickedExcluir() {
		System.out.println("Esse método deve ser sobreescrito");
	}

	
	
	
}
