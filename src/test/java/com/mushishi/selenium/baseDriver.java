package com.mushishi.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class baseDriver {

    WebDriver driver;
    public baseDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
     //   driver.get("https://www.imooc.com");
      //  driver.manage().window().maximize();
    }
    /**
     * z增加截图方法
     * */
    public void takeScreenShot(){
        //用系统时间戳作为截图的文件名
        long date = System.currentTimeMillis();
        String  path = String.valueOf(date);
        path = path+".png";
        String curpath = System.getProperty("user.dir");
        System.out.println(curpath);

        String screenPath = curpath+"/"+path;
        File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screen,new File(screenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
