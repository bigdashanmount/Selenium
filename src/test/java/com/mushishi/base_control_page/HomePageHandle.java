package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;

public class HomePageHandle {
	public DriverBase driver;
	public HomePage hp;
	public HomePageHandle(DriverBase driver){
		this.driver = driver;
		hp = new HomePage(driver);
	}
	/**
	 * 点击登陆按钮
	 * */
	public void clickLogin() throws Exception {
		hp.click(hp.getLoginElement());
	}
	
	/**
	 * 点击实战按钮
	 * */
	public void clickCoding() throws Exception {
		hp.click(hp.getCodingElement());
	}
	/**
	 * 获取用户名
	 * */
	public String getUserName() throws Exception {
		String username = hp.getText(hp.getUserNameElement());
		return username;
	}

	
}
