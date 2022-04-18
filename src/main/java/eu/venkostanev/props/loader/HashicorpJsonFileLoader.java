/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 17 Apr 2022 - venko
 */
package eu.venkostanev.props.loader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Loads Hashicorp JSON format
 * 
 * <pre>
 *   {
 *     "prop1": "value1",
 *     "prop2": "value2"
 *   }
 * </pre>
 * 
 * @author venko
 *
 */
public class HashicorpJsonFileLoader implements PropsLoader {

	@Override
	public Properties getProperties(String source) throws PropsLoaderException {
		Properties properties = new Properties();
 		try {
			Reader reader = Files.newBufferedReader(Paths.get(source));
			JsonElement jsonElement = JsonParser.parseReader(reader);
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
			for (Map.Entry<String, JsonElement> entry : entries) {
				if (entry.getValue().isJsonPrimitive()) {
					properties.put(entry.getKey(), entry.getValue().getAsString());
				}
			}
		} catch (IOException e) {
			throw new PropsLoaderException(e);
		}
		return properties;
	}

}
