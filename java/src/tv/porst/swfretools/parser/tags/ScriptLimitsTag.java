package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a ScriptLimits tag.
 */
public final class ScriptLimitsTag extends Tag {

	/**
	 * Maximum recursion depth.
	 */
	private final UINT16 maxRecursionDepth;

	/**
	 * Maximum ActionScript processing time before script stuck dialog box displays.
	 */
	private final UINT16 scriptTimeoutSeconds;

	/**
	 * Creates a new ScriptLimits tag object.
	 * 
	 * @param header Tag header.
	 * @param maxRecursionDepth Maximum recursion depth.
	 * @param scriptTimeoutSeconds Maximum ActionScript processing time before script stuck dialog box displays.
	 */
	public ScriptLimitsTag(final RecordHeader header, final UINT16 maxRecursionDepth, final UINT16 scriptTimeoutSeconds) {
		super(header);

		SWFParserHelpers.checkNull(maxRecursionDepth, "MaxRecursionDepth");
		SWFParserHelpers.checkNull(scriptTimeoutSeconds, "ScriptTimeoutSeconds");

		this.maxRecursionDepth = maxRecursionDepth;
		this.scriptTimeoutSeconds = scriptTimeoutSeconds;
	}

	/**
	 * Returns the maximum recursion depth.
	 * 
	 * @return The maximum recursion depth.
	 */
	public UINT16 getMaxRecursionDepth() {
		return maxRecursionDepth;
	}

	/**
	 * Returns the maximum ActionScript processing time before script stuck dialog box displays.
	 * 
	 * @return The maximum ActionScript processing time before script stuck dialog box displays.
	 */
	public UINT16 getScriptTimeoutSeconds() {
		return scriptTimeoutSeconds;
	}
}