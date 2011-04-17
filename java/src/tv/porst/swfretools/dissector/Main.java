package tv.porst.swfretools.dissector;

import javax.swing.JFrame;

import tv.porst.swfretools.dissector.gui.MainWindow;

/**
 * Main class of Flash Dissector.
 */
public final class Main {

	/**
	 * Main method of Flash Dissector.
	 * 
	 * @param args Command line arguments passed to Flash Dissector.
	 */
	public static void main(final String[] args) {

		final MainWindow window = new MainWindow();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}