package com.mushishi.testCase;

import com.mushishi.base_control_page.HomePagePro;
import com.mushishi.base_control_page.LoginPagePro;
import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SuiteTestLogin extends CaseBase{
	public DriverBase driver;
	public LoginPagePro loginpro;
	public HomePagePro homepagepro;
	public ProUtil pro;
//	public HandleCookie handcookie;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		this.driver = InitDriver("chrome");
		pro = new ProUtil("loginTest.properties");
		//driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage();
		loginpro = new LoginPagePro(driver);
		//handcookie = new HandleCookie(driver);
		homepagepro = new HomePagePro(driver);
		driver.get(pro.getPro("url"));
	}
	@Test
	public void testLogin() throws Exception {
		String username = pro.getPro("username");
		String password = pro.getPro("passwd");
		loginpro.login(username, password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(homepagepro.AssertLogin(pro.getPro("yq"))){
			System.out.println("登陆成功: "+username);
			//handcookie.writeCookie();
		}else {
			System.out.println("登录失败！");
		}
	}
	@AfterClass
	public void afterClass(){
		//driver.quit();
	}
}
