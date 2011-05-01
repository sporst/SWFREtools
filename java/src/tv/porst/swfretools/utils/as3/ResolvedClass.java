package tv.porst.swfretools.utils.as3;

import java.util.ArrayList;
import java.util.List;

public class ResolvedClass {

	private final String[] name;
	private final List<ResolvedMethod> methods;
	private final ResolvedMethod staticConstructor;
	private final ResolvedMethod constructor;

	public ResolvedClass(final String[] name, final List<ResolvedMethod> methods, final ResolvedMethod staticConstructor, final ResolvedMethod constructor) {
		this.name = name.clone();
		this.methods = new ArrayList<ResolvedMethod>(methods);
		this.staticConstructor = staticConstructor;
		this.constructor = constructor;
	}

	public ResolvedMethod getConstructor() {
		return constructor;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public List<ResolvedMethod> getMethods() {
		return new ArrayList<ResolvedMethod>(methods);
	}

	public String[] getName() {
		return name.clone();
	}

	public ResolvedMethod getStaticConstructor() {
		return staticConstructor;
	}
}