package com.mushishi.testCase;

import com.mushishi.base_control_page.CoursePagePro;
import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.HandleCookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SuiteTestBuy extends CaseBase{
	public DriverBase driver;
	public CoursePagePro cpp;
	public HandleCookie handleCookie;
	@BeforeClass
	public void beforeClass() throws Exception {
		this.driver = InitDriver("chrome");
		cpp = new CoursePagePro(driver);
		handleCookie = new HandleCookie(driver);
		//打开一个网页
		driver.get("http://coding.imooc.com/class/101.html");
		Thread.sleep(3000);
		//添加cookie到网页setCookie = driver.manage().addCookie(cookie);
		handleCookie.setCookie();
		Thread.sleep(2000);
		//设置后需要重新加载生效
		driver.get("http://coding.imooc.com/class/101.html");
		driver.manage();
		//需要时间等待设置
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass(){
		//driver.quit();
	}
	@Test
	public void testBuy() throws Exception {
		cpp.buyNow();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
