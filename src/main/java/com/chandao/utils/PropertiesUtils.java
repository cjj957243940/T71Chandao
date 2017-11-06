package com.chandao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtils {
		private static Properties properties = null;
		private static String propertiesFileName = null;
		
		//构造函数
		public PropertiesUtils(String path){
			this.propertiesFileName = path;
		}
		//提取方法
		public static String getPropertiesValues(String keyName){
			properties = new Properties();
			InputStream c = PropertiesUtils.class.getClassLoader().getResourceAsStream("com/chandao/config"+propertiesFileName);
			String value =null;
			try {
				properties.load(c);
				value = properties.getProperty(keyName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return value;
		}
}
