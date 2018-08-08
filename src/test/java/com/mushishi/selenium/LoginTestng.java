package com.mushishi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginTestng {
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
        //首页右上角登录按钮
        driver.findElement(By.id("js-signin-btn")).click();
        Thread.sleep(2000);
           //输入邮箱或者手机号
           WebElement user = driver.findElement(By.name("email"));
           user.isDisplayed();
           //输入密码
           WebElement password = driver.findElement(By.name("password"));
           password.isDisplayed();
           //WebElement loginButton = driver.findElement(By.className("btn-red"));
        //登录按钮
           WebElement loginButton = driver.findElement(By.xpath("//*[@id=\'signup-form\']/div[5]/input"));
           loginButton.isDisplayed();
           user.sendKeys("850512700@qq.com");
           password.sendKeys("shan6500333jing");
           loginButton.click();
           Thread.sleep(3000);
           WebElement header = driver.findElement(By.id("header-avator"));
           header.isDisplayed();
        Thread.sleep(1000);
           Actions actions = new Actions(driver);
           actions.moveToElement(header).perform();
           String userInfo = driver.findElement(By.className("name")).getText();
           System.out.println(userInfo);


    }
    public static void main(String[] args) throws Exception {
        LoginTestng login = new LoginTestng();
        login.InitDriver();
        login.loginScript();



    }

}
