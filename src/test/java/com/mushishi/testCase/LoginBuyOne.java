package com.mushishi.testCase;

import com.mushishi.base_control_page.LoginPagePro;
import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/**
 * 封装下购买流程
 *
 *
 * */

public class LoginBuyOne extends CaseBase{
    public DriverBase driver;
    public LoginPagePro loginPagePro;
    //使用log4j日志,把当前类名称传入进去
    //static Logger logger = Logger.getLogger(LoginBuyOne.class);
    public LoginBuyOne(){
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
    @Test(dependsOnMethods={"getLoginHome"})
    public void testLogin()throws Exception {
       // logger.debug("log4j第一次使用！！！！！！！！！！！！！！！！！！！！");
        loginPagePro.login("850512700@qq.com", "shan6500333jing");
    }
    /**
     * 下单流程封装版
     * 获取 element
     *
     *
     * */
        public WebElement getElement(By by)  {
            return  driver.findElement(by);
        }
      /**通过父节点获得子节点*/

        public WebElement getElement(WebElement element,By by)  {

        return element.findElement(by);
        }
    /**
     * 获取课程信息
     * */
    public String  getCourseText(WebElement element ) throws InterruptedException {
        Thread.sleep(1000);
        return   element.getText();
    }
    /**
     * 立即购买然后返回课程信息
     * */
    public String bugCourseNow()throws Exception{

        /**
    //父节点
       WebElement element = this.getElement(GetByLocator.GetLocator("courseInfo"));


        //根据父节点查找子节点
        Thread.sleep(2000);
        WebElement elementNode =this.getElement(element,GetByLocator.GetLocator("courseInfoText"));
        String currentText = this.getCourseText(elementNode);
         */
        //通过xpath定位
         WebElement element = this.getElement(GetByLocator.GetLocator("courseInfoxpath"));
        String currentText = this.getCourseText(element);

        //点击立即购买
        driver.click(this.getElement(GetByLocator.GetLocator("buyNow")));

        return currentText;
    }
    /**
     * 点击确认订单
     * */
    public void sureOrder() throws Exception {
        this.getElement(GetByLocator.GetLocator("sureOrderxpath")).click();
    }
    /**
     * 获取订单号text
     * */
    public String getOrder()throws Exception{
        //支付中心“订单”两个字
        WebElement a= this.getElement(GetByLocator.GetLocator("orderxpath"));
        String orderText =a.getText();
       // String orderText = this.getCourseText(a);
        return orderText;

    }
   /**
           * 获取支付中心商品信息
	 * */
    public String getOrderCourse()throws Exception {
        //WebElement element = this.getElement(GetByLocator.GetLocator("orderCourse"));

       // WebElement elementNode = this.getElement(element, GetByLocator.GetLocator("orderCourseNode"));
        //单独xpath定位就可以
        WebElement elementNode = this.getElement( GetByLocator.GetLocator("orderCourseNodexpath"));
        return this.getCourseText(elementNode);
    }
    //新的下单实现
   @Test(dependsOnMethods = {"testLogin"})
    public void downOrder() throws Exception {
        Thread.sleep(3000);
        driver.get("https://coding.imooc.com/class/107.html");
        Thread.sleep(2000);
        String  currentText = this.bugCourseNow();

        System.out.println(currentText);
        Thread.sleep(2000);
        this.sureOrder();
        Thread.sleep(3000);
        this.getOrder();
        String orderCourseText = this.getOrderCourse();
        System.out.println(orderCourseText);
        if (currentText.equals(orderCourseText)){
            System.out.println("下单成功！！！！！");
        }else {
            System.out.println("下单失败！");
        }

    }

}
