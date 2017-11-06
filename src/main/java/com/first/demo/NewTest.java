package com.first.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chandao.utils.AccertUtils;

import junit.framework.Assert;

public class NewTest {
	@BeforeMethod
	public void init(){
		try{int[]a={1,2,3,4,5};
		int b =a[8];//1.初始化异常
		}catch(Exception e){
			System.out.println("初始化错误，不执行后面的程序");
		}
	}
  @Test
  public void f() {
		try{int[]a={1,2,3,4,5};
		int b =a[8];//2.执行业务代码中错误
		}catch(Exception e){
			System.out.println("执行业务代码中错误");
		}
  }
  @AfterMethod
  public void f2(){
	  int a=1,b=3;
	  int c=a+b;
	  AccertUtils assertutils = new AccertUtils();
	  assertutils.checkIntNum(c, 43);
  }
}
