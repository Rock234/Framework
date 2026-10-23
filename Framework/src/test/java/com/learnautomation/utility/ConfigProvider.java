package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigProvider {

	Properties pro;

	public ConfigProvider() {

		File src = new File("./Config/Config.properties");

		try (FileInputStream fis = new FileInputStream(src)) {
			pro = new Properties();

			pro.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to read Config file " + e.getMessage());
		}

	}

	public String getDataFromConfig(String ketToSearch) {
		return pro.getProperty(ketToSearch);

	}

	public String getBrowser() {

		return pro.getProperty("Browser");
	}

	public String getStagingUrl() {

		return pro.getProperty("qaUrl");

	}

}

