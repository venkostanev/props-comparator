/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 17 Apr 2022 - venko
 */
package eu.venkostanev.props.loader;

import java.util.Properties;

/**
 * Properties loader interface
 * 
 * @author venko
 *
 */
public interface PropsLoader {
	
	/**
	 * Gets the properties from a source
	 * 
	 * @param source the properties source
	 * @return the properties from the provided source
	 * @throws PropsLoaderException wrapped around the actual root cause of the Exception
	 */
	Properties getProperties(String source) throws PropsLoaderException;

}
