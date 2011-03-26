package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.tags.CSMTextSettingsTag;
import tv.porst.swfretools.parser.tags.DefineBinaryDataTag;
import tv.porst.swfretools.parser.tags.DefineBitsJPEG2Tag;
import tv.porst.swfretools.parser.tags.DefineBitsJPEG3Tag;
import tv.porst.swfretools.parser.tags.DefineBitsJPEG4Tag;
import tv.porst.swfretools.parser.tags.DefineBitsLossless2Tag;
import tv.porst.swfretools.parser.tags.DefineBitsLosslessTag;
import tv.porst.swfretools.parser.tags.DefineBitsTag;
import tv.porst.swfretools.parser.tags.DefineButton2Tag;
import tv.porst.swfretools.parser.tags.DefineButtonCxformTag;
import tv.porst.swfretools.parser.tags.DefineButtonSoundTag;
import tv.porst.swfretools.parser.tags.DefineButtonTag;
import tv.porst.swfretools.parser.tags.DefineEditTextTag;
import tv.porst.swfretools.parser.tags.DefineFont2Tag;
import tv.porst.swfretools.parser.tags.DefineFont3Tag;
import tv.porst.swfretools.parser.tags.DefineFont4Tag;
import tv.porst.swfretools.parser.tags.DefineFontAlignZonesTag;
import tv.porst.swfretools.parser.tags.DefineFontInfo2Tag;
import tv.porst.swfretools.parser.tags.DefineFontInfoTag;
import tv.porst.swfretools.parser.tags.DefineFontNameTag;
import tv.porst.swfretools.parser.tags.DefineFontTag;
import tv.porst.swfretools.parser.tags.DefineMorphShape2Tag;
import tv.porst.swfretools.parser.tags.DefineMorphShapeTag;
import tv.porst.swfretools.parser.tags.DefineScalingGridTag;
import tv.porst.swfretools.parser.tags.DefineSceneAndFrameLabelDataTag;
import tv.porst.swfretools.parser.tags.DefineShape2Tag;
import tv.porst.swfretools.parser.tags.DefineShape3Tag;
import tv.porst.swfretools.parser.tags.DefineShape4Tag;
import tv.porst.swfretools.parser.tags.DefineShapeTag;
import tv.porst.swfretools.parser.tags.DefineSoundTag;
import tv.porst.swfretools.parser.tags.DefineSpriteTag;
import tv.porst.swfretools.parser.tags.DefineText2Tag;
import tv.porst.swfretools.parser.tags.DefineTextTag;
import tv.porst.swfretools.parser.tags.DefineVideoStreamTag;
import tv.porst.swfretools.parser.tags.DoABCTag;
import tv.porst.swfretools.parser.tags.DoActionTag;
import tv.porst.swfretools.parser.tags.DoInitActionTag;
import tv.porst.swfretools.parser.tags.EnableDebugger2Tag;
import tv.porst.swfretools.parser.tags.EnableDebuggerTag;
import tv.porst.swfretools.parser.tags.EndTag;
import tv.porst.swfretools.parser.tags.ExportAssetsTag;
import tv.porst.swfretools.parser.tags.FileAttributesTag;
import tv.porst.swfretools.parser.tags.FrameLabelTag;
import tv.porst.swfretools.parser.tags.ImportAssets2Tag;
import tv.porst.swfretools.parser.tags.ImportAssetsTag;
import tv.porst.swfretools.parser.tags.JPEGTablesTag;
import tv.porst.swfretools.parser.tags.MetadataTag;
import tv.porst.swfretools.parser.tags.PlaceObject2Tag;
import tv.porst.swfretools.parser.tags.PlaceObject3Tag;
import tv.porst.swfretools.parser.tags.PlaceObjectTag;
import tv.porst.swfretools.parser.tags.RemoveObject2Tag;
import tv.porst.swfretools.parser.tags.RemoveObjectTag;
import tv.porst.swfretools.parser.tags.ScriptLimitsTag;
import tv.porst.swfretools.parser.tags.SetBackgroundColorTag;
import tv.porst.swfretools.parser.tags.SetTabIndexTag;
import tv.porst.swfretools.parser.tags.ShowFrameTag;
import tv.porst.swfretools.parser.tags.SoundStreamBlockTag;
import tv.porst.swfretools.parser.tags.SoundStreamHead2Tag;
import tv.porst.swfretools.parser.tags.SoundStreamHeadTag;
import tv.porst.swfretools.parser.tags.StartSound2Tag;
import tv.porst.swfretools.parser.tags.StartSoundTag;
import tv.porst.swfretools.parser.tags.SymbolClassTag;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.parser.tags.VideoFrameTag;
import tv.porst.swfretools.utils.TagNames;

