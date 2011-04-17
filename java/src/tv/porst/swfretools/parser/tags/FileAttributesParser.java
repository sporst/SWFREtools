package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing FileAttributes tags.
 */
public final class FileAttributesParser {

	/**
	 * Parses a FileAttributes tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static FileAttributesTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UBits reserved = parseUBits(parser, 1, 0x00006, "FileAttributes::Reserved");
		final Flag useDirectBit = parseFlag(parser, 0x00006, "FileAttributes::UseDirectBit");
		final Flag useGPU = parseFlag(parser, 0x00006, "FileAttributes::UseGPU");
		final Flag hasMetadata = parseFlag(parser, 0x00006, "FileAttributes::HasMetadata");
		final Flag actionScript3 = parseFlag(parser, 0x00006, "FileAttributes::ActionScript3");
		final UBits reserved2 = parseUBits(parser, 2, 0x00006, "FileAttributes::Reserved2");
		final Flag useNetwork = parseFlag(parser, 0x00006, "FileAttributes::UseNetwork");
		final UBits reserved3 = parseUBits(parser, 24, 0x00006, "FileAttributes::Reserved3");

		return new FileAttributesTag(header, reserved, useDirectBit, useGPU, hasMetadata, actionScript3, reserved2, useNetwork, reserved3);
	}
}