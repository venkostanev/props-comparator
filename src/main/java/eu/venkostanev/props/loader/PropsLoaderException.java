/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 17 Apr 2022 - venko
 */
package eu.venkostanev.props.loader;

/**
 * Acts as a wrapper around different exceptions that might rise from loading of
 * properties.
 * 
 * @author venko
 *
 */
public class PropsLoaderException extends Exception {

	/**
	 * Serializable class better define this field.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new PropsLoaderException by calling the super constructor.
	 */
	public PropsLoaderException() {
		super();
	}

	/**
	 * Creates new PropsLoaderException by calling the super constructor.
	 * 
	 * @param message the error message
	 */
	public PropsLoaderException(String message) {
		super(message);
	}

	/**
	 * Creates new PropsLoaderException by calling the super constructor.
	 * 
	 * @param cause the root cause of the Exception
	 */
	public PropsLoaderException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates new PropsLoaderException by calling the super constructor.
	 * 
	 * @param message the error message
	 * @param cause the root cause of the Exception
	 */
	public PropsLoaderException(String message, Throwable cause) {
		super(message, cause);
	}
}
