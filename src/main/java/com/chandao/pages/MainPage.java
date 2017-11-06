package com.chandao.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chandao.baseframework.BasePage;
import com.chandao.baseframework.Locator;
import com.chandao.baseframework.WebElementUntils;

public class MainPage extends BasePage{
	
	
	public MainPage(WebDriver dr){
		super(dr);
	}
	
	Locator userMenu = getLocator("userMenu");
	public String getLoginUserName(){	
		wait(3);
		return getText(userMenu);
	}
}
