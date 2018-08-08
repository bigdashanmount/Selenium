package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;

public class LoginPagePro {
    public LoginPageHandle lph;
    public LoginPagePro(DriverBase driver){
        lph = new LoginPageHandle(driver);

    }
    public void login (String username,String password) throws Exception {
        if(lph.assertLoginPage()){
        lph.sendKeysUser(username);
        lph.sendKeysPsaaword(password);
        lph.clickAutoSignin();
        lph.clickLoginButton();
        }else {
            System.out.println("页面不存在！");
        }
    }
}
