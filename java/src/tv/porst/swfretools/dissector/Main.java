package tv.porst.swfretools.dissector;

import javax.swing.JFrame;

import tv.porst.swfretools.dissector.console.ConsoleDumper;
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

		if (args.length == 2 && args[0].equals("-dump")) {

			ConsoleDumper.dump(args[1]);

			return;
		}

		final MainWindow window = new MainWindow();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}