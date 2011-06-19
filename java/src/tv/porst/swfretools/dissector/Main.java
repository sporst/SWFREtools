package tv.porst.swfretools.dissector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import tv.porst.swfretools.dissector.console.ConsoleDumper;
import tv.porst.swfretools.dissector.gui.MainWindow;
import tv.porst.swfretools.utils.Decompressor;

/**
 * Main class of Flash Dissector.
 */
public final class Main {

	/**
	 * Determines whether all arguments refer to file names.
	 * 
	 * @param args The arguments to check.
	 * 
	 * @return True, if all arguments refer to file names. False, otherwise.
	 */
	private static boolean isAllFilenames(final String[] args) {

		for (final String arg : args) {
			final File file = new File(arg);

			if (!file.exists()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Main method of Flash Dissector.
	 * 
	 * @param args Command line arguments passed to Flash Dissector.
	 */
	public static void main(final String[] args) {

		final List<String> filesToOpen = new ArrayList<String>();

		if (args.length == 2 && args[0].equals("-dump")) {

			ConsoleDumper.dump(args[1]);

			return;
		}
		else if (args.length == 4 && args[0].equals("-decompress") && args[2].equals("-o")) {

			Decompressor.decompress(args[1], args[3]);

			return;
		}
		else if (isAllFilenames(args)) {
			for (final String filename : args) {
				filesToOpen.add(filename);
			}
		}
		else if (args.length != 0) {
			System.out.println("Usage: dissector.jar options");
			System.out.println();
			System.out.println("  -dump [file]                            : Dumps the content of the SWF file");
			System.out.println("  -decompress [inputfile] -o [outputfile] : Decompresses the input file");
			return;
		}

		final MainWindow window = new MainWindow(filesToOpen);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}