package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class TagParser {

	public static List<Tag> parse(final BinaryParser parser, final int version) {

		final List<Tag> tags = new ArrayList<Tag>();

		while (!parser.isDone())
		{
			tags.add(parseTag(parser, version));
		}

		return tags;
	}

	private static RecordHeader parseRecordHeader(final BinaryParser parser) {

		final int tagCodeAndLength = parser.readUInt16();

		final int tagCode = tagCodeAndLength >>> 6;
		final int length = tagCodeAndLength & 0x3F;

		if (length == 0x3F) {
			return new RecordHeader(tagCode, length, parser.readSInt32());
		}
		else {
			return new RecordHeader(tagCode, length, 0);
		}

	}

	private static Tag parseTag(final BinaryParser parser, final int version) {

		final RecordHeader header = parseRecordHeader(parser);

		switch (header.getTagCode()) {
		case TagCodes.PlaceObject: return PlaceObjectParser.parse(header, parser);
		case TagCodes.PlaceObject2: return PlaceObject2Parser.parse(header, parser, version);
		case TagCodes.PlaceObject3: return PlaceObject3Parser.parse(header, parser, version);
		case TagCodes.RemoveObject: return RemoveObjectParser.parse(header, parser);
		case TagCodes.RemoveObject2: return RemoveObject2Parser.parse(header, parser);
		case TagCodes.ShowFrame: return ShowFrameParser.parse(header, parser);
		case TagCodes.SetBackgroundColor: return SetBackgroundColorParser.parse(header, parser);
		case TagCodes.FrameLabel: return FrameLabelParser.parse(header, parser);
		case TagCodes.Protect: return ProtectParser.parse(header, parser);
		case TagCodes.End: return EndParser.parse(header, parser);
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
		case TagCodes.DefineFontName: return DefineFontNameParser.parse(header, parser);
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
		}

		return null;

	}

}
