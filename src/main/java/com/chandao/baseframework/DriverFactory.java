package com.chandao.baseframework;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.chandao.config.Localconfig;
import com.chandao.utils.Log;

public class DriverFactory {
		private static  WebDriver driver;
	    static Runtime runtime =Runtime.getRuntime();
	    private static Log log = new Log(DriverFactory.class);
		//封装Chrome启动驱动	
		public static WebDriver getChromeDriver(){	
		//1.如果打开了多个chrome页面，先关闭之前可能出错的浏览器
		try {		
			runtime.exec("taskkill /F /IM chrome.exe");
			log.info("杀死Chrome浏览器进程成功");
		} catch (IOException e) {
			log.info("杀进程出现异常");
			e.printStackTrace();
		}
			//2.读取去掉所在路径
			String driverPath =System.getProperty("user.dir")+Localconfig.CHROMEDRIVER;
			System.setProperty("webdriver.chrome.driver",driverPath);
			  //3.去掉启动时候的黄色提示框
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
			options.addArguments("--test-type", "--start-maximized");
			driver= new ChromeDriver(options);
			return driver; 
		}
		
}
