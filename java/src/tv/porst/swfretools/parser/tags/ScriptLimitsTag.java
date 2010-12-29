package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class ScriptLimitsTag extends Tag {

	public ScriptLimitsTag(final RecordHeader header, final int maxRecursionDepth,
			final int scriptTimeoutSeconds) {
		super(header);
	}

}
