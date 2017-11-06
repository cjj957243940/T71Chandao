package com.chandao.config;

import com.chandao.utils.PropertiesUtils;

public class Localconfig {
	static PropertiesUtils propertiesutils = new PropertiesUtils("/local.properties");
	public static final String url = propertiesutils.getPropertiesValues("url");
	public static final String CHROMEDRIVER = propertiesutils.getPropertiesValues("chromeDriverPath");
	public static final String SCREENSHORTPATH = propertiesutils.getPropertiesValues("shotPath");
}
