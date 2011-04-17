package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.ParserError;
import tv.porst.swfretools.parser.structures.TagList;

/**
 * Represents the result of a tag parsing operation.
 */
public final class TagParserResult {

	/**
	 * List of parsed tags.
	 */
	private final TagList tags;

	/**
	 * Parsing errors that were encountered while parsing.
	 */
	private final List<ParserError> errors;

	/**
	 * Creates a new tag parser result object.
	 * 
	 * @param tags Tags that were parsed during the operation.
	 * @param errors Parsing errors that were encountered while parsing.
	 */
	public TagParserResult(final TagList tags, final List<ParserError> errors) {
		if (tags == null) {
			throw new IllegalArgumentException("List of tags must not be null");
		}

		if (errors == null) {
			throw new IllegalArgumentException("List of errors must not be null");
		}

		this.tags = tags;
		this.errors = new ArrayList<ParserError>(errors);
	}

	/**
	 * Returns the parser errors list.
	 *
	 * @return The parser errors list.
	 */
	public List<ParserError> getErrors() {
		return new ArrayList<ParserError>(errors);
	}

	/**
	 * Returns the list of parsed tags.
	 * 
	 * @return The list of parsed tags.
	 */
	public TagList getTags() {
		return tags;
	}
}