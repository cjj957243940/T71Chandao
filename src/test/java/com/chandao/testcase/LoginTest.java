package com.chandao.testcase;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chandao.actions.LoginOperate;
import com.chandao.baseframework.DriverFactory;
import com.chandao.pages.LoginPage;
import com.chandao.pages.MainPage;
import com.chandao.utils.AccertUtils;
import com.chandao.utils.ExeclUtils;
import com.chandao.utils.TestCase;

public class LoginTest {
	 WebDriver driver;
	AccertUtils assertutils;
	@BeforeTest
	
	public void setUp(){
		try {
			assertutils = new AccertUtils();
			driver =DriverFactory.getChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("出现异常，不执行后面的代码");
		}
	
	}
  @Test
  public void loginTest() throws InterruptedException, DocumentException{
	  List<TestCase>testcases = ExeclUtils.getUITestData("UITestData.xlsx");
	  HashMap<String, String> testdata = (HashMap<String, String>) testcases.get(0).getTestdata();
	  LoginOperate.setDriver(driver);
	  Thread.sleep(3000);
	  String value =LoginOperate.getLoginName(testdata.get("username"),testdata.get("password"));
	  Assert.assertEquals(value.contains("admin"), true);
	  //assertutils.checkStringContains(value, testdata.get("expecteResult"),"测试失败"); 
  }
  @Test
  public void filelogin01() throws InterruptedException, DocumentException{
	  List<TestCase>testcases = ExeclUtils.getUITestData("UITestData.xlsx");
	  HashMap<String, String> testdata = (HashMap<String, String>) testcases.get(1).getTestdata();
	  LoginOperate.setDriver(driver);
	  String value = LoginOperate.LoginFail(testdata.get("username"), testdata.get("password"));
	 // Assert.assertEquals(value.contains("登录失败，请检查您的用户名或密码是否填写正确。"), true);
	  assertutils.checkStringContains(value, "登录失败，请检查您的用户名或密码是否填写正确。","测试失败");
  }
  @AfterTest
  public void tearDown() throws InterruptedException{	
		Thread.sleep(3000);
	    driver.quit();
  }
}
