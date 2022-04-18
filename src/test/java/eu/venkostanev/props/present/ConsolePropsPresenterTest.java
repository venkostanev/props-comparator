/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 13 Feb 2022 - venko
 */
package eu.venkostanev.props.present;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.junit.jupiter.api.Test;

import eu.venkostanev.props.PropsComparator;
import eu.venkostanev.props.present.ConsolePropsPresenter;

/**
 * @author venko
 *
 */
class ConsolePropsPresenterTest {
  
	@Test
	void testPresent() {
		Properties first = new Properties();
		Properties second = new Properties();
		
		ConsolePropsPresenter presenter = new ConsolePropsPresenter();
		PropsComparator comparator = new PropsComparator(first, second);
		assertEquals("-", presenter.prepare(comparator));
		
		first.put("1", "1");
		comparator = new PropsComparator(first, second);
		assertEquals("FIRST ONLY:\n  1 = 1\n\n", presenter.prepare(comparator));
		
		first.remove("1");
		second.put("1", "1");
		comparator = new PropsComparator(first, second);
		assertEquals("SECOND ONLY:\n  1 = 1\n\n", presenter.prepare(comparator));
		
		first.put("1", "2");
		comparator = new PropsComparator(first, second);
		assertEquals("DIFFERENT:\n> Property key - 1\n--> value in first - 2\n--> value in second - 1\n\n", presenter.prepare(comparator));
		
		first.put("1", "1");
		comparator = new PropsComparator(first, second);
		assertEquals("SAME:\n  1 = 1\n\n", presenter.prepare(comparator));
	}
}
