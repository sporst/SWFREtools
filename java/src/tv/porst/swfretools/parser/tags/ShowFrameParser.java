package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing ShowFrame tags.
 * 
 * @author sp
 */
public final class ShowFrameParser {

	/**
	 * Parses a ShowFrame tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 */
	public static ShowFrameTag parse(final RecordHeader header, final BinaryParser parser) {
		return new ShowFrameTag(header);
	}
}