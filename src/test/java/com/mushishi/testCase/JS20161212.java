package com.mushishi.testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS20161212 {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://coding.imooc.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("scrollTo(0,10000)");
//        Thread.sleep(2000);
//        js.executeScript("scrollBy(0, 0-document.body.scrollHeight *99/100)");
//        Thread.sleep(2000);
//        js.executeScript("scrollTo(0,100000)");
//        Thread.sleep(2000);
//        js.executeScript("scrollTo(0,1)");
//        Thread.sleep(2000);
//        js.executeScript("scrollTo(0,1000)");
//        Thread.sleep(2000);
        js.executeScript("scrollBy(0, 0-document.body.scrollHeight *1/2)");
//        Thread.sleep(2000);
//        js.executeScript("scrollBy(0, 0-document.body.scrollWidht *1/2)");


//      ((JavascriptExecutor)driver).executeScript("scrollTo(0,10000)");----------------向下拉到底
//      Thread.sleep(2000);
//      ((JavascriptExecutor)driver).executeScript("scrollTo(0,1)");--------------------向上拉到顶
//      Thread.sleep(2000);
//      ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=10000");  将页面滚动条拖到底部
//      Thread.sleep(2000);
//      ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=0");  将页面滚动条拖到顶部
//      Thread.sleep(2000);
    }
}