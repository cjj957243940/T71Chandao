package com.first.demo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.chandao.baseframework.Locator;
import com.chandao.baseframework.Locator.ByType;
import com.chandao.utils.xmlUtils;


public class Readxml {

public static void main(String[] args) throws DocumentException {
	HashMap<String, Locator> l = xmlUtils.readElementInfo("LoginPage.xml");
	l.get("fantiLink").getElementName();
	
}
}
