package com.mushishi.testCase;

import com.mushishi.base_control_page.CoursePagePro;
import com.mushishi.base_control_page.LoginPagePro;
import com.mushishi.base_control_page.OrderPayPagePro;
import com.mushishi.base_control_page.SureOrderPagePro;
import com.mushishi.base_serve_driver.DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginBuyCar extends CaseBase{
    public DriverBase driver;
    public LoginPagePro loginPagePro;
    public CoursePagePro coursePagePro;
    public SureOrderPagePro sureOrderPagePro;
    public OrderPayPagePro orderPayPagePro;
    //使用log4j日志,把当前类名称传入进去
    static Logger logger = Logger.getLogger(LoginBuyCar.class);
    public LoginBuyCar(){
       this.driver = InitDriver("chrome");
       loginPagePro= new LoginPagePro(driver);
       coursePagePro = new CoursePagePro(driver);
       sureOrderPagePro = new SureOrderPagePro(driver);
        orderPayPagePro = new OrderPayPagePro(driver);
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
    @Parameters({"username","password"})
    public void testLogin(String username,String password)throws Exception{
        logger.debug("log4j第一次使用！！！！！！！！！！！！！！！！！！！！");
       // loginPagePro.login("850512700@qq.com","shan6500333jing");
       //通过test NG参数化
        loginPagePro.login(username,password);
        Thread.sleep(2000);
        driver.get("https://coding.imooc.com/class/247.html");
        //页面添砖太快，元素架子啊不出来！！
        Thread.sleep(3000);

    }
    /**
     * 添加购物车和立即购买
     *
     * */
    @Test(dependsOnMethods = {"testLogin"})
    public void TestAddCart() throws Exception {
        //添加购物车
        //coursePagePro.addCart();
        //产品详情页面的立即购买
        coursePagePro.buyNow();

    }
    //提交订单
    @Test(dependsOnMethods = {"TestAddCart"})
    public  void TestSureOrder() throws Exception {
        sureOrderPagePro.sureOrder();
        Thread.sleep(5000);
    }
    //跳转 支付页面
    @Test(dependsOnMethods = {"TestSureOrder"})
      public  void TestGoPay() throws Exception {
           orderPayPagePro.orderPayPro();
        }

}