public class FlashTagNode extends FlashTreeNode<Tag> {

	private final Tag tag;

	public FlashTagNode(final Tag tag) {
		super(TagNames.getTagName(tag.getHeader().getTagCode()), tag);

		this.tag = tag;

		createChildren();
	}

	private void createChildren() {

		addNode("Header", tag.getHeader());

		if (tag instanceof CSMTextSettingsTag) {
			final CSMTextSettingsTag ctag = (CSMTextSettingsTag) tag;

			addNode("TextID", ctag.getTextId());
			addNode("UseFlashType", ctag.getUseFlashType());
			addNode("GridFit", ctag.getGridFit());
			addNode("Reserved", ctag.getReserved());
			addNode("Thickness", ctag.getThickness());
			addNode("Sharpness", ctag.getSharpness());
			addNode("Reserved", ctag.getReserved2());
		}
		else if (tag instanceof DefineBinaryDataTag) {
			final DefineBinaryDataTag ctag = (DefineBinaryDataTag) tag;

			addNode("Tag", ctag.getTag());
			addNode("Reserved", ctag.getReserved());
			addNode("Data", ctag.getData());
		}
		else if (tag instanceof DefineBitsJPEG2Tag) {
			final DefineBitsJPEG2Tag ctag = (DefineBitsJPEG2Tag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("ImageData", ctag.getImageData());
		}
		else if (tag instanceof DefineBitsJPEG3Tag) {
			final DefineBitsJPEG3Tag ctag = (DefineBitsJPEG3Tag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("AlphaDataOffset", ctag.getAlphaDataOffset());
			addNode("JPEGData", ctag.getJpegData());
			addNode("BitmapAlphaData", ctag.getBitmapAlphaData());
		}
		else if (tag instanceof DefineBitsJPEG4Tag) {
			final DefineBitsJPEG4Tag ctag = (DefineBitsJPEG4Tag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("AlphaDataOffset", ctag.getAlphaDataOffset());
			addNode("DeblockParam", ctag.getDeblockParam());
			addNode("ImageData", ctag.getImageData());
			addNode("BitmapAlphaData", ctag.getBitmapAlphaData());
		}
		else if (tag instanceof DefineBitsLossless2Tag) {
			final DefineBitsLossless2Tag ctag = (DefineBitsLossless2Tag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("BitmapFormat", ctag.getBitmapFormat());
			addNode("BitmapWidth", ctag.getBitmapWidth());
			addNode("BitmapHeight", ctag.getBitmapHeight());
			addNode("BitmapColorTableSize", ctag.getBitmapColorTableSize());
			addNode("ZLibBitmapData", ctag.getZlibBitmapData());
		}
		else if (tag instanceof DefineBitsLosslessTag) {
			final DefineBitsLosslessTag ctag = (DefineBitsLosslessTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("BitmapFormat", ctag.getBitmapFormat());
			addNode("BitmapWidth", ctag.getBitmapWidth());
			addNode("BitmapHeight", ctag.getBitmapHeight());
			addNode("BitmapColorTableSize", ctag.getBitmapColorTableSize());
			addNode("ZLibBitmapData", ctag.getZlibBitmapData());
		}
		else if (tag instanceof DefineBitsTag) {
			final DefineBitsTag ctag = (DefineBitsTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("JPEGData", ctag.getJpegData());
		}
		else if (tag instanceof DefineButton2Tag) {
			final DefineButton2Tag ctag = (DefineButton2Tag) tag;

			addNode("ButtonID", ctag.getButtonId());
			addNode("ReservedFlags", ctag.getReservedFlags());
			addNode("TrackAsMenu", ctag.getTrackAsMenu());
			addNode("ActionOffset", ctag.getActionOffset());
			addNode("Characters", ctag.getCharacters());
			addNode("CharacterEndFlag", ctag.getCharacterEndFlag());
			addNode("Actions", ctag.getActions());
		}
		else if (tag instanceof DefineButtonCxformTag) {
			final DefineButtonCxformTag ctag = (DefineButtonCxformTag) tag;

			addNode("ButtonID", ctag.getButtonId());
			addNode("ButtonColorTransform", ctag.getButtonColorTransform());
		}
		else if (tag instanceof DefineButtonSoundTag) {
			final DefineButtonSoundTag ctag = (DefineButtonSoundTag) tag;

			addNode("ButtonID", ctag.getButtonId());
			addNode("ButtonSoundChar0", ctag.getButtonSoundChar0());
			addNode("ButtonSoundInfo0", ctag.getButtonSoundInfo0());
			addNode("ButtonSoundChar1", ctag.getButtonSoundChar1());
			addNode("ButtonSoundInfo1", ctag.getButtonSoundInfo1());
			addNode("ButtonSoundChar2", ctag.getButtonSoundChar2());
			addNode("ButtonSoundInfo2", ctag.getButtonSoundInfo2());
			addNode("ButtonSoundChar3", ctag.getButtonSoundChar3());
			addNode("ButtonSoundInfo3", ctag.getButtonSoundInfo3());
		}
		else if (tag instanceof DefineButtonTag) {
			final DefineButtonTag ctag = (DefineButtonTag) tag;

			addNode("ButtonID", ctag.getButtonId());
			addNode("Characters", ctag.getCharacters());
			addNode("CharacterEndFlag", ctag.getCharacterEndFlag());
			addNode("Actions", ctag.getActions());
			addNode("ActionEndFlag", ctag.getActionEndFlag());
		}
		else if (tag instanceof DefineEditTextTag) {
			final DefineEditTextTag ctag = (DefineEditTextTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("Bounds", ctag.getBounds());
			addNode("HasText", ctag.getHasText());
			addNode("WordWrap", ctag.getWordWrap());
			addNode("Multiline", ctag.getMultiline());
			addNode("Password", ctag.getPassword());
			addNode("ReadOnly", ctag.getReadOnly());
			addNode("HasTextColor", ctag.getHasTextColor());
			addNode("HasMaxLength", ctag.getHasMaxLength());
			addNode("HasFont", ctag.getHasFont());
			addNode("HasFontClass", ctag.getHasFontClass());
			addNode("AutoSize", ctag.getAutoSize());
			addNode("HasLayout", ctag.getHasLayout());
			addNode("NoSelect", ctag.getNoSelect());
			addNode("Border", ctag.getBorder());
			addNode("WasStatic", ctag.getWasStatic());
			addNode("Html", ctag.getHtml());
			addNode("UseOutlines", ctag.getUseOutlines());
			addNode("FontID", ctag.getFontId());
			addNode("FontClass", ctag.getFontClass());
			addNode("FontHeight", ctag.getFontHeight());
			addNode("TextColor", ctag.getTextColor());
			addNode("MaxLength", ctag.getMaxLength());
			addNode("Align", ctag.getAlign());
			addNode("LeftMargin", ctag.getLeftMargin());
			addNode("RightMargin", ctag.getRightMargin());
			addNode("Indent", ctag.getIndent());
			addNode("Leading", ctag.getLeading());
			addNode("VariableName", ctag.getVariableName());
			addNode("InitialText", ctag.getInitialText());
		}
		else if (tag instanceof DefineFont2Tag) {
			final DefineFont2Tag ctag = (DefineFont2Tag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("FontFlagsHasLayout", ctag.getFontFlagsHasLayout());
			addNode("FontFlagsShiftJIS", ctag.getFontFlagsShiftJIS());
			addNode("FontFlagsSmallText", ctag.getFontFlagsSmallText());
			addNode("FontFlagsANSI", ctag.getFontFlagsANSI());
			addNode("FontFlagsWideCodes", ctag.getFontFlagsWideCodes());
			addNode("FontFlagsWideOffsets", ctag.getFontFlagsWideOffsets());
			addNode("FontFlagsItalic", ctag.getFontFlagsItalic());
			addNode("FontFlagsBold", ctag.getFontFlagsBold());
			addNode("LanguageCode", ctag.getLanguageCode());
			addNode("FontNameLen", ctag.getFontNameLen());
			addNode("FontName", ctag.getFontName());
			addNode("NumGlyps", ctag.getNumGlyphs());
			addNode("CodeTable", ctag.getCodeTable());
			addNode("CodeTableOffset", ctag.getCodeTableOffset());
			addNode("GlyphShapeTable", ctag.getGlyphShapeTable());
			addNode("FontAscent", ctag.getFontAscent());
			addNode("FontDescent", ctag.getFontDescent());
			addNode("FontLeading", ctag.getFontLeading());
			addNode("FontAdvanceTable", ctag.getFontAdvanceTable());
			addNode("FontBoundsTable", ctag.getFontBoundsTable());
			addNode("KerningCount", ctag.getKerningCount());
			addNode("FontKerningTable", ctag.getFontKerningTable());
		}
		else if (tag instanceof DefineFont3Tag) {
			final DefineFont3Tag ctag = (DefineFont3Tag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("FontFlagsHasLayout", ctag.getFontFlagsHasLayout());
			addNode("FontFlagsShiftJIS", ctag.getFontFlagsShiftJIS());
			addNode("FontFlagsSmallText", ctag.getFontFlagsSmallText());
			addNode("FontFlagsANSI", ctag.getFontFlagsANSI());
			addNode("FontFlagsWideCodes", ctag.getFontFlagsWideCodes());
			addNode("FontFlagsWideOffsets", ctag.getFontFlagsWideOffsets());
			addNode("FontFlagsItalic", ctag.getFontFlagsItalic());
			addNode("FontFlagsBold", ctag.getFontFlagsBold());
			addNode("LanguageCode", ctag.getLanguageCode());
			addNode("FontNameLen", ctag.getFontNameLen());
			addNode("FontName", ctag.getFontName());
			addNode("NumGlyps", ctag.getNumGlyphs());
			addNode("CodeTable", ctag.getCodeTable());
			addNode("CodeTableOffset", ctag.getCodeTableOffset());
			addNode("GlyphShapeTable", ctag.getGlyphShapeTable());
			addNode("FontAscent", ctag.getFontAscent());
			addNode("FontDescent", ctag.getFontDescent());
			addNode("FontLeading", ctag.getFontLeading());
			addNode("FontAdvanceTable", ctag.getFontAdvanceTable());
			addNode("FontBoundsTable", ctag.getFontBoundsTable());
			addNode("KerningCount", ctag.getKerningCount());
			addNode("FontKerningTable", ctag.getFontKerningTable());
		}
		else if (tag instanceof DefineFont4Tag) {
			final DefineFont4Tag ctag = (DefineFont4Tag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("FontFlagsReserved", ctag.getFontFlagsReserved());
			addNode("FontFlagsHasFontData", ctag.getFontFlagsHasFontData());
			addNode("FontFlagsItalic", ctag.getFontFlagsItalic());
			addNode("FontFlagsBold", ctag.getFontFlagsBold());
			addNode("FontName", ctag.getFontName());
			addNode("FontData", ctag.getFontData());
		}
		else if (tag instanceof DefineFontAlignZonesTag) {
			final DefineFontAlignZonesTag ctag = (DefineFontAlignZonesTag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("CsmTableHint", ctag.getCsmTableHint());
			addNode("Reserved", ctag.getReserved());
			addNode("ZoneTable", ctag.getZoneTable());
		}
		else if (tag instanceof DefineFontInfo2Tag) {
			final DefineFontInfo2Tag ctag = (DefineFontInfo2Tag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("FontNameLen", ctag.getFontNameLen());
			addNode("FontName", ctag.getFontName());
			addNode("FontFlagsReserved", ctag.getFontFlagsReserved());
			addNode("FontFlagsSmallText", ctag.getFontFlagsSmallText());
			addNode("FontFlagsShiftJIS", ctag.getFontFlagsShiftJIS());
			addNode("FontFlagsANSI", ctag.getFontFlagsANSI());
			addNode("FontFlagsItalic", ctag.getFontFlagsItalic());
			addNode("FontFlagsBold", ctag.getFontFlagsBold());
			addNode("FontFlagsWideCodes", ctag.getFontFlagsWideCodes());
			addNode("CodeTable", ctag.getCodeTable());
		}
		else if (tag instanceof DefineFontInfoTag) {
			final DefineFontInfoTag ctag = (DefineFontInfoTag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("FontNameLen", ctag.getFontNameLen());
			addNode("FontName", ctag.getFontName());
			addNode("FontFlagsReserved", ctag.getFontFlagsReserved());
			addNode("FontFlagsSmallText", ctag.getFontFlagsSmallText());
			addNode("FontFlagsShiftJIS", ctag.getFontFlagsShiftJIS());
			addNode("FontFlagsANSI", ctag.getFontFlagsANSI());
			addNode("FontFlagsItalic", ctag.getFontFlagsItalic());
			addNode("FontFlagsBold", ctag.getFontFlagsBold());
			addNode("FontFlagsWideCodes", ctag.getFontFlagsWideCodes());
			addNode("CodeTable", ctag.getCodeTable());
		}
		else if (tag instanceof DefineFontNameTag) {
			final DefineFontNameTag ctag = (DefineFontNameTag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("FontName", ctag.getFontName());
			addNode("FontCopyright", ctag.getFontCopyright());
		}
		else if (tag instanceof DefineFontTag) {
			final DefineFontTag ctag = (DefineFontTag) tag;

			addNode("FontID", ctag.getFontId());
			addNode("OffsetTable", ctag.getOffsetTable());
			addNode("GlyphShapeTable", ctag.getGlyphShapeTable());
		}
		else if (tag instanceof DefineMorphShape2Tag) {
			final DefineMorphShape2Tag ctag = (DefineMorphShape2Tag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("StartBounds", ctag.getStartBounds());
			addNode("EndBounds", ctag.getEndBounds());
			addNode("Offset", ctag.getOffset());
			addNode("MorphFillStyles", ctag.getMorphFillStyles());
			addNode("MorphLineStyles", ctag.getMorphLineStyles());
			addNode("StartEdges", ctag.getStartEdges());
			addNode("EndEdges", ctag.getEndEdges());
		}
		else if (tag instanceof DefineMorphShapeTag) {
			final DefineMorphShapeTag ctag = (DefineMorphShapeTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("StartBounds", ctag.getStartBounds());
			addNode("EndBounds", ctag.getEndBounds());
			addNode("Offset", ctag.getOffset());
			addNode("MorphFillStyles", ctag.getMorphFillStyles());
			addNode("MorphLineStyles", ctag.getMorphLineStyles());
			addNode("StartEdges", ctag.getStartEdges());
			addNode("EndEdges", ctag.getEndEdges());
		}
		else if (tag instanceof DefineScalingGridTag) {
			final DefineScalingGridTag ctag = (DefineScalingGridTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("Splitter", ctag.getSplitter());
		}
		else if (tag instanceof DefineSceneAndFrameLabelDataTag) {
			final DefineSceneAndFrameLabelDataTag ctag = (DefineSceneAndFrameLabelDataTag) tag;

			addNode("SceneCount", ctag.getSceneCount());
			addNode("SceneNames", ctag.getSceneNames());
			addNode("FrameLabelCount", ctag.getFrameLabelCount());
			addNode("FrameLabels", ctag.getFrameLabels());
		}
		else if (tag instanceof DefineShape2Tag) {
			final DefineShape2Tag ctag = (DefineShape2Tag) tag;

			addNode("ShapeID", ctag.getShapeId());
			addNode("ShapeBounds", ctag.getShapeBounds());
			addNode("Shapes", ctag.getShapes());
		}
		else if (tag instanceof DefineShape3Tag) {
			final DefineShape3Tag ctag = (DefineShape3Tag) tag;

			addNode("ShapeID", ctag.getShapeId());
			addNode("ShapeBounds", ctag.getShapeBounds());
			addNode("Shapes", ctag.getShapes());
		}
		else if (tag instanceof DefineShape4Tag) {
			final DefineShape4Tag ctag = (DefineShape4Tag) tag;

			addNode("ShapeID", ctag.getShapeId());
			addNode("ShapeBounds", ctag.getShapeBounds());
			addNode("EdgeBounds", ctag.getEdgeBounds());
			addNode("Reserved", ctag.getReserved());
			addNode("UsesFillWindingRule", ctag.getUsesFillWindingRule());
			addNode("UsesNonScalingStrokes", ctag.getUsesNonScalingStrokes());
			addNode("UsesScalingStrokes", ctag.getUsesScalingStrokes());
			addNode("Shapes", ctag.getShapes());
		}
		else if (tag instanceof DefineShapeTag) {
			final DefineShapeTag ctag = (DefineShapeTag) tag;

			addNode("ShapeID", ctag.getShapeId());
			addNode("ShapeBounds", ctag.getShapeBounds());
			addNode("Shapes", ctag.getShapes());
		}
		else if (tag instanceof DefineSoundTag) {
			final DefineSoundTag ctag = (DefineSoundTag) tag;

			addNode("SpriteID", ctag.getSoundId());
			addNode("SoundFormat", ctag.getSoundFormat());
			addNode("SoundRate", ctag.getSoundRate());
			addNode("SoundSize", ctag.getSoundSize());
			addNode("SoundType", ctag.getSoundType());
			addNode("SoundSampleCount", ctag.getSoundSampleCount());
			addNode("SoundData", ctag.getSoundData());
		}
		else if (tag instanceof DefineSpriteTag) {
			final DefineSpriteTag ctag = (DefineSpriteTag) tag;

			addNode("SpriteID", ctag.getSpriteId());
			addNode("FrameCount", ctag.getFrameCount());
			addNode("ControlTags", ctag.getControlTags());
		}
		else if (tag instanceof DefineText2Tag) {
			final DefineText2Tag ctag = (DefineText2Tag) tag;

			addNode("FontID", ctag.getCharacterId());
			addNode("TextBounds", ctag.getTextBounds());
			addNode("TextMatrix", ctag.getTextMatrix());
			addNode("GlyphBits", ctag.getGlyphBits());
			addNode("AdvanceBits", ctag.getAdvanceBits());
			addNode("TextRecords", ctag.getTextRecords());
			addNode("End", ctag.getEnd());
		}
		else if (tag instanceof DefineTextTag) {
			final DefineTextTag ctag = (DefineTextTag) tag;

			addNode("FontID", ctag.getCharacterId());
			addNode("TextBounds", ctag.getTextBounds());
			addNode("TextMatrix", ctag.getTextMatrix());
			addNode("GlyphBits", ctag.getGlyphBits());
			addNode("AdvanceBits", ctag.getAdvanceBits());
			addNode("TextRecords", ctag.getTextRecords());
			addNode("End", ctag.getEnd());
		}
		else if (tag instanceof DefineVideoStreamTag) {
			final DefineVideoStreamTag ctag = (DefineVideoStreamTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("NumFrames", ctag.getNumFrames());
			addNode("Width", ctag.getWidth());
			addNode("Height", ctag.getHeight());
			addNode("VideoFlagsReserved", ctag.getVideoFlagsReserved());
			addNode("VideoFlagsDeblocking", ctag.getVideoFlagsDeblocking());
			addNode("VideoFlagsSmoothing", ctag.getVideoFlagsSmoothing());
			addNode("CodecID", ctag.getCodecId());
		}
		else if (tag instanceof DoABCTag) {
		}
		else if (tag instanceof DoActionTag) {
		}
		else if (tag instanceof DoInitActionTag) {
			final DoInitActionTag ctag = (DoInitActionTag) tag;

			addNode("SpriteID", ctag.getSpriteId());
		}
		else if (tag instanceof EnableDebugger2Tag) {
			final EnableDebugger2Tag ctag = (EnableDebugger2Tag) tag;

			addNode("Password", ctag.getPassword());
			addNode("Reserved", ctag.getReserved());
		}
		else if (tag instanceof EnableDebuggerTag) {
			final EnableDebuggerTag ctag = (EnableDebuggerTag) tag;

			addNode("Password", ctag.getPassword());
		}
		else if (tag instanceof EndTag) {
			// Nothing to do here
		}
		else if (tag instanceof ExportAssetsTag) {
			final ExportAssetsTag ctag = (ExportAssetsTag) tag;

			addNode("Count", ctag.getCount());
			addNode("Assets", ctag.getAssets());
		}
		else if (tag instanceof FileAttributesTag) {
			final FileAttributesTag ctag = (FileAttributesTag) tag;

			addNode("Reserved", ctag.getReserved());
			addNode("UseDirectBit", ctag.getUseDirectBit());
			addNode("UseGPU", ctag.getUseGPU());
			addNode("HasMetadata", ctag.getHasMetadata());
			addNode("ActionScript3", ctag.getActionScript3());
			addNode("Reserved2", ctag.getReserved2());
			addNode("Network", ctag.getUseNetwork());
			addNode("Reserved3", ctag.getReserved3());
		}
		else if (tag instanceof FrameLabelTag) {
			final FrameLabelTag ctag = (FrameLabelTag) tag;

			addNode("Name", ctag.getName());
			addNode("NamedAnchorFlag", ctag.getNamedAnchorFlag());
		}
		else if (tag instanceof ImportAssets2Tag) {
			final ImportAssets2Tag ctag = (ImportAssets2Tag) tag;

			addNode("URLs", ctag.getUrl());
			addNode("Count", ctag.getCount());
			addNode("Symbols", ctag.getSymbols());
			addNode("Count", ctag.getReserved());
			addNode("Count", ctag.getReserved2());
		}
		else if (tag instanceof ImportAssetsTag) {
			final ImportAssetsTag ctag = (ImportAssetsTag) tag;

			addNode("URLs", ctag.getUrl());
			addNode("Count", ctag.getCount());
			addNode("Symbols", ctag.getSymbols());
		}
		else if (tag instanceof JPEGTablesTag) {
			final JPEGTablesTag ctag = (JPEGTablesTag) tag;

			addNode("JPEGData", ctag.getJpegData());
		}
		else if (tag instanceof MetadataTag) {
			final MetadataTag ctag = (MetadataTag) tag;

			addNode("Metadata", ctag.getMetadata());
		}
		else if (tag instanceof PlaceObject2Tag) {
			final PlaceObject2Tag ctag = (PlaceObject2Tag) tag;

			addNode("PlaceFlagHasClipActions", ctag.getPlaceFlagHasClipActions());
			addNode("PlaceFlagHasClipDepth", ctag.getPlaceFlagHasClipDepth());
			addNode("PlaceFlagHasName", ctag.getPlaceFlagHasName());
			addNode("PlaceFlagHasRatio", ctag.getPlaceFlagHasRatio());
			addNode("PlaceFlagHasColorTransform", ctag.getPlaceFlagHasColorTransform());
			addNode("PlaceFlagHasMatrix", ctag.getPlaceFlagHasMatrix());
			addNode("PlaceFlagHasCharacter", ctag.getPlaceFlagHasCharacter());
			addNode("PlaceFlagHasMove", ctag.getPlaceFlagHasMove());
			addNode("Depth", ctag.getDepth());
			addNode("CharacterID", ctag.getCharacterId());
			addNode("Matrix", ctag.getMatrix());
			addNode("ColorTransform", ctag.getColorTransform());
			addNode("Ratio", ctag.getRatio());
			addNode("Name", ctag.getName());
			addNode("ClipDepth", ctag.getClipDepth());
			addNode("ClipActions", ctag.getClipActions());
		}
		else if (tag instanceof PlaceObject3Tag) {
			final PlaceObject3Tag ctag = (PlaceObject3Tag) tag;

			addNode("PlaceFlagHasClipActions", ctag.getPlaceFlagHasClipActions());
			addNode("PlaceFlagHasClipDepth", ctag.getPlaceFlagHasClipDepth());
			addNode("PlaceFlagHasName", ctag.getPlaceFlagHasName());
			addNode("PlaceFlagHasRatio", ctag.getPlaceFlagHasRatio());
			addNode("PlaceFlagHasColorTransform", ctag.getPlaceFlagHasColorTransform());
			addNode("PlaceFlagHasMatrix", ctag.getPlaceFlagHasMatrix());
			addNode("PlaceFlagHasCharacter", ctag.getPlaceFlagHasCharacter());
			addNode("PlaceFlagHasMove", ctag.getPlaceFlagHasMove());
			addNode("Reserved", ctag.getReserved());
			addNode("PlaceFlagHasImage", ctag.getPlaceFlagHasImage());
			addNode("PlaceFlagHasClassName", ctag.getPlaceFlagHasClassName());
			addNode("PlaceFlagHasCacheAsBitmap", ctag.getPlaceFlagHasCacheAsBitmap());
			addNode("PlaceFlagHasBlendMode", ctag.getPlaceFlagHasBlendMode());
			addNode("PlaceFlagHasFilterList", ctag.getPlaceFlagHasFilterList());
			addNode("Depth", ctag.getDepth());
			addNode("ClassName", ctag.getClassName());
			addNode("CharacterID", ctag.getCharacterId());
			addNode("Matrix", ctag.getMatrix());
			addNode("ColorTransform", ctag.getColorTransform());
			addNode("Ratio", ctag.getRatio());
			addNode("Name", ctag.getName());
			addNode("ClipDepth", ctag.getClipDepth());
			addNode("SurfaceFilterList", ctag.getSurfaceFilterList());
			addNode("BlendMode", ctag.getBlendMode());
			addNode("BitmapCache", ctag.getBitmapCache());
			addNode("ClipActions", ctag.getClipActions());
		}
		else if (tag instanceof PlaceObjectTag) {
			final PlaceObjectTag ctag = (PlaceObjectTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("Depth", ctag.getDepth());
			addNode("Matrix", ctag.getMatrix());
			addNode("ColorTransform", ctag.getColorTransform());
		}
		else if (tag instanceof RemoveObject2Tag) {
			final RemoveObject2Tag ctag = (RemoveObject2Tag) tag;

			addNode("Depth", ctag.getDepth());
		}
		else if (tag instanceof RemoveObjectTag) {
			final RemoveObjectTag ctag = (RemoveObjectTag) tag;

			addNode("CharacterID", ctag.getCharacterId());
			addNode("Depth", ctag.getDepth());
		}
		else if (tag instanceof ScriptLimitsTag) {
			final ScriptLimitsTag ctag = (ScriptLimitsTag) tag;

			addNode("MaxRecursionDepth", ctag.getMaxRecursionDepth());
			addNode("ScriptTimeoutSeconds", ctag.getScriptTimeoutSeconds());
		}
		else if (tag instanceof SetBackgroundColorTag) {
			final SetBackgroundColorTag ctag = (SetBackgroundColorTag) tag;

			addNode("BackgroundColor", ctag.getBackgroundColor());
		}
		else if (tag instanceof SetTabIndexTag) {
			final SetTabIndexTag ctag = (SetTabIndexTag) tag;

			addNode("Depth", ctag.getDepth());
			addNode("TabIndex", ctag.getTabIndex());
		}
		else if (tag instanceof ShowFrameTag) {
			// Nothing to do here
		}
		else if (tag instanceof SoundStreamBlockTag) {
			final SoundStreamBlockTag ctag = (SoundStreamBlockTag) tag;

			addNode("StreamSoundData", ctag.getStreamSoundData());
		}
		else if (tag instanceof SoundStreamHead2Tag) {
			final SoundStreamHead2Tag ctag = (SoundStreamHead2Tag) tag;

			addNode("Reserved", ctag.getReserved());
			addNode("PlaybackSoundRate", ctag.getPlaybackSoundRate());
			addNode("PlaybackSoundSize", ctag.getPlaybackSoundSize());
			addNode("PlaybackSoundType", ctag.getPlaybackSoundType());
			addNode("StreamSoundCompression", ctag.getStreamSoundCompression());
			addNode("StreamSoundRate", ctag.getStreamSoundRate());
			addNode("StreamSoundSize", ctag.getStreamSoundSize());
			addNode("StreamSoundType", ctag.getStreamSoundType());
			addNode("StreamSoundSampleCount", ctag.getStreamSoundSampleCount());
			addNode("LatencySeek", ctag.getLatencySeek());
		}
		else if (tag instanceof SoundStreamHeadTag) {
			final SoundStreamHeadTag ctag = (SoundStreamHeadTag) tag;

			addNode("Reserved", ctag.getReserved());
			addNode("PlaybackSoundRate", ctag.getPlaybackSoundRate());
			addNode("PlaybackSoundSize", ctag.getPlaybackSoundSize());
			addNode("PlaybackSoundType", ctag.getPlaybackSoundType());
			addNode("StreamSoundCompression", ctag.getStreamSoundCompression());
			addNode("StreamSoundRate", ctag.getStreamSoundRate());
			addNode("StreamSoundSize", ctag.getStreamSoundSize());
			addNode("StreamSoundType", ctag.getStreamSoundType());
			addNode("StreamSoundSampleCount", ctag.getStreamSoundSampleCount());
			addNode("LatencySeek", ctag.getLatencySeek());
		}
		else if (tag instanceof StartSound2Tag) {
			final StartSound2Tag ctag = (StartSound2Tag) tag;

			addNode("SoundClassName", ctag.getSoundClassName());
			addNode("SoundInfo", ctag.getSoundInfo());
		}
		else if (tag instanceof StartSoundTag) {
			final StartSoundTag ctag = (StartSoundTag) tag;

			addNode("SoundID", ctag.getSoundId());
			addNode("SoundInfo", ctag.getSoundInfo());
		}
		else if (tag instanceof SymbolClassTag) {
			final SymbolClassTag ctag = (SymbolClassTag) tag;

			addNode("NumSymbols", ctag.getNumSymbols());
			addNode("Symbols", ctag.getSymbols());
		}
		else if (tag instanceof VideoFrameTag) {
			final VideoFrameTag ctag = (VideoFrameTag) tag;

			addNode("StreamID", ctag.getStreamId());
			addNode("FrameNum", ctag.getFrameNum());
			addNode("VideoData", ctag.getVideoData());
		}
		else if (tag instanceof DoABCTag) {
			final DoABCTag ctag = (DoABCTag) tag;

			addNode("Name", ctag.getName());
			addNode("Flags", ctag.getFlags());
			addNode("ABCData", ctag.getAbcData());
		}
	}

	@Override
	public String toString() {
		return getName();
	}
}