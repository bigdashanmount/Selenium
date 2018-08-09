package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;

public class OrderPayPageHandle {
	public DriverBase driver;
	public OrderPayPage orderpaypage;
	public OrderPayPageHandle(DriverBase driver){
		this.driver = driver;
		orderpaypage = new OrderPayPage(driver);
	}
	/**
	 * 获取订单文字
	 * */
	public String getOrderName() throws Exception {
		return orderpaypage.getText(orderpaypage.getOrderNumElement());
	}
	/**
	 * 获取课程名称
	 * */
	public String getOrderCourseName() throws Exception {
		return orderpaypage.getText(orderpaypage.getOrderCourseNameElement());
	}
	/**
	 * 点击支付宝支付
	 * */
	public void clickAliPay() throws Exception {
		orderpaypage.click(orderpaypage.getAlipayElement());
	}
	/**
	 * 点击立即支付
	 * */
	public void clickPayElement() throws Exception {
		orderpaypage.click(orderpaypage.getOederPayElement());
	}
}
