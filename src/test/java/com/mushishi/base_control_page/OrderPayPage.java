package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.GetByLocator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class OrderPayPage extends BasePage{
	public OrderPayPage(DriverBase driver){
		super(driver);
	}
	
	/**
	 * 获取订单号element
	 * */
	@Test
	public WebElement getOrderNumElement() throws Exception {
		return element(GetByLocator.GetLocator("order"));
	}
	/**
	 * 返回课程名称element
	 * */
	public WebElement getOrderCourseNameElement() throws Exception {
		return nodeElement(GetByLocator.GetLocator("orderCourse"),GetByLocator.GetLocator("orderCourseNode"));
	}
	/**
	 * 返回支付宝element
	 * */
	public WebElement getAlipayElement() throws Exception {
		return element(GetByLocator.GetLocator("alipay"));
	}
	/**
	 * 获取点击立即支付element
	 * */
	public WebElement getOederPayElement() throws Exception {
		return element(GetByLocator.GetLocator("orderpay"));
	}
}
