package tv.porst.swfretools.utils;

/**
 * Exception class used to signal problems when resolving ActionScript 3 components.
 */
public final class ResolverException extends Exception {

	/**
	 * Creates a new ResolverException object.
	 * 
	 * @param msg Exception message.
	 */
	public ResolverException(final String msg) {
		super(msg);
	}
}