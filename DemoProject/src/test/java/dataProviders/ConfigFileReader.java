package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private FileInputStream fis;
	private final String propertyFilePath = "config//Configuration.properties";

	/**
	 * Read Config properties file
	 * 
	 * 
	 * @throws IOException
	 */
	public ConfigFileReader() throws IOException {
		try {
			fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
	}

	/**
	 * Get path of input test data json from properties file
	 * 
	 * 
	 * @return inputDataPath
	 */
	public String getInputTestDataPath() {
		String inputDataPath = properties.getProperty("testData");
		if (inputDataPath != null)
			return inputDataPath;
		else
			throw new RuntimeException("Test Data path is not present in properties file");
	}

}
