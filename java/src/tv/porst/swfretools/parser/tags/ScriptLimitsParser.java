package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ScriptLimitsParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int maxRecursionDepth = parser.readUInt16();
		final int scriptTimeoutSeconds = parser.readUInt16();

		return new ScriptLimitsTag(header, maxRecursionDepth, scriptTimeoutSeconds);
	}

}
