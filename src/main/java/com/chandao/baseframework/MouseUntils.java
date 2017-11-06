package com.chandao.baseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUntils{
	private Actions actions;
	public MouseUntils(WebDriver dr){
		this.actions = new Actions(dr);		
	}
	//1.contestClick():右击
	public void contextClick(WebElement e){
		actions.contextClick(e).perform();
	}
	//2.doubleClick():双击
	public void doubleClick(WebElement e){
		actions.doubleClick(e).perform();
	}
	//3.moveToElenment():鼠标移动到一个元素上
	public void moveToElement(WebElement e){
		actions.moveToElement(e).perform();;
	}
}
