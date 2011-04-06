package tv.porst.swfretools.dissector;

import java.io.File;
import java.io.IOException;

import tv.porst.splib.file.DirectoryTraverser;
import tv.porst.splib.file.IDirectoryTraversalVisitor;
import tv.porst.splib.io.FileHelpers;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;

public class Main {

	public static void main(final String[] args) {

		DirectoryTraverser.recurse(new File("C:\\@@\\swftest"), new IDirectoryTraversalVisitor() {

			@Override
			public void visit(final File file) {

				if (FileHelpers.extractFilename(file.getAbsolutePath()).toLowerCase().charAt(0) < 'a') {
					return;
				}

				if (file.getAbsolutePath().contains("apple")) {
					return;
				}

				if (file.getAbsolutePath().contains("aqua")) {
					return;
				}

				if (file.getAbsolutePath().contains("4W")) {
					return;
				}

				if (file.getAbsolutePath().contains("alanbecker")) {
					return;
				}

				if (file.getAbsolutePath().contains("BSH")) {
					return;
				}

				if (file.getAbsolutePath().contains("sponsors")) {
					return;
				}

				if (file.getAbsolutePath().contains("puppy")) {
					return;
				}

				if (file.getAbsolutePath().contains("Downes")) {
					return;
				}

				if (file.getAbsolutePath().contains("Everlink")) {
					return;
				}

				if (file.getAbsolutePath().contains("flashflood")) {
					return;
				}

				if (file.getAbsolutePath().contains("foo.swf")) {
					return;
				}

				if (file.getAbsolutePath().contains("kingsco")) {
					return;
				}

				if (file.getAbsolutePath().contains("submachine")) {
					return;
				}

				if (file.getAbsolutePath().contains("SWF1")) {
					return;
				}

				if (file.getAbsolutePath().contains("swfToLoad")) {
					return;
				}

				if (file.getAbsolutePath().contains("TCYT")) {
					return;
				}

				if (file.getAbsolutePath().contains("the-last")) {
					return;
				}

				if (file.getAbsolutePath().contains("UNESCO")) {
					return;
				}

				if (file.getAbsolutePath().contains("wildfire")) {
					return;
				}

				if (!file.getAbsolutePath().endsWith("decompressed")) {
					return;
				}

				System.out.println("Parsing " + file.getAbsolutePath());

				try {
					SWFParser.parse(file);
				} catch (final IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(0);
				} catch (final SWFParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(0);
				}
			}
		});
	}
}