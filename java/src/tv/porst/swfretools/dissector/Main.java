package tv.porst.swfretools.dissector;

import javax.swing.JFrame;

import tv.porst.swfretools.dissector.console.ConsoleDumper;
import tv.porst.swfretools.dissector.gui.MainWindow;
import tv.porst.swfretools.utils.Decompressor;

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
		else if (args.length == 4 && args[0].equals("-decompress") && args[2].equals("-o")) {

			Decompressor.decompress(args[1], args[3]);

			return;
		}
		else if (args.length != 0) {
			System.out.println("Usage: dissector.jar options");
			System.out.println();
			System.out.println("  -dump [file]                            : Dumps the content of the SWF file");
			System.out.println("  -decompress [inputfile] -o [outputfile] : Decompresses the input file");
			return;
		}

		final MainWindow window = new MainWindow();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}