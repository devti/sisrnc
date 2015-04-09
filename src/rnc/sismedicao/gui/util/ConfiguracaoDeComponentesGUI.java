package rnc.sismedicao.gui.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.border.BevelBorder;

/**
 * 
 * @author Charles Arruda
 * @category Util
 *
 */
public class ConfiguracaoDeComponentesGUI {

	private static Toolkit toolKit = null;
	private static Dimension dimension = null;

	private static final int DIVISOR_LARGURA = 2;
	private static final int DIVISOR_ALTURA = 6;

	private ConfiguracaoDeComponentesGUI() {

	}

	/*
	 * Início do Overload do método contralizaFrame
	 */
	/**
	 * @author Charles Arruda
	 * @category Util
	 * @param frame
	 */
	public static void centralizaFrame(Frame frame) {
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
		int x = (int) (dimension.getWidth() - frame.getWidth())
				/ DIVISOR_LARGURA;
		int y = (int) (dimension.getHeight() - frame.getHeight())
				/ DIVISOR_ALTURA;

		frame.setBounds(x, y, frame.getWidth(), frame.getHeight());

		System.out.println("\nInicializando tela: " + frame.getTitle()
				+ "\n Posição H: " + x + "\nPosição V: " + y
				+ "\nResolução do Monitor: " + (int) dimension.getWidth() + "x"
				+ (int) dimension.getHeight());
	}

	/**
	 * 
	 * @author Charles Arruda
	 * @category Util
	 * @param frame
	 * @param resizable
	 */
	public static void centralizaFrame(Frame frame, boolean resizable) {

		centralizaFrame(frame);

		frame.setResizable(resizable);

		System.out.println("Resizable: " + resizable + "\n");
	}

	/**
	 * @author Charles Arruda
	 * @category Util
	 * @param frame
	 * @param width
	 * @param heigth
	 */
	public static void centralizaFrame(Frame frame, int width, int heigth) {
		toolKit = Toolkit.getDefaultToolkit();
		dimension = toolKit.getScreenSize();
		int x = (int) (dimension.getWidth() - width) / DIVISOR_LARGURA;
		int y = (int) (dimension.getHeight() - heigth) / DIVISOR_ALTURA;


		frame.setBounds(x, y,  width, heigth);

		System.out.printf("\nInicializando tela: " + frame.getTitle()
				+ "\nPosição H: " + x + "\nPosição V: " + y
				+ "\nResolução da tela: " + width + "x" + heigth
				+ "\nResolução do Monitor: " + (int) dimension.getWidth() + "x"
				+ (int) dimension.getHeight() + "\n");
	}

	/**
	 * @author Charles Arruda
	 * @category Util
	 * @param frame
	 * @param width
	 * @param heigth
	 * @param resizable
	 */
	public static void centralizaFrame(Frame frame, int width, int heigth,
			boolean resizable) {

		centralizaFrame(frame, width, heigth);

		frame.setResizable(resizable);

		System.out.println("Resizable: " + resizable + "\n");

	}

	/*
	 * Fim do Overload do método centralizaFrame
	 */

	/**
	 * Configura uma Text Field com borda Bevel, método utilizado para manter um
	 * padrão no sistema.
	 * 
	 * @author Charles Arruda
	 * @category Util
	 * @param jTextField
	 * 
	 */

	public static void configuraJTextField(JTextField jTextField) {
		jTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(
				211, 211, 211), null, null, null));
		jTextField.setBackground(Color.WHITE);
		jTextField.setColumns(10);

	}

	/**
	 * Transforma uma Label em um botão com borda do tipo Bevel.
	 * 
	 * @author Charles Arruda
	 * @category Util
	 * @param jLabel
	 * 
	 */
	public static void CriarButtonBevelDeLabel(final JLabel jLabel) {
		jLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, new Color(
				220, 220, 220), null, null));
		jLabel.setForeground(new Color(0, 0, 0));
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setForeground(new Color(0, 0, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null,
						new Color(220, 220, 220), null, null));
				jLabel.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
						new Color(220, 220, 220), null, null));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null,
						new Color(220, 220, 220), null, null));
			}
		});

	}

	public static Popup showTooltip(JComponent component) {
		// Point p = component.getLocationOnScreen();
		JToolTip tip = component.createToolTip();
		tip.setTipText(component.getToolTipText());
		PopupFactory popupFactory = PopupFactory.getSharedInstance();
		Popup popup = popupFactory.getPopup(component, tip,
				component.getWidth() + 10, +component.getHeight() + 2);
		return popup;
	}

}
