/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 18 Apr 2022 - venko
 */
package eu.venkostanev.props.loader;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author venko
 *
 */
class PropsLoaderFactoryTest {
	
	@Test
	void testGetLoader() {
		PropsLoader loader1 = PropsLoaderFactory.getLoader("properties");
		PropsLoader loader2 = PropsLoaderFactory.getLoader("hashicorp");
		assertTrue(loader1 instanceof PropertiesFileLoader);
		assertTrue(loader2 instanceof HashicorpJsonFileLoader);
	}

}
