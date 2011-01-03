package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfoTag extends Tag {

	public DefineFontInfoTag(final RecordHeader header, final int fontId, final int fontNameLen,
			final String fontName, final int fontFlagsReserved, final boolean fontFlagsSmallText,
			final boolean fontFlagsShiftJIS, final boolean fontFlagsANSI,
			final boolean fontFlagsItalic, final boolean fontFlagsBold,
			final boolean fontFlagsWideCodes, final List<Integer> codeTable) {
		super(header);
	}

}
