package com.chandao.utils;

import org.testng.Assert;

public class AccertUtils {
	
	//1.比较整数
	public void checkIntNum(int actual,int expected,String...com){
		Assert.assertEquals(actual, expected);
	}
	//2.比较字符串
	public void checkString(String actual,String expected,String...com){
		Assert.assertEquals(expected, actual);
	}
	//3.字符串包含 实际结果里面包含我们要的预期结果，就表示为true
	public void checkStringContains(String actual,String expected,String...com){
		Assert.assertEquals(true,actual.contains(expected));
	}
	//4.非空
	public void checkNotNull(Object actual,String...com){
		Assert.assertNull(actual);
	}
}
