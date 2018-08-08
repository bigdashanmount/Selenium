package com.mushishi.selenium;

import com.mushishi.utils.ProUtil;
import com.mushishi.utils.TestngListenerScreenShot;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 读取配置文件
 * */
@Listeners({TestngListenerScreenShot.class})
public class LoginTakeScreenshot2 extends baseDriver{

    public void loginScript(String username,String userpassword ) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
        Thread.sleep(2000);
  ;      driver.get("https://www.imooc.com");
         driver.manage().window().maximize();
        this.element(this.byStr("zero")).click();
        Thread.sleep(2000);
           //输入邮箱或者手机号
           WebElement user = this.element(this.byStr("one"));
           user.isDisplayed();
           //输入密码
           WebElement password = this.element(this.byStr("two"));
           password.isDisplayed();
        //登录按钮
           WebElement loginButton = this.element(this.byStr("three"));
           loginButton.isDisplayed();
           user.sendKeys(username);
           password.sendKeys(userpassword);
           loginButton.click();
           Thread.sleep(2000);
           //鼠标悬浮在个人信息
           WebElement header = this.element(this.byStr("four"));
           header.isDisplayed();
        Thread.sleep(1000);
           Actions actions = new Actions(driver);
           actions.moveToElement(header).perform();
           String userInfo = this.element(this.byStr("five")).getText();
           System.out.println(userInfo);
           if(userInfo.equals("qq_big大山mount_03375711")){
             //  this.takeScreenShot();
               System.out.println("登录成功loginhashMap");

           }else {
               System.out.println("登录失败loginHashMap!");
           }
           driver.close();
    }
    /***
     * by封装定位方法
     */
    public By byStr(String elementkey ) throws Exception{
        ProUtil properties = new ProUtil("element.properties");
        //username 包含定位方式是by.name  定位数值是
        String localtor = properties.getPro(elementkey);
        String localtorType = localtor.split(">")[0];
        String localtorValue = localtor.split(">")[1];
        //用localtorType替换by.其实就是进一步抽取/
        if (localtorType.equals("id")){
            return By.id(localtorValue);
        }else  if (localtorType.equals("name")){
            return By.name(localtorValue);
        }else if (localtorType.equals("classname")){
            return  By.className(localtorValue);
        }else {
            return  By.xpath(localtorValue);
        }

     }
     /**
      * 封装driver.findElement()
      *
      * */
     public WebElement element(By by){

         WebElement ele = driver.findElement(by);
         return ele;
     }
    @Test
    public void loginpage() throws Exception {

       this.loginScript("888888888@qq.com","11111111");


    }
}
