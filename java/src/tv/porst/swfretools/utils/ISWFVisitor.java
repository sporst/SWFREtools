package tv.porst.swfretools.utils;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Float16;
import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.*;
import tv.porst.swfretools.parser.tags.Tag;

/**
 * Interface to be implemented by classes that want to visit all elements
 * of a SWF file.
 */
public interface ISWFVisitor {

	/**
	 * Invoked when an Action value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Action value);

	/**
	 * Invoked when an ActionList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ActionList value);

	/**
	 * Invoked when a AS3Data value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, AS3Data value);

	/**
	 * Invoked when an AsciiString value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, AsciiString value);

	/**
	 * Invoked when a BevelFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, BevelFilter value);

	/**
	 * Invoked when a Bits value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Bits value);

	/**
	 * Invoked when a BlurFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, BlurFilter value);

	/**
	 * Invoked when a ButtonCondAction value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ButtonCondAction value);

	/**
	 * Invoked when a ButtonCondActionList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ButtonCondActionList value);

	/**
	 * Invoked when a ButtonRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ButtonRecord value);

	/**
	 * Invoked when a ButtonRecord2 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ButtonRecord2 value);

	/**
	 * Invoked when a ButtonRecord2List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ButtonRecord2List value);

	/**
	 * Invoked when a ButtonRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ButtonRecordList value);

	/**
	 * Invoked when a ByteArray value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ByteArray value);

	/**
	 * Invoked when a ClipActionRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ClipActionRecord value);

	/**
	 * Invoked when a ClipActionRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ClipActionRecordList value);

	/**
	 * Invoked when a ClipActions value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ClipActions value);

	/**
	 * Invoked when a ClipEventFlags value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ClipEventFlags value);

	/**
	 * Invoked when a ColorMatrixFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ColorMatrixFilter value);

	/**
	 * Invoked when a ConvolutionFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ConvolutionFilter value);

	/**
	 * Invoked when a CurvedEdgeRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, CurvedEdgeRecord value);

	/**
	 * Invoked when a CxForm value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, CxForm value);

	/**
	 * Invoked when a CxFormWithAlpha value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, CxFormWithAlpha value);

	/**
	 * Invoked when a DropShadowFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, DropShadowFilter value);

	/**
	 * Invoked when an EncodedU32 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, EncodedU32 value);

	/**
	 * Invoked when an EndShapeRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, EndShapeRecord value);

	/**
	 * Invoked when a FillStyle value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FillStyle value);

	/**
	 * Invoked when a FillStyle3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FillStyle3 value);

	/**
	 * Invoked when a FillStyle3Array value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FillStyle3Array value);

	/**
	 * Invoked when a FillStyle3List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FillStyle3List value);

	/**
	 * Invoked when a FillStyleArray value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FillStyleArray value);

	/**
	 * Invoked when a FillStyleList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FillStyleList value);

	/**
	 * Invoked when a Filter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Filter value);

	/**
	 * Invoked when a FilterList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FilterList value);

	/**
	 * Invoked when a Fixed value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Fixed value);

	/**
	 * Invoked when a Fixed8 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Fixed8 value);

	/**
	 * Invoked when a Flag value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Flag value);

	/**
	 * Invoked when a Float16 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Float16 value);

	/**
	 * Invoked when a Float32 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Float32 value);

	/**
	 * Invoked when a Float32List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Float32List value);

	/**
	 * Invoked when a FocalGradient value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FocalGradient value);

	/**
	 * Invoked when an FrameLabel value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FrameLabel value);

	/**
	 * Invoked when a FrameLabelList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, FrameLabelList value);

	/**
	 * Invoked when a GlowFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GlowFilter value);

	/**
	 * Invoked when a GlyphEntry value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GlyphEntry value);

	/**
	 * Invoked when a GlyphEntryList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GlyphEntryList value);

	/**
	 * Invoked when a Gradient value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Gradient value);

	/**
	 * Invoked when a Gradient3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Gradient3 value);

	/**
	 * Invoked when a GradientBevelFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GradientBevelFilter value);

	/**
	 * Invoked when a GradientGlowFilter value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GradientGlowFilter value);

	/**
	 * Invoked when a GradRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GradRecord value);

	/**
	 * Invoked when a GradRecord3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GradRecord3 value);

	/**
	 * Invoked when a GradRecord3List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GradRecord3List value);

	/**
	 * Invoked when a GradRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, GradRecordList value);

	/**
	 * Invoked when a INT16 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, INT16 value);

	/**
	 * Invoked when an INT16List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, INT16List value);

	/**
	 * Invoked when a INT32 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, INT32 value);

	/**
	 * Invoked when a KerningRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, KerningRecord value);

	/**
	 * Invoked when a KerningRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, KerningRecordList value);

	/**
	 * Invoked when a LineStyle value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle value);

	/**
	 * Invoked when a LineStyle3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle3 value);

	/**
	 * Invoked when a LineStyle3Array value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle3Array value);

	/**
	 * Invoked when a LineStyle3List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle3List value);

	/**
	 * Invoked when a LineStyle4 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle4 value);

	/**
	 * Invoked when a LineStyle4Array value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle4Array value);

	/**
	 * Invoked when a LineStyle4List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyle4List value);

	/**
	 * Invoked when a LineStyleArray value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyleArray value);

	/**
	 * Invoked when a LineStyleList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, LineStyleList value);

	/**
	 * Invoked when a Matrix value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Matrix value);

	/**
	 * Invoked when a MorphFillStyle value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphFillStyle value);

	/**
	 * Invoked when a MorphFillStyleArray value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphFillStyleArray value);

	/**
	 * Invoked when a MorphFillStyleList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphFillStyleList value);

	/**
	 * Invoked when a MorphGradient value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphGradient value);

	/**
	 * Invoked when a MorphGradientRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphGradientRecord value);

	/**
	 * Invoked when a MorphGradientRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphGradientRecordList value);

	/**
	 * Invoked when a MorphLineStyle value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphLineStyle value);

	/**
	 * Invoked when a MorphLineStyle2 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphLineStyle2 value);

	/**
	 * Invoked when a MorphLineStyle2List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphLineStyle2List value);

	/**
	 * Invoked when a MorphLineStyleArray value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphLineStyleArray value);

	/**
	 * Invoked when a MorphLineStyleArray2 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphLineStyleArray2 value);

	/**
	 * Invoked when a MorphLineStyleList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, MorphLineStyleList value);

	/**
	 * Invoked when a ParsedINTElementList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ParsedINTElementList value);

	/**
	 * Invoked when a RecordHeader value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, RecordHeader value);

	/**
	 * Invoked when a Rect value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Rect value);

	/**
	 * Invoked when a RectList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, RectList value);

	/**
	 * Invoked when an RGB value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, RGB value);

	/**
	 * Invoked when an RGBA value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, RGBA value);

	/**
	 * Invoked when a RGBAList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, RGBAList value);

	/**
	 * Invoked when an SceneName value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SceneName value);

	/**
	 * Invoked when a SceneNameList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SceneNameList value);

	/**
	 * Invoked when a Shape value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Shape value);

	/**
	 * Invoked when a Shape3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Shape3 value);

	/**
	 * Invoked when a Shape3List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Shape3List value);

	/**
	 * Invoked when a Shape3Record value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Shape3Record value);

	/**
	 * Invoked when a Shape3RecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Shape3RecordList value);

	/**
	 * Invoked when a ShapeList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ShapeList value);

	/**
	 * Invoked when a ShapeRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ShapeRecord value);

	/**
	 * Invoked when a ShapeRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ShapeRecordList value);

	/**
	 * Invoked when a ShapeWithStyle value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ShapeWithStyle value);

	/**
	 * Invoked when a ShapeWithStyle3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ShapeWithStyle3 value);

	/**
	 * Invoked when a ShapeWithStyle4 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ShapeWithStyle4 value);

	/**
	 * Invoked when a SingleFilterList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SingleFilterList value);

	/**
	 * Invoked when a SoundEnvelope value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SoundEnvelope value);

	/**
	 * Invoked when a SoundEnvelopeList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SoundEnvelopeList value);

	/**
	 * Invoked when a SoundInfo value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SoundInfo value);

	/**
	 * Invoked when a StraightEdgeRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, StraightEdgeRecord value);

	/**
	 * Invoked when a StyleChangeRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, StyleChangeRecord value);

	/**
	 * Invoked when a StyleChangeRecord3 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, StyleChangeRecord3 value);

	/**
	 * Invoked when a StyleChangeRecord4 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, StyleChangeRecord4 value);

	/**
	 * Invoked when a Symbol value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, Symbol value);

	/**
	 * Invoked when a SymbolList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, SymbolList value);

	/**
	 * Invoked when a TagList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, TagList value);

	/**
	 * Invoked when a TextRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, TextRecord value);

	/**
	 * Invoked when a TextRecord2 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, TextRecord2 value);

	/**
	 * Invoked when a TextRecord2List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, TextRecord2List value);

	/**
	 * Invoked when a TextRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, TextRecordList value);

	/**
	 * Invoked when a UBits value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, UBits value);

	/**
	 * Invoked when a UINT16 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, UINT16 value);

	/**
	 * Invoked when a UINT16List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, UINT16List value);

	/**
	 * Invoked when a UINT32 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, UINT32 value);

	/**
	 * Invoked when a UINT8 value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, UINT8 value);

	/**
	 * Invoked when a UINT8List value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, UINT8List value);

	/**
	 * Invoked when a ZoneData value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ZoneData value);

	/**
	 * Invoked when a ZoneDataList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ZoneDataList value);

	/**
	 * Invoked when a ZoneRecord value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ZoneRecord value);

	/**
	 * Invoked when a ZoneRecordList value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param name The name of the value.
	 * @param value The value.
	 */
	void visit(Object parent, String name, ZoneRecordList value);

	/**
	 * Invoked when a Tag value is encountered.
	 * 
	 * @param parent The parent element of the value.
	 * @param value The value.
	 */
	void visit(Object parent, Tag value);

	/**
	 * Invoked when a SWFFile value is encountered.
	 * 
	 * @param value The value.
	 */
	void visit(SWFFile value);
}
