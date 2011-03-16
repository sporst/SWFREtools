package tv.porst.swfretools.dissector.gui.main.flashtree;

import javax.swing.tree.DefaultMutableTreeNode;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Float16;
import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.INT64;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.*;
import tv.porst.swfretools.parser.actions.Action;
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
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.DropShadowFilter;
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
import tv.porst.swfretools.parser.structures.GlowFilter;
import tv.porst.swfretools.parser.structures.GlyphEntry;
import tv.porst.swfretools.parser.structures.GlyphEntryList;
import tv.porst.swfretools.parser.structures.GradRecord;
import tv.porst.swfretools.parser.structures.GradRecord3;
import tv.porst.swfretools.parser.structures.GradRecord3List;
import tv.porst.swfretools.parser.structures.GradRecordList;
import tv.porst.swfretools.parser.structures.GradientBevelFilter;
import tv.porst.swfretools.parser.structures.GradientGlowFilter;
import tv.porst.swfretools.parser.structures.IGradient;
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
import tv.porst.swfretools.parser.structures.MorphLineStyle2;
import tv.porst.swfretools.parser.structures.MorphLineStyle2List;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;
import tv.porst.swfretools.parser.structures.MorphLineStyleList;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.Shape;
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
import tv.porst.swfretools.parser.structures.Symbol;
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

public class FlashTreeNode<T> extends DefaultMutableTreeNode {

	private final String name;

	public FlashTreeNode(final String name, final T userObject) {
		super(userObject);

		this.name = name;
	}

	protected void addNode(final String name, final Action value) {
		if (value != null) {
			add(new FlashActionNode(name, value));
		}
	}

	protected void addNode(final String name, final ActionList value) {
		if (value != null) {
			add(new FlashActionListNode(name, value));
		}
	}

	protected void addNode(final String name, final AsciiString value) {
		if (value != null) {
			add(new FlashAsciiStringNode(name, value));
		}
	}

