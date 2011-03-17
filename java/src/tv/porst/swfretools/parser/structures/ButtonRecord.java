package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ButtonRecord structure.
 * 
 * @author sp
 *
 */
public final class ButtonRecord implements IFileElement {

	/**
	 * Reserved bits.
	 */
	private final UBits buttonReserved;

	/**
	 * Blend mode flag.
	 */
	private final Flag buttonHasBlendMode;

	/**
	 * Filter list flag.
	 */
	private final Flag buttonHasFilterList;

	/**
	 * Present in down state.
	 */
	private final Flag buttonStateHitTest;

	/**
	 * Present in down state.
	 */
	private final Flag buttonStateDown;

	/**
	 * Present in over state.
	 */
	private final Flag buttonStateOver;

	/**
	 * Present in up state.
	 */
	private final Flag buttonStateUp;

	/**
	 * ID of character to place.
	 */
	private final UINT16 characterId;

	/**
	 * Depth at which to place the character.
	 */
	private final UINT16 placeDepth;

	/**
	 * Transformation matrix for character placement.
	 */
	private final Matrix placeMatrix;

	/**
	 * Creates a new ButtonRecord object.
	 * 
	 * @param buttonReserved Reserved bits.
	 * @param buttonHasBlendMode Blend mode flag.
	 * @param buttonHasFilterList Filter list flag.
	 * @param buttonStateHitTest Present in hit test state.
	 * @param buttonStateDown Present in down state.
	 * @param buttonStateOver Present in over state.
	 * @param buttonStateUp Present in up state.
	 * @param characterId ID of character to place.
	 * @param placeDepth Depth at which to place the character.
	 * @param placeMatrix Transformation matrix for character placement.
	 */
	public ButtonRecord(final UBits buttonReserved, final Flag buttonHasBlendMode,
			final Flag buttonHasFilterList, final Flag buttonStateHitTest,
			final Flag buttonStateDown, final Flag buttonStateOver,
			final Flag buttonStateUp, final UINT16 characterId, final UINT16 placeDepth,
			final Matrix placeMatrix) {

		this.buttonReserved = buttonReserved;
		this.buttonHasBlendMode = buttonHasBlendMode;
		this.buttonHasFilterList = buttonHasFilterList;
		this.buttonStateHitTest = buttonStateHitTest;
		this.buttonStateDown = buttonStateDown;
		this.buttonStateOver = buttonStateOver;
		this.buttonStateUp = buttonStateUp;
		this.characterId = characterId;
		this.placeDepth = placeDepth;
		this.placeMatrix = placeMatrix;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(buttonReserved, buttonHasBlendMode, buttonHasFilterList,
				buttonStateHitTest, buttonStateDown, buttonStateOver, buttonStateUp, characterId,
				placeDepth, placeMatrix);
	}

	@Override
	public int getBitPosition() {
		return buttonReserved.getBitPosition();
	}

	/**
	 * Returns the blend mode flag.
	 *
	 * @return The blend mode flag.
	 */
	public Flag getButtonHasBlendMode() {
		return buttonHasBlendMode;
	}

	/**
	 * Returns the filter list flag.
	 *
	 * @return The filter list flag.
	 */
	public Flag getButtonHasFilterList() {
		return buttonHasFilterList;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UBits getButtonReserved() {
		return buttonReserved;
	}

	/**
	 * Returns the present in down state.
	 *
	 * @return The present in down state.
	 */
	public Flag getButtonStateDown() {
		return buttonStateDown;
	}

	/**
	 * Returns the present in down state.
	 *
	 * @return The present in down state.
	 */
	public Flag getButtonStateHitTest() {
		return buttonStateHitTest;
	}

	/**
	 * Returns the present in over state.
	 *
	 * @return The present in over state.
	 */
	public Flag getButtonStateOver() {
		return buttonStateOver;
	}

	/**
	 * Returns the present in up state.
	 *
	 * @return The present in up state.
	 */
	public Flag getButtonStateUp() {
		return buttonStateUp;
	}

	/**
	 * Returns the ID of character to place.
	 *
	 * @return The ID of character to place.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the depth at which to place the character.
	 *
	 * @return The depth at which to place the character.
	 */
	public UINT16 getPlaceDepth() {
		return placeDepth;
	}

	/**
	 * Returns the transformation matrix for character placement.
	 *
	 * @return The transformation matrix for character placement.
	 */
	public Matrix getPlaceMatrix() {
		return placeMatrix;
	}
}