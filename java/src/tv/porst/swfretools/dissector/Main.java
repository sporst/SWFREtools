package tv.porst.swfretools.dissector;

import java.io.File;
import java.io.IOException;

import tv.porst.splib.file.DirectoryTraverser;
import tv.porst.splib.file.IDirectoryTraversalVisitor;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;

public class Main {

	public static void main(final String[] args) {

		DirectoryTraverser.recurse(new File("C:\\@@\\flash"), new IDirectoryTraversalVisitor() {

			@Override
			public void visit(final File file) {

				if (!file.getAbsolutePath().endsWith("swf")) {
					return;
				}

				System.out.println(file.getAbsolutePath());
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