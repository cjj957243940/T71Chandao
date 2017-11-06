package com.chandao.baseframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chandao.utils.xmlUtils;

import junit.framework.Assert;

public class WebElementUntils extends DriverUntils {
	
	protected HashMap<String, Locator> locatorMap;
	protected String xmlPath = null;
	public WebElementUntils(WebDriver driver){
		super(driver);
		xmlPath =this.getClass().getSimpleName()+".xml";	
		try {
			locatorMap = xmlUtils.readElementInfo(xmlPath);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//1.获取元素getElement
	public WebElement getElement(Locator locator){
		WebElement el =null;
		try{
		switch(locator.getByTye()){
		case id:
			el=driver.findElement(By.id(locator.getLocatorInfo()));
			break;
		case name:
			el = driver.findElement(By.name(locator.getLocatorInfo()));
			break;
		case className:
			el = driver.findElement(By.className(locator.getLocatorInfo()));
			break;
		case xpath:
			el = driver.findElement(By.xpath(locator.getLocatorInfo()));
			break;
		case cssSelector:
			el = driver.findElement(By.cssSelector(locator.getLocatorInfo()));
			break;
		case linkText:
			el = driver.findElement(By.linkText(locator.getLocatorInfo()));
			break;
		}
		}catch(Exception e){
			takeScreenShot("findElementErrorImage");
			log.info("元素："+locator.getElementName()+" 识别异常");
			Assert.fail("查找元素异常，退出当前测试用例");
		}
		return el;
	}
	//2.使用显示等待方法，查找与安生
	public WebElement findElement( final Locator locator){
		WebDriverWait wait = new WebDriverWait(driver, locator.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d){
				return getElement(locator);
			}
		});
		return el;	
	}
	//3.click : 单击对象
	public void click(Locator locator){
		WebElement el = findElement(locator);
		el.click();
		log.info("点击元素："+locator.getElementName());
	}
	//4.sendkeys:在对象上模拟按键输入
	public void sendkeys(Locator locator,String str){
		WebElement el = findElement(locator);
		el.sendKeys(str);
		log.info(" 在元素："+locator.getElementName()+" 输入"+str);
	}
	//5.getText():获取对象文本
	public String getText(Locator locator){
		WebElement el = findElement(locator);
		log.info("获取元素："+locator.getElementName()+"文本值");
		return el.getText();
	}
	//6.get_attribute("属性名"):获取对象的属性值
	public void get_attribute(Locator locator,String attribute){
		WebElement el = findElement(locator);
		el.getAttribute(attribute);
	}
	//7.isDisplayed(): 用来判断对象是否可见，即css的display属性是否为none
	public void isDisplayed(Locator locator){
		WebElement el = findElement(locator);
		el.isDisplayed();
	}
	//8.判断对象是否被禁用
	public void isEnabled(Locator locator){
		WebElement el = findElement(locator);
		el.isEnabled();
	}
	//9.isSelected():判断对象是否被选中
	public void isSelected(Locator locator){
		WebElement el = findElement(locator);
		el.isSelected();
	}
	public Locator getLocator(String LocatorName){
		Locator locator = locatorMap.get(LocatorName);
		return locator;
	}
}
