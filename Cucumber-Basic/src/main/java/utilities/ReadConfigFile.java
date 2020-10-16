package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ReadConfigFile {
	FileInputStream fis;
	 Properties p2=null;
	public Properties read()  {
	try 
	{
	File f=new File("./configuration/config.properties");

	 fis=new FileInputStream(f);

     p2=new Properties();
    
    p2.load(fis);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return p2;
    
}}