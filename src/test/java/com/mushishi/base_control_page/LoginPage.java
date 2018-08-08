package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.GetByLocator;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(DriverBase driver) {
        super(driver);
    }
    /**
     * 获取账号名称
     * */
    public WebElement getUserElement() throws Exception {
        return  element(GetByLocator.GetLocator("one"));
    }
    /**
     * 获取用户名称
     * */
    public WebElement getPasswordElement() throws Exception {
        return  element(GetByLocator.GetLocator("two"));
    }
    /**
     * 获取登录按钮
     * */
    public WebElement getLoginButtonElement() throws Exception {
        return  element(GetByLocator.GetLocator("three"));
    }
    /**
     * 获取7天自动登录勾选框
     * */

    public WebElement getAutoSigninElement() throws Exception {
        System.out.println("自动登录勾选");
        return  element(GetByLocator.GetLocator("zidong"));
    }
}
