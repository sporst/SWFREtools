package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses a SoundInfo structure.
 * 
 * @author sp
 *
 */
public final class SoundInfoParser {

	/**
	 * Parses a SoundInfo structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static SoundInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Bits reserved = parseBits(parser, 2, 0x00006, fieldName + "::Reserved");
		final Flag syncStop = parseFlag(parser, 0x00006, fieldName + "::SyncStopY");
		final Flag syncNoMultiple = parseFlag(parser, 0x00006, fieldName + "::SyncNoMultiple");
		final Flag hasEnvelope = parseFlag(parser, 0x00006, fieldName + "::HasMultiple");
		final Flag hasLoops = parseFlag(parser, 0x00006, fieldName + "::HasLoops");
		final Flag hasOutPoint= parseFlag(parser, 0x00006, fieldName + "::HasOutPoint");
		final Flag hasInPoint = parseFlag(parser, 0x00006, fieldName + "::HasInPoint");

		final UINT32 inPoint = parseUINT32If(parser, 0x00006, hasInPoint, fieldName + "::InPoint");
		final UINT32 outPoint = parseUINT32If(parser, 0x00006, hasOutPoint, fieldName + "::OutPoint");
		final UINT16 loopCount = parseUINT16If(parser, 0x000006, hasLoops, fieldName + "::LoopCount");
		final UINT8 envPoints = parseUINT8If(parser, 0x00006, hasEnvelope, fieldName + "::EnvPoints");

		final List<SoundEnvelope> envelopeRecords = new ArrayList<SoundEnvelope>();

		if (hasEnvelope.value()) {
			for (int i=0;i<envPoints.value();i++) {
				envelopeRecords.add(SoundEnvelopeParser.parse(parser, String.format("EnvelopeRecords[%d]", i)));
			}
		}

		return new SoundInfo(reserved, syncStop, syncNoMultiple, hasEnvelope, hasLoops,
				hasOutPoint, hasInPoint, inPoint, outPoint, loopCount, envPoints,
				envelopeRecords);
	}

	/**
	 * Parses a SoundInfo structure if a given condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition that must be true.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static SoundInfo parseIf(final SWFBinaryParser parser, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, fieldName) : null;
	}
}