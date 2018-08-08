package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;

public class LoginPageHandle {
    public DriverBase driver;
    public LoginPage lp;
    public LoginPageHandle(DriverBase driver){
        this.driver = driver;
        lp = new LoginPage(driver);
    }
    /**
     * 输入emali或者手机账号
     * */
    public void  sendKeysUser(String username) throws Exception {
        lp.sendKeys(lp.getUserElement(),username);
    }
    /**
     * 输入密码
     * */
    public void  sendKeysPsaaword(String password) throws Exception {
        lp.sendKeys(lp.getPasswordElement(),password);
    }
    /**
     * 点击登录
     * */
    public void  clickLoginButton() throws Exception {
        lp.click(lp.getLoginButtonElement());
    }
    /**
     * 点击7天登录自动登录
     * */
    public void  clickAutoSignin() throws Exception {
        lp.click(lp.getAutoSigninElement());
    }
    /**
     * 判断是否是登录界面
     * */
    public boolean assertLoginPage()throws Exception{
        return lp.assertElementIs(lp.getUserElement());
    }
}
