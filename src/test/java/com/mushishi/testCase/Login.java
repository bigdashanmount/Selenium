package com.mushishi.testCase;

import com.mushishi.base_control_page.LoginPagePro;
import com.mushishi.base_serve_driver.DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class Login extends CaseBase{
    public DriverBase driver;
    public LoginPagePro loginPagePro;
    //使用log4j日志,把当前类名称传入进去
    static Logger logger = Logger.getLogger(Login.class);
    public  Login(){
       this.driver = InitDriver("chrome");
       loginPagePro= new LoginPagePro(driver);

    }
    @Test
    public void getLoginHome() throws Exception {
        Thread.sleep(1000);
        driver.get("http://www.imooc.com");
        //调用封装的最大化方法
        driver.manage();
        Thread.sleep(2000);
        driver.findElement(By.id("js-signin-btn")).click();
        Thread.sleep(5000);
    }
    @Test(dependsOnMethods = {"getLoginHome"})
    public void testLogin()throws Exception{
        logger.debug("log4j第一次使用！！！！！！！！！！！！！！！！！！！！");
        loginPagePro.login("850512700@qq.com","shan6500333jing");
    }

}
