package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class FilterParser {

	public static Filter parse(final BinaryParser parser) {
		final int filterId = parser.readUInt8();

		final DropShadowFilter dropShadowFilter = filterId == 0 ? DropShadowFilterParser.parse(parser) : null;
		final BlurFilter blurFilter = filterId == 1 ? BlurFilterParser.parse(parser) : null;
		final GlowFilter glowFilter = filterId == 2 ? GlowFilterParser.parse(parser) : null;
		final BevelFilter bevelFilter = filterId == 3 ? BevelFilterParser.parse(parser) : null;
		final GradientGlowFilter gradientGlowFilter = filterId == 4 ? GradientGlowFilterParser.parse(parser) : null;
		final ConvolutionFilter convolutionFilter = filterId == 5 ? ConvolutionFilterParser.parse(parser) : null;
		final ColorMatrixFilter colorMatrixFilter = filterId == 6 ? ColorMatrixFilterParser.parse(parser) : null;
		final GradientBevelFilter gradientBevelFilter = filterId == 7 ? GradientBevelFilterParser.parse(parser) : null;

		return new Filter(dropShadowFilter, blurFilter, glowFilter, bevelFilter, gradientGlowFilter, convolutionFilter, colorMatrixFilter, gradientBevelFilter);
	}

}
