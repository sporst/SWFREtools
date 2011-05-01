package tv.porst.swfretools.utils.as3;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.structures.AS3Code;

public class ResolvedMethod {

	private final String[] returnType;
	private final String[] methodName;
	private final List<String[]> arguments;
	private final AS3Code code;

	public ResolvedMethod(final String[] returnType, final String[] methodName, final List<String[]> arguments, final AS3Code code) {
		this.returnType = returnType.clone();
		this.methodName = methodName.clone();
		this.arguments = new ArrayList<String[]>(arguments);
		this.code = code;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public List<String[]> getArguments() {
		return new ArrayList<String[]>(arguments);
	}

	public AS3Code getCode() {
		return code;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public String[] getName() {
		return methodName.clone();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public String[] getReturnType() {
		return returnType.clone();
	}
}
