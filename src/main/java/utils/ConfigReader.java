package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties intializeProperties() {
	
	
	Properties prop=new Properties();
	File propfis=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
	
	try {
			FileInputStream fis =new FileInputStream(propfis);
			prop.load(fis);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return prop;
}}
