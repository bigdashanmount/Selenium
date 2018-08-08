package com.mushishi.testCase;

import com.mushishi.base_control_page.LoginPagePro;
import com.mushishi.base_serve_driver.DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginBuy extends CaseBase{
    public DriverBase driver;
    public LoginPagePro loginPagePro;
    //使用log4j日志,把当前类名称传入进去
    static Logger logger = Logger.getLogger(LoginBuy.class);
    public LoginBuy(){
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
    /**
     * 获取课程信息
     * */
    public String  getCourseText(WebElement element ){
    return   element.getText();
    }
    /**
     * 下单流程
     * */
    @Test(dependsOnMethods = {"testLogin"})
    public void buyCourse() throws InterruptedException {
        Thread.sleep(4000);
        driver.get("https://coding.imooc.com/class/105.html");
        Thread.sleep(2000);
       //层级定位在class类下面的span
         String  courseDetil =  driver.findElement(By.className("path")).findElement(By.tagName("span")).getText();
       // String  courseDetil = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/span")).getText();
        //立即购买id:buy-trigger
        driver.findElement(By.id("buy-trigger")).click();
        Thread.sleep(2000);
        //提交订单
        driver.findElement(By.linkText("提交订单")).click();
        Thread.sleep(3000);
        String orderText = driver.findElement(By.className("order")).getText();

        Thread.sleep(2000);
        if(orderText !=null){
           //支付中心商品文字名称
          String orderString =driver.findElement(By.className("item")).findElement(By.className("left")).findElement(By.tagName("dt")).getText();

        Assert.assertEquals(courseDetil,orderString,"购买的商品信息不一样！！！！");
        }
    }

}
