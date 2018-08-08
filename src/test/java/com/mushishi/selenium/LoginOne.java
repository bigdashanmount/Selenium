package com.mushishi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.xml.bind.Element;
/***
 * 代码提前用户参数
 */


public class LoginOne {
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
        driver.findElement(By.id(loginone)).click();
        Thread.sleep(2000);
           //输入邮箱或者手机号
           WebElement user = driver.findElement(By.name(WebElementemail));
           user.isDisplayed();
           //输入密码
           WebElement password = driver.findElement(By.name(WebElementpassword));
           password.isDisplayed();
           //WebElement loginButton = driver.findElement(By.className("btn-red"));
        //登录按钮
           WebElement loginButton = driver.findElement(By.xpath(WebElementloginButton));
           loginButton.isDisplayed();
           user.sendKeys(username);
           password.sendKeys(userpassword);
           loginButton.click();
           Thread.sleep(2000);
           //鼠标悬浮在个人信息
           WebElement header = driver.findElement(By.id(header_info));
           header.isDisplayed();
        Thread.sleep(1000);
           Actions actions = new Actions(driver);
           actions.moveToElement(header).perform();
           String userInfo = driver.findElement(By.className(user_nicheng)).getText();
           System.out.println(userInfo);
    }


    public static void main(String[] args) throws Exception {
        LoginOne loginOne = new LoginOne();
        loginOne.InitDriver();
        loginOne.loginScript();



    }

}
