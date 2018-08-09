package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.GetByLocator;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	public HomePage(DriverBase driver){
		super(driver);
	}
	/**
	 * 获取点击登陆element
	 * */
	public WebElement getLoginElement() throws Exception {
		return element(GetByLocator.GetLocator("login"));
	}
	/**
	 * 获取实战element
	 * */
	public WebElement getCodingElement() throws Exception {
		return nodeElement(GetByLocator.GetLocator("tophead"),GetByLocator.GetLocator("coding"));
	}
	
	/**
	 * 获取用户名信息element
	 * */
	public WebElement getUserNameElement() throws Exception {
		//悬浮到用户头像上
		action(element(GetByLocator.GetLocator("header")));
		Thread.sleep(3000);
		//获取用户名信息
		WebElement nameInfo = element(GetByLocator.GetLocator("nameInfo"));
		Thread.sleep(3000);
		return nameInfo;
	}

	
}
