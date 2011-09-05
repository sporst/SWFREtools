package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.BinaryParser;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.ParserError;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.TagList;

/**
 * Class for parsing individual SWF tags.
 */
public final class TagParser {

	/**
	 * In case parsing of a tag failed, this method can be used to set the parser position
	 * to the beginning of the next tag. Parsing can continue there then.
	 * 
	 * @param parser Parser whose current position is adjusted.
	 * @param header Header of the tag that could not be parsed.
	 */
	private static void jumpToNextTag(final BinaryParser parser, final RecordHeader header) {
		final int nextTagPosition = header.getBitPosition() / 8 + header.getHeaderLength() + header.getLength();

		parser.setPosition(nextTagPosition, 0);
	}

	/**
	 * Parses a tag header (also called a record header).
	 * 
	 * @param parser Provides the input data.
	 * 
	 * @return The parsed tag header.
	 * 
	 * @throws SWFParserException Thrown if the tag header could not be parsed
	 */
	private static RecordHeader parseRecordHeader(final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 tagCodeAndLength = SWFParserHelpers.parseUINT16(parser, 0x00006, "RecordHeader::TagCodeAndLength");

		final int length = tagCodeAndLength.value() & 0x3F;

		if (length == 0x3F) {
			final INT32 extraLength = SWFParserHelpers.parseINT32(parser, 0x00006, "RecordHeader::Length");
			return new RecordHeader(tagCodeAndLength, extraLength);
		}
		else {
			return new RecordHeader(tagCodeAndLength, null);
		}

	}

	/**
	 * Parses a single tag and flags eventual errors.
	 * 
	 * @param parser Provides the input data.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param errors List where errors that appear during parsing are added.
	 * 
	 * @return The parsed tag or null if parsing failed.
	 */
	private static Tag parseTag(final SWFBinaryParser parser, final int version, final List<ParserError> errors) {

		try {

			final RecordHeader header = parseRecordHeader(parser);

			//			System.out.printf("Parsing at %d [%d:%s]\n", parser.getBytePosition() - header.getHeaderLength() - 8, header.getTagCode(), TagNames.getTagName(header.getTagCode()));

			return parseTag(parser, header, version, errors);

		} catch (final SWFParserException e) {
			// A parser exception while parsing the header means we ran beyond
			// the input data.

			errors.add(new ParserError(e.getOffset(), e.getMessage()));
		}

		return null;
	}

