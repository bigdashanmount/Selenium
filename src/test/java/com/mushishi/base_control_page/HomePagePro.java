package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;

public class HomePagePro {
	public HomePageHandle hph;
	public HomePagePro(DriverBase driver){
		hph =new HomePageHandle(driver);
	}
	/**
	 * 点击登陆按钮
	 * */
	public void clickLoginButton() throws Exception {
		try {
			hph.clickLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 点击实战按钮
	 * */
	public void clickCodingLink() throws Exception {
		hph.clickCoding();
	}
	/**
	 * 根据用户名判断登陆信息是否正确
	 * */
	public Boolean AssertLogin(String username) throws Exception {
		if(hph.getUserName().equals(username)){
			return true;
		}
		return false;
	}
}
