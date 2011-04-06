package tv.porst.swfretools.utils;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.BevelFilter;
import tv.porst.swfretools.parser.structures.BlurFilter;
import tv.porst.swfretools.parser.structures.ButtonCondAction;
import tv.porst.swfretools.parser.structures.ButtonCondActionList;
import tv.porst.swfretools.parser.structures.ButtonRecord2;
import tv.porst.swfretools.parser.structures.ButtonRecord2List;
import tv.porst.swfretools.parser.structures.ClipActionRecord;
import tv.porst.swfretools.parser.structures.ClipActionRecordList;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.ClipEventFlags;
import tv.porst.swfretools.parser.structures.ColorMatrixFilter;
import tv.porst.swfretools.parser.structures.ConvolutionFilter;
import tv.porst.swfretools.parser.structures.CurvedEdgeRecord;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.DropShadowFilter;
import tv.porst.swfretools.parser.structures.EndShapeRecord;
import tv.porst.swfretools.parser.structures.FillStyle;
import tv.porst.swfretools.parser.structures.FillStyle3;
import tv.porst.swfretools.parser.structures.FillStyle3Array;
import tv.porst.swfretools.parser.structures.FillStyle3List;
import tv.porst.swfretools.parser.structures.FillStyleArray;
import tv.porst.swfretools.parser.structures.FillStyleList;
import tv.porst.swfretools.parser.structures.Filter;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.FocalGradient;
import tv.porst.swfretools.parser.structures.GlowFilter;
import tv.porst.swfretools.parser.structures.GlyphEntry;
import tv.porst.swfretools.parser.structures.GlyphEntryList;
import tv.porst.swfretools.parser.structures.GradRecord;
import tv.porst.swfretools.parser.structures.GradRecord3;
import tv.porst.swfretools.parser.structures.GradRecord3List;
import tv.porst.swfretools.parser.structures.GradRecordList;
import tv.porst.swfretools.parser.structures.Gradient;
import tv.porst.swfretools.parser.structures.Gradient3;
import tv.porst.swfretools.parser.structures.GradientBevelFilter;
import tv.porst.swfretools.parser.structures.GradientGlowFilter;
import tv.porst.swfretools.parser.structures.IGradient;
import tv.porst.swfretools.parser.structures.INT16List;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordList;
import tv.porst.swfretools.parser.structures.LineStyle;
import tv.porst.swfretools.parser.structures.LineStyle3;
import tv.porst.swfretools.parser.structures.LineStyle3Array;
import tv.porst.swfretools.parser.structures.LineStyle3List;
import tv.porst.swfretools.parser.structures.LineStyle4;
import tv.porst.swfretools.parser.structures.LineStyle4Array;
import tv.porst.swfretools.parser.structures.LineStyle4List;
import tv.porst.swfretools.parser.structures.LineStyleArray;
import tv.porst.swfretools.parser.structures.LineStyleList;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MorphFillStyle;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphFillStyleList;
import tv.porst.swfretools.parser.structures.MorphGradient;
import tv.porst.swfretools.parser.structures.MorphGradientRecord;
import tv.porst.swfretools.parser.structures.MorphGradientRecordList;
import tv.porst.swfretools.parser.structures.MorphLineStyle;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleList;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectList;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.Shape3;
import tv.porst.swfretools.parser.structures.Shape3List;
import tv.porst.swfretools.parser.structures.Shape3Record;
import tv.porst.swfretools.parser.structures.Shape3RecordList;
import tv.porst.swfretools.parser.structures.Shape4Record;
import tv.porst.swfretools.parser.structures.ShapeList;
import tv.porst.swfretools.parser.structures.ShapeRecord;
import tv.porst.swfretools.parser.structures.ShapeRecordList;
import tv.porst.swfretools.parser.structures.ShapeWithStyle;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;
import tv.porst.swfretools.parser.structures.SingleFilterList;
import tv.porst.swfretools.parser.structures.SoundEnvelope;
import tv.porst.swfretools.parser.structures.SoundEnvelopeList;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.StraightEdgeRecord;
import tv.porst.swfretools.parser.structures.StyleChangeRecord;
import tv.porst.swfretools.parser.structures.StyleChangeRecord3;
import tv.porst.swfretools.parser.structures.StyleChangeRecord4;
import tv.porst.swfretools.parser.structures.Symbol;
import tv.porst.swfretools.parser.structures.TagList;
import tv.porst.swfretools.parser.structures.TextRecord;
import tv.porst.swfretools.parser.structures.TextRecord2;
import tv.porst.swfretools.parser.structures.TextRecord2List;
import tv.porst.swfretools.parser.structures.TextRecordList;
import tv.porst.swfretools.parser.structures.UINT16List;
import tv.porst.swfretools.parser.structures.ZoneData;
import tv.porst.swfretools.parser.structures.ZoneDataList;
import tv.porst.swfretools.parser.structures.ZoneRecord;
import tv.porst.swfretools.parser.structures.ZoneRecordList;
import tv.porst.swfretools.parser.tags.CSMTextSettingsTag;
import tv.porst.swfretools.parser.tags.DefineBitsJPEG2Tag;
import tv.porst.swfretools.parser.tags.DefineBitsJPEG3Tag;
import tv.porst.swfretools.parser.tags.DefineBitsLossless2Tag;
import tv.porst.swfretools.parser.tags.DefineBitsLosslessTag;
import tv.porst.swfretools.parser.tags.DefineBitsTag;
import tv.porst.swfretools.parser.tags.DefineButton2Tag;
import tv.porst.swfretools.parser.tags.DefineEditTextTag;
import tv.porst.swfretools.parser.tags.DefineFont2Tag;
import tv.porst.swfretools.parser.tags.DefineFont3Tag;
import tv.porst.swfretools.parser.tags.DefineFontAlignZonesTag;
import tv.porst.swfretools.parser.tags.DefineFontInfo2Tag;
import tv.porst.swfretools.parser.tags.DefineFontInfoTag;
import tv.porst.swfretools.parser.tags.DefineFontNameTag;
import tv.porst.swfretools.parser.tags.DefineFontTag;
import tv.porst.swfretools.parser.tags.DefineMorphShapeTag;
import tv.porst.swfretools.parser.tags.DefineShape2Tag;
import tv.porst.swfretools.parser.tags.DefineShape3Tag;
import tv.porst.swfretools.parser.tags.DefineShape4Tag;
import tv.porst.swfretools.parser.tags.DefineShapeTag;
import tv.porst.swfretools.parser.tags.DefineSoundTag;
import tv.porst.swfretools.parser.tags.DefineSpriteTag;
import tv.porst.swfretools.parser.tags.DefineText2Tag;
import tv.porst.swfretools.parser.tags.DefineTextTag;
import tv.porst.swfretools.parser.tags.DefineVideoStreamTag;
import tv.porst.swfretools.parser.tags.DoActionTag;
import tv.porst.swfretools.parser.tags.DoInitActionTag;
import tv.porst.swfretools.parser.tags.EndTag;
import tv.porst.swfretools.parser.tags.ExportAssetsTag;
import tv.porst.swfretools.parser.tags.FileAttributesTag;
import tv.porst.swfretools.parser.tags.FrameLabelTag;
import tv.porst.swfretools.parser.tags.JPEGTablesTag;
import tv.porst.swfretools.parser.tags.MetadataTag;
import tv.porst.swfretools.parser.tags.PlaceObject2Tag;
import tv.porst.swfretools.parser.tags.PlaceObject3Tag;
import tv.porst.swfretools.parser.tags.ProtectTag;
import tv.porst.swfretools.parser.tags.RemoveObject2Tag;
import tv.porst.swfretools.parser.tags.SetBackgroundColorTag;
import tv.porst.swfretools.parser.tags.ShowFrameTag;
import tv.porst.swfretools.parser.tags.SoundStreamBlockTag;
import tv.porst.swfretools.parser.tags.SoundStreamHead2Tag;
import tv.porst.swfretools.parser.tags.SoundStreamHeadTag;
import tv.porst.swfretools.parser.tags.StartSoundTag;
import tv.porst.swfretools.parser.tags.Tag;

public class SWFIterator {

	private static void visit(final ActionList actions, final ISWFVisitor visitor) {

		for (final Action action : actions) {
			visitor.visit(actions, "Action", action);
		}
	}

	private static void visit(final BevelFilter filter, final ISWFVisitor visitor) {
		visitor.visit(filter, "ShadowColor", filter.getShadowColor());
		visitor.visit(filter, "HightlightColor", filter.getHighlightColor());
		visitor.visit("BlurX", filter.getBlurX());
		visitor.visit("BlurY", filter.getBlurY());
		visitor.visit("Angle", filter.getAngle());
		visitor.visit("Distance", filter.getDistance());
		visitor.visit("Strength", filter.getStrength());
		visitor.visit("InnerShadow", filter.getInnerShadow());
		visitor.visit("Knockout", filter.getKnockout());
		visitor.visit("CompositeSource", filter.getCompositeSource());
		visitor.visit("OnTop", filter.getOnTop());
		visitor.visit("Passes", filter.getPasses());
	}

	private static void visit(final BlurFilter filter, final ISWFVisitor visitor) {
		visitor.visit("BlurX", filter.getBlurX());
		visitor.visit("BlurY", filter.getBlurY());
		visitor.visit("Passes", filter.getPasses());
		visitor.visit("Reserved", filter.getReserved());
	}

	private static void visit(final ButtonCondAction action, final ISWFVisitor visitor) {
		visitor.visit("CondActionSize", action.getCondActionSize());
		visitor.visit("CondIdleToOverDown", action.getCondIdleToOverDown());
		visitor.visit("CondOutDownToIdle", action.getCondOutDownToIdle());
		visitor.visit("CondOutDownToOverDown", action.getCondOutDownToOverDown());
		visitor.visit("CondOverDownToOutDown", action.getCondOverDownToOutDown());
		visitor.visit("CondOverDownToOverUp", action.getCondOverDownToOverUp());
		visitor.visit("CondOverUpToOverDown", action.getCondOverUpToOverDown());
		visitor.visit("CondOverUpToIdle", action.getCondOverUpToIdle());
		visitor.visit("CondIdleToOverUp", action.getCondIdleToOverUp());
		visitor.visit("CondKeyPress", action.getCondKeyPress());
		visitor.visit("CondOverDownToIdle", action.getCondOverDownToIdle());
		visitor.visit(action, "Actions", action.getActions());
		visit(action.getActions(), visitor);
		visitor.visit("ActionEndFlag", action.getActionEndFlag());
	}

