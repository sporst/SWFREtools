package tv.porst.swfretools.parser.actions;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.BinaryParser;
import tv.porst.splib.binaryparser.BinaryParserHelpers;

/**
 * Class responsible for parsing actions.
 * 
 * @author sp
 *
 */
public final class ActionRecordParser {

	/**
	 * Parses a list of actions.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param actionRecordSize Number of bytes to parse into action objects.
	 * 
	 * @return The parsed actions.
	 */
	public static List<Action> parse(final BinaryParser parser, final long actionRecordSize) {

		BinaryParserHelpers.readByteArray(parser, (int) actionRecordSize);

		return new ArrayList<Action>();
	}

}
