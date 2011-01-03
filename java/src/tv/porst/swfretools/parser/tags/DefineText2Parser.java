package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.TextRecord2;
import tv.porst.swfretools.parser.structures.TextRecord2Parser;

public class DefineText2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterID = parser.readUInt16();
		final Rect textBounds = RectParser.parse(parser);
		final Matrix textMatrix = MatrixParser.parse(parser);
		final int glyphBits = parser.readUInt8();
		final int advanceBits = parser.readUInt8();

		final List<TextRecord2> textRecords = new ArrayList<TextRecord2>();

		do
		{
			if (parser.peekUInt8() == 0) {
				break;
			}

			textRecords.add(TextRecord2Parser.parse(parser, glyphBits, advanceBits));

		} while (true);

		return new DefineText2Tag(header, characterID, textBounds, textMatrix, glyphBits, advanceBits, textRecords);
	}

}
