package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ScriptLimitsParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 maxRecursionDepth = parser.readUInt16();
		final UINT16 scriptTimeoutSeconds = parser.readUInt16();

		return new ScriptLimitsTag(header, maxRecursionDepth, scriptTimeoutSeconds);
	}

}
