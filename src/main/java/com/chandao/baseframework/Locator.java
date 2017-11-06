package com.chandao.baseframework;

public class Locator {
	public enum ByType{
		xpath,id,linkText,name,className,cssSelector,partialLinkText,tagName
	}
	private String elementName;
	private String locatorInfo;
	private int timeOut;
	private ByType byTye; 
	
	public Locator(String element,int waitSec,ByType byType,String name){
		this.elementName = name;
		this.locatorInfo = element;
		this.timeOut = waitSec;
		this.byTye = byType;//识别方法
	}

	public String getElementName() {
		return elementName;
	}

	public String getLocatorInfo() {
		return locatorInfo;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public ByType getByTye() {
		return byTye;
	}
	
}
