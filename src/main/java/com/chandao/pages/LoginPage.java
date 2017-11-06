package com.chandao.pages;

import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chandao.baseframework.BasePage;
import com.chandao.baseframework.Locator;
import com.chandao.baseframework.WebElementUntils;
import com.chandao.config.Localconfig;
import com.chandao.utils.xmlUtils;
import com.first.demo.Readxml;

public class LoginPage  extends BasePage{
			
	Locator usernameInputbox = getLocator("usernameInputbox");
	Locator passwordInputbox = getLocator("passwordInputbox");
	Locator loginButton = getLocator("loginButton");
	//构造函数
	public LoginPage(WebDriver dr) {
		super(dr);
		openWeb(Localconfig.url);
		
	}
	public void inputUserName(String name){
		sendkeys(usernameInputbox, name);
	}
	public void inputPassWord(String password){
		sendkeys(passwordInputbox, password);
	}
	public void clickLoginButton(){
		click(loginButton);
	}
	public WebDriver getDriver() {
		return driver;
	}
}
