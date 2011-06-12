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
import tv.porst.swfretools.dissector.Constants;
import tv.porst.swfretools.dissector.gui.main.panels.AS2CodePrinter;
import tv.porst.swfretools.dissector.gui.main.panels.AS3CodePrinter;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.*;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.utils.ISWFVisitor;
import tv.porst.swfretools.utils.TagNames;
import tv.porst.swfretools.utils.as3.ActionScript3Resolver;

/**
 * Visitor class that dumps all elements of a SWF file to stdout.
 */
public final class ConsoleVisitor implements ISWFVisitor {

	/**
	 * File that is processed.
	 */
	private final File file;

	/**
	 * Output target.
	 */
	private final PrintStream output = System.out;

	/**
	 * Stack that keeps track of the element traversal hierarchy.
	 */
	private final Stack<Object> stack = new Stack<Object>();

	/**
	 * Creates a new console visitor object.
	 * 
	 * @param file File that is processed.
	 */
	public ConsoleVisitor(final File file) {

		if (file == null) {
			throw new IllegalArgumentException("File argument must not be null.");
		}

		this.file = file;
	}

	/**
	 * Returns the necessary padding before lines depending on the size of the
	 * traversal stack.
	 * 
	 * @return The necessary padding string.
	 */
	private String getPadding() {
		return StringHelpers.repeat("  ", stack.size() - 1);
	}

	/**
	 * Processes a file element.
	 * 
	 * @param parent Parent element of the list.
	 * @param name Name of the file element.
	 * @param value The file element to process.
	 */
	private void handleElement(final Object parent, final String name, final IFileElement value) {

		if (value != null) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s\n", value.getBitPosition() / 8, 0, name);

			stack.push(value);
		}
	}

	/**
	 * Processes a list.
	 * 
	 * @param parent Parent element of the list.
	 * @param name Name of the list.
	 * @param value The list to process.
	 */
	private void handleList(final Object parent, final String name, final ElementList<?> value) {

		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition() / 8, 0, name, value.size());

			stack.push(value);
		}
	}

	/**
	 * Updates the stack with a new parent element.
	 * 
	 * @param parent The new parent element.
	 */
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
		// Do nothing
	}

	@Override
	public void visit(final Object parent, final String name, final ActionList value) {
		handleList(parent, name, value);

		output.println(AS2CodePrinter.getCodeText(value, getPadding()));
	}

	@Override
	public void visit(final Object parent, final String name, final AS3Data value) {
		handleElement(parent, name, value);

		output.println(AS3CodePrinter.getCodeText(ActionScript3Resolver.resolve(value)));
	}

	@Override
	public void visit(final Object parent, final String name, final AsciiString value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %s\n", value.getBitPosition() / 8, 0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final BevelFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Bits value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8, value.getBitPosition() % 8, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final BlurFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonCondAction value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonCondActionList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonRecord2 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonRecord2List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ButtonRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ByteArray value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %s\n", value.getBitPosition() / 8, 0, name, "ARRAY");
		}
	}

	@Override
	public void visit(final Object parent, final String name, final ClipActionRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipActionRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipActions value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ClipEventFlags value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ColorMatrixFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ConvolutionFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final CurvedEdgeRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final CxForm value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final CxFormWithAlpha value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final DropShadowFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final EncodedU32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8, 0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final EndShapeRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle3 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle3Array value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyle3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyleArray value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FillStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Filter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FilterList value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Fixed value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8, 0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final Fixed8 value) {
		output.printf(getPadding() + "[%08X:%d]: %s : %b\n", value.getBitPosition() / 8,  0, name, value.value());
	}

	@Override
	public void visit(final Object parent, final String name, final Flag value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %b\n", value.getBitPosition() / 8,  value.getBitPosition() % 8,  name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final Float16 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %f\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final Float32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %f\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final Float32List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FocalGradient value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FrameLabel value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final FrameLabelList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GlowFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GlyphEntry value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GlyphEntryList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Gradient value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Gradient3 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradientBevelFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradientGlowFilter value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final GradRecord3 value) {
		handleElement(parent, name, value);
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
	public void visit(final Object parent, final String name, final INT16 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final INT16List value) {
		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition() / 8,  0, name, value.size());

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final INT32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final KerningRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final KerningRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle3 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle3Array value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle4 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle4Array value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyle4List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyleArray value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final LineStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Matrix value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphFillStyle value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphFillStyleArray value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphFillStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphGradient value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphGradientRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphGradientRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyle value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyle2 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyle2List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyleArray value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyleArray2 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final MorphLineStyleList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ParsedINTElementList value) {
		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition() / 8,  0, name, value.size());

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final RecordHeader value) {
		if (value != null) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (Code: %d Length: %d)\n", value.getBitPosition() / 8, 0, name, value.getTagCode(), value.getLength());

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
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final RGBAList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SceneName value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SceneNameList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Shape3Record value) {
		handleElement(parent, name, value);
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
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeWithStyle value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeWithStyle3 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ShapeWithStyle4 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SingleFilterList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SoundEnvelope value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SoundEnvelopeList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SoundInfo value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StraightEdgeRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StyleChangeRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StyleChangeRecord3 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final StyleChangeRecord4 value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final Symbol value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final SymbolList value) {
		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s (%d tags)\n", value.getBitPosition() / 8,  0, name, value.size());

		stack.push(value);
	}

	@Override
	public void visit(final Object parent, final String name, final TagList value) {
		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s (%d tags)\n", value.getBitPosition() / 8,  0, name, value.size());

		stack.push(value);
	}

	@Override
	public void visit(final Object parent, final String name, final TextRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final TextRecord2 value) {
		handleElement(parent, name, value);
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
	public void visit(final Object parent, final String name, final UBits value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8,  value.getBitPosition() % 8,  name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final UINT16 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final UINT16List value) {
		if (value.size() != 0) {

			updateStack(parent);

			output.printf(getPadding() + "[%08X:%d]: %s (%d elements)\n", value.getBitPosition() / 8,  0, name, value.size());

			stack.push(value);
		}
	}

	@Override
	public void visit(final Object parent, final String name, final UINT32 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final UINT8 value) {
		if (value != null) {
			output.printf(getPadding() + "[%08X:%d]: %s : %d\n", value.getBitPosition() / 8,  0, name, value.value());
		}
	}

	@Override
	public void visit(final Object parent, final String name, final UINT8List value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneData value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneDataList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneRecord value) {
		handleElement(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final String name, final ZoneRecordList value) {
		handleList(parent, name, value);
	}

	@Override
	public void visit(final Object parent, final Tag tag) {

		updateStack(parent);

		output.printf(getPadding() + "[%08X:%d]: %s\n", tag.getHeader().getBitPosition() / 8, 0, TagNames.getPrintableTagName(tag.getHeader().getTagCode()));

		stack.push(tag);
	}

	@Override
	public void visit(final SWFFile file) {
		output.println("Flash Dissector " + Constants.VERSION + " (http://www.github.com/sporst/SWFRETools)");
		output.println("Dumping Flash file " + this.file.getAbsolutePath());
		output.println();
	}
}