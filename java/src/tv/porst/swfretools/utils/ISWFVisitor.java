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
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.BevelFilter;
import tv.porst.swfretools.parser.structures.BlurFilter;
import tv.porst.swfretools.parser.structures.ButtonCondAction;
import tv.porst.swfretools.parser.structures.ButtonCondActionList;
import tv.porst.swfretools.parser.structures.ButtonRecord2;
import tv.porst.swfretools.parser.structures.ButtonRecord2List;
import tv.porst.swfretools.parser.structures.ByteArray;
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
import tv.porst.swfretools.parser.structures.Fixed;
import tv.porst.swfretools.parser.structures.Fixed8;
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
import tv.porst.swfretools.parser.structures.SymbolList;
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
import tv.porst.swfretools.parser.tags.Tag;

public interface ISWFVisitor {

	void visit(Object parent, String name, Action value);

	void visit(Object parent, String name, ActionList value);

	void visit(Object parent, String name, BevelFilter value);

	void visit(Object parent, String name, BlurFilter value);

	void visit(Object parent, String name, ButtonCondAction value);

	void visit(Object parent, String name, ButtonCondActionList value);

	void visit(Object parent, String name, ButtonRecord2 value);

	void visit(Object parent, String name, ButtonRecord2List value);

	void visit(Object parent, String name, ClipActionRecord value);

	void visit(Object parent, String name, ClipActionRecordList value);

	void visit(Object parent, String name, ClipActions value);

	void visit(Object parent, String name, ClipEventFlags value);

	void visit(Object parent, String name, ColorMatrixFilter value);

	void visit(Object parent, String name, ConvolutionFilter value);

	void visit(Object parent, String name, CurvedEdgeRecord value);

	void visit(Object parent, String name, CxFormWithAlpha value);

	void visit(Object parent, String name, DropShadowFilter value);

	void visit(Object parent, String name, EndShapeRecord value);

	void visit(Object parent, String name, FillStyle value);

	void visit(Object parent, String name, FillStyle3 value);

	void visit(Object parent, String name, FillStyle3Array value);

	void visit(Object parent, String name, FillStyle3List value);

	void visit(Object parent, String name, FillStyleArray fillStyles);

	void visit(Object parent, String name, FillStyleList value);

	void visit(Object parent, String name, Filter value);

	void visit(Object parent, String name, FilterList value);

	void visit(Object parent, String name, FocalGradient value);

	void visit(Object parent, String name, GlowFilter value);

	void visit(Object parent, String name, GlyphEntry value);

	void visit(Object parent, String name, GlyphEntryList value);

	void visit(Object parent, String name, Gradient value);

	void visit(Object parent, String name, Gradient3 value);

	void visit(Object parent, String name, GradientBevelFilter value);

	void visit(Object parent, String name, GradientGlowFilter value);

	void visit(Object parent, String name, GradRecord value);

	void visit(Object parent, String name, GradRecord3 value);

	void visit(Object parent, String name, GradRecord3List value);

	void visit(Object parent, String name, GradRecordList value);

	void visit(Object parent, String name, INT16List value);

	void visit(Object parent, String name, KerningRecord value);

	void visit(Object parent, String name, KerningRecordList value);

	void visit(Object parent, String name, LineStyle value);

	void visit(Object parent, String name, LineStyle3 value);

	void visit(Object parent, String name, LineStyle3Array value);

	void visit(Object parent, String name, LineStyle3List value);

	void visit(Object parent, String name, LineStyle4 value);

	void visit(Object parent, String name, LineStyle4Array value);

	void visit(Object parent, String name, LineStyle4List value);

	void visit(Object parent, String name, LineStyleArray fillStyles);

	void visit(Object parent, String name, LineStyleList value);

	void visit(Object parent, String name, Matrix value);

	void visit(Object parent, String name, MorphFillStyle value);

	void visit(Object parent, String name, MorphFillStyleArray value);

	void visit(Object parent, String name, MorphFillStyleList value);

	void visit(Object parent, String name, MorphGradient value);

	void visit(Object parent, String name, MorphGradientRecord value);

	void visit(Object parent, String name, MorphGradientRecordList value);

	void visit(Object parent, String name, MorphLineStyle value);

	void visit(Object parent, String name, MorphLineStyleArray value);

	void visit(Object parent, String name, MorphLineStyleList value);

	void visit(Object parent, String name, ParsedINTElementList value);

	void visit(Object parent, String name, Rect value);

	void visit(Object parent, String name, RectList value);

	void visit(Object parent, String name, RGB value);

	void visit(Object parent, String name, RGBA value);

	void visit(Object parent, String name, Shape value);

	void visit(Object parent, String name, Shape3 value);

	void visit(Object parent, String name, Shape3List value);

	void visit(Object parent, String name, Shape3Record value);

	void visit(Object parent, String name, Shape3RecordList value);

	void visit(Object parent, String name, ShapeList value);

	void visit(Object parent, String name, ShapeRecord value);

	void visit(Object parent, String name, ShapeRecordList value);

	void visit(Object parent, String name, ShapeWithStyle value);

	void visit(Object parent, String name, ShapeWithStyle3 value);

	void visit(Object parent, String name, ShapeWithStyle4 value);

	void visit(Object parent, String name, SingleFilterList value);

	void visit(Object parent, String name, SoundEnvelope value);

	void visit(Object parent, String name, SoundEnvelopeList value);

	void visit(Object parent, String name, SoundInfo value);

	void visit(Object parent, String name, StraightEdgeRecord value);

	void visit(Object parent, String name, StyleChangeRecord value);

	void visit(Object parent, String name, StyleChangeRecord3 value);

	void visit(Object parent, String name, StyleChangeRecord4 value);

	void visit(Object parent, String name, SymbolList assets);

	void visit(Object parent, String name, TagList value);

	void visit(Object parent, String name, TextRecord value);

	void visit(Object parent, String name, TextRecord2 value);

	void visit(Object parent, String name, TextRecord2List value);

	void visit(Object parent, String name, TextRecordList value);

	void visit(Object parent, String name, UINT16List value);

	void visit(Object parent, String name, ZoneData value);

	void visit(Object parent, String name, ZoneDataList value);

	void visit(Object parent, String name, ZoneRecord value);

	void visit(Object parent, String name, ZoneRecordList value);

	void visit(Object parent, Tag tag);

	void visit(String name, AsciiString value);

	void visit(String name, Bits value);

	void visit(String name, ByteArray value);

	void visit(String name, Fixed value);

	void visit(String name, Fixed8 value);

	void visit(String name, Flag value);

	void visit(String name, Float16 value);

	void visit(String name, Float32 value);

	void visit(String name, INT16 value);

	void visit(String name, INT32 value);

	void visit(String name, UBits value);

	void visit(String name, UINT16 value);

	void visit(String name, UINT32 value);

	void visit(String name, UINT8 value);

	void visit(SWFFile file);

}
