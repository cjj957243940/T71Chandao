package com.chandao.baseframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUntils {
		public BasePage(WebDriver driver){
			super(driver);
		}
		
		//1.获取网站源代码
		public String getPageSource(){
			return driver.getPageSource();
		}
		//2.js提示框：确认
		public void alertsAccept(){
			Alert alert = driver.switchTo().alert();
			alert.accept();;
		}
		//3.js提示框：取消{
		public void disMiss(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
}
		//4.js提示框：输入数据
		public void alertsDissmiss(String value){
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
		}
		//5.获取提示信息
		public void alertGettext(){
			Alert alert = driver.switchTo().alert();
			alert.getText();
		}
}
