package com.chandao.baseframework;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardUntils {
	private Actions action;
	public KeyBoardUntils(WebDriver dr){
		this.action = new Actions(dr);
	}
	//ctrl+c;ctrl+V;
	public void Ctrl(String word){
		action.keyDown(Keys.CONTROL).sendKeys(word).keyUp(Keys.CONTROL).perform();
	}
	//向下的按键几次
	public void pressDown(int times){
		Robot robot;
		try {
			robot = new Robot();
		for (int i = 0; i < times; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			
				Thread.sleep(1000);
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

