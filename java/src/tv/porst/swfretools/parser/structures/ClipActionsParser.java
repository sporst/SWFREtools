package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.UINT16;

public class ClipActionsParser {

	public static ClipActions parse(final BinaryParser parser, final int version) {

		final UINT16 reserved = parser.readUInt16();
		final ClipEventFlags allEventFlags = ClipEventFlagsParser.parse(parser, version);


		final List<ClipActionRecord> clipActionRecords = new ArrayList<ClipActionRecord>();

		do {

			if (parser.peekUInt16() == 0) {
				break;
			}

			clipActionRecords.add(ClipActionRecordParser.parse(parser, version));

		} while (true);

		final IParsedINTElement clipActionEndFlag = version <= 5 ? parser.readUInt16() : parser.readUInt32();

		return new ClipActions(reserved, allEventFlags, clipActionRecords, clipActionEndFlag);
	}

}
