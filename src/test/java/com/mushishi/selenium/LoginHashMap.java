package com.mushishi.selenium;

import com.mushishi.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 读取配置文件
 * */
public class LoginHashMap {
    //初始化driver
    public WebDriver driver;
    //初始化方法
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com");
        driver.manage().window().maximize();
    }
    public void loginScript(String username,String userpassword ) throws Exception {
        this.InitDriver();
        this.element(this.byStr("zero")).click();
        Thread.sleep(3000);
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
    public static void main(String[] args) throws Exception {
        LoginHashMap loginProp = new LoginHashMap();

        loginProp.loginScript("850512700@qq.com","shan6500333jing");



    /**
     * 运用hashMap做账号密码的参数化
     *
     * * */

    HashMap<String ,String > user = new HashMap<String , String>();
    user.put("850512700@qq.com","shan6500333jing") ;
    user.put("13582905701","shan6500333jing");
    Iterator us = user.entrySet().iterator();
    while (us.hasNext()){
        Map.Entry entry = (Map.Entry) us.next();
        String username = entry.getKey().toString();
        String password = entry.getValue().toString();
        System.out.println(username+"密码：  "+password);
        //将登录放到循环中，可以参数化登录
        loginProp.loginScript(username,password);
    }


    }
}
