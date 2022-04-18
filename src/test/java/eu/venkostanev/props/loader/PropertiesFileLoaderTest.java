/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 13 Feb 2022 - venko
 */
package eu.venkostanev.props.loader;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * @author venko
 *
 */
class PropertiesFileLoaderTest {
	
	@Test
	void testGetProperties() throws PropsLoaderException {
		PropertiesFileLoader loader = new PropertiesFileLoader();
		Properties props = loader.getProperties(this.getClass().getResource("/first.properties").getPath());
		assertTrue(props.contains("1"));
		assertTrue(props.contains("c"));
	}

}
