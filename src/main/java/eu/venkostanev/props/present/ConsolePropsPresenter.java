/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 10 Feb 2022 - venko
 */
package eu.venkostanev.props.present;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import eu.venkostanev.props.PropsComparator;

public class ConsolePropsPresenter implements PropsComparisonPresenter {

	@Override
	public String prepare(PropsComparator comparator) {
		return prepare(comparator, true);
	}

	@Override
	public String prepare(PropsComparator comparator, boolean showSame) {
		var locale = Locale.getDefault();
		var m = ResourceBundle.getBundle("messages", locale);

		StringBuilder sb = new StringBuilder();
		if (!comparator.getOnlyInFirst().isEmpty()) {
			sb.append(presentProperties(m.getString("output.first"), 
					comparator.getOnlyInFirst(), comparator.getFirst()));
			sb.append("\n");
		}

		if (!comparator.getOnlyInSecond().isEmpty()) {
			sb.append(presentProperties(m.getString("output.second"), 
					comparator.getOnlyInSecond(), comparator.getSecond()));
			sb.append("\n");
		}

		if (!comparator.getDifferentValues().isEmpty()) {
			sb.append(presentDifferentProperties(m.getString("output.different"), 
					comparator.getDifferentValues(), comparator.getFirst(), comparator.getSecond()));
			sb.append("\n");
		}

		if (!comparator.getSameValues().isEmpty() && showSame) {
			sb.append(presentProperties(m.getString("output.same"), 
					comparator.getSameValues(), comparator.getFirst()));
			sb.append("\n");
		}

		if (sb.isEmpty()) {
			sb.append("-");
		}
		return sb.toString();
	}

	@Override
	public void present(PropsComparator comparator, boolean showSame) {
		String result = prepare(comparator, showSame);
		System.out.println(result);
	}

	@Override
	public void present(PropsComparator comparator) {
		present(comparator, true);
	}

	private String presentProperties(String header, Set<Object> keys, Properties props) {
		StringBuilder sb = new StringBuilder();
		sb.append(header + "\n");
		for (Object key : keys) {
			sb.append("  " + key + " = " + props.getProperty((String) key) + "\n");
		}
		return sb.toString();
	}

	private String presentDifferentProperties(String header, Set<Object> keys, Properties first, Properties second) {
		var locale = Locale.getDefault();
		var m = ResourceBundle.getBundle("messages", locale);
		StringBuilder sb = new StringBuilder();
		sb.append(header + "\n");
		for (Object key : keys) {
			sb.append(m.getString("output.key") + key + "\n");
			sb.append(m.getString("output.value.first") + first.getProperty((String) key) + "\n");
			sb.append(m.getString("output.value.second") + second.getProperty((String) key) + "\n");
		}
		return sb.toString();
	}
}
