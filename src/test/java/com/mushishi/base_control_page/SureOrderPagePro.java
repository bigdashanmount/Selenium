package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;

public class SureOrderPagePro {
	public SureOrderHandle sureOrderHandle;
	public DriverBase driver;
	public SureOrderPagePro(DriverBase driver){
		this.driver = driver;
		sureOrderHandle = new SureOrderHandle(driver);
	}
	/**
	 * 确认订单按钮
	 * */
	public void sureOrder() throws Exception {
		sureOrderHandle.clickSubOrderElement();
	}
	
	
}
