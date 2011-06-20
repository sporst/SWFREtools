package tv.porst.swfretools.utils;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.*;
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
import tv.porst.swfretools.parser.tags.ProtectTag;
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

/**
 * Class that iterates over all elements of a SWF file.
 */
public final class SWFIterator {

	/**
	 * Visits an ActionList object.
	 * 
	 * @param actions The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ActionList actions, final ISWFVisitor visitor) {

		if (actions == null) {
			return;
		}

		for (final Action action : actions) {
			visitor.visit(actions, "Action", action);
		}
	}

	/**
	 * Visits a BevelFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final BevelFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "ShadowColor", filter.getShadowColor());
		visitor.visit(filter, "HightlightColor", filter.getHighlightColor());
		visitor.visit(filter, "BlurX", filter.getBlurX());
		visitor.visit(filter, "BlurY", filter.getBlurY());
		visitor.visit(filter, "Angle", filter.getAngle());
		visitor.visit(filter, "Distance", filter.getDistance());
		visitor.visit(filter, "Strength", filter.getStrength());
		visitor.visit(filter, "InnerShadow", filter.getInnerShadow());
		visitor.visit(filter, "Knockout", filter.getKnockout());
		visitor.visit(filter, "CompositeSource", filter.getCompositeSource());
		visitor.visit(filter, "OnTop", filter.getOnTop());
		visitor.visit(filter, "Passes", filter.getPasses());
	}

	/**
	 * Visits a BlurFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final BlurFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "BlurX", filter.getBlurX());
		visitor.visit(filter, "BlurY", filter.getBlurY());
		visitor.visit(filter, "Passes", filter.getPasses());
		visitor.visit(filter, "Reserved", filter.getReserved());
	}

	/**
	 * Visits a ButtonCondAction object.
	 * 
	 * @param action The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ButtonCondAction action, final ISWFVisitor visitor) {

		if (action == null) {
			return;
		}

		visitor.visit(action, "CondActionSize", action.getCondActionSize());
		visitor.visit(action, "CondIdleToOverDown", action.getCondIdleToOverDown());
		visitor.visit(action, "CondOutDownToIdle", action.getCondOutDownToIdle());
		visitor.visit(action, "CondOutDownToOverDown", action.getCondOutDownToOverDown());
		visitor.visit(action, "CondOverDownToOutDown", action.getCondOverDownToOutDown());
		visitor.visit(action, "CondOverDownToOverUp", action.getCondOverDownToOverUp());
		visitor.visit(action, "CondOverUpToOverDown", action.getCondOverUpToOverDown());
		visitor.visit(action, "CondOverUpToIdle", action.getCondOverUpToIdle());
		visitor.visit(action, "CondIdleToOverUp", action.getCondIdleToOverUp());
		visitor.visit(action, "CondKeyPress", action.getCondKeyPress());
		visitor.visit(action, "CondOverDownToIdle", action.getCondOverDownToIdle());
		visitor.visit(action, "Actions", action.getActions());
		visit(action.getActions(), visitor);
		visitor.visit(action, "ActionEndFlag", action.getActionEndFlag());
	}

	/**
	 * Visits a ButtonCondActionList object.
	 * 
	 * @param actions The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ButtonCondActionList actions, final ISWFVisitor visitor) {

		if (actions == null) {
			return;
		}

		for (final ButtonCondAction action : actions) {
			visitor.visit(actions, "Action", action);
			visit(action, visitor);
		}
	}

	/**
	 * Visits a ButtonRecord object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ButtonRecord record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "ButtonReserved", record.getButtonReserved());
		visitor.visit(record, "ButtonHasBlendMode", record.getButtonHasBlendMode());
		visitor.visit(record, "ButtonHasFilterList", record.getButtonHasFilterList());
		visitor.visit(record, "ButtonStateHitTest", record.getButtonStateHitTest());
		visitor.visit(record, "ButtonStateDown", record.getButtonStateDown());
		visitor.visit(record, "ButtonStateOver", record.getButtonStateOver());
		visitor.visit(record, "ButtonStateUp", record.getButtonStateUp());
		visitor.visit(record, "CharacterID", record.getCharacterId());
		visitor.visit(record, "PlaceDepth", record.getPlaceDepth());
		visitor.visit(record, "PlaceMatrix", record.getPlaceMatrix());
		visit(record.getPlaceMatrix(), visitor);
	}

	/**
	 * Visits a ButtonRecord2 object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ButtonRecord2 record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "ButtonReserved", record.getButtonReserved());
		visitor.visit(record, "ButtonHasBlendMode", record.getButtonHasBlendMode());
		visitor.visit(record, "ButtonHasFilterList", record.getButtonHasFilterList());
		visitor.visit(record, "ButtonStateHitTest", record.getButtonStateHitTest());
		visitor.visit(record, "ButtonStateDown", record.getButtonStateDown());
		visitor.visit(record, "ButtonStateOver", record.getButtonStateOver());
		visitor.visit(record, "ButtonStateUp", record.getButtonStateUp());
		visitor.visit(record, "CharacterID", record.getCharacterId());
		visitor.visit(record, "PlaceDepth", record.getPlaceDepth());
		visitor.visit(record, "PlaceMatrix", record.getPlaceMatrix());
		visit(record.getPlaceMatrix(), visitor);
		visitor.visit(record, "ColorTransform", record.getColorTransform());
		visit(record.getColorTransform(), visitor);
		visitor.visit(record, "FilterList", record.getFilterList());
		visit(record.getFilterList(), visitor);
		visitor.visit(record, "BlendMode", record.getBlendMode());
	}

	/**
	 * Visits a ButtonRecord2List object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ButtonRecord2List list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final ButtonRecord2 character : list) {
			visitor.visit(list, "Character", character);
			visit(character, visitor);
		}
	}

	/**
	 * Visits a ButtonRecordList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ButtonRecordList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final ButtonRecord character : list) {
			visitor.visit(list, "Character", character);
			visit(character, visitor);
		}
	}

	/**
	 * Visits a ClipActionRecord object.
	 * 
	 * @param clipActionRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ClipActionRecord clipActionRecord, final ISWFVisitor visitor) {

		if (clipActionRecord == null) {
			return;
		}

		visitor.visit(clipActionRecord, "EventFlags", clipActionRecord.getEventFlags());
		visit(clipActionRecord.getEventFlags(), visitor);
		visitor.visit(clipActionRecord, "ActionRecordSize", clipActionRecord.getActionRecordSize());
		visitor.visit(clipActionRecord, "KeyCode", clipActionRecord.getKeyCode());
		visitor.visit(clipActionRecord, "Actions", clipActionRecord.getActions());
		visit(clipActionRecord.getActions(), visitor);
	}

	/**
	 * Visits a ClipActionRecordList object.
	 * 
	 * @param clipActionRecords The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ClipActionRecordList clipActionRecords, final ISWFVisitor visitor) {

		if (clipActionRecords == null) {
			return;
		}

		for (final ClipActionRecord clipActionRecord : clipActionRecords) {
			visitor.visit(clipActionRecords, "ClipActionRecord", clipActionRecord);
			visit(clipActionRecord, visitor);
		}
	}

	/**
	 * Visits a ClipActions object.
	 * 
	 * @param clipActions The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ClipActions clipActions, final ISWFVisitor visitor) {

		if (clipActions == null) {
			return;
		}

		visitor.visit(clipActions, "Reserved", clipActions.getReserved());
		visitor.visit(clipActions, "AllEventFlags", clipActions.getAllEventFlags());
		visit(clipActions.getAllEventFlags(), visitor);
		visitor.visit(clipActions, "ClipActionRecords", clipActions.getClipActionRecords());
		visit(clipActions.getClipActionRecords(), visitor);

		final IParsedINTElement endFlag = clipActions.getClipActionEndFlag();

		if (endFlag instanceof UINT16) {
			visitor.visit(clipActions, "ClipActionEndFlag", (UINT16) clipActions.getClipActionEndFlag());
		}
		else  {
			visitor.visit(clipActions, "ClipActionEndFlag", (UINT32) clipActions.getClipActionEndFlag());
		}
	}

	/**
	 * Visits a ClipEventFlags object.
	 * 
	 * @param clipEventFlags The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ClipEventFlags clipEventFlags, final ISWFVisitor visitor) {

		if (clipEventFlags == null) {
			return;
		}

		visitor.visit(clipEventFlags, "ClipEventKeyUp", clipEventFlags.getClipEventKeyUp());
		visitor.visit(clipEventFlags, "ClipEventKeyDown", clipEventFlags.getClipEventKeyDown());
		visitor.visit(clipEventFlags, "ClipEventMouseUp", clipEventFlags.getClipEventMouseUp());
		visitor.visit(clipEventFlags, "ClipEventMouseDown", clipEventFlags.getClipEventMouseDown());
		visitor.visit(clipEventFlags, "ClipEventMouseMove", clipEventFlags.getClipEventMouseMove());
		visitor.visit(clipEventFlags, "ClipEventUnload", clipEventFlags.getClipEventUnload());
		visitor.visit(clipEventFlags, "ClipEventEnterFrame", clipEventFlags.getClipEventEnterFrame());
		visitor.visit(clipEventFlags, "ClipEventLoad", clipEventFlags.getClipEventLoad());
		visitor.visit(clipEventFlags, "ClipEventDragOver", clipEventFlags.getClipEventDragOver());
		visitor.visit(clipEventFlags, "ClipEventRollOut", clipEventFlags.getClipEventRollOut());
		visitor.visit(clipEventFlags, "ClipEventRollOver", clipEventFlags.getClipEventRollOver());
		visitor.visit(clipEventFlags, "ClipEventReleaseOutside", clipEventFlags.getClipEventReleaseOutside());
		visitor.visit(clipEventFlags, "ClipEventRelease", clipEventFlags.getClipEventRelease());
		visitor.visit(clipEventFlags, "ClipEventPress", clipEventFlags.getClipEventPress());
		visitor.visit(clipEventFlags, "ClipEventInitialize", clipEventFlags.getClipEventInitialize());
		visitor.visit(clipEventFlags, "ClipEventData", clipEventFlags.getClipEventData());
		visitor.visit(clipEventFlags, "Reserved", clipEventFlags.getReserved());
		visitor.visit(clipEventFlags, "ClipEventConstruct", clipEventFlags.getClipEventConstruct());
		visitor.visit(clipEventFlags, "ClipEventKeyPress", clipEventFlags.getClipEventKeyPress());
		visitor.visit(clipEventFlags, "ClipEventDragOut", clipEventFlags.getClipEventDragOut());
		visitor.visit(clipEventFlags, "Reserved2", clipEventFlags.getReserved2());
	}

	/**
	 * Visits a ColorMatrixFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ColorMatrixFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "Matrix", filter.getMatrix());
	}

	/**
	 * Visits a ConvolutionFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ConvolutionFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "MatrixX", filter.getMatrixX());
		visitor.visit(filter, "MatrixY", filter.getMatrixY());
		visitor.visit(filter, "Divisor", filter.getDivisor());
		visitor.visit(filter, "Bias", filter.getBias());
		visitor.visit(filter, "Matrix", filter.getMatrix());
		visitor.visit(filter, "DefaultColor", filter.getDefaultColor());
		visit(filter.getDefaultColor(), visitor);
		visitor.visit(filter, "Reserved", filter.getReserved());
		visitor.visit(filter, "Clamp", filter.getClamp());
		visitor.visit(filter, "PreserveAlpha", filter.getPreserveAlpha());
	}

	/**
	 * Visits a CSMTextSettingsTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final CSMTextSettingsTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "TextID", tag.getTextId());
		visitor.visit(tag, "UseFlashType", tag.getUseFlashType());
		visitor.visit(tag, "GridFit", tag.getGridFit());
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "Thickness", tag.getThickness());
		visitor.visit(tag, "Sharpness", tag.getSharpness());
		visitor.visit(tag, "Reserved2", tag.getReserved2());
	}

	/**
	 * Visits a CurvedEdgeRecord object.
	 * 
	 * @param curvedEdgeRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final CurvedEdgeRecord curvedEdgeRecord, final ISWFVisitor visitor) {

		if (curvedEdgeRecord == null) {
			return;
		}

		visitor.visit(curvedEdgeRecord, "TypeFlag", curvedEdgeRecord.getTypeFlag());
		visitor.visit(curvedEdgeRecord, "StraightFlag", curvedEdgeRecord.getStraightFlag());
		visitor.visit(curvedEdgeRecord, "NumBits", curvedEdgeRecord.getNumBits());
		visitor.visit(curvedEdgeRecord, "ControlDeltaX", curvedEdgeRecord.getControlDeltaX());
		visitor.visit(curvedEdgeRecord, "ControlDeltaY", curvedEdgeRecord.getControlDeltaY());
		visitor.visit(curvedEdgeRecord, "AnchorDeltaX", curvedEdgeRecord.getAnchorDeltaX());
		visitor.visit(curvedEdgeRecord, "AnchorDeltaY", curvedEdgeRecord.getAnchorDeltaY());
	}

	/**
	 * Visits a CxForm object.
	 * 
	 * @param cxForm The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final CxForm cxForm, final ISWFVisitor visitor) {

		if (cxForm == null) {
			return;
		}

		visitor.visit(cxForm, "HasAddTerms", cxForm.getHasAddTerms());
		visitor.visit(cxForm, "HasMultTerms", cxForm.getHasMultTerms());
		visitor.visit(cxForm, "NBits", cxForm.getnBits());
		visitor.visit(cxForm, "RedMultTerm", cxForm.getRedMultTerm());
		visitor.visit(cxForm, "GreenMultTerm", cxForm.getGreenMultTerm());
		visitor.visit(cxForm, "BlueMultTerm", cxForm.getBlueMultTerm());
		visitor.visit(cxForm, "RedAddTerm", cxForm.getRedAddTerm());
		visitor.visit(cxForm, "GreenAddTerm", cxForm.getGreenAddTerm());
		visitor.visit(cxForm, "BlueAddTerm", cxForm.getBlueAddTerm());
	}

	/**
	 * Visits a CxFormWithAlpha object.
	 * 
	 * @param cxFormWithAlpha The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final CxFormWithAlpha cxFormWithAlpha, final ISWFVisitor visitor) {

		if (cxFormWithAlpha == null) {
			return;
		}

		visitor.visit(cxFormWithAlpha, "HasAddTerms", cxFormWithAlpha.getHasAddTerms());
		visitor.visit(cxFormWithAlpha, "HasMultTerms", cxFormWithAlpha.getHasMultTerms());
		visitor.visit(cxFormWithAlpha, "NBits", cxFormWithAlpha.getnBits());
		visitor.visit(cxFormWithAlpha, "RedMultTerm", cxFormWithAlpha.getRedMultTerm());
		visitor.visit(cxFormWithAlpha, "GreenMultTerm", cxFormWithAlpha.getGreenMultTerm());
		visitor.visit(cxFormWithAlpha, "BlueMultTerm", cxFormWithAlpha.getBlueMultTerm());
		visitor.visit(cxFormWithAlpha, "AlphaMultTerm", cxFormWithAlpha.getAlphaMultTerm());
		visitor.visit(cxFormWithAlpha, "RedAddTerm", cxFormWithAlpha.getRedAddTerm());
		visitor.visit(cxFormWithAlpha, "GreenAddTerm", cxFormWithAlpha.getGreenAddTerm());
		visitor.visit(cxFormWithAlpha, "BlueAddTerm", cxFormWithAlpha.getBlueAddTerm());
		visitor.visit(cxFormWithAlpha, "AlphaAddTerm", cxFormWithAlpha.getAlphaAddTerm());
	}

	/**
	 * Visits a DefineBinaryDataTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBinaryDataTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Tag", tag.getTag());
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "Data", tag.getData());
	}

	/**
	 * Visits a DefineBitsJPEG2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBitsJPEG2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "ImageData", tag.getImageData());
	}

	/**
	 * Visits a DefineBitsJPEG3Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBitsJPEG3Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "AlphaDataOffset", tag.getAlphaDataOffset());
		visitor.visit(tag, "JPEGData", tag.getJpegData());
		visitor.visit(tag, "BitmapAlphaData", tag.getBitmapAlphaData());
	}

	/**
	 * Visits a DefineBitsJPEG4Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBitsJPEG4Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "AlphaDataOffset", tag.getAlphaDataOffset());
		visitor.visit(tag, "CharacterID", tag.getDeblockParam());
		visitor.visit(tag, "ImageData", tag.getImageData());
		visitor.visit(tag, "BitmapAlphaData", tag.getBitmapAlphaData());
	}

	/**
	 * Visits a DefineBitsLossless2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBitsLossless2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "BitmapFormat", tag.getBitmapFormat());
		visitor.visit(tag, "BitmapWidth", tag.getBitmapWidth());
		visitor.visit(tag, "BitmapHeight", tag.getBitmapHeight());
		visitor.visit(tag, "BitmapColorTableSize", tag.getBitmapColorTableSize());
		visitor.visit(tag, "ZlibBitmapData", tag.getZlibBitmapData());
	}

	/**
	 * Visits a DefineBitsLosslessTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBitsLosslessTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "BitmapFormat", tag.getBitmapFormat());
		visitor.visit(tag, "BitmapWidth", tag.getBitmapWidth());
		visitor.visit(tag, "BitmapHeight", tag.getBitmapHeight());
		visitor.visit(tag, "BitmapColorTableSize", tag.getBitmapColorTableSize());
		visitor.visit(tag, "ZlibBitmapData", tag.getZlibBitmapData());
	}

	/**
	 * Visits a DefineBitsTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineBitsTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "JPEGData", tag.getJpegData());
	}

	/**
	 * Visits a DefineButton2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineButton2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ButtonID", tag.getButtonId());
		visitor.visit(tag, "ReservedFlags", tag.getReservedFlags());
		visitor.visit(tag, "TrackAsMenu", tag.getTrackAsMenu());
		visitor.visit(tag, "ActionOffset", tag.getActionOffset());
		visitor.visit(tag, "Characters", tag.getCharacters());
		visit(tag.getCharacters(), visitor);
		visitor.visit(tag, "CharacterEndFlag", tag.getCharacterEndFlag());
		visitor.visit(tag, "Actions", tag.getActions());
		visit(tag.getActions(), visitor);
	}

	/**
	 * Visits a DefineButtonCxformTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineButtonCxformTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ButtonID", tag.getButtonId());
		visitor.visit(tag, "ButtonColorTransform", tag.getButtonColorTransform());
		visit(tag.getButtonColorTransform(), visitor);
	}

	/**
	 * Visits a DefineButtonSoundTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineButtonSoundTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ButtonID", tag.getButtonId());
		visitor.visit(tag, "ButtonSoundChar0", tag.getButtonSoundChar0());
		visitor.visit(tag, "ButtonSoundInfo0", tag.getButtonSoundInfo0());
		visitor.visit(tag, "ButtonSoundChar1", tag.getButtonSoundChar1());
		visitor.visit(tag, "ButtonSoundInfo1", tag.getButtonSoundInfo1());
		visitor.visit(tag, "ButtonSoundChar2", tag.getButtonSoundChar2());
		visitor.visit(tag, "ButtonSoundInfo2", tag.getButtonSoundInfo2());
		visitor.visit(tag, "ButtonSoundChar3", tag.getButtonSoundChar3());
		visitor.visit(tag, "ButtonSoundInfo3", tag.getButtonSoundInfo3());
	}

	/**
	 * Visits a DefineButtonTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineButtonTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ButtonID", tag.getButtonId());
		visitor.visit(tag, "Characters", tag.getCharacters());
		visit(tag.getCharacters(), visitor);
		visitor.visit(tag, "CharacterEndFlag", tag.getCharacterEndFlag());
		visitor.visit(tag, "Actions", tag.getActions());
		visit(tag.getActions(), visitor);
		visitor.visit(tag, "ActionEndFlag", tag.getActionEndFlag());
	}

	/**
	 * Visits a DefineEditTextTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineEditTextTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Bounds", tag.getBounds());
		visit(tag.getBounds(), visitor);
		visitor.visit(tag, "HasText", tag.getHasText());
		visitor.visit(tag, "WordWrap", tag.getWordWrap());
		visitor.visit(tag, "Multiline", tag.getMultiline());
		visitor.visit(tag, "Password", tag.getPassword());
		visitor.visit(tag, "ReadOnly", tag.getReadOnly());
		visitor.visit(tag, "HasTextColor", tag.getHasTextColor());
		visitor.visit(tag, "HasMaxLength", tag.getHasMaxLength());
		visitor.visit(tag, "HasFont", tag.getFontId());
		visitor.visit(tag, "HasFontClass", tag.getHasFontClass());
		visitor.visit(tag, "AutoSize", tag.getAutoSize());
		visitor.visit(tag, "HasLayout", tag.getHasLayout());
		visitor.visit(tag, "NoSelect", tag.getNoSelect());
		visitor.visit(tag, "Border", tag.getBorder());
		visitor.visit(tag, "WasStatic", tag.getWasStatic());
		visitor.visit(tag, "HTML", tag.getHtml());
		visitor.visit(tag, "UseOutlines", tag.getUseOutlines());
		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontClass", tag.getFontClass());
		visitor.visit(tag, "FontHeight", tag.getFontHeight());
		visitor.visit(tag, "TextColor", tag.getTextColor());
		visit(tag.getTextColor(), visitor);
		visitor.visit(tag, "MaxLength", tag.getMaxLength());
		visitor.visit(tag, "Align", tag.getAlign());
		visitor.visit(tag, "LeftMargin", tag.getLeftMargin());
		visitor.visit(tag, "RightMargin", tag.getRightMargin());
		visitor.visit(tag, "Indent", tag.getIndent());
		visitor.visit(tag, "Leading", tag.getLeading());
		visitor.visit(tag, "VariableName", tag.getVariableName());
		visitor.visit(tag, "InitialText", tag.getInitialText());
	}

	/**
	 * Visits a DefineFont2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFont2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontFlagsHasLayout", tag.getFontFlagsHasLayout());
		visitor.visit(tag, "FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit(tag, "FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit(tag, "FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit(tag, "FontFlagsWideOffsets", tag.getFontFlagsWideOffsets());
		visitor.visit(tag, "FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit(tag, "FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit(tag, "FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit(tag, "LanguageCode", tag.getLanguageCode());
		visitor.visit(tag, "FontNameLen", tag.getFontNameLen());
		visitor.visit(tag, "FontName", tag.getFontName());
		visitor.visit(tag, "NumGlyphs", tag.getNumGlyphs());
		visitor.visit(tag, "OffsetTable", tag.getOffsetTable());
		visit(tag.getOffsetTable(), visitor);

		final IParsedINTElement codeTableOffset = tag.getCodeTableOffset();

		if (codeTableOffset instanceof UINT16) {
			visitor.visit(tag, "CodeTableOffset", (UINT16) tag.getCodeTableOffset());
		} else {
			visitor.visit(tag, "CodeTableOffset", (UINT32) tag.getCodeTableOffset());
		}

		visitor.visit(tag, "GlyphShapeTable", tag.getGlyphShapeTable());
		visit(tag.getGlyphShapeTable(), visitor);
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
		visitor.visit(tag, "FontAscent", tag.getFontAscent());
		visitor.visit(tag, "FontDescent", tag.getFontDescent());
		visitor.visit(tag, "FontLeading", tag.getFontLeading());
		visitor.visit(tag, "FontAdvanceTable", tag.getFontAdvanceTable());
		visit(tag.getFontAdvanceTable(), visitor);
		visitor.visit(tag, "FontBoundsTable", tag.getFontBoundsTable());
		visit(tag.getFontBoundsTable(), visitor);
		visitor.visit(tag, "KerningCount", tag.getKerningCount());
		visitor.visit(tag, "FontKerningTable", tag.getFontKerningTable());
		visit(tag.getFontKerningTable(), visitor);
	}

	/**
	 * Visits a DefineFont3Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFont3Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontFlagsHasLayout", tag.getFontFlagsHasLayout());
		visitor.visit(tag, "FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit(tag, "FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit(tag, "FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit(tag, "FontFlagsWideOffsets", tag.getFontFlagsWideOffsets());
		visitor.visit(tag, "FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit(tag, "FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit(tag, "FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit(tag, "LanguageCode", tag.getLanguageCode());
		visitor.visit(tag, "FontNameLen", tag.getFontNameLen());
		visitor.visit(tag, "FontName", tag.getFontName());
		visitor.visit(tag, "NumGlyphs", tag.getNumGlyphs());
		visitor.visit(tag, "OffsetTable", tag.getOffsetTable());
		visit(tag.getOffsetTable(), visitor);

		final IParsedINTElement codeTableOffset = tag.getCodeTableOffset();

		if (codeTableOffset instanceof UINT16) {
			visitor.visit(tag, "CodeTableOffset", (UINT16) tag.getCodeTableOffset());
		} else {
			visitor.visit(tag, "CodeTableOffset", (UINT32) tag.getCodeTableOffset());
		}

		visitor.visit(tag, "GlyphShapeTable", tag.getGlyphShapeTable());
		visit(tag.getGlyphShapeTable(), visitor);
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
		visitor.visit(tag, "FontAscent", tag.getFontAscent());
		visitor.visit(tag, "FontDescent", tag.getFontDescent());
		visitor.visit(tag, "FontLeading", tag.getFontLeading());
		visitor.visit(tag, "FontAdvanceTable", tag.getFontAdvanceTable());
		visit(tag.getFontAdvanceTable(), visitor);
		visitor.visit(tag, "FontBoundsTable", tag.getFontBoundsTable());
		visit(tag.getFontBoundsTable(), visitor);
		visitor.visit(tag, "KerningCount", tag.getKerningCount());
		visitor.visit(tag, "FontKerningTable", tag.getFontKerningTable());
		visit(tag.getFontKerningTable(), visitor);
	}

	/**
	 * Visits a DefineFont4Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFont4Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontFlagsReserved", tag.getFontFlagsReserved());
		visitor.visit(tag, "FontFlagsHasFontData", tag.getFontFlagsHasFontData());
		visitor.visit(tag, "FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit(tag, "FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit(tag, "FontName", tag.getFontName());
		visitor.visit(tag, "FontData", tag.getFontData());
	}

	/**
	 * Visits a DefineFontAlignZonesTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFontAlignZonesTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "CSMTableHint", tag.getCsmTableHint());
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "ZoneTable", tag.getZoneTable());
		visit(tag.getZoneTable(), visitor);
	}

	/**
	 * Visits a DefineFontInfo2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFontInfo2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontNameLen", tag.getFontNameLen());
		visitor.visit(tag, "FontName", tag.getFontName());
		visitor.visit(tag, "FontFlagsReserved", tag.getFontFlagsReserved());
		visitor.visit(tag, "FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit(tag, "FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit(tag, "FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit(tag, "FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit(tag, "FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit(tag, "FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit(tag, "LanguageCode", tag.getLanguageCode());
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
	}

	/**
	 * Visits a DefineFontInfoTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFontInfoTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontNameLen", tag.getFontNameLen());
		visitor.visit(tag, "FontName", tag.getFontName());
		visitor.visit(tag, "FontFlagsReserved", tag.getFontFlagsReserved());
		visitor.visit(tag, "FontFlagsSmallText", tag.getFontFlagsSmallText());
		visitor.visit(tag, "FontFlagsShiftJIS", tag.getFontFlagsShiftJIS());
		visitor.visit(tag, "FontFlagsANSI", tag.getFontFlagsANSI());
		visitor.visit(tag, "FontFlagsItalic", tag.getFontFlagsItalic());
		visitor.visit(tag, "FontFlagsBold", tag.getFontFlagsBold());
		visitor.visit(tag, "FontWideCodes", tag.getFontFlagsWideCodes());
		visitor.visit(tag, "CodeTable", tag.getCodeTable());
		visit(tag.getCodeTable(), visitor);
	}

	/**
	 * Visits a DefineFontNameTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFontNameTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "FontName", tag.getFontName());
		visitor.visit(tag, "FontCopyright", tag.getFontCopyright());
	}

	/**
	 * Visits a DefineFontTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineFontTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "FontID", tag.getFontId());
		visitor.visit(tag, "OffsetTable", tag.getOffsetTable());
		visit(tag.getOffsetTable(), visitor);
		visitor.visit(tag, "GlyphShapeTable", tag.getGlyphShapeTable());
		visit(tag.getGlyphShapeTable(), visitor);
	}

	/**
	 * Visits a DefineMorphShape2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineMorphShape2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "StartBounds", tag.getStartBounds());
		visit(tag.getStartBounds(), visitor);
		visitor.visit(tag, "EndBounds", tag.getEndBounds());
		visit(tag.getEndBounds(), visitor);
		visitor.visit(tag, "StartEdgeBounds", tag.getStartEdgeBounds());
		visit(tag.getStartBounds(), visitor);
		visitor.visit(tag, "EndEdgeBounds", tag.getEndEdgeBounds());
		visit(tag.getEndBounds(), visitor);
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "UsesNonScalingStrokes", tag.getUsesNonScalingStrokes());
		visitor.visit(tag, "UsesScalingStrokes", tag.getUsesScalingStrokes());
		visitor.visit(tag, "Offset", tag.getOffset());
		visitor.visit(tag, "MorphFillStyles", tag.getMorphFillStyles());
		visit(tag.getMorphFillStyles(), visitor);
		visitor.visit(tag, "MorphLineStyles", tag.getMorphLineStyles());
		visit(tag.getMorphLineStyles(), visitor);
		visitor.visit(tag, "StartEdges", tag.getStartEdges());
		visit(tag.getStartEdges(), visitor);
		visitor.visit(tag, "EndEdges", tag.getEndEdges());
		visit(tag.getEndEdges(), visitor);
	}

	/**
	 * Visits a DefineMorphShapeTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineMorphShapeTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "StartBounds", tag.getStartBounds());
		visit(tag.getStartBounds(), visitor);
		visitor.visit(tag, "EndBounds", tag.getEndBounds());
		visit(tag.getEndBounds(), visitor);
		visitor.visit(tag, "Offset", tag.getOffset());
		visitor.visit(tag, "MorphFillStyles", tag.getMorphFillStyles());
		visit(tag.getMorphFillStyles(), visitor);
		visitor.visit(tag, "MorphLineStyles", tag.getMorphLineStyles());
		visit(tag.getMorphLineStyles(), visitor);
		visitor.visit(tag, "StartEdges", tag.getStartEdges());
		visit(tag.getStartEdges(), visitor);
		visitor.visit(tag, "EndEdges", tag.getEndEdges());
		visit(tag.getEndEdges(), visitor);
	}

	/**
	 * Visits a DefineScalingGridTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineScalingGridTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Splitter", tag.getSplitter());
		visit(tag.getSplitter(), visitor);
	}

	/**
	 * Visits a DefineSceneAndFrameLabelDataTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineSceneAndFrameLabelDataTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "SceneCount", tag.getSceneCount());
		visitor.visit(tag, "SceneNames", tag.getSceneNames());
		visit(tag.getSceneNames(), visitor);
		visitor.visit(tag, "FrameLabelCount", tag.getFrameLabelCount());
		visitor.visit(tag, "FrameLabels", tag.getFrameLabels());
		visit(tag.getFrameLabels(), visitor);
	}

	/**
	 * Visits a DefineShape2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineShape2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	/**
	 * Visits a DefineShape3Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineShape3Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	/**
	 * Visits a DefineShape4Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineShape4Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "EdgeBounds", tag.getEdgeBounds());
		visit(tag.getEdgeBounds(), visitor);
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "UsesFillWindingRule", tag.getUsesFillWindingRule());
		visitor.visit(tag, "UsesNonScalingStrokes", tag.getUsesNonScalingStrokes());
		visitor.visit(tag, "UsesScalingStrokes", tag.getUsesScalingStrokes());
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	/**
	 * Visits a DefineShape4Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineShapeTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "ShapeID", tag.getShapeId());
		visitor.visit(tag, "ShapeBounds", tag.getShapeBounds());
		visit(tag.getShapeBounds(), visitor);
		visitor.visit(tag, "Shapes", tag.getShapes());
		visit(tag.getShapes(), visitor);
	}

	/**
	 * Visits a DefineSoundTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineSoundTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "SoundID", tag.getSoundId());
		visitor.visit(tag, "SoundFormat", tag.getSoundFormat());
		visitor.visit(tag, "SoundRate", tag.getSoundRate());
		visitor.visit(tag, "SoundSize", tag.getSoundSize());
		visitor.visit(tag, "SoundType", tag.getSoundType());
		visitor.visit(tag, "SoundSampleCount", tag.getSoundSampleCount());
		visitor.visit(tag, "SoundData", tag.getSoundData());
	}

	/**
	 * Visits a DefineSpriteTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineSpriteTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "SpriteID", tag.getSpriteId());
		visitor.visit(tag, "FrameCount", tag.getFrameCount());
		visitor.visit(tag, "ControlTags", tag.getControlTags());
		visit(tag.getControlTags(), visitor);
	}

	/**
	 * Visits a DefineText2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineText2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "TextBounds", tag.getTextBounds());
		visit(tag.getTextBounds(), visitor);
		visitor.visit(tag, "TextMatrix", tag.getTextMatrix());
		visit(tag.getTextMatrix(), visitor);
		visitor.visit(tag, "GlyphBits", tag.getGlyphBits());
		visitor.visit(tag, "AdvanceBits", tag.getAdvanceBits());
		visitor.visit(tag, "TextRecords", tag.getTextRecords());
		visit(tag.getTextRecords(), visitor);
		visitor.visit(tag, "End", tag.getEnd());
	}

	/**
	 * Visits a DefineTextTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineTextTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "TextBounds", tag.getTextBounds());
		visit(tag.getTextBounds(), visitor);
		visitor.visit(tag, "TextMatrix", tag.getTextMatrix());
		visit(tag.getTextMatrix(), visitor);
		visitor.visit(tag, "GlyphBits", tag.getGlyphBits());
		visitor.visit(tag, "AdvanceBits", tag.getAdvanceBits());
		visitor.visit(tag, "TextRecords", tag.getTextRecords());
		visit(tag.getTextRecords(), visitor);
		visitor.visit(tag, "End", tag.getEnd());
	}

	/**
	 * Visits a DefineVideoStreamTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DefineVideoStreamTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "NumFrames", tag.getNumFrames());
		visitor.visit(tag, "Width", tag.getWidth());
		visitor.visit(tag, "Height", tag.getHeight());
		visitor.visit(tag, "VideoFlagsReserved", tag.getVideoFlagsReserved());
		visitor.visit(tag, "VideoFlagsDeblocking", tag.getVideoFlagsDeblocking());
		visitor.visit(tag, "VideoFlagsSmoothing", tag.getVideoFlagsSmoothing());
		visitor.visit(tag, "CodecID", tag.getCodecId());
	}

	/**
	 * Visits a DoABC object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DoABCTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Flags", tag.getFlags());
		visitor.visit(tag, "Name", tag.getName());
		visitor.visit(tag, "ABCData", tag.getAbcData());
	}

	/**
	 * Visits a DoActionTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DoActionTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Actions", tag.getActions());
		visit(tag.getActions(), visitor);
	}

	/**
	 * Visits a DoInitActionTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DoInitActionTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "SpriteID", tag.getSpriteId());
		visitor.visit(tag, "Actions", tag.getActions());
		visit(tag.getActions(), visitor);
	}

	/**
	 * Visits a DropShadowFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final DropShadowFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "DropShadowColor", filter.getDropShadowColor());
		visit(filter.getDropShadowColor(), visitor);
		visitor.visit(filter, "BlurX", filter.getBlurX());
		visitor.visit(filter, "BlurY", filter.getBlurY());
		visitor.visit(filter, "Angle", filter.getAngle());
		visitor.visit(filter, "Distance", filter.getDistance());
		visitor.visit(filter, "Strength", filter.getStrength());
		visitor.visit(filter, "InnerShadow", filter.getInnerShadow());
		visitor.visit(filter, "Knockout", filter.getKnockout());
		visitor.visit(filter, "CompositeSource", filter.getCompositeSource());
		visitor.visit(filter, "Passes", filter.getPasses());
	}

	/**
	 * Visits a EnableDebugger2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final EnableDebugger2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Password", tag.getPassword());
		visitor.visit(tag, "Reserved", tag.getReserved());
	}

	/**
	 * Visits a EnableDebuggerTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final EnableDebuggerTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Password", tag.getPassword());
	}

	/**
	 * Visits an EndShapeRecord object.
	 * 
	 * @param shapeRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final EndShapeRecord shapeRecord, final ISWFVisitor visitor) {

		if (shapeRecord == null) {
			return;
		}

		visitor.visit(shapeRecord, "TypeFlag", shapeRecord.getTypeFlag());
		visitor.visit(shapeRecord, "EndOfShape", shapeRecord.getEndOfShape());
	}

	/**
	 * Visits an EndTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final EndTag tag, final ISWFVisitor visitor) {
		// Nothing to do here.
	}

	/**
	 * Visits an ExportAssetsTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ExportAssetsTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Count", tag.getCount());
		visitor.visit(tag, "Tags", tag.getAssets());

		for (final Symbol symbol : tag.getAssets()) {
			visit(symbol, visitor);
		}
	}

	/**
	 * Visits a FileAttributesTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FileAttributesTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "UseDirectBit", tag.getUseDirectBit());
		visitor.visit(tag, "UseGPU", tag.getUseGPU());
		visitor.visit(tag, "HasMetadata", tag.getHasMetadata());
		visitor.visit(tag, "ActionScript3", tag.getActionScript3());
		visitor.visit(tag, "Reserved2", tag.getReserved2());
		visitor.visit(tag, "UseNetwork", tag.getUseNetwork());
		visitor.visit(tag, "Reserved3", tag.getReserved3());
	}

	/**
	 * Visits a FillStyle object.
	 * 
	 * @param fillStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FillStyle fillStyle, final ISWFVisitor visitor) {

		if (fillStyle == null) {
			return;
		}

		visitor.visit(fillStyle, "Width", fillStyle.getFillStyleType());
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

		visitor.visit(fillStyle, "BitmapID", fillStyle.getBitmapId());
		visitor.visit(fillStyle, "BitmapMatrix", fillStyle.getBitmapMatrix());
		visit(fillStyle.getBitmapMatrix(), visitor);
	}

	/**
	 * Visits a FillStyle3 object.
	 * 
	 * @param fillStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FillStyle3 fillStyle, final ISWFVisitor visitor) {

		if (fillStyle == null) {
			return;
		}

		visitor.visit(fillStyle, "Width", fillStyle.getFillStyleType());
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

		visitor.visit(fillStyle, "BitmapID", fillStyle.getBitmapId());
		visitor.visit(fillStyle, "BitmapMatrix", fillStyle.getBitmapMatrix());
		visit(fillStyle.getBitmapMatrix(), visitor);
	}

	/**
	 * Visits a FillStyle3Array object.
	 * 
	 * @param fillStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FillStyle3Array fillStyles, final ISWFVisitor visitor) {

		if (fillStyles == null) {
			return;
		}

		visitor.visit(fillStyles, "FillStyleCount", fillStyles.getFillStyleCount());
		visitor.visit(fillStyles, "FillStyleCountExtended", fillStyles.getFillStyleCountExtended());
		visitor.visit(fillStyles, "FillStyles", fillStyles.getFillStyles());

		visit(fillStyles.getFillStyles(), visitor);
	}

	/**
	 * Visits a FillStyle3List object.
	 * 
	 * @param fillStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FillStyle3List fillStyles, final ISWFVisitor visitor) {

		if (fillStyles == null) {
			return;
		}

		for (final FillStyle3 fillStyle : fillStyles) {
			visitor.visit(fillStyles, "FillStyle", fillStyle);
			visit(fillStyle, visitor);
		}
	}

	/**
	 * Visits a FillStyleArray object.
	 * 
	 * @param fillStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FillStyleArray fillStyles, final ISWFVisitor visitor) {

		if (fillStyles == null) {
			return;
		}

		visitor.visit(fillStyles, "FillStyleCount", fillStyles.getFillStyleCount());
		visitor.visit(fillStyles, "FillStyleCountExtended", fillStyles.getFillStyleCountExtended());
		visitor.visit(fillStyles, "FillStyles", fillStyles.getFillStyles());

		visit(fillStyles.getFillStyles(), visitor);
	}

	/**
	 * Visits a FillStyleList object.
	 * 
	 * @param fillStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FillStyleList fillStyles, final ISWFVisitor visitor) {

		if (fillStyles == null) {
			return;
		}

		for (final FillStyle fillStyle : fillStyles) {
			visitor.visit(fillStyles, "FillStyle", fillStyle);
			visit(fillStyle, visitor);
		}
	}

	/**
	 * Visits a Filter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Filter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "FilterID", filter.getFilterId());
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

	/**
	 * Visits a FilterList object.
	 * 
	 * @param filterList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FilterList filterList, final ISWFVisitor visitor) {

		if (filterList == null) {
			return;
		}

		visitor.visit(filterList, "NumberOfFilters", filterList.getNumberOfFilters());
		visitor.visit(filterList, "Filters", filterList.getFilters());
		visit(filterList.getFilters(), visitor);
	}

	/**
	 * Visits a FocalGradient List object.
	 * 
	 * @param gradient The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FocalGradient gradient, final ISWFVisitor visitor) {

		if (gradient == null) {
			return;
		}

		visitor.visit(gradient, "SpreadMode", gradient.getSpreadMode());
		visitor.visit(gradient, "InterpolationMode", gradient.getInterpolationMode());
		visitor.visit(gradient, "NumGradients", gradient.getNumGradients());
		visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
		visit(gradient.getGradientRecords(), visitor);
		visitor.visit(gradient, "FocalPoint", gradient.getFocalPoint());
	}

	/**
	 * Visits a FrameLabel object.
	 * 
	 * @param frameLabel The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FrameLabel frameLabel, final ISWFVisitor visitor) {

		if (frameLabel == null) {
			return;
		}

		visitor.visit(frameLabel, "Offset", frameLabel.getOffset());
		visitor.visit(frameLabel, "Name", frameLabel.getName());
	}

	/**
	 * Visits a FrameLabelList object.
	 * 
	 * @param frameLabels The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FrameLabelList frameLabels, final ISWFVisitor visitor) {

		if (frameLabels == null) {
			return;
		}

		for (final FrameLabel frameLabel : frameLabels) {
			visitor.visit(frameLabels, "FrameLabel", frameLabel);
			visit(frameLabel, visitor);
		}
	}

	/**
	 * Visits a FrameLabelTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final FrameLabelTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Name", tag.getName());
		visitor.visit(tag, "AnchorFlag", tag.getNamedAnchorFlag());
	}

	/**
	 * Visits a GlowFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GlowFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "GlowColor", filter.getGlowColor());
		visit(filter.getGlowColor(), visitor);
		visitor.visit(filter, "BlurX", filter.getBlurX());
		visitor.visit(filter, "BlurY", filter.getBlurY());
		visitor.visit(filter, "Strength", filter.getStrength());
		visitor.visit(filter, "InnerShadow", filter.getInnerShadow());
		visitor.visit(filter, "Knockout", filter.getKnockout());
		visitor.visit(filter, "CompositeSource", filter.getCompositeSource());
		visitor.visit(filter, "Passes", filter.getPasses());
	}

	/**
	 * Visits a GlyphEntry object.
	 * 
	 * @param glyphEntry The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GlyphEntry glyphEntry, final ISWFVisitor visitor) {

		if (glyphEntry == null) {
			return;
		}

		visitor.visit(glyphEntry, "GlyphIndex", glyphEntry.getGlyphIndex());
		visitor.visit(glyphEntry, "AdvanceIndex", glyphEntry.getAdvanceIndex());
	}

	/**
	 * Visits a GlyphEntryList object.
	 * 
	 * @param glyphEntries The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GlyphEntryList glyphEntries, final ISWFVisitor visitor) {

		if (glyphEntries == null) {
			return;
		}

		for (final GlyphEntry glyphEntry : glyphEntries) {
			visitor.visit(glyphEntries, "GlyphEntry", glyphEntry);
			visit(glyphEntry, visitor);
		}
	}

	/**
	 * Visits a Gradient object.
	 * 
	 * @param gradient The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Gradient gradient, final ISWFVisitor visitor) {

		if (gradient == null) {
			return;
		}

		visitor.visit(gradient, "SpreadMode", gradient.getSpreadMode());
		visitor.visit(gradient, "InterpolationMode", gradient.getInterpolationMode());
		visitor.visit(gradient, "NumGradients", gradient.getNumGradients());
		visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
		visit(gradient.getGradientRecords(), visitor);
	}

	/**
	 * Visits a Gradient3 object.
	 * 
	 * @param gradient The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Gradient3 gradient, final ISWFVisitor visitor) {

		if (gradient == null) {
			return;
		}

		visitor.visit(gradient, "SpreadMode", gradient.getSpreadMode());
		visitor.visit(gradient, "InterpolationMode", gradient.getInterpolationMode());
		visitor.visit(gradient, "NumGradients", gradient.getNumGradients());
		visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
		visit(gradient.getGradientRecords(), visitor);
	}

	/**
	 * Visits a GradientBevelFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GradientBevelFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "NumColors", filter.getNumColors());
		visitor.visit(filter, "GradientColors", filter.getGradientColors());
		visitor.visit(filter, "GradientRatio", filter.getGradientRatio());
		visitor.visit(filter, "BlurX", filter.getBlurX());
		visitor.visit(filter, "BlurY", filter.getBlurY());
		visitor.visit(filter, "Angle", filter.getAngle());
		visitor.visit(filter, "Distance", filter.getDistance());
		visitor.visit(filter, "Strength", filter.getStrength());
		visitor.visit(filter, "InnerShadow", filter.getInnerShadow());
		visitor.visit(filter, "Knockout", filter.getKnockout());
		visitor.visit(filter, "CompositeSource", filter.getCompositeSource());
		visitor.visit(filter, "OnTop", filter.getOnTop());
		visitor.visit(filter, "Passes", filter.getPasses());
	}

	/**
	 * Visits a GradientGlowFilter object.
	 * 
	 * @param filter The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GradientGlowFilter filter, final ISWFVisitor visitor) {

		if (filter == null) {
			return;
		}

		visitor.visit(filter, "NumColors", filter.getNumColors());
		visitor.visit(filter, "GradientColors", filter.getGradientColors());
		visitor.visit(filter, "GradientRatio", filter.getGradientRatio());
		visitor.visit(filter, "BlurX", filter.getBlurX());
		visitor.visit(filter, "BlurY", filter.getBlurY());
		visitor.visit(filter, "Angle", filter.getAngle());
		visitor.visit(filter, "Distance", filter.getDistance());
		visitor.visit(filter, "Strength", filter.getStrength());
		visitor.visit(filter, "InnerShadow", filter.getInnerShadow());
		visitor.visit(filter, "Knockout", filter.getKnockout());
		visitor.visit(filter, "CompositeSource", filter.getCompositeSource());
		visitor.visit(filter, "OnTop", filter.getOnTop());
		visitor.visit(filter, "Passes", filter.getPasses());
	}

	/**
	 * Visits a GradRecord object.
	 * 
	 * @param gradRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GradRecord gradRecord, final ISWFVisitor visitor) {

		if (gradRecord == null) {
			return;
		}

		visitor.visit(gradRecord, "Ratio", gradRecord.getRatio());
		visitor.visit(gradRecord, "Color", gradRecord.getColor());
		visit(gradRecord.getColor(), visitor);
	}

	/**
	 * Visits a GradRecord3 object.
	 * 
	 * @param gradRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GradRecord3 gradRecord, final ISWFVisitor visitor) {

		if (gradRecord == null) {
			return;
		}

		visitor.visit(gradRecord, "Ratio", gradRecord.getRatio());
		visitor.visit(gradRecord, "Color", gradRecord.getColor());
		visit(gradRecord.getColor(), visitor);
	}

	/**
	 * Visits a GradRecord3List object.
	 * 
	 * @param gradientRecords The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GradRecord3List gradientRecords, final ISWFVisitor visitor) {

		if (gradientRecords == null) {
			return;
		}

		for (final GradRecord3 gradRecord : gradientRecords) {
			visitor.visit(gradientRecords, "GradRecord", gradRecord);
			visit(gradRecord, visitor);
		}
	}

	/**
	 * Visits a GradRecordList object.
	 * 
	 * @param gradientRecords The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final GradRecordList gradientRecords, final ISWFVisitor visitor) {

		if (gradientRecords == null) {
			return;
		}

		for (final GradRecord gradRecord : gradientRecords) {
			visitor.visit(gradientRecords, "GradRecord", gradRecord);
			visit(gradRecord, visitor);
		}
	}

	/**
	 * Visits an ImportAssets2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ImportAssets2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "URL", tag.getUrl());
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "Reserved2", tag.getReserved2());
		visitor.visit(tag, "Count", tag.getCount());
		visitor.visit(tag, "Symbols", tag.getSymbols());
		visit(tag.getSymbols(), visitor);
	}

	/**
	 * Visits an ImportAssetsTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ImportAssetsTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "URL", tag.getUrl());
		visitor.visit(tag, "Count", tag.getCount());
		visitor.visit(tag, "Symbols", tag.getSymbols());
		visit(tag.getSymbols(), visitor);
	}

	/**
	 * Visits an INT16List object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final INT16List list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final INT16 element : list) {
			visitor.visit(list, "Element", element);
		}
	}

	/**
	 * Visits a JPEGTablesTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final JPEGTablesTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "JPEGData", tag.getJpegData());
	}

	/**
	 * Visits a KerningRecord object.
	 * 
	 * @param kerningRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final KerningRecord kerningRecord, final ISWFVisitor visitor) {

		if (kerningRecord == null) {
			return;
		}

		final IParsedINTElement kerningCode1 = kerningRecord.getFontKerningCode1();

		if (kerningCode1 instanceof UINT16) {
			visitor.visit(kerningRecord, "FontKerningCode1", (UINT16) kerningCode1);
		}
		else  {
			visitor.visit(kerningRecord, "FontKerningCode1", (UINT32) kerningCode1);
		}

		final IParsedINTElement kerningCode2 = kerningRecord.getFontKerningCode1();

		if (kerningCode1 instanceof UINT16) {
			visitor.visit(kerningRecord, "FontKerningCode2", (UINT16) kerningCode2);
		}
		else  {
			visitor.visit(kerningRecord, "FontKerningCode2", (UINT32) kerningCode2);
		}

		visitor.visit(kerningRecord, "FontKerningAdjustment", kerningRecord.getFontKerningAdjustment());
	}

	/**
	 * Visits a KerningRecordList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final KerningRecordList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final KerningRecord kerningRecord : list) {
			visitor.visit(list, "KerningRecord", kerningRecord);
			visit(kerningRecord, visitor);
		}
	}

	/**
	 * Visits a LineStyle object.
	 * 
	 * @param lineStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle lineStyle, final ISWFVisitor visitor) {

		if (lineStyle == null) {
			return;
		}

		visitor.visit(lineStyle, "Width", lineStyle.getWidth());
		visitor.visit(lineStyle, "Color", lineStyle.getColor());
		visit(lineStyle.getColor(), visitor);
	}

	/**
	 * Visits a LineStyle3 object.
	 * 
	 * @param lineStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle3 lineStyle, final ISWFVisitor visitor) {

		if (lineStyle == null) {
			return;
		}

		visitor.visit(lineStyle, "Width", lineStyle.getWidth());
		visitor.visit(lineStyle, "Color", lineStyle.getColor());
		visit(lineStyle.getColor(), visitor);
	}

	/**
	 * Visits a LineStyle3Array object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle3Array lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		visitor.visit(lineStyles, "LineStyleCount", lineStyles.getLineStyleCount());
		visitor.visit(lineStyles, "LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
		visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

		visit(lineStyles.getLineStyles(), visitor);
	}

	/**
	 * Visits a LineStyle3List object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle3List lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		for (final LineStyle3 lineStyle : lineStyles) {
			visitor.visit(lineStyles, "LineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	/**
	 * Visits a LineStyle4 object.
	 * 
	 * @param lineStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle4 lineStyle, final ISWFVisitor visitor) {

		if (lineStyle == null) {
			return;
		}

		visitor.visit(lineStyle, "Width", lineStyle.getWidth());
		visitor.visit(lineStyle, "Color", lineStyle.getColor());
		visit(lineStyle.getColor(), visitor);
	}

	/**
	 * Visits a LineStyle4Array object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle4Array lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		visitor.visit(lineStyles, "LineStyleCount", lineStyles.getLineStyleCount());
		visitor.visit(lineStyles, "LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
		visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

		visit(lineStyles.getLineStyles(), visitor);
	}

	/**
	 * Visits a LineStyle4List object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyle4List lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		for (final LineStyle4 lineStyle : lineStyles) {
			visitor.visit(lineStyles, "LineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	/**
	 * Visits a LineStyleArray object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyleArray lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		visitor.visit(lineStyles, "LineStyleCount", lineStyles.getLineStyleCount());
		visitor.visit(lineStyles, "LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
		visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

		visit(lineStyles.getLineStyles(), visitor);
	}

	/**
	 * Visits a LineStyleList object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final LineStyleList lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		for (final LineStyle lineStyle : lineStyles) {
			visitor.visit(lineStyles, "LineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	/**
	 * Visits a Matrix object.
	 * 
	 * @param matrix The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Matrix matrix, final ISWFVisitor visitor) {

		if (matrix == null) {
			return;
		}

		visitor.visit(matrix, "HasScale", matrix.getHasScale());
		visitor.visit(matrix, "NScaleBits", matrix.getnScaleBits());
		visitor.visit(matrix, "ScaleX", matrix.getScaleX());
		visitor.visit(matrix, "ScaleY", matrix.getScaleY());
		visitor.visit(matrix, "HasRotate", matrix.getHasRotate());
		visitor.visit(matrix, "NRotateBits", matrix.getnRotateBits());
		visitor.visit(matrix, "RotateSkew0", matrix.getRotateSkew0());
		visitor.visit(matrix, "RotateSkew1", matrix.getRotateSkew1());
		visitor.visit(matrix, "NTranslateBits", matrix.getnTranslateBits());
		visitor.visit(matrix, "TranslateX", matrix.getTranslateX());
		visitor.visit(matrix, "TranslateY", matrix.getTranslateY());
	}

	/**
	 * Visits a MetaDataTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MetadataTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Metadata", tag.getMetadata());
	}

	/**
	 * Visits a MorphFillStyle object.
	 * 
	 * @param fillStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphFillStyle fillStyle, final ISWFVisitor visitor) {

		if (fillStyle == null) {
			return;
		}

		visitor.visit(fillStyle, "Width", fillStyle.getFillStyleType());
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
		visitor.visit(fillStyle, "BitmapID", fillStyle.getBitmapId());
		visitor.visit(fillStyle, "StartBitmapMatrix", fillStyle.getStartBitmapMatrix());
		visit(fillStyle.getStartBitmapMatrix(), visitor);
		visitor.visit(fillStyle, "EndBitmapMatrix", fillStyle.getEndBitmapMatrix());
		visit(fillStyle.getEndBitmapMatrix(), visitor);
	}

	/**
	 * Visits a MorphFillStyleArray object.
	 * 
	 * @param fillStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphFillStyleArray fillStyles, final ISWFVisitor visitor) {

		if (fillStyles == null) {
			return;
		}

		visitor.visit(fillStyles, "FillStyleCount", fillStyles.getFillStyleCount());
		visitor.visit(fillStyles, "FillStyleCountExtended", fillStyles.getFillStyleCountExtended());
		visitor.visit(fillStyles, "FillStyles", fillStyles.getFillStyles());

		visit(fillStyles.getFillStyles(), visitor);
	}

	/**
	 * Visits a MorphFillStyleList object.
	 * 
	 * @param fillStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphFillStyleList fillStyles, final ISWFVisitor visitor) {

		if (fillStyles == null) {
			return;
		}

		for (final MorphFillStyle fillStyle : fillStyles) {
			visitor.visit(fillStyles, "MorphFillStyle", fillStyle);
			visit(fillStyle, visitor);
		}
	}

	/**
	 * Visits a MorphGradient object.
	 * 
	 * @param gradient The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphGradient gradient, final ISWFVisitor visitor) {

		if (gradient == null) {
			return;
		}

		visitor.visit(gradient, "NumGradients", gradient.getNumGradients());
		visitor.visit(gradient, "GradientRecords", gradient.getGradientRecords());
		visit(gradient.getGradientRecords(), visitor);
	}

	/**
	 * Visits a MorphGradientRecord object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphGradientRecord record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "StartRatio", record.getStartRatio());
		visitor.visit(record, "StartColor", record.getStartColor());
		visit(record.getStartColor(), visitor);
		visitor.visit(record, "EndRatio", record.getEndRatio());
		visitor.visit(record, "EndColor", record.getEndColor());
		visit(record.getEndColor(), visitor);
	}

	/**
	 * Visits a MorphGradientRecordList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphGradientRecordList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final MorphGradientRecord record : list) {
			visitor.visit(list, "GradientRecord", record);
			visit(record, visitor);
		}
	}

	/**
	 * Visits a MorphLineStyle object.
	 * 
	 * @param lineStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphLineStyle lineStyle, final ISWFVisitor visitor) {

		if (lineStyle == null) {
			return;
		}

		visitor.visit(lineStyle, "StartWidth", lineStyle.getStartWidth());
		visitor.visit(lineStyle, "EndWidth", lineStyle.getEndWidth());
		visitor.visit(lineStyle, "StartColor", lineStyle.getStartColor());
		visit(lineStyle.getStartColor(), visitor);
		visitor.visit(lineStyle, "EndColor", lineStyle.getEndColor());
		visit(lineStyle.getEndColor(), visitor);
	}

	/**
	 * Visits a MorphLineStyle2 object.
	 * 
	 * @param lineStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphLineStyle2 lineStyle, final ISWFVisitor visitor) {

		if (lineStyle == null) {
			return;
		}

		visitor.visit(lineStyle, "StartWidth", lineStyle.getStartWidth());
		visitor.visit(lineStyle, "EndWidth", lineStyle.getEndWidth());
		visitor.visit(lineStyle, "StartColor", lineStyle.getStartColor());
		visit(lineStyle.getStartColor(), visitor);
		visitor.visit(lineStyle, "EndColor", lineStyle.getEndColor());
		visit(lineStyle.getEndColor(), visitor);
	}

	/**
	 * Visits a MorphLineStyle2List object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphLineStyle2List lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		for (final MorphLineStyle2 lineStyle : lineStyles) {
			visitor.visit(lineStyles, "MorphLineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	/**
	 * Visits a MorphLineStyleArray object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphLineStyleArray lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		visitor.visit(lineStyles, "LineStyleCount", lineStyles.getLineStyleCount());
		visitor.visit(lineStyles, "LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
		visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

		visit(lineStyles.getLineStyles(), visitor);
	}

	/**
	 * Visits a MorphLineStyleArray2 object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphLineStyleArray2 lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		visitor.visit(lineStyles, "LineStyleCount", lineStyles.getLineStyleCount());
		visitor.visit(lineStyles, "LineStyleCountExtended", lineStyles.getLineStyleCountExtended());
		visitor.visit(lineStyles, "LineStyles", lineStyles.getLineStyles());

		visit(lineStyles.getLineStyles(), visitor);
	}

	/**
	 * Visits a MorphLineStyleList object.
	 * 
	 * @param lineStyles The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final MorphLineStyleList lineStyles, final ISWFVisitor visitor) {

		if (lineStyles == null) {
			return;
		}

		for (final MorphLineStyle lineStyle : lineStyles) {
			visitor.visit(lineStyles, "MorphLineStyle", lineStyle);
			visit(lineStyle, visitor);
		}
	}

	/**
	 * Visits a ParsedINTELementList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ParsedINTElementList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final IParsedINTElement element : list) {

			if (element instanceof UINT8) {
				visitor.visit(list, "Element", (UINT8) element);
			}
			else if (element instanceof UINT16) {
				visitor.visit(list, "Element", (UINT16) element);
			}
			else if (element instanceof UINT32) {
				visitor.visit(list, "Element", (UINT32) element);
			}
			else if (element instanceof INT32) {
				visitor.visit(list, "Element", (INT32) element);
			}
		}
	}

	/**
	 * Visits a PlaceObject2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final PlaceObject2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "PlaceFlagHasClipAction", tag.getPlaceFlagHasClipActions());
		visitor.visit(tag, "PlaceFlagHasClipDepth", tag.getPlaceFlagHasClipDepth());
		visitor.visit(tag, "PlaceFlagHasName", tag.getPlaceFlagHasName());
		visitor.visit(tag, "PlaceFlagHasRatio", tag.getPlaceFlagHasRatio());
		visitor.visit(tag, "PlaceFlagHasColorTransform", tag.getPlaceFlagHasColorTransform());
		visitor.visit(tag, "PlaceFlagHasMatrix", tag.getPlaceFlagHasMatrix());
		visitor.visit(tag, "PlaceFlagHasCharacter", tag.getPlaceFlagHasCharacter());
		visitor.visit(tag, "PlaceFlagHasMove", tag.getPlaceFlagHasMove());
		visitor.visit(tag, "Depth", tag.getDepth());
		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Matrix", tag.getMatrix());
		visit(tag.getMatrix(), visitor);
		visitor.visit(tag, "ColorTransform", tag.getColorTransform());
		visit(tag.getColorTransform(), visitor);
		visitor.visit(tag, "Ratio", tag.getRatio());
		visitor.visit(tag, "Name", tag.getName());
		visitor.visit(tag, "ClipDepth", tag.getClipDepth());
		visitor.visit(tag, "ClipActions", tag.getClipActions());
		visit(tag.getClipActions(), visitor);
	}

	/**
	 * Visits a PlaceObject3Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final PlaceObject3Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "PlaceFlagHasClipAction", tag.getPlaceFlagHasClipActions());
		visitor.visit(tag, "PlaceFlagHasClipDepth", tag.getPlaceFlagHasClipDepth());
		visitor.visit(tag, "PlaceFlagHasName", tag.getPlaceFlagHasName());
		visitor.visit(tag, "PlaceFlagHasRatio", tag.getPlaceFlagHasRatio());
		visitor.visit(tag, "PlaceFlagHasColorTransform", tag.getPlaceFlagHasColorTransform());
		visitor.visit(tag, "PlaceFlagHasMatrix", tag.getPlaceFlagHasMatrix());
		visitor.visit(tag, "PlaceFlagHasCharacter", tag.getPlaceFlagHasCharacter());
		visitor.visit(tag, "PlaceFlagHasMove", tag.getPlaceFlagHasMove());
		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "PlaceFlagHasImage", tag.getPlaceFlagHasImage());
		visitor.visit(tag, "PlaceFlagHasClassName", tag.getPlaceFlagHasClassName());
		visitor.visit(tag, "PlaceFlagHasCacheAsBitmap", tag.getPlaceFlagHasCacheAsBitmap());
		visitor.visit(tag, "PlaceFlagHasBlendMode", tag.getPlaceFlagHasBlendMode());
		visitor.visit(tag, "PlaceFlagHasFilterList", tag.getPlaceFlagHasFilterList());
		visitor.visit(tag, "Depth", tag.getDepth());
		visitor.visit(tag, "ClassName", tag.getClassName());
		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Matrix", tag.getMatrix());
		visit(tag.getMatrix(), visitor);
		visitor.visit(tag, "ColorTransform", tag.getColorTransform());
		visit(tag.getColorTransform(), visitor);
		visitor.visit(tag, "Ratio", tag.getRatio());
		visitor.visit(tag, "Name", tag.getName());
		visitor.visit(tag, "ClipDepth", tag.getClipDepth());
		visitor.visit(tag, "SurfaceFilterList", tag.getSurfaceFilterList());
		visit(tag.getSurfaceFilterList(), visitor);
		visitor.visit(tag, "BlendMode", tag.getBlendMode());
		visitor.visit(tag, "BitmapCache", tag.getBitmapCache());
		visitor.visit(tag, "ClipActions", tag.getClipActions());
		visit(tag.getClipActions(), visitor);
	}

	/**
	 * Visits a PlaceObjectTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final PlaceObjectTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Depth", tag.getDepth());
		visitor.visit(tag, "Matrix", tag.getMatrix());
		visit(tag.getMatrix(), visitor);
		visitor.visit(tag, "ColorTransform", tag.getColorTransform());
		visit(tag.getColorTransform(), visitor);
	}

	/**
	 * Visits a ProtectTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ProtectTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Data", tag.getData());
	}

	/**
	 * Visits a RecordHeader object.
	 * 
	 * @param header The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final RecordHeader header, final ISWFVisitor visitor) {

		if (header == null) {
			return;
		}

		visitor.visit(header, "TagAndLength", header.getTagAndLength());
		visitor.visit(header, "ExtraLength", header.getExtraLength());
	}

	/**
	 * Visits a Rect object.
	 * 
	 * @param rect The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Rect rect, final ISWFVisitor visitor) {

		if (rect == null) {
			return;
		}

		visitor.visit(rect, "NBits", rect.getnBits());
		visitor.visit(rect, "XMin", rect.getxMin());
		visitor.visit(rect, "XMax", rect.getxMax());
		visitor.visit(rect, "YMin", rect.getyMin());
		visitor.visit(rect, "YMax", rect.getyMax());
	}

	/**
	 * Visits a RectList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final RectList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final Rect element : list) {
			visitor.visit(list, "Element", element);
			visit(element, visitor);
		}
	}

	/**
	 * Visits a RemoveObject2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final RemoveObject2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Dept", tag.getDepth());
	}

	/**
	 * Visits a RemoveObjectTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final RemoveObjectTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "CharacterID", tag.getCharacterId());
		visitor.visit(tag, "Dept", tag.getDepth());
	}

	/**
	 * Visits a RGB object.
	 * 
	 * @param value The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final RGB value, final ISWFVisitor visitor) {

		if (value == null) {
			return;
		}

		visitor.visit(value, "Red", value.getRed());
		visitor.visit(value, "Green", value.getGreen());
		visitor.visit(value, "Blue", value.getBlue());
	}

	/**
	 * Visits a RGBA object.
	 * 
	 * @param value The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final RGBA value, final ISWFVisitor visitor) {

		if (value == null) {
			return;
		}

		visitor.visit(value, "Red", value.getRed());
		visitor.visit(value, "Green", value.getGreen());
		visitor.visit(value, "Blue", value.getBlue());
		visitor.visit(value, "Alpha", value.getAlpha());
	}

	/**
	 * Visits a SceneName object.
	 * 
	 * @param sceneName The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SceneName sceneName, final ISWFVisitor visitor) {

		if (sceneName == null) {
			return;
		}

		visitor.visit(sceneName, "Offset", sceneName.getOffset());
		visitor.visit(sceneName, "Name", sceneName.getName());
	}

	/**
	 * Visits a SceneNameList object.
	 * 
	 * @param sceneNames The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SceneNameList sceneNames, final ISWFVisitor visitor) {

		if (sceneNames == null) {
			return;
		}

		for (final SceneName sceneName : sceneNames) {
			visitor.visit(sceneNames, "SceneName", sceneName);
			visit(sceneName, visitor);
		}
	}

	/**
	 * Visits a ScriptLimitsTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ScriptLimitsTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "MaxRecursionDepth", tag.getMaxRecursionDepth());
		visitor.visit(tag, "ScriptTimeoutSeconds", tag.getScriptTimeoutSeconds());
	}

	/**
	 * Visits a SetBackgroundColorTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SetBackgroundColorTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "BackgroundColor", tag.getBackgroundColor());

		visit(tag.getBackgroundColor(), visitor);
	}

	/**
	 * Visits a SetTabIndexTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SetTabIndexTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "DepthColor", tag.getDepth());
		visitor.visit(tag, "TabIndex", tag.getTabIndex());
	}

	/**
	 * Visits a Shape object.
	 * 
	 * @param shape The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Shape shape, final ISWFVisitor visitor) {

		if (shape == null) {
			return;
		}

		visitor.visit(shape, "NumFillBits", shape.getNumFillBits());
		visitor.visit(shape, "NumLineBits", shape.getNumLineBits());
		visitor.visit(shape, "ShapeRecord", shape.getShapeRecord());
		visit(shape.getShapeRecord(), visitor);
	}

	/**
	 * Visits a Shape3 object.
	 * 
	 * @param shape The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Shape3 shape, final ISWFVisitor visitor) {

		if (shape == null) {
			return;
		}

		visitor.visit(shape, "NumFillBits", shape.getNumFillBits());
		visitor.visit(shape, "NumLineBits", shape.getNumLineBits());
		visitor.visit(shape, "ShapeRecord", shape.getShapeRecord());
		visit(shape.getShapeRecord(), visitor);
	}

	/**
	 * Visits a Shape3List object.
	 * 
	 * @param shapeList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Shape3List shapeList, final ISWFVisitor visitor) {

		if (shapeList == null) {
			return;
		}

		for (final Shape3 shape3 : shapeList) {
			visitor.visit(shapeList, "Element", shape3);
			visit(shape3, visitor);
		}
	}

	/**
	 * Visits a ShapeRecordList object.
	 * 
	 * @param shapeRecordList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Shape3RecordList shapeRecordList, final ISWFVisitor visitor) {

		if (shapeRecordList == null) {
			return;
		}

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

	/**
	 * Visits a ShapeList object.
	 * 
	 * @param shapeList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ShapeList shapeList, final ISWFVisitor visitor) {

		if (shapeList == null) {
			return;
		}

		for (final Shape shape : shapeList) {
			visitor.visit(shapeList, "Element", shape);
			visit(shape, visitor);
		}
	}

	/**
	 * Visits a ShapeRecordList object.
	 * 
	 * @param shapeRecordList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ShapeRecordList shapeRecordList, final ISWFVisitor visitor) {

		if (shapeRecordList == null) {
			return;
		}

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

	/**
	 * Visits a ShapeWithStyle object.
	 * 
	 * @param shapeWithStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ShapeWithStyle shapeWithStyle, final ISWFVisitor visitor) {

		if (shapeWithStyle == null) {
			return;
		}

		visitor.visit(shapeWithStyle, "FillStyles", shapeWithStyle.getFillStyles());
		visit(shapeWithStyle.getFillStyles(), visitor);
		visitor.visit(shapeWithStyle, "LineStyles", shapeWithStyle.getLineStyles());
		visit(shapeWithStyle.getLineStyles(), visitor);
		visitor.visit(shapeWithStyle, "NumFillBits", shapeWithStyle.getNumFillBits());
		visitor.visit(shapeWithStyle, "NumLineBits", shapeWithStyle.getNumLineBits());

		final ShapeRecord shapeRecord = shapeWithStyle.getShapeRecord();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (CurvedEdgeRecord) shapeRecord);
			visit((CurvedEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (EndShapeRecord) shapeRecord);
			visit((EndShapeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (StraightEdgeRecord) shapeRecord);
			visit((StraightEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StyleChangeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (StyleChangeRecord) shapeRecord);
			visit((StyleChangeRecord) shapeRecord, visitor);
		}
	}

	/**
	 * Visits a ShapeWithStyle3 object.
	 * 
	 * @param shapeWithStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ShapeWithStyle3 shapeWithStyle, final ISWFVisitor visitor) {

		if (shapeWithStyle == null) {
			return;
		}

		visitor.visit(shapeWithStyle, "FillStyles", shapeWithStyle.getFillStyles());
		visit(shapeWithStyle.getFillStyles(), visitor);
		visitor.visit(shapeWithStyle, "LineStyles", shapeWithStyle.getLineStyles());
		visit(shapeWithStyle.getLineStyles(), visitor);
		visitor.visit(shapeWithStyle, "NumFillBits", shapeWithStyle.getNumFillBits());
		visitor.visit(shapeWithStyle, "NumLineBits", shapeWithStyle.getNumLineBits());

		final Shape3Record shapeRecord = shapeWithStyle.getShapeRecord();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (CurvedEdgeRecord) shapeRecord);
			visit((CurvedEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (EndShapeRecord) shapeRecord);
			visit((EndShapeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (StraightEdgeRecord) shapeRecord);
			visit((StraightEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StyleChangeRecord3) {
			visitor.visit(shapeWithStyle, "ShapeRecord", (StyleChangeRecord3) shapeRecord);
			visit((StyleChangeRecord3) shapeRecord, visitor);
		}
	}

	/**
	 * Visits a ShapeWithStyle4 object.
	 * 
	 * @param shapeWithStyle The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ShapeWithStyle4 shapeWithStyle, final ISWFVisitor visitor) {

		if (shapeWithStyle == null) {
			return;
		}

		visitor.visit(shapeWithStyle, "FillStyles", shapeWithStyle.getFillStyles());
		visit(shapeWithStyle.getFillStyles(), visitor);
		visitor.visit(shapeWithStyle, "LineStyles", shapeWithStyle.getLineStyles());
		visit(shapeWithStyle.getLineStyles(), visitor);
		visitor.visit(shapeWithStyle, "NumFillBits", shapeWithStyle.getNumFillBits());
		visitor.visit(shapeWithStyle, "NumLineBits", shapeWithStyle.getNumLineBits());

		final Shape4Record shapeRecord = shapeWithStyle.getShapeRecord();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			visitor.visit(shapeWithStyle, "CurvedEdgeRecord", (CurvedEdgeRecord) shapeRecord);
			visit((CurvedEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			visitor.visit(shapeWithStyle, "EndShapeRecord", (EndShapeRecord) shapeRecord);
			visit((EndShapeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			visitor.visit(shapeWithStyle, "StraightEdgeRecord", (StraightEdgeRecord) shapeRecord);
			visit((StraightEdgeRecord) shapeRecord, visitor);
		}
		else if (shapeRecord instanceof StyleChangeRecord4) {
			visitor.visit(shapeWithStyle, "StyleChangeRecord", (StyleChangeRecord4) shapeRecord);
			visit((StyleChangeRecord4) shapeRecord, visitor);
		}
	}

	/**
	 * Visits a ShowFrameTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ShowFrameTag tag, final ISWFVisitor visitor) {
		// Nothing to do
	}

	/**
	 * Visits a SingleFilterList object.
	 * 
	 * @param filters The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SingleFilterList filters, final ISWFVisitor visitor) {

		if (filters== null) {
			return;
		}

		for (final Filter filter : filters) {
			visitor.visit(filters, "Filter", filter);
			visit(filter, visitor);
		}
	}

	/**
	 * Visits a SoundEnvelope object.
	 * 
	 * @param envelope The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SoundEnvelope envelope, final ISWFVisitor visitor) {

		if (envelope == null) {
			return;
		}

		visitor.visit(envelope, "Pos44", envelope.getPos44());
		visitor.visit(envelope, "LeftLevel", envelope.getLeftLevel());
		visitor.visit(envelope, "RightLevel", envelope.getRightLevel());
	}

	/**
	 * Visits a EnvelopeList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SoundEnvelopeList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final SoundEnvelope envelope : list) {
			visitor.visit(list, "SoundEnvelope", envelope);
			visit(envelope, visitor);
		}
	}

	/**
	 * Visits a SoundInfo object.
	 * 
	 * @param soundInfo The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SoundInfo soundInfo, final ISWFVisitor visitor) {

		if (soundInfo == null) {
			return;
		}

		visitor.visit(soundInfo, "Reserved", soundInfo.getReserved());
		visitor.visit(soundInfo, "SyncStop", soundInfo.getSyncStop());
		visitor.visit(soundInfo, "SyncNoMultiple", soundInfo.getSyncNoMultiple());
		visitor.visit(soundInfo, "HasEnvelope", soundInfo.getHasEnvelope());
		visitor.visit(soundInfo, "HasLoops", soundInfo.getHasLoops());
		visitor.visit(soundInfo, "HasOutPoint", soundInfo.getHasOutPoint());
		visitor.visit(soundInfo, "HasInPoint", soundInfo.getHasInPoint());
		visitor.visit(soundInfo, "OutPoint", soundInfo.getOutPoint());
		visitor.visit(soundInfo, "InPoint", soundInfo.getInPoint());
		visitor.visit(soundInfo, "LoopCount", soundInfo.getLoopCount());
		visitor.visit(soundInfo, "EnvPoints", soundInfo.getEnvPoints());
		visitor.visit(soundInfo, "EnvelopeRecords", soundInfo.getEnvelopeRecords());
		visit(soundInfo.getEnvelopeRecords(), visitor);
	}

	/**
	 * Visits a SoundStreamBlockTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SoundStreamBlockTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "StreamSoundData", tag.getStreamSoundData());
	}

	/**
	 * Visits a SoundStreamHead2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SoundStreamHead2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "PlaybackSoundRate", tag.getPlaybackSoundRate());
		visitor.visit(tag, "PlaybackSoundSize", tag.getPlaybackSoundSize());
		visitor.visit(tag, "PlaybackSoundType", tag.getPlaybackSoundType());
		visitor.visit(tag, "StreamSoundCompression", tag.getStreamSoundCompression());
		visitor.visit(tag, "StreamSoundRate", tag.getStreamSoundRate());
		visitor.visit(tag, "StreamSoundSize", tag.getStreamSoundSize());
		visitor.visit(tag, "StreamSoundType", tag.getStreamSoundType());
		visitor.visit(tag, "StreamSoundSampleCount", tag.getStreamSoundSampleCount());
		visitor.visit(tag, "LatencySeek", tag.getLatencySeek());
	}

	/**
	 * Visits a SoundStreamHeadTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SoundStreamHeadTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Reserved", tag.getReserved());
		visitor.visit(tag, "PlaybackSoundRate", tag.getPlaybackSoundRate());
		visitor.visit(tag, "PlaybackSoundSize", tag.getPlaybackSoundSize());
		visitor.visit(tag, "PlaybackSoundType", tag.getPlaybackSoundType());
		visitor.visit(tag, "StreamSoundCompression", tag.getStreamSoundCompression());
		visitor.visit(tag, "StreamSoundRate", tag.getStreamSoundRate());
		visitor.visit(tag, "StreamSoundSize", tag.getStreamSoundSize());
		visitor.visit(tag, "StreamSoundType", tag.getStreamSoundType());
		visitor.visit(tag, "StreamSoundSampleCount", tag.getStreamSoundSampleCount());
		visitor.visit(tag, "LatencySeek", tag.getLatencySeek());
	}

	/**
	 * Visits a StartSound2Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final StartSound2Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "SoundClassName", tag.getSoundClassName());
		visitor.visit(tag, "SoundFormat", tag.getSoundInfo());
		visit(tag.getSoundInfo(), visitor);
	}

	/**
	 * Visits a StartSoundTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final StartSoundTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "SoundID", tag.getSoundId());
		visitor.visit(tag, "SoundFormat", tag.getSoundInfo());
		visit(tag.getSoundInfo(), visitor);
	}

	/**
	 * Visits a StraightEdgeRecord object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final StraightEdgeRecord record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "TypeFlag", record.getTypeFlag());
		visitor.visit(record, "StraightFlag", record.getStraightFlag());
		visitor.visit(record, "NumBits", record.getNumBits());
		visitor.visit(record, "GeneralLineFlag", record.getGeneralLineFlag());
		visitor.visit(record, "VertLineFlag", record.getVertLineFlag());
		visitor.visit(record, "DeltaX", record.getDeltaX());
		visitor.visit(record, "DeltaY", record.getDeltaY());
	}

	/**
	 * Visits a StyleChangeRecord object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final StyleChangeRecord record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "TypeFlag", record.getTypeFlag());
		visitor.visit(record, "StateNewStyles", record.getStateNewStyles());
		visitor.visit(record, "StateLineStyle", record.getStateLineStyle());
		visitor.visit(record, "StateFillStyle1", record.getStateFillStyle1());
		visitor.visit(record, "StateFillStyle0", record.getStateFillStyle0());
		visitor.visit(record, "StateMoveTo", record.getStateMoveTo());
		visitor.visit(record, "MoveBits", record.getMoveBits());
		visitor.visit(record, "MoveDeltaX", record.getMoveDeltaX());
		visitor.visit(record, "MoveDeltaY", record.getMoveDeltaY());
		visitor.visit(record, "FillStyle0", record.getFillStyle0());
		visitor.visit(record, "FillStyle1", record.getFillStyle1());
		visitor.visit(record, "LineStyle", record.getLineStyle());
		visitor.visit(record, "FillStyles", record.getFillStyles());
		visit(record.getFillStyles(), visitor);
		visitor.visit(record, "LineStyles", record.getLineStyles());
		visit(record.getLineStyles(), visitor);
		visitor.visit(record, "NumFillBits", record.getNumFillBits());
		visitor.visit(record, "NumLineBits", record.getNumLineBits());
	}

	/**
	 * Visits a StyleChangeRecord3 object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final StyleChangeRecord3 record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "TypeFlag", record.getTypeFlag());
		visitor.visit(record, "StateNewStyles", record.getStateNewStyles());
		visitor.visit(record, "StateLineStyle", record.getStateLineStyle());
		visitor.visit(record, "StateFillStyle1", record.getStateFillStyle1());
		visitor.visit(record, "StateFillStyle0", record.getStateFillStyle0());
		visitor.visit(record, "StateMoveTo", record.getStateMoveTo());
		visitor.visit(record, "MoveBits", record.getMoveBits());
		visitor.visit(record, "MoveDeltaX", record.getMoveDeltaX());
		visitor.visit(record, "MoveDeltaY", record.getMoveDeltaY());
		visitor.visit(record, "FillStyle0", record.getFillStyle0());
		visitor.visit(record, "FillStyle1", record.getFillStyle1());
		visitor.visit(record, "LineStyle", record.getLineStyle());
		visitor.visit(record, "FillStyles", record.getFillStyles());
		visit(record.getFillStyles(), visitor);
		visitor.visit(record, "LineStyles", record.getLineStyles());
		visit(record.getLineStyles(), visitor);
		visitor.visit(record, "NumFillBits", record.getNumFillBits());
		visitor.visit(record, "NumLineBits", record.getNumLineBits());
	}

	/**
	 * Visits a StyleChangeRecord4 object.
	 * 
	 * @param record The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final StyleChangeRecord4 record, final ISWFVisitor visitor) {

		if (record == null) {
			return;
		}

		visitor.visit(record, "TypeFlag", record.getTypeFlag());
		visitor.visit(record, "StateNewStyles", record.getStateNewStyles());
		visitor.visit(record, "StateLineStyle", record.getStateLineStyle());
		visitor.visit(record, "StateFillStyle1", record.getStateFillStyle1());
		visitor.visit(record, "StateFillStyle0", record.getStateFillStyle0());
		visitor.visit(record, "StateMoveTo", record.getStateMoveTo());
		visitor.visit(record, "MoveBits", record.getMoveBits());
		visitor.visit(record, "MoveDeltaX", record.getMoveDeltaX());
		visitor.visit(record, "MoveDeltaY", record.getMoveDeltaY());
		visitor.visit(record, "FillStyle0", record.getFillStyle0());
		visitor.visit(record, "FillStyle1", record.getFillStyle1());
		visitor.visit(record, "LineStyle", record.getLineStyle());
		visitor.visit(record, "FillStyles", record.getFillStyles());
		visit(record.getFillStyles(), visitor);
		visitor.visit(record, "LineStyles", record.getLineStyles());
		visit(record.getLineStyles(), visitor);
		visitor.visit(record, "NumFillBits", record.getNumFillBits());
		visitor.visit(record, "NumLineBits", record.getNumLineBits());
	}

	/**
	 * Visits a SWFFile object.
	 * 
	 * @param file The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SWFFile file, final ISWFVisitor visitor) {

		if (file == null) {
			return;
		}

		visitor.visit(file);

		for (final Tag tag : file.getTags()) {
			visitor.visit(file, tag);

			visit(tag, visitor);
		}
	}

	/**
	 * Visits a Symbol object.
	 * 
	 * @param symbol The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Symbol symbol, final ISWFVisitor visitor) {

		if (symbol == null) {
			return;
		}

		visitor.visit(symbol, "Tag", symbol.getTag());
		visitor.visit(symbol, "Name", symbol.getName());
	}

	/**
	 * Visits a SymbolClassTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SymbolClassTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "NumSymbols", tag.getNumSymbols());
		visitor.visit(tag, "Symbols", tag.getSymbols());
		visit(tag.getSymbols(), visitor);
	}

	/**
	 * Visits a SymbolList object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final SymbolList list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final Symbol element : list) {
			visitor.visit(element, "Symbol", element);
			visit(element, visitor);
		}
	}

	/**
	 * Visits a Tag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final Tag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "Header", tag.getHeader());
		visit(tag.getHeader(), visitor);

		if (tag instanceof CSMTextSettingsTag) {
			visit((CSMTextSettingsTag) tag, visitor);
		}
		else if (tag instanceof DefineBinaryDataTag) {
			visit((DefineBinaryDataTag) tag, visitor);
		}
		else if (tag instanceof DefineBitsJPEG2Tag) {
			visit((DefineBitsJPEG2Tag) tag, visitor);
		}
		else if (tag instanceof DefineBitsJPEG3Tag) {
			visit((DefineBitsJPEG3Tag) tag, visitor);
		}
		else if (tag instanceof DefineBitsJPEG4Tag) {
			visit((DefineBitsJPEG4Tag) tag, visitor);
		}
		else if (tag instanceof DefineBitsLosslessTag) {
			visit((DefineBitsLosslessTag) tag, visitor);
		}
		else if (tag instanceof DefineBitsLossless2Tag) {
			visit((DefineBitsLossless2Tag) tag, visitor);
		}
		else if (tag instanceof DefineBitsTag) {
			visit((DefineBitsTag) tag, visitor);
		}
		else if (tag instanceof DefineButtonTag) {
			visit((DefineButtonTag) tag, visitor);
		}
		else if (tag instanceof DefineButton2Tag) {
			visit((DefineButton2Tag) tag, visitor);
		}
		else if (tag instanceof DefineButtonCxformTag) {
			visit((DefineButtonCxformTag) tag, visitor);
		}
		else if (tag instanceof DefineButtonSoundTag) {
			visit((DefineButtonSoundTag) tag, visitor);
		}
		else if (tag instanceof DefineEditTextTag) {
			visit((DefineEditTextTag) tag, visitor);
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
		else if (tag instanceof DefineFont4Tag) {
			visit((DefineFont4Tag) tag, visitor);
		}
		else if (tag instanceof DefineFontAlignZonesTag) {
			visit((DefineFontAlignZonesTag) tag, visitor);
		}
		else if (tag instanceof DefineFontInfoTag) {
			visit((DefineFontInfoTag) tag, visitor);
		}
		else if (tag instanceof DefineFontInfo2Tag) {
			visit((DefineFontInfo2Tag) tag, visitor);
		}
		else if (tag instanceof DefineFontNameTag) {
			visit((DefineFontNameTag) tag, visitor);
		}
		else if (tag instanceof DefineMorphShapeTag) {
			visit((DefineMorphShapeTag) tag, visitor);
		}
		else if (tag instanceof DefineMorphShape2Tag) {
			visit((DefineMorphShape2Tag) tag, visitor);
		}
		else if (tag instanceof DefineScalingGridTag) {
			visit((DefineScalingGridTag) tag, visitor);
		}
		else if (tag instanceof DefineSceneAndFrameLabelDataTag) {
			visit((DefineSceneAndFrameLabelDataTag) tag, visitor);
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
		else if (tag instanceof DefineSoundTag) {
			visit((DefineSoundTag) tag, visitor);
		}
		else if (tag instanceof DefineSpriteTag) {
			visit((DefineSpriteTag) tag, visitor);
		}
		else if (tag instanceof DefineTextTag) {
			visit((DefineTextTag) tag, visitor);
		}
		else if (tag instanceof DefineText2Tag) {
			visit((DefineText2Tag) tag, visitor);
		}
		else if (tag instanceof DefineVideoStreamTag) {
			visit((DefineVideoStreamTag) tag, visitor);
		}
		else if (tag instanceof DoABCTag) {
			visit((DoABCTag) tag, visitor);
		}
		else if (tag instanceof DoActionTag) {
			visit((DoActionTag) tag, visitor);
		}
		else if (tag instanceof DoInitActionTag) {
			visit((DoInitActionTag) tag, visitor);
		}
		else if (tag instanceof EnableDebuggerTag) {
			visit((EnableDebuggerTag) tag, visitor);
		}
		else if (tag instanceof EnableDebugger2Tag) {
			visit((EnableDebugger2Tag) tag, visitor);
		}
		else if (tag instanceof EndTag) {
			visit((EndTag) tag, visitor);
		}
		else if (tag instanceof ExportAssetsTag) {
			visit((ExportAssetsTag) tag, visitor);
		}
		else if (tag instanceof FileAttributesTag) {
			visit((FileAttributesTag) tag, visitor);
		}
		else if (tag instanceof FrameLabelTag) {
			visit((FrameLabelTag) tag, visitor);
		}
		else if (tag instanceof ImportAssetsTag) {
			visit((ImportAssetsTag) tag, visitor);
		}
		else if (tag instanceof ImportAssets2Tag) {
			visit((ImportAssets2Tag) tag, visitor);
		}
		else if (tag instanceof JPEGTablesTag) {
			visit((JPEGTablesTag) tag, visitor);
		}
		else if (tag instanceof MetadataTag) {
			visit((MetadataTag) tag, visitor);
		}
		else if (tag instanceof PlaceObjectTag) {
			visit((PlaceObjectTag) tag, visitor);
		}
		else if (tag instanceof PlaceObject2Tag) {
			visit((PlaceObject2Tag) tag, visitor);
		}
		else if (tag instanceof PlaceObject3Tag) {
			visit((PlaceObject3Tag) tag, visitor);
		}
		else if (tag instanceof ProtectTag) {
			visit((ProtectTag) tag, visitor);
		}
		else if (tag instanceof RemoveObjectTag) {
			visit((RemoveObjectTag) tag, visitor);
		}
		else if (tag instanceof RemoveObject2Tag) {
			visit((RemoveObject2Tag) tag, visitor);
		}
		else if (tag instanceof ScriptLimitsTag) {
			visit((ScriptLimitsTag) tag, visitor);
		}
		else if (tag instanceof SetBackgroundColorTag) {
			visit((SetBackgroundColorTag) tag, visitor);
		}
		else if (tag instanceof SetTabIndexTag) {
			visit((SetTabIndexTag) tag, visitor);
		}
		else if (tag instanceof ShowFrameTag) {
			visit((ShowFrameTag) tag, visitor);
		}
		else if (tag instanceof SoundStreamBlockTag) {
			visit((SoundStreamBlockTag) tag, visitor);
		}
		else if (tag instanceof SoundStreamHeadTag) {
			visit((SoundStreamHeadTag) tag, visitor);
		}
		else if (tag instanceof SoundStreamHead2Tag) {
			visit((SoundStreamHead2Tag) tag, visitor);
		}
		else if (tag instanceof StartSoundTag) {
			visit((StartSoundTag) tag, visitor);
		}
		else if (tag instanceof StartSound2Tag) {
			visit((StartSound2Tag) tag, visitor);
		}
		else if (tag instanceof SymbolClassTag) {
			visit((SymbolClassTag) tag, visitor);
		}
		else if (tag instanceof VideoFrameTag) {
			visit((VideoFrameTag) tag, visitor);
		}
		else {
			System.out.println(tag);
			System.exit(0);
		}
	}

	/**
	 * Visits a TagList object.
	 * 
	 * @param tags The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final TagList tags, final ISWFVisitor visitor) {

		if (tags == null) {
			return;
		}

		for (final Tag tag : tags) {
			visitor.visit(tags, tag);

			visit(tag, visitor);
		}
	}

	/**
	 * Visits a TextRecord object.
	 * 
	 * @param textRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final TextRecord textRecord, final ISWFVisitor visitor) {

		if (textRecord == null) {
			return;
		}

		visitor.visit(textRecord, "TextRecordType", textRecord.getTextRecordType());
		visitor.visit(textRecord, "StyleFlagsReserved", textRecord.getStyleFlagsReserved());
		visitor.visit(textRecord, "StyleFlagsHasFont", textRecord.getStyleFlagsHasFont());
		visitor.visit(textRecord, "StyleFlagsHasColor", textRecord.getStyleFlagsHasColor());
		visitor.visit(textRecord, "StyleFlagsHasYOffset", textRecord.getStyleFlagsHasYOffset());
		visitor.visit(textRecord, "StyleFlagsHasXOffset", textRecord.getStyleFlagsHasXOffset());
		visitor.visit(textRecord, "FontID", textRecord.getFontId());
		visitor.visit(textRecord, "TextColor", textRecord.getTextColor());
		visit(textRecord.getTextColor(), visitor);
		visitor.visit(textRecord, "XOffset", textRecord.getxOffset());
		visitor.visit(textRecord, "YOffset", textRecord.getyOffset());
		visitor.visit(textRecord, "TextHeight", textRecord.getTextHeight());
		visitor.visit(textRecord, "GlyphCount", textRecord.getGlyphCount());
		visitor.visit(textRecord, "GlyphEntries", textRecord.getGlyphEntries());
		visit(textRecord.getGlyphEntries(), visitor);
	}

	/**
	 * Visits a TextRecord2 object.
	 * 
	 * @param textRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final TextRecord2 textRecord, final ISWFVisitor visitor) {

		if (textRecord == null) {
			return;
		}

		visitor.visit(textRecord, "TextRecordType", textRecord.getTextRecordType());
		visitor.visit(textRecord, "StyleFlagsReserved", textRecord.getStyleFlagsReserved());
		visitor.visit(textRecord, "StyleFlagsHasFont", textRecord.getStyleFlagsHasFont());
		visitor.visit(textRecord, "StyleFlagsHasColor", textRecord.getStyleFlagsHasColor());
		visitor.visit(textRecord, "StyleFlagsHasYOffset", textRecord.getStyleFlagsHasYOffset());
		visitor.visit(textRecord, "StyleFlagsHasXOffset", textRecord.getStyleFlagsHasXOffset());
		visitor.visit(textRecord, "FontID", textRecord.getFontId());
		visitor.visit(textRecord, "TextColor", textRecord.getTextColor());
		visit(textRecord.getTextColor(), visitor);
		visitor.visit(textRecord, "XOffset", textRecord.getxOffset());
		visitor.visit(textRecord, "YOffset", textRecord.getyOffset());
		visitor.visit(textRecord, "TextHeight", textRecord.getTextHeight());
		visitor.visit(textRecord, "GlyphCount", textRecord.getGlyphCount());
		visitor.visit(textRecord, "GlyphEntries", textRecord.getGlyphEntries());
		visit(textRecord.getGlyphEntries(), visitor);
	}

	/**
	 * Visits a TextRecord2List object.
	 * 
	 * @param textRecords The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final TextRecord2List textRecords, final ISWFVisitor visitor) {

		if (textRecords == null) {
			return;
		}

		for (final TextRecord2 textRecord : textRecords) {
			visitor.visit(textRecords, "TextRecord", textRecord);
			visit(textRecord, visitor);
		}
	}

	/**
	 * Visits a TextRecordList object.
	 * 
	 * @param textRecords The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final TextRecordList textRecords, final ISWFVisitor visitor) {

		if (textRecords == null) {
			return;
		}

		for (final TextRecord textRecord : textRecords) {
			visitor.visit(textRecords, "TextRecord", textRecord);
			visit(textRecord, visitor);
		}
	}

	/**
	 * Visits a UINT16List object.
	 * 
	 * @param list The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final UINT16List list, final ISWFVisitor visitor) {

		if (list == null) {
			return;
		}

		for (final UINT16 element : list) {
			visitor.visit(list, "Element", element);
		}
	}

	/**
	 * Visits a VideoFrameTag object.
	 * 
	 * @param tag The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final VideoFrameTag tag, final ISWFVisitor visitor) {

		if (tag == null) {
			return;
		}

		visitor.visit(tag, "StreamID", tag.getStreamId());
		visitor.visit(tag, "FrameNum", tag.getFrameNum());
		visitor.visit(tag, "VideoData", tag.getVideoData());
	}

	/**
	 * Visits a ZoneData object.
	 * 
	 * @param zoneData The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ZoneData zoneData, final ISWFVisitor visitor) {

		if (zoneData == null) {
			return;
		}

		visitor.visit(zoneData, "AlignmentCoordinate", zoneData.getAlignmentCoordinate());
		visitor.visit(zoneData, "Range", zoneData.getRange());
	}

	/**
	 * Visits a ZoneDataList object.
	 * 
	 * @param zoneDataList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ZoneDataList zoneDataList, final ISWFVisitor visitor) {

		if (zoneDataList == null) {
			return;
		}

		for (final ZoneData zoneData : zoneDataList) {

			visitor.visit(zoneDataList, "ZoneData", zoneData);
			visit(zoneData, visitor);
		}
	}

	/**
	 * Visits a ZoneRecord object.
	 * 
	 * @param zoneRecord The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ZoneRecord zoneRecord, final ISWFVisitor visitor) {

		if (zoneRecord == null) {
			return;
		}

		visitor.visit(zoneRecord, "NumZoneData", zoneRecord.getNumZoneData());
		visitor.visit(zoneRecord, "ZoneData", zoneRecord.getZoneData());
		visit(zoneRecord.getZoneData(), visitor);
		visitor.visit(zoneRecord, "Reserved", zoneRecord.getReserved());
		visitor.visit(zoneRecord, "ZoneMaskX", zoneRecord.getZoneMaskX());
		visitor.visit(zoneRecord, "ZoneMaskY", zoneRecord.getZoneMaskY());
	}

	/**
	 * Visits a ZoneRecordList object.
	 * 
	 * @param zoneRecordList The visited object.
	 * @param visitor The visitor that is invoked for all elements of the visited object.
	 */
	public static void visit(final ZoneRecordList zoneRecordList, final ISWFVisitor visitor) {

		if (zoneRecordList == null) {
			return;
		}

		for (final ZoneRecord zoneRecord : zoneRecordList) {

			visitor.visit(zoneRecordList, "ZoneRecord", zoneRecord);
			visit(zoneRecord, visitor);
		}
	}
}