	/**
	 * Parses a single tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header The previously parsed header of the tag.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param errors List where errors that appear during parsing are added.
	 * 
	 * @return The parsed tag or null if parsing failed.
	 */
	private static Tag parseTag(final SWFBinaryParser parser, final RecordHeader header, final int version, final List<ParserError> errors) {

		try {

			switch (header.getTagCode()) {
			case TagCodes.PlaceObject: return PlaceObjectParser.parse(parser, header);
			case TagCodes.PlaceObject2: return PlaceObject2Parser.parse(header, parser, version);
			case TagCodes.PlaceObject3: return PlaceObject3Parser.parse(header, parser, version);
			case TagCodes.RemoveObject: return RemoveObjectParser.parse(header, parser);
			case TagCodes.RemoveObject2: return RemoveObject2Parser.parse(header, parser);
			case TagCodes.ShowFrame: return ShowFrameParser.parse(header, parser);
			case TagCodes.SetBackgroundColor: return SetBackgroundColorParser.parse(header, parser);
			case TagCodes.FrameLabel: return FrameLabelParser.parse(header, parser);
			case TagCodes.Protect: return ProtectParser.parse(header, parser);
			case TagCodes.End: return EndParser.parse(header);
			case TagCodes.ExportAssets: return ExportAssetsParser.parse(header, parser);
			case TagCodes.ImportAssets: return ImportAssetsParser.parse(header, parser);
			case TagCodes.EnableDebugger: return EnableDebuggerParser.parse(header, parser);
			case TagCodes.EnableDebugger2: return EnableDebugger2Parser.parse(header, parser);
			case TagCodes.ScriptLimits: return ScriptLimitsParser.parse(header, parser);
			case TagCodes.SetTabIndex: return SetTabIndexParser.parse(header, parser);
			case TagCodes.FileAttributes: return FileAttributesParser.parse(header, parser);
			case TagCodes.ImportAssets2: return ImportAssets2Parser.parse(header, parser);
			case TagCodes.SymbolClass: return SymbolClassParser.parse(header, parser);
			case TagCodes.Metadata: return MetadataParser.parse(header, parser);
			case TagCodes.DefineScalingGrid: return DefineScalingGridParser.parse(header, parser);
			case TagCodes.DefineSceneAndFrameLabelData: return DefineSceneAndFrameLabelDataParser.parse(header, parser);
			case TagCodes.DoAction: return DoActionParser.parse(header, parser);
			case TagCodes.DoInitAction: return DoInitActionParser.parse(header, parser);
			case TagCodes.DefineShape: return DefineShapeParser.parse(header, parser);
			case TagCodes.DefineShape2: return DefineShape2Parser.parse(header, parser);
			case TagCodes.DefineShape3: return DefineShape3Parser.parse(header, parser);
			case TagCodes.DefineShape4: return DefineShape4Parser.parse(header, parser);
			case TagCodes.DefineBits: return DefineBitsParser.parse(header, parser);
			case TagCodes.JPEGTables: return JPEGTablesParser.parse(header, parser);
			case TagCodes.DefineBitsJPEG2: return DefineBitsJPEG2Parser.parse(header, parser);
			case TagCodes.DefineBitsJPEG3: return DefineBitsJPEG3Parser.parse(header, parser);
			case TagCodes.DefineBitsLossless: return DefineBitsLosslessParser.parse(header, parser);
			case TagCodes.DefineBitsLossless2: return DefineBitsLossless2Parser.parse(header, parser);
			case TagCodes.DefineBitsJPEG4: return DefineBitsJPEG4Parser.parse(header, parser);
			case TagCodes.DefineMorphShape: return DefineMorphShapeParser.parse(header, parser);
			case TagCodes.DefineMorphShape2: return DefineMorphShape2Parser.parse(header, parser);
			case TagCodes.DefineFont: return DefineFontParser.parse(header, parser);
			case TagCodes.DefineFontInfo: return DefineFontInfoParser.parse(header, parser);
			case TagCodes.DefineFontInfo2: return DefineFontInfo2Parser.parse(header, parser);
			case TagCodes.DefineFont2: return DefineFont2Parser.parse(header, parser);
			case TagCodes.DefineFont3: return DefineFont3Parser.parse(header, parser);
			case TagCodes.DefineFontAlignZones: return DefineFontAlignZonesParser.parse(header, parser);
			case TagCodes.DefineText: return DefineTextParser.parse(header, parser);
			case TagCodes.DefineText2: return DefineText2Parser.parse(header, parser);
			case TagCodes.DefineEditText: return DefineEditTextParser.parse(header, parser);
			case TagCodes.CSMTextSettings: return CSMTextSettingsParser.parse(header, parser);
			case TagCodes.DefineFont4: return DefineFont4Parser.parse(header, parser);
			case TagCodes.DefineSound: return DefineSoundParser.parse(header, parser);
			case TagCodes.StartSound: return StartSoundParser.parse(header, parser);
			case TagCodes.StartSound2: return StartSound2Parser.parse(header, parser);
			case TagCodes.SoundStreamHead: return SoundStreamHeadParser.parse(header, parser);
			case TagCodes.SoundStreamHead2: return SoundStreamHead2Parser.parse(header, parser);
			case TagCodes.SoundStreamBlock: return SoundStreamBlockParser.parse(header, parser);
			case TagCodes.DefineButton: return DefineButtonParser.parse(header, parser);
			case TagCodes.DefineButton2: return DefineButton2Parser.parse(header, parser);
			case TagCodes.DefineButtonCxform: return DefineButtonCxformParser.parse(header, parser);
			case TagCodes.DefineButtonSound: return DefineButtonSoundParser.parse(header, parser);
			case TagCodes.DefineSprite: return DefineSpriteParser.parse(header, parser, version);
			case TagCodes.DefineVideoStream: return DefineVideoStreamParser.parse(header, parser);
			case TagCodes.VideoFrame: return VideoFrameParser.parse(header, parser);
			case TagCodes.DefineBinaryData: return DefineBinaryDataParser.parse(header, parser);
			case TagCodes.DoABC: return DoABCParser.parse(header, parser);
			case TagCodes.DefineFontName: return DefineFontNameParser.parse(header, parser);
			}

			errors.add(new ParserError(header.getTagAndLength().getBitPosition(), String.format("Tried to parse tag with unknown tag code 0x%02X", header.getTagCode())));

			// We do not know the type of this tag but we can try to continue parsing at the next tag
			jumpToNextTag(parser, header);

			return null;
		} catch (final SWFParserException exception) {

			errors.add(new ParserError(exception.getOffset(), exception.getMessage()));

			exception.printStackTrace();

			// Parsing this tag failed but we can try to continue parsing at the next tag
			jumpToNextTag(parser, header);

			return null;
		}
	}

