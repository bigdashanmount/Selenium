package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;

public class SureOrderHandle {
	public SureOrderPage sureorderpage;
	public DriverBase driver;
	public SureOrderHandle(DriverBase driver){
		this.driver = driver;
		sureorderpage = new SureOrderPage(driver);
	}
	/**
	 * 点击确认订单按钮
	 * */
	public void clickSubOrderElement() throws Exception {
		sureorderpage.click(sureorderpage.getSubOrderElement());
	}
}
