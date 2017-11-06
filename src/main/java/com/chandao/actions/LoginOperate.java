package com.chandao.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.chandao.pages.LoginPage;
import com.chandao.pages.MainPage;



public class LoginOperate {
	private static WebDriver driver;
	private static Alert alert;
	public static WebDriver getDriver(){
		return driver;
		
	}
	public static void setDriver(WebDriver driver){
		LoginOperate.driver = driver;
	}
	static LoginPage loginPage ;
	static MainPage mainPage;
		public static MainPage LoginSuess(String username,String password){
			loginPage = new LoginPage(getDriver());
			loginPage.inputUserName(username);
			loginPage.inputPassWord(password);
			loginPage.clickLoginButton();
			return new MainPage(getDriver());
		}
		public static String getLoginName(String username,String password){
			mainPage = LoginSuess(username, password);
			return mainPage.getLoginUserName();
		}
		public static String LoginFail(String username,String password) throws InterruptedException{
			loginPage = new LoginPage(getDriver());
			loginPage.inputUserName(username);
			loginPage.inputPassWord(password);
			loginPage.clickLoginButton();
			alert = driver.switchTo().alert();
			String value = alert.getText();
			alert.accept();
			return value;
			
		}
} 
