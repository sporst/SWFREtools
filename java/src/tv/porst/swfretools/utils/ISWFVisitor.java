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
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.ClipActionRecord;
import tv.porst.swfretools.parser.structures.ClipActionRecordList;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.ClipEventFlags;
import tv.porst.swfretools.parser.structures.CurvedEdgeRecord;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.EndShapeRecord;
import tv.porst.swfretools.parser.structures.FillStyle;
import tv.porst.swfretools.parser.structures.FillStyle3;
import tv.porst.swfretools.parser.structures.FillStyle3Array;
import tv.porst.swfretools.parser.structures.FillStyle3List;
import tv.porst.swfretools.parser.structures.FillStyleArray;
import tv.porst.swfretools.parser.structures.FillStyleList;
import tv.porst.swfretools.parser.structures.Fixed8;
import tv.porst.swfretools.parser.structures.FocalGradient;
import tv.porst.swfretools.parser.structures.GlyphEntry;
import tv.porst.swfretools.parser.structures.GlyphEntryList;
import tv.porst.swfretools.parser.structures.GradRecord;
import tv.porst.swfretools.parser.structures.GradRecordList;
import tv.porst.swfretools.parser.structures.Gradient;
import tv.porst.swfretools.parser.structures.INT16List;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordList;
import tv.porst.swfretools.parser.structures.LineStyle;
import tv.porst.swfretools.parser.structures.LineStyle4;
import tv.porst.swfretools.parser.structures.LineStyle4Array;
import tv.porst.swfretools.parser.structures.LineStyle4List;
import tv.porst.swfretools.parser.structures.LineStyleArray;
import tv.porst.swfretools.parser.structures.LineStyleList;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectList;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.structures.Shape3;
import tv.porst.swfretools.parser.structures.Shape3List;
import tv.porst.swfretools.parser.structures.ShapeWithStyle;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;
import tv.porst.swfretools.parser.structures.StraightEdgeRecord;
import tv.porst.swfretools.parser.structures.StyleChangeRecord;
import tv.porst.swfretools.parser.structures.StyleChangeRecord3;
import tv.porst.swfretools.parser.structures.SymbolList;
import tv.porst.swfretools.parser.structures.TagList;
import tv.porst.swfretools.parser.structures.TextRecord;
import tv.porst.swfretools.parser.structures.TextRecordList;
import tv.porst.swfretools.parser.structures.ZoneData;
import tv.porst.swfretools.parser.structures.ZoneDataList;
import tv.porst.swfretools.parser.structures.ZoneRecord;
import tv.porst.swfretools.parser.structures.ZoneRecordList;
import tv.porst.swfretools.parser.tags.Tag;

public interface ISWFVisitor {

	void visit(Object parent, String name, Action value);

	void visit(Object parent, String name, ActionList value);

	void visit(Object parent, String name, ClipActionRecord value);

	void visit(Object parent, String name, ClipActionRecordList value);

	void visit(Object parent, String name, ClipActions value);

	void visit(Object parent, String name, ClipEventFlags value);

	void visit(Object parent, String name, CurvedEdgeRecord value);

	void visit(Object parent, String name, CxFormWithAlpha value);

	void visit(Object parent, String name, EndShapeRecord value);

	void visit(Object parent, String name, FillStyle value);

	void visit(Object parent, String name, FillStyle3 value);

	void visit(Object parent, String name, FillStyle3Array value);

	void visit(Object parent, String name, FillStyle3List value);

	void visit(Object parent, String name, FillStyleArray fillStyles);

	void visit(Object parent, String name, FillStyleList value);

	void visit(Object parent, String name, FocalGradient value);

	void visit(Object parent, String name, GlyphEntry value);

	void visit(Object parent, String name, GlyphEntryList value);

	void visit(Object parent, String name, Gradient value);

	void visit(Object parent, String name, GradRecord value);

	void visit(Object parent, String name, GradRecordList value);

	void visit(Object parent, String name, INT16List value);

	void visit(Object parent, String name, KerningRecord value);

	void visit(Object parent, String name, KerningRecordList value);

	void visit(Object parent, String name, LineStyle value);

	void visit(Object parent, String name, LineStyle4 value);

	void visit(Object parent, String name, LineStyle4Array value);

	void visit(Object parent, String name, LineStyle4List value);

	void visit(Object parent, String name, LineStyleArray fillStyles);

	void visit(Object parent, String name, LineStyleList value);

	void visit(Object parent, String name, Matrix value);

	void visit(Object parent, String name, ParsedINTElementList value);

	void visit(Object parent, String name, Rect value);

	void visit(Object parent, String name, RectList value);

	void visit(Object parent, String name, RGB value);

	void visit(Object parent, String name, RGBA value);

	void visit(Object parent, String name, Shape3 value);

	void visit(Object parent, String name, Shape3List value);

	void visit(Object parent, String name, ShapeWithStyle value);

	void visit(Object parent, String name, ShapeWithStyle4 value);

	void visit(Object parent, String name, StraightEdgeRecord value);

	void visit(Object parent, String name, StyleChangeRecord value);

	void visit(Object parent, String name, StyleChangeRecord3 value);

	void visit(Object parent, String name, SymbolList assets);

	void visit(Object parent, String name, TagList value);

	void visit(Object parent, String name, TextRecord value);

	void visit(Object parent, String name, TextRecordList value);

	void visit(Object parent, String name, ZoneData value);

	void visit(Object parent, String name, ZoneDataList value);

	void visit(Object parent, String name, ZoneRecord value);

	void visit(Object parent, String name, ZoneRecordList value);

	void visit(Object parent, Tag tag);

	void visit(String name, AsciiString value);

	void visit(String name, Bits value);

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
