package com.mushishi.base_serve_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 设置浏览器类型， 浏览器驱动
 *
 * */
public class SelectDriver {
    public WebDriver driverName(String browser){
        if(browser.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");

            return  new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");

            return  new ChromeDriver();

        }
    }

}
