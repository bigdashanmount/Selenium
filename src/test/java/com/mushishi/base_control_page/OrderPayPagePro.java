package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;

public class OrderPayPagePro {
	public DriverBase driver;
	public OrderPayPageHandle orderPayPageHandle;
	public OrderPayPagePro(DriverBase driver){
		this.driver = driver;
		orderPayPageHandle = new OrderPayPageHandle(driver);
	}
	/**
	 * 根据课程、订单判断跳转到支付页面
	 * */
	public void orderPayPro() throws Exception {
		String orderName = orderPayPageHandle.getOrderName();
		String courseName = orderPayPageHandle.getOrderCourseName();
		if(orderName !=null && courseName !=null){
			orderPayPageHandle.clickAliPay();
			orderPayPageHandle.clickPayElement();
		}
	}
}
