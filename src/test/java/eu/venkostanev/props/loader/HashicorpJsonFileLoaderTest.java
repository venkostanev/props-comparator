/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 18 Apr 2022 - venko
 */
package eu.venkostanev.props.loader;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * @author venko
 *
 */
class HashicorpJsonFileLoaderTest {
	
	@Test
	void testGetProperties() throws PropsLoaderException {
		HashicorpJsonFileLoader loader = new HashicorpJsonFileLoader();
		Properties props = loader.getProperties(this.getClass().getResource("/first.json").getPath());
		assertTrue(props.containsKey("prop1"));
		assertFalse(props.containsKey("prop3"));
		assertTrue(props.containsValue("value1"));
		assertTrue(props.containsKey("prop2"));
		assertTrue(props.containsValue("value2"));
	}
}
