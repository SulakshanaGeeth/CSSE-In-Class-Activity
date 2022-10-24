package com.employee.services;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;


public class readProperty {

	public static final Properties properties = new Properties();
	public static final Logger logs = Logger.getLogger(readProperty.class.getName());

	static {
		try {
			properties.load(readContent.class.getResourceAsStream("../config/config.properties"));
			
		}catch (IOException e) {
			logs.log(Level.SEVERE, e.getMessage());
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}
