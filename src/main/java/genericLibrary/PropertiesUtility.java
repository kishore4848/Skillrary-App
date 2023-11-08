package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods to read data from properties file
 * @author Kishore
 *
 */

public class PropertiesUtility {
	
	private Properties property;
	
	
	public void propertiesInitialization(String filepath) {
		FileInputStream fis =null;
		try {
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String readFromProperties(String key) {
		return property.getProperty(key);
	}

}