	private static void visit(final ButtonCondActionList actions, final ISWFVisitor visitor) {
		for (final ButtonCondAction action : actions) {
			visitor.visit(actions, "Action", action);
			visit(action, visitor);
		}
	}

	private static void visit(final ButtonRecord2 record, final ISWFVisitor visitor) {
		visitor.visit("ButtonReserved", record.getButtonReserved());
		visitor.visit("ButtonHasBlendMode", record.getButtonHasBlendMode());
		visitor.visit("ButtonHasFilterList", record.getButtonHasFilterList());
		visitor.visit("ButtonStateHitTest", record.getButtonStateHitTest());
		visitor.visit("ButtonStateDown", record.getButtonStateDown());
		visitor.visit("ButtonStateOver", record.getButtonStateOver());
		visitor.visit("ButtonStateUp", record.getButtonStateUp());
		visitor.visit("CharacterID", record.getCharacterId());
		visitor.visit("PlaceDepth", record.getPlaceDepth());
		visitor.visit(record, "PlaceMatrix", record.getPlaceMatrix());
		visit(record.getPlaceMatrix(), visitor);
		visitor.visit(record, "ColorTransform", record.getColorTransform());
		visit(record.getColorTransform(), visitor);
		visitor.visit(record, "FilterList", record.getFilterList());
		visit(record.getFilterList(), visitor);
		visitor.visit("BlendMode", record.getBlendMode());
	}

	private static void visit(final ButtonRecord2List characters, final ISWFVisitor visitor) {
		for (final ButtonRecord2 character : characters) {
			visitor.visit(characters, "Character", character);
			visit(character, visitor);
		}
	}

	private static void visit(final ColorMatrixFilter filter, final ISWFVisitor visitor) {
		// TODO
	}

	private static void visit(final ConvolutionFilter filter, final ISWFVisitor visitor) {
		visitor.visit("MatrixX", filter.getMatrixX());
		visitor.visit("MatrixY", filter.getMatrixY());
		visitor.visit("Divisor", filter.getDivisor());
		visitor.visit("Bias", filter.getBias());
		// TODO
		// visitor.visit("Matrix", filter.getMatrix());
		visitor.visit(filter, "DefaultColor", filter.getDefaultColor());
		visit(filter.getDefaultColor(), visitor);
		visitor.visit("Reserved", filter.getReserved());
		visitor.visit("Clamp", filter.getClamp());
		visitor.visit("PreserveAlpha", filter.getPreserveAlpha());
	}

	private static void visit(final DropShadowFilter filter, final ISWFVisitor visitor) {
		visitor.visit(filter, "DropShadowColor", filter.getDropShadowColor());
		visit(filter.getDropShadowColor(), visitor);
		visitor.visit("BlurX", filter.getBlurX());
		visitor.visit("BlurY", filter.getBlurY());
		visitor.visit("Angle", filter.getAngle());
		visitor.visit("Distance", filter.getDistance());
		visitor.visit("Strength", filter.getStrength());
		visitor.visit("InnerShadow", filter.getInnerShadow());
		visitor.visit("Knockout", filter.getKnockout());
		visitor.visit("CompositeSource", filter.getCompositeSource());
		visitor.visit("Passes", filter.getPasses());
	}

	private static void visit(final Filter filter, final ISWFVisitor visitor) {
		visitor.visit("FilterID", filter.getFilterId());
		visitor.visit(filter, "DropShadowFilter", filter.getDropShadowFilter());
		visit(filter.getDropShadowFilter(), visitor);
		visitor.visit(filter, "BlurFilter", filter.getBlurFilter());
		visit(filter.getBlurFilter(), visitor);
		visitor.visit(filter, "GlowFilter", filter.getGlowFilter());
		visit(filter.getGlowFilter(), visitor);
		visitor.visit(filter, "BevelFilter", filter.getBevelFilter());
		visit(filter.getBevelFilter(), visitor);
		visitor.visit(filter, "GradientGlowFilter", filter.getGradientGlowFilter());
		visit(filter.getGradientGlowFilter(), visitor);
		visitor.visit(filter, "ConvolutionFilter", filter.getConvolutionFilter());
		visit(filter.getConvolutionFilter(), visitor);
		visitor.visit(filter, "ColorMatrixFilter", filter.getColorMatrixFilter());
		visit(filter.getColorMatrixFilter(), visitor);
		visitor.visit(filter, "GradientBevelFilter", filter.getGradientBevelFilter());
		visit(filter.getGradientBevelFilter(), visitor);
	}

	private static void visit(final FilterList filterList, final ISWFVisitor visitor) {

		if (filterList != null) {
			visitor.visit("NumberOfFilters", filterList.getNumberOfFilters());
			visitor.visit(filterList, "Filters", filterList.getFilters());
			visit(filterList.getFilters(), visitor);
		}
	}

	private static void visit(final GlowFilter filter, final ISWFVisitor visitor) {
		visitor.visit(filter, "GlowColor", filter.getGlowColor());
		visit(filter.getGlowColor(), visitor);
		visitor.visit("BlurX", filter.getBlurX());
		visitor.visit("BlurY", filter.getBlurY());
		visitor.visit("Strength", filter.getStrength());
		visitor.visit("InnerShadow", filter.getInnerShadow());
		visitor.visit("Knockout", filter.getKnockout());
		visitor.visit("CompositeSource", filter.getCompositeSource());
		visitor.visit("Passes", filter.getPasses());
	}

	private static void visit(final GlyphEntry glyphEntry, final ISWFVisitor visitor) {

		visitor.visit("GlyphIndex", glyphEntry.getGlyphIndex());
		visitor.visit("AdvanceIndex", glyphEntry.getAdvanceIndex());
	}

	private static void visit(final GlyphEntryList glyphEntries, final ISWFVisitor visitor) {
		for (final GlyphEntry glyphEntry : glyphEntries) {
			visitor.visit(glyphEntries, "GlyphEntry", glyphEntry);
			visit(glyphEntry, visitor);
		}
	}

	private static void visit(final GradientBevelFilter filter, final ISWFVisitor visitor) {
		visitor.visit("NumColors", filter.getNumColors());
		// TODO
		visitor.visit("BlurX", filter.getBlurX());
		visitor.visit("BlurY", filter.getBlurY());
		visitor.visit("Angle", filter.getAngle());
		visitor.visit("Distance", filter.getDistance());
		visitor.visit("Strength", filter.getStrength());
		visitor.visit("InnerShadow", filter.getInnerShadow());
		visitor.visit("Knockout", filter.getKnockout());
		visitor.visit("CompositeSource", filter.getCompositeSource());
		visitor.visit("OnTop", filter.getOnTop());
		visitor.visit("Passes", filter.getPasses());
	}

	private static void visit(final GradientGlowFilter filter, final ISWFVisitor visitor) {
		visitor.visit("NumColors", filter.getNumColors());
		//TODO
		visitor.visit("BlurX", filter.getBlurX());
		visitor.visit("BlurY", filter.getBlurY());
		visitor.visit("Angle", filter.getAngle());
		visitor.visit("Distance", filter.getDistance());
		visitor.visit("Strength", filter.getStrength());
		visitor.visit("InnerShadow", filter.getInnerShadow());
		visitor.visit("Knockout", filter.getKnockout());
		visitor.visit("CompositeSource", filter.getCompositeSource());
		visitor.visit("OnTop", filter.getOnTop());
		visitor.visit("Passes", filter.getPasses());
	}

	private static void visit(final INT16List list, final ISWFVisitor visitor) {
		for (final INT16 element : list) {
			visitor.visit("Element", element);
		}
	}

	private static void visit(final MorphGradient gradient, final ISWFVisitor visitor) {

		if (gradient != null) {
			visitor.visit("NumGradients", gradient.getNumGradients());
			visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
			visit(gradient.getGradientRecords(), visitor);
		}
	}

	private static void visit(final MorphGradientRecord record, final ISWFVisitor visitor) {
		visitor.visit("StartRatio", record.getStartRatio());
		visitor.visit(record, "StartColor", record.getStartColor());
		visit(record.getStartColor(), visitor);
		visitor.visit("EndRatio", record.getEndRatio());
		visitor.visit(record, "EndColor", record.getEndColor());
		visit(record.getEndColor(), visitor);
	}

	private static void visit(final MorphGradientRecordList list, final ISWFVisitor visitor) {
		for (final MorphGradientRecord record : list) {
			visitor.visit(list, "GradientRecord", record);
			visit(record, visitor);
		}
	}

	private static void visit(final RectList list, final ISWFVisitor visitor) {
		for (final Rect element : list) {
			visitor.visit(list, "Element", element);
			visit(element, visitor);
		}
	}

	private static void visit(final Shape shape, final ISWFVisitor visitor) {
		visitor.visit("NumFillBits", shape.getNumFillBits());
		visitor.visit("NumLineBits", shape.getNumLineBits());
		visitor.visit(shape, "ShapeRecord", shape.getShapeRecord());
		visit(shape.getShapeRecord(), visitor);
	}

	private static void visit(final Shape3 shape, final ISWFVisitor visitor) {
		visitor.visit("NumFillBits", shape.getNumFillBits());
		visitor.visit("NumLineBits", shape.getNumLineBits());
		visitor.visit(shape, "ShapeRecord", shape.getShapeRecord());
		visit(shape.getShapeRecord(), visitor);
	}

