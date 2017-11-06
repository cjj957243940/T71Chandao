package com.chandao.baseframework;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.chandao.config.Localconfig;
import com.chandao.utils.Log;

public class DriverUntils {
	 protected WebDriver driver = null;
	protected static MouseUntils mouse;
	
	protected static Log log = new Log(DriverUntils.class);
	//构造函数
	public DriverUntils(WebDriver dr ){
		this.driver = dr;
	}
	
	
	//1.打开网站
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址："+url);
	}
	//2.浏览器最大化
	public void maxWeb(){
		driver.manage().window().maximize();
	}
	//3.刷新
	public void refresh(){
		driver.navigate().refresh();
	}
	//4.返回上一页
	public void back(){
		driver.navigate().back();
		log.info("返回上一页");
	}
	//5.前进下一页
	public void forward(){
		driver.navigate().forward();
		log.info("前进下一页");
	}
	//6.获取当前URL
	public String getUrl(){
		return driver.getCurrentUrl();
	}
	//7.关闭tab页面
	public void closeWeb(){
		driver.close();
		log.info("关闭tab页面");
	}
	//8.退出当前driver
	public void quitWeb(){
		driver.quit();
		log.info("退出当前driver");
	}
	//9.获取当前页的标题
	public void webTitle(){
		driver.getTitle();
		log.info("获取当前页的标题");
	}
	//10.等待时间
	public void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//截图
    public void takeScreenShot(String... pngName) {
    	String fileName ;
    	String filePath = Localconfig.SCREENSHORTPATH;
    	File file = new File(filePath);
    	if(!file.exists()) {
    	    file.mkdir();
    	}
        if (pngName.length == 0) {
        	fileName = "shotImage";
        } else {
        	fileName = pngName[0];
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path =  "\\"+ filePath +"\\" + fileName + "_" + dateStr + ".png";
        takeScreenShot(driver, path);    	
    }
    
    public void takeScreenShot(WebDriver drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
        File picFile = new File(currentPath + path);
        try {
           log.info ("失败截图保存的路径为:" + currentPath + path);
            FileUtils.copyFile(scrFile, picFile);
           log.info ("截图成功！！！");
        } catch (Exception e) {
           log.error("截图失败！！！");
        } 
        log.screenShotLog("截图：" + scrFile, picFile);
    }
}
