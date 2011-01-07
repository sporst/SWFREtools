package tv.porst.swfretools.parser;

import tv.porst.splib.io.BinaryParserHelpers;

public class SWFParserHelpers {

	public static void throwIf(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		if (!BinaryParserHelpers.hasBytesLeft(parser, numberOfBytes)) {
			throw new SWFParserException(errorCode, parser.getBytePosition(), String.format("Read beyond file while parsing %s::%s (%08X)", parser.getTagName(), fieldName, parser.getBytePosition()));
		}
	}

	public static void throwIfB(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		if (!BinaryParserHelpers.hasBitsLeft(parser, numberOfBytes)) {
			throw new SWFParserException(errorCode, parser.getBytePosition(), String.format("Read beyond file while parsing %s::%s (%08X)", parser.getTagName(), fieldName, parser.getBytePosition()));
		}
	}

}
