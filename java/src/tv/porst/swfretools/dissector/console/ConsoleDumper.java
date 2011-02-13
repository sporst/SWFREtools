package tv.porst.swfretools.dissector.console;

import java.io.File;

import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.utils.ISWFVisitor;
import tv.porst.swfretools.utils.SWFIterator;

public class ConsoleDumper {

	public static void dump(final File inputFile, final SWFFile parsedFile) {

		final ISWFVisitor visitor = new ConsoleVisitor(inputFile);
		SWFIterator.visit(parsedFile, visitor);
	}
}
