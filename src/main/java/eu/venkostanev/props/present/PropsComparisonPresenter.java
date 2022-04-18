/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 18 Apr 2022 - venko
 */
package eu.venkostanev.props.present;

import eu.venkostanev.props.PropsComparator;

/**
 * @author venko
 *
 */
public interface PropsComparisonPresenter {
	
	/**
	 * Prepares the presentation of the properties comparison results for a comparator.
	 * 
	 * @param comparator the properties comparator
	 * 
	 * @return the comparison details in the form of String
	 */
	String prepare(PropsComparator comparator);
	
	/**
	 * Prepares the presentation of the properties comparison results for a comparator.
	 * 
	 * @param comparator the properties comparator
	 * @param showSame if true will also include the same properties in the result
	 * 
	 * @return the comparison details in the form of String
	 */
	String prepare(PropsComparator comparator, boolean showSame);
	
	/**
	 * Presents the results of the properties comparison.
	 * 
	 * @param comparator the properties comparator
	 */
	void present(PropsComparator comparator);
	
	/**
	 * Presents the results of the properties comparison.
	 * 
	 * @param comparator the properties comparator
	 * @param showSame if true the method will show also the same properties.
	 */
	void present(PropsComparator comparator, boolean showSame);

}
