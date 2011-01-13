package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineVideoStream tags.
 * 
 * @author sp
 */
public final class DefineVideoStreamParser {

	/**
	 * Parses a DefineVideoStream tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineVideoStreamTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineVideoStream::CharacterId");
		final UINT16 numFrames = parseUINT16(parser, 0x00006, "DefineVideoStream::NumFrames");
		final UINT16 width = parseUINT16(parser, 0x00006, "DefineVideoStream::Width");
		final UINT16 height = parseUINT16(parser, 0x00006, "DefineVideoStream::Height");
		final int videoFlagsReserved = parseBits(parser, 4, 0x00006, "DefineVideoStream::VideoFlagsReserved");
		final int videoFlagsDeblocking = parseBits(parser, 4, 0x00006, "DefineVideoStream::VideoFlagsDeblocking");
		final Flag videoFlagsSmoothing = parseFlag(parser, 0x00006, "DefineVideoStream::VideoFlagsSmoothing");
		final UINT8 codecId = parseUINT8(parser, 0x00006, "DefineVideoStream::CodecID");

		return new DefineVideoStreamTag(header, characterId, numFrames, width, height,
				videoFlagsReserved, videoFlagsDeblocking, videoFlagsSmoothing,
				codecId);

	}
}