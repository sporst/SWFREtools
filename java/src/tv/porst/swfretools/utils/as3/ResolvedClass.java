package tv.porst.swfretools.utils.as3;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a resolved ActionScript 3 class.
 */
public final class ResolvedClass {

	/**
	 * Parts of the fully qualified class name.
	 */
	private final String[] name;

	/**
	 * The static constructor of the class.
	 */
	private final ResolvedMethod staticConstructor;

	/**
	 * The constructor of the class.
	 */
	private final ResolvedMethod constructor;

	/**
	 * The methods of the class.
	 */
	private final List<ResolvedMethod> methods;

	/**
	 * Creates a new resolved class object.
	 * 
	 * @param name Parts of the fully qualified class name.
	 * @param staticConstructor The static constructor of the class.
	 * @param constructor The constructor of the class.
	 * @param methods The methods of the class.
	 */
	public ResolvedClass(final String[] name, final ResolvedMethod staticConstructor, final ResolvedMethod constructor, final List<ResolvedMethod> methods) {

		if (name == null) {
			throw new IllegalArgumentException("Name argument must not be null.");
		}

		if (staticConstructor == null) {
			throw new IllegalArgumentException("Static constructor argument must not be null.");
		}

		if (constructor == null) {
			throw new IllegalArgumentException("constructor argument must not be null.");
		}

		if (methods == null) {
			throw new IllegalArgumentException("Methods argument must not be null.");
		}

		this.name = name.clone();
		this.staticConstructor = staticConstructor;
		this.constructor = constructor;
		this.methods = new ArrayList<ResolvedMethod>(methods);
	}

	/**
	 * Returns the constructor of the class.
	 * 
	 * @return The constructor of the class.
	 */
	public ResolvedMethod getConstructor() {
		return constructor;
	}

	/**
	 * Returns the methods of the class.
	 *
	 * @return The methods of the class.
	 */
	public List<ResolvedMethod> getMethods() {
		return new ArrayList<ResolvedMethod>(methods);
	}

	/**
	 * Returns the fully qualified class name.
	 * 
	 * @return The parts of the fully qualified name.
	 */
	public String[] getName() {
		return name.clone();
	}

	/**
	 * Returns the static constructor of the class.
	 * 
	 * @return The static constructor of the class.
	 */
	public ResolvedMethod getStaticConstructor() {
		return staticConstructor;
	}
}