package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MetaDataParser {

	public static MetaData parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 name = EncodedU30Parser.parse(parser, fieldName + "::name");
		final EncodedU30 itemCount = EncodedU30Parser.parse(parser, fieldName + "::item_count");

		final List<ItemInfo> items = new ArrayList<ItemInfo>();

		for (int i=0;i<itemCount.value();i++) {
			items.add(ItemInfoParser.parse(parser, String.format(fieldName + "::items[%d]", i)));
		}

		return new MetaData(name, itemCount, items);
	}

}
