/**
 * Copyright: (c) 2022 Properties Comparator
 *
 * This work is part of the Properties Comparator project which is released under GPL v3 license.
 * SGNU General Public License v3.0+ (see COPYING or https://www.gnu.org/licenses/gpl-3.0.txt)
 *
 * 6 Feb 2022 - venko
 */
package eu.venkostanev.props;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import eu.venkostanev.props.loader.PropsLoaderException;
import eu.venkostanev.props.loader.PropsLoaderFactory;
import eu.venkostanev.props.present.ConsolePropsPresenter;

/**
 * The main class
 * 
 * @author venko
 *
 */
public class MainPropsComparator {
	
	 private static Logger logger = Logger.getLogger("eu.venkostanev.props");

	/**
	 * The main entry point of the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		CommandLineParser parser = new DefaultParser();
		
		var locale = Locale.getDefault();
		var m = ResourceBundle.getBundle("messages", locale);
		
		HelpFormatter helpFormatter = new HelpFormatter();
		
		Option first = new Option(m.getString("options.first.short"), m.getString("options.first.long"), true, m.getString("options.first.description"));
		Option second = new Option(m.getString("options.second.short"), m.getString("options.second.long"), true,  m.getString("options.second.description"));
		Option help = new Option(m.getString("options.help.short"), m.getString("options.help.long"), false,  m.getString("options.help.description"));
		Option nosame = new Option(m.getString("options.nosame.short"), m.getString("options.nosame.long"), false,  m.getString("options.nosame.description"));
		Option format = new Option(m.getString("options.format.short"), m.getString("options.format.long"), true, m.getString("options.format.description"));
		
		Options options = new Options();
		
		options.addOption(first);
		options.addOption(second);
		options.addOption(help);
		options.addOption(nosame);
		options.addOption(format);
		
		String cmdLineSyntax = m.getString("cmd");
        String header = m.getString("header");
        String footer = m.getString("footer");
		
		try {
			CommandLine line = parser.parse(options, args, false);
			if (!line.hasOption(first) || !line.hasOption(second) || line.hasOption(help)) {
				helpFormatter.printHelp(cmdLineSyntax, header, options, footer);
				return;
			}
			
			boolean showSame = true;
			if (line.hasOption(nosame)) {
				showSame = false;
			}
			
			Properties firstProps = PropsLoaderFactory.getLoader(line.getOptionValue(format)).getProperties(line.getOptionValue(first));
			Properties secondProps = PropsLoaderFactory.getLoader(line.getOptionValue(format)).getProperties(line.getOptionValue(second));
			
			PropsComparator comparator = new PropsComparator(firstProps, secondProps);
			
			ConsolePropsPresenter presenter = new ConsolePropsPresenter();
			presenter.present(comparator, showSame);
		} catch (ParseException e) {
			logger.log(Level.SEVERE, m.getString("error.parse"), e);
			helpFormatter.printHelp(cmdLineSyntax, header, options, footer);
		} catch (PropsLoaderException e) {
			logger.log(Level.SEVERE, m.getString("error.file"), e.getCause());
		}
	}
}
