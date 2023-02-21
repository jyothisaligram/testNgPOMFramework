package com.training.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
 
	public String getproperty(String key) throws IOException {
          	 
  //filepath          	 
 String spath = "C:\\Users\\jyoth\\eclipse-workspace\\TestngSalesforceFrameWork\\properties\\application.properties";
            
   //fileinputstream
 FileInputStream file = new FileInputStream(spath);
 Properties prop = new Properties();
 prop.load(file);
 String value = prop.getProperty(key);
 return value;
             
             }
	
	
}