	/**
	 * Parses tags until the input data is exhausted.
	 * 
	 * @param parser Provides the input data.
	 * @param version Flash version number which was read from the SWF file header.
	 * 
	 * @return A list of parsed tags.
	 */
	public static TagParserResult parse(final SWFBinaryParser parser, final int version) {

		if (parser == null) {
			throw new IllegalArgumentException("Argument parser must not be null");
		}

		if (version <= 0) {
			throw new IllegalArgumentException("Invalid Flash version number");
		}

		final List<ParserError> errors = new ArrayList<ParserError>();
		final List<Tag> tags = new ArrayList<Tag>();

		while (!parser.isDone())
		{
			final int before = parser.getBytePosition();

			try {
				final Tag parsedTag = parseTag(parser, version, errors);

				if (parsedTag != null) {
					tags.add(parsedTag);

					if (parser.getBytePosition() != before + parsedTag.getHeader().getNormalizedLength() + (parsedTag.getHeader().getHeaderLength()))
					{
						System.out.println(String.format("No: Wanted %X but was %X", before + parsedTag.getHeader().getNormalizedLength() + (parsedTag.getHeader().getHeaderLength()), parser.getBytePosition()));

						parser.setPosition(before + parsedTag.getHeader().getNormalizedLength() + (parsedTag.getHeader().getHeaderLength()), 0);
					}
				}
			}
			catch (final IllegalArgumentException e) {
				break;
			}
		}

		return new TagParserResult(new TagList(tags), errors);
	}

	/**
	 * Parses tags until length bytes have been parsed or the input data is exhausted.
	 * This method was added because some tags can contain subtags that must be parsed
	 * separately.
	 * 
	 * @param parser Provides the input data.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param length Number of bytes to parse.
	 * 
	 * @return A list of parsed tags.
	 */
	public static TagParserResult parse(final SWFBinaryParser parser, final int version, final int length) {

		if (parser == null) {
			throw new IllegalArgumentException("Argument parser must not be null");
		}

		if (version <= 0) {
			throw new IllegalArgumentException("Invalid Flash version number");
		}

		if (length < 0) {
			throw new IllegalArgumentException("Length argument must be positive");
		}

		final int start = parser.getBytePosition();

		final List<Tag> tags = new ArrayList<Tag>();
		final List<ParserError> errors = new ArrayList<ParserError>();

		while (parser.getBytePosition() < start + length)
		{
			// TODO: I suspect checking parser.isDone here is not needed but I have to test that.

			final int before = parser.getBytePosition();

			final Tag parsedTag = parseTag(parser, version, errors);

			if (parsedTag != null) {
				tags.add(parsedTag);

				if (parser.getBytePosition() != before + parsedTag.getHeader().getNormalizedLength() + (parsedTag.getHeader().getHeaderLength()))
				{
					System.out.println(String.format("No: Wanted %X but was %X", before + parsedTag.getHeader().getNormalizedLength() + (parsedTag.getHeader().getHeaderLength()), parser.getBytePosition()));

					parser.setPosition(before + parsedTag.getHeader().getNormalizedLength() + (parsedTag.getHeader().getHeaderLength()), 0);
				}
			}

		}

		return new TagParserResult(new TagList(tags), errors);
	}

}