	protected void addNode(final String name, final BevelFilter value) {
		if (value != null) {
			add(new FlashBevelFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final Bits value) {
		if (value != null) {
			add(new FlashBitsNode(name, value));
		}
	}

	protected void addNode(final String name, final BlurFilter value) {
		if (value != null) {
			add(new FlashBlurFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final ButtonCondAction value) {
		if (value != null) {
			add(new FlashButtonCondActionNode(name, value));
		}
	}

	protected void addNode(final String name, final ButtonCondActionList value) {
		if (value != null) {
			add(new FlashButtonCondActionListNode(name, value));
		}
	}

	protected void addNode(final String name, final ButtonRecord2 value) {
		if (value != null) {
			add(new FlashButtonRecord2Node(name, value));
		}
	}

	protected void addNode(final String name, final ButtonRecord2List value) {
		if (value != null) {
			add(new FlashButtonRecord2ListNode(name, value));
		}
	}

	protected void addNode(final String name, final ByteArray value) {
		if (value != null) {
			add(new FlashByteArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final ClipActionRecord value) {
		if (value != null) {
			add(new FlashClipActionRecordNode(name, value));
		}
	}

	protected void addNode(final String name, final ClipActionRecordList value) {
		if (value != null) {
			add(new FlashClipActionRecordListNode(name, value));
		}
	}

	protected void addNode(final String name, final ClipActions value) {
		if (value != null) {
			add(new FlashClipActionsNode(name, value));
		}
	}

	protected void addNode(final String name, final ClipEventFlags value) {
		if (value != null) {
			add(new FlashClipEventFlagsNode(name, value));
		}
	}

	protected void addNode(final String name, final ColorMatrixFilter value) {
		if (value != null) {
			add(new FlashColorMatrixFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final ConvolutionFilter value) {
		if (value != null) {
			add(new FlashConvolutionFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final CxForm value) {
		if (value != null) {
			add(new FlashCxFormNode(name, value));
		}
	}

	protected void addNode(final String name, final CxFormWithAlpha value) {
		if (value != null) {
			add(new FlashCxFormWithAlphaNode(name, value));
		}
	}

	protected void addNode(final String name, final DropShadowFilter value) {
		if (value != null) {
			add(new FlashDropShadowFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final FillStyle value) {
		if (value != null) {
			add(new FlashFillStyleNode(name, value));
		}
	}

	protected void addNode(final String name, final FillStyle3 value) {
		if (value != null) {
			add(new FlashFillStyle3Node(name, value));
		}
	}

	protected void addNode(final String name, final FillStyle3Array value) {
		if (value != null) {
			add(new FlashFillStyle3ArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final FillStyle3List value) {
		if (value != null) {
			add(new FlashFillStyle3ListNode(name, value));
		}
	}

	protected void addNode(final String name, final FillStyleArray value) {
		if (value != null) {
			add(new FlashFillStyleArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final FillStyleList value) {
		if (value != null) {
			add(new FlashFillStyleListNode(name, value));
		}
	}

	protected void addNode(final String name, final Filter value) {
		if (value != null) {
			add(new FlashFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final FilterList value) {
		if (value != null) {
			add(new FlashFilterListNode(name, value));
		}
	}

	protected void addNode(final String name, final Fixed value) {
		if (value != null) {
			add(new FlashFixedNode(name, value));
		}
	}

	protected void addNode(final String name, final Fixed8 value) {
		if (value != null) {
			add(new FlashFixed8Node(name, value));
		}
	}

	protected void addNode(final String name, final Flag value) {
		if (value != null) {
			add(new FlashFlagNode(name, value));
		}
	}

	protected void addNode(final String name, final Float16 value) {
		if (value != null) {
			add(new FlashFloat16Node(name, value));
		}
	}

	protected void addNode(final String name, final Float32 value) {
		if (value != null) {
			add(new FlashFloat32Node(name, value));
		}
	}

	protected void addNode(final String name, final Float32[] value) {
		if (value != null) {
			add(new FlashFloat32ArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final GlowFilter value) {
		if (value != null) {
			add(new FlashGlowFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final GlyphEntry value) {
		if (value != null) {
			add(new FlashGlyphEntryNode(name, value));
		}
	}

	protected void addNode(final String name, final GlyphEntryList value) {
		if (value != null) {
			add(new FlashGlyphEntryListNode(name, value));
		}
	}

	protected void addNode(final String name, final GradientBevelFilter value) {
		if (value != null) {
			add(new FlashGradientBevelFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final GradientGlowFilter value) {
		if (value != null) {
			add(new FlashGradientGlowFilterNode(name, value));
		}
	}

	protected void addNode(final String name, final GradRecord value) {
		if (value != null) {
			add(new FlashGradRecordNode(name, value));
		}
	}

	protected void addNode(final String name, final GradRecord3 value) {
		if (value != null) {
			add(new FlashGradRecord3Node(name, value));
		}
	}

	protected void addNode(final String name, final GradRecord3List value) {
		if (value != null) {
			add(new FlashGradRecord3ListNode(name, value));
		}
	}

	protected void addNode(final String name, final GradRecordList value) {
		if (value != null) {
			add(new FlashGradRecordListNode(name, value));
		}
	}

	protected void addNode(final String name, final IGradient value) {
		if (value != null) {
			add(new FlashGradientNode(name, value));
		}
	}

	protected void addNode(final String name, final INT16 value) {
		if (value != null) {
			add(new FlashINT16Node(name, value));
		}
	}

	protected void addNode(final String name, final INT32 value) {
		if (value != null) {
			add(new FlashINT32Node(name, value));
		}
	}

	protected void addNode(final String name, final IParsedINTElement value) {
		if (value != null) {
			if (value instanceof UINT8) {
				addNode(name, (UINT8) value);
			}
			else if (value instanceof UINT16) {
				addNode(name, (UINT16) value);
			}
			else if (value instanceof UINT32) {
				addNode(name, (UINT32) value);
			}
			else if (value instanceof INT32) {
				addNode(name, (INT32) value);
			}
			else if (value instanceof INT64) {
				addNode(name, value);
			}
			else {
				throw new IllegalStateException("Error: Unknown int element");
			}
		}
	}

	protected void addNode(final String name, final LineStyle value) {
		if (value != null) {
			add(new FlashLineStyleNode(name, value));
		}
	}

	protected void addNode(final String name, final LineStyle3 value) {
		if (value != null) {
			add(new FlashLineStyle3Node(name, value));
		}
	}

	protected void addNode(final String name, final LineStyle3Array value) {
		if (value != null) {
			add(new FlashLineStyle3ArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final LineStyle3List value) {
		if (value != null) {
			add(new FlashLineStyle3ListNode(name, value));
		}
	}

	protected void addNode(final String name, final LineStyle4 value) {
		if (value != null) {
			add(new FlashLineStyle4Node(name, value));
		}
	}

	protected void addNode(final String name, final LineStyle4Array value) {
		if (value != null) {
			add(new FlashLineStyle4ArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final LineStyle4List value) {
		if (value != null) {
			add(new FlashLineStyle4ListNode(name, value));
		}
	}

	protected void addNode(final String name, final LineStyleArray value) {
		if (value != null) {
			add(new FlashLineStyleArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final LineStyleList value) {
		if (value != null) {
			add(new FlashLineStyleListNode(name, value));
		}
	}

	protected void addNode(final String name, final Matrix value) {
		if (value != null) {
			add(new FlashMatrixNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphFillStyle value) {
		if (value != null) {
			add(new FlashMorphFillStyleNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphFillStyleArray value) {
		if (value != null) {
			add(new FlashMorphFillStyleArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphFillStyleList value) {
		if (value != null) {
			add(new FlashMorphFillStyleListNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphGradient value) {
		if (value != null) {
			add(new FlashMorphGradientNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphGradientRecord value) {
		if (value != null) {
			add(new FlashMorphGradientRecordNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphGradientRecordList value) {
		if (value != null) {
			add(new FlashMorphGradientRecordListNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphLineStyle value) {
		if (value != null) {
			add(new FlashMorphLineStyleNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphLineStyle2 value) {
		if (value != null) {
			add(new FlashMorphLineStyle2Node(name, value));
		}
	}

	protected void addNode(final String name, final MorphLineStyle2List value) {
		if (value != null) {
			add(new FlashMorphLineStyle2ListNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphLineStyleArray value) {
		if (value != null) {
			add(new FlashMorphLineStyleArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphLineStyleArray2 value) {
		if (value != null) {
			add(new FlashMorphLineStyle2ArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final MorphLineStyleList value) {
		if (value != null) {
			add(new FlashMorphLineStyleListNode(name, value));
		}
	}

	protected void addNode(final String name, final ParsedINTElementList value) {
		if (value != null) {
			add(new FlashParsedINTElementListNode(name, value));
		}
	}

	protected void addNode(final String name, final RecordHeader value) {
		if (value != null) {
			add(new FlashRecordHeaderNode(name, value));
		}
	}

	protected void addNode(final String name, final Rect value) {
		if (value != null) {
			add(new FlashRectNode(name, value));
		}
	}

	protected void addNode(final String name, final RGB value) {
		if (value != null) {
			add(new FlashRGBNode(name, value));
		}
	}

	protected void addNode(final String name, final RGBA value) {
		if (value != null) {
			add(new FlashRGBANode(name, value));
		}
	}

	protected void addNode(final String name, final RGBA[] value) {
		if (value != null) {
			add(new FlashRGBAArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final Shape value) {
		if (value != null) {
			add(new FlashShapeNode(name, value));
		}
	}

	protected void addNode(final String name, final Shape3Record value) {
		if (value != null) {
			add(new FlashShapeRecord3Node(name, value));
		}
	}

	protected void addNode(final String name, final Shape3RecordList value) {
		if (value != null) {
			add(new FlashShapeRecord3ListNode(name, value));
		}
	}

	protected void addNode(final String name, final ShapeList value) {
		if (value != null) {
			add(new FlashShapeListNode(name, value));
		}
	}

	protected void addNode(final String name, final ShapeRecord value) {
		if (value != null) {
			add(new FlashShapeRecordNode(name, value));
		}
	}

	protected void addNode(final String name, final ShapeRecordList value) {
		if (value != null) {
			add(new FlashShapeRecordListNode(name, value));
		}
	}

	protected void addNode(final String name, final ShapeWithStyle value) {
		if (value != null) {
			add(new FlashShapeWithStyleNode(name, value));
		}
	}

	protected void addNode(final String name, final ShapeWithStyle3 value) {
		if (value != null) {
			add(new FlashShapeWithStyle3Node(name, value));
		}
	}

	protected void addNode(final String name, final ShapeWithStyle4 value) {
		if (value != null) {
			add(new FlashShapeWithStyle4Node(name, value));
		}
	}

	protected void addNode(final String name, final SingleFilterList value) {
		if (value != null) {
			add(new FlashSingleFilterListNode(name, value));
		}
	}

	protected void addNode(final String name, final SoundEnvelope value) {
		if (value != null) {
			add(new FlashSoundEnvelopeNode(name, value));
		}
	}

	protected void addNode(final String name, final SoundEnvelopeList value) {
		if (value != null) {
			add(new FlashSoundEnvelopeListNode(name, value));
		}
	}

	protected void addNode(final String name, final SoundInfo value) {
		if (value != null) {
			add(new FlashSoundInfoNode(name, value));
		}
	}

	protected void addNode(final String name, final Symbol value) {
		if (value != null) {
			add(new FlashSymbolNode(name, value));
		}
	}

	protected void addNode(final String name, final SymbolList value) {
		if (value != null) {
			add(new FlashSymbolListNode(name, value));
		}
	}

	protected void addNode(final String name, final Tag value) {
		if (value != null) {
			add(new FlashTagNode(value));
		}
	}

	protected void addNode(final String name, final TagList value) {
		if (value != null) {
			add(new FlashTagListNode(name, value));
		}
	}

	protected void addNode(final String name, final TextRecord value) {
		if (value != null) {
			add(new FlashTextRecordNode(name, value));
		}
	}

	protected void addNode(final String name, final TextRecord2 value) {
		if (value != null) {
			add(new FlashTextRecord2Node(name, value));
		}
	}

	protected void addNode(final String name, final TextRecord2List value) {
		if (value != null) {
			add(new FlashTextRecord2ListNode(name, value));
		}
	}

	protected void addNode(final String name, final TextRecordList value) {
		if (value != null) {
			add(new FlashTextRecordListNode(name, value));
		}
	}

	protected void addNode(final String name, final UBits value) {
		if (value != null) {
			add(new FlashUBitsNode(name, value));
		}
	}

	protected void addNode(final String name, final UINT16 value) {
		if (value != null) {
			add(new FlashUINT16Node(name, value));
		}
	}

	protected void addNode(final String name, final UINT16List value) {
		if (value != null) {
			add(new FlashUINT16ListNode(name, value));
		}
	}

	protected void addNode(final String name, final UINT32 value) {
		if (value != null) {
			add(new FlashUINT32Node(name, value));
		}
	}

	protected void addNode(final String name, final UINT8 value) {
		if (value != null) {
			add(new FlashUINT8Node(name, value));
		}
	}

	protected void addNode(final String name, final UINT8[] value) {
		if (value != null) {
			add(new FlashUINT8ArrayNode(name, value));
		}
	}

	protected void addNode(final String name, final ZoneData value) {
		if (value != null) {
			add(new FlashZoneDataNode(name, value));
		}
	}

	protected void addNode(final String name, final ZoneDataList value) {
		if (value != null) {
			add(new FlashZoneDataListNode(name, value));
		}
	}

	protected void addNode(final String name, final ZoneRecord value) {
		if (value != null) {
			add(new FlashZoneRecordNode(name, value));
		}
	}

	protected void addNode(final String name, final ZoneRecordList value) {
		if (value != null) {
			add(new FlashZoneRecordListNode(name, value));
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public T getUserObject() {
		return (T) super.getUserObject();
	}

}
