/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 9 Feb 2022 - venko
 */
package eu.venkostanev.props;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Compares properties
 * 
 * @author venko
 *
 */
public class PropsComparator {

	/**
	 * Properties that are only in the first properties source.
	 */
	private Set<Object> onlyInFirst;
	
	/**
	 * Properties that are only in the second properties source.
	 */
	private Set<Object> onlyInSecond;
	
	/**
	 * Properties that are present in both sources but with different values.
	 */
	private Set<Object> differentValues;
	
	/**
	 * Properties that same in both sources.
	 */
	private Set<Object> sameValues;
	
	/**
	 * All properties from the first source.
	 */
	private Properties first;
	
	/**
	 * All properties from the second source.
	 */
	private Properties second;

	/**
	 * Creates a properties comparator and calculates the differences.
	 * 
	 * @param first the first properties source
	 * @param second the first properties source
	 */
	public PropsComparator(Properties first, Properties second) {
		if (first == null) {
			this.first = new Properties();
		} else {
			this.first = first;
		}
		if (second == null) {
			this.second = new Properties();
		} else {
			this.second = second;
		}
		this.onlyInFirst = new HashSet<>();
		this.onlyInSecond = new HashSet<>();
		this.differentValues = new HashSet<>();
		this.sameValues = new HashSet<>();
		process();
	}

	/**
	 * Sorts the properties into 4 different categories - only in the first, only in
	 * the second, changed values between first and second and properties that
	 * remain the same.
	 */
	public void process() {
		Set<Object> keys = new HashSet<>();
		keys.addAll(first.keySet());
		keys.addAll(second.keySet());

		for (Object k : keys) {
			if (first.containsKey(k) && second.containsKey(k) && equalValues(first.get(k), second.get(k))) {
				sameValues.add(k);
			} else if (first.containsKey(k) && second.containsKey(k) && !equalValues(first.get(k), second.get(k))) {
				differentValues.add(k);
			} else if (first.containsKey(k) && !second.containsKey(k)) {
				onlyInFirst.add(k);
			} else if (!first.containsKey(k) && second.containsKey(k)) {
				onlyInSecond.add(k);
			}
		}
	}

	public Set<Object> getOnlyInFirst() {
		return onlyInFirst;
	}

	public Set<Object> getOnlyInSecond() {
		return onlyInSecond;
	}

	public Set<Object> getDifferentValues() {
		return differentValues;
	}

	public Set<Object> getSameValues() {
		return sameValues;
	}

	public Properties getFirst() {
		return first;
	}

	public Properties getSecond() {
		return second;
	}

	/**
	 * Checks two object for equality. If both objects are null returns true;
	 * 
	 * @param o1 first object
	 * @param o2 second object
	 * @return true if both objects are equal or null
	 */
	private boolean equalValues(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		} else {
			return o1.equals(o2);
		}
	}
}
