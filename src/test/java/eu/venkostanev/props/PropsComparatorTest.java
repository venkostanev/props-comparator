/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 12 Feb 2022 - venko
 */
package eu.venkostanev.props;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * @author venko
 *
 */
class PropsComparatorTest {
	
	@Test
	void testProcess() {
		Properties first = new Properties();
		first.put("1", "1");
		first.put("2", "2");
		first.put("3", "3");
		
		Properties second = new Properties();
		second.put("2", "two");
		second.put("3", "3");
		second.put("4", "4");
		
		PropsComparator c = new PropsComparator(first, second);
		
		assertTrue(c.getOnlyInFirst().contains("1"));
		assertTrue(c.getOnlyInSecond().contains("4"));
		assertTrue(c.getSameValues().contains("3"));
		assertTrue(c.getDifferentValues().contains("2"));
	}
	
	@Test
	void testProcessEdgeConditions() {
		Properties first = new Properties();
		
		Properties second = new Properties();
		second.put("2", "two");
		second.put("3", "3");
		second.put("4", "4");
		
		PropsComparator c = new PropsComparator(first, second);
		
		assertTrue(c.getOnlyInFirst().isEmpty());
		assertEquals(second.size(), c.getOnlyInSecond().size());
		assertTrue(c.getSameValues().isEmpty());
		assertTrue(c.getDifferentValues().isEmpty());
		
		first.put("1", "1");
		first.put("2", "2");
		first.put("3", "3");
		
		second = new Properties();
		c = new PropsComparator(first, second);
		
		assertEquals(first.size(), c.getOnlyInFirst().size());
		assertTrue(c.getOnlyInSecond().isEmpty());
		assertTrue(c.getSameValues().isEmpty());
		assertTrue(c.getDifferentValues().isEmpty());
		
		first = new Properties();
		second = new Properties();
		
		c = new PropsComparator(first, second);
		
		assertTrue(c.getOnlyInFirst().isEmpty());
		assertTrue(c.getOnlyInSecond().isEmpty());
		assertTrue(c.getSameValues().isEmpty());
		assertTrue(c.getDifferentValues().isEmpty());
		
		first = null;
		second = null;
		
        c = new PropsComparator(first, second);
		
		assertTrue(c.getOnlyInFirst().isEmpty());
		assertTrue(c.getOnlyInSecond().isEmpty());
		assertTrue(c.getSameValues().isEmpty());
		assertTrue(c.getDifferentValues().isEmpty());
		
		
	}

}
