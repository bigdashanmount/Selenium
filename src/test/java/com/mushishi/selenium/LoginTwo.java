package com.mushishi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 封装byd定位方法
 *
 * */
public class LoginTwo {
    //初始化driver
    public WebDriver driver;
    //初始化方法
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
        //最大化窗口
       // ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--start-maximized");
       // driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com");
        driver.manage().window().maximize();


    }
    public void loginScript() throws Exception {
        //提取定位方法，将定位方式封装成方法，将定位方法名称写成key value提供给方法调用，方法传入，定位方式和定位值。
        String zero = "id";
        String one = "name";
        String two = "name";
        String three ="xpath";
        String four = "id";
        String five = "classname";



        //提取用户参数=======================================================
        String username = "850512700@qq.com";
        String userpassword = "shan6500333jing";
        //首页右上角登录按钮
        String loginone ="js-signin-btn";
        String WebElementemail = "email";
        String WebElementpassword = "password";
        String WebElementloginButton = "//*[@id=\'signup-form\']/div[5]/input";
        //个人信息
        String header_info = "header-avator";
        //用户昵称
        String user_nicheng = "name";

        //首页右上角登录按钮
      //  driver.findElement(By.id(loginone)).click();

        driver.findElement(this.byStr(zero,loginone)).click();
        Thread.sleep(3000);
           //输入邮箱或者手机号
          //WebElement user = driver.findElement(By.name(WebElementemail));
          WebElement user = driver.findElement(this.byStr(one,WebElementemail));
           user.isDisplayed();
           //输入密码
           WebElement password = driver.findElement(this.byStr(two,WebElementpassword));
           password.isDisplayed();
           //WebElement loginButton = driver.findElement(By.className("btn-red"));
        //登录按钮
           WebElement loginButton = driver.findElement(this.byStr(three,WebElementloginButton));
           loginButton.isDisplayed();
           user.sendKeys(username);
           password.sendKeys(userpassword);
           loginButton.click();
           Thread.sleep(2000);
           //鼠标悬浮在个人信息
           WebElement header = driver.findElement(this.byStr(four,header_info));
           header.isDisplayed();
        Thread.sleep(1000);
           Actions actions = new Actions(driver);
           actions.moveToElement(header).perform();
           String userInfo = driver.findElement(this.byStr(five,user_nicheng)).getText();
           System.out.println(userInfo);
           if(userInfo.equals("qq_big大山mount_03375711")){
               System.out.println("登录成功logintwo!");

           }else {
               System.out.println("登录失败logintwo!");
           }
    }
    /***
     * by封装定位方法
     */
    public By byStr(String by ,String local){
        if (by.equals("id")){
            return By.id(local);
        }else  if (by.equals("name")){
            return By.name(local);
        }else if (by.equals("classname")){
            return  By.className(local);
        }else {
            return  By.xpath(local);
        }

     }
    public static void main(String[] args) throws Exception {
        LoginTwo loginTwo = new LoginTwo();
        loginTwo.InitDriver();
        loginTwo.loginScript();



    }

}
