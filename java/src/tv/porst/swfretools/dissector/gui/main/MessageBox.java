package tv.porst.swfretools.dissector.gui.main;

import java.awt.Window;

import javax.swing.JOptionPane;

/**
 * Contains functions for displaying message boxes to the user.
 */
public final class MessageBox {

	/**
	 * Shows an error message box to the user.
	 * 
	 * @param parent Parent window the message box.
	 * @param message Error message to show to the user.
	 */
	public static void showError(final Window parent, final String message) {
		JOptionPane.showMessageDialog(parent, message);
	}
}