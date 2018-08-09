package com.mushishi.base_control_page;


import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.GetByLocator;
import org.openqa.selenium.WebElement;

public class SureOrderPage extends BasePage{

	public SureOrderPage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 获取提交订单按钮
	 * */
	public WebElement getSubOrderElement() throws Exception {
		return element(GetByLocator.GetLocator("sureOrder"));
	}

}
