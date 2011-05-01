package tv.porst.swfretools.utils.as3;

import java.util.List;

import tv.porst.swfretools.parser.structures.AS3Code;
import tv.porst.swfretools.utils.ActionScript3Helpers;


public class ResolvedFunction {

	private final String name;
	private final List<String[]> arguments;
	private final String[] returnType;
	private final AS3Code code;

	private static String flatten(final List<String[]> arguments) {

		final StringBuilder sb = new StringBuilder();

		for (final String[] argument : arguments) {
			if (argument != arguments.get(0)) {
				sb.append(", ");
			}

			sb.append(ActionScript3Helpers.flattenNamespaceName(argument));
		}

		return sb.toString();
	}

	public ResolvedFunction(final String name, final String[] returnType, final List<String[]> arguments, final AS3Code code) {
		this.name = name;
		this.returnType = returnType;
		this.arguments = arguments;
		this.code = code;
	}

	public List<String[]> getArguments() {
		return arguments;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AS3Code getCode() {
		return code;
	}

	public String[] getReturnType() {
		return returnType;
	}

	@Override
	public String toString() {
		return ActionScript3Helpers.flattenNamespaceName(returnType) + " " + name + "(" + flatten(arguments) + ")";
	}
}
