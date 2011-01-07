package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.TextRecord;
import tv.porst.swfretools.parser.structures.TextRecordParser;

public class DefineTextParser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final UINT16 characterID = parser.readUInt16();
		final Rect textBounds = RectParser.parse(parser);
		final Matrix textMatrix = MatrixParser.parse(parser, "TextMatrix");
		final UINT8 glyphBits = parser.readUInt8();
		final UINT8 advanceBits = parser.readUInt8();

		final List<TextRecord> textRecords = new ArrayList<TextRecord>();

		do
		{
			if (parser.peekUInt8() == 0) {
				break;
			}

			textRecords.add(TextRecordParser.parse(parser, glyphBits.value(), advanceBits.value()));

		} while (true);

		return new DefineTextTag(header, characterID, textBounds, textMatrix, glyphBits, advanceBits, textRecords);
	}

}
