package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ScriptLimitsTag extends Tag {

	public ScriptLimitsTag(final RecordHeader header, final UINT16 maxRecursionDepth,
			final UINT16 scriptTimeoutSeconds) {
		super(header);
	}

}
