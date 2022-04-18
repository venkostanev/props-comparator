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
 * Factory for properties loaders
 * 
 * @author venko
 *
 */
public class PropsLoaderFactory {

	private static final String PROPERTIES = "properties";
	private static final String HASHICORP = "hashicorp";
	
	private PropsLoaderFactory() {
		super();
	}

	/**
	 * Returns properties loader corresponding to the provided type. The type can be
	 * either properties or hashicorp (Hashicorp JSON format)
	 * 
	 * @param type either properties or hashicorp. If an unknown type is supplied then PropertiesFileLoader is created.
	 * @return Properties Loader
	 */
	public static PropsLoader getLoader(String type) {
		if (type == null || type.isBlank() || PropsLoaderFactory.PROPERTIES.equals(type)) {
			return new PropertiesFileLoader();
		} else if (PropsLoaderFactory.HASHICORP.equals(type)) {
			return new HashicorpJsonFileLoader();
		}

		return new PropertiesFileLoader();
	}

}