	private static void visit(final Shape3RecordList shapeRecordList, final ISWFVisitor visitor) {
		for (final Shape3Record shapeRecord : shapeRecordList) {

			if (shapeRecord instanceof CurvedEdgeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (CurvedEdgeRecord) shapeRecord);
				visit((CurvedEdgeRecord) shapeRecord, visitor);
			}
			else if (shapeRecord instanceof EndShapeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (EndShapeRecord) shapeRecord);
				visit((EndShapeRecord) shapeRecord, visitor);
			}
			else if (shapeRecord instanceof StraightEdgeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (StraightEdgeRecord) shapeRecord);
				visit((StraightEdgeRecord) shapeRecord, visitor);
			}
			else if (shapeRecord instanceof StyleChangeRecord3) {
				visitor.visit(shapeRecordList, "ShapeRecord", (StyleChangeRecord3) shapeRecord);
				visit((StyleChangeRecord3) shapeRecord, visitor);
			}
		}
	}

	private static void visit(final ShapeRecordList shapeRecordList, final ISWFVisitor visitor) {
		for (final ShapeRecord shapeRecord : shapeRecordList) {

			if (shapeRecord instanceof CurvedEdgeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (CurvedEdgeRecord) shapeRecord);
				visit((CurvedEdgeRecord) shapeRecord, visitor);
			}
			else if (shapeRecord instanceof EndShapeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (EndShapeRecord) shapeRecord);
				visit((EndShapeRecord) shapeRecord, visitor);
			}
			else if (shapeRecord instanceof StraightEdgeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (StraightEdgeRecord) shapeRecord);
				visit((StraightEdgeRecord) shapeRecord, visitor);
			}
			else if (shapeRecord instanceof StyleChangeRecord) {
				visitor.visit(shapeRecordList, "ShapeRecord", (StyleChangeRecord) shapeRecord);
				visit((StyleChangeRecord) shapeRecord, visitor);
			}
		}
	}

	private static void visit(final ShapeWithStyle4 shapes, final ISWFVisitor visitor) {

		visitor.visit(shapes, "FillStyles", shapes.getFillStyles());
		visit(shapes.getFillStyles(), visitor);
		visitor.visit(shapes, "LineStyles", shapes.getLineStyles());
		visit(shapes.getLineStyles(), visitor);
		visitor.visit("NumFillBits", shapes.getNumFillBits());
		visitor.visit("NumLineBits", shapes.getNumLineBits());

		final Shape4Record shapeRecord = shapes.getShapeRecord();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			visitor.visit(shapes, "CurvedEdgeRecord", (CurvedEdgeRecord) shapeRecord);
			visit((CurvedEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			visitor.visit(shapes, "EndShapeRecord", (EndShapeRecord) shapeRecord);
			visit((EndShapeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			visitor.visit(shapes, "StraightEdgeRecord", (StraightEdgeRecord) shapeRecord);
			visit((StraightEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StyleChangeRecord4) {
			visitor.visit(shapes, "StyleChangeRecord", (StyleChangeRecord4) shapeRecord);
			visit((StyleChangeRecord4) shapeRecord, visitor);
		}
	}

	private static void visit(final SingleFilterList filters, final ISWFVisitor visitor) {
		for (final Filter filter : filters) {
			visitor.visit(filters, "Filter", filter);
			visit(filter, visitor);
		}
	}

	private static void visit(final SoundEnvelope envelope, final ISWFVisitor visitor) {

		visitor.visit("Pos44", envelope.getPos44());
		visitor.visit("LeftLevel", envelope.getLeftLevel());
		visitor.visit("RightLevel", envelope.getRightLevel());
	}

	private static void visit(final SoundEnvelopeList list, final ISWFVisitor visitor) {
		for (final SoundEnvelope envelope : list) {
			visitor.visit(list, "SoundEnvelope", envelope);
			visit(envelope, visitor);
		}
	}

	private static void visit(final TextRecord textRecord, final ISWFVisitor visitor) {

		visitor.visit("TextRecordType", textRecord.getTextRecordType());
		visitor.visit("StyleFlagsReserved", textRecord.getStyleFlagsReserved());
		visitor.visit("StyleFlagsHasFont", textRecord.getStyleFlagsHasFont());
		visitor.visit("StyleFlagsHasColor", textRecord.getStyleFlagsHasColor());
		visitor.visit("StyleFlagsHasYOffset", textRecord.getStyleFlagsHasYOffset());
		visitor.visit("StyleFlagsHasXOffset", textRecord.getStyleFlagsHasXOffset());
		visitor.visit("FontID", textRecord.getFontId());
		visitor.visit(textRecord, "TextColor", textRecord.getTextColor());
		visit(textRecord.getTextColor(), visitor);
		visitor.visit("XOffset", textRecord.getxOffset());
		visitor.visit("YOffset", textRecord.getyOffset());
		visitor.visit("TextHeight", textRecord.getTextHeight());
		visitor.visit("GlyphCount", textRecord.getGlyphCount());
		visitor.visit(textRecord, "GlyphEntries", textRecord.getGlyphEntries());
		visit(textRecord.getGlyphEntries(), visitor);
	}

	private static void visit(final TextRecord2 textRecord, final ISWFVisitor visitor) {

		visitor.visit("TextRecordType", textRecord.getTextRecordType());
		visitor.visit("StyleFlagsReserved", textRecord.getStyleFlagsReserved());
		visitor.visit("StyleFlagsHasFont", textRecord.getStyleFlagsHasFont());
		visitor.visit("StyleFlagsHasColor", textRecord.getStyleFlagsHasColor());
		visitor.visit("StyleFlagsHasYOffset", textRecord.getStyleFlagsHasYOffset());
		visitor.visit("StyleFlagsHasXOffset", textRecord.getStyleFlagsHasXOffset());
		visitor.visit("FontID", textRecord.getFontId());
		visitor.visit(textRecord, "TextColor", textRecord.getTextColor());
		visit(textRecord.getTextColor(), visitor);
		visitor.visit("XOffset", textRecord.getxOffset());
		visitor.visit("YOffset", textRecord.getyOffset());
		visitor.visit("TextHeight", textRecord.getTextHeight());
		visitor.visit("GlyphCount", textRecord.getGlyphCount());
		visitor.visit(textRecord, "GlyphEntries", textRecord.getGlyphEntries());
		visit(textRecord.getGlyphEntries(), visitor);
	}

	private static void visit(final TextRecord2List textRecords, final ISWFVisitor visitor) {
		for (final TextRecord2 textRecord : textRecords) {
			visitor.visit(textRecords, "TextRecord", textRecord);
			visit(textRecord, visitor);
		}
	}

	private static void visit(final TextRecordList textRecords, final ISWFVisitor visitor) {
		for (final TextRecord textRecord : textRecords) {
			visitor.visit(textRecords, "TextRecord", textRecord);
			visit(textRecord, visitor);
		}
	}

	private static void visit(final UINT16List list, final ISWFVisitor visitor) {
		for (final UINT16 element : list) {
			visitor.visit("Element", element);
		}
	}

	private static void visit(final ZoneRecord zoneRecord, final ISWFVisitor visitor) {

		visitor.visit("NumZoneData", zoneRecord.getNumZoneData());
		visitor.visit(zoneRecord, "ZoneData", zoneRecord.getZoneData());
		visit(zoneRecord.getZoneData(), visitor);
		visitor.visit("Reserved", zoneRecord.getReserved());
		visitor.visit("ZoneMaskX", zoneRecord.getZoneMaskX());
		visitor.visit("ZoneMaskY", zoneRecord.getZoneMaskY());
	}

	public static void visit(final ClipActionRecord clipActionRecord, final ISWFVisitor visitor) {

		visitor.visit(clipActionRecord, "EventFlags", clipActionRecord.getEventFlags());
		visit(clipActionRecord.getEventFlags(), visitor);
		visitor.visit("ActionRecordSize", clipActionRecord.getActionRecordSize());
		visitor.visit("KeyCode", clipActionRecord.getKeyCode());
		visitor.visit(clipActionRecord, "Actions", clipActionRecord.getActions());
		visit(clipActionRecord.getActions(), visitor);
	}

	public static void visit(final ClipActionRecordList clipActionRecords, final ISWFVisitor visitor) {

		for (final ClipActionRecord clipActionRecord : clipActionRecords) {
			visitor.visit(clipActionRecords, "ClipActionRecord", clipActionRecord);
			visit(clipActionRecord, visitor);
		}
	}

	public static void visit(final ClipActions clipActions, final ISWFVisitor visitor) {

		if (clipActions != null) {

			visitor.visit("Reserved", clipActions.getReserved());
			visitor.visit(clipActions, "AllEventFlags", clipActions.getAllEventFlags());
			visit(clipActions.getAllEventFlags(), visitor);
			visitor.visit(clipActions, "ClipActionRecords", clipActions.getClipActionRecords());
			visit(clipActions.getClipActionRecords(), visitor);

			final IParsedINTElement endFlag = clipActions.getClipActionEndFlag();

			if (endFlag instanceof UINT16) {
				visitor.visit("ClipActionEndFlag", (UINT16) clipActions.getClipActionEndFlag());
			}
			else  {
				visitor.visit("ClipActionEndFlag", (UINT32) clipActions.getClipActionEndFlag());
			}
		}
	}

	public static void visit(final ClipEventFlags allEventFlags, final ISWFVisitor visitor) {

		visitor.visit("ClipEventKeyUp", allEventFlags.getClipEventKeyUp());
		visitor.visit("ClipEventKeyDown", allEventFlags.getClipEventKeyDown());
		visitor.visit("ClipEventMouseUp", allEventFlags.getClipEventMouseUp());
		visitor.visit("ClipEventMouseDown", allEventFlags.getClipEventMouseDown());
		visitor.visit("ClipEventMouseMove", allEventFlags.getClipEventMouseMove());
		visitor.visit("ClipEventUnload", allEventFlags.getClipEventUnload());
		visitor.visit("ClipEventEnterFrame", allEventFlags.getClipEventEnterFrame());
		visitor.visit("ClipEventLoad", allEventFlags.getClipEventLoad());
		visitor.visit("ClipEventDragOver", allEventFlags.getClipEventDragOver());
		visitor.visit("ClipEventRollOut", allEventFlags.getClipEventRollOut());
		visitor.visit("ClipEventRollOver", allEventFlags.getClipEventRollOver());
		visitor.visit("ClipEventReleaseOutside", allEventFlags.getClipEventReleaseOutside());
		visitor.visit("ClipEventRelease", allEventFlags.getClipEventRelease());
		visitor.visit("ClipEventPress", allEventFlags.getClipEventPress());
		visitor.visit("ClipEventInitialize", allEventFlags.getClipEventInitialize());
		visitor.visit("ClipEventData", allEventFlags.getClipEventData());
		visitor.visit("Reserved", allEventFlags.getReserved());
		visitor.visit("ClipEventConstruct", allEventFlags.getClipEventConstruct());
		visitor.visit("ClipEventKeyPress", allEventFlags.getClipEventKeyPress());
		visitor.visit("ClipEventDragOut", allEventFlags.getClipEventDragOut());
		visitor.visit("Reserved2", allEventFlags.getReserved2());
	}

	public static void visit(final CSMTextSettingsTag tag, final ISWFVisitor visitor) {

		visitor.visit("TextID", tag.getTextId());
		visitor.visit("UseFlashType", tag.getUseFlashType());
		visitor.visit("GridFit", tag.getGridFit());
		visitor.visit("Reserved", tag.getReserved());
		visitor.visit("Thickness", tag.getThickness());
		visitor.visit("Sharpness", tag.getSharpness());
		visitor.visit("Reserved2", tag.getReserved2());
	}

	public static void visit(final CurvedEdgeRecord shapeRecord, final ISWFVisitor visitor) {
		visitor.visit("TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit("StraightFlag", shapeRecord.getStraightFlag());
		visitor.visit("NumBits", shapeRecord.getNumBits());
		visitor.visit("ControlDeltaX", shapeRecord.getControlDeltaX());
		visitor.visit("ControlDeltaY", shapeRecord.getControlDeltaY());
		visitor.visit("AnchorDeltaX", shapeRecord.getAnchorDeltaX());
		visitor.visit("AnchorDeltaY", shapeRecord.getAnchorDeltaY());
	}

	public static void visit(final CxFormWithAlpha colorTransform, final ISWFVisitor visitor) {

		if (colorTransform != null) {

			visitor.visit("HasAddTerms", colorTransform.getHasAddTerms());
			visitor.visit("HasMultTerms", colorTransform.getHasMultTerms());
			visitor.visit("NBits", colorTransform.getnBits());
			visitor.visit("RedMultTerm", colorTransform.getRedMultTerm());
			visitor.visit("GreenMultTerm", colorTransform.getGreenMultTerm());
			visitor.visit("BlueMultTerm", colorTransform.getBlueMultTerm());
			visitor.visit("AlphaMultTerm", colorTransform.getAlphaMultTerm());
			visitor.visit("RedAddTerm", colorTransform.getRedAddTerm());
			visitor.visit("GreenAddTerm", colorTransform.getGreenAddTerm());
			visitor.visit("BlueAddTerm", colorTransform.getBlueAddTerm());
			visitor.visit("AlphaAddTerm", colorTransform.getAlphaAddTerm());
		}
	}

	public static void visit(final DefineBitsJPEG2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit("ImageData", tag.getImageData());
	}

	public static void visit(final DefineBitsJPEG3Tag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit("AlphaDataOffset", tag.getAlphaDataOffset());
		visitor.visit("JPEGData", tag.getJpegData());
		visitor.visit("BitmapAlphaData", tag.getBitmapAlphaData());
	}

	public static void visit(final DefineBitsLossless2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit("BitmapFormat", tag.getBitmapFormat());
		visitor.visit("BitmapWidth", tag.getBitmapWidth());
		visitor.visit("BitmapHeight", tag.getBitmapHeight());
		visitor.visit("BitmapColorTableSize", tag.getBitmapColorTableSize());
		visitor.visit("ZlibBitmapData", tag.getZlibBitmapData());
	}

	public static void visit(final DefineBitsLosslessTag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit("BitmapFormat", tag.getBitmapFormat());
		visitor.visit("BitmapWidth", tag.getBitmapWidth());
		visitor.visit("BitmapHeight", tag.getBitmapHeight());
		visitor.visit("BitmapColorTableSize", tag.getBitmapColorTableSize());
		visitor.visit("ZlibBitmapData", tag.getZlibBitmapData());
	}

	public static void visit(final DefineBitsTag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit("JPEGData", tag.getJpegData());
	}

	public static void visit(final DefineButton2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("ButtonID", tag.getButtonId());
		visitor.visit("ReservedFlags", tag.getReservedFlags());
		visitor.visit("TrackAsMenu", tag.getTrackAsMenu());
		visitor.visit("ActionOffset", tag.getActionOffset());
		visitor.visit(tag, "Characters", tag.getCharacters());
		visit(tag.getCharacters(), visitor);
		visitor.visit("CharacterEndFlag", tag.getCharacterEndFlag());
		visitor.visit(tag, "Actions", tag.getActions());
		visit(tag.getActions(), visitor);
	}

	public static void visit(final DefineEditTextTag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Bounds", tag.getBounds());
		visit(tag.getBounds(), visitor);
		visitor.visit("HasText", tag.getHasText());
		visitor.visit("WordWrap", tag.getWordWrap());
		visitor.visit("Multiline", tag.getMultiline());
		visitor.visit("Password", tag.getPassword());
		visitor.visit("ReadOnly", tag.getReadOnly());
		visitor.visit("HasTextColor", tag.getHasTextColor());
		visitor.visit("HasMaxLength", tag.getHasMaxLength());
		visitor.visit("HasFont", tag.getFontId());
		visitor.visit("HasFontClass", tag.getHasFontClass());
		visitor.visit("AutoSize", tag.getAutoSize());
		visitor.visit("HasLayout", tag.getHasLayout());
		visitor.visit("NoSelect", tag.getNoSelect());
		visitor.visit("Border", tag.getBorder());
		visitor.visit("WasStatic", tag.getWasStatic());
		visitor.visit("HTML", tag.getHtml());
		visitor.visit("UseOutlines", tag.getUseOutlines());
		visitor.visit("FontID", tag.getFontId());
		visitor.visit("FontClass", tag.getFontClass());
		visitor.visit("FontHeight", tag.getFontHeight());
		visitor.visit(tag, "TextColor", tag.getTextColor());
		visit(tag.getTextColor(), visitor);
		visitor.visit("MaxLength", tag.getMaxLength());
		visitor.visit("Align", tag.getAlign());
		visitor.visit("LeftMargin", tag.getLeftMargin());
		visitor.visit("RightMargin", tag.getRightMargin());
		visitor.visit("Indent", tag.getIndent());
		visitor.visit("Leading", tag.getLeading());
		visitor.visit("VariableName", tag.getVariableName());
		visitor.visit("InitialText", tag.getInitialText());
	}

	public static void visit(final DefineFont2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit("FontFlagsHasLayout", tag.getFontFlagsHasLayout());
		visitor.visit("FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit("FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit("FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit("FontFlagsWideOffsets", tag.getFontFlagsWideOffsets());
		visitor.visit("FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit("FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit("FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit("LanguageCode", tag.getLanguageCode());
		visitor.visit("FontNameLen", tag.getFontNameLen());
		visitor.visit("FontName", tag.getFontName());
		visitor.visit("NumGlyphs", tag.getNumGlyphs());
		visitor.visit(tag, "OffsetTable", tag.getOffsetTable());
		visit(tag.getOffsetTable(), visitor);

		final IParsedINTElement codeTableOffset = tag.getCodeTableOffset();

		if (codeTableOffset instanceof UINT16) {
			visitor.visit("CodeTableOffset", (UINT16) tag.getCodeTableOffset());
		} else {
			visitor.visit("CodeTableOffset", (UINT32) tag.getCodeTableOffset());
		}

		visitor.visit(tag, "GlyphShapeTable", tag.getGlyphShapeTable());
		visit(tag.getGlyphShapeTable(), visitor);
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
		visitor.visit("FontAscent", tag.getFontAscent());
		visitor.visit("FontDescent", tag.getFontDescent());
		visitor.visit("FontLeading", tag.getFontLeading());
		visitor.visit(tag, "FontAdvanceTable", tag.getFontAdvanceTable());
		visit(tag.getFontAdvanceTable(), visitor);
		visitor.visit(tag, "FontBoundsTable", tag.getFontBoundsTable());
		visit(tag.getFontBoundsTable(), visitor);
		visitor.visit("KerningCount", tag.getKerningCount());
		visitor.visit(tag, "FontKerningTable", tag.getFontKerningTable());
		visit(tag.getFontKerningTable(), visitor);
	}

	public static void visit(final DefineFont3Tag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit("FontFlagsHasLayout", tag.getFontFlagsHasLayout());
		visitor.visit("FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit("FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit("FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit("FontFlagsWideOffsets", tag.getFontFlagsWideOffsets());
		visitor.visit("FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit("FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit("FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit("LanguageCode", tag.getLanguageCode());
		visitor.visit("FontNameLen", tag.getFontNameLen());
		visitor.visit("FontName", tag.getFontName());
		visitor.visit("NumGlyphs", tag.getNumGlyphs());
		visitor.visit(tag, "OffsetTable", tag.getOffsetTable());
		visit(tag.getOffsetTable(), visitor);

		final IParsedINTElement codeTableOffset = tag.getCodeTableOffset();

		if (codeTableOffset instanceof UINT16) {
			visitor.visit("CodeTableOffset", (UINT16) tag.getCodeTableOffset());
		} else {
			visitor.visit("CodeTableOffset", (UINT32) tag.getCodeTableOffset());
		}

		visitor.visit(tag, "GlyphShapeTable", tag.getGlyphShapeTable());
		visit(tag.getGlyphShapeTable(), visitor);
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
		visitor.visit("FontAscent", tag.getFontAscent());
		visitor.visit("FontDescent", tag.getFontDescent());
		visitor.visit("FontLeading", tag.getFontLeading());
		visitor.visit(tag, "FontAdvanceTable", tag.getFontAdvanceTable());
		visit(tag.getFontAdvanceTable(), visitor);
		visitor.visit(tag, "FontBoundsTable", tag.getFontBoundsTable());
		visit(tag.getFontBoundsTable(), visitor);
		visitor.visit("KerningCount", tag.getKerningCount());
		visitor.visit(tag, "FontKerningTable", tag.getFontKerningTable());
		visit(tag.getFontKerningTable(), visitor);
	}

	public static void visit(final DefineFontAlignZonesTag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit("CSMTableHint", tag.getCsmTableHint());
		visitor.visit("Reserved", tag.getReserved());
		visitor.visit(tag, "ZoneTable", tag.getZoneTable());
		visit(tag.getZoneTable(), visitor);
	}

	public static void visit(final DefineFontInfo2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit("FontNameLen", tag.getFontNameLen());
		visitor.visit("FontName", tag.getFontName());
		visitor.visit("FontFlagsReserved", tag.getFontFlagsReserved());
		visitor.visit("FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit("FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit("FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit("FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit("FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit("FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit("LanguageCode", tag.getLanguageCode());
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
	}

	public static void visit(final DefineFontInfoTag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit("FontNameLen", tag.getFontNameLen());
		visitor.visit("FontName", tag.getFontName());
		visitor.visit("FontFlagsReserved", tag.getFontFlagsReserved());
		visitor.visit("FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit("FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit("FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit("FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit("FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit("FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
	}

	public static void visit(final DefineFontNameTag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit("FontName", tag.getFontName());
		visitor.visit("FontCopyright", tag.getFontCopyright());
	}

	public static void visit(final DefineFontTag tag, final ISWFVisitor visitor) {

		visitor.visit("FontID", tag.getFontId());
		visitor.visit(tag, "OffsetTable", tag.getOffsetTable());
		visit(tag.getOffsetTable(), visitor);
		visitor.visit(tag, "GlyphShapeTable", tag.getGlyphShapeTable());
		visit(tag.getGlyphShapeTable(), visitor);
	}

	public static void visit(final DefineMorphShapeTag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit(tag, "StartBounds", tag.getStartBounds());
		visit(tag.getStartBounds(), visitor);
		visitor.visit(tag, "EndBounds", tag.getEndBounds());
		visit(tag.getEndBounds(), visitor);
		visitor.visit("Offset", tag.getOffset());
		visitor.visit(tag, "MorphFillStyles", tag.getMorphFillStyles());
		visit(tag.getMorphFillStyles(), visitor);
		visitor.visit(tag, "MorphLineStyles", tag.getMorphLineStyles());
		visit(tag.getMorphLineStyles(), visitor);
		visitor.visit(tag, "StartEdges", tag.getStartEdges());
		visit(tag.getStartEdges(), visitor);
		visitor.visit(tag, "EndEdges", tag.getEndEdges());
		visit(tag.getEndEdges(), visitor);
	}

	public static void visit(final DefineShape2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	public static void visit(final DefineShape3Tag tag, final ISWFVisitor visitor) {

		visitor.visit("ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	public static void visit(final DefineShape4Tag tag, final ISWFVisitor visitor) {

		visitor.visit("ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "EdgeBounds", tag.getEdgeBounds());
		visit(tag.getEdgeBounds(), visitor);
		visitor.visit("Reserved", tag.getReserved());
		visitor.visit("UsesFillWindingRule", tag.getUsesFillWindingRule());
		visitor.visit("UsesNonScalingStrokes", tag.getUsesNonScalingStrokes());
		visitor.visit("UsesScalingStrokes", tag.getUsesScalingStrokes());
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	public static void visit(final DefineShapeTag tag, final ISWFVisitor visitor) {

		visitor.visit("ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	public static void visit(final DefineSoundTag tag, final ISWFVisitor visitor) {

		visitor.visit("SoundID", tag.getSoundId());
		visitor.visit("SoundFormat", tag.getSoundFormat());
		visitor.visit("SoundRate", tag.getSoundRate());
		visitor.visit("SoundSize", tag.getSoundSize());
		visitor.visit("SoundType", tag.getSoundType());
		visitor.visit("SoundSampleCount", tag.getSoundSampleCount());
		visitor.visit("SoundData", tag.getSoundData());
	}

	public static void visit(final DefineSpriteTag tag, final ISWFVisitor visitor) {

		visitor.visit("SpriteID", tag.getSpriteId());
		visitor.visit("FrameCount", tag.getFrameCount());
		visitor.visit(tag, "ControlTags", tag.getControlTags());
		visit(tag.getControlTags(), visitor);
	}

	public static void visit(final DefineText2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit(tag, "TextBounds", tag.getTextBounds());
		visit(tag.getTextBounds(), visitor);
		visitor.visit(tag, "TextMatrix", tag.getTextMatrix());
		visit(tag.getTextMatrix(), visitor);
		visitor.visit("GlyphBits", tag.getGlyphBits());
		visitor.visit("AdvanceBits", tag.getAdvanceBits());
		visitor.visit(tag, "TextRecords", tag.getTextRecords());
		visit(tag.getTextRecords(), visitor);
		visitor.visit("End", tag.getEnd());
	}

	public static void visit(final DefineTextTag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit(tag, "TextBounds", tag.getTextBounds());
		visit(tag.getTextBounds(), visitor);
		visitor.visit(tag, "TextMatrix", tag.getTextMatrix());
		visit(tag.getTextMatrix(), visitor);
		visitor.visit("GlyphBits", tag.getGlyphBits());
		visitor.visit("AdvanceBits", tag.getAdvanceBits());
		visitor.visit(tag, "TextRecords", tag.getTextRecords());
		visit(tag.getTextRecords(), visitor);
		visitor.visit("End", tag.getEnd());
	}

	public static void visit(final DefineVideoStreamTag tag, final ISWFVisitor visitor) {

		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit("NumFrames", tag.getNumFrames());
		visitor.visit("Width", tag.getWidth());
		visitor.visit("Height", tag.getHeight());
		visitor.visit("VideoFlagsReserved", tag.getVideoFlagsReserved());
		visitor.visit("VideoFlagsDeblocking", tag.getVideoFlagsDeblocking());
		visitor.visit("VideoFlagsSmoothing", tag.getVideoFlagsSmoothing());
		visitor.visit("CodecID", tag.getCodecId());
	}

	public static void visit(final DoActionTag tag, final ISWFVisitor visitor) {
		// TODO
	}

	public static void visit(final DoInitActionTag tag, final ISWFVisitor visitor) {

		visitor.visit("SpriteID", tag.getSpriteId());
		// TODO
	}

	public static void visit(final EndShapeRecord shapeRecord, final ISWFVisitor visitor) {

		visitor.visit("TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit("EndOfShape", shapeRecord.getEndOfShape());
	}

	public static void visit(final EndTag tag, final ISWFVisitor visitor) {
		// Nothing to do here.
	}

	public static void visit(final ExportAssetsTag tag, final ISWFVisitor visitor) {

		visitor.visit("Count", tag.getCount());
		visitor.visit(tag, "Tags", tag.getAssets());

		for (final Symbol symbol : tag.getAssets()) {
			visit(symbol, visitor);
		}
	}

	public static void visit(final FileAttributesTag tag, final ISWFVisitor visitor) {

		visitor.visit("Reserved", tag.getReserved());
		visitor.visit("UseDirectBit", tag.getUseDirectBit());
		visitor.visit("UseGPU", tag.getUseGPU());
		visitor.visit("HasMetadata", tag.getHasMetadata());
		visitor.visit("ActionScript3", tag.getActionScript3());
		visitor.visit("Reserved2", tag.getReserved2());
		visitor.visit("UseNetwork", tag.getUseNetwork());
		visitor.visit("Reserved3", tag.getReserved3());
	}

	public static void visit(final FillStyle fillStyle, final ISWFVisitor visitor) {

		visitor.visit("Width", fillStyle.getFillStyleType());
		visitor.visit(fillStyle, "Color", fillStyle.getColor());
		visit(fillStyle.getColor(), visitor);
		visitor.visit(fillStyle, "GradientMatrix", fillStyle.getGradientMatrix());
		visit(fillStyle.getGradientMatrix(), visitor);

		final IGradient gradient = fillStyle.getGradient();

		if (gradient instanceof Gradient) {
			visitor.visit(fillStyle, "Gradient", (Gradient) gradient);
			visit((Gradient) gradient, visitor);
		} else {
			visitor.visit(fillStyle, "Gradient", (FocalGradient) gradient);
			visit((FocalGradient) gradient, visitor);
		}

		visitor.visit("BitmapID", fillStyle.getBitmapId());
		visitor.visit(fillStyle, "BitmapMatrix", fillStyle.getBitmapMatrix());
		visit(fillStyle.getBitmapMatrix(), visitor);
	}

	public static void visit(final FillStyle3 fillStyle, final ISWFVisitor visitor) {

		visitor.visit("Width", fillStyle.getFillStyleType());
		visitor.visit(fillStyle, "Color", fillStyle.getColor());
		visit(fillStyle.getColor(), visitor);
		visitor.visit(fillStyle, "GradientMatrix", fillStyle.getGradientMatrix());
		visit(fillStyle.getGradientMatrix(), visitor);

		final IGradient gradient = fillStyle.getGradient();

		if (gradient instanceof Gradient3) {
			visitor.visit(fillStyle, "Gradient", (Gradient3) gradient);
			visit((Gradient3) gradient, visitor);
		} else {
			visitor.visit(fillStyle, "Gradient", (FocalGradient) gradient);
			visit((FocalGradient) gradient, visitor);
		}

		visitor.visit("BitmapID", fillStyle.getBitmapId());
		visitor.visit(fillStyle, "BitmapMatrix", fillStyle.getBitmapMatrix());
		visit(fillStyle.getBitmapMatrix(), visitor);
	}

	public static void visit(final FillStyle3Array fillStyles, final ISWFVisitor visitor) {

		if (fillStyles != null) {

			visitor.visit("FillStyleCount", fillStyles.getFillStyleCount());
			visitor.visit("FillStyleCountExtended", fillStyles.getFillStyleCountExtended());
			visitor.visit(fillStyles, "FillStyles", fillStyles.getFillStyles());

			visit(fillStyles.getFillStyles(), visitor);
		}
	}

	public static void visit(final FillStyle3List fillStyles, final ISWFVisitor visitor) {
		for (final FillStyle3 fillStyle : fillStyles) {
			visitor.visit(fillStyles, "FillStyle", fillStyle);
			visit(fillStyle, visitor);
		}
	}

	public static void visit(final FillStyleArray fillStyles, final ISWFVisitor visitor) {

		if (fillStyles != null) {

			visitor.visit("FillStyleCount", fillStyles.getFillStyleCount());
			visitor.visit("FillStyleCountExtended", fillStyles.getFillStyleCountExtended());
			visitor.visit(fillStyles, "FillStyles", fillStyles.getFillStyles());

			visit(fillStyles.getFillStyles(), visitor);
		}
	}

	public static void visit(final FillStyleList fillStyles, final ISWFVisitor visitor) {
		for (final FillStyle fillStyle : fillStyles) {
			visitor.visit(fillStyles, "FillStyle", fillStyle);
			visit(fillStyle, visitor);
		}
	}

	public static void visit(final FocalGradient gradient, final ISWFVisitor visitor) {

		if (gradient != null) {

			visitor.visit("SpreadMode", gradient.getSpreadMode());
			visitor.visit("InterpolationMode", gradient.getInterpolationMode());
			visitor.visit("NumGradients", gradient.getNumGradients());
			visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
			visit(gradient.getGradientRecords(), visitor);
			visitor.visit("FocalPoint", gradient.getFocalPoint());
		}
	}

	public static void visit(final FrameLabelTag tag, final ISWFVisitor visitor) {

		visitor.visit("Name", tag.getName());
		visitor.visit("AnchorFlag", tag.getNamedAnchorFlag());
	}

	public static void visit(final Gradient gradient, final ISWFVisitor visitor) {

		visitor.visit("SpreadMode", gradient.getSpreadMode());
		visitor.visit("InterpolationMode", gradient.getInterpolationMode());
		visitor.visit("NumGradients", gradient.getNumGradients());
		visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
		visit(gradient.getGradientRecords(), visitor);
	}

	public static void visit(final Gradient3 gradient, final ISWFVisitor visitor) {

		visitor.visit("SpreadMode", gradient.getSpreadMode());
		visitor.visit("InterpolationMode", gradient.getInterpolationMode());
		visitor.visit("NumGradients", gradient.getNumGradients());
		visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
		visit(gradient.getGradientRecords(), visitor);
	}

	public static void visit(final GradRecord gradRecord, final ISWFVisitor visitor) {

		visitor.visit("Ratio", gradRecord.getRatio());
		visitor.visit(gradRecord, "Color", gradRecord.getColor());
		visit(gradRecord.getColor(), visitor);
	}

	public static void visit(final GradRecord3 gradRecord, final ISWFVisitor visitor) {

		visitor.visit("Ratio", gradRecord.getRatio());
		visitor.visit(gradRecord, "Color", gradRecord.getColor());
		visit(gradRecord.getColor(), visitor);
	}

	public static void visit(final GradRecord3List gradientRecords, final ISWFVisitor visitor) {

		for (final GradRecord3 gradRecord : gradientRecords) {
			visitor.visit(gradientRecords, "GradRecord", gradRecord);
			visit(gradRecord, visitor);
		}
	}

	public static void visit(final GradRecordList gradientRecords, final ISWFVisitor visitor) {

		for (final GradRecord gradRecord : gradientRecords) {
			visitor.visit(gradientRecords, "GradRecord", gradRecord);
			visit(gradRecord, visitor);
		}
	}

	public static void visit(final JPEGTablesTag tag, final ISWFVisitor visitor) {

		visitor.visit("JPEGData", tag.getJpegData());
	}

	public static void visit(final KerningRecord kerningRecord, final ISWFVisitor visitor) {

		final IParsedINTElement kerningCode1 = kerningRecord.getFontKerningCode1();

		if (kerningCode1 instanceof UINT16) {
			visitor.visit("FontKerningCode1", (UINT16) kerningCode1);
		}
		else  {
			visitor.visit("FontKerningCode1", (UINT32) kerningCode1);
		}

		final IParsedINTElement kerningCode2 = kerningRecord.getFontKerningCode1();

		if (kerningCode1 instanceof UINT16) {
			visitor.visit("FontKerningCode2", (UINT16) kerningCode2);
		}
		else  {
			visitor.visit("FontKerningCode2", (UINT32) kerningCode2);
		}

		visitor.visit("FontKerningAdjustment", kerningRecord.getFontKerningAdjustment());
	}

	public static void visit(final KerningRecordList list, final ISWFVisitor visitor) {
		for (final KerningRecord kerningRecord : list) {
			visitor.visit(list, "KerningRecord", kerningRecord);
			visit(kerningRecord, visitor);
		}
	}

	public static void visit(final LineStyle lineStyle, final ISWFVisitor visitor) {

		visitor.visit("Width", lineStyle.getWidth());
		visitor.visit(lineStyle, "Color", lineStyle.getColor());
		visit(lineStyle.getColor(), visitor);
	}

	public static void visit(final LineStyle3 lineStyle, final ISWFVisitor visitor) {

		visitor.visit("Width", lineStyle.getWidth());
		visitor.visit(lineStyle, "Color", lineStyle.getColor());
		visit(lineStyle.getColor(), visitor);
	}

	public static void visit(final LineStyle3Array lineStyles, final ISWFVisitor visitor) {

		if (lineStyles != null) {

			visitor.visit("LineStyleCount", lineStyles.getLineStyleCount());
			visitor.visit("LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
			visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

			visit(lineStyles.getLineStyles(), visitor);
		}
	}

	public static void visit(final LineStyle3List lineStyles, final ISWFVisitor visitor) {
		for (final LineStyle3 lineStyle : lineStyles) {
			visitor.visit(lineStyles, "LineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	public static void visit(final LineStyle4 lineStyle, final ISWFVisitor visitor) {

		visitor.visit("Width", lineStyle.getWidth());
		visitor.visit(lineStyle, "Color", lineStyle.getColor());
		visit(lineStyle.getColor(), visitor);
	}

	public static void visit(final LineStyle4Array lineStyles, final ISWFVisitor visitor) {

		visitor.visit("LineStyleCount", lineStyles.getLineStyleCount());
		visitor.visit("LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
		visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

		visit(lineStyles.getLineStyles(), visitor);
	}

	public static void visit(final LineStyle4List lineStyles, final ISWFVisitor visitor) {
		for (final LineStyle4 lineStyle : lineStyles) {
			visitor.visit(lineStyles, "LineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	public static void visit(final LineStyleArray lineStyles, final ISWFVisitor visitor) {

		if (lineStyles != null) {

			visitor.visit("LineStyleCount", lineStyles.getLineStyleCount());
			visitor.visit("LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
			visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

			visit(lineStyles.getLineStyles(), visitor);
		}
	}

	public static void visit(final LineStyleList lineStyles, final ISWFVisitor visitor) {
		for (final LineStyle lineStyle : lineStyles) {
			visitor.visit(lineStyles, "LineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	public static void visit(final Matrix matrix, final ISWFVisitor visitor) {

		if (matrix != null) {
			visitor.visit("HasScale", matrix.getHasScale());
			visitor.visit("NScaleBits", matrix.getnScaleBits());
			visitor.visit("ScaleX", matrix.getScaleX());
			visitor.visit("ScaleY", matrix.getScaleY());
			visitor.visit("HasRotate", matrix.getHasRotate());
			visitor.visit("NRotateBits", matrix.getnRotateBits());
			visitor.visit("RotateSkew0", matrix.getRotateSkew0());
			visitor.visit("RotateSkew1", matrix.getRotateSkew1());
			visitor.visit("NTranslateBits", matrix.getnTranslateBits());
			visitor.visit("TranslateX", matrix.getTranslateX());
			visitor.visit("TranslateY", matrix.getTranslateY());
		}
	}

	public static void visit(final MetadataTag tag, final ISWFVisitor visitor) {

		visitor.visit("Metadata", tag.getMetadata());
	}

	public static void visit(final MorphFillStyle fillStyle, final ISWFVisitor visitor) {

		visitor.visit("Width", fillStyle.getFillStyleType());
		visitor.visit(fillStyle, "StartColor", fillStyle.getStartColor());
		visit(fillStyle.getStartColor(), visitor);
		visitor.visit(fillStyle, "StartColor", fillStyle.getEndColor());
		visit(fillStyle.getEndColor(), visitor);
		visitor.visit(fillStyle, "StartGradientMatrix", fillStyle.getStartGradientMatrix());
		visit(fillStyle.getStartGradientMatrix(), visitor);
		visitor.visit(fillStyle, "EndGradientMatrix", fillStyle.getEndGradientMatrix());
		visit(fillStyle.getEndGradientMatrix(), visitor);
		visitor.visit(fillStyle, "Gradient", fillStyle.getGradient());
		visit(fillStyle.getGradient(), visitor);
		visitor.visit("BitmapID", fillStyle.getBitmapId());
		visitor.visit(fillStyle, "StartBitmapMatrix", fillStyle.getStartBitmapMatrix());
		visit(fillStyle.getStartBitmapMatrix(), visitor);
		visitor.visit(fillStyle, "EndBitmapMatrix", fillStyle.getEndBitmapMatrix());
		visit(fillStyle.getEndBitmapMatrix(), visitor);
	}

	public static void visit(final MorphFillStyleArray fillStyles, final ISWFVisitor visitor) {

		visitor.visit("FillStyleCount", fillStyles.getFillStyleCount());
		visitor.visit("FillStyleCountExtended", fillStyles.getFillStyleCountExtended());
		visitor.visit(fillStyles, "FillStyles", fillStyles.getFillStyles());

		visit(fillStyles.getFillStyles(), visitor);
	}

	public static void visit(final MorphFillStyleList fillStyles, final ISWFVisitor visitor) {
		for (final MorphFillStyle fillStyle : fillStyles) {
			visitor.visit(fillStyles, "MorphFillStyle", fillStyle);
			visit(fillStyle, visitor);
		}
	}

	public static void visit(final MorphLineStyle lineStyle, final ISWFVisitor visitor) {

		visitor.visit("StartWidth", lineStyle.getStartWidth());
		visitor.visit("EndWidth", lineStyle.getEndWidth());
		visitor.visit(lineStyle, "StartColor", lineStyle.getStartColor());
		visit(lineStyle.getStartColor(), visitor);
		visitor.visit(lineStyle, "EndColor", lineStyle.getEndColor());
		visit(lineStyle.getEndColor(), visitor);
	}

	public static void visit(final MorphLineStyleArray lineStyles, final ISWFVisitor visitor) {

		if (lineStyles != null) {

			visitor.visit("LineStyleCount", lineStyles.getLineStyleCount());
			visitor.visit("LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
			visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

			visit(lineStyles.getLineStyles(), visitor);
		}
	}

	public static void visit(final MorphLineStyleList lineStyles, final ISWFVisitor visitor) {
		for (final MorphLineStyle lineStyle : lineStyles) {
			visitor.visit(lineStyles, "MorphLineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	public static void visit(final ParsedINTElementList offsetTable, final ISWFVisitor visitor) {
		for (final IParsedINTElement element : offsetTable) {

			if (element instanceof UINT8) {
				visitor.visit("Element", (UINT8) element);
			}
			else if (element instanceof UINT16) {
				visitor.visit("Element", (UINT16) element);
			}
			else if (element instanceof UINT32) {
				visitor.visit("Element", (UINT32) element);
			}
			else if (element instanceof INT32) {
				visitor.visit("Element", (INT32) element);
			}
		}
	}

	public static void visit(final PlaceObject2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("PlaceFlagHasClipAction", tag.getPlaceFlagHasClipActions());
		visitor.visit("PlaceFlagHasClipDepth", tag.getPlaceFlagHasClipDepth());
		visitor.visit("PlaceFlagHasName", tag.getPlaceFlagHasName());
		visitor.visit("PlaceFlagHasRatio", tag.getPlaceFlagHasRatio());
		visitor.visit("PlaceFlagHasColorTransform", tag.getPlaceFlagHasColorTransform());
		visitor.visit("PlaceFlagHasMatrix", tag.getPlaceFlagHasMatrix());
		visitor.visit("PlaceFlagHasCharacter", tag.getPlaceFlagHasCharacter());
		visitor.visit("PlaceFlagHasMove", tag.getPlaceFlagHasMove());
		visitor.visit("Depth", tag.getDepth());
		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Matrix", tag.getMatrix());
		visit(tag.getMatrix(), visitor);
		visitor.visit(tag, "ColorTransform", tag.getColorTransform());
		visit(tag.getColorTransform(), visitor);
		visitor.visit("Ratio", tag.getRatio());
		visitor.visit("Name", tag.getName());
		visitor.visit("ClipDepth", tag.getClipDepth());
		visitor.visit(tag, "ClipActions", tag.getClipActions());
		visit(tag.getClipActions(), visitor);
	}

	public static void visit(final PlaceObject3Tag tag, final ISWFVisitor visitor) {

		visitor.visit("PlaceFlagHasClipAction", tag.getPlaceFlagHasClipActions());
		visitor.visit("PlaceFlagHasClipDepth", tag.getPlaceFlagHasClipDepth());
		visitor.visit("PlaceFlagHasName", tag.getPlaceFlagHasName());
		visitor.visit("PlaceFlagHasRatio", tag.getPlaceFlagHasRatio());
		visitor.visit("PlaceFlagHasColorTransform", tag.getPlaceFlagHasColorTransform());
		visitor.visit("PlaceFlagHasMatrix", tag.getPlaceFlagHasMatrix());
		visitor.visit("PlaceFlagHasCharacter", tag.getPlaceFlagHasCharacter());
		visitor.visit("PlaceFlagHasMove", tag.getPlaceFlagHasMove());
		visitor.visit("Reserved", tag.getReserved());
		visitor.visit("PlaceFlagHasImage", tag.getPlaceFlagHasImage());
		visitor.visit("PlaceFlagHasClassName", tag.getPlaceFlagHasClassName());
		visitor.visit("PlaceFlagHasCacheAsBitmap", tag.getPlaceFlagHasCacheAsBitmap());
		visitor.visit("PlaceFlagHasBlendMode", tag.getPlaceFlagHasBlendMode());
		visitor.visit("PlaceFlagHasFilterList", tag.getPlaceFlagHasFilterList());
		visitor.visit("Depth", tag.getDepth());
		visitor.visit("ClassName", tag.getClassName());
		visitor.visit("CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Matrix", tag.getMatrix());
		visit(tag.getMatrix(), visitor);
		visitor.visit(tag, "ColorTransform", tag.getColorTransform());
		visit(tag.getColorTransform(), visitor);
		visitor.visit("Ratio", tag.getRatio());
		visitor.visit("Name", tag.getName());
		visitor.visit("ClipDepth", tag.getClipDepth());
		visitor.visit(tag, "SurfaceFilterList", tag.getSurfaceFilterList());
		visit(tag.getSurfaceFilterList(), visitor);
		visitor.visit("BlendMode", tag.getBlendMode());
		visitor.visit("BitmapCache", tag.getBitmapCache());
		visitor.visit(tag, "ClipActions", tag.getClipActions());
		visit(tag.getClipActions(), visitor);
	}

	public static void visit(final ProtectTag tag, final ISWFVisitor visitor) {

		visitor.visit("Data", tag.getData());
	}

	public static void visit(final Rect rect, final ISWFVisitor visitor) {

		visitor.visit("NBits", rect.getnBits());
		visitor.visit("XMin", rect.getxMin());
		visitor.visit("XMax", rect.getxMax());
		visitor.visit("YMin", rect.getyMin());
		visitor.visit("YMax", rect.getyMax());
	}

	public static void visit(final RemoveObject2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("Dept", tag.getDepth());
	}

	public static void visit(final RGB value, final ISWFVisitor visitor) {

		if (value != null) {
			visitor.visit("Red", value.getRed());
			visitor.visit("Green", value.getGreen());
			visitor.visit("Blue", value.getBlue());
		}
	}

	public static void visit(final RGBA value, final ISWFVisitor visitor) {

		if (value != null) {
			visitor.visit("Red", value.getRed());
			visitor.visit("Green", value.getGreen());
			visitor.visit("Blue", value.getBlue());
			visitor.visit("Alpha", value.getAlpha());
		}
	}

	public static void visit(final SetBackgroundColorTag tag, final ISWFVisitor visitor) {

		visitor.visit(tag, "BackgroundColor", tag.getBackgroundColor());

		visit(tag.getBackgroundColor(), visitor);
	}

	public static void visit(final Shape3List shapeList, final ISWFVisitor visitor) {
		for (final Shape3 shape3 : shapeList) {
			visitor.visit(shapeList, "Element", shape3);
			visit(shape3, visitor);
		}
	}

	public static void visit(final ShapeList shapeList, final ISWFVisitor visitor) {
		for (final Shape shape : shapeList) {
			visitor.visit(shapeList, "Element", shape);
			visit(shape, visitor);
		}
	}

	public static void visit(final ShapeWithStyle shapes, final ISWFVisitor visitor) {
		visitor.visit(shapes, "FillStyles", shapes.getFillStyles());
		visit(shapes.getFillStyles(), visitor);
		visitor.visit(shapes, "LineStyles", shapes.getLineStyles());
		visit(shapes.getLineStyles(), visitor);
		visitor.visit("NumFillBits", shapes.getNumFillBits());
		visitor.visit("NumLineBits", shapes.getNumLineBits());

		final ShapeRecord shapeRecord = shapes.getShapeRecord();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			visitor.visit(shapes, "ShapeRecord", (CurvedEdgeRecord) shapeRecord);
			visit((CurvedEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			visitor.visit(shapes, "ShapeRecord", (EndShapeRecord) shapeRecord);
			visit((EndShapeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			visitor.visit(shapes, "ShapeRecord", (StraightEdgeRecord) shapeRecord);
			visit((StraightEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StyleChangeRecord) {
			visitor.visit(shapes, "ShapeRecord", (StyleChangeRecord) shapeRecord);
			visit((StyleChangeRecord) shapeRecord, visitor);
		}
	}

	public static void visit(final ShapeWithStyle3 shapes, final ISWFVisitor visitor) {
		visitor.visit(shapes, "FillStyles", shapes.getFillStyles());
		visit(shapes.getFillStyles(), visitor);
		visitor.visit(shapes, "LineStyles", shapes.getLineStyles());
		visit(shapes.getLineStyles(), visitor);
		visitor.visit("NumFillBits", shapes.getNumFillBits());
		visitor.visit("NumLineBits", shapes.getNumLineBits());

		final Shape3Record shapeRecord = shapes.getShapeRecord();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			visitor.visit(shapes, "ShapeRecord", (CurvedEdgeRecord) shapeRecord);
			visit((CurvedEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			visitor.visit(shapes, "ShapeRecord", (EndShapeRecord) shapeRecord);
			visit((EndShapeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			visitor.visit(shapes, "ShapeRecord", (StraightEdgeRecord) shapeRecord);
			visit((StraightEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StyleChangeRecord3) {
			visitor.visit(shapes, "ShapeRecord", (StyleChangeRecord3) shapeRecord);
			visit((StyleChangeRecord3) shapeRecord, visitor);
		}
	}

	public static void visit(final ShowFrameTag tag, final ISWFVisitor visitor) {

	}

	public static void visit(final SoundInfo soundInfo, final ISWFVisitor visitor) {

		visitor.visit("Reserved", soundInfo.getReserved());
		visitor.visit("SyncStop", soundInfo.getSyncStop());
		visitor.visit("SyncNoMultiple", soundInfo.getSyncNoMultiple());
		visitor.visit("HasEnvelope", soundInfo.getHasEnvelope());
		visitor.visit("HasLoops", soundInfo.getHasLoops());
		visitor.visit("HasOutPoint", soundInfo.getHasOutPoint());
		visitor.visit("HasInPoint", soundInfo.getHasInPoint());
		visitor.visit("OutPoint", soundInfo.getOutPoint());
		visitor.visit("InPoint", soundInfo.getInPoint());
		visitor.visit("LoopCount", soundInfo.getLoopCount());
		visitor.visit("EnvPoints", soundInfo.getEnvPoints());
		visitor.visit(soundInfo, "EnvelopeRecords", soundInfo.getEnvelopeRecords());
		visit(soundInfo.getEnvelopeRecords(), visitor);
	}

	public static void visit(final SoundStreamBlockTag tag, final ISWFVisitor visitor) {

		visitor.visit("StreamSoundData", tag.getStreamSoundData());
	}

	public static void visit(final SoundStreamHead2Tag tag, final ISWFVisitor visitor) {

		visitor.visit("Reserved", tag.getReserved());
		visitor.visit("PlaybackSoundRate", tag.getPlaybackSoundRate());
		visitor.visit("PlaybackSoundSize", tag.getPlaybackSoundSize());
		visitor.visit("PlaybackSoundType", tag.getPlaybackSoundType());
		visitor.visit("StreamSoundCompression", tag.getStreamSoundCompression());
		visitor.visit("StreamSoundRate", tag.getStreamSoundRate());
		visitor.visit("StreamSoundSize", tag.getStreamSoundSize());
		visitor.visit("StreamSoundType", tag.getStreamSoundType());
		visitor.visit("StreamSoundSampleCount", tag.getStreamSoundSampleCount());
		visitor.visit("LatencySeek", tag.getLatencySeek());
	}

	public static void visit(final SoundStreamHeadTag tag, final ISWFVisitor visitor) {

		visitor.visit("Reserved", tag.getReserved());
		visitor.visit("PlaybackSoundRate", tag.getPlaybackSoundRate());
		visitor.visit("PlaybackSoundSize", tag.getPlaybackSoundSize());
		visitor.visit("PlaybackSoundType", tag.getPlaybackSoundType());
		visitor.visit("StreamSoundCompression", tag.getStreamSoundCompression());
		visitor.visit("StreamSoundRate", tag.getStreamSoundRate());
		visitor.visit("StreamSoundSize", tag.getStreamSoundSize());
		visitor.visit("StreamSoundType", tag.getStreamSoundType());
		visitor.visit("StreamSoundSampleCount", tag.getStreamSoundSampleCount());
		visitor.visit("LatencySeek", tag.getLatencySeek());
	}

	public static void visit(final StartSoundTag tag, final ISWFVisitor visitor) {

		visitor.visit("SoundID", tag.getSoundId());
		visitor.visit(tag, "SoundFormat", tag.getSoundInfo());
		visit(tag.getSoundInfo(), visitor);
	}

	public static void visit(final StraightEdgeRecord shapeRecord, final ISWFVisitor visitor) {
		visitor.visit("TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit("StraightFlag", shapeRecord.getStraightFlag());
		visitor.visit("NumBits", shapeRecord.getNumBits());
		visitor.visit("GeneralLineFlag", shapeRecord.getGeneralLineFlag());
		visitor.visit("VertLineFlag", shapeRecord.getVertLineFlag());
		visitor.visit("DeltaX", shapeRecord.getDeltaX());
		visitor.visit("DeltaY", shapeRecord.getDeltaY());
	}

	public static void visit(final StyleChangeRecord shapeRecord, final ISWFVisitor visitor) {
		visitor.visit("TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit("StateNewStyles", shapeRecord.getStateNewStyles());
		visitor.visit("StateLineStyle", shapeRecord.getStateLineStyle());
		visitor.visit("StateFillStyle1", shapeRecord.getStateFillStyle1());
		visitor.visit("StateFillStyle0", shapeRecord.getStateFillStyle0());
		visitor.visit("StateMoveTo", shapeRecord.getStateMoveTo());
		visitor.visit("MoveBits", shapeRecord.getMoveBits());
		visitor.visit("MoveDeltaX", shapeRecord.getMoveDeltaX());
		visitor.visit("MoveDeltaY", shapeRecord.getMoveDeltaY());
		visitor.visit("FillStyle0", shapeRecord.getFillStyle0());
		visitor.visit("FillStyle1", shapeRecord.getFillStyle1());
		visitor.visit("LineStyle", shapeRecord.getLineStyle());
		visitor.visit(shapeRecord, "FillStyles", shapeRecord.getFillStyles());
		visit(shapeRecord.getFillStyles(), visitor);
		visitor.visit(shapeRecord, "LineStyles", shapeRecord.getLineStyles());
		visit(shapeRecord.getLineStyles(), visitor);
		visitor.visit("NumFillBits", shapeRecord.getNumFillBits());
		visitor.visit("NumLineBits", shapeRecord.getNumLineBits());
	}

	public static void visit(final StyleChangeRecord3 shapeRecord, final ISWFVisitor visitor) {
		visitor.visit("TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit("StateNewStyles", shapeRecord.getStateNewStyles());
		visitor.visit("StateLineStyle", shapeRecord.getStateLineStyle());
		visitor.visit("StateFillStyle1", shapeRecord.getStateFillStyle1());
		visitor.visit("StateFillStyle0", shapeRecord.getStateFillStyle0());
		visitor.visit("StateMoveTo", shapeRecord.getStateMoveTo());
		visitor.visit("MoveBits", shapeRecord.getMoveBits());
		visitor.visit("MoveDeltaX", shapeRecord.getMoveDeltaX());
		visitor.visit("MoveDeltaY", shapeRecord.getMoveDeltaY());
		visitor.visit("FillStyle0", shapeRecord.getFillStyle0());
		visitor.visit("FillStyle1", shapeRecord.getFillStyle1());
		visitor.visit("LineStyle", shapeRecord.getLineStyle());
		visitor.visit(shapeRecord, "FillStyles", shapeRecord.getFillStyles());
		visit(shapeRecord.getFillStyles(), visitor);
		visitor.visit(shapeRecord, "LineStyles", shapeRecord.getLineStyles());
		visit(shapeRecord.getLineStyles(), visitor);
		visitor.visit("NumFillBits", shapeRecord.getNumFillBits());
		visitor.visit("NumLineBits", shapeRecord.getNumLineBits());
	}

	public static void visit(final StyleChangeRecord4 shapeRecord, final ISWFVisitor visitor) {
		visitor.visit("TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit("StateNewStyles", shapeRecord.getStateNewStyles());
		visitor.visit("StateLineStyle", shapeRecord.getStateLineStyle());
		visitor.visit("StateFillStyle1", shapeRecord.getStateFillStyle1());
		visitor.visit("StateFillStyle0", shapeRecord.getStateFillStyle0());
		visitor.visit("StateMoveTo", shapeRecord.getStateMoveTo());
		visitor.visit("MoveBits", shapeRecord.getMoveBits());
		visitor.visit("MoveDeltaX", shapeRecord.getMoveDeltaX());
		visitor.visit("MoveDeltaY", shapeRecord.getMoveDeltaY());
		visitor.visit("FillStyle0", shapeRecord.getFillStyle0());
		visitor.visit("FillStyle1", shapeRecord.getFillStyle1());
		visitor.visit("LineStyle", shapeRecord.getLineStyle());
		visitor.visit(shapeRecord, "FillStyles", shapeRecord.getFillStyles());
		visit(shapeRecord.getFillStyles(), visitor);
		visitor.visit(shapeRecord, "LineStyles", shapeRecord.getLineStyles());
		visit(shapeRecord.getLineStyles(), visitor);
		visitor.visit("NumFillBits", shapeRecord.getNumFillBits());
		visitor.visit("NumLineBits", shapeRecord.getNumLineBits());
	}

	public static void visit(final SWFFile file, final ISWFVisitor visitor) {

		visitor.visit(file);

		for (final Tag tag : file.getTags()) {
			visitor.visit(file, tag);

			visit(tag, visitor);
		}
	}

	public static void visit(final Symbol symbol, final ISWFVisitor visitor) {

		visitor.visit("Tag", symbol.getTag());
		visitor.visit("Name", symbol.getName());
	}

	public static void visit(final Tag tag, final ISWFVisitor visitor) {
		if (tag instanceof FileAttributesTag) {
			visit((FileAttributesTag) tag, visitor);
		}
		else if (tag instanceof MetadataTag) {
			visit((MetadataTag) tag, visitor);
		}
		else if (tag instanceof SetBackgroundColorTag) {
			visit((SetBackgroundColorTag) tag, visitor);
		}
		else if (tag instanceof DefineSpriteTag) {
			visit((DefineSpriteTag) tag, visitor);
		}
		else if (tag instanceof DoActionTag) {
			visit((DoActionTag) tag, visitor);
		}
		else if (tag instanceof FrameLabelTag) {
			visit((FrameLabelTag) tag, visitor);
		}
		else if (tag instanceof ShowFrameTag) {
			visit((ShowFrameTag) tag, visitor);
		}
		else if (tag instanceof EndTag) {
			visit((EndTag) tag, visitor);
		}
		else if (tag instanceof ExportAssetsTag) {
			visit((ExportAssetsTag) tag, visitor);
		}
		else if (tag instanceof DefineShapeTag) {
			visit((DefineShapeTag) tag, visitor);
		}
		else if (tag instanceof DefineShape2Tag) {
			visit((DefineShape2Tag) tag, visitor);
		}
		else if (tag instanceof DefineShape3Tag) {
			visit((DefineShape3Tag) tag, visitor);
		}
		else if (tag instanceof DefineShape4Tag) {
			visit((DefineShape4Tag) tag, visitor);
		}
		else if (tag instanceof PlaceObject2Tag) {
			visit((PlaceObject2Tag) tag, visitor);
		}
		else if (tag instanceof PlaceObject3Tag) {
			visit((PlaceObject3Tag) tag, visitor);
		}
		else if (tag instanceof RemoveObject2Tag) {
			visit((RemoveObject2Tag) tag, visitor);
		}
		else if (tag instanceof DefineFontTag) {
			visit((DefineFontTag) tag, visitor);
		}
		else if (tag instanceof DefineFont2Tag) {
			visit((DefineFont2Tag) tag, visitor);
		}
		else if (tag instanceof DefineFont3Tag) {
			visit((DefineFont3Tag) tag, visitor);
		}
		else if (tag instanceof DefineFontAlignZonesTag) {
			visit((DefineFontAlignZonesTag) tag, visitor);
		}
		else if (tag instanceof DefineEditTextTag) {
			visit((DefineEditTextTag) tag, visitor);
		}
		else if (tag instanceof DefineVideoStreamTag) {
			visit((DefineVideoStreamTag) tag, visitor);
		}
		else if (tag instanceof DefineFontNameTag) {
			visit((DefineFontNameTag) tag, visitor);
		}
		else if (tag instanceof DefineTextTag) {
			visit((DefineTextTag) tag, visitor);
		}
		else if (tag instanceof DefineText2Tag) {
			visit((DefineText2Tag) tag, visitor);
		}
		else if (tag instanceof DoInitActionTag) {
			visit((DoInitActionTag) tag, visitor);
		}
		else if (tag instanceof CSMTextSettingsTag) {
			visit((CSMTextSettingsTag) tag, visitor);
		}
		else if (tag instanceof DefineFontInfoTag) {
			visit((DefineFontInfoTag) tag, visitor);
		}
		else if (tag instanceof DefineFontInfo2Tag) {
			visit((DefineFontInfo2Tag) tag, visitor);
		}
		else if (tag instanceof DefineBitsLosslessTag) {
			visit((DefineBitsLosslessTag) tag, visitor);
		}
		else if (tag instanceof DefineBitsLossless2Tag) {
			visit((DefineBitsLossless2Tag) tag, visitor);
		}
		else if (tag instanceof DefineButton2Tag) {
			visit((DefineButton2Tag) tag, visitor);
		}
		else if (tag instanceof JPEGTablesTag) {
			visit((JPEGTablesTag) tag, visitor);
		}
		else if (tag instanceof DefineBitsTag) {
			visit((DefineBitsTag) tag, visitor);
		}
		else if (tag instanceof DefineBitsJPEG2Tag) {
			visit((DefineBitsJPEG2Tag) tag, visitor);
		}
		else if (tag instanceof DefineBitsJPEG3Tag) {
			visit((DefineBitsJPEG3Tag) tag, visitor);
		}
		else if (tag instanceof ProtectTag) {
			visit((ProtectTag) tag, visitor);
		}
		else if (tag instanceof SoundStreamHeadTag) {
			visit((SoundStreamHeadTag) tag, visitor);
		}
		else if (tag instanceof SoundStreamHead2Tag) {
			visit((SoundStreamHead2Tag) tag, visitor);
		}
		else if (tag instanceof DefineMorphShapeTag) {
			visit((DefineMorphShapeTag) tag, visitor);
		}
		else if (tag instanceof DefineSoundTag) {
			visit((DefineSoundTag) tag, visitor);
		}
		else if (tag instanceof StartSoundTag) {
			visit((StartSoundTag) tag, visitor);
		}
		else if (tag instanceof SoundStreamBlockTag) {
			visit((SoundStreamBlockTag) tag, visitor);
		}
		else {
			System.out.println(tag);
			System.exit(0);
		}
	}

	public static void visit(final TagList tags, final ISWFVisitor visitor) {
		for (final Tag tag : tags) {
			visitor.visit(tags, tag);

			visit(tag, visitor);
		}
	}

	public static void visit(final ZoneData zoneData, final ISWFVisitor visitor) {

		visitor.visit("AlignmentCoordinate", zoneData.getAlignmentCoordinate());
		visitor.visit("Range", zoneData.getRange());
	}

	public static void visit(final ZoneDataList zoneDataList, final ISWFVisitor visitor) {

		for (final ZoneData zoneData : zoneDataList) {

			visitor.visit(zoneDataList, "ZoneData", zoneData);
			visit(zoneData, visitor);
		}
	}

	public static void visit(final ZoneRecordList zoneRecordList, final ISWFVisitor visitor) {

		for (final ZoneRecord zoneRecord : zoneRecordList) {

			visitor.visit(zoneRecordList, "ZoneRecord", zoneRecord);
			visit(zoneRecord, visitor);
		}
	}
}