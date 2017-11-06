package com.chandao.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.chandao.baseframework.Locator;
import com.chandao.baseframework.Locator.ByType;

public class xmlUtils {
	
		public static HashMap<String, Locator>readElementInfo(String fileName) throws DocumentException{
			String xfp=System.getProperty("user.dir")+"/webelementdata/"+fileName;
			//目标提取xml里面的数据，存入一个MAP
			Map<String, Locator>elementinfo  = new HashMap<String,Locator>();
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new File(xfp));
			//提取根节点
			Element root = document.getRootElement();
			List<Element> childList = root.elements("locator");
			for(Element e:childList){
				String value = e.attributeValue("value").toString();
				int timeOut = Integer.parseInt(e.attributeValue("timeout"));
				String name = e.attributeValue("name").toString();
				String type = e.attributeValue("type").toString();
				Locator locator = new Locator(value, timeOut, getType(type), name);
				String keyName = e.getText();//MAP的键
				elementinfo.put(keyName, locator);	
		}
			return (HashMap<String, Locator>) elementinfo;
		}
			public static ByType getType(String value){
				ByType type = null;
				switch(value){
				case "css":
					type = ByType.cssSelector;
					break;
				case "xpath":
					type = ByType.xpath;
					break;
				case "id":
					type = ByType.id;
					break;
				case "classname":
					type = ByType.className;
					break;
				case "name":
					type = ByType.name;
					break;
				case "linkText":
					type = ByType.linkText;
					break;
				case "tagName":
					type = ByType.tagName;
					break;
				}
				return type;
			}

}
