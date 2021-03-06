package com.mushishi.base_serve_driver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/**
 * 先建立driver驱动，然后去调用浏览器驱动
 *
 * */
public class DriverBase {

    public WebDriver driver;
    //重新构造方法；
    public DriverBase(String browser){
        SelectDriver selecdriver = new SelectDriver();
       // selecdriver.driverName(browser);
        this.driver = selecdriver.driverName(browser);
    }
    public void quit(){
        System.out.println("关闭driver!");
        driver.quit();
    }
    public  void   manage(){
        driver.manage().window().maximize();
    }
    //封装element

    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    //封装get
    public void get (String url){
            driver.get(url);
    }
    //封装返回按钮
    public  void back(){
        driver.navigate().back();
    }

    public void js(int n){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollTo(0,10000)");
        js.executeScript("scrollBy(0, 0-document.body.scrollHeight *1/n)");
    }
    /**
     * 点击
     * */
    public void click(WebElement element){
        element.click();
    }

    /**
     * 切换windows窗口
     * */
    public void switchWindows(String name){
        driver.switchTo().window(name);
    }

    /**
     * 切换alert窗口
     * */
    public void switchAlert(){
        driver.switchTo().alert();
    }
    /**
     * 模态框切换
     * */
    public void switchToMode(){
        driver.switchTo().activeElement();
    }
    /**
     * actionMoveElement
     * */
    public void action(WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
    }
    /**
     * 获取cookcie
     * @return
     * */
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

    /**
     * 删除cookie
     * */
    public void deleteCookie(){
        driver.manage().deleteAllCookies();
    }
    /**
     * 设置cookie
     * */
    public void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

}

