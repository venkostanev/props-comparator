/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 6 Feb 2022 - venko
 */
package eu.venkostanev.props.loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads properties files
 * 
 * @author venko
 *
 */
public class PropertiesFileLoader implements PropsLoader {

	/**
	 * Returns Properties object from properties file
	 * 
	 * @param path the path to the file
	 * @return Properties object
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Override
	public Properties getProperties(String path) throws PropsLoaderException {
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream(path);) {
			props.load(fis);
		} catch (IOException e) {
			throw new PropsLoaderException(e);
		}
		return props;
	}
}
