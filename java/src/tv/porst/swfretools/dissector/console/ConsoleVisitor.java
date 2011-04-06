package tv.porst.swfretools.dissector.console;

import java.io.File;
import java.io.PrintStream;
import java.util.Stack;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Float16;
import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.splib.strings.StringHelpers;
import tv.porst.swfretools.Constants;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.*;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.utils.ISWFVisitor;
import tv.porst.swfretools.utils.TagNames;

public class ConsoleVisitor implements ISWFVisitor {

	private final File file;

	private final PrintStream output = System.out;

	private final Stack<Object> stack = new Stack<Object>();

	public ConsoleVisitor(final File file) {
		this.file = file;
	}

	private String getPadding() {
		return StringHelpers.repeat("  ", stack.size() - 1);
	}

	private void handleList(final Object parent, final String name, final ElementList<?> value) {

		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition(), 0, name, value.size());

			stack.push(value);
		}
	}

	private void handleStructure(final Object parent, final String name, final IFileElement value) {

		if (value != null) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s\n", value.getBitPosition(), 0, name);

			stack.push(value);
		}
	}

	private void updateStack(final Object parent) {

		if (stack.contains(parent)) {
			while (stack.peek() != parent) {
				stack.pop();
			}
		} else {
			stack.push(parent);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final Action value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ActionList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final BevelFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final BlurFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonCondAction value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonCondActionList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonRecord2 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonRecord2List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipActionRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipActionRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipActions value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipEventFlags value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ColorMatrixFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ConvolutionFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final CurvedEdgeRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final CxFormWithAlpha value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final DropShadowFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final EndShapeRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle3Array value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyleArray value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Filter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FilterList value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FocalGradient value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GlowFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GlyphEntry value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GlyphEntryList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Gradient value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Gradient3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradientBevelFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradientGlowFilter value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradRecord3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradRecord3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final INT16List value) {
		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition(), 0, name, value.size());

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final KerningRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final KerningRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle3Array value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle4 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle4Array value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle4List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyleArray value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Matrix value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphFillStyle value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphFillStyleArray value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphFillStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphGradient value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphGradientRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphGradientRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyle value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyleArray value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ParsedINTElementList value) {
		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition(), 0, name, value.size());

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final Rect value) {
		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s\n", value.getnBits().getBitPosition(), 0, name);

		stack.push(value);
	}

	@Override
	public void visit(final Object parent, final String name, final RectList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final RGB value) {

		if (value != null) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s\n", value.getRed().getBitPosition(), 0, name);

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final RGBA value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3Record value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3RecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeWithStyle value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeWithStyle3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeWithStyle4 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SingleFilterList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SoundEnvelope value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SoundEnvelopeList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SoundInfo value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StraightEdgeRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StyleChangeRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StyleChangeRecord3 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StyleChangeRecord4 value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(final Object parent, final String name, final SymbolList value) {
		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s (%d tags)\n", value.getBitPosition(), 0, name, value.size());

		stack.push(value);
	}

	@Override
	public void visit(final Object parent, final String name, final TagList value) {
		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s (%d tags)\n", value.getBitPosition(), 0, name, value.size());

		stack.push(value);
	}

	@Override
	public void visit(final Object parent, final String name, final TextRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final TextRecord2 value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final TextRecord2List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final TextRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final UINT16List value) {
		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition(), 0, name, value.size());

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneData value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneDataList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneRecord value) {
		handleStructure(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final Tag tag) {

		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s\n", tag.getHeader().getBitPosition(), 0, TagNames.getTagName(tag.getHeader().getTagCode()));

		stack.push(tag);
	}

	@Override
	public void visit(final String name, final AsciiString value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %s\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final Bits value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), value.getBitPosition(), name, value.value());
		}
	}

	@Override
	public void visit(final String name, final ByteArray value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %s\n", value.getBitPosition(), 0, name, "ARRAY");
		}
	}

	@Override
	public void visit(final String name, final Fixed value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final Fixed8 value) {
		output.printf(getPadding() + "[%08X:%d]: %s : %b\n", value.getBitPosition(), 0, name, value.value());
	}

	@Override
	public void visit(final String name, final Flag value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %b\n", value.getBitPosition(), value.getBitPosition(), name, value.value());
		}
	}

	@Override
	public void visit(final String name, final Float16 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %f\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final Float32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %f\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final INT16 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final INT32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final UBits value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), value.getBitPosition(), name, value.value());
		}
	}

	@Override
	public void visit(final String name, final UINT16 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final UINT32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final String name, final UINT8 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition(), 0, name, value.value());
		}
	}

	@Override
	public void visit(final SWFFile file) {
		output.println("Flash Dissector " + Constants.VERSION + " (http://www.the-interweb.com)");
		output.println("Dumping Flash file " + this.file.getAbsolutePath());
	}
